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

import cl.desafiolatam.yerkos.stresless.FabsAnimation;
import cl.desafiolatam.yerkos.stresless.FabsCallback;
import cl.desafiolatam.yerkos.stresless.fragments.PendingsFragment;
import cl.desafiolatam.yerkos.stresless.R;
import cl.desafiolatam.yerkos.stresless.intefaces.SearchListener;
import cl.desafiolatam.yerkos.stresless.models.Pending;

public class PendingsActivity extends AppCompatActivity implements SearchListener, FabsCallback{

    private PendingsFragment pendingsFragment;
    private FloatingActionButton fab_main;
    private FloatingActionButton fab_second;
    private FloatingActionButton fab_third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pendingsFragment = (PendingsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        fab_main = findViewById(R.id.fab_main);
        fab_second = findViewById(R.id.fab_second);
        fab_third = findViewById(R.id.fab_third);

        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FabsAnimation(PendingsActivity.this).fabAnimation(view);
            }
        });

        fab_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                            pendingsFragment.updateList(pending);
                            showFabs();
                        }
                        dialog.dismiss();
                    }
                });

                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
                hideFabs();
            }
        });

        fab_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PendingsActivity.this,
                        "Desafío E4 - La base de datos en Android [ANIMACIONES]",
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    @Override
    public void searched(String name) {
        pendingsFragment.updateListByName(name);
    }

    @Override
    public void showFabs() {
        fab_main.animate().rotation(45).setDuration(400).start();
        fab_second.animate().translationX(-200).setDuration(600).start();
        fab_third.animate().translationX(-400).setDuration(800).start();
    }

    @Override
    public void hideFabs() {
        fab_main.animate().rotation(0).setDuration(400).start();
        fab_second.animate().translationX(0).setDuration(600).start();
        fab_third.animate().translationX(0).setDuration(800).start();
    }
}
