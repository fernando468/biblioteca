package com.app.backend.event.dto;

import java.util.UUID;

import com.app.backend.event.Event;
import com.app.backend.library.dto.LibraryResponseDTO;
import com.app.backend.shared.utils.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDTO {
    private UUID id;
    private String title;
    private LibraryResponseDTO library;
    private String hour;
    private String date;
    private String status;

    public static EventResponseDTO toDTO(Event event) {
        return new EventResponseDTO(
                event.getId(),
                event.getTitle(),
                LibraryResponseDTO.toDTO(event.getLibrary()),
                event.getHour(),
                DateUtil.formatToDDMMYYYY(event.getDate()),
                event.getStatus().toString()
        );
    }
    
}