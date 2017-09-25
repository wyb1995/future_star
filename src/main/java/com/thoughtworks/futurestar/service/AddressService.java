package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.dto.AddressDTO;

public interface AddressService {
    void createAddress(AddressDTO addressDTO, String user_id);
}
