package com.example.chihiroiijima.testsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOK = (Button)findViewById(R.id.button9);
        Button btnCancel = (Button)findViewById(R.id.button10);


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etxtBrickTitle = (EditText) findViewById(R.id.editText);
                EditText etxtBrickDNA = (EditText) findViewById(R.id.editText2);
                EditText etxtBrickMemo = (EditText) findViewById(R.id.editText3);
                RadioButton rbtn1 = (RadioButton) findViewById(R.id.radioButton);
                RadioButton rbtn2 = (RadioButton) findViewById(R.id.radioButton);
                RadioButton rbtn3 = (RadioButton) findViewById(R.id.radioButton);

                TextView txtResultPass = (TextView) findViewById(R.id.textView6);

                String strBrickTitle = etxtBrickTitle.getText().toString();
                String strBrickDNA = etxtBrickDNA.getText().toString();
                String strBrickMemo = etxtBrickMemo.getText().toString();

                String kind = new String();

                if (rbtn1.isChecked() == true) {
                    kind = "0";
                } else if (rbtn2.isChecked() == true) {
                    kind = "1";
                } else {
                    kind = "2";
                }

                AsyncDB addDB = new AsyncDB();
                addDB.setPassByAsyncDB(strBrickTitle, strBrickDNA, kind, strBrickMemo);
                txtResultPass.setText(addDB.getPassByAsyncDB());
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v){
                AsyncDB loadDB = new AsyncDB();
                loadDB.setBrickDataByAsyncDB("QlU3DpED");
            }
        });
    }


}
