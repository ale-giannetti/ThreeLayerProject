package it.unikey.esercizioconnessionelibrary.BLL.mapper;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.AuthorDTO;
import it.unikey.esercizioconnessionelibrary.DAL.entities.AuthorEntities;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper {

    AuthorDTO fromAuhtorEntityToAuthorDto(AuthorEntities entity);
    AuthorEntities fromAuthorDtoToAuthorEntity(AuthorDTO dto);
}
