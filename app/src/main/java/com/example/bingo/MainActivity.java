package com.example.bingo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonRendom;
    private int count;
    private TextView result;
    private boolean flag1,flag2,flag3,flag4,flag5,flag6,flag7,flag8,flag9;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.textView_result);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent);
            }
        });

        button1 = (Button)findViewById(R.id.button_num1);
        button2 = (Button)findViewById(R.id.button_num2);
        button3 = (Button)findViewById(R.id.button_num3);
        button4 = (Button)findViewById(R.id.button_num4);
        button5 = (Button)findViewById(R.id.button_num5);
        button6 = (Button)findViewById(R.id.button_num6);
        button7 = (Button)findViewById(R.id.button_num7);
        button8 = (Button)findViewById(R.id.button_num8);
        button9 = (Button)findViewById(R.id.button_num9);

        buttonRendom = (Button)findViewById(R.id.button_Random);

        buttonRendom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                result.setText("");
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                button5.setEnabled(true);
                button6.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                button9.setEnabled(true);
                flag1=false;
                flag2=false;
                flag3=false;
                flag4=false;
                flag5=false;
                flag6=false;
                flag7=false;
                flag8=false;
                flag9=false;

                int[] arr = new int[9];
                Boolean flag;
                for (int i=0;i<9;i++){
                    do{
                        arr[i] = (int) (Math.random()*50)+1;
                        flag = false;
                        if (i!=0){
                            for(int j=0;j<i;j++) {
                                if(arr[i]==arr[j])
                                    flag = true;
                            }
                        }
                    }while(flag);
                }
                button1.setText(String.valueOf(arr[0]));
                button2.setText(String.valueOf(arr[1]));
                button3.setText(String.valueOf(arr[2]));
                button4.setText(String.valueOf(arr[3]));
                button5.setText(String.valueOf(arr[4]));
                button6.setText(String.valueOf(arr[5]));
                button7.setText(String.valueOf(arr[6]));
                button8.setText(String.valueOf(arr[7]));
                button9.setText(String.valueOf(arr[8]));

            }
        });

        button1.setOnClickListener(new mybutton());
        button2.setOnClickListener(new mybutton());
        button3.setOnClickListener(new mybutton());
        button4.setOnClickListener(new mybutton());
        button5.setOnClickListener(new mybutton());
        button6.setOnClickListener(new mybutton());
        button7.setOnClickListener(new mybutton());
        button8.setOnClickListener(new mybutton());
        button9.setOnClickListener(new mybutton());


    }

    private class mybutton implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button_num1:
                    button1.setEnabled(false);
                    flag1 = true;
                    checkBingo();
                    break;
                case R.id.button_num2:
                    button2.setEnabled(false);
                    flag2 = true;
                    checkBingo();
                    break;
                case R.id.button_num3:
                    button3.setEnabled(false);
                    flag3 = true;
                    checkBingo();
                    break;
                case R.id.button_num4:
                    button4.setEnabled(false);
                    flag4 = true;
                    checkBingo();
                    break;
                case R.id.button_num5:
                    button5.setEnabled(false);
                    flag5 = true;
                    checkBingo();
                    break;
                case R.id.button_num6:
                    button6.setEnabled(false);
                    flag6 = true;
                    checkBingo();
                    break;
                case R.id.button_num7:
                    button7.setEnabled(false);
                    flag7 = true;
                    checkBingo();
                    break;
                case R.id.button_num8:
                    button8.setEnabled(false);
                    flag8 = true;
                    checkBingo();
                    break;
                case R.id.button_num9:
                    button9.setEnabled(false);
                    flag9 = true;
                    checkBingo();
                    break;
            }

        }
    }

    public void checkBingo(){
        count=0;
        if((flag1&&flag2&&flag3)==true)
            count++;
        if((flag4&&flag5&&flag6)==true)
            count++;
        if((flag7&&flag8&&flag9)==true)
            count++;
        if((flag1&&flag4&&flag7)==true)
            count++;
        if((flag2&&flag5&&flag8)==true)
            count++;
        if((flag3&&flag6&&flag9)==true)
            count++;
        if((flag1&&flag5&&flag9)==true)
            count++;
        if((flag3&&flag5&&flag7)==true)
            count++;
        if(count>=2){
            result.setText("BINGO!!!");
            count=0;
        }
    }
}