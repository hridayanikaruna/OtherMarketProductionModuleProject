package id.hridev.pengeluaranpasarlainnya.data;

import java.util.ArrayList;
import java.util.List;

import id.hridev.pengeluaranpasarlainnya.model.Pegawai;

public class DataPegawai {
    List<Pegawai> listPegawai = new ArrayList<>();

    public DataPegawai(){
        listPegawai.add(new Pegawai(1, "hridayani", "hridayani", "manajer", "1"));
        listPegawai.add(new Pegawai(2, "ferhati", "ferhati", "admin", "1"));
    }

    public ArrayList<Pegawai> getPegawai(){
        return (ArrayList<Pegawai>) listPegawai;
    }
}
