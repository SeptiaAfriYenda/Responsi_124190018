package com.example.responsimobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsimobile.R;
import com.example.responsimobile.model.DataItemFaskes;

import java.util.ArrayList;

//dihubungkan denganrecyclerview agar layout dan fungsinya dapat berjalan
//viewholder untuk menyimpan view yang akan digunakan
public class RSAdapter extends RecyclerView.Adapter<RSAdapter.viewHolder> {
    //informasi memulai intent, view, atau layout
    private ArrayList<DataItemFaskes> itemFaskes = new ArrayList<>();
    private Context context;
    public RSAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataItemFaskes> items) {
        itemFaskes.clear();
        itemFaskes.addAll(items);
        notifyDataSetChanged();
    }

    public ArrayList<DataItemFaskes> getItemFaskes(){
        return itemFaskes;
    }

    public void setItemFaskes(ArrayList<DataItemFaskes> itemFaskes) {
        this.itemFaskes = itemFaskes;
    }

    @NonNull
    @Override
    //pembuatan vvieholder baru
    public RSAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //convert layout xml
        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
        View view = inflater.inflate(R.layout.item_faskes, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.tv_rs.setText(itemFaskes.get(position).getNama());
        holder.tv_alamatrs.setText(itemFaskes.get(position).getAlamat());
        holder.btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rs = itemFaskes.get(position).getNama();
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=" + rs));
                context.startActivity(intent);

            }
        });
    }


    @Override
    //mendapatkan set ukuran data yang akan ditampilkan
    public int getItemCount() {

        return itemFaskes.size();
    }
    //class holder yg terhubung ke layout item list
    public class viewHolder extends RecyclerView.ViewHolder{
        private TextView tv_rs,tv_alamatrs;
        private Button btn_maps;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv_rs = itemView.findViewById(R.id.tvrs);
            tv_alamatrs = itemView.findViewById(R.id.tvalamatrs);
            btn_maps = itemView.findViewById(R.id.btnmaps);
        }
    }
}
