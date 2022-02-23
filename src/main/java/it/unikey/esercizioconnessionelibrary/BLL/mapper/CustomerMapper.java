package it.unikey.esercizioconnessionelibrary.BLL.mapper;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnessionelibrary.DAL.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerDTO fromCustomerEntityToCustomerDto(CustomerEntity entity);
    CustomerEntity fromCustomerDtoToCustomerEntity(CustomerDTO dto);

}
