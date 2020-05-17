package com.example.messagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView received;
    Button reply;
    EditText replyMessage;
    public static final String key_reply="com.example.messageDemo.key.reply";
    public static final int code=500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        received = findViewById(R.id.editReceived);
        reply=findViewById(R.id.buttonreply);
        replyMessage=findViewById(R.id.editreply);
        Intent intent = getIntent();
        String m = intent.getStringExtra(MainActivity.key_message);
        received.setText(m);

    }

    public void reply(View view) {
        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        String r=replyMessage.getText().toString().trim();
        if (r.isEmpty()){
            replyMessage.setError("type a reply");
        }
        else
            intent.putExtra(key_reply,r);
            setResult(RESULT_OK,intent);
            finish();
    }
}
