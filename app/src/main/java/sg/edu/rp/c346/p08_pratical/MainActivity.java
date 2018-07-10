package sg.edu.rp.c346.p08_pratical;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import sg.edu.rp.c346.p08_pratical.R;

public class MainActivity extends AppCompatActivity {

    EditText etAge, etName;
    TextView tvage, tvname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tvname = findViewById(R.id.tvname);
        tvage = findViewById(R.id.tvAge);
        etAge = findViewById(R.id.etage);
        etName = findViewById(R.id.etname);
    }
    @Override
    protected void onPause() {
        super.onPause();
            String name = etName.getText().toString();
            Integer integer = Integer.parseInt(etAge.getText().toString());
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor preEdit = prefs.edit();
            preEdit.putString("Name", name);
            preEdit.putInt("Age", integer);
            preEdit.commit();



        preEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            String name = prefs.getString("Name", "");
            Integer age = prefs.getInt("Age", 0);

            etName.setText(name);
            etAge.setText(age.toString());

        }
    }

















