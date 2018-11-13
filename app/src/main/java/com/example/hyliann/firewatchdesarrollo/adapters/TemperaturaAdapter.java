package com.example.hyliann.firewatchdesarrollo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.hyliann.firewatchdesarrollo.R;

public class TemperaturaAdapter extends RecyclerView.Adapter<TemperaturaAdapter.ViewHolderSectores> {
    ArrayList<String> sectores;

    public TemperaturaAdapter(ArrayList<String> sectores) {
        this.sectores = sectores;
    }

    @NonNull
    @Override
    public ViewHolderSectores onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_temperatura,null,false);
        return new ViewHolderSectores(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSectores holder, int position) {
        holder.setSectores(sectores.get(position));
    }

    @Override
    public int getItemCount() {
        return sectores.size();
    }

    public class ViewHolderSectores extends RecyclerView.ViewHolder {
        TextView tv_temperatura;

        public ViewHolderSectores(View itemView) {
            super(itemView);

            tv_temperatura= (TextView) itemView.findViewById(R.id.tv_temperatura);
        }

        public void setSectores(String sector) {
            tv_temperatura.setText(sector);
        }
    }
}
