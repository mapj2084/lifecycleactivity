package ec.edu.tecnologicoloja.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityB extends AppCompatActivity {
    private Button mButtonActivityA;
    private Button mButtonActivityC;
    private Button mButtonFinishActivityB;
    private Button mButtonStartDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // Set views
        mButtonActivityA = (Button) findViewById(R.id.btn_start_a);
        mButtonActivityC = (Button) findViewById(R.id.btn_start_c);
        mButtonFinishActivityB = (Button) findViewById(R.id.btn_finish_b);
        mButtonStartDialog = (Button) findViewById(R.id.btn_start_dialog);

        // Set Listeners
        mButtonActivityA.setOnClickListener(startActivityAListener);
        mButtonActivityC.setOnClickListener(startActivityCListener);
        mButtonFinishActivityB.setOnClickListener(finishActivityBListener);
        mButtonStartDialog.setOnClickListener(startDialogListener);
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

    public void startActivityA() {
        Intent intent = new Intent(ActivityB.this, ActivityA.class);
        startActivity(intent);
    }

    public void startActivityC() {
        Intent intent = new Intent(ActivityB.this, ActivityC.class);
        startActivity(intent);
    }

    public void finishActivityB() {
        ActivityB.this.finish();
    }

    // Listeners
    private View.OnClickListener startActivityAListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            startActivityA();
        }
    };

    private View.OnClickListener startActivityCListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            startActivityC();
        }
    };

    private View.OnClickListener finishActivityBListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            finishActivityB();
        }
    };

    private View.OnClickListener startDialogListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            showDialog();
        }
    };
}
