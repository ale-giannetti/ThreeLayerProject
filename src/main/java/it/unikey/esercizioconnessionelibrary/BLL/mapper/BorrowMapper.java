package it.unikey.esercizioconnessionelibrary.BLL.mapper;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.BorrowDTO;
import it.unikey.esercizioconnessionelibrary.DAL.entities.BorrowEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BorrowMapper {
    BorrowDTO fromBorrowEntityToBorrowDto(BorrowEntity entity);
    BorrowEntity fromBorrowDtoToBorrowEntity(BorrowDTO dto);
}
