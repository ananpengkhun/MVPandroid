package com.example.ananpengkhun.mvpwithdialogfragment.dialog;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ananpengkhun.mvpwithdialogfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainBaseFragment extends DialogFragment {
    public static final int DIALOG_SUCCESS = 1;
    public static final int DIALOG_ERROR = 2;

    private int layout;
    private int dialogType;
    private String titleMsg;
    private String descMsg;


    private MainBaseOnClicklistener mainBaseOnClicklistener;

    public interface MainBaseOnClicklistener {
        boolean onCLick(MainBaseFragment mainBaseFragment, View view);
    }

    public MainBaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = savedInstanceState != null ? savedInstanceState : getArguments();
        dialogType = bundle.getInt("DIALOG_TYPE");
        titleMsg = bundle.getString("title");
        descMsg = bundle.getString("desc");

        if (DIALOG_SUCCESS == dialogType) {
            setStyle(STYLE_NORMAL, R.style.ThemeDialog);
            layout = R.layout.dialog_success;
        } else if (DIALOG_ERROR == dialogType) {
            setStyle(STYLE_NORMAL, R.style.ThemeDialog);
            layout = R.layout.dialog_error;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (savedInstanceState != null) {
            layout = savedInstanceState.getInt("layout");
        }
        View v = inflater.inflate(layout, container, false);
        // Inflate the layout for this fragment
        if (DIALOG_SUCCESS == dialogType) {
            DialogSuccessHolder successHolder = new DialogSuccessHolder(v);
            successHolder.tvTitle.setText(titleMsg);
            successHolder.tvDesc.setText(descMsg);
            successHolder.btnSuccess.setOnClickListener(onClickListener);
        } else if (DIALOG_ERROR == dialogType) {
            DialogErrorHolder errorHolder = new DialogErrorHolder(v);
            errorHolder.tvTitle.setText(titleMsg);
            errorHolder.tvTitle.setText(descMsg);
            errorHolder.btnError.setOnClickListener(onClickListener);
        }
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("layout", layout);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public static MainBaseFragment createSuccessDialog(String title, String description, MainBaseOnClicklistener mainBaseOnClicklistener) {
        MainBaseFragment mainBaseFragment = new MainBaseFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("DIALOG_TYPE", DIALOG_SUCCESS);
        bundle.putString("title", title);
        bundle.putString("desc", description);
        mainBaseFragment.setArguments(bundle);
        mainBaseFragment.mainBaseOnClicklistener = mainBaseOnClicklistener;
        return mainBaseFragment;
    }

    public static MainBaseFragment createErrorDialog(String title, String description, MainBaseOnClicklistener mainBaseOnClicklistener) {
        MainBaseFragment mainBaseFragment = new MainBaseFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("DIALOG_TYPE", DIALOG_ERROR);
        bundle.putString("title", title);
        bundle.putString("desc", description);
        mainBaseFragment.setArguments(bundle);
        mainBaseFragment.mainBaseOnClicklistener = mainBaseOnClicklistener;
        return mainBaseFragment;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Log.d("before: ssss", "onCLick: cvvbvbcvbcvb");
            if(!mainBaseOnClicklistener.onCLick(MainBaseFragment.this,view)){
                Log.d("after : ssss", "onCLick: cvvbvbcvbcvb");
            }

        }
    };


    public class DialogSuccessHolder {
        @BindView(R.id.tv_title) TextView tvTitle;
        @BindView(R.id.tv_desc) TextView tvDesc;
        @BindView(R.id.btn_success) Button btnSuccess;

        DialogSuccessHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public class DialogErrorHolder {
        @BindView(R.id.tv_title) TextView tvTitle;
        @BindView(R.id.tv_desc) TextView tvDesc;
        @BindView(R.id.btn_error) Button btnError;

        DialogErrorHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
