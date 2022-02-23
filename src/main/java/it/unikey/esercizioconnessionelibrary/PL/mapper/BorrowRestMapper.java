package it.unikey.esercizioconnessionelibrary.PL.mapper;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.BorrowDTO;
import it.unikey.esercizioconnessionelibrary.PL.rest.BorrowRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowRestMapper {

    BorrowRest formBorrowDtoToBorrowRest(BorrowDTO dto);
    BorrowDTO fromBorrowRestToBorrowDto(BorrowRest rest);

}
