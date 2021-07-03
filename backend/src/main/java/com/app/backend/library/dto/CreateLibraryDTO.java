package com.app.backend.library.dto;

import com.app.backend.library.Library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLibraryDTO {
    private String cep;
    private String address;
    private String city;
    private String number;
    private String name;
    private String neighborhood;
    
    public static CreateLibraryDTO toDTO(Library library) {
        return new CreateLibraryDTO(
                library.getCep(),
                library.getAddress(),
                library.getCity(),
                library.getNumber(),
                library.getName(),
                library.getNeighborhood()
        );
    }

    public Library toEntity() {
        return new Library(this.cep, this.address, this.city, this.number, this.name, this.neighborhood);
    }
}
