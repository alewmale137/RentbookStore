package com.example.admin.rentbookstore.model;

import java.util.Locale;

public class BookItem {

    public final String namebook;
    public final String nameauthor;
    public final String numpage;
    public final String pricebook;
    public final String pricerent;
    public final String typebook;
    public final String image;
    public final String status;
    //public final long _id;


    public BookItem( String namebook, String nameauthor, String numpage, String pricebook, String pricerent, String typebook, String image , String status ) {
        //this._id = _id;
        this.namebook = namebook;
        this.nameauthor = nameauthor;
        this.numpage = numpage;
        this.pricebook = pricebook;
        this.pricerent = pricerent;
        this.typebook = typebook;
        this.image = image;
        this.status = status;
    }

    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "ชื่อหนังสือ : %s\n" +
                        "ชื่อผู้แต่ง : %s\n" +
                        "จำนวนหน้า : %s\n"+
                        "ราคาปก : %s\n" +
                        "ราคาค่าเช่า : %s\n" +
                        "ประเภทหนังสือ : %s\n"+
                        "สถานะ : %s\n",
                this.namebook,
                this.nameauthor,
                this.numpage,
                this.pricebook,
                this.pricerent,
                this.typebook,
                this.status
        );
        return msg;
    }
}
