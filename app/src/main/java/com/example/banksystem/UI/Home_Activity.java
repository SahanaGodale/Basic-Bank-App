package com.example.banksystem.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.banksystem.R;

public class Home_Activity extends AppCompatActivity {
    TextView textView,textView2;
    Button btnView,btntransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView=findViewById(R.id.textview1);
        textView2=findViewById(R.id.textview2);
        btnView=findViewById(R.id.btnView);
        btnView=findViewById(R.id.btntransaction);

        setTextViewColor(textView,getResources().getColor(R.color.blue),
                getResources().getColor(R.color.green));
        setTextViewColor1(textView2,getResources().getColor(R.color.blue),
                getResources().getColor(R.color.green));
    }
    private void setTextViewColor(TextView textView,int...color){
        TextPaint paint=textView.getPaint();
        float width=paint.measureText(textView.getText().toString());
        Shader shader=new LinearGradient(0,0,width,textView.getTextSize(),color,null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
        textView.setTextColor(color[0]);
    }
    private void setTextViewColor1(TextView textView2,int...color){
        TextPaint paint=textView2.getPaint();
        float width=paint.measureText(textView2.getText().toString());
        Shader shader=new LinearGradient(0,0,width,textView2.getTextSize(),color,null,Shader.TileMode.CLAMP);
        textView2.getPaint().setShader(shader);
        textView2.setTextColor(color[0]);
    }

    public void showAllUsers(View view) {
        Intent intent = new Intent(this, UsersList.class);
        startActivity(intent);
    }

    public void showAllTransactions(View view) {
        Intent intent = new Intent(this, TransactionHistory.class);
        startActivity(intent);
    }
}
