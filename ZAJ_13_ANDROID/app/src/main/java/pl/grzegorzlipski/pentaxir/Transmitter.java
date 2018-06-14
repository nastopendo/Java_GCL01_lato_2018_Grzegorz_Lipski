package pl.grzegorzlipski.pentaxir;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.Build;

import static android.content.Context.CONSUMER_IR_SERVICE;

public class Transmitter {

    private ConsumerIrManager consumerIrManager;

    public int frequency = 38000;
    public  int[] afPattern = {12844,2964,988,988,988,988,988,988,988,988,988,988,988,2964,988,26};
    public  int[] shootPattern = {12844,2964,988,988,988,988,988,988,988,988,988,988,988,988,988,988};

    public Transmitter(Context context) {
        this.consumerIrManager = (ConsumerIrManager) context.getSystemService(context.CONSUMER_IR_SERVICE);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void afTransmit() {
            consumerIrManager.transmit(frequency, afPattern);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void shootTransmit() {
        consumerIrManager.transmit(frequency, shootPattern);
    }
}