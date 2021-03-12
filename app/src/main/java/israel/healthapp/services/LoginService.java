package israel.healthapp.services;

import android.content.Context;

import israel.healthapp.dao.SharedPreferencesManager;
import israel.healthapp.models.User;
import israel.healthapp.services.request.LoginRequest;
import israel.healthapp.services.response.LoginResponse;

public class LoginService {
    private static LoginService instance = new LoginService();

    public LoginService() {}
    public static LoginService getInstance() { return instance;}

    public LoginResponse getLoginResponse(LoginRequest request) {
        LoginResponse response = getSharePreferencesManager(request.getContext()).getLoginResponse(request);

        if(response.isSuccess()) {
            RegisterService.getInstance().setCurrentUser(response.getUser());
        }

        return response;
    }

    SharedPreferencesManager getSharePreferencesManager(Context context) {
        return SharedPreferencesManager.getInstance(context);
    }
}
