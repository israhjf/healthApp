package israel.healthapp.presenters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import israel.healthapp.models.User;
import israel.healthapp.services.RegisterService;
import israel.healthapp.services.request.LoginRequest;
import israel.healthapp.services.request.RegisterRequest;
import israel.healthapp.services.response.LoginResponse;
import android.content.Context;
import androidx.test.core.app.ApplicationProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPresenterTest {
    private final User user = new User("Daffy", "11/01/1991",
            5.4f,145.6f, "F","Beginner");

    private LoginPresenter.View view;
    private LoginPresenter presenter;
    private LoginRequest resquest;
    private Context context = ApplicationProvider.getApplicationContext();

    @BeforeEach
    public void setup(){
        view = Mockito.mock(LoginPresenter.View.class);
        presenter = new LoginPresenter(view);
        resquest = new LoginRequest(context);
    }


    @Test
    public void getLoginResponse_userNotLoggedIn_returnsFalse() {
        LoginResponse response = presenter.getLoginResponse(resquest);
        assertEquals(response.success, false);
    }

    @Test
    public void getLoginResponse_userLoggedIn_returnsUser() {
        RegisterService registerService = new RegisterService();
        registerService.getRegisterResponse(new RegisterRequest(user, context));

        LoginResponse response = presenter.getLoginResponse(resquest);
        assertEquals(response.success, true);
    }
}