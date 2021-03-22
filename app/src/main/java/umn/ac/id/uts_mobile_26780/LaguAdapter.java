package umn.ac.id.uts_mobile_26780;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class LaguAdapter extends RecyclerView.Adapter <LaguViewHolder> {
    private Context context;
    private ArrayList<Lagu> laguList;

    public LaguAdapter(Context context, ArrayList<Lagu> laguList) {
        this.context = context;
        this.laguList = laguList;
    }
    @NonNull
    @Override
    public LaguViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_lagu, parent, false);
        return new LaguViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull LaguViewHolder holder, int position) {
        Lagu lagu = laguList.get(position);
        holder.setLaguJudul(lagu.getJudul());
        holder.setLaguDurasi(lagu.getDurasi());

    }

    @Override
    public int getItemCount() {
        return laguList == null ? 0 : laguList.size();
    }


    }







