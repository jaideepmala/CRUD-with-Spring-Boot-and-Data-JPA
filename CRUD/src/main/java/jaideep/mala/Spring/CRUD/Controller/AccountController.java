package jaideep.mala.Spring.CRUD.Controller;

import jaideep.mala.Spring.CRUD.DTO.AccountsInputDTO;
import jaideep.mala.Spring.CRUD.DTO.OutputDTO;
import jaideep.mala.Spring.CRUD.Model.Account;
import jaideep.mala.Spring.CRUD.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping(value="/create")
    public ResponseEntity<?> addAccount(@RequestBody AccountsInputDTO accountsInputDTO) throws Exception {
        OutputDTO r1 =accountService.createAccount(accountsInputDTO);
        return new ResponseEntity<>(r1, HttpStatus.CREATED);
    }
    @GetMapping(value = "/getallusers")
    public List<Account> getAllAccounts() throws Exception{
        List<Account> li = accountService.getAllAccounts();
        return li;

    }
    @GetMapping(value = "/getuser/{acc_no}")
    public ResponseEntity<?> getAccountById(@PathVariable (value = "acc_no") Long acc_no) throws Exception
    {
        ResponseEntity<Account> accountByid = accountService.getByAccno(acc_no);
        return new ResponseEntity<>(accountByid, HttpStatus.OK);
    }
}

