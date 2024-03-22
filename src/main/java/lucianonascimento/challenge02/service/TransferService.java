package lucianonascimento.challenge02.service;

import lucianonascimento.challenge02.apiClient.TransferAuthorizationClient;
import lucianonascimento.challenge02.apiClient.dto.TransferAuthorizationResponse;
import lucianonascimento.challenge02.controller.dto.TransferRequest;
import lucianonascimento.challenge02.model.UserTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private UserService userService;
    @Autowired
    private TransferAuthorizationClient transferAuthorizationClient;
    public static final String TRANSFR_AUTHORIZATION_OK = "Autorizado";

    public Boolean transfer (TransferRequest transferRequestDto) {

        UserTypeEnum userType = userService.getUserType(transferRequestDto.payer());
        if (userType.getDescricao().equals(UserTypeEnum.DEFAULT.getDescricao()))
        {
            //@todo
            TransferAuthorizationResponse transferAuthorizationResponse = transferAuthorizationClient.getTransferAuthorization();
            if (transferAuthorizationResponse.message().equals(TRANSFR_AUTHORIZATION_OK)) {
                //@todo
                //do transference
                //call notification endpoint
            }
            return true;
        }

        return false;
    }
}
