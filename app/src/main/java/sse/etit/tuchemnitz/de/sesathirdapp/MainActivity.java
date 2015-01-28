package sse.etit.tuchemnitz.de.sesathirdapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {


    public static final String HANDOVER_PARAMETER = "handoverparameter";
    public static final String LOGTAG = "logtagmainactivity";

    private MainFragment mainFragment;
    private DisplayMessageFragment displayMessageFragment;
    private Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //general layout appearance (in our case a blank layout called fragment_placeholder)
        setContentView(R.layout.activity_main);

        //instantiation of fragments (the bundle )
        mainFragment = (MainFragment) Fragment.instantiate(this, MainFragment.class.getName(), null);
        displayMessageFragment = (DisplayMessageFragment) Fragment.instantiate(this, DisplayMessageFragment.class.getName(), bundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_placeholder, mainFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
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

    public void onSelectFragment(View view){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        if (view == findViewById(R.id.button1)){
            onStoreText();
            Log.d(LOGTAG, "button1 press");
            fragmentTransaction.replace(R.id.fragment_placeholder, displayMessageFragment);
            Log.d(LOGTAG, "change fragment to displaymessage");
        } else {
            fragmentTransaction.replace(R.id.fragment_placeholder, mainFragment);
            Log.d(LOGTAG, "change fragment to main");
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onStoreText(){
        EditText editText = (EditText) findViewById(R.id.editText1);
        String parameter = editText.getText().toString();
        Log.i(LOGTAG, "Save String " + parameter);

        bundle.putString(HANDOVER_PARAMETER, parameter);
    }
}
