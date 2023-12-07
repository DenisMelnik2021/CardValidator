package com.example.cardvalidator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private EditText editCard;
    private TextView tv;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editCard = findViewById(R.id.editCard);
        button = findViewById(R.id.button);
        tv = findViewById(R.id.tv);
    }

    public void isValid (View v)
    {
        String str_card = editCard.getText().toString();
        char[] a = str_card.toCharArray();
        int sum = 0;
        for (int i = 0; i < a.length; i++)
        {
            int tmp = Character.getNumericValue(a[i]);
            if (i % 2 == 0)
            {
                int temp = tmp * 2;
                if (temp > 9)
                {
                    temp -= 9;
                }
                sum += temp;
            } else
            {
                sum += tmp;
            }
        }
        if (sum % 10 == 0)
        {
            tv.setText("Номер правильный");
        } else
        {
            tv.setText("Номер не правильный");
        }
    }
}