package cl.desafiolatam.yerkos.stresless.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.desafiolatam.yerkos.stresless.R;
import cl.desafiolatam.yerkos.stresless.data.Queries;
import cl.desafiolatam.yerkos.stresless.models.Wine;

public class WinesAdapter extends RecyclerView.Adapter<WinesAdapter.WineViewHolder> {

    private List<Wine> wines = new Queries().wines();

    @NonNull
    @Override
    public WineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pending, parent, false);
        WineViewHolder wineViewHolder = new WineViewHolder(view);
        return wineViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WineViewHolder holder, int position) {
        Wine wine = wines.get(position);
        holder.brandTv.setText("Nombre de la marca: " + wine.getBrand());
        holder.yearsTv.setText("Añejado durante: " + wine.getYears() + " años.");
        holder.typeTv.setText("Tipo de vino: " + wine.getType());

    }

    @Override
    public int getItemCount() {
        return wines.size();
    }

    static class WineViewHolder extends RecyclerView.ViewHolder{

        private TextView brandTv, yearsTv, typeTv;

        public WineViewHolder(View itemView) {
            super(itemView);

            /*brandTv = itemView.findViewById(R.id.brandTv);
            yearsTv = itemView.findViewById(R.id.yearsTv);
            typeTv = itemView.findViewById(R.id.typeTv);*/
        }
    }

}
