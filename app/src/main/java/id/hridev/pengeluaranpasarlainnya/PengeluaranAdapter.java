package id.hridev.pengeluaranpasarlainnya;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.hridev.pengeluaranpasarlainnya.model.Pengeluaran;

public class PengeluaranAdapter extends RecyclerView.Adapter<CustomViewHolder>  {
    private Context context;
    private List<Pengeluaran> list;
    TextView txtJudul;
    EditText edtUraian, edtQty, edtSatuan, edtTotal, edtCatat, edtLunas;
    Button addBtn;

    public PengeluaranAdapter(Context context, List<Pengeluaran> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.pengeluaran_k12022_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.txt_uraian.setText(list.get(holder.getAdapterPosition()).getUraian());
        holder.txt_qty.setText(list.get(holder.getAdapterPosition()).getQty());
        holder.txt_satuan.setText(list.get(holder.getAdapterPosition()).getSatuan());
        holder.txt_total.setText(list.get(holder.getAdapterPosition()).getTotal());
        holder.txt_catat.setText(list.get(holder.getAdapterPosition()).getTgl_catat());
        holder.txt_lunas.setText(list.get(holder.getAdapterPosition()).getTgl_lunas());

        holder.editBtn.setOnClickListener(view -> {
            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.add_update_data);


            edtUraian = dialog.findViewById(R.id.edt_uraian);
            edtQty = dialog.findViewById(R.id.edt_qty);
            edtSatuan = dialog.findViewById(R.id.edt_satuan);
            edtTotal = dialog.findViewById(R.id.edt_total);
            edtCatat = dialog.findViewById(R.id.edt_catat);
            edtLunas = dialog.findViewById(R.id.edt_lunas);
            addBtn = dialog.findViewById(R.id.addbtn);

            txtJudul = dialog.findViewById(R.id.txtJudul);

            //update
            txtJudul.setText("Update Uraian");
            addBtn.setText("Update");

//            set text ke get position edit text semua field
            edtUraian.setText(list.get(position).getUraian());
            edtQty.setText(list.get(position).getQty());
            edtSatuan.setText(list.get(position).getSatuan());
            edtTotal.setText(list.get(position).getTotal());
            edtCatat.setText(list.get(position).getTgl_catat());
            edtLunas.setText(list.get(position).getTgl_lunas());

            //edit button di klik
            addBtn.setOnClickListener(view1 -> {
                String uraian = "", qty = "", satuan = "", total = "", tgl_catat = "", tgl_lunas = "";
                //validasi
                if(!edtUraian.getText().toString().equals("")){
                    uraian = edtUraian.getText().toString();
                    if(!edtQty.getText().toString().equals("")){
                        qty = edtQty.getText().toString();
                        if(!edtSatuan.getText().toString().equals("")){
                            satuan = edtSatuan.getText().toString();
                            if(!edtTotal.getText().toString().equals("")){
                                total = edtTotal.getText().toString();
                                if(!edtCatat.getText().toString().equals("")){
                                    tgl_catat = edtCatat.getText().toString();
                                    if(!edtLunas.getText().toString().equals("")){
                                        tgl_lunas = edtLunas.getText().toString();
                                        //add new datanya
                                        list.set(holder.getAdapterPosition(), new Pengeluaran(uraian, qty, satuan, total, tgl_catat, tgl_lunas));
                                        notifyItemChanged(holder.getAdapterPosition());

                                        dialog.dismiss();
                                    }else{
                                        edtLunas.setError("Mohon masukan tanggal lunas");
                                    }
                                }else{
                                    edtCatat.setError("Mohon masukan tanggal catat");
                                }
                            }else{
                                edtTotal.setError("Mohon masukan total");
                            }
                        }else{
                            edtSatuan.setError("Mohon masukan satuan");
                        }
                    }else{
                        edtQty.setError("Mohon masukan quantity");
                    }
                }else{
                    edtUraian.setError("Mohon masukan uraian");
                }
            });
            dialog.show();
        });


        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Data")
                        .setMessage("Yakin ingin delete data pengeluaran?")
                        .setIcon(R.drawable.ic_delete)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                list.remove(holder.getAdapterPosition());
                                notifyItemRemoved(holder.getAdapterPosition());
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
