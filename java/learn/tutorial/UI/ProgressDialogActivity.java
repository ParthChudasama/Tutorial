package learn.tutorial.UI;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import learn.tutorial.R;

import static android.R.attr.handle;

public class ProgressDialogActivity extends AppCompatActivity {
 ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);

       Button btn = (Button) findViewById(R.id.progress);
        btn.setOnClickListener(new View.OnClickListener() {

            Handler handle = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    pd.incrementProgressBy(1);
                }
            };

            @Override
            public void onClick(View view) {
                pd = new ProgressDialog(ProgressDialogActivity.this);
                pd.setMax(100);
                pd.setMessage("Its loading....");
                pd.setTitle("ProgressDialog bar example");
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd.setCancelable(false);
                pd.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (pd.getProgress() <= pd
                                    .getMax()) {
                                Thread.sleep(200);
                                handle.sendMessage(handle.obtainMessage());
//                                The above line activates the handler in which we write the code to increment the progress bar.
                                if (pd.getProgress() == pd
                                        .getMax()) {
                                    pd.dismiss();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }


        });
    }
}
