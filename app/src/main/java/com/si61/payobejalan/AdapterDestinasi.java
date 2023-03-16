package com.si61.payobejalan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDestinasi extends  RecyclerView.Adapter<AdapterDestinasi.viewHolderDestinasi>{

    private Context ctx;
    private ArrayList arrNama, arrAlamat, arrJam;

    public AdapterDestinasi(Context ctx, ArrayList arrNama, ArrayList arrAlamat, ArrayList arrJam) {
        this.ctx = ctx;
        this.arrNama = arrNama;
        this.arrAlamat = arrAlamat;
        this.arrJam = arrJam;
    }

    @NonNull
    @Override
    public viewHolderDestinasi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.list_item_destinasi, parent, false);

        return new viewHolderDestinasi(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderDestinasi holder, int position) {
        holder.tvNama.setText(arrNama.get(position).toString());
        holder.tvAlamat.setText(arrAlamat.get(position).toString());
        holder.tvJam.setText(arrJam.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return arrNama.size();
    }

    public class viewHolderDestinasi extends RecyclerView.ViewHolder{
        TextView tvNama, tvAlamat, tvJam;
        public viewHolderDestinasi(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvJam = itemView.findViewById(R.id.tv_jam);
        }
    }
}
