package ro.pub.cs.systems.eim.practicaltest01var03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private Button navigate = null, display = null;
    private EditText name = null, group = null;
    private CheckBox name_check = null, group_check = null;
    private TextView text = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        navigate = (Button)findViewById(R.id.navigate);
        display = (Button)findViewById(R.id.display);
        name = (EditText)findViewById(R.id.edit1);
        group = (EditText)findViewById(R.id.edit2);
        name_check = (CheckBox)findViewById(R.id.checkBox1);
        group_check = (CheckBox)findViewById(R.id.checkBox2);
        text = (TextView)findViewById(R.id.shown_info);

        display.setOnClickListener(buttonClickListener);
        navigate.setOnClickListener(buttonClickListener);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("name", name.getText().toString());
        savedInstanceState.putString("group", group.getText().toString());
        savedInstanceState.putString("display", display.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("name")) {
            name.setText(savedInstanceState.getString("name"));
        } else {
            name.setText("");
        }
        if (savedInstanceState.containsKey("group")) {
            group.setText(savedInstanceState.getString("group"));
        } else {
            group.setText("");
        }
        if (savedInstanceState.containsKey("display")) {
            group.setText(savedInstanceState.getString("display"));
        } else {
            group.setText("");
        }
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.display:
                    text.setText("");

                    if(name_check.isChecked())
                        text.setText(text.getText().toString() + name.getText().toString());

                    if(group_check.isChecked())
                        text.setText(text.getText().toString() + " " + group.getText().toString());
                    break;
            }
        }
    }
}
