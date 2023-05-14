package com.monir.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText weight, heightFit, heightInc;
    Button bmiCalculate;
    TextView displayBmi, displayBmiRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        heightFit = findViewById(R.id.heightFit);
        heightInc = findViewById(R.id.heightInc);
        bmiCalculate = findViewById(R.id.bmiCalculate);
        displayBmi = findViewById(R.id.displayBmi);
        displayBmiRate = findViewById(R.id.displayBmiRate);

        bmiCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sWeight = weight.getText().toString();
                String sFit = heightFit.getText().toString();
                String sInc = heightInc.getText().toString();

                //convert float
                Float fWeight = Float.parseFloat(sWeight);
                Float Fit = Float.parseFloat(sFit);
                Float Inc = Float.parseFloat(sInc);

                //bmi calculate
                Float height = (float) (Fit * 0.3048 + Inc * 0.0254);
                Float bmIndex = fWeight / (height * height);
                displayBmi.setText("Your BMI Index Is : " +bmIndex);
                if (bmIndex <= 18.5){
                    displayBmiRate.setText("You are Underweight Now !");
                }else if(bmIndex <=24.9) {
                    displayBmiRate.setText("You are Normal Now !");
                } else if (bmIndex <=29.9) {
                    displayBmiRate.setText("You are Overweight Now !");
                } else if (bmIndex >=30){
                    displayBmiRate.setText("You are Obesity Now !");
                }


            }
        });
    }
}