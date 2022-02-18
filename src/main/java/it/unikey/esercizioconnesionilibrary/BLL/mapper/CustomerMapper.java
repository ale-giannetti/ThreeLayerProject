package it.unikey.esercizioconnesionilibrary.BLL.mapper;


import it.unikey.esercizioconnesionilibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnesionilibrary.DAL.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO fromCustomerEntityToCustomerDTO(CustomerEntity entity);
    CustomerEntity fromCustomerDTOToCustomerEntity(CustomerDTO dto);
}
