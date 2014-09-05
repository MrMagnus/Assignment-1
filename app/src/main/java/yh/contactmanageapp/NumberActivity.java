package yh.contactmanageapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class NumberActivity extends Activity implements View.OnClickListener{

    //Class variables
    private Button generateBtn;
    private TextView numberTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        //Finds the items from the UI and saves them to individual variables
        generateBtn = (Button) findViewById(R.id.generateButton);
        numberTv = (TextView) findViewById(R.id.numberTextView);

        //Set clickListeners
        generateBtn.setOnClickListener(this);
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
                //Create a new intent that will take the user to the NumberActivity activity.
                Intent addFriendAction = new Intent(this, AddFriendsActivity.class);
                //Starts the activity
                startActivity(addFriendAction);
                break;

            case R.id.action_numberGenerator:
                //Create the necessary params tor the toast and saves it into variables.
                Context context = getApplicationContext();
                CharSequence text = "You're already on this page.";
                int duration = Toast.LENGTH_SHORT;

                //Creates the Toast with the params we created and then shows it.
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                break;

            case R.id.action_colorGenerator:
                //Create a new intent that will take the user to the NumberActivity activity.
                Intent colorAction = new Intent(this, ColorActivity.class);
                //Starts the activity
                startActivity(colorAction);
            break;
        }

        return super.onOptionsItemSelected(item);

    }

    /**
     * Generates a random double between 0 and 100 and then shows it to the user.
     */
    public void onClick(View view) {
        int id = view.getId();

        //Generates a random number and shows it if button in clicked.
        if (id == R.id.generateButton) {

            Random random = new Random();
            //Generates a random number between 0 and 100.
            Double randomNum = random.nextDouble() * 100.0;
            //Format the the double so that it only shows 2 decimals.
            String scaledNum = String.format("%.2f", randomNum);
            //Changes the numberTextView (in the UI) to the value of numberTv.
            numberTv.setText("" + scaledNum);
        }

    }
}
