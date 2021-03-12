package israel.healthapp.services;

import android.content.Context;

import israel.healthapp.dao.SharedPreferencesManager;
import israel.healthapp.models.User;
import israel.healthapp.services.request.RegisterRequest;
import israel.healthapp.services.response.RegisterResponse;

public class RegisterService {

    private static RegisterService instance = new RegisterService();
    private User currentUser;

    public RegisterService() {}
    public static RegisterService getInstance() { return instance;}

    public RegisterResponse getRegisterResponse(RegisterRequest request){
        RegisterResponse response = getSharePreferencesManager(request.getContext()).getRegisterResponse(request);

        if(response.isSuccess()) {
            setCurrentUser(response.getUser());
        }

        return response;
    }

    SharedPreferencesManager getSharePreferencesManager(Context context) {
        return SharedPreferencesManager.getInstance(context);
    }

    public void setCurrentUser(User user){
        this.currentUser = user;
    }
    public User getCurrentUser() {
        return currentUser;
    }
}
