package israel.healthapp.presenters;

import java.io.IOException;

import israel.healthapp.services.RegisterService;
import israel.healthapp.services.request.RegisterRequest;
import israel.healthapp.services.response.RegisterResponse;

public class RegisterPresenter extends Presenter {
    private final View view;

    public interface View {
        // If needed, specify methods here that will be called on the view in response to model updates
    }

    public RegisterPresenter(View view) {
        this.view = view;
    }

    public RegisterResponse getRegisterResponse(RegisterRequest request) {
        RegisterService registerService = getRegisterService();
        return registerService.getRegisterResponse(request);
    }

    RegisterService getRegisterService() {
        return new RegisterService();
    }
}
