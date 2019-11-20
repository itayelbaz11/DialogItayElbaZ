package com.example.dialogitayelbaz;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;


    /**
     * @author  Itay Elbaz
     * @since 6.7.2003
     * This activity has 5 buttons that make different alert dialogs show
     */
public class MainActivity extends AppCompatActivity {

        /**
         *  ll is the Linear layout object
         */
    LinearLayout ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll=(LinearLayout) findViewById(R.id.ll);

    }

        /**
         * this method creates the menu
         */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.main, menu);
            menu.add(0,0,250,"Clibrate");
            return true;
    }

        /**
         * this method activates te menu and moves to the credits activity
         * @param item the selected item
         */
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.credits) {
            Intent si = new Intent(this, credits.class);
            startActivity(si);
        }
        return true;
    }

        /**
         *when the first button is taped an alert dialog shows a message
         */
    public void alert(View view) {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Alert!");
        adb.setMessage("this is an alert");
        AlertDialog ad=adb.create();
        ad.show();

    }
        /**
         *when the second button is taped an alert dialog shows a message and there is an icon
         */
    public void alerticon(View view) {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Alert with icon!");
        adb.setMessage("this is an alert");
        adb.setIcon(R.drawable.ic_launcher_background);
        AlertDialog ad=adb.create();
        ad.show();
    }
        /**
         *when the second button is taped an alert dialog shows a message, there is an icon, and you can press a button to stop
         */
    public void iconbtn(View view) {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Alert, icon and ok!");
        adb.setMessage("this is an alert");
        adb.setIcon(R.drawable.ic_launcher_background);
        adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }

        /**
         *when the second button is taped an alert dialog shows a message, there is an icon, and you can press a button for a random background color
         */

    public void rc(View view) {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Random color!!");
        adb.setMessage("press to get color");
        adb.setIcon(R.drawable.ic_launcher_background);
        adb.setPositiveButton("color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(new Random().nextInt());
            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }
        /**
         *when the second button is taped an alert dialog shows a message, there is an icon, and you can press a button for a random background color and a button for reseting the backgrounds color
         */
    public void rr(View view) {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Random color!!");
        adb.setMessage("press to get color");
        adb.setIcon(R.drawable.ic_launcher_background);
        adb.setPositiveButton("color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(new Random().nextInt());
            }
        });
        adb.setNegativeButton("reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.WHITE);
            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }

}
