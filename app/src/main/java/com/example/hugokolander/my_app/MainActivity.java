package com.example.hugokolander.my_app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final EditText url_field = (EditText)findViewById(R.id.editText3);
       final TextView error = (TextView)findViewById(R.id.textView3);

        url_field.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(v.getText().toString().matches("^(https|www|http).+")){
                     error.setText("");
                     String url = url_field.getText().toString();
                     Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                     try{
                         startActivity(i);
                     }catch(Exception e){
                         error.setText("enter a valid url starting with http(s) or www");
                     }



                }else{
                    error.setText("enter a valid url starting with http(s) or www");
                    url_field.setText("");
                }





                return false;
            }
        });







    }
}
