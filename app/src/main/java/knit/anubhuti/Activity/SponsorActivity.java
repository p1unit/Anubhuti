package knit.anubhuti.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import knit.anubhuti.Adapter.SponsorAdapter;
import knit.anubhuti.R;
import knit.anubhuti.model.ListData;
import knit.anubhuti.model.SponsorDetail;

public class SponsorActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase database;
    TextView sponsortext;
    Button sponsors;
    DatabaseReference reference;
      List<SponsorDetail>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);
        sponsors = (Button) findViewById(R.id.button);
        sponsortext =(TextView)findViewById(R.id.sponsors);
        recyclerView =(RecyclerView)findViewById(R.id.sponsor_recyclerview);

        database =FirebaseDatabase.getInstance();
        reference=database.getReference("SponsorDetail");
        sponsors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list = new ArrayList<>();
                        for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                            SponsorDetail listdata=new SponsorDetail();
//                            ListData listData = dataSnapshot1.getValue(ListData.class);
//                            String name = listData.getName();
                            listdata.setName(dataSnapshot1.child("description").getValue().toString());
                            String name =listdata.getName();
                            sponsortext.setText(name);

                           // String name = sponsorDetail.getName();
                            //listdata.setName(sponsorDetail);

                            //list.add(sponsorDetail);
                        }
                        LinearLayoutManager layoutManager = new LinearLayoutManager(SponsorActivity.this);
                        recyclerView.setLayoutManager(layoutManager);
                        SponsorAdapter recycler= new SponsorAdapter(list);
                        recyclerView.setAdapter(recycler);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
