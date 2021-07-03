package com.app.backend.library.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.app.backend.library.Library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryResponseDTO {
    private UUID id;
    private String cep;
    private String address;
    private String city;
    private String number;
    private String name;

    @NotBlank(message = "Name is required")
    private String neighborhood;

    public static LibraryResponseDTO toDTO(Library library) {
        return new LibraryResponseDTO(
                library.getId(),
                library.getCep(),
                library.getAddress(),
                library.getCity(),
                library.getNumber(),
                library.getName(),
                library.getNeighborhood()
        );
    }
}
