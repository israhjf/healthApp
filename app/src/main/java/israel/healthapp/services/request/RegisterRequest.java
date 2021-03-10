package israel.healthapp.services.request;

import israel.healthapp.models.User;

public class RegisterRequest {
    private User user;

    public RegisterRequest() {}

    public RegisterRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
