package com.hotix.myhotixmarhaba.helpers;

import android.content.Context;
import android.content.SharedPreferences;

public class MySession {

    //Shared Preferences Keys
    // Booleans
    public static final String KEY_IS_RESA = "resa";

    // Sharedpref file name
    private static final String PREF_NAME = "CheckInSession";
    // Shared Preferences
    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Constructor
    public MySession(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**********************************(  Getters & Setters )**************************************/
    // Booleans
    public boolean getIsResa() {
        return pref.getBoolean(KEY_IS_RESA, true);
    }
    public void setISResa(boolean isResa) {
        editor.putBoolean(KEY_IS_RESA, isResa);
        editor.commit();
    }


    /*****************************************(  _______  )****************************************/
    //Clear MySettings details
    public void clearSettingsDetails() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }

}
