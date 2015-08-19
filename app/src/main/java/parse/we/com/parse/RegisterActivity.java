package parse.we.com.parse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends Activity {

    protected EditText mUsername;
    protected EditText mEmail;
    protected EditText mUserPassword;
    protected Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mUsername = (EditText) findViewById(R.id.usernameRegister);
        mEmail = (EditText) findViewById(R.id.emailRegister);
        mUserPassword = (EditText) findViewById(R.id.passwordRegister);
        mRegisterButton = (Button) findViewById(R.id.buttonSignUp);

        //TODO Click
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Save
                String txtUser = mUsername.getText().toString().trim();
                String txtEmail = mEmail.getText().toString().trim();
                String txtPassword = mUserPassword.getText().toString().trim();

                ParseUser user = new ParseUser();
                user.setUsername(txtUser);
                user.setPassword(txtPassword);
                user.setEmail(txtEmail);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        try {
                            if (e == null) {
                                //signup success
                                Intent intent = new Intent(RegisterActivity.this, HomepageActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                //signup error
                                Log.e("ERROR", e.getMessage().toString());
                                Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception ex) {
                            Log.e("ERROR" , ex.getMessage().toString());
                        }

                    }
                });
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();


    }
}
