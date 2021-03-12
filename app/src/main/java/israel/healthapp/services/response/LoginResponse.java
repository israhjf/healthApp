package israel.healthapp.services.response;

import israel.healthapp.models.User;

public class LoginResponse extends Response {
    private User user;

    public LoginResponse(String message) {
        super(false);
        this.message = message;
    }

    public LoginResponse(User user) {
        super(true);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
