package org.qblex.QbleRemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by VIT_HOME on 2016-05-02.
 */
public class FragButton2 extends Fragment implements Button.OnClickListener {
    private static final String TAG = FragButton2.class.getSimpleName();

    ButtonSelectedListener2 listener;

    Button button, button2;
    Animation buttonOn1, buttonOn2;
    Animation buttonOff1, buttonOff2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_button2, container, false);

        button = (Button) root.findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 = (Button) root.findViewById(R.id.button2);
        button2.setOnClickListener(this);

        buttonOn1 = AnimationUtils.loadAnimation(getActivity(), R.anim.buttonon1);
        buttonOff1 = AnimationUtils.loadAnimation(getActivity(), R.anim.buttonoff1);
        buttonOn2 = AnimationUtils.loadAnimation(getActivity(), R.anim.buttonon2);
        buttonOff2 = AnimationUtils.loadAnimation(getActivity(), R.anim.buttonoff2);

        return root;
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            switch (v.getId()) {
                case R.id.button:
                    listener.onButtonSelected2(1);
                    break;
                case R.id.button2:
                    listener.onButtonSelected2(2);
                    break;
                default:
                    break;
            }
    }

    public void updataButton(int index, int status) {
        switch (index) {
            case 1:
                if (status == 1) button.startAnimation(buttonOff1);
                else button.startAnimation(buttonOn1);
                break;
            case 2:
                if (status == 1) button2.startAnimation(buttonOff2);
                else button2.startAnimation(buttonOn2);
                break;
            default:
                break;
        }
    }

    public interface ButtonSelectedListener2 {
        void onButtonSelected2(int index);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ButtonSelectedListener2) {
            listener = (ButtonSelectedListener2) activity;
        }
    }

    //장비의 설정 상태 변경, 화면 방향 변경시에 다음 메소드가 호출된다.
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
