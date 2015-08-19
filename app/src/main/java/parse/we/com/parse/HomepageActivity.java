package parse.we.com.parse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseUser;


public class HomepageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ParseUser cuParseUser = ParseUser.getCurrentUser();
        if (cuParseUser != null) {
            Toast.makeText(getApplicationContext() , "Welcome" , Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(HomepageActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        try {
            switch (id) {
                case R.id.updateStatus:
                    //TODO Update
                    Intent intent = new Intent(HomepageActivity.this, UpdateStatusActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.logoutUser:
                    //TODO LogOut
                    ParseUser.logOut();
                    Intent intentLogin = new Intent(HomepageActivity.this, LoginActivity.class);
                    startActivity(intentLogin);
                    finish();
                    break;
            }
        } catch (Exception ex) {
            Log.e("ERROR", ex.getMessage().toString());
        }

        return super.onOptionsItemSelected(item);
    }
}
