package israel.healthapp.presenters;

import israel.healthapp.models.User;
import israel.healthapp.services.RegisterService;

public abstract class Presenter {

    public User getCurrentUser() {
        return RegisterService.getInstance().getCurrentUser();
    }
}