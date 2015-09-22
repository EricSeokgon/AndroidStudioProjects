package tk.hadeslee.mylifecycle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "onCreate() 호출됨. ", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        Toast.makeText(getApplicationContext(), "onStop() 호출됨. ", Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(getApplicationContext(), "onDestroy() 호출됨. ", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast.makeText(getApplicationContext(), "onPause() 호출됨. ", Toast.LENGTH_LONG).show();

        saveScore();

        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(getApplicationContext(), "onResume() 호출됨. ", Toast.LENGTH_LONG).show();
        loadScore();
        super.onResume();
    }

    @Override
    protected void onStart() {
        Toast.makeText(getApplicationContext(), "onStart() 호출됨. ", Toast.LENGTH_LONG).show();
        super.onStart();
    }

    private void saveScore() {
        SharedPreferences pref = getSharedPreferences("gostop", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("score", 10000);
        editor.commit();
    }

    private void loadScore() {
        SharedPreferences pref = getSharedPreferences("gostop", Activity.MODE_PRIVATE);
        int score = pref.getInt("score", 0);
        Toast.makeText(getApplicationContext(), "읽어온 점수 :" + score, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
