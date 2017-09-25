package com.thoughtworks.futurestar.service.Impl;

import com.thoughtworks.futurestar.dto.AddressDTO;
import com.thoughtworks.futurestar.entity.Address;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.repository.AddressRepository;
import com.thoughtworks.futurestar.repository.UserRepository;
import com.thoughtworks.futurestar.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createAddress(AddressDTO addressDTO, String user_id) {
        User user = userRepository.findOne(user_id);
        Address address = Address.builder().id(UUID.randomUUID().toString()).address(addressDTO.getAddress()).user(user).build();
        addressRepository.save(address);
    }

    @Override
    public List<String> getAddressList(String user_id) {
        User user = userRepository.findOne(user_id);
        return addressRepository.findAllByUser(user).stream().map(address -> address.getAddress()).collect(Collectors.toList());
    }
}
