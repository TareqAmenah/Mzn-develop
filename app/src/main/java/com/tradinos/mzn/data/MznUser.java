package com.tradinos.mzn.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.tradinos.mzn.models.FormData;
import com.tradinos.mzn.models.User;

public class MznUser {

    private static String PREFERENCE_FILE_NAME = "MyUser";
    private static String USER_KEY = "UserKey";

    private static MznUser INSTANCE;
    private static User myUser;
    private FormData formData;

    public static MznUser getINSTANCE() {

        //TODO get the user from shared preference
        if(INSTANCE == null)
            INSTANCE = new MznUser();
        return INSTANCE;
    }

    public void clear(Context context) {
//        if(myUser == null)
//            return;

        SharedPreferences mPrefs = context.getSharedPreferences(PREFERENCE_FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        prefsEditor.clear().apply();
        myUser = null;
    }

    public class UserNotFoundException extends Exception{
        @Override
        public String getMessage() {
            return "User not found";
        }
    }

    //TODO: Is this acceptable?
    public void saveUser(User user, Context context){
        SharedPreferences mPrefs = context.getSharedPreferences(PREFERENCE_FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        prefsEditor.putString(USER_KEY, json);
        prefsEditor.commit();

        myUser = user;
    }

    private User getUserFromPreference(Context context) throws UserNotFoundException{
        SharedPreferences mPrefs = context.getSharedPreferences(PREFERENCE_FILE_NAME,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString(USER_KEY, "");

        if(json==null || json.equals(""))
            throw new UserNotFoundException();
        User user = gson.fromJson(json, User.class);
        return user;
    }

    public User getMyUser(Context context) throws UserNotFoundException {
        if (myUser!= null)
            return myUser;

        User user = getUserFromPreference(context);
        return user;
    }

    public void setFormData(FormData formData){
        this.formData = formData;
    }

    public FormData getFormData(){
        return formData;
    }
}
