package cl.desafiolatam.yerkos.stresless.fragments;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.desafiolatam.yerkos.stresless.R;
import cl.desafiolatam.yerkos.stresless.activities.DetailActivity;
import cl.desafiolatam.yerkos.stresless.adapters.PendingsAdapter;
import cl.desafiolatam.yerkos.stresless.intefaces.PendingClickListener;
import cl.desafiolatam.yerkos.stresless.models.Pending;

/**
 * A placeholder fragment containing a simple view.
 */
public class PendingsFragment extends Fragment implements PendingClickListener{

    public static final String PENDING_ID = "cl.desafiolatam.yerkos.stresless.fragments.KEY.PENDING_ID";
    private PendingsAdapter adapter;

    public PendingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView pendingRecyclerView = view.findViewById(R.id.pendingRecyclerView);
        pendingRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        pendingRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new PendingsAdapter(this);
        pendingRecyclerView.setAdapter(adapter);
    }

    public void updateList(Pending pending){
        adapter.udpdate(pending);
    }

    public void updateListByName(String name){
        adapter.updateByName(name);
    }

    @Override
    public void clickedId(long id) {
        Intent goToDetail = new Intent(getContext(), DetailActivity.class);
        goToDetail.putExtra(PENDING_ID, id);
        startActivity(goToDetail);
    }
}
