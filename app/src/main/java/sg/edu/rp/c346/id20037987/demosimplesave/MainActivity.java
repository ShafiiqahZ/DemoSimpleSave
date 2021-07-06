package sg.edu.rp.c346.id20037987.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String msg = prefs.getString("greetings", "No greetings!");
        //String msg = "No greetings!";
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        //String msg = "Activity is Closed!";
        //Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();

        //Storing data
        //Step 1:Obtain the sharedPreferences instance
        SharedPreferences prefs = getPreferences((MODE_PRIVATE));
        //Step 2: Create a sharedPreferences Editor by calling edit();
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Step 3: Set a key-pair in the editor
        prefEdit.putString("greetings", "Hello");
        //Stepp 4: Call commit() to save changes made to the sharedPreferences
        prefEdit.commit();
    }
}