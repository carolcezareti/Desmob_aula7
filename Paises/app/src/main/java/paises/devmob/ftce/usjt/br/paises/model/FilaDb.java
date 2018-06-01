package paises.devmob.ftce.usjt.br.paises.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by carol on 15/04/2018.
 */

public class FilaDb {
    private FilaDbHelper dbHelper;

    public FilaDb(Context context) {
        dbHelper = new FilaDbHelper(context);
    }

    public void inserirFila(ArrayList<Fila> filas){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        for(Fila fila:filas){
            values.put(FilaDbContract.FilaBanco.ID_FILA, fila.getId());
            values.put(FilaDbContract.FilaBanco.NM_FILA, fila.getNome());
            values.put(FilaDbContract.FilaBanco.NM_FIGURA, fila.getFigura());

            db.insert(FilaDbContract.FilaBanco.TABLE_NAME, null, values);
        }
        db.close();
    }

    public ArrayList<Fila> listarFilas(){
        ArrayList<Fila> filas = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {FilaDbContract.FilaBanco.ID_FILA, FilaDbContract.FilaBanco.NM_FILA, FilaDbContract.FilaBanco.NM_FIGURA};

        String orderBy = FilaDbContract.FilaBanco.ID_FILA;

        Cursor c;
        c = db.query(FilaDbContract.FilaBanco.TABLE_NAME, colunas, null, null, null, null, orderBy);

        while (c.moveToNext()){
            Fila fila = new Fila();
            fila.setId(c.getInt(c.getColumnIndex(FilaDbContract.FilaBanco.ID_FILA)));
            fila.setNome(c.getString(c.getColumnIndex(FilaDbContract.FilaBanco.NM_FIGURA)));
            fila.setFigura((c.getString(c.getColumnIndex(FilaDbContract.FilaBanco.NM_FIGURA))));

            filas.add(fila);
        }
        c.close();
        db.close();
        return filas;
    }
}
