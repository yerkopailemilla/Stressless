package cl.desafiolatam.yerkos.stresless.adapters;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cl.desafiolatam.yerkos.stresless.R;
import cl.desafiolatam.yerkos.stresless.data.Queries;
import cl.desafiolatam.yerkos.stresless.intefaces.PendingClickListener;
import cl.desafiolatam.yerkos.stresless.models.Pending;

public class PendingsAdapter extends RecyclerView.Adapter<PendingsAdapter.PendingViewHolder> {

    private List<Pending> pendings = new Queries().pendings();
    private PendingClickListener clickListener;

    public PendingsAdapter(PendingClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public PendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pending, parent, false);
        PendingViewHolder pendingViewHolder = new PendingViewHolder(view);
        return pendingViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PendingViewHolder holder, int position) {
        Pending pending = pendings.get(position);
        holder.pendingTextView.setText(pending.getName());
        holder.pendingCheckBox.setChecked(pending.isDone());

        holder.pendingCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int auxPosition = holder.getAdapterPosition();
                        Pending auxPending = pendings.get(auxPosition);
                        auxPending.setDone(true);
                        auxPending.save();
                        pendings.remove(auxPosition);
                        notifyItemRemoved(auxPosition);
                    }
                }, 500);
            }
            }
        });

        holder.pendingTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int auxPosition = holder.getAdapterPosition();
            Pending auxPending = pendings.get(auxPosition);
            clickListener.clickedId(auxPending.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return pendings.size();
    }

    public void udpdate(Pending pending){
        pendings.add(pending);
        notifyDataSetChanged();
    }

    public void updateByName(String name){
        List<Pending> byName = new Queries().byName(name);
        pendings.clear();
        pendings.addAll(byName);
        notifyDataSetChanged();
    }

    static class PendingViewHolder extends RecyclerView.ViewHolder{

        private CheckBox pendingCheckBox;
        private TextView pendingTextView;

        public PendingViewHolder(View itemView) {
            super(itemView);

            pendingCheckBox = itemView.findViewById(R.id.pendingCheckBox);
            pendingTextView = itemView.findViewById(R.id.pendingTextView);
        }
    }

}
