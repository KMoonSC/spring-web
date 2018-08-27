package com.myspring.repo;

import com.myspring.entity.UserAdmin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * created by xuyuan 18/8/27
 */
@Repository
@Transactional
public class UserAdminRepo {

    @Resource
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public UserAdmin findOne(int id) {
        Object o = currentSession().get(UserAdmin.class, id);
        return (UserAdmin) o;
    }
}
