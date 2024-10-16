package com.eroudini.banking.services;

import com.eroudini.banking.dto.TransactionDto;

import java.util.List;

public interface TransactionService extends AbstractService<TransactionDto>{
    List<TransactionDto> findAllByUserId(Integer userId);
}
