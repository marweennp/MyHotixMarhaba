package com.hotix.myhotixmarhaba.helpers;

import android.content.Context;
import android.content.SharedPreferences;

public class MySettings {

    //Shared Preferences Keys
    // Booleans
    public static final String KEY_FIRST_START = "firstStart";
    public static final String KEY_CONFIGURED = "configured";
    public static final String KEY_SETTINGS_UPDATED = "settingsUpdated";
    public static final String KEY_SSL = "ssl";
    public static final String KEY_PUBLIC_IP_ENABLED = "publicIpEnabled";
    public static final String KEY_LOCAL_IP_ENABLED = "localIpEnabled";
    public static final String KEY_AUTO_UPDATE = "autoUpdate";
    public static final String KEY_LOCAL_IP_DEFAULT = "localIpDefault";
    public static final String KEY_PUBLIC_IP_REACHABLE = "publicIpReachable";
    public static final String KEY_LOCAL_IP_REACHABLE = "localIpReachable";

    //String
    public static final String KEY_PUBLIC_IP = "publicIp";
    public static final String KEY_LOCAL_IP = "localIp";
    public static final String KEY_PUBLIC_BASE_URL = "publicBaseUrl";
    public static final String KEY_LOCAL_BASE_URL = "localBaseUrl";
    public static final String KEY_HOTEL_CODE = "hotelCode";
    public static final String KEY_HOTEL_NAME = "hotelName";
    public static final String KEY_API_VERSION = "apiVersion";

    //Integer
    //

    // Sharedpref file name
    private static final String PREF_NAME = "CheckInSettings";
    // Shared Preferences
    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;


    // Constructor
    public MySettings(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**********************************(  Getters & Setters )**************************************/
    // Booleans
    public boolean getFirstStart() {
        return pref.getBoolean(KEY_FIRST_START, true);
    }

    public void setFirstStart(boolean firstStart) {
        editor.putBoolean(KEY_FIRST_START, firstStart);
        editor.commit();
    }

    public boolean getConfigured() {
        return pref.getBoolean(KEY_CONFIGURED, false);
    }

    public void setConfigured(boolean configured) {
        editor.putBoolean(KEY_CONFIGURED, configured);
        editor.commit();
    }

    public boolean getSettingsUpdated() {
        return pref.getBoolean(KEY_SETTINGS_UPDATED, false);
    }

    public void setSettingsUpdated(boolean settingsUpdated) {
        editor.putBoolean(KEY_SETTINGS_UPDATED, settingsUpdated);
        editor.commit();
    }

    public boolean getSsl() {
        return pref.getBoolean(KEY_SSL, false);
    }

    public void setSsl(boolean ssl) {
        editor.putBoolean(KEY_SSL, ssl);
        editor.commit();
    }

    public boolean getAutoUpdate() {
        return pref.getBoolean(KEY_AUTO_UPDATE, true);
    }

    public void setAutoUpdate(boolean autoUpdate) {
        editor.putBoolean(KEY_AUTO_UPDATE, autoUpdate);
        editor.commit();
    }

    public boolean getLocalIpDefault() {
        return pref.getBoolean(KEY_LOCAL_IP_DEFAULT, true);
    }

    public void setLocalIpDefault(boolean localIpDefault) {
        editor.putBoolean(KEY_LOCAL_IP_DEFAULT, localIpDefault);
        editor.commit();
    }

    public boolean getPublicIpReachable() {
        return pref.getBoolean(KEY_PUBLIC_IP_REACHABLE, false);
    }

    public void setPublicIpReachable(boolean publicIpReachable) {
        editor.putBoolean(KEY_PUBLIC_IP_REACHABLE, publicIpReachable);
        editor.commit();
    }

    public boolean getLocalIpReachable() {
        return pref.getBoolean(KEY_LOCAL_IP_REACHABLE, false);
    }

    public void setLocalIpReachable(boolean localIpReachable) {
        editor.putBoolean(KEY_LOCAL_IP_REACHABLE, localIpReachable);
        editor.commit();
    }

    public boolean getPublicIpEnabled() {
        return pref.getBoolean(KEY_PUBLIC_IP_ENABLED, false);
    }

    public void setPublicIpEnabled(boolean publicIpEnabled) {
        editor.putBoolean(KEY_PUBLIC_IP_ENABLED, publicIpEnabled);
        editor.commit();
    }

    public boolean getLocalIpEnabled() {
        return pref.getBoolean(KEY_LOCAL_IP_ENABLED, false);
    }

    public void setLocalIpEnabled(boolean localIpEnabled) {
        editor.putBoolean(KEY_LOCAL_IP_ENABLED, localIpEnabled);
        editor.commit();
    }

    // Strings
    public String getPublicIp() {
        return pref.getString(KEY_PUBLIC_IP, "xxx.xxx.xxx.xxx");
    }

    public void setPublicIp(String publicIp) {
        editor.putString(KEY_PUBLIC_IP, publicIp);
        editor.commit();
    }

    public String getLocalIp() {
        return pref.getString(KEY_LOCAL_IP, "xxx.xxx.xxx.xxx");
    }

    public void setLocalIp(String localIp) {
        editor.putString(KEY_LOCAL_IP, localIp);
        editor.commit();
    }

    public String getPublicBaseUrl() {
        return pref.getString(KEY_PUBLIC_BASE_URL, "http://xxx.xxx.xxx.xxx/");
    }

    public void setPublicBaseUrl(String publicBaseUrl) {
        editor.putString(KEY_PUBLIC_BASE_URL, publicBaseUrl);
        editor.commit();
    }

    public String getLocalBaseUrl() {
        return pref.getString(KEY_LOCAL_BASE_URL, "http://xxx.xxx.xxx.xxx/");
    }

    public void setLocalBaseUrl(String localBaseUrl) {
        editor.putString(KEY_LOCAL_BASE_URL, localBaseUrl);
        editor.commit();
    }

    public String getHotelCode() {
        return pref.getString(KEY_HOTEL_CODE, "0000");
    }

    public void setHotelCode(String hotelCode) {
        editor.putString(KEY_HOTEL_CODE, hotelCode);
        editor.commit();
    }

    public String getHotelName() {
        return pref.getString(KEY_HOTEL_NAME, "MY HOTEL");
    }

    public void setHotelName(String hotelName) {
        editor.putString(KEY_HOTEL_NAME, hotelName);
        editor.commit();
    }

    public String getApiVersion() {
        return pref.getString(KEY_API_VERSION, "v0");
    }

    public void setApiVersion(String apiVersion) {
        editor.putString(KEY_API_VERSION, apiVersion);
        editor.commit();
    }

    //Integer
    //

    /*****************************************(  _______  )****************************************/
    //Clear MySettings details
    public void clearSettingsDetails() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }

}
