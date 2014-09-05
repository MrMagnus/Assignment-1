package yh.contactmanageapp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddFriendsActivity extends Activity {

    //Class variables
    private EditText nameEt;
    private EditText phoneNumEt;
    private EditText emailEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        nameEt = (EditText) findViewById(R.id.nameEditText);
        phoneNumEt = (EditText) findViewById(R.id.phoneEditText);
        emailEt = (EditText) findViewById(R.id.emailEditText);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.index, menu);
        return true;
    }

    /**
     * Takes the user to the activity he chooses from the menu.
     * However, if the user tries to choose the menu item they're currently on, a error
     * message will be displayed.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_addFriends:
                //Create the necessary params tor the toast and saves it into variables.
                Context context = getApplicationContext();
                CharSequence text = "You're already on this page.";
                int duration = Toast.LENGTH_SHORT;

                //Creates the Toast with the params we created and then shows it.
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            break;

            case R.id.action_numberGenerator:
                //Create a new intent that will take the user to the NumberActivity activity.
                Intent numberAction = new Intent(this, NumberActivity.class);
                //Starts the new activity
                startActivity(numberAction);
            break;

            case R.id.action_colorGenerator:
                //Create a new intent that will take the user to the ColorActivity activity.
                Intent colorAction = new Intent(this, ColorActivity.class);
                //Starts the new activity
                startActivity(colorAction);
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Saves the user inputs into variables and sends the users input to ContactContract
     */
    public void onAddBtn(View view){

        //Get user imputed values from the UI and removes unnecessary white space
        String name = nameEt.getText().toString().trim();
        String phoneNum = phoneNumEt.getText().toString().trim();
        String email = emailEt.getText().toString().trim();

        //Create a new intent
        Intent addContactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);

        //Makes a the intent to the right content type
        addContactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        //Sends the users input to ContactContract if the Name edit text are not null
        if(!name.matches("")) {

            //Sends the user inputs to the new activity
            addContactIntent.putExtra(ContactsContract.Intents.Insert.NAME, name);
            addContactIntent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
            addContactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNum);

            //Starts the new activity
            startActivity(addContactIntent);
        } else {
            //If the Name edit text are null an error message will be shown
            Context context = getApplicationContext();
            CharSequence text = "Name Required!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
    }
}
