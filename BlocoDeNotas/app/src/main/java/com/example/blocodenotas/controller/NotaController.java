package com.example.blocodenotas.controller;

import android.content.Context;
import com.example.blocodenotas.modelo.Nota;
import com.example.blocodenotas.modelo.NotaDAO;

import java.util.ArrayList;

public class NotaController {
    Context mContext;
    NotaDAO notaDao;

    public NotaController(Context c) {
        mContext = c;
        notaDao = new NotaDAO(c);
    }

    public Nota cadastrarNovaNota(Nota nota){
        return notaDao.inserirNota(nota);
    }

    public ArrayList<Nota> listaNotas(){
        return notaDao.getListaNotas();
    }

    public ArrayList<String> listaTitulosNotas(){
       ArrayList<String> lista = new ArrayList<String>();

        for (Nota nota: this.listaNotas()) {
            lista.add(nota.getTitulo());
        }

        return lista;
    }

    public boolean atualizaNota(Nota n) {
        return notaDao.updateNota(n);
    }

    public boolean excluirNota(Nota n){
        return notaDao.deleteNota(n);
    }

    public Nota getNota(Integer idNota){
        return notaDao.getNota(idNota);
    }
}
