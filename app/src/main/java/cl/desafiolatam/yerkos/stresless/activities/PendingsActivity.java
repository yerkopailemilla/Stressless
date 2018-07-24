package cl.desafiolatam.yerkos.stresless.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import cl.desafiolatam.yerkos.stresless.fragments.PendingsFragment;
import cl.desafiolatam.yerkos.stresless.R;
import cl.desafiolatam.yerkos.stresless.intefaces.SearchListener;
import cl.desafiolatam.yerkos.stresless.models.Pending;

public class PendingsActivity extends AppCompatActivity implements SearchListener{

    private PendingsFragment pendingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pendingsFragment = (PendingsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(PendingsActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_pending);

                ImageButton savePendingButton = dialog.findViewById(R.id.savePendingButton);
                savePendingButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText pendingEditText = dialog.findViewById(R.id.pendingEditText);
                        String name = pendingEditText.getText().toString();
                        if (name.trim().length() > 0){
                            Pending pending = new Pending();
                            pending.setName(name);
                            pending.setDone(false);
                            pending.save();
//                            pendingsFragment.updateList(pending);
                            pendingsFragment.updateListByName(name);
                        }
                        dialog.dismiss();
                    }
                });

                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });
    }

    @Override
    public void searched(String name) {
        pendingsFragment.updateListByName(name);
    }
}
