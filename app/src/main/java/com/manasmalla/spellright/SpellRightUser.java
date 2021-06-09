package com.manasmalla.spellright;

import android.content.Context;
import android.content.SharedPreferences;

import com.manasmalla.spellright.enums.Character;
import com.manasmalla.spellright.enums.DifficultyLevel;
import com.manasmalla.spellright.enums.Goal;
import com.manasmalla.spellright.enums.Language;
import com.manasmalla.spellright.enums.Motivation;

import java.util.HashSet;
import java.util.Set;

public class SpellRightUser {

    private static SharedPreferences sharedPreferences;

    String username, password;

    public SpellRightUser(String username, String password){
        this.username = username;
        this.password = password;
        sharedPreferences.edit().putString("currentUsername", username).commit();
        sharedPreferences.edit().putString("Password"+username, password).commit();
        sharedPreferences.edit().putInt("numberOfUsers", getNumberOfUsers()+1).commit();
        Set<String> usernames = sharedPreferences.getStringSet("listOfUsernames", new HashSet<>());
        usernames.add(username);
        sharedPreferences.edit().putStringSet("listOfUsernames", usernames).commit();
    }

    public static void initialiseSharedPreferences(Context context){
        sharedPreferences = context.getSharedPreferences("com.manasmalla.spellright", Context.MODE_PRIVATE);
    }

    public static void setGuestUser(boolean isGuestUser){
        sharedPreferences.edit().putBoolean("isGuestUser", isGuestUser).commit();
    }

    public static void setCharacter(Character character){
        sharedPreferences.edit().putString("Character"+ getUsername(), character.name()).commit();
    }
    public static void setNativeLanguage(Language language){
        sharedPreferences.edit().putString("NativeLanguage"+ getUsername(), language.name()).commit();
    }
    public static void setMotivation(Motivation motivation){
        sharedPreferences.edit().putString("Motivation"+ getUsername(), motivation.name()).commit();
    }
    public static void setDifficultyLevel(DifficultyLevel difficultyLevel){
        sharedPreferences.edit().putString("DifficultyLevel"+ getUsername(), difficultyLevel.name()).commit();
    }
    public static void setGoal(Goal goal, OnSuccessListener mListener){
        sharedPreferences.edit().putString("Goal"+ getUsername(), goal.name()).commit();
        mListener.onSuccess();
    }

    public static String getUsername() {
        if (isGuestUser()){
            return "GUEST";
        }else{
            return sharedPreferences.getString("currentUsername","GUEST");
        }
    }

    public static boolean isCurrentUsernameAvailable(){
        return !sharedPreferences.getString("currentUsername", "").matches("");
    }

    public static boolean isGuestUser(){
        return sharedPreferences.getBoolean("isGuestUser", false);
    }

    public static boolean areUsersAvailable(){
        if (!isGuestUser()){
            return getNumberOfUsers() > 0;
        }else{
            return true;
        }
    }

    public static int getNumberOfUsers(){
        return sharedPreferences.getInt("numberOfUsers", 0);
    }

    public interface OnSuccessListener{
        void onSuccess();
    }

}
