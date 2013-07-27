package com.trailblazers.freewheelers.mappers;

import com.trailblazers.freewheelers.model.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface AddressMapper {

    @Insert(
            "INSERT INTO address (account_id, street1, street2, city, state, country, zipCode) " +
                    "VALUES (#{account_id}, #{street1}, #{street2}, #{city}, #{state}, #{country}, #{zipCode})"
    )
    @Options(keyProperty = "address_id", useGeneratedKeys = true)
    void insert(Address address);
    @Select(
            "SELECT address_id,account_id,street1, street2, city, state, country, zipCode " +
                    "FROM address " +
                    "WHERE address_id = #{address_id}"
    )
    Address getById(Long address_id);
}
