package com.example.hyliann.firewatchdesarrollo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.hyliann.firewatchdesarrollo.R;

public class HumedadAdapter extends RecyclerView.Adapter<HumedadAdapter.ViewHolderSectores> {

    ArrayList<String> sectores;

    public HumedadAdapter(ArrayList<String> sectores) {
        this.sectores = sectores;
    }

    @NonNull
    @Override
    public ViewHolderSectores onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_humedad,null,false);
        return new ViewHolderSectores(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HumedadAdapter.ViewHolderSectores holder, int position) {
        holder.setSectores(sectores.get(position));
    }

    @Override
    public int getItemCount() {//tamaño total de la lista frfsdf TEST!!!!!!PUSH!!!
        return sectores.size();
    }

    public class ViewHolderSectores extends RecyclerView.ViewHolder {

        TextView tv_humedad;

        public ViewHolderSectores(View itemView) {
            super(itemView);
            tv_humedad= (TextView) itemView.findViewById(R.id.tv_humedad);
        }

        public void setSectores(String sector) {
            tv_humedad.setText(sector);
        }
    }
}
