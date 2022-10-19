package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    Button btnAdd, btnSub, btnMult, btnDiv, btnComma, btnBack, btn1, btn2, btn3, btn4, btn5,
            btn6, btn7, btn8, btn9, btn0, btnRes, btnCe, btnC;
    TextView tvResult, tvInfo;
    BigDecimal a, b, res;
    String oper = "";
    boolean comma = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        tvResult = (TextView) findViewById(R.id.tvResault);
        btnRes = (Button) findViewById(R.id.btnRes);
        btnComma = (Button) findViewById(R.id.btnComma);
        btnBack = (Button) findViewById(R.id.btnBack);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnCe = (Button) findViewById(R.id.btnCe);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        btnC = (Button) findViewById(R.id.btnC);


        btnComma.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnRes.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnCe.setOnClickListener(this);
        btnC.setOnClickListener(this);
    }

    public void aFormar() {
        //a = Float.parseFloat(tvResult.getText().toString());
        a=BigDecimal.valueOf(Double.valueOf(tvResult.getText().toString()));
        tvResult.setText("");

        //tvInfo.append("\n" + new Float(a).toString().replaceAll("\\.?0*$", "") + " " + oper + " ");
        tvInfo.append("\n" + a.toString().replaceAll("\\.?0*$", "") + " " + oper + " ");
        comma = true;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnAdd:
                oper = "+";
                aFormar();
                break;
            case R.id.btnSub:
                oper = "-";
                aFormar();
                break;
            case R.id.btnDiv:
                oper = "/";
                aFormar();
                break;
            case R.id.btnMult:
                oper = "*";
                aFormar();
                break;
            case R.id.btn0:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("0.0");
                    comma = false;
                } else {
                    tvResult.append("0");
                }
                break;
            case R.id.btn1:
                tvResult.append("1");
                break;
            case R.id.btn2:
                tvResult.append("2");
                break;
            case R.id.btn3:
                tvResult.append("3");
                break;
            case R.id.btn4:
                tvResult.append("4");
                break;
            case R.id.btn5:
                tvResult.append("5");
                break;
            case R.id.btn6:
                tvResult.append("6");
                break;
            case R.id.btn7:
                tvResult.append("7");
                break;
            case R.id.btn8:
                tvResult.append("8");
                break;
            case R.id.btn9:
                tvResult.append("9");
                break;
            case R.id.btnCe:
                tvResult.setText("");
                tvInfo.setText("");
                comma = true;
                break;
            case R.id.btnC:
                tvResult.setText("");
                comma = true;
                break;
            case R.id.btnComma:
                if (TextUtils.isEmpty(tvResult.getText().toString())) {
                    tvResult.append("0.");
                    comma = false;
                }
                if (comma == true) {
                    tvResult.append(".");
                    comma = false;
                }
                break;
            case R.id.btnBack:
                String s=tvResult.getText().toString();
                s= s.substring(0,(s.length()-1));
                tvResult.setText(s);
                break;
            default:
                break;
        }
        if (view.getId() == R.id.btnRes) {
            //b = Float.parseFloat(tvResult.getText().toString());
            b=BigDecimal.valueOf(Double.valueOf(tvResult.getText().toString()));
            switch (oper) {
                case "+":
                    res = a.add(b);
                    break;
                case "-":
                    res = a.subtract(b);
                    break;
                case "/":
                    res = a.divide(b);
                    break;
                case "*":
                    res = a.multiply(b);
                    break;
            }
//            tvResult.setText(new Float(res).toString().replaceAll("\\.?0*$", ""));
//            tvInfo.append(new Float(b).toString().replaceAll("\\.?0*$", "") + " = " + new Float(res).toString().replaceAll("\\.?0*$", ""));
//            //tvInfo.append("\n");

            tvResult.setText(res.toString().replaceAll("\\.?0*$", ""));
            tvInfo.append(b.toString().replaceAll("\\.?0*$", "") + " = " + res.toString().replaceAll("\\.?0*$", ""));

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}