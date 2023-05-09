package id.hridev.pengeluaranpasarlainnya.model;

public class Pengeluaran {
    String uraian = "", qty = "", satuan = "", total = "", tgl_catat = "", tgl_lunas = "";

    public Pengeluaran(String uraian, String qty, String satuan, String total, String tgl_catat, String tgl_lunas) {
        this.uraian = uraian;
        this.qty = qty;
        this.satuan = satuan;
        this.total = total;
        this.tgl_catat = tgl_catat;
        this.tgl_lunas = tgl_lunas;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTgl_catat() {
        return tgl_catat;
    }

    public void setTgl_catat(String tgl_catat) {
        this.tgl_catat = tgl_catat;
    }

    public String getTgl_lunas() {
        return tgl_lunas;
    }

    public void setTgl_lunas(String tgl_lunas) {
        this.tgl_lunas = tgl_lunas;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
