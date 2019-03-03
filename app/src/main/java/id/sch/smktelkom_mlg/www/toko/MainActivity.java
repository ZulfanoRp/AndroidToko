package id.sch.smktelkom_mlg.www.toko;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtnamapel, edtnamabar, edtjumlahbel, edtharga, edtuangbay;
    private Button btnproses;
    private Button btnhapus;
    private Button btnexit;
    private TextView txtnamapel;
    private TextView txtnamabar;
    private TextView txtjumlahbel;
    private TextView txtharga;
    private TextView txtuangbay;
    private TextView txtbonus;
    private TextView txttotalbelanja;
    private TextView txtuangkembali;
    private TextView txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Toko Gecol");

        edtnamapel = findViewById(R.id.namapelanggan);
        edtnamabar = findViewById(R.id.namabarang);
        edtjumlahbel = findViewById(R.id.jumlahbeli);
        edtharga = findViewById(R.id.harga);
        edtuangbay = findViewById(R.id.uangbayar);
        btnproses = findViewById(R.id.tombol1);
        btnhapus = findViewById(R.id.tombol2);
        btnexit = findViewById(R.id.tombol3);
        txtnamapel = findViewById(R.id.namapelanggan);
        txtnamabar = findViewById(R.id.namabarang);
        txtjumlahbel = findViewById(R.id.jumlahbeli);
        txtharga = findViewById(R.id.harga);
        txtuangbay = findViewById(R.id.uangbayar);
        txtbonus = findViewById(R.id.bonus);
        txttotalbelanja = findViewById(R.id.totalbelanja);
        txtuangkembali = findViewById(R.id.uangkembali);
        txtketerangan = findViewById(R.id.keterangan);

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namapelanggan = edtnamapel.getText().toString().trim();
                String namabarang = edtnamabar.getText().toString().trim();
                String jumlahbeli = edtjumlahbel.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();
                String uangbayar = edtuangbay.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbeli);

                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotalbelanja.setText("Total Belanja : " + total);


                if (total >= 200000) {
                    txtbonus.setText("Bonus : Celana");
                } else if (total >= 50000) {
                    txtbonus.setText("Bonus : Baju");
                } else if (total >= 40000) {
                    txtbonus.setText("Bonus : Topi");
                } else {
                    txtbonus.setText("Bonus : Tidak Ada");
                }
                double uangkembalian = (ub - total);

                if (ub < total) {
                    txtketerangan.setText("Keterangan : uang bayar kurang Rp " + (-uangkembalian));
                    txtuangkembali.setText("Uang Kembali : Rp 0");
                } else {
                    txtketerangan.setText("Keterangan : TUNGGU KEMBALIANNYA");
                    txtuangkembali.setText("Uang Kembali : " + uangkembalian);
                }


            }
        });
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnamapel.setText(" ");
                txtnamabar.setText(" ");
                txttotalbelanja.setText(" Total Belanja : Rp 0");
                txtharga.setText(" ");
                txtuangbay.setText(" ");
                txtuangkembali.setText("Uang Kembali : Rp 0");
                txtbonus.setText("Bonus : - ");
                txtjumlahbel.setText(" ");
                txtketerangan.setText("Keterangan : - ");

                Toast.makeText(getApplicationContext(), "data sudah direset", Toast.LENGTH_LONG).show();

            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                moveTaskToBack(true);
            }
        });
    }
}