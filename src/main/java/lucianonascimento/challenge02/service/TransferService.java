package lucianonascimento.challenge02.service;

import lucianonascimento.challenge02.dto.TransferRequestDto;
import lucianonascimento.challenge02.model.UserTypeEnum;
import lucianonascimento.challenge02.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private UserService userService;

    public Boolean transfer (TransferRequestDto transferRequestDto) {

        UserTypeEnum userType = userService.getUserType(transferRequestDto.payer());
        if (userType.getDescricao().equals(UserTypeEnum.DEFAULT))
        {
            //@todo
            //start transaction
            //transference
            //call authorization endpoint
            //call notification endpoint
            return true;
        }

        return false;
    }
}
