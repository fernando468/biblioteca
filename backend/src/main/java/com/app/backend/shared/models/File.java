package com.app.backend.shared.models;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class File extends BaseEntity {
    private String fileName;
    private String originalFileName;
    private String url;
}
