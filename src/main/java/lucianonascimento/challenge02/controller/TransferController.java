package lucianonascimento.challenge02.controller;

import lucianonascimento.challenge02.controller.dto.TransferRequest;
import lucianonascimento.challenge02.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    public String transfer(@RequestBody TransferRequest transferRequest) {
         var transferResult = transferService.transfer(transferRequest);

        if (transferResult) {
            return "Transfer succeed.";
        }
        return "Transfer Failed.";
    }
}
