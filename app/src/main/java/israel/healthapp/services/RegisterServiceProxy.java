package israel.healthapp.services;

import java.io.IOException;

import israel.healthapp.models.User;
import israel.healthapp.services.request.RegisterRequest;
import israel.healthapp.services.response.RegisterResponse;

public class RegisterServiceProxy implements RegisterService {

    private static RegisterServiceProxy instance = new RegisterServiceProxy();
    private User currentUser;

    public RegisterServiceProxy() {}
    public static RegisterServiceProxy getInstance() {
        return instance;
    }
    public void setCurrentUser(User user){
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public RegisterResponse getRegisterResponse(RegisterRequest request) {
//        RegisterResponse response = getServerFacade().getRegisterResponse(request, URL_PATH);
//
//        if(response.isSuccess()) {
//            setCurrentUser(response.getUser());
//        }
//
//        return response;
        return null;
    }

//    ServerFacade getServerFacade() {
//        return new ServerFacade();
//    }
}
