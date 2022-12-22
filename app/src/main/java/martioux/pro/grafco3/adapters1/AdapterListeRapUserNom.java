package martioux.pro.grafco3.adapters1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import martioux.pro.grafco3.ModifRapport;
import martioux.pro.grafco3.R;
import martioux.pro.grafco3.restbeans.ObjetListeRapNomUser;
import martioux.pro.grafco3.restbeans.ObjetListeRapport;

public class AdapterListeRapUserNom extends RecyclerView.Adapter<AdapterListeRapUserNom.Rpviewholders> {

    List<ObjetListeRapNomUser> objetlisteRapportParNom;
    Context context;


    public AdapterListeRapUserNom(Context context) {
        this.context = context;
        objetlisteRapportParNom = new ArrayList<> ();
    }

    @NonNull
    @Override
    public Rpviewholders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.layout_card,
                parent, false);

        return new  AdapterListeRapUserNom.Rpviewholders (view);
    }

    @Override
    public void onBindViewHolder(@NonNull Rpviewholders holder, int position) {
        holder.bindViewHolder (objetlisteRapportParNom.get (position));
        holder.supprim.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (context, ModifRapport.class);
                intent.putExtra ("idrap",
                        Integer.valueOf (holder.idra.getText ().toString ()));
                intent.putExtra ("rapport",
                        holder.texrap.getText ().toString ());
                intent.addFlags (Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity (intent);
            }
        });

    }




    @Override
    public int getItemCount() {
        return objetlisteRapportParNom.size ();
    }

    public void AjouterUnElement(ObjetListeRapNomUser objetListeRapNomUsers) {
        objetlisteRapportParNom.add (objetListeRapNomUsers);
        notifyItemInserted (objetlisteRapportParNom.size () - 1);
    }

    static class Rpviewholders extends RecyclerView.ViewHolder {
        public TextView idra, texrap, firstnames, lastnames, da;
        public ImageView supprim, modifs;

        public Rpviewholders(View view) {
            super (view);
            idra = (TextView) itemView.findViewById (R.id.idrapco);
            texrap = (TextView) itemView.findViewById (R.id.rapport);
            da = (TextView) itemView.findViewById (R.id.daterap);
            firstnames = (TextView) itemView.findViewById (R.id.firtname);
            lastnames = (TextView) itemView.findViewById (R.id.lastname);
            supprim = (ImageView) itemView.findViewById (R.id.supprim);
            modifs=(ImageView) itemView.findViewById (R.id.modif);
        }

        public void bindViewHolder(ObjetListeRapNomUser objets) {

            idra.setText (String.valueOf (objets.getIdrapns ()));
            texrap.setText (objets.getTextrapns ());
            da.setText (objets.getDatens ());
            firstnames.setText (objets.getFirstnamens ());
            lastnames.setText (objets.getLastnamens ());
        }


    }
}
