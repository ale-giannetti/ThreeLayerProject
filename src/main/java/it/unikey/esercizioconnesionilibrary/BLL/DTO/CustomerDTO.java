package it.unikey.esercizioconnesionilibrary.BLL.DTO;

import it.unikey.esercizioconnesionilibrary.DAL.entity.BorrowEntity;
import lombok.Data;

import java.util.Set;

@Data
public class CustomerDTO {
    private Integer id;
    private String name;
    private String surname;
    private Set<BorrowDTO> borrowsDTO;
}
