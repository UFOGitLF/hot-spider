package com.hacker.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JPA-Entity
 * Created by Lenovo on 2017/7/1.
 */
@Data
@Entity
@Table(name = "t_phone_tag")
public class PhoneTag {
    @Id
    @GeneratedValue
    private int id;
    private String tag;
    private String url;

}
