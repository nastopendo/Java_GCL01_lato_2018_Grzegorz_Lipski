package pl.grzegorzlipski.pentaxir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menuItem1:
                Toast.makeText(this,"Author: Grzegorz Lipski", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuItem2:
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onRemoteButtonClick(View view){
        Intent i = new Intent(MainActivity.this, RemoteActivity.class);
        startActivity(i);
    }

    public void onTimelapseButtonClick(View view){
        Intent i = new Intent(MainActivity.this, TimelapseActivity.class);
        startActivity(i);
    }
}
