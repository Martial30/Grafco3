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
import martioux.pro.grafco3.restbeans.ObjetListeClientCommercial;

public class AdapterListeClientCommercials extends RecyclerView.Adapter<AdapterListeClientCommercials.FactureViewHolderlcc> {

    List<ObjetListeClientCommercial>don;
    public AdapterListeClientCommercials(){
        don=new ArrayList<> ();
    }

    @NonNull
    @Override
    public FactureViewHolderlcc onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.sgllisteclientcommercial,
                parent, false);
        return new FactureViewHolderlcc (view);
    }



    @Override
    public void onBindViewHolder(@NonNull FactureViewHolderlcc holder, int position) {
        holder.bind(don.get(position));
    }

    @Override
    public int getItemCount() {
        return don.size ();
    }
    
    public void addElementlcc(ObjetListeClientCommercial datalcc){
        don.add (datalcc);
        notifyItemInserted (don.size ()-1);
        
    }
    
    static  class FactureViewHolderlcc extends RecyclerView.ViewHolder{
        TextView idlcc, nomlcc, adresslcc, telephonelcc;
        public FactureViewHolderlcc(@NonNull View view) {
            super (view);
           idlcc=(TextView) itemView.findViewById (R.id.idclient);
           nomlcc=(TextView) itemView.findViewById (R.id.nom);
           adresslcc=(TextView) itemView.findViewById (R.id.adress);
           telephonelcc=(TextView) itemView.findViewById (R.id.telephonel);
        }
        
        public void bind(ObjetListeClientCommercial objetListeClientCommercial){
            idlcc.setText (String.valueOf (objetListeClientCommercial.getIdClient ()));
            nomlcc.setText (String.valueOf (objetListeClientCommercial.getNom ()));
            adresslcc.setText (String.valueOf (objetListeClientCommercial.getAddress ()));
            telephonelcc.setText (String.valueOf (objetListeClientCommercial.getPhone ()));
        }
    }
}
