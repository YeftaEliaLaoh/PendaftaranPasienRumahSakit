package com.example.pendaftaranpasienrumahsakit.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pendaftaranpasienrumahsakit.R;
import com.example.pendaftaranpasienrumahsakit.activity.DetailActivity;
import com.example.pendaftaranpasienrumahsakit.entity.Pasien;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.myviewholder>
{
    Context context;
    ArrayList<Pasien> pasienArrayList;

    public HistoryAdapter( Context context, ArrayList<Pasien> pasienArrayList )
    {
        this.context = context;
        this.pasienArrayList = pasienArrayList;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder( @NonNull ViewGroup parent, int viewType )
    {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.layout_1, parent, false);
        return new myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder( @NonNull myviewholder holder, final int position )
    {

        final ArrayList<Pasien> item1 = this.pasienArrayList;
        TextView ltName = holder.itemView.findViewById(R.id.ltName);
        TextView ltAlamat = holder.itemView.findViewById(R.id.ltAlamat);
        TextView ltTahun = holder.itemView.findViewById(R.id.ltTahun);
        TextView ltLama = holder.itemView.findViewById(R.id.ltLama);
        TextView ltJenisKelamin = holder.itemView.findViewById(R.id.ltJenisKelamin);
        TextView ltKamar = holder.itemView.findViewById(R.id.ltKamar);

        ltName.setText(String.format("Nama : %s", item1.get(position).nama));
        ltAlamat.setText(String.format("Alamat : %s", item1.get(position).alamat));
        ltTahun.setText(String.format("Tahun : %s", item1.get(position).tahun));
        ltLama.setText(String.format("Lama : %s", item1.get(position).lama));
        ltJenisKelamin.setText(String.format("J K : %s", item1.get(position).jenisKelamin));
        ltKamar.setText(String.format("Kamar : %s", item1.get(position).kamar));

        CardView cardView = holder.itemView.findViewById(R.id.parentLayout);
        cardView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", item1.get(position).id);
                intent.putExtra("name", item1.get(position).nama);
                ContextCompat.startActivity(context, intent, null);
            }
        });


    }


    @Override
    public int getItemCount()
    {
        if( pasienArrayList != null )
        {
            return pasienArrayList.size();
        }

        return 0;
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        public myviewholder( @NonNull View itemView )
        {
            super(itemView);
        }
    }
}
