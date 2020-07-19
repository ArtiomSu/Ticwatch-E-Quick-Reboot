package terminal_heat_sink.fast_settings;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView power_off = (ImageView) findViewById(R.id.button_off);

        power_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process proc = Runtime.getRuntime()
                            .exec(new String[]{ "su", "-c", "reboot -p" });
                    proc.waitFor();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        ImageView reboot = (ImageView) findViewById(R.id.button_reboot);
        reboot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process proc = Runtime.getRuntime()
                            .exec(new String[]{ "su", "-c", "reboot" });
                    proc.waitFor();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        ImageView reboottwrp = (ImageView) findViewById(R.id.button_twrp);
        reboottwrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process proc = Runtime.getRuntime()
                            .exec(new String[]{ "su", "-c", "reboot recovery" });
                    proc.waitFor();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        ImageView rebootbootloader = (ImageView) findViewById(R.id.button_bootloader);
        rebootbootloader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process proc = Runtime.getRuntime()
                            .exec(new String[]{ "su", "-c", "reboot bootloader" });
                    proc.waitFor();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }
}
