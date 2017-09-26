package com.thoughtworks.futurestar.service.Impl;

import com.thoughtworks.futurestar.dto.AddressDTO;
import com.thoughtworks.futurestar.entity.Address;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.exception.InvalidCredentialException;
import com.thoughtworks.futurestar.repository.AddressRepository;
import com.thoughtworks.futurestar.repository.UserRepository;
import com.thoughtworks.futurestar.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createAddress(AddressDTO addressDTO, String user_id) {
        User user = userRepository.findOne(user_id);
        if (user == null) {
            throw new InvalidCredentialException("not login");
        }

        Address address = Address.builder().id(UUID.randomUUID().toString()).address(addressDTO.getAddress()).build();
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        user.setAddresses(addresses);
        addressRepository.save(address);
        userRepository.save(user);
    }

    @Override
    public List<Address> getAddressList(String user_id) {
        User user = userRepository.findOne(user_id);
        if (user == null) {
            throw new InvalidCredentialException("no login");
        }
        if (user.getAddresses() == null) {
            List<Address> addresses = new ArrayList<>();

            user.setAddresses(addresses);

            userRepository.save(user);
        }
        return user.getAddresses();
    }
}
