package it.unikey.esercizioconnesionilibrary.BLL.mapper;


import it.unikey.esercizioconnesionilibrary.BLL.DTO.BorrowDTO;
import it.unikey.esercizioconnesionilibrary.DAL.entity.BorrowEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowMapper {
    BorrowDTO fromBorrowEntityToBorrowDTO(BorrowEntity entity);
    BorrowEntity fromBorrowDTOToBorrowEntity(BorrowDTO dto);
}
