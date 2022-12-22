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

import java.util.ArrayList;
import java.util.List;

import martioux.pro.grafco3.ModifRapport;
import martioux.pro.grafco3.OpenApplication;
import martioux.pro.grafco3.R;
import martioux.pro.grafco3.ecrire_rapport;
import martioux.pro.grafco3.restbeans.ObjetListeRapport;
import martioux.pro.grafco3.restbeans.ObjetListefactureimpayee;

public class AdaptaterListeRapport extends RecyclerView.Adapter<AdaptaterListeRapport.RappoortViewHolders> {

    List<ObjetListeRapport> donneeRapport;
    Context context;
    public AdaptaterListeRapport(Context c) {
        context = c;
        donneeRapport= new ArrayList<> ();
    }
    @NonNull
    @Override
    public RappoortViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.layout_card,
       // View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.listedesrapport,
                parent, false);


        return new AdaptaterListeRapport.RappoortViewHolders (view);
    }
    @Override
    public void onBindViewHolder(@NonNull RappoortViewHolders holder, int position) {
        holder.bind (donneeRapport.get (position));
        holder.supprim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent (context, ModifRapport.class);
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
        return donneeRapport.size ();
    }

    public void addElementsrapport(ObjetListeRapport datass){
        donneeRapport.add (datass);
        notifyItemInserted (donneeRapport.size ()-1);
    }

    static class RappoortViewHolders extends RecyclerView.ViewHolder{
       public TextView idra, texrap, codecom, heu, da;
       public ImageView supprim;
       public RappoortViewHolders(View view){
           super(view);
           idra= (TextView) itemView.findViewById (R.id.idrapco);
           texrap= (TextView) itemView.findViewById (R.id.rapport);
         //  codecom= (TextView) itemView.findViewById (R.id.code);
         //  heu= (TextView) itemView.findViewById (R.id.heurerap);
           da= (TextView) itemView.findViewById (R.id.daterap);
           supprim= (ImageView) itemView.findViewById (R.id.supprim);
       }


        public void bind(ObjetListeRapport objets){
            idra.setText ( String.valueOf (objets.getIdrapports ()));
            texrap.setText (objets.getTextRappot ());
            codecom.setText (String.valueOf (objets.getCode ()));
            heu.setText (objets.getHeure ());
            da.setText (objets.getDates ());

    }
}
}
