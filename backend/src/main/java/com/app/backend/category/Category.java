package com.app.backend.category;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.app.backend.shared.models.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
