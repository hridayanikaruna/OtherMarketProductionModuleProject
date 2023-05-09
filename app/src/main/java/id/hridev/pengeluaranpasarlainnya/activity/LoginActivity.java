package id.hridev.pengeluaranpasarlainnya.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import id.hridev.pengeluaranpasarlainnya.R;
import id.hridev.pengeluaranpasarlainnya.data.DataPegawai;
import id.hridev.pengeluaranpasarlainnya.model.Pegawai;

public class LoginActivity extends AppCompatActivity {
    EditText inputUsername,inputPassword;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        inputUsername= findViewById(R.id.username_login);
        inputPassword= findViewById(R.id.password_login);
        loginbtn= findViewById(R.id.loginbtn);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataPegawai dataPegawai = new DataPegawai();
                List<Pegawai> listpegawai = dataPegawai.getPegawai();

                String mUsername = inputUsername.getText().toString();
                String mPassword = inputPassword.getText().toString();
                //validasi di array
                for (int i = 0; i < listpegawai.size(); i++) {
                    if(mUsername.equals(listpegawai.get(i).getUsername()) && mPassword.equals(listpegawai.get(i).getPassword())) {
                        if(listpegawai.get(i).getRole().equals("manajer")) {
                            if(listpegawai.get(i).getStatus().equals("1")) {
                                Toast.makeText(LoginActivity.this, "Selamat Datang " + mUsername, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(LoginActivity.this, "Akun tidak aktif!", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(LoginActivity.this, "Pastikan login sebagai manajer!", Toast.LENGTH_SHORT).show();
                        }
                    }else if(mUsername.equals(listpegawai.get(i).getUsername()) && !(mPassword.equals(listpegawai.get(i).getPassword()))) {
                        Toast.makeText(LoginActivity.this, "Username atau Password salah!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}