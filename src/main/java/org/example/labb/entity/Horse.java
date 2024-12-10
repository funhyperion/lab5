package org.example.labb.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "horse", schema = "labs_java")
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhorse", nullable = false)
    private Integer id;

    @Column(name = "nickname", length = 45)
    private String nickname;

    @Column(name = "gender", length = 45)
    private String gender;

    @Column(name = "breed", length = 45)
    private String breed;

    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "owner_idowner", referencedColumnName = "idowner")
    private Owner owner;

    @ManyToMany(mappedBy = "horses")
    private List<Jokey> jokeys = new ArrayList<>(); // Коллекция для жокеев

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public Integer getAge() {
        return age;

    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public List<Jokey> getJokey() {
        return jokeys;
    }

    public void setJokey(List<Jokey> jokeys) {
        this.jokeys = jokeys;
    }

}