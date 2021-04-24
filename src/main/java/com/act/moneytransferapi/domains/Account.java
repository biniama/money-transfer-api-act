package com.act.moneytransferapi.domains;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Account class that defines the properties and will be mapped to a table using ORM.
 *
 * @author Biniam Asnake
 */
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "First name cannot be empty.")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "Last name cannot be empty.")
    private String lastName;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer pin;

    @Column(nullable = false)
    private Boolean isVerified = Boolean.TRUE;

    @Column(nullable = false)
    private Double balance = 0.0;
}
