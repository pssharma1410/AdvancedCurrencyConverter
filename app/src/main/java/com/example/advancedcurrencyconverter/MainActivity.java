package com.example.advancedcurrencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void convert(View view){
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        if(rg1.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Select Currency \n that has to be converted", Toast.LENGTH_SHORT).show();
            return;
        }else if(rg2.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Select Currency you want", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton rbi = (RadioButton) findViewById(R.id.radioButton);
        RadioButton rbu = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton rbe = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton cbi = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton cbu = (RadioButton) findViewById(R.id.radioButton5);
        RadioButton cbe = (RadioButton) findViewById(R.id.radioButton6);
        double convvalue = 0;
        if(rbi.isChecked() && cbi.isChecked()){
            convvalue = 1.0;
            Toast.makeText(this, "Both the currencies are same", Toast.LENGTH_SHORT).show();
        }else if(rbi.isChecked() && cbu.isChecked()){
            convvalue = 0.013;
        }else if(rbi.isChecked() && cbe.isChecked()){
            convvalue = 0.012;
        }
        else if(rbu.isChecked() && cbi.isChecked()){
            convvalue = 74.34;
        }
        else if(rbu.isChecked() && cbu.isChecked()){
            convvalue = 1.0;
            Toast.makeText(this, "Both the currencies are same", Toast.LENGTH_SHORT).show();
        }
        else if(rbu.isChecked() && cbe.isChecked()){
            convvalue = 0.87;
        }
        else if(rbe.isChecked() && cbi.isChecked()){
            convvalue = 85.82;
        }
        else if(rbe.isChecked() && cbu.isChecked()){
            convvalue = 1.15;
        }
        else if(rbe.isChecked() && cbe.isChecked()){
            convvalue = 1.0;
            Toast.makeText(this, "Both the currencies are same", Toast.LENGTH_SHORT).show();
        }
        EditText tf = (EditText) findViewById(R.id.Input);
        if(tf.getText().toString().isEmpty()){
            Toast.makeText(this, "The value is empty!!", Toast.LENGTH_SHORT).show();
            return;
        }
        double in = Double.parseDouble(String.valueOf(tf.getText()));
        double newval = convvalue*in;
        double n = newval*100.0;
        newval = Math.round(n)/100.0;
        TextView c = (TextView) findViewById(R.id.converted);
        String ans = String.valueOf(newval);
        c.setText(ans);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}