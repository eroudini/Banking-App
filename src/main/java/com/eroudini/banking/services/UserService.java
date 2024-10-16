package com.eroudini.banking.services;

import com.eroudini.banking.dto.UserDto;

public interface UserService extends AbstractService<UserDto>{

    Integer validateAccount(Integer id);

    Integer invalidateAccount(Integer id);
}
