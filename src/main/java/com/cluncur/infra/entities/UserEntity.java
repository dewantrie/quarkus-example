package com.cluncur.infra.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

@Data
@Entity
@Table(name = "public.user")
public class UserEntity extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    public String id;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "name")
    public String name;
}
