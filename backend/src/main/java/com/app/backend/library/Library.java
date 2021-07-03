package com.app.backend.library;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.app.backend.shared.models.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Library extends BaseEntity {
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String neighborhood;
}
