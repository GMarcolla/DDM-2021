package com.example.blocodenotas.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDAO {
    SQLiteDatabase database;

    public NotaDAO(Context c) {
        database = c.openOrCreateDatabase("dbNotas", c.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo VARCHAR," +
                "texto VARCHAR)");
    }

    public Nota inserirNota(Nota n){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", n.getTitulo());
        contentValues.put("texto", n.getTexto());

        int i = (int) database.insert("notas", null, contentValues);
        n.setId(i);

        return n;
    }

    public ArrayList<Nota> getListaNotas() {
        Cursor cursor = database.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<Nota> lista = new ArrayList<Nota>();

        while(!cursor.isAfterLast()){
            lista.add(new Nota( cursor.getInt(cursor.getColumnIndex("id")),
                                cursor.getString(cursor.getColumnIndex("titulo")),
                                cursor.getString(cursor.getColumnIndex("texto"))));
            cursor.moveToNext();
        }

        return lista;
    }

    public boolean updateNota(Nota nota){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", nota.getTitulo());
        contentValues.put("texto", nota.getTexto());

        int rowsAfected = database.update("notas", contentValues, "id = ?", new String[]{Integer.toString(nota.getId())});

        if (rowsAfected > 0){
            return true;
        }

        return false;
    }

    public boolean deleteNota(Nota nota){
        int rowsAfected = database.delete("notas", "id = ?", new String[]{Integer.toString(nota.getId())});

        if (rowsAfected > 0){
            return true;
        }

        return false;
    }

    public Nota getNota(Integer idNota){
        Cursor cursor = database.rawQuery("SELECT * FROM notas WHERE id = ?", new String[]{Integer.toString(idNota)});
        cursor.moveToFirst();

        return new Nota(cursor.getInt(cursor.getColumnIndex("id")),
                cursor.getString(cursor.getColumnIndex("titulo")),
                cursor.getString(cursor.getColumnIndex("texto")));
    }
}
