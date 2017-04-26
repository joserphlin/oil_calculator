package com.cz.myapplication;

import android.icu.text.DecimalFormat;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.cz.myapplication.R.string.d;

public class MainActivity extends AppCompatActivity {
    String d1, h1, l1, p1;



    double v,p,l,s,m,d,h;
    double s1,s2;

//    int a;
//    int d,l,p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void react(View view) {
        EditText d_text = (EditText) findViewById(R.id.d_editText);
        EditText l_text = (EditText) findViewById(R.id.l_editText);
        EditText h_text = (EditText) findViewById(R.id.h_editText);
        EditText p_text = (EditText) findViewById(R.id.p_editText);
        d1 = d_text.getText().toString();
        l1 = l_text.getText().toString();
        h1 = h_text.getText().toString();
        p1 = p_text.getText().toString();
        d = Double.parseDouble(d1);
        l = Double.parseDouble(l1);
        h = Double.parseDouble(h1);
        p = Double.parseDouble(p1);
        cal();
    }

    public void cal() {
        double r;
        r = d / 2;
        if (h <= r) {
            s = (Math.acos(((r - h) / r))) * r * r - (r - h) * Math.sqrt(2 * r * h - h * h);
            v = (int)((s * l)/1000);
            m = (v * p)/1000;
            System.out.println("h <= r");
            System.out.println("r"+r);
            System.out.println("h"+h);
            System.out.println("s"+s);
            System.out.println("v"+v);
            System.out.println("m"+m);
            String String_v = String.valueOf(v);
            String String_m = String.valueOf(m);
            v_display(String_v);
            m_display(String_m);
        }
//        }
        else if (h > r & h <= d) {
            s = Math.PI * r * r - ((Math.acos(((h - r) / r))) * r * r - (h - r) * Math.sqrt(2 * r * (d - h) - (d - h) * (d - h)));
            v = ( int )((s * l)/1000);
            m = ((v * p))/1000;
            System.out.println("h>r&h<d");
            System.out.println("r"+r);
            System.out.println("h"+h);
            System.out.println("s"+s);
            System.out.println("v"+v);
            System.out.println("m"+m);
            String String_v = String.valueOf(v);
            String String_m = String.valueOf(m);
            v_display(String_v);
            m_display(String_m);
        } else {
            System.out.println("error");
            v_display("数据错误");
            m_display("数据错误");
        }
    }


    public void v_display(String number) {
        TextView textview = (TextView) findViewById(R.id.v_text);
        textview.setText("" + number);
    }
    public void m_display(String number) {
        TextView textview = (TextView) findViewById(R.id.m_text);
        textview.setText("" + number);
    }
}


