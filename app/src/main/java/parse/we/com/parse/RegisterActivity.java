package parse.we.com.parse;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity {

    protected EditText mUsername;
    protected EditText mEmail;
    protected EditText mUserPassword;
    protected Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUsername = (EditText)findViewById(R.id.usernameRegister);
        mEmail = (EditText)findViewById(R.id.emailRegister);
        mUserPassword = (EditText)findViewById(R.id.passwordRegister);
        mRegisterButton = (Button)findViewById(R.id.buttonSignUp);
    }

}
