package com.eroudini.banking.services.Implt;

import com.eroudini.banking.dto.AccountDto;
import com.eroudini.banking.exceptions.ObjectsValidator;
import com.eroudini.banking.exceptions.OperationNonPermittedException;
import com.eroudini.banking.models.Account;
import com.eroudini.banking.repository.AccountRepository;
import com.eroudini.banking.services.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final ObjectsValidator<AccountDto> validator;

    @Override
    public Integer save(AccountDto dto) {

        // block account update iban cannot be changed
        if (dto.getId() != null){
            throw new OperationNonPermittedException("Message", "Détails", "Code", "Raison");
        }
        validator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        boolean UserHasAlreadyAnAccount = repository.findByUserId(account.getUser().getId()).isPresent();
        if (UserHasAlreadyAnAccount){
            throw new OperationNonPermittedException("L'utilisateur a deja un compte","","","");
        }
        // generate iban
        account.setIban(generateRandomIban());

        return repository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {


        return repository.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Integer id) {
        return repository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun compte trouver avec cet Id"));
    }

    @Override
    public void delete(Integer id) {

        repository.deleteById(id);
    }

    private String generateRandomIban(){
        // generer un iban
        String iban = Iban.random(CountryCode.FR).toFormattedString();
        // check s'il existe ou pas
        boolean ibanExists = repository.findByIban(iban).isPresent();
        // si oui en generer un autre
        if (ibanExists){
            generateRandomIban();
        }
        // s'il existe pas return generated iban

        return iban;

    }
}
