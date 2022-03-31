package ma.emsi.second_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    TextView logo ;
    TextView findDoc;
    LottieAnimationView lottie;
    Thread t = new Thread(){
        @Override
        public void run() {
            try {
                sleep(5000);
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = findViewById(R.id.logo);
        lottie =findViewById(R.id.lottie);

        lottie.animate().translationY(-1400).setDuration(1500).setStartDelay(4000);
        logo.animate().translationY(1800).setDuration(1500).setStartDelay(4000);
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5030);
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();




    }
}