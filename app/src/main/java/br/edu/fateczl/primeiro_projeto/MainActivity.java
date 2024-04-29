package br.edu.fateczl.primeiro_projeto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etVDelta;
    private EditText etVX1;
    private EditText etVX2;
    private TextView tvRes;
    private TextView tvMErro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etVDelta = findViewById(R.id.etVDelta);
        etVDelta.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etVX1 = findViewById(R.id.etVX1);
        etVX1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etVX2 = findViewById(R.id.etVX2);
        etVX2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvMErro = findViewById(R.id.tvMErro);
        tvMErro.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());


    }

    private void calc() {
        try {
            double a = Double.parseDouble(etVDelta.getText().toString());
            double b = Double.parseDouble(etVX1.getText().toString());
            double c = Double.parseDouble(etVX2.getText().toString());

            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                tvRes.setText("");
                tvMErro.setText(getString(R.string.tvMErro));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);

                tvRes.setText(getString(R.string.VDelta) + ": " + a + "\n" +
                        getString(R.string.VX1) + ": " + b + "\n" +
                        getString(R.string.VX2) + ": " + c);
                tvMErro.setText("");
            }
        } catch (NumberFormatException e) {
            tvRes.setText("");
            tvMErro.setText(getString(R.string.tvMErro));


        }
    }
}