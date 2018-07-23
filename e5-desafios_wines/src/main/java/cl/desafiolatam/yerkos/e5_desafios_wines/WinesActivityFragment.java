package cl.desafiolatam.yerkos.e5_desafios_wines;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.desafiolatam.yerkos.e5_desafios_wines.adapters.WinesAdapter;
import cl.desafiolatam.yerkos.e5_desafios_wines.models.Wine;

/**
 * A placeholder fragment containing a simple view.
 */
public class WinesActivityFragment extends Fragment {

    private WinesAdapter adapter;

    public WinesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wines, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView winesRecyclerView = view.findViewById(R.id.winesRecyclerView);
        winesRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        winesRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new WinesAdapter();
        winesRecyclerView.setAdapter(adapter);
    }

    public void updateList(Wine wine){
        adapter.udpdate(wine);
    }

}
