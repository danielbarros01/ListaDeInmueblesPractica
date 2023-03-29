package com.example.listadeinmuebles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListaAdapter extends ArrayAdapter<Inmueble> {

    private Context context;
    private List<Inmueble> lista;
    private LayoutInflater li;


    //CADA RECURSO(resource), TIENE UN VALOR ENTERO, sea un layout, imagen, etc.
    public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    //indice del elemento, el item a visualizar,     contendor padre(ListView que vamos a usar)
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = li.inflate(R.layout.item, parent, false);
        }

        Inmueble inmueble = lista.get(position);

        ImageView foto = itemView.findViewById(R.id.foto);
        foto.setImageResource(inmueble.getFoto());

        TextView direccion = itemView.findViewById(R.id.direccion);
        direccion.setText(inmueble.getDireccion());

        TextView precio = itemView.findViewById(R.id.precio);
        precio.setText(inmueble.getPrecio() + "");

        return itemView;
    }
}
