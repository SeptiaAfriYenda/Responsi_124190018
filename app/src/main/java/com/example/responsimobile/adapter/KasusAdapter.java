package com.example.responsimobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsimobile.R;
import com.example.responsimobile.model.ContentItemDataHarian;

import java.util.ArrayList;

//dihubungkan denganrecyclerview agar layout dan fungsinya dapat berjalan
//viewholder untuk menyimpan view yang akan digunakan
public class KasusAdapter extends RecyclerView.Adapter<KasusAdapter.viewHolder> {
    //informasi memulai intent, view, atau layout
    private ArrayList<ContentItemDataHarian> itemDataHarian = new ArrayList<>();
    private Context context;

    public KasusAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ContentItemDataHarian> items) {
        itemDataHarian.clear();
        itemDataHarian.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    //pembuatan vvieholder baru
    public KasusAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    //untuk mengambil data yg digunakan mengisi di tampilannyya
    public void onBindViewHolder(@NonNull KasusAdapter.viewHolder holder, int position) {
        holder.tv_tanggal.setText(itemDataHarian.get(position).getTanggal());
        holder.tv_sembuh.setText("Sembuh " + String.valueOf(itemDataHarian.get(position).getConfirmationSelesai()));
        holder.tv_meninggal.setText("Meninggal " + String.valueOf(itemDataHarian.get(position).getConfirmationMeninggal()));
        holder.tv_konfirmasi.setText("Terkonfirmasi " + String.valueOf(itemDataHarian.get(position).getCONFIRMATION()));

    }

    @Override
    //mendapatkan set ukuran data yang akan ditampilkan
    public int getItemCount() {

        return itemDataHarian.size();
    }
    //class holder yg terhubung ke layout item list
    public class viewHolder extends RecyclerView.ViewHolder{
        private TextView tv_tanggal,tv_sembuh,tv_meninggal, tv_konfirmasi;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tanggal = itemView.findViewById(R.id.tvtanggal);
            tv_sembuh = itemView.findViewById(R.id.tvsembuh);
            tv_meninggal = itemView.findViewById(R.id.tvmeninggal);
            tv_konfirmasi = itemView.findViewById(R.id.tvkonfirmasi);
        }
    }
}

