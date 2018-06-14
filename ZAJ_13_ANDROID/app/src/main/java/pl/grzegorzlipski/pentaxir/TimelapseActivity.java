package pl.grzegorzlipski.pentaxir;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.*;

public class TimelapseActivity extends AppCompatActivity {

    public int numberOfInterval = 1;
    public int numberOfShots = 1;
    public int delay;
    public TextView photoLeft;
    public ProgressBar horizontalProgressBar;
    Thread photoLeftThread;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timelapse);

        photoLeftThread = new Thread() {
            int i=0;
            int progress = 100/numberOfShots;
            @Override
            public void run() {
                for(i = 0; i<numberOfShots-1; i++) {
                    progressStatus += progress;
                    try { sleep(numberOfInterval*1000); }
                    catch (InterruptedException e) {}

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            photoLeft.setText("Photo: " + (i+1) + "/" + numberOfShots);
                            horizontalProgressBar.setProgress(progressStatus);
                        }
                    });

//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            photoLeft.setText("Photo: " + (i+1) + "/" + numberOfShots);
//                        }
//                    });
                }
            }
        };
    }

    public void onTimelapseStartClick(View view){


        EditText intervalNumberText = (EditText) findViewById(R.id.intervalNumber);
        EditText shootsNumberText = (EditText) findViewById(R.id.shootsNumber);
        horizontalProgressBar = (ProgressBar) findViewById(R.id.horizontalProgressBar);
        ProgressBar circleProgressBar = (ProgressBar) findViewById(R.id.circleProgressBar);
        photoLeft = (TextView) findViewById(R.id.photoLeft);
        TextView timeLeft = (TextView) findViewById(R.id.timeLeft);

        numberOfInterval = Integer.parseInt(intervalNumberText.getText().toString());
        numberOfShots = Integer.parseInt(shootsNumberText.getText().toString());
        Transmitter transmitter = new Transmitter(getApplicationContext());
        photoLeftThread.start();

        for(int i = 0; i<numberOfShots; i++){

            transmitter.shootTransmit();
            //photoLeft.setText("Photo: " + (i+1) + "/" + numberOfShots);

            if(numberOfInterval == 0)
                delay = 400;
            else
                delay = numberOfInterval*1000;

            try {
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //SystemClock.sleep(delay);
        }
    }
}
