package id.hridev.pengeluaranpasarlainnya.data;

import java.util.ArrayList;
import java.util.List;

import id.hridev.pengeluaranpasarlainnya.model.Pengeluaran;

public class DataPengeluaran {
    private static String[][] dataPengeluaran = new String[][] {
            {"Sewa Gedung I", "2", "Bulan", "600000", "29 Mei 2022", "29 Mei 2022"},
            {"Sewa Gedung II", "3", "Bulan", "800000", "30 Mei 2022", "31 Mei 2022"}
    };

    public static ArrayList<Pengeluaran> getListPengeluaran() {
        String uraian = "", qty = "", satuan = "", total = "", tgl_catat = "", tgl_lunas = "";
        ArrayList<Pengeluaran> listPengeluaran = new ArrayList<>();
        for (String[] dataPengeluaran : dataPengeluaran) {
            Pengeluaran pengeluaran = new Pengeluaran(uraian, qty, satuan, total, tgl_catat, tgl_lunas);
            pengeluaran.setUraian(dataPengeluaran[0]);
            pengeluaran.setQty(dataPengeluaran[1]);
            pengeluaran.setSatuan(dataPengeluaran[2]);
            pengeluaran.setTotal(dataPengeluaran[3]);
            pengeluaran.setTgl_catat(dataPengeluaran[4]);
            pengeluaran.setTgl_lunas(dataPengeluaran[5]);
            listPengeluaran.add(pengeluaran);
        }
        return listPengeluaran;
    }
}
