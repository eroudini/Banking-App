package com.eroudini.banking.repository;

import com.eroudini.banking.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
