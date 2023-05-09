package id.hridev.pengeluaranpasarlainnya;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    public TextView txt_uraian, txt_qty, txt_satuan, txt_total, txt_catat, txt_lunas;
    public LinearLayout ll_row;
    public Button editBtn, deleteBtn;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_uraian = itemView.findViewById(R.id.txt_uraian);
        txt_qty = itemView.findViewById(R.id.txt_qty);
        txt_satuan = itemView.findViewById(R.id.txt_satuan);
        txt_total = itemView.findViewById(R.id.txt_total);
        txt_catat = itemView.findViewById(R.id.txt_catat);
        txt_lunas = itemView.findViewById(R.id.txt_lunas);
        ll_row = itemView.findViewById(R.id.ll_row);
        editBtn = itemView.findViewById(R.id.editBtn);
        deleteBtn = itemView.findViewById(R.id.deleteBtn);
    }
}
