package com.app.swachhbharat;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class MainActivity extends AppCompatActivity {
    private LottieAnimationView cleanLoading,bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("hello","Running");
        final RelativeLayout main_layout = findViewById(R.id.main_layout);
        main_layout.setVisibility(View.GONE);
        cleanLoading = findViewById(R.id.loading_animation);
        cleanLoading.setVisibility(View.VISIBLE);
        cleanLoading.playAnimation();
        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {

                cleanLoading.pauseAnimation();
                cleanLoading.setVisibility(View.GONE);
                main_layout.setVisibility(View.VISIBLE);
                final GoogleSignInAccount googleSignIn = GoogleSignIn.getLastSignedInAccount(MainActivity.this);
                if (googleSignIn != null) {
                    Intent intent = new Intent(MainActivity.this,Login.class);
                    startActivity(intent);
                }
            }
        },8000);
    }
    public void upload(View view){
        Intent intent = new Intent(MainActivity.this,Upload.class);
        startActivity(intent);
    }
}
