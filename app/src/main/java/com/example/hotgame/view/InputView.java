package com.example.hotgame.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.hotgame.R;

public class InputView extends FrameLayout {
    private int inputIcon;
    private String inputHint;
    private boolean isPassword;
    private View mVIew;
    private ImageView mIvIcon;
    private TextView mEtInput;
    public InputView(Context context) {
        super(context);
        init(context,null);
    }

    public InputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public InputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InputView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }
    private void init(Context context,AttributeSet attrs){
        if(attrs==null) return;
        TypedArray typedArray= context.obtainStyledAttributes(attrs, R.styleable.inputView);
        inputIcon=typedArray.getResourceId(R.styleable.inputView_input_icon,R.mipmap.phone);
        inputHint=typedArray.getString(R.styleable.inputView_input_hint);
        isPassword=typedArray.getBoolean(R.styleable.inputView_is_password,false);
        typedArray.recycle();
        mVIew= LayoutInflater.from(context).inflate(R.layout.input_view,this,false);
        mIvIcon=mVIew.findViewById(R.id.iv_icon);
        mEtInput=mVIew.findViewById(R.id.et_input);
        addView(mVIew);
        mIvIcon.setImageResource(inputIcon);
        mEtInput.setHint(inputHint);
        mEtInput.setInputType(isPassword ? InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD:InputType.TYPE_CLASS_PHONE);

    }
    public String getInputStr(){
        return  mEtInput.getText().toString().trim();
    }
}