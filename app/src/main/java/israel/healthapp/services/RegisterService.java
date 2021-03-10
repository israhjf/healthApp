package israel.healthapp.services;

import java.io.IOException;
import israel.healthapp.services.request.RegisterRequest;
import israel.healthapp.services.response.RegisterResponse;

public interface RegisterService {
    RegisterResponse getRegisterResponse(RegisterRequest request)
            throws IOException;
}

