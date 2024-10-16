package com.eroudini.banking.controllers;

import com.eroudini.banking.dto.ContactDto;
import com.eroudini.banking.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contact")
@RequiredArgsConstructor

public class ContactController {

    private final ContactService service;


    @PostMapping("/")
    public ResponseEntity<Integer> save(
            @RequestBody ContactDto ContactDto
    ) {
        return ResponseEntity.ok(service.save(ContactDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ContactDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{contact-id}")
    public ResponseEntity<ContactDto> findById(
            @PathVariable("contact-id") Integer ContactId
    ) {
        return ResponseEntity.ok(service.findById(ContactId));
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<ContactDto>> findAllByUserId(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.findAllByUserId(userId));
    }

    @DeleteMapping("/{contact-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("contact-id") Integer ContactId
    ) {
        service.delete(ContactId);
        return ResponseEntity.accepted().build();
    }
}
