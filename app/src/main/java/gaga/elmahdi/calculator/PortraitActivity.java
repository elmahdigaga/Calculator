package gaga.elmahdi.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import gaga.elmahdi.calculator.evaluator.Evaluator;

public class PortraitActivity extends AppCompatActivity implements View.OnClickListener {
    StringBuilder expression = new StringBuilder();
    String result;
    boolean isBracketOpen = false;
    TextView historyTV, resultTV;
    Button clearAllBtn, clearBtn, openBracketBtn, closeBracketBtn, dotBtn, divisionBtn, multiplicationBtn, additionBtn, subtractionBtn, equalBtn;
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

        openBracketBtn = assignIdToBtn(R.id.openBracketButton);
        closeBracketBtn = assignIdToBtn(R.id.closeBracketButton);
        dotBtn = assignIdToBtn(R.id.dotButton);

        divisionBtn = assignIdToBtn(R.id.divisionButton);
        multiplicationBtn = assignIdToBtn(R.id.multplicationButton);
        additionBtn = assignIdToBtn(R.id.additionButton);
        subtractionBtn = assignIdToBtn(R.id.subtractionButton);
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

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();


        switch (buttonText) {
            case "=":
                result = Evaluator.evaluate(String.valueOf(expression));
                break;
            case "C":
                if (expression.length() == 0) break;
                expression.deleteCharAt(expression.length() - 1);
                break;
            case "AC":
                expression.setLength(0);
                result = "0";
                break;
            default:
                expression.append(buttonText);
                break;
        }

        historyTV.setText(expression.toString());
        resultTV.setText(result);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            startActivity(new Intent(this, LandscapeActivity.class));
            finish();
        }
    }
}