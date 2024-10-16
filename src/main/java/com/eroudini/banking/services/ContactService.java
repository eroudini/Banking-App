package com.eroudini.banking.services;

import com.eroudini.banking.dto.ContactDto;

import java.util.List;

public interface ContactService extends AbstractService<ContactDto>{

    List<ContactDto> findAllByUserId(Integer userId);
}
