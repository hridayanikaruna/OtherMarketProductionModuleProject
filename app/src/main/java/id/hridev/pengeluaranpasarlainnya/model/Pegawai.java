package id.hridev.pengeluaranpasarlainnya.model;

public class Pegawai {
    int id_admin;
    String username;
    String password;
    String role;
    String status;

    public Pegawai(int id_admin, String username, String password, String role, String status) {
        this.id_admin = id_admin;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
