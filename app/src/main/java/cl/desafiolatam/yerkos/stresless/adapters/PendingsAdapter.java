package cl.desafiolatam.yerkos.stresless.adapters;

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
import cl.desafiolatam.yerkos.stresless.models.Pending;

public class PendingsAdapter extends RecyclerView.Adapter<PendingsAdapter.PendingViewHolder> {

    private List<Pending> pendings = new Queries().pendings();

    @NonNull
    @Override
    public PendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pending, parent, false);
        PendingViewHolder pendingViewHolder = new PendingViewHolder(view);
        return pendingViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PendingViewHolder holder, int position) {
        Pending pending = pendings.get(position);
        holder.pendingTextView.setText(pending.getName());
        holder.pendingCheckBox.setChecked(pending.isDone());

        holder.pendingCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

        holder.pendingTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return pendings.size();
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
