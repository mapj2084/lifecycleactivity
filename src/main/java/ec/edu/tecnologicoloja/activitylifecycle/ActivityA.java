package ec.edu.tecnologicoloja.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityA extends AppCompatActivity implements View.OnClickListener{

    private Button mButtonActivityB;
    private Button mButtonActivityC;
    private Button mButtonFinishActivityA;
    private Button mButtonStartDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        // Set views
        mButtonActivityB = (Button) findViewById(R.id.btn_start_b);
        mButtonActivityC = (Button) findViewById(R.id.btn_start_c);
        mButtonFinishActivityA = (Button) findViewById(R.id.btn_finish_a);
        mButtonStartDialog = (Button) findViewById(R.id.btn_start_dialog);

        // Set Listeners
        mButtonActivityB.setOnClickListener(this);
        mButtonActivityC.setOnClickListener(this);
        mButtonFinishActivityA.setOnClickListener(this);
        mButtonStartDialog.setOnClickListener(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Add the buttons
        builder.setPositiveButton(R.string.dialog_ok_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(R.string.dialog_cancel_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                dialog.dismiss();
            }
        });
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_message);
        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void startActivityB() {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }

    public void startActivityC() {
        Intent intent = new Intent(ActivityA.this, ActivityC.class);
        startActivity(intent);
    }

    public void finishActivityA() {
        ActivityA.this.finish();
    }

    @Override
    public void onClick(View v) {
        if (v == mButtonActivityB) {
            startActivityB();
        } else if (v == mButtonActivityC) {
            startActivityC();
        } else if (v == mButtonFinishActivityA) {
            finishActivityA();
        } else if (v == mButtonStartDialog) {
            showDialog();
        }
    }
}
