package deepdive.cnm.edu.temperatureconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener {

  private EditText fahrenheit;
  private EditText celcius;
  private EditText kelvin;
  private Button fahrenheitButton;
  private Button celciusButton;
  private Button kelvinButton;

  private double fahrenheitValue;
  private double celsiusValue;
  private double kelvinValue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    fahrenheit = (EditText) findViewById(R.id.fahrenheit);
    celcius = (EditText) findViewById(R.id.celcius);
    kelvin = (EditText) findViewById(R.id.kelvin);
    fahrenheitButton = (Button) findViewById(R.id.fahrenheit_button);
    celciusButton = (Button) findViewById(R.id.celcius_button);
    kelvinButton = (Button) findViewById(R.id.kelvin_button);
    fahrenheitButton.setOnClickListener(this);
    celciusButton.setOnClickListener(this);
    kelvinButton.setOnClickListener(this);
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

  @Override
  public void onClick(View v) {
    if (v.getId() == R.id.fahrenheit_button){
      String fahrenheitInput = fahrenheit.getText().toString();
      try {
        fahrenheitValue = Double.parseDouble(fahrenheitInput);
      } catch (final NumberFormatException ex) {
        fahrenheitValue = 32.0;
      }
      String fahrenheitToCelcius = Double.toString((fahrenheitValue - 32) / 1.8);
      String fahrenheitToKelvin = Double.toString(.556 * (fahrenheitValue - 32) + 273);
      celcius.setText(fahrenheitToCelcius);
      kelvin.setText(fahrenheitToKelvin);
    } else if (v.getId() == R.id.celcius_button){
      String celsiusInput = celcius.getText().toString();
      try {
        celsiusValue = Double.parseDouble(celsiusInput);
      } catch (final NumberFormatException ex) {
        celsiusValue = 0.0;
      }
      String celciusToFahrenheit = Double.toString((1.8 * celsiusValue + 32));
      String celciusToKelvin = Double.toString(celsiusValue + 273);
      fahrenheit.setText(celciusToFahrenheit);
      kelvin.setText(celciusToKelvin);
    } else {
      String kelvinInput = kelvin.getText().toString();
      try {
        kelvinValue = Double.parseDouble(kelvinInput);
      } catch (final NumberFormatException ex) {
        kelvinValue = 273;
      }
      String kelvinToFahrenheit = Double.toString(1.8 * (kelvinValue - 273) + 32);
      String kelvinToCelcius = Double.toString(kelvinValue - 273);
      celcius.setText(kelvinToCelcius);
      fahrenheit.setText(kelvinToFahrenheit);
    }
  }
}
