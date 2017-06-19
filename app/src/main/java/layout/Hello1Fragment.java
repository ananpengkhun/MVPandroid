package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ananpengkhun.mvpwithdialogfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Hello1Fragment extends Fragment {


    public Hello1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello1, container, false);
    }

    public static Fragment newInstant() {
        return new Hello1Fragment();
    }
}
