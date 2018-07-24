package cl.desafiolatam.yerkos.stresless.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import cl.desafiolatam.yerkos.stresless.R;
import cl.desafiolatam.yerkos.stresless.data.Queries;
import cl.desafiolatam.yerkos.stresless.intefaces.SearchListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    private SearchListener listener;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (SearchListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final AutoCompleteTextView completeTextView = (AutoCompleteTextView) view;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, new Queries().names());
        completeTextView.setAdapter(arrayAdapter);

        completeTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = completeTextView.getText().toString();
                listener.searched(name);
            }
        });
    }
}
