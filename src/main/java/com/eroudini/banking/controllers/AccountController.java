package com.eroudini.banking.controllers;

import com.eroudini.banking.dto.AccountDto;
import com.eroudini.banking.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {


    private final AccountService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(
            @RequestBody AccountDto AccountDto
    ) {
        return ResponseEntity.ok(service.save(AccountDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<AccountDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{account-id}")
    public ResponseEntity<AccountDto> findById(
            @PathVariable("account-id") Integer AccountId
    ) {
        return ResponseEntity.ok(service.findById(AccountId));
    }

    @DeleteMapping("/{account-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("account-id") Integer AccountId
    ) {
        service.delete(AccountId);
        return ResponseEntity.accepted().build();
    }


}
