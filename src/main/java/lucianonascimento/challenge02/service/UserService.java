package lucianonascimento.challenge02.service;

import lucianonascimento.challenge02.apiClient.TransferAuthorizationClient;
import lucianonascimento.challenge02.model.UserTypeEnum;
import lucianonascimento.challenge02.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserTypeEnum getUserType(Long UserId) {
        var user = userRepository.getReferenceById(UserId);
        return user.getType();
    }
}
