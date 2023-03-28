package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
AppCompatButton btnDialog1, btnDialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialog1 = findViewById(R.id.btnDialog1);
        btnDialog2 = findViewById(R.id.btnDialog2);


        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);

        // Single Button Alert Dialog
        btnDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.setTitle("Terms & Condition");
                alertDialog.setIcon(R.drawable.ic_baseline_info_24);
                alertDialog.setMessage("Have you read all T&C ");

                alertDialog.setButton("Yes, Proceed", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Yes, You can proceed over", Toast.LENGTH_LONG).show();
                    }
                });
                alertDialog.show();
            }
        });

        // For Two Button Alert Dialog
        btnDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                delDialog.setTitle("Delete");
                delDialog.setMessage("Are you sure want to Delete ?");
                delDialog.setIcon(R.drawable.ic_baseline_delete_24);

                delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // For Yes
                        Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
                    }
                });

                delDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // For No..
                        Toast.makeText(MainActivity.this, "Not Deleted", Toast.LENGTH_SHORT).show();
                    }
                });

                delDialog.show();
            }
        });

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);

        exitDialog.setTitle("Exit");
        exitDialog.setMessage("Are you sure want to exit ?");
        exitDialog.setIcon(R.drawable.ic_baseline_exit_to_app_24);

        exitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              MainActivity.super.onBackPressed();
            }
        });
        exitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Back", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.show();
    }
}