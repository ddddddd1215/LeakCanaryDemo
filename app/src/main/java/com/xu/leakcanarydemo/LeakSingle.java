package com.xu.leakcanarydemo;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by zhaoxuzhang on 2018/6/7.
 *
 * @author zhaoxuzhang
 */
public class LeakSingle {

    private Context mContext;
    private TextView mTextView;

    private static LeakSingle sInstance;

    private LeakSingle(Context context) {
        mContext = context;
    }

    public static LeakSingle getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new LeakSingle(context);
        }
        return sInstance;
    }

    public void setRetainedTextView(TextView tv) {
        mTextView = tv;
        mTextView.setText(mContext.getString(R.string.app_name));
    }

    public void removeRetainedTextView() {
        mTextView = null;
    }

}
