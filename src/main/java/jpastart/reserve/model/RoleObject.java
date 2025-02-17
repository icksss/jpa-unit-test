package jpastart.reserve.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class RoleObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleObject_seq_gen")
    private Long id;
    private String name;

    @ElementCollection(fetch = jakarta.persistence.FetchType.EAGER)
    @CollectionTable(name = "role_perm", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "perm")
    private Set<GrantedPermission> permissions = new HashSet<>();

    public RoleObject(){}

    public RoleObject(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<GrantedPermission> getPermissions() {
        return permissions;
    }

    public void setId(Long id) {
        this.id = id;
    }       

    public void setName(String name) {
        this.name = name;
    }

    public void setPermissions(Set<GrantedPermission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "RoleObject [id=" + id + ", name=" + name + ", permissions=" + permissions + "]";
    }
}   