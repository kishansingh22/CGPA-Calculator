package com.example.shashank.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateCGPA extends AppCompatActivity {

    private EditText s1;
    private EditText s2;
    private EditText s3;
    private EditText s4;
    private EditText s5;
    private EditText s6;
    private EditText s7;
    private EditText s8;

    public TextView txtresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_cgpa);


        s1 = (EditText)findViewById(R.id.sub1);
        s2 = (EditText)findViewById(R.id.sub2);
        s3 = (EditText)findViewById(R.id.sub3);
        s4 = (EditText)findViewById(R.id.sub4);
        s5 = (EditText)findViewById(R.id.sub5);
        s6 = (EditText)findViewById(R.id.sub6);
        s7 = (EditText)findViewById(R.id.sub7);
        s8 = (EditText)findViewById(R.id.sub8);
        Button btnCGPA = (Button) findViewById(R.id.btnadd);
        txtresult= (TextView) findViewById(R.id.result);

        // Division
        btnCGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((s1.getText().length()>0) && (s2.getText().length()>0) && (s3.getText().length()>0) && (s4.getText().length()>0) && (s5.getText().length()>0) && (s6.getText().length()>0) && (s7.getText().length()>0) && (s8.getText().length()>0))
                {
                    String rm = (s1.getText().toString());
                    String ds = (s2.getText().toString());
                    String dsl = (s3.getText().toString());
                    String pyl = (s4.getText().toString());
                    String ct = (s5.getText().toString());
                    String np = (s6.getText().toString());
                    String mth = (s7.getText().toString());
                    String py = (s8.getText().toString());

                    double rmg = getValueOfSubject(rm);
                    double dsg = getValueOfSubject(ds);
                    double dslg = getValueOfSubject(dsl);
                    double pylg = getValueOfSubject(pyl);
                    double ctg = getValueOfSubject(ct);
                    double npg = getValueOfSubject(np);
                    double mthg = getValueOfSubject(mth);
                    double pyg = getValueOfSubject(py);

                    int rmc =2;
                    int  dsc= 3;
                    int dslc = 2;
                    int pylc = 2;
                    int ctc = 4;
                    int npc = 3;
                    int mthc = 4;
                    int pyc = 3;

                    double totalCredit = 23.0;
                    double total = (rmg*rmc)+(dsg*dsc)+(dslg*dslc)+(pylg*pylc)+(ctg*ctc)+(npg*npc)+(mthg*mthc)+(pyg*pyc);

                    double result = total / totalCredit;
                    String cgpa = String.format("%.03f",result);
                    txtresult.setText(String.valueOf("Your CGPA : " + cgpa));
                    Toast toast= Toast.makeText(CalculateCGPA.this,"CGPA = "+result,Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    Toast toast= Toast.makeText(CalculateCGPA.this,"Enter The Valid Value",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });


    }

    private double getValueOfSubject(String grade) {
        switch (grade) {
            case "O":
                return 10;
            case "A+":
                return 9;
            case "A":
                return 8;
            case "B+":
                return 7;
            case "B":
                return 6;
        }
        return  0;


    }
}