package com.myspring.repo;

import com.myspring.entity.UserAdmin;

public interface UserAdminRepo {

    UserAdmin findOne(int id);

}
