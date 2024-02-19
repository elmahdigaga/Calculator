package gaga.elmahdi.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PortraitActivity extends AppCompatActivity implements View.OnClickListener {
    TextView historyTV, resultTV;
    Button clearAllMB, clearMB, bracketsMB, dotMB, divisionMB, multiplicationMB, additionMB, substractionMB, moduloMB, equalMB;
    Button zeroMB, oneMB, twoMB, threeMB, fourMB, fiveMB, sixMB, sevenMB, eightMB, nineMB;

    private Button assignIdToMB(int id) {
        Button button = findViewById(id);
        button.setOnClickListener(this);
        return button;
    }

    private void assignIds() {
        historyTV = findViewById(R.id.historyTextView);
        resultTV = findViewById(R.id.resultTextView);

        clearAllMB = assignIdToMB(R.id.clearAllButton);
        clearMB = assignIdToMB(R.id.clearButton);

        bracketsMB = assignIdToMB(R.id.bracketsButton);
        dotMB = assignIdToMB(R.id.dotButton);
        divisionMB = assignIdToMB(R.id.divisionButton);
        multiplicationMB = assignIdToMB(R.id.multplicationButton);
        additionMB = assignIdToMB(R.id.additionButton);
        substractionMB = assignIdToMB(R.id.substractionButton);
        moduloMB = assignIdToMB(R.id.moduloButton);
        equalMB = assignIdToMB(R.id.equalButton);

        zeroMB = assignIdToMB(R.id.zeroButton);
        oneMB = assignIdToMB(R.id.oneButton);
        twoMB = assignIdToMB(R.id.twoButton);
        threeMB = assignIdToMB(R.id.threeButton);
        fourMB = assignIdToMB(R.id.fourButton);
        fiveMB = assignIdToMB(R.id.fiveButton);
        sixMB = assignIdToMB(R.id.sixButton);
        sevenMB = assignIdToMB(R.id.sevenButton);
        eightMB = assignIdToMB(R.id.eightButton);
        nineMB = assignIdToMB(R.id.nineButton);
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
        String newExpression = historyTV.getText().toString() + buttonText;
        historyTV.setText(newExpression);
    }
}