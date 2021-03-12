package israel.healthapp.presenters;

import israel.healthapp.services.LoginService;
import israel.healthapp.services.request.LoginRequest;
import israel.healthapp.services.response.LoginResponse;

public class LoginPresenter extends Presenter {
    private final LoginPresenter.View view;

    public interface View {
        // If needed, specify methods here that will be called on the view in response to model updates
    }

    public LoginPresenter(LoginPresenter.View view) {
        this.view = view;
    }

    public LoginResponse getLoginResponse(LoginRequest request) {
        LoginService loginService = getLoginService();
        return loginService.getLoginResponse(request);
    }

    LoginService getLoginService() {
        return new LoginService();
    }
}
