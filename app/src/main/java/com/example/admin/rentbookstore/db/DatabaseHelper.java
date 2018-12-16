package com.example.admin.rentbookstore.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "store.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "book";
    //public static final String COL_ID = "_id";
    public static final String COL_NAMEBOOK = "namebook";
    public static final String COL_NAMEAUTHOR = "nameauthor";
    public static final String COL_NUMPAGE = "numpage";
    public static final String COL_PRICEBOOK = "pricebook";
    public static final String COL_PRICERENT = "pricerent";
    public static final String COL_TYPEBOOK = "typebook";
    public static final String COL_IMAGE = "image";
    public static final String COL_STATUS = "status";

    private static final String SQL_CREATE_TABLE_BOOK
            = "CREATE TABLE " + TABLE_NAME + "("
            //+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NAMEBOOK + " TEXT,"
            + COL_NAMEAUTHOR + " TEXT,"
            + COL_NUMPAGE + " TEXT,"
            + COL_PRICEBOOK + " TEXT,"
            + COL_PRICERENT + " TEXT,"
            + COL_TYPEBOOK + " TEXT,"
            + COL_IMAGE + " TEXT,"
            + COL_STATUS + " TEXT"
            + ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_BOOK);
        ContentValues cv = new ContentValues();

        cv.put(COL_NAMEBOOK, "นายฉลาดน้อยกับหัวใจคุณ");
        cv.put(COL_NAMEAUTHOR, "สุชาญ วงศ์ลิขิตปัญญา");
        cv.put(COL_NUMPAGE, "152");
        cv.put(COL_PRICEBOOK, "128.25");
        cv.put(COL_PRICERENT, "30");
        cv.put(COL_TYPEBOOK, "บันเทิงคดี");
        cv.put(COL_IMAGE, "1.jpg");
        cv.put(COL_STATUS, "ไม่ว่าง");
       	db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "คำใส");
        cv.put(COL_NAMEAUTHOR, "วีระศักดิ์ สุยะลา");
        cv.put(COL_NUMPAGE, "96");
        cv.put(COL_PRICEBOOK, "65");
        cv.put(COL_PRICERENT, "20");
        cv.put(COL_TYPEBOOK, "บันเทิงคดี");
        cv.put(COL_IMAGE, "2.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "ข้าคือหุ่นยนต์");
        cv.put(COL_NAMEAUTHOR, "Isaac Asimov");
        cv.put(COL_NUMPAGE, "272");
        cv.put(COL_PRICEBOOK, "450");
        cv.put(COL_PRICERENT, "40");
        cv.put(COL_TYPEBOOK, "บันเทิงคดี");
        cv.put(COL_IMAGE, "3.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "หัวใจติดปลายนวม");
        cv.put(COL_NAMEAUTHOR, "วสุวัต");
        cv.put(COL_NUMPAGE, "134");
        cv.put(COL_PRICEBOOK, "145");
        cv.put(COL_PRICERENT, "30");
        cv.put(COL_TYPEBOOK, "บันเทิงคดี");
        cv.put(COL_IMAGE, "4.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "ห้องเรียนไม่มีฝา");
        cv.put(COL_NAMEAUTHOR, "ธารา ศรีอนุรักษ์");
        cv.put(COL_NUMPAGE, "129");
        cv.put(COL_PRICEBOOK, "135");
        cv.put(COL_PRICERENT, "30");
        cv.put(COL_TYPEBOOK, "บันเทิงคดี");
        cv.put(COL_IMAGE, "5.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "ม็อกซ์ แมวมหัศจรรย์");
        cv.put(COL_NAMEAUTHOR, "สุมาลี");
        cv.put(COL_NUMPAGE, "271");
        cv.put(COL_PRICEBOOK, "175");
        cv.put(COL_PRICERENT, "40");
        cv.put(COL_TYPEBOOK, "บันเทิงคดี");
        cv.put(COL_IMAGE, "6.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "Ring the Bell สาวสถาปัตย์กับเด็กหนุ่มของเธอ");
        cv.put(COL_NAMEAUTHOR, "พองโก้");
        cv.put(COL_NUMPAGE, "304");
        cv.put(COL_PRICEBOOK, "229");
        cv.put(COL_PRICERENT, "50");
        cv.put(COL_TYPEBOOK, "บันเทิงคดี");
        cv.put(COL_IMAGE, "7.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);



        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "รอยจำในเรือนใจ");
        cv.put(COL_NAMEAUTHOR, "Andra");
        cv.put(COL_NUMPAGE, "480");
        cv.put(COL_PRICEBOOK, "329");
        cv.put(COL_PRICERENT, "60");
        cv.put(COL_TYPEBOOK, "บันเทิงคดี");
        cv.put(COL_IMAGE, "8.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "School Boy Idol หล่อแล้วไง รักได้มั้ยล่ะ");
        cv.put(COL_NAMEAUTHOR, "แสตมป์เบอรี่");
        cv.put(COL_NUMPAGE, "432");
        cv.put(COL_PRICEBOOK, "309");
        cv.put(COL_PRICERENT, "60");
        cv.put(COL_TYPEBOOK, "บันเทิงคดี");
        cv.put(COL_IMAGE, "9.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "A piece of the moon");
        cv.put(COL_NAMEAUTHOR, "Ha-Hyun");
        cv.put(COL_NUMPAGE, "296");
        cv.put(COL_PRICEBOOK, "299");
        cv.put(COL_PRICERENT, "40");
        cv.put(COL_TYPEBOOK, "บันเทิงคดี");
        cv.put(COL_IMAGE, "10.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "Italy Crafted : ลีลาอิตาลี");
        cv.put(COL_NAMEAUTHOR, "พลอย จริยะเวช");
        cv.put(COL_NUMPAGE, "368");
        cv.put(COL_PRICEBOOK, "495");
        cv.put(COL_PRICERENT, "60");
        cv.put(COL_TYPEBOOK, "สารคดี");
        cv.put(COL_IMAGE, "11.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "ท่องเที่ยวบ้านดินฮกเกี้ยนมรดกโลก...บ้านที่แสนไกล");
        cv.put(COL_NAMEAUTHOR, "เหอ เป่า กั๋ว");
        cv.put(COL_NUMPAGE, "153");
        cv.put(COL_PRICEBOOK, "190");
        cv.put(COL_PRICERENT, "30");
        cv.put(COL_TYPEBOOK, "สารคดี");
        cv.put(COL_IMAGE, "12.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "เดินทางกลับบ้าน");
        cv.put(COL_NAMEAUTHOR, "นิ้วกลม");
        cv.put(COL_NUMPAGE, "192");
        cv.put(COL_PRICEBOOK, "217");
        cv.put(COL_PRICERENT, "30");
        cv.put(COL_TYPEBOOK, "สารคดี");
        cv.put(COL_IMAGE, "13.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "บนเส้นทางสำรวจหิน แผ่นดินแอนตาร์กติกา");
        cv.put(COL_NAMEAUTHOR, "รศ.ดร. พิษณุพงศ์ กาญจนพยนต์");
        cv.put(COL_NUMPAGE, "136");
        cv.put(COL_PRICEBOOK, "200");
        cv.put(COL_PRICERENT, "30");
        cv.put(COL_TYPEBOOK, "สารคดี");
        cv.put(COL_IMAGE, "14.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK, "สายลมรักที่เชียงใหม่ (เชียงใหม่นครแห่งความรัก)");
        cv.put(COL_NAMEAUTHOR, "รุ่งวิทย์ สุวรรณอภิชน");
        cv.put(COL_NUMPAGE, "368");
        cv.put(COL_PRICEBOOK, "295");
        cv.put(COL_PRICERENT, "50");
        cv.put(COL_TYPEBOOK, "สารคดี");
        cv.put(COL_IMAGE, "15.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "เดินข้างเขา หนาวข้างเธอ");
        cv.put(COL_NAMEAUTHOR , "คุณากร วรวรรณธนะชัย");
        cv.put(COL_NUMPAGE , "572");
        cv.put(COL_PRICEBOOK  , "395");
        cv.put(COL_PRICERENT , "70");
        cv.put(COL_TYPEBOOK , "สารคดี");
        cv.put(COL_IMAGE, "16.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "ล่าแสงเหนือ");
        cv.put(COL_NAMEAUTHOR , "หมอ ๆ ตะลุยโลก");
        cv.put(COL_NUMPAGE , "214");
        cv.put(COL_PRICEBOOK  , "325");
        cv.put(COL_PRICERENT , "40");
        cv.put(COL_TYPEBOOK , "สารคดี");
        cv.put(COL_IMAGE, "17.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "Alone Around The World รอบโลกตามลำพัง");
        cv.put(COL_NAMEAUTHOR , "ธีรธัธธ์");
        cv.put(COL_NUMPAGE , "288");
        cv.put(COL_PRICEBOOK  , "250");
        cv.put(COL_PRICERENT , "40");
        cv.put(COL_TYPEBOOK , "สารคดี");
        cv.put(COL_IMAGE, "18.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "Japan Diary กาลครั้งหนึ่ง เมื่อใบไม้เปลี่ยนสี");
        cv.put(COL_NAMEAUTHOR , "POGGHI, เอ๋อ้อย, มาเรีย ณ ไกลบ้าน");
        cv.put(COL_NUMPAGE , "256");
        cv.put(COL_PRICEBOOK  , "325");
        cv.put(COL_PRICERENT , "60");
        cv.put(COL_TYPEBOOK , "สารคดี");
        cv.put(COL_IMAGE, "19.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "โขงนทีสีทันดร");
        cv.put(COL_NAMEAUTHOR , "ธีรภาพ โลหิตกุล");
        cv.put(COL_NUMPAGE , "176");
        cv.put(COL_PRICEBOOK  , "399");
        cv.put(COL_PRICERENT , "30");
        cv.put(COL_TYPEBOOK , "สารคดี");
        cv.put(COL_IMAGE, "20.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "TCAS ขั้นเทพ! ฉบับอัพเดต 2562");
        cv.put(COL_NAMEAUTHOR , "เด็กดี");
        cv.put(COL_NUMPAGE , "256");
        cv.put(COL_PRICEBOOK  , "199");
        cv.put(COL_PRICERENT , "60");
        cv.put(COL_TYPEBOOK , "ตำรา");
        cv.put(COL_IMAGE, "21.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "ติวเข้ม ม.6 สอบเข้ามหาวิทยาลัยได้ง่ายๆ ด้วยตัวเอง");
        cv.put(COL_NAMEAUTHOR , "คณาจารย์และกองบรรณาธิการสำนักพิมพ์");
        cv.put(COL_NUMPAGE , "384");
        cv.put(COL_PRICEBOOK  , "284");
        cv.put(COL_PRICERENT , "50");
        cv.put(COL_TYPEBOOK , "ตำรา");
        cv.put(COL_IMAGE, "22.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "สรุปเข้ม + ข้อสอบ สังคม ม.ปลาย มั่นใจเต็ม 100 ฉบับสมบูรณ์");
        cv.put(COL_NAMEAUTHOR , "พรรณณิดา วาสกุล");
        cv.put(COL_NUMPAGE , "284");
        cv.put(COL_PRICEBOOK  , "245");
        cv.put(COL_PRICERENT , "40");
        cv.put(COL_TYPEBOOK , "ตำรา");
        cv.put(COL_IMAGE, "23.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "เตรียมสอบ O-NET ม.6 ฉบับสมบูรณ์");
        cv.put(COL_NAMEAUTHOR , "ปฏิญญา นาฬิเกร์,เดชส์นรินทร์ วรรณเพ็ชร และทีมงาน");
        cv.put(COL_NUMPAGE , "752");
        cv.put(COL_PRICEBOOK  , "350");
        cv.put(COL_PRICERENT , "90");
        cv.put(COL_TYPEBOOK , "ตำรา");
        cv.put(COL_IMAGE, "24.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "พิชิต 150 คะแนนเต็ม GAT ภาษาไทย โดย อ.ขลุ่ย");
        cv.put(COL_NAMEAUTHOR , "ณภัทร รอดเหตุภัย (อ.ขลุ่ย)");
        cv.put(COL_NUMPAGE , "232");
        cv.put(COL_PRICEBOOK  , "185");
        cv.put(COL_PRICERENT , "40");
        cv.put(COL_TYPEBOOK , "ตำรา");
        cv.put(COL_IMAGE, "25.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "แก่นเกษตร ");
        cv.put(COL_NAMEAUTHOR , "คณะเกษตรศาสตร์ มหาวิทยาลัยเกษตรศาสตร์");
        cv.put(COL_NUMPAGE , "73");
        cv.put(COL_PRICEBOOK  , "129");
        cv.put(COL_PRICERENT , "20");
        cv.put(COL_TYPEBOOK , "วารสาร");
        cv.put(COL_IMAGE, "26.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "ชีวจิต");
        cv.put(COL_NAMEAUTHOR , "บริษัท อมรินทร์ บุ๊ค เซ็นเตอร์ จำกัด");
        cv.put(COL_NUMPAGE , "65");
        cv.put(COL_PRICEBOOK  , "75");
        cv.put(COL_PRICERENT , "20");
        cv.put(COL_TYPEBOOK , "วารสาร");
        cv.put(COL_IMAGE, "27.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "ซีเคร็ต ");
        cv.put(COL_NAMEAUTHOR , "บริษัท อมรินทร์พริ้นติ้งแอนด์พับลิชชิ่ง จำกัด (มหาชน)");
        cv.put(COL_NUMPAGE , "60");
        cv.put(COL_PRICEBOOK  , "60");
        cv.put(COL_PRICERENT , "20");
        cv.put(COL_TYPEBOOK , "วารสาร");
        cv.put(COL_IMAGE, "28.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "ไซแอนซ์ อิลัสเตรเต็ด");
        cv.put(COL_NAMEAUTHOR , "Post International Media");
        cv.put(COL_NUMPAGE , "92");
        cv.put(COL_PRICEBOOK  , "89");
        cv.put(COL_PRICERENT , "20");
        cv.put(COL_TYPEBOOK , "วารสาร");
        cv.put(COL_IMAGE, "29.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAMEBOOK , "เที่ยวรอบโลก");
        cv.put(COL_NAMEAUTHOR , "บริษัท อทิตตา พับลิเคชั่น จำกัด");
        cv.put(COL_NUMPAGE , "76");
        cv.put(COL_PRICEBOOK  , "100");
        cv.put(COL_PRICERENT , "20");
        cv.put(COL_TYPEBOOK , "วารสาร");
        cv.put(COL_IMAGE, "30.jpg");
        cv.put(COL_STATUS, "ว่าง");
        db.insert(TABLE_NAME, null, cv);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
