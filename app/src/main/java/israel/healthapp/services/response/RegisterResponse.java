package israel.healthapp.services.response;

import israel.healthapp.models.User;

public class RegisterResponse extends Response {
    private User user;

    public RegisterResponse(String message) {
        super(false);
        this.message = message;
    }

    public RegisterResponse(User user) {
        super(true);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
