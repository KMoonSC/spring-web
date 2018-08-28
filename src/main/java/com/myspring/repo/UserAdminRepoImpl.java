package com.myspring.repo;

import com.myspring.entity.UserAdmin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * created by xuyuan 18/8/27
 */
@Repository
@Transactional(value = "hibernateTransactionManager")
public class UserAdminRepoImpl implements UserAdminRepo {

    @Resource
    private SessionFactory sessionFactory;

//    @PersistenceContext
//    private EntityManager em;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public UserAdmin findOne(int id) {
        return currentSession().get(UserAdmin.class, id);
    }

//    public UserAdmin findOne(int id) {
//        return em.find(UserAdmin.class, id);
//    }
}
