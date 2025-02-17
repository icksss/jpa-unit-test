package jpastart.reserve.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class GrantedPermission {
    private String permission;
    private String grantor;

    public GrantedPermission(){}

    public GrantedPermission(String permission, String grantor){
        this.permission = permission;
        this.grantor = grantor;
    }

    public String getPermission() {
        return permission;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    @Override
    public String toString() {
        return "GrantedPermission [permission=" + permission + ", grantor=" + grantor + "]";
    }
}