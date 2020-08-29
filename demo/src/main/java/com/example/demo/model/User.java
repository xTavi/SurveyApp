//package com.example.demo.model;
//
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "auth_user")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "auth_user_id")
//    private int id;
//
//    @Column(name = "first_name")
//    private String name;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "password")
//    private String password;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name= "auth_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
//    private Set<Role> role;
//
//}
