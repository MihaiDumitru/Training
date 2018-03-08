package com.delta.bartalk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by samharris on 12/12/13.
 */
public class BaseActivity extends Activity {

    Typeface customTypeface;
    String j = "woohoo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        customTypeface = Typeface.createFromAsset(getAssets(), "fonts/fasterone.ttf");
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = super.onCreateView(name, context, attrs);

        return setCustomTypeface(name, attrs, view);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = super.onCreateView(parent, name, context, attrs);

        return setCustomTypeface(name, attrs, view);
    }

    public View setCustomTypeface(String name, AttributeSet attrs, View view) {

        View replacementView = null;

        if(("TextView".equals(name))) {

            replacementView = new TextView(this, attrs);
            ((TextView) replacementView).setTypeface(customTypeface);
        }

        if(replacementView == null) {

            return view;
        } else {

            return replacementView;
        }

    }


}
