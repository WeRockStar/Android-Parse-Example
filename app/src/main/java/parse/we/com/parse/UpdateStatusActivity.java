package parse.we.com.parse;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class UpdateStatusActivity extends Activity {

    private EditText updateStatusEditText;
    private Button postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_status);

        postButton = (Button) findViewById(R.id.postButton);
        updateStatusEditText = (EditText) findViewById(R.id.updateStatusEditText);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get username current
                ParseUser cuParseUser = ParseUser.getCurrentUser();
                String username = cuParseUser.getUsername();
                //status text
                String status = updateStatusEditText.getText().toString().trim();
                try {
                    if (!status.isEmpty()) {
                        //save to parse
                        ParseObject statusObj = ParseObject.create("Status");
                        statusObj.put("status", status);
                        statusObj.put("username", username);
                        statusObj.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException ee) {
                                if (ee == null) {
                                    Intent intent = new Intent(UpdateStatusActivity.this, HomepageActivity.class);
                                    startActivity(intent);
                                } else {
                                    Log.e("ERROR", ee.getMessage());
                                    AlertDialog.Builder builder = new AlertDialog.Builder(UpdateStatusActivity.this);
                                    builder.setTitle("Warning...");
                                    builder.setMessage("Status not working...");
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            dialog.cancel();
                                        }
                                    });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                }
                            }
                        });
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(UpdateStatusActivity.this);
                        builder.setTitle("Warning...");
                        builder.setMessage("Please input your status");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                dialog.cancel();
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                } catch (Exception ex) {
                    Log.e("ERROR", ex.getMessage().toString());
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_status, menu);
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
}
