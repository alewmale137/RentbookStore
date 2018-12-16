package com.example.admin.rentbookstore.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.rentbookstore.R;
import com.example.admin.rentbookstore.model.BookItem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BookListAdapter  extends ArrayAdapter<BookItem> {

    private Context mContext;
    private int mResource;
    private List<BookItem> mBookItemList;

    public BookListAdapter(@NonNull Context context,
                            int resource,
                            @NonNull List<BookItem> bookItemList) {
        super(context, resource, bookItemList);
        this.mContext = context;
        this.mResource = resource;
        this.mBookItemList = bookItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, parent, false);

        TextView nameBookTextView = view.findViewById(R.id.textView_namebook);
        TextView nameAuthorTextView = view.findViewById(R.id.textView_nameauthor);
        TextView numPageTextView = view.findViewById(R.id.textView_numpage);
        TextView priceBookTextView = view.findViewById(R.id.textView_pricebook);
        TextView priceRentTextView = view.findViewById(R.id.textView_pricerent);
        TextView typeBookTextView = view.findViewById(R.id.textView_typebook);
        TextView statusTextView = view.findViewById(R.id.textView_status);
        ImageView imageView = view.findViewById(R.id.image_view);

        BookItem phoneItem = mBookItemList.get(position);
        String nameBook = phoneItem.namebook;
        String nameAuthor = phoneItem.nameauthor;
        String numPage = phoneItem.numpage;
        String priceBook = phoneItem.pricebook;
        String priceRent = phoneItem.pricerent;
        String typeBook = phoneItem.typebook;
        String status = phoneItem.status;
        String filename = phoneItem.image;



        nameBookTextView.setText("ชื่อหนังสือ : "+nameBook);
        nameAuthorTextView.setText("ชื่อผู้แต่ง : "+nameAuthor);
        numPageTextView.setText("จำนวนหน้า : "+numPage);
        priceBookTextView.setText("ราคาปก : "+priceBook);
        priceRentTextView.setText("ราคาค่าเช่า : "+priceRent);
        typeBookTextView.setText("ประเภทหนังสือ : "+typeBook);
        statusTextView.setText("สถานะ : "+status);

        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open(filename);
            Drawable drawable = Drawable.createFromStream(is, "");
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            File privateDir = mContext.getFilesDir();
            File logoFile = new File(privateDir, filename);

            Bitmap bitmap = BitmapFactory.decodeFile(logoFile.getAbsolutePath(), null);
            //Bitmap resized = Bitmap.createScaledBitmap(bitmap,(int)(bitmap.getWidth()*0.8), (int)(bitmap.getHeight()*0.8), true);
            imageView.setImageBitmap(bitmap);

            e.printStackTrace();
        }

        return view;
    }

}
