package com.example.add;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.ToggleButton;
import android.widget.ViewAnimator;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private Button btn;
    private CheckBox cv1,cv2;
    private RadioGroup rg;
    private RadioButton rb1,rb2,rb3,rb4;
    private RelativeLayout re;
    private ToggleButton tb;
    private Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView act=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        String[] select=getResources().getStringArray(R.array.select_array);

        ArrayAdapter<String>adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,select);
        act.setAdapter(adapter);
        cv1=findViewById(R.id.checkBox);
        cv2=findViewById(R.id.checkBox2);
        sp=findViewById(R.id.spinner);
        re=findViewById(R.id.re);
        tb=findViewById(R.id.toggleButton);

        rg=findViewById(R.id.gr);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);
        rb4=findViewById(R.id.radioButton4);
        tb.setOnCheckedChangeListener(this);
        cv1.setOnCheckedChangeListener(this);
        cv2.setOnCheckedChangeListener(this);
        rg.setOnCheckedChangeListener(this);


        String[] arr=getResources().getStringArray(R.array.xia);
        ArrayAdapter<String>st=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,arr);
        sp.setAdapter(st);

    }
    public void onClick(View v){
        Log.i("hello","word");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.checkBox:
                if (b)
                    cv1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                else
                    cv1.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                break;
            case R.id.checkBox2:

                if (b)
                    cv2.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                else
                    cv2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                break;
            case R.id.toggleButton:
                if (b)
                    re.setBackgroundColor(Color.BLACK);

                else
                    re.setBackgroundColor(Color.WHITE);

            }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.radioButton:
                rb1.setTextColor(Color.RED);
                rb2.setTextColor(Color.RED);
                rb3.setTextColor(Color.RED);
                rb4.setTextColor(Color.RED);
                break;
            case R.id.radioButton2:
                rb1.setTextColor(Color.BLUE);
                rb2.setTextColor(Color.BLUE);
                rb3.setTextColor(Color.BLUE);
                rb4.setTextColor(Color.BLUE);
                break;
            case R.id.radioButton3:
                rb1.setTextColor(Color.GREEN);
                rb2.setTextColor(Color.GREEN);
                rb3.setTextColor(Color.GREEN);
                rb4.setTextColor(Color.GREEN);
                break;
            case R.id.radioButton4:
                rb1.setTextColor(Color.parseColor("#4d1256"));
                rb2.setTextColor(Color.parseColor("#4d1256"));
                rb3.setTextColor(Color.parseColor("#4d1256"));
                rb4.setTextColor(Color.parseColor("#4d1256"));
                break;
        }
    }
}
