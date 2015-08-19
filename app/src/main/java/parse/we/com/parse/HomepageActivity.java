package parse.we.com.parse;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class HomepageActivity extends ListActivity {

    List<ParseObject> mStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        ParseUser cuParseUser = ParseUser.getCurrentUser();
        if (cuParseUser != null) {
//            Toast.makeText(getApplicationContext() , "Welcome" , Toast.LENGTH_SHORT).show();
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Status");
            query.orderByDescending("CreatedAt");
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> list, ParseException e) {
                    if (e == null) {
                        // success
                        mStatus = list;
                        StatusAdapter statusAdapter = new StatusAdapter(getListView().getContext(), mStatus);
                        setListAdapter(statusAdapter);
                    } else {
                        // error
                    }
                }
            });
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
