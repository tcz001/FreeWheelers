package com.trailblazers.freewheelers.mappers;

import com.trailblazers.freewheelers.model.AccountRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface AccountRoleMapper {

    @Insert(
        "INSERT INTO account_role (account_name, role) VALUES (#{account_name}, #{role})"
    )
    @Options(keyProperty = "role_id", useGeneratedKeys = true)
    void insert(AccountRole accountRole);

}
