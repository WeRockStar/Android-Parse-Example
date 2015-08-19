package parse.we.com.parse;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseObject;


public class HomepageActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Parse.initialize(this, "95I4LvWem7H4dIYI1MfnWRQjRdcziQHh76Rh6x9A", "yKUWKoKqe1hnGtsX6io12mZOSjkGdN5r7RliyR6Z");
        ParseObject gameScore = new ParseObject("GameScore");
        gameScore.put("score", 1337);
        gameScore.put("playerName", "Sean Plott");
        gameScore.put("cheatMode", false);
        gameScore.saveInBackground();
    }


}
