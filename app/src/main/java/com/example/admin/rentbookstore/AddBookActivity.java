package com.example.admin.rentbookstore;


import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admin.rentbookstore.db.DatabaseHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

import static com.example.admin.rentbookstore.db.DatabaseHelper.TABLE_NAME;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_NAMEBOOK;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_NAMEAUTHOR;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_NUMPAGE;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_PRICEBOOK;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_PRICERENT;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_TYPEBOOK;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_IMAGE;
import static com.example.admin.rentbookstore.db.DatabaseHelper.COL_STATUS;

public class AddBookActivity extends AppCompatActivity {
    private static final String TAG = AddBookActivity.class.getName();

    private Spinner bookSpinner;
    private ArrayList<String> bookType = new ArrayList<String>();
    private  String typeName = "";

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private String mLogoFilename = null;

//    public String namebook;
//    public String nameauthor;
//    public String numpage;
//    public String pricebook;
//    public String pricerent;
//    public String typebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);


        mHelper = new DatabaseHelper(this);
        mDb = mHelper.getWritableDatabase();


        bookSpinner = (Spinner) findViewById(R.id.Dropdown_type);

        createThaiClubData();

        // Adapter ตัวแรก
        ArrayAdapter<String> adapterBook = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, bookType);
        bookSpinner.setAdapter(adapterBook);

        // setOnItemSelectedListener
        bookSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                typeName = bookType.get(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        Button saveButton = findViewById(R.id.add_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //doInsertPhoneItem();
                EditText nameBookEditText2 = findViewById(R.id.editText_nameBook);
                EditText nameAuthorEditText2 = findViewById(R.id.editText_nameAuthor);
                EditText numPageEditText2 = findViewById(R.id.editText_numPage);
                EditText priceBookEditText2 = findViewById(R.id.editText_priceBook);
                EditText priceRentEditText2 = findViewById(R.id.editText_priceRent);

                String namebook2 = nameBookEditText2.getText().toString();
                String nameauthor2 = nameAuthorEditText2.getText().toString();
                String numpage2 = numPageEditText2.getText().toString();
                String pricebook2 = priceBookEditText2.getText().toString();
                String pricerent2 = priceRentEditText2.getText().toString();
                String typebook2 = typeName;

                if (namebook2.length() != 0 && nameauthor2.length() != 0
                        && numpage2.length() != 0 &&
                        pricebook2.length() != 0 &&
                        pricerent2.length() != 0 &&
                        (typebook2.length() != 0 && !typebook2.equals("เลือกประเภทของหนังสือ"))) {
                    doInsertPhoneItem();
                }
                else {
                    Toast t = Toast.makeText(AddBookActivity.this,namebook2+" "
                            +numpage2+" "+pricebook2+
                            " "+pricerent2+" "+typebook2,Toast.LENGTH_LONG);
                    t.show();
                    new AlertDialog.Builder(AddBookActivity.this)
                            .setTitle("")
                            .setMessage("กรุณากรอกข้อมูลหนังสือให้ครบ")
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .show();
                }
            }
        });

        ImageView logoImageView = findViewById(R.id.logo_image_view2);
        logoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyImage.openChooserWithGallery(AddBookActivity.this, "เลือกรูปภาพ", 0);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagesPicked(@NonNull List<File> list, EasyImage.ImageSource imageSource, int i) {
                File logoFile = list.get(0);
                Log.i(TAG, logoFile.getAbsolutePath());
                Log.i(TAG, logoFile.getName());

                File privateDir = getFilesDir();
                File dstFile = new File(privateDir, logoFile.getName());
                try {
                    copy(logoFile, dstFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mLogoFilename = logoFile.getName();
                ImageView logoImageView = findViewById(R.id.logo_image_view2);

                Bitmap bitmap = BitmapFactory.decodeFile(logoFile.getAbsolutePath(), null);
                logoImageView.setImageBitmap(bitmap);
            }
        });

    }

    public static void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    private void doInsertPhoneItem() {
        EditText nameBookEditText = findViewById(R.id.editText_nameBook);
        EditText nameAuthorEditText = findViewById(R.id.editText_nameAuthor);
        EditText numPageEditText = findViewById(R.id.editText_numPage);
        EditText priceBookEditText = findViewById(R.id.editText_priceBook);
        EditText priceRentEditText = findViewById(R.id.editText_priceRent);

        String namebook = nameBookEditText.getText().toString();
        String nameauthor = nameAuthorEditText.getText().toString();
        String numpage = numPageEditText.getText().toString();
        String pricebook = priceBookEditText.getText().toString();
        String pricerent = priceRentEditText.getText().toString();
        String typebook = typeName;

        ContentValues cv = new ContentValues();
        cv.put(COL_NAMEBOOK, namebook);
        cv.put(COL_NAMEAUTHOR, nameauthor);
        cv.put(COL_NUMPAGE, numpage);
        cv.put(COL_PRICEBOOK, pricebook);
        cv.put(COL_PRICERENT, pricerent);
        cv.put(COL_TYPEBOOK, typebook);
        cv.put(COL_STATUS, "ว่าง");
        cv.put(COL_IMAGE, mLogoFilename);
        mDb.insert(TABLE_NAME, null, cv);

        finish();
    }

    private void createThaiClubData() {



        bookType.add("เลือกประเภทของหนังสือ");
        bookType.add("บันเทิงคดี");
        bookType.add("สารคดี");
        bookType.add("ตำรา");
        bookType.add("วารสาร");



    }
}
