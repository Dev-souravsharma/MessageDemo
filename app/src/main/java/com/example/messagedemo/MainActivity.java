package com.example.messagedemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText message;
    Button send;
    TextView replyReceived;
    public static final String key_message="com.example.messageDemo.key.message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message=findViewById(R.id.editmessage);
        send=findViewById(R.id.editsend);
        replyReceived=findViewById(R.id.editreplyreceived);
    }

    public void send(View view) {
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        String m=message.getText().toString().trim();
        if (m.isEmpty()) {
            message.setError("type a message");
        }
        else{
        intent.putExtra(key_message,m);
        startActivityForResult(intent,Main2Activity.code);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==Main2Activity.code){
            if (resultCode==RESULT_OK){
                assert data != null;
                String activityData=data.getStringExtra(Main2Activity.key_reply);
                Log.d("sourav", "onActivityResult: "+activityData);
                replyReceived.setVisibility(View.VISIBLE);
                replyReceived.setText(activityData);
            }
        }
    }
}
