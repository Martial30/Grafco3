package martioux.pro.grafco3.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import martioux.pro.grafco3.R;
import martioux.pro.grafco3.restbeans.ObjetListefacturepayee;

public class AdapterFacturePayee extends RecyclerView.Adapter<AdapterFacturePayee.FactureViewHolder>{

    List<ObjetListefacturepayee> donnee;

    public AdapterFacturePayee() {
        donnee=new ArrayList<> ();
    }

    @NonNull
    @Override
    public FactureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleview,
                parent,false);
        return new FactureViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return donnee.size();
    }

    public void addElement(ObjetListefacturepayee data) {
        donnee.add(data);
        notifyItemInserted(donnee.size()-1);
    }

    @Override
    public void onBindViewHolder(@NonNull FactureViewHolder holder, int position) {
        holder.bind (donnee.get (position));
    }


    static class FactureViewHolder extends RecyclerView.ViewHolder {

        TextView id, nomPrenom, structure, date_facture, montant_paye, date_paiement;

        public FactureViewHolder(View view) {
            super (view);
            id = (TextView) itemView.findViewById(R.id.id);
            nomPrenom = (TextView) itemView.findViewById(R.id.nomPrenom);
            structure = (TextView) itemView.findViewById(R.id.structure);
            date_facture = (TextView) itemView.findViewById(R.id.date_facture);
            montant_paye = (TextView) itemView.findViewById(R.id.montant_paye);
            date_paiement = (TextView) itemView.findViewById(R.id.date_paiement);
        }

        public void bind(ObjetListefacturepayee objet){
            id.setText ( String.valueOf (objet.getId ()));
            nomPrenom.setText (objet.getNomclient ());
            structure.setText (objet.getStructures ());
            date_facture.setText (objet.getDatefacture ());
            montant_paye.setText (objet.getMontant ());
            date_paiement.setText (objet.getDatepaiement ());
        }
    }
}