package tk.hadeslee.myintent;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int ACTIVITY_MENU = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v) {
//        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1000-1000"));
//        startActivity(intent);

//        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
//        startActivityForResult(intent, ACTIVITY_MENU);

        Intent intent = new Intent();
        ComponentName name = new ComponentName("tk.hadeslee.myintent",
                "tk.hadeslee.myintent.MenuActivity");
        intent.setComponent(name);
        intent.putExtra("title", "소녀시대");
        intent.putExtra("age", 20);


        Person person01 = new Person("걸스데이", 21);
        intent.putExtra("person", person01);

        startActivityForResult(intent, ACTIVITY_MENU);
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
