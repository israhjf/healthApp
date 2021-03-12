package israel.healthapp.services.request;

import android.content.Context;

import israel.healthapp.models.User;

public class RegisterRequest {
    private User user;
    private Context context;

    public RegisterRequest() {}

    public RegisterRequest(User user, Context context) {
        this.user = user;
        this.context = context;
    }

    public User getUser() {
        return user;
    }

    public Context getContext() {
        return context;
    }
}
