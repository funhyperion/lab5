package org.example.labb.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "jokey")
public class Jokey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jokeyid", nullable = false)
    private Integer id;

    @Column(name = "jokey_namel", length = 45)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "jokey_has_horse",
            joinColumns = @JoinColumn(name = "jokey_jokey"),
            inverseJoinColumns = @JoinColumn(name = "horse_idhorse")
    )
    private List<Horse> horses = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }
}
