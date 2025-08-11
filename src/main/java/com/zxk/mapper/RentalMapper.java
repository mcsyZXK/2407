package com.zxk.mapper;

import com.zxk.entity.Rental;
import com.zxk.entity.RentalVO;

public interface RentalMapper {
    RentalVO[] getAll();
    RentalVO[] getUser(String email);
    Integer deleteRental(Integer id);
    Integer insert(Rental rental);

}
