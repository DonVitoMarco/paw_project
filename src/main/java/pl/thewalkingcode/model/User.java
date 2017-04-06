package pl.thewalkingcode.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_has_role",
                joinColumns = {@JoinColumn(name = "idUser")},
                inverseJoinColumns = {@JoinColumn(name = "idRole")})
    private List<Role> roles;

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}