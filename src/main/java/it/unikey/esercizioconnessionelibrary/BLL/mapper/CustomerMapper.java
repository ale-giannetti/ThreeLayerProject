package it.unikey.esercizioconnessionelibrary.BLL.mapper;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnessionelibrary.DAL.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO fromCustomerEntityToCustomerDto(CustomerEntity entity);
    CustomerEntity fromCustomerDtoToCustomerEntity(CustomerDTO dto);

}
