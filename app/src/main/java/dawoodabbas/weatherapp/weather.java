package dawoodabbas.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class weather extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_weather);
            TextView ed1 = (TextView) findViewById(R.id.ed1);
            TextView ed2 = (TextView) findViewById(R.id.ed2);
            TextView ed3 = (TextView) findViewById(R.id.ed3);
            Intent i = getIntent();
            String tem=i.getStringExtra("temp");
            String hum=i.getStringExtra("humidity");
            String pres=i.getStringExtra("pressure");
            Bundle bundle = i.getExtras();
            if (bundle != null) {


                ed1.setText("Temperature: \n"+tem+(char)0x00B0+"C");
                ed2.setText("humidity: \n"+hum);
                ed3.setText("pressure: \n"+pres);


            }
        }catch (Exception e)
        {
            Log.d("error",e+"");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weather, menu);
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
