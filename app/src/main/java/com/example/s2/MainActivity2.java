package com.example.s2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {
    private Button button;
    private EditText nameBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupButton();
        setupNameBox();
    }

    private void setupButton() {
        button = (Button) findViewById(R.id.button_goto_game);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isUsernameValid()) {
                    nameBox.setError("Name cannot be whitespace-only, empty, or null");
                    return;
                }

                RadioGroup difficultyGroup = findViewById(R.id.radioGroup);
              
                int selectedId = getChecked(difficultyGroup);
              
                RadioButton spriteButton1 = findViewById(R.id.spriteRadioButton);
                RadioButton spriteButton2 = findViewById(R.id.spriteRadioButton2);
                RadioButton spriteButton3 = findViewById(R.id.spriteRadioButton3);

                int selectedSprite = 1;
                if (spriteButton2.isChecked()) {
                    selectedSprite = 2;
                } else if (spriteButton3.isChecked()) {
                    selectedSprite = 3;
                }

                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("selected_id", selectedId);
                intent.putExtra("selected_sprite", selectedSprite);
                intent.putExtra("name", nameBox.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void setupNameBox() {
        nameBox = (EditText) findViewById(R.id.editTextTextPersonName);
    }

    private boolean isUsernameValid() {
        String name = nameBox.getText().toString().trim();
        return !name.isEmpty();
    }

    private int getChecked(RadioGroup group) {
        if (group.getCheckedRadioButtonId() == -1) {
            return 2;
        } else {
            return group.getCheckedRadioButtonId();
        }
    }
}
