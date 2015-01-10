package org.lofstead.myfirstapp;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void swap (View view)
    {
        View b1 = findViewById (R.id.character1);
        View b2 = findViewById (R.id.character2);

        RelativeLayout.LayoutParams params_b1 = (RelativeLayout.LayoutParams) b1.getLayoutParams();
        RelativeLayout.LayoutParams params_b2 = (RelativeLayout.LayoutParams) b2.getLayoutParams();

        int current_parent_b1 = params_b1.getRules() [RelativeLayout.BELOW];
        int current_parent_b2 = params_b2.getRules() [RelativeLayout.BELOW];
        params_b1.removeRule (RelativeLayout.BELOW);
        params_b2.removeRule(RelativeLayout.BELOW);
        int new_parent_b1;
        int new_parent_b2;

        if (current_parent_b1 == R.id.hello_world)
        {
            new_parent_b1 = R.id.character2;
            new_parent_b2 = R.id.hello_world;
        }
        else
        {
            new_parent_b1 = R.id.hello_world;
            new_parent_b2 = R.id.character1;
        }

        params_b1.addRule(RelativeLayout.BELOW, new_parent_b1);
        params_b2.addRule(RelativeLayout.BELOW, new_parent_b2);
        b1.setLayoutParams (params_b1);
        b2.setLayoutParams (params_b2);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
