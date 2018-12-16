package com.example.admin.rentbookstore;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.rentbookstore.adapter.BookListAdapter;
import com.example.admin.rentbookstore.db.DatabaseHelper;
import com.example.admin.rentbookstore.model.BookItem;

import java.util.ArrayList;
import java.util.List;

//import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_ID;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_IMAGE;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_NAMEAUTHOR;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_NAMEBOOK;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_NUMPAGE;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_PRICEBOOK;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_PRICERENT;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_STATUS;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_TYPEBOOK;
import static com.example.admin.rentbookstore.db.DatabaseHelper.TABLE_NAME;

public class EditActivity extends AppCompatActivity {
    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;

    private List<BookItem> mBookItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mHelper = new DatabaseHelper(EditActivity.this);
        mDb = mHelper.getWritableDatabase();

        Button backHome = findViewById(R.id.button_own_backhome);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });

        Button addBook = findViewById(R.id.button_add);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, AddBookActivity.class);

                startActivity(intent);
            }
        });


    }

    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadBookData();
        setupListView();
    }

    private void loadBookData() {
        Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);

        mBookItemList = new ArrayList<>();
        while (c.moveToNext()) {



            //long id = c.getLong(c.getColumnIndex(COL_ID));
            String namebook = c.getString(c.getColumnIndex(COL_NAMEBOOK));
            String nameauthor = c.getString(c.getColumnIndex(COL_NAMEAUTHOR));
            String numpage = c.getString(c.getColumnIndex(COL_NUMPAGE));
            String pricebook = c.getString(c.getColumnIndex(COL_PRICEBOOK));
            String pricerent = c.getString(c.getColumnIndex(COL_PRICERENT));
            String typebook = c.getString(c.getColumnIndex(COL_TYPEBOOK));
            String image = c.getString(c.getColumnIndex(COL_IMAGE));
            String status = c.getString(c.getColumnIndex(COL_STATUS));


            BookItem item = new BookItem(namebook, nameauthor, numpage, pricebook, pricerent, typebook, image, status);
            mBookItemList.add(item);


        }
        c.close();
    }

    private void setupListView() {
        /*ArrayAdapter<BookItem> adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                mBookItemList
        );*/

        BookListAdapter adapter = new BookListAdapter(
                EditActivity.this,
                R.layout.item_book,
                mBookItemList
        );

        ListView lv = findViewById(R.id.result_list_view2);
        lv.setAdapter(adapter);

        /*lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {


                BookItem item = mBookItemList.get(position);




                return true;
            }
        });*/

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                String[] items = new String[]{
                        "Edit",
                        "Delete"
                };

                new AlertDialog.Builder(EditActivity.this)
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                final BookItem bookItem = mBookItemList.get(position);

                                switch (i) {
                                    case 0: // Edit
                                        Intent intent = new Intent(EditActivity.this, Edit2Activity.class);
                                        intent.putExtra("namebook", bookItem.namebook);
                                        intent.putExtra("status", bookItem.status);
                                        //intent.putExtra("id", bookItem._id);
                                        startActivity(intent);

                                        break;
                                    case 1: // Delete
                                        new AlertDialog.Builder(EditActivity.this)
                                                .setMessage("ต้องการลบข้อมูลหนังสือเล่มนี้ ใช่หรือไม่")
                                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        mDb.delete(
                                                                TABLE_NAME,
                                                                COL_NAMEBOOK + " = ?",
                                                                new String[]{String.valueOf(bookItem.namebook)}
                                                        );
                                                        loadBookData();
                                                        setupListView();
                                                    }
                                                })
                                                .setNegativeButton("No", null)
                                                .show();
                                        break;
                                }
                            }
                        })
                        .show();

                return true;
            }
        });


    }
}

