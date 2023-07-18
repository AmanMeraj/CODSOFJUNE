package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] bodmasRule = {"/","x","\\+","-"};
    private int currentRule=0;
    RelativeLayout Calculatortv;
    TextView calculationTv,ResultTv;
    LinearLayout linearLayout,line1,line2,line3,line4,line5;
    CardView Ac,Back,Percent,Divide,Add,Substract,Multiply,equals,dot,N1,N2,N3,N4,N5,N6,N7,N8,N9,N0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calculatortv=findViewById(R.id.calculator_tv);
        calculationTv=findViewById(R.id.calculation_tv);
        ResultTv=findViewById(R.id.result_tv);
        linearLayout=findViewById(R.id.linear);
        line1=findViewById(R.id.line1);
        line2=findViewById(R.id.line2);
        line3=findViewById(R.id.line3);
        line4=findViewById(R.id.line4);
        line5=findViewById(R.id.line5);
        Ac=findViewById(R.id.AC);
        Back=findViewById(R.id.back_card);
        Percent=findViewById(R.id.percentage);
        Divide=findViewById(R.id.divide);
        Add=findViewById(R.id.plus);
        Substract=findViewById(R.id.minus);
        Multiply=findViewById(R.id.multiply);
        equals=findViewById(R.id.equals);
        dot=findViewById(R.id.dot);
        N0=findViewById(R.id.zero);
        N1=findViewById(R.id.one);
        N2=findViewById(R.id.two);
        N3=findViewById(R.id.three);
        N4=findViewById(R.id.four);
        N5=findViewById(R.id.five);
        N6=findViewById(R.id.six);
        N7=findViewById(R.id.seven);
        N8=findViewById(R.id.eight);
        N9=findViewById(R.id.nine);

        Ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           ResultTv.setText(" ");
           calculationTv.setText(" ");
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Calculate=calculationTv.getText().toString();

                if(!Calculate.isEmpty()){
                    calculationTv.setText(Calculate.substring(0,Calculate.length()-1));
                }
            }
        });
        Percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Calculate=calculationTv.getText().toString();
                if(Calculate.isEmpty()){
                    calculationTv.setText("0/");
                }else{
                    final char lastchar=Calculate.charAt(calculationTv.length()-1);

                    if(lastchar=='+'||lastchar=='-'||lastchar=='/'||lastchar=='x'){
                        calculationTv.setText(Calculate.substring(0,Calculate.length()-1)+ "/");
                    }else{
                        calculationTv.setText(Calculate+'/');
                    }
                }
            }
        });
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            final String Calculate=calculationTv.getText().toString();
            if(Calculate.isEmpty()){
                calculationTv.setText("0+");
            }else{
                final char lastchar=Calculate.charAt(calculationTv.length()-1);

                if(lastchar=='+'||lastchar=='-'||lastchar=='/'||lastchar=='x'){
                    calculationTv.setText(Calculate.substring(0,Calculate.length()-1)+ "+");
                }else{
                    calculationTv.setText(Calculate+'+');
                }
            }
            }
        });
        Substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Calculate=calculationTv.getText().toString();
                if(Calculate.isEmpty()){
                    calculationTv.setText("0-");
                }else{
                    final char lastchar=Calculate.charAt(calculationTv.length()-1);

                    if(lastchar=='+'||lastchar=='-'||lastchar=='/'||lastchar=='x'){
                        calculationTv.setText(Calculate.substring(0,Calculate.length()-1)+ "-");
                    }else{
                        calculationTv.setText(Calculate+'-');
                    }
                }

            }
        });
        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Calculate=calculationTv.getText().toString();
                if(Calculate.isEmpty()){
                    calculationTv.setText("0x");
                }else{
                    final char lastchar=Calculate.charAt(calculationTv.length()-1);

                    if(lastchar=='+'||lastchar=='-'||lastchar=='/'||lastchar=='x'){
                        calculationTv.setText(Calculate.substring(0,Calculate.length()-1)+ "x");
                    }else{
                        calculationTv.setText(Calculate+'x');
                    }
                }
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            final String Calculate=calculationTv.getText().toString();
            if(Calculate.contains("+")||Calculate.contains("-")||Calculate.contains("/")||Calculate.contains("x")){
                final char lastChar=Calculate.charAt(Calculate.length()-1);
                if(lastChar!='+'||lastChar !='-'||lastChar !='/'||lastChar !='x'){
                   Calculate(calculationTv,ResultTv,Calculate);
                }
            }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Caluclate=calculationTv.getText().toString();
                calculationTv.setText(Caluclate+".");
            }
        });
        N0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            final String Caluclate=calculationTv.getText().toString();
            calculationTv.setText(Caluclate+"0");
            }
        });
        N1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Caluclate=calculationTv.getText().toString();
                calculationTv.setText(Caluclate+"1");
            }
        });
        N2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Caluclate=calculationTv.getText().toString();
                calculationTv.setText(Caluclate+"2");
            }
        });
        N3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Caluclate=calculationTv.getText().toString();
                calculationTv.setText(Caluclate+"3");
            }
        });
        N4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Caluclate=calculationTv.getText().toString();
                calculationTv.setText(Caluclate+"4");
            }
        });
        N5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Caluclate=calculationTv.getText().toString();
                calculationTv.setText(Caluclate+"5");
            }
        });
        N6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Caluclate=calculationTv.getText().toString();
                calculationTv.setText(Caluclate+"6");
            }
        });
        N7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Caluclate=calculationTv.getText().toString();
                calculationTv.setText(Caluclate+"7");
            }
        });
        N8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Caluclate=calculationTv.getText().toString();
                calculationTv.setText(Caluclate+"8");
            }
        });
        N9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Caluclate=calculationTv.getText().toString();
                calculationTv.setText(Caluclate+"9");
            }
        });


    }
    private void Calculate(TextView calculationTv,TextView resultTv,String Calculate){
        String Cal2= Calculate;
        while(true){

            if (currentRule==2 && !Cal2.contains("+")){
                currentRule++;
                continue;
            }else if(currentRule!=2 && !Cal2.contains(bodmasRule[currentRule])){
                if(currentRule==3){
                    break;
                }else{
                    currentRule++;
                    continue;
                }
            }
            String expArr[]=Cal2.split(bodmasRule[currentRule]);

            if(expArr.length==1||expArr[0].isEmpty()){
                break;
            }
            StringBuilder firstVal= new StringBuilder();
            StringBuilder scndVal= new StringBuilder();

            for(int i= expArr[0].length()-1;i >= 0;i--){
                if(expArr[0].charAt(i)=='+'||expArr[0].charAt(i)=='-'||expArr[0].charAt(i)=='/'||expArr[0].charAt(i)=='x'){
                    break;
                }else{
                    firstVal.insert(0,expArr[0].charAt(i));
                }
            }
            for(int i=0;i<expArr[1].length();i++){
                if(expArr[1].charAt(i)=='+'||expArr[1].charAt(i)=='-'||expArr[1].charAt(i)=='/'||expArr[1].charAt(i)=='x'){
                    break;
                }else{
                    scndVal.append(expArr[1].charAt(i));
                }
            }
            double results;

            switch (bodmasRule[currentRule]){
                case "/":
                    results=Double.parseDouble(firstVal.toString())/Double.parseDouble(scndVal.toString());
//
                    break;
                case "x":
                    results=Double.parseDouble(firstVal.toString())*Double.parseDouble(scndVal.toString());
                    break;
                case "+":
                case "\\+":
                    results=Double.parseDouble(firstVal.toString())+Double.parseDouble(scndVal.toString());
                    break;
                case  "-":
                    results=Double.parseDouble(firstVal.toString())-Double.parseDouble(scndVal.toString());
                    break;

                case "%":
                    results=Double.parseDouble(firstVal.toString())%Double.parseDouble(scndVal.toString());
                    break;


                default:
                    results=0;
            }
            Cal2=Cal2.replaceFirst(firstVal+bodmasRule[currentRule]+scndVal,String.valueOf(results));
        }
        currentRule=0;
        resultTv.setText(Calculate);
        String[] finalArray=Cal2.split("\\.");
        Log.d("TAG", "Calculate: "+Cal2);;


        if(!Cal2.matches("Infinity")&&finalArray[1].length() == 1 && finalArray[1].equals("0")){
            resultTv.setText(finalArray[0]);
        }else{
            resultTv.setText(Cal2);
}

    }
}