package com.ipap.backendapi.customer;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customer",
        uniqueConstraints = {
                @UniqueConstraint(name = "customer_email_unique", columnNames = "email"),
                @UniqueConstraint(name = "profile_image_id_unique", columnNames = "profile_image_id")
        })
public class Customer implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "customer_id_seq",
            sequenceName = "customer_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_seq"
    )
    private Integer id;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;
    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "profile_image_id", nullable = true, columnDefinition = "TEXT")
    private String profileImageId;

    public Customer() {
    }

    public Customer(Integer id, String name, String email, String password, Integer age, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public Customer(Integer id, String name, String email, String password, Integer age, Gender gender, String profileImageId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.profileImageId = profileImageId;
    }

    public Customer(String name, String email, String password, Integer age, Gender gender, String profileImageId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.profileImageId = profileImageId;
    }

    public Customer(String name, String email, String password, Integer age, Gender gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getProfileImageId() {
        return profileImageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password; // TODO: encrypt password
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password) && Objects.equals(age, customer.age) && gender == customer.gender && Objects.equals(profileImageId, customer.profileImageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, age, gender, profileImageId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", profileImageId='" + profileImageId + '\'' +
                '}';
    }
}
