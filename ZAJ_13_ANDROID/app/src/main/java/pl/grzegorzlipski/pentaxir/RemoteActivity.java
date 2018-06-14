package pl.grzegorzlipski.pentaxir;

import android.hardware.ConsumerIrManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.hardware.ConsumerIrManager.CarrierFrequencyRange;
import android.widget.Toast;

public class RemoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);

    }

    public void onRemoteAfClick(View view){
        Transmitter transmitter = new Transmitter(getApplicationContext());
        transmitter.afTransmit();
        Toast.makeText(this,"Autofocus", Toast.LENGTH_SHORT).show();
    }

    public void onRemoteShootClick(View view){
        Transmitter transmitter = new Transmitter(getApplicationContext());
        transmitter.shootTransmit();
        Toast.makeText(this,"Shoot", Toast.LENGTH_SHORT).show();
    }
}
