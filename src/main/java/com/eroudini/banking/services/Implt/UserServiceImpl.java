package com.eroudini.banking.services.Implt;

import com.eroudini.banking.dto.AccountDto;
import com.eroudini.banking.dto.UserDto;
import com.eroudini.banking.exceptions.ObjectsValidator;
import com.eroudini.banking.models.Account;
import com.eroudini.banking.models.User;
import com.eroudini.banking.repository.AccountRepository;
import com.eroudini.banking.repository.UserRepository;
import com.eroudini.banking.services.AccountService;
import com.eroudini.banking.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    private final UserRepository repository;
    private final AccountService accountService;
    private final ObjectsValidator<UserDto> validator;
    @Override
    public Integer save(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
        return repository.save(user).getId();
    }

    @Override
    public List<UserDto> findAll() {

        return repository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return repository.findById(id)
                .map(UserDto::fromEntity) // Utilisation d'une lambda pour mapper l'entité User à UserDto
                .orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur trouvé avec cet id : " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Integer validateAccount(Integer id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur n'a était trouver"));
        user.setActive(true);

        // creation du compte bancaire
        AccountDto account = AccountDto.builder()
                .user(UserDto.fromEntity(user))
                .build();
        accountService.save(account);
        repository.save(user);
        return user.getId();
    }

    @Override
    public Integer invalidateAccount(Integer id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur n'a était trouver"));
        user.setActive(false);

        user.setActive(false);
        repository.save(user);
        return user.getId();

    }
}
