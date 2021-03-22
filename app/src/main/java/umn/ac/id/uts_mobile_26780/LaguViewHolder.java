package umn.ac.id.uts_mobile_26780;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LaguViewHolder extends RecyclerView.ViewHolder {
    private TextView txtLaguJudul;
    private TextView txtLaguDurasi;

    public LaguViewHolder(@NonNull View itemView) {
        super(itemView);

        txtLaguJudul = itemView.findViewById(R.id.txt_lagu_judul);
        txtLaguDurasi = itemView.findViewById(R.id.txt_lagu_durasi);
    }
    public void setLaguJudul(String laguJudul) {
        this.txtLaguJudul.setText(laguJudul);
    }
    public void setLaguDurasi(String laguDurasi) {
        this.txtLaguDurasi.setText(laguDurasi);
    }
}