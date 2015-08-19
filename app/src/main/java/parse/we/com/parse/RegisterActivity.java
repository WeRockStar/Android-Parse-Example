package parse.we.com.parse;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class RegisterActivity extends Activity {

    protected EditText mUsername;
    protected EditText mEmail;
    protected EditText mUserpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        
    }

}
