package com.myspring.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * created by xuyuan 18/8/27
 */
@Table(name = "adm_admin")
@Data
@Entity
public class UserAdmin {

    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    private int adminId;
    @Column(name = "username")
    private String username;
}
