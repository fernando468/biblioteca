package com.app.backend.language;

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
public class Language extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
