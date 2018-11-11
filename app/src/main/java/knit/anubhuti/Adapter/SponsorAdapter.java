package knit.anubhuti.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import knit.anubhuti.R;
import knit.anubhuti.model.SponsorDetail;

public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.MyHolder> {
    List<SponsorDetail>list;


    public SponsorAdapter(List<SponsorDetail>list){
        this.list= list;
    }
    @NonNull
    @Override
    public SponsorAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sponsor_list,viewGroup,false);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SponsorAdapter.MyHolder myHolder, int i) {
       SponsorDetail listdata = new SponsorDetail();

        myHolder.vname.setText(listdata.getName());
        myHolder.vemail.setText(listdata.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView vname , vaddress,vemail;

        public MyHolder(View itemView) {
            super(itemView);
            vname = (TextView) itemView.findViewById(R.id.sponsor_name);
            vemail = (TextView) itemView.findViewById(R.id.sponsor_descrption);
           // vaddress = (TextView) itemView.findViewById(R.id.sp);

        }
    }

}
