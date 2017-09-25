package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    void createAddress(AddressDTO addressDTO, String user_id);

    List<String> getAddressList(String user_id);
}
