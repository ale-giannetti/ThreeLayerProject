package it.unikey.esercizioconnessionelibrary.PL.mapper;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnessionelibrary.PL.rest.CustomerRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerRestMapper {

    CustomerRest fromCustmerDtoToCustomerRest (CustomerDTO dto);
    CustomerDTO fromCustomerRestToCustomerDto(CustomerRest rest);

}
