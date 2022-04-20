package com.novatec.test.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table("users")
public class User {
    @Id
    private Integer id;

    @Column("first_name")
    @NotNull(message = "Debe insertar un nombre")
    @Size(min=4, max=50, message = "El nombre debe contener entre 4 y 50 caracteres")
    private String firstName;

    @Column("last_name")
    @NotNull(message = "Debe insertar un apellido")
    @Size(min=4, max=50, message = "El apellido debe contener entre 4 y 50 caracteres")
    private String lastName;

    @NotNull(message = "Debe seleccionar un rol")
    private Boolean role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }
}
