package com.si61.payobejalan;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDestinasi extends  RecyclerView.Adapter<AdapterDestinasi.viewHolderDestinasi>{

    private Context ctx;
    private ArrayList arrNama, arrAlamat, arrJam, arrId;


    public AdapterDestinasi(Context ctx, ArrayList arrId, ArrayList arrNama, ArrayList arrAlamat, ArrayList arrJam) {
        this.ctx = ctx;
        this.arrId = arrId;
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
        holder.tvId.setText(arrId.get(position).toString());
        holder.tvNama.setText(arrNama.get(position).toString());
        holder.tvAlamat.setText(arrAlamat.get(position).toString());
        holder.tvJam.setText(arrJam.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return arrNama.size();
    }

    public class viewHolderDestinasi extends RecyclerView.ViewHolder{
        TextView tvId, tvNama, tvAlamat, tvJam;
        public viewHolderDestinasi(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvJam = itemView.findViewById(R.id.tv_jam);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder pesan = new AlertDialog.Builder(ctx);
                    pesan.setTitle("Perhatian");
                    pesan.setMessage("Perintah Apa yang Akan Dilakukan?");
                    pesan.setCancelable(true);


                    pesan.setPositiveButton("Ubah", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    pesan.setNegativeButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MyDatabaseHelper myDB = new MyDatabaseHelper(ctx);
                            long eks = myDB.hapusData(tvId.getText().toString());
                            if(eks == -1){
                                Toast.makeText(ctx, "Gagal Hapus Data", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(ctx, "Sukses Hapus Data", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                ((MainActivity) ctx).onResume();
                            }
                        }
                    });

                    pesan.show();

                    return false;
                }
            });
        }
    }
}
