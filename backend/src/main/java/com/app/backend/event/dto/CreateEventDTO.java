package com.app.backend.event.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.backend.event.Event;
import com.app.backend.event.Status;
import com.app.backend.library.Library;
import com.app.backend.shared.utils.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Locale is required")
    private UUID libraryId;

    @NotBlank(message = "Hour is required")
    private String hour;

    @NotBlank(message = "Date is required")
    private String date;

    public Event toEntity() {
        Library library = new Library();
        library.setId(this.libraryId);
        return new Event(
                this.title,
                library,
                this.hour,
                DateUtil.formatToLocalDate(date),
                Status.ABERTO
        );
    }
}
