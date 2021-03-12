package israel.healthapp.services.request;

import android.content.Context;

public class LoginRequest {
    private Context context;

    public LoginRequest(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
