package dawoodabbas.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity
{

    EditText ed1;

    private String url1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String url2 = "&mode=xml";
    private HandleXML obj;
    Button b1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
ed1=(EditText)findViewById(R.id.editText);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = ed1.getText().toString();
                String finalUrl = url1 + url + url2;

                obj = new HandleXML(finalUrl);
                obj.fetchXML();
                while(obj.parsingComplete);

               try {
                    Intent i=new Intent(MainActivity.this,weather.class);


                i.putExtra("temp",obj.getTemperature());
                i.putExtra("humidity",obj.getHumidity());
                i.putExtra("pressure", obj.getPressure());

    startActivity(i);
}catch (Exception e)
{
    Log.d("error",e+"");
}

//                Log.d("error",obj.getTemperature());
//                Log.d("error",obj.getHumidity());
//                Log.d("error",obj.getPressure());


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}