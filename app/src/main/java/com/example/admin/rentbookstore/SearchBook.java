package com.example.admin.rentbookstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchBook extends AppCompatActivity {

    private Spinner bookSpinner;
    private ArrayList<String> bookType = new ArrayList<String>();

    private  String typeName = "";
    private  String bookName = "";
    private  String authorName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book);

        bookSpinner = (Spinner) findViewById(R.id.Dropdown_status);

        createThaiClubData();

        // Adapter ตัวแรก
        ArrayAdapter<String> adapterBook = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, bookType);
        bookSpinner.setAdapter(adapterBook);

        // setOnItemSelectedListener
        bookSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(SearchBook.this,
                        "Select : " + bookType.get(position),
                        Toast.LENGTH_SHORT).show();*/
                typeName = bookType.get(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button searchButton = findViewById(R.id.SearchButton_Search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText  bookEditText = findViewById(R.id.editText_BookName);
                EditText authorEditText = findViewById(R.id.editText_AuthorName);
                bookName = bookEditText.getText().toString();
                authorName = authorEditText.getText().toString();



                //String bookAndAuthor = bookName+","+authorName;
                /*Toast t1 = Toast.makeText(SearchBook.this, typeName, Toast.LENGTH_SHORT);
                t1.show();*/
                if(bookName.length() == 0 && authorName.length() == 0 && typeName.equals("เลือกประเภทของหนังสือ")){
                    Toast t = Toast.makeText(SearchBook.this, "กรุณาใส่ชื่อหนังสือ, ชื่อผู้แต่ง หรือประเภทหนังสือก่อนค่ะ", Toast.LENGTH_SHORT);
                    t.show();

                }
                else if (bookName.length() != 0 || authorName.length() != 0 || (typeName.length() != 0 && !typeName.equals("เลือกประเภทของหนังสือ"))){
                    Intent intent = new Intent(SearchBook.this, ResultBook.class);
                    //Toast t = Toast.makeText(SearchBook.this, typeName, Toast.LENGTH_SHORT);
                    //t.show();
                    intent.putExtra("book", bookName);
                    intent.putExtra("author", authorName);
                    intent.putExtra("type", typeName);
                    startActivity(intent);
                }

                /*
                Intent intent = new Intent(SearchBook.this, SearchBook.class);

                startActivity(intent);*/
            }
        });

        Button backButton =  findViewById(R.id.back_to_home);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void createThaiClubData() {
        bookType.add("เลือกประเภทของหนังสือ");
        bookType.add("บันเทิงคดี");
        bookType.add("สารคดี");
        bookType.add("ตำรา");
        bookType.add("วารสาร");



    }

}
