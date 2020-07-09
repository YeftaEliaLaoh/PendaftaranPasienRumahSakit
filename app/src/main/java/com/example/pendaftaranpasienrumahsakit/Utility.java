package com.example.pendaftaranpasienrumahsakit;

import android.content.Context;

import android.view.View;
import android.view.inputmethod.InputMethodManager;


public class Utility
{

    public static void hideKeyboard( View view )
    {
        InputMethodManager mgr = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}
