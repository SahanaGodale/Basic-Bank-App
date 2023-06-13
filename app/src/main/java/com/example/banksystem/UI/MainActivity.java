package com.example.banksystem.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.banksystem.R;

public class MainActivity extends AppCompatActivity {
    TextView spay;
    private static int splash_timeout=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spay=findViewById(R.id.textview1);
        setTextViewColor(spay,getResources().getColor(R.color.blue),
                getResources().getColor(R.color.green));
                new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, Home_Activity.class);
                startActivity(intent);
                finish();
            }
        },splash_timeout);
        Animation myanimation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation1);
        spay.startAnimation(myanimation);

    }
    private void setTextViewColor(TextView spay,int...color){
        TextPaint paint=spay.getPaint();
        float width=paint.measureText(spay.getText().toString());
        Shader shader=new LinearGradient(0,0,width,spay.getTextSize(),color,null,Shader.TileMode.CLAMP);
        spay.getPaint().setShader(shader);
        spay.setTextColor(color[0]);
    }
}