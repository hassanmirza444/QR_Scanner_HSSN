package com.example.qr_scanner_hssn.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.qr_scanner_hssn.R;

public class MainActivity extends AppCompatActivity {


    TextView result;
    Button startscan, generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startscan = findViewById(R.id.Main_btn_scan);
        generate = findViewById(R.id.Main_btn_generate);
        result = findViewById(R.id.txt_scan_result);

        startscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, QRCodeScannerActivity.class), QRCodeScannerActivity.QR_REQUEST_CODE);
            }
        });
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QRCodeGeneratorActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == QRCodeScannerActivity.QR_REQUEST_CODE) {
            result.setText(
                    resultCode == RESULT_OK
                            ? data.getExtras().getString(QRCodeScannerActivity.QR_RESULT_STR)
                            : "Scanned Nothing!");
        }
    }
}