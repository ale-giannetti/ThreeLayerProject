package it.unikey.esercizioconnessionelibrary.BLL.mapper;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.BorrowDTO;
import it.unikey.esercizioconnessionelibrary.DAL.entities.BorrowEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowMapper {
    BorrowDTO fromBorrowEntityToBorrowDto(BorrowEntity entity);
    BorrowEntity fromBorrowDtoToBorrowEntity(BorrowDTO dto);
}
