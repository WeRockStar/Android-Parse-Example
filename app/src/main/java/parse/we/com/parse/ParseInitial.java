package parse.we.com.parse;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Kotchaphan Muangsan on 19/8/2558.
 */
public class ParseInitial extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "95I4LvWem7H4dIYI1MfnWRQjRdcziQHh76Rh6x9A", "yKUWKoKqe1hnGtsX6io12mZOSjkGdN5r7RliyR6Z");


    }
}
