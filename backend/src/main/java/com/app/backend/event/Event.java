package com.app.backend.event;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.app.backend.library.Library;
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
public class Event extends BaseEntity {
    @Column(nullable = false)
    private String title;
    
    @ManyToOne
    private Library library;
    
    @Column(nullable = false)
    private String hour;

    @Column(nullable = false)
    private LocalDate date;

    private Status status;
}
