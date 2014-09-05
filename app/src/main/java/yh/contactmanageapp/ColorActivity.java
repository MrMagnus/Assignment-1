package yh.contactmanageapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;


public class ColorActivity extends Activity implements View.OnClickListener {

    //Class variables
    private Button randomColorBtn;
    private Button defaultColorBtn;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        //Finds the items from the UI and saves them to individual variables
        randomColorBtn = (Button) findViewById(R.id.randomColorButton);
        defaultColorBtn = (Button) findViewById(R.id.defaultColorButton);
        //This is the layout of the activity that I've given a ID so that i can change it's color.
        layout = (RelativeLayout) findViewById(R.id.colorActivityLayout);

        //Set the click listeners
        randomColorBtn.setOnClickListener(this);
        defaultColorBtn.setOnClickListener(this);

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
                //Create a new intent that will take the user to the NumberActivity activity.
                Intent numberAction = new Intent(this, NumberActivity.class);
                //Starts the activity
                startActivity(numberAction);
                break;

            case R.id.action_colorGenerator:
                //Create a new intent that will take the user to the NumberActivity activity.
                Context context = getApplicationContext();
                CharSequence text = "You're already on this page.";
                int duration = Toast.LENGTH_SHORT;

                //Creates the Toast with the params we created and then shows it.
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * When the user clicks on the randomColorButton the program will create 3 random numbers
     * between 0 and 255. These are used to set the background using Color.rgb().
     *
     * When the user clicks the defaultColorButton the program will change the background color to
     * white, which is the default.
     *
     * I could have used if statements to handle the button clicks but i choose to use a switch
     * because I think it's easier to expand and easier to understand.
     */
    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.randomColorButton:
                //Creates a new Random
                Random random = new Random();

                //Creates a new random and saves it to a variable
                int randomRed = random.nextInt() * 255;
                int randomGreen = random.nextInt() * 255;
                int randomBlue = random.nextInt() * 255;
                //Set the background to the default
                layout.setBackgroundColor(Color.rgb(randomRed, randomGreen, randomBlue));
            break;

            case R.id.defaultColorButton:
                //Sets the background to the color which i have as a resource in the color.xml file
                layout.setBackgroundColor(getResources().getColor(R.color.defaultBackgroundColor));
            break;

        }

    }
}
