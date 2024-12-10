package org.example.labb.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "horse", schema = "labs_java")
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhorse", nullable = false)
    private Integer id;

    @Column(name = "nickname", length = 45)
    private String nickname;


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

}