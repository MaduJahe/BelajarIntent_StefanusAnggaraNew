package com.example.belajarintent_stefanusanggaranew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_mengirim_pesan extends AppCompatActivity {
    private static final String LOG_TAG = activity_mengirim_pesan.class.getSimpleName();

    public static final String EXTRA_MESSAGE = "com.example.belajarintent_stefanusanggaranew.extra.MESSAGE";

    public static final int TEXT_REQUEST = 1 ;

    private EditText mMessageEditText;

    private TextView penerima;

    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mengirim_pesan);

        mMessageEditText = (EditText) findViewById(R.id.editText_Main);
        penerima = (TextView) findViewById(R.id.text_header);
        mReplyTextView = (TextView) findViewById(R.id.text_message);

        Intent intent = getIntent();
        String kontak = intent.getStringExtra(MainActivity.KONTAK);
        penerima.setText(kontak);
    }

    public void launchSecondActivity(View view){
        Log.d(LOG_TAG, "Button clicked!");

        Intent intent = new Intent(this, activity_penerima_pesan.class);
        String message = mMessageEditText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra(activity_penerima_pesan.EXTRA_REPLY);

                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}