package sse.etit.tuchemnitz.de.sesathirdapp;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rlentz on 28.01.15.
 */
public class DisplayMessageFragment extends Fragment{

    private TextView viewMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.display_message_fragment, null);
        viewMessage = (TextView) layout.findViewById(R.id.view_message);

        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(MainActivity.LOGTAG, "Entered displaymessage");

        String rcvdParameter = getArguments().getString(MainActivity.HANDOVER_PARAMETER);
        Log.d(MainActivity.LOGTAG, "rcvdParameter: " + rcvdParameter);

        if(!TextUtils.isEmpty(rcvdParameter)){
            viewMessage.setText(rcvdParameter);
        }



    }
}
