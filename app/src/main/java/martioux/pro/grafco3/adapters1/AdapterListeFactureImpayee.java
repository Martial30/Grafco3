package martioux.pro.grafco3.adapters1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import martioux.pro.grafco3.R;
import martioux.pro.grafco3.restbeans.ObjetListefactureimpayee;

public class AdapterListeFactureImpayee extends RecyclerView.Adapter<AdapterListeFactureImpayee.FactureViewHolders> {

   List<ObjetListefactureimpayee>donnes;

    public AdapterListeFactureImpayee() {
        donnes= new ArrayList<> ();
    }

    @NonNull
    @Override
    public FactureViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.singleview2,
                parent, false);
        return new FactureViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FactureViewHolders holder, int position) {
        holder.bind (donnes.get (position));

    }

    @Override
    public int getItemCount() {
        return donnes.size ();
    }
    public void addElements(ObjetListefactureimpayee datas){
        donnes.add (datas);
        notifyItemInserted (donnes.size ()-1);
    }
    static class FactureViewHolders extends RecyclerView.ViewHolder{
        TextView id, nomPrenom, structure, datefacture, creance, dateecheance;
        public FactureViewHolders(View view) {
            super (view);
            id= (TextView) itemView.findViewById (R.id.ids);
            nomPrenom= (TextView) itemView.findViewById (R.id.nomPrenoms);
            structure= (TextView) itemView.findViewById (R.id.structures);
            datefacture= (TextView) itemView.findViewById (R.id.date_factures);
            creance= (TextView) itemView.findViewById (R.id.creances);
            dateecheance= (TextView) itemView.findViewById (R.id.date_echeances);
        }
        public void bind(ObjetListefactureimpayee objets){
            id.setText ( String.valueOf (objets.getIds ()));
            nomPrenom.setText (objets.getNomclient ());
            structure.setText (objets.getStructure ());
            datefacture.setText (objets.getDatefactures ());
            creance.setText (objets.getCreance ());
            dateecheance.setText (objets.getDateecheance ());
        }
    }

}
