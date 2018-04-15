package paises.devmob.ftce.usjt.br.paises.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by carol on 15/04/2018.
 */

public class FilaDbHelper {
    public static final String SQL_CREATE_FILA =
            "CREATE TABLE" + FilaDbContract.FilaBanco.TABLE_NAME + "(" +
                    FilaDbContract.FilaBanco._ID + " INTEGER PROMARY KEY, " +
                    FilaDbContract.FilaBanco.ID_FILA + " INTEGER, " +
                    FilaDbContract.FilaBanco.NM_FILA + " TEXT, " +
                    FilaDbContract.FilaBanco.NM_FIGURA + " TEXT, " +
                    FilaDbContract.FilaBanco.IMG_FIGURA + "BLOB ) ";

    public static final String SQL_DROP_FILA =
            "DROP TABLE IF EXISTS " + FilaDbContract.FilaBanco.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Fila.db";
    private SQLiteDatabase readableDatabase;
    private SQLiteDatabase writableDatabase;

    public FilaDbHelper(Context context) {super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_FILA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_FILA);
        db.execSQL(SQL_CREATE_FILA);
    }

    public SQLiteDatabase getReadableDatabase() {
        return readableDatabase;
    }

    public SQLiteDatabase getWritableDatabase() {
        return writableDatabase;
    }
}
