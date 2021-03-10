package israel.healthapp.presenters;

import israel.healthapp.models.User;
import israel.healthapp.services.RegisterServiceProxy;

public abstract class Presenter {

    public User getCurrentUser() {
        return RegisterServiceProxy.getInstance().getCurrentUser();
    }
}