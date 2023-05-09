package id.hridev.pengeluaranpasarlainnya.periode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import id.hridev.pengeluaranpasarlainnya.PengeluaranAdapter;
import id.hridev.pengeluaranpasarlainnya.R;
import id.hridev.pengeluaranpasarlainnya.data.DataPengeluaran;
import id.hridev.pengeluaranpasarlainnya.model.Pengeluaran;

public class Kuartal12022Activity extends AppCompatActivity {
    FloatingActionButton btnFloating;
    RecyclerView recyclerView;
    EditText edtUraian, edtQty, edtSatuan, edtTotal, edtCatat, edtLunas;
    Button addBtn;
    PengeluaranAdapter pengeluaranAdapter;
    Spinner spinner;
//    public List<Pengeluaran> PengeluaranList;
    public static List<Pengeluaran> listPengeluaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuartal12022);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnFloating = findViewById(R.id.btnFloating);

        btnFloating.setOnClickListener(view -> {

            Dialog dialog = new Dialog(Kuartal12022Activity.this);
            dialog.setContentView(R.layout.add_update_data);

            //init isian
            edtUraian = dialog.findViewById(R.id.edt_uraian);
            edtQty = dialog.findViewById(R.id.edt_qty);
            edtSatuan = dialog.findViewById(R.id.edt_satuan);
            edtTotal = dialog.findViewById(R.id.edt_total);
            edtCatat = dialog.findViewById(R.id.edt_catat);
            edtLunas = dialog.findViewById(R.id.edt_lunas);
            addBtn = dialog.findViewById(R.id.addbtn);

            //kategori field
            spinner = dialog.findViewById(R.id.kategoriSpinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.kategori, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            

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
                                        listPengeluaran.add(new Pengeluaran(uraian, qty, satuan, total, tgl_catat, tgl_lunas));
                                        pengeluaranAdapter.notifyItemInserted(listPengeluaran.size()-1);
                                        recyclerView.scrollToPosition(listPengeluaran.size()-1);
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

        displayItems();
    }

    private void displayItems() {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        listPengeluaran = new ArrayList<>();
        listPengeluaran.addAll(DataPengeluaran.getListPengeluaran());

        pengeluaranAdapter = new PengeluaranAdapter(this, listPengeluaran);
        recyclerView.setAdapter(pengeluaranAdapter);
    }

}