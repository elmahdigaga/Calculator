package gaga.elmahdi.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PortraitActivity extends AppCompatActivity implements View.OnClickListener {
    StringBuilder expression = new StringBuilder();
    boolean isBracketOpen = false;
    TextView historyTV, resultTV;
    Button clearAllBtn, clearBtn, bracketsBtn, dotBtn, divisionBtn, multiplicationBtn, additionBtn, substractionBtn, moduloBtn, equalBtn;
    Button zeroBtn, oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn;

    private Button assignIdToBtn(int id) {
        Button button = findViewById(id);
        button.setOnClickListener(this);
        return button;
    }

    private void assignIds() {
        historyTV = findViewById(R.id.historyTextView);
        resultTV = findViewById(R.id.resultTextView);

        clearAllBtn = assignIdToBtn(R.id.clearAllButton);
        clearBtn = assignIdToBtn(R.id.clearButton);

        bracketsBtn = assignIdToBtn(R.id.bracketsButton);
        dotBtn = assignIdToBtn(R.id.dotButton);

        divisionBtn = assignIdToBtn(R.id.divisionButton);
        multiplicationBtn = assignIdToBtn(R.id.multplicationButton);
        additionBtn = assignIdToBtn(R.id.additionButton);
        substractionBtn = assignIdToBtn(R.id.substractionButton);
        moduloBtn = assignIdToBtn(R.id.moduloButton);
        equalBtn = assignIdToBtn(R.id.equalButton);

        zeroBtn = assignIdToBtn(R.id.zeroButton);
        oneBtn = assignIdToBtn(R.id.oneButton);
        twoBtn = assignIdToBtn(R.id.twoButton);
        threeBtn = assignIdToBtn(R.id.threeButton);
        fourBtn = assignIdToBtn(R.id.fourButton);
        fiveBtn = assignIdToBtn(R.id.fiveButton);
        sixBtn = assignIdToBtn(R.id.sixButton);
        sevenBtn = assignIdToBtn(R.id.sevenButton);
        eightBtn = assignIdToBtn(R.id.eightButton);
        nineBtn = assignIdToBtn(R.id.nineButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait);
        assignIds();
    }

    private void clearHandler(final String token) {
        if (token.equals("C")) {
            expression.deleteCharAt(expression.length() - 1);
        } else {
            expression.setLength(0);
        }
        resultTV.setText("0");
    }

    private void bracketsHandler() {
        if (isBracketOpen) {
            expression.append(")");
        } else {
            expression.append("(");
        }
        isBracketOpen = !isBracketOpen;
    }

    private void dotHandler() {
        if (expression.length() == 0) return;
        final char lastToken = expression.charAt(expression.length() - 1);
        if (Character.isDigit(lastToken)) {
            expression.append(".");
        }
    }

    private void operatorHandler(final String op) {
        if (expression.length() == 0) {
            if (op.equals("-")) expression.append(op);
            return;
        }
        final char lastToken = expression.charAt(expression.length() - 1);
        if (Character.isDigit(lastToken) || lastToken == ')') {
            expression.append(op);
        }
    }

    private void equalHandler() {
        if (expression.length() == 0) return;
        final char lastToken = expression.charAt(expression.length() - 1);
        if (!Character.isDigit(lastToken) && lastToken != ')') {
            return;
        }
        resultTV.setText("Total");
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "C":
            case "AC":
                clearHandler(buttonText);
                break;
            case "()":
                bracketsHandler();
                break;
            case ".":
                dotHandler();
                break;
            case "+":
            case "-":
            case "x":
            case "/":
            case "%":
                operatorHandler(buttonText);
                break;
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                expression.append(buttonText);
                break;
            case "=":
                equalHandler();
                break;
        }

        historyTV.setText(expression.toString());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            startActivity(new Intent(this, LandscapeActivity.class));
            finish();
        }
    }
}