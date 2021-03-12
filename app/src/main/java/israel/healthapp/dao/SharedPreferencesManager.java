package israel.healthapp.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import israel.healthapp.models.User;
import israel.healthapp.services.request.LoginRequest;
import israel.healthapp.services.request.RegisterRequest;
import israel.healthapp.services.response.LoginResponse;
import israel.healthapp.services.response.RegisterResponse;

public class SharedPreferencesManager {

    private static final String APP_PREFS_FILE_KEY = "HealthAppSharedPreferences";

    private SharedPreferences sharedPrefs;
    private static SharedPreferencesManager instance;

    private SharedPreferencesManager(Context context) {
        sharedPrefs = context.getApplicationContext()
                .getSharedPreferences(APP_PREFS_FILE_KEY, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPreferencesManager getInstance(Context context){
        if(instance == null)
            instance = new SharedPreferencesManager(context);
        return instance;
    }

    public LoginResponse getLoginResponse(LoginRequest request){
        LoginResponse response;
        try {
            User user = new User(
                    sharedPrefs.getString("name", null),
                    sharedPrefs.getString("birthdate", null),
                    sharedPrefs.getFloat("height", 0.0f),
                    sharedPrefs.getFloat("weight", 0.0f),
                    sharedPrefs.getString("gender", null),
                    sharedPrefs.getString("fitnessLevel", null)
            );
            if (user.getName() != null)
                response = new LoginResponse(user);
            else
                response = new LoginResponse("User Not Logged");
        }
        catch (Exception e){
            response = new LoginResponse("Error: on SharedPreferences getLoginResponse");
            e.printStackTrace();
        }
        return response;
    }

    public RegisterResponse getRegisterResponse(RegisterRequest request) {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        RegisterResponse response;
        try {
            editor.putString("name", request.getUser().getName());
            editor.putString("birthdate", request.getUser().getName());
            editor.putFloat("height", request.getUser().getHeight());
            editor.putFloat("weight", request.getUser().getWeight());
            editor.putString("gender", request.getUser().getGender());
            editor.putString("fitnessLevel", request.getUser().getFitnessLevel());
            editor.apply();
            response = new RegisterResponse(request.getUser());
        }
        catch (Exception e){
            response = new RegisterResponse("Error: on SharedPreferences getRegisterResponse");
            e.printStackTrace();
        }
        return response;
    }
}
