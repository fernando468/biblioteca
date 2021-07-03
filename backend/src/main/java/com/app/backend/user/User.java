package com.app.backend.user;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.app.backend.shared.models.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "Users")
public class User extends BaseEntity {
    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Embedded
    private Password password;

    @OneToOne
    @JoinColumn(columnDefinition = "VARBINARY(2147483647) default '7e7f1b883f0b4503b5c4bead1623dcaf'")
    private Role role;
}
