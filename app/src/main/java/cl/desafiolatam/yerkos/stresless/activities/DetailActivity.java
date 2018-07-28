package cl.desafiolatam.yerkos.stresless.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import cl.desafiolatam.yerkos.stresless.R;
import cl.desafiolatam.yerkos.stresless.data.Queries;
import cl.desafiolatam.yerkos.stresless.models.Pending;

public class DetailActivity extends AppCompatActivity {

    public static final String PENDING_ID = "cl.desafiolatam.yerkos.stresless.fragments.KEY.PENDING_ID";
    private Pending pending;
    private EditText descriptionEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        long id = getIntent().getLongExtra(PENDING_ID, 0L);
        pending = new Queries().byId(id);

        getSupportActionBar().setTitle("Nombre de la tarea: " + pending.getName());
        descriptionEt = findViewById(R.id.descriptionEt);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String description = descriptionEt.getText().toString();
        pending.setDescription(description);
        pending.save();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String description = pending.getDescription();
        if (description != null){
            descriptionEt.setText(description);
        } else {
            Toast.makeText(DetailActivity.this, "Esta tarea no tiene descripción por el momento. Escribe una.", Toast.LENGTH_LONG).show();
        }
    }
}
