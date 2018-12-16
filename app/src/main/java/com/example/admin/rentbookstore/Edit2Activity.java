package com.example.admin.rentbookstore;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.admin.rentbookstore.db.DatabaseHelper;

import java.util.ArrayList;
import static com.example.admin.rentbookstore.db.DatabaseHelper.TABLE_NAME;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_STATUS;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_NAMEBOOK;


public class Edit2Activity extends AppCompatActivity {

    private Spinner bookSpinner;
    private ArrayList<String> bookStatus = new ArrayList<String>();
    private  String status = "";
    private  String namebook = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit2);

        bookSpinner = (Spinner) findViewById(R.id.thai_book);

        createThaiClubData();

        // Adapter ตัวแรก
        ArrayAdapter<String> adapterBook = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, bookStatus);
        bookSpinner.setAdapter(adapterBook);

        // setOnItemSelectedListener
        bookSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(SearchBook.this,
                        "Select : " + bookType.get(position),
                        Toast.LENGTH_SHORT).show();*/
                status = bookStatus.get(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Intent intent = getIntent();
        namebook = intent.getStringExtra("namebook");
        status = intent.getStringExtra("status");
        //mId = intent.getStringExtra("id");

        //mNameBookEditText = findViewById(R.id.namebook_edit_text);
        // mStatusEditText = findViewById(R.id.status_edit_text);
        Button mSaveButton = findViewById(R.id.save_button);
        TextView showNamebook = findViewById(R.id.textView_showNameBook);
        showNamebook.setText(namebook);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper helper = new DatabaseHelper(Edit2Activity.this);
                SQLiteDatabase db = helper.getWritableDatabase();

//                String newNameBook = mNameBookEditText.getText().toString().trim();
//                String newStatus = mStatusEditText.getText().toString().trim();

                String newStatus = status;


                ContentValues cv = new ContentValues();
                //cv.put(COL_NAMEBOOK, newNameBook);
                cv.put(COL_STATUS, newStatus);

                db.update(
                        TABLE_NAME,
                        cv,
                        COL_NAMEBOOK + " = ?",
                        new String[]{String.valueOf(namebook)}
                );


                finish();

            }
        });





    }
    private void createThaiClubData() {
        bookStatus.add("ว่าง");
        bookStatus.add("ไม่ว่าง");




    }
}
