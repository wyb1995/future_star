package com.thoughtworks.futurestar.repository;

import com.thoughtworks.futurestar.entity.Address;
import com.thoughtworks.futurestar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, String>{
    List<Address> findAllByUser(User user);
}
