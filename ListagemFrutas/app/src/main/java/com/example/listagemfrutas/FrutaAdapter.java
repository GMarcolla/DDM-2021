package com.example.listagemfrutas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FrutaAdapter extends ArrayAdapter<Fruta> {
    Context mContext;
    int mResource;

    public FrutaAdapter(@NonNull Context context, int resource, Fruta[] frutas) {
        super(context, resource, frutas);
        mContext = context;
        mResource = resource;
    }

    public View getView(int position, @Nullable View viewFrutas, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        viewFrutas = layoutInflater.inflate(mResource,parent,false);

        TextView txCodigo = (TextView) viewFrutas.findViewById(R.id.txCodigo);
        TextView txNomeFruta = (TextView) viewFrutas.findViewById(R.id.txNomeFruta);
        TextView txPreco =  (TextView) viewFrutas.findViewById(R.id.txPreco);
        TextView txPrecoVenda =(TextView) viewFrutas.findViewById(R.id.txPrecoVenda);
        ImageView imageView = (ImageView) viewFrutas.findViewById(R.id.imageView);

        Fruta fruta = getItem(position);

        NumberFormat nf = new DecimalFormat("#,###.00");

        txCodigo.setText(Integer.toString(fruta.getCodigo()));
        txNomeFruta.setText(fruta.getNome());
        txPreco.setText(nf.format (fruta.getPreco()));
        txPrecoVenda.setText(nf.format (fruta.getPreco_venda()));
        imageView.setImageResource(fruta.getImagem());

        return viewFrutas;
    }
}
