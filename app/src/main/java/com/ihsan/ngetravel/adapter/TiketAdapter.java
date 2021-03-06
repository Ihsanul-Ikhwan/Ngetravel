package com.ihsan.ngetravel.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ihsan.ngetravel.R;
import com.ihsan.ngetravel.interfaces.TiketInterface;
import com.ihsan.ngetravel.model.TiketModel;

import java.util.List;

public class TiketAdapter extends RecyclerView.Adapter<TiketViewHolder> {
    private final TiketInterface tiketInterface;

    Context context;
    private List<TiketModel> tiketModels;


    public TiketAdapter(Context context, List<TiketModel> tiketModels, TiketInterface tiketInterface) {
        this.context = context;
        this.tiketModels = tiketModels;
        this.tiketInterface = tiketInterface;
    }

    @NonNull
    @Override
    public TiketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        TiketViewHolder tvh = new TiketViewHolder(view, tiketInterface);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TiketViewHolder holder, int position) {
        TiketModel tiketModel = tiketModels.get(position);
        holder.idtiket.setText(String.valueOf(tiketModel.getIdtiket()));
        holder.asal.setText(tiketModel.getAsal());
        holder.berangkat.setText(tiketModel.getBerangkat());
        holder.tujuan.setText(tiketModel.getTujuan());
        holder.sampai.setText(tiketModel.getSampai());
        holder.jam.setText(tiketModel.getJam());
        holder.harga.setText("Rp. " + tiketModel.getHarga() + ",-");
    }

    @Override
    public int getItemCount() {
        return tiketModels.size();
    }
}
class TiketViewHolder extends RecyclerView.ViewHolder{
    TextView idtiket, asal, berangkat, tujuan, sampai, jam, harga;
    public TiketViewHolder(@NonNull View itemView, TiketInterface tiketInterface){
        super(itemView);
        idtiket = itemView.findViewById(R.id.idtiket);
        asal = itemView.findViewById(R.id.asal);
        berangkat = itemView.findViewById(R.id.berangkat);
        tujuan = itemView.findViewById(R.id.tujuan);
        sampai = itemView.findViewById(R.id.sampai);
        jam = itemView.findViewById(R.id.jam);
        harga = itemView.findViewById(R.id.harga);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tiketInterface != null){
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION){
                        tiketInterface.onItemClick(pos);
                    }
                }
            }
        });
    }
}
