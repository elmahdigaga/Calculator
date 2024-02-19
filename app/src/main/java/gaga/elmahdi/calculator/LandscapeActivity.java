package gaga.elmahdi.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LandscapeActivity extends AppCompatActivity implements View.OnClickListener {
    TextView historyTV, resultTV;
    Button clearAllBtn, clearBtn, bracketsBtn, dotBtn, divisionBtn, multiplicationBtn, additionBtn, substractionBtn, moduloBtn, equalBtn;
    Button absoluteValueBtn, piBtn, sqrtBtn, sinBtn, cosBtn, tanBtn, lnBtn, logBtn, invMultBtn, expBtn, squareBtn, powerBtn;
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

        absoluteValueBtn = assignIdToBtn(R.id.absoluteValueButton);
        piBtn = assignIdToBtn(R.id.piButton);
        sqrtBtn = assignIdToBtn(R.id.squareRootButton);
        sinBtn = assignIdToBtn(R.id.sinusButton);
        cosBtn = assignIdToBtn(R.id.cosinusButton);
        tanBtn = assignIdToBtn(R.id.tangenteButton);
        lnBtn = assignIdToBtn(R.id.lnButton);
        logBtn = assignIdToBtn(R.id.logarithmButton);
        invMultBtn = assignIdToBtn(R.id.inverseMultiplicationButton);
        expBtn = assignIdToBtn(R.id.exponentialButton);
        squareBtn = assignIdToBtn(R.id.squareButton);
        powerBtn = assignIdToBtn(R.id.powerButton);

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
        setContentView(R.layout.activity_landscape);
        assignIds();
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String newExpression = historyTV.getText().toString() + buttonText;
        historyTV.setText(newExpression);
    }
}