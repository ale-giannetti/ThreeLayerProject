package it.unikey.esercizioconnessionelibrary.BLL.mapper;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.AuthorDTO;
import it.unikey.esercizioconnessionelibrary.DAL.entities.AuthorEntities;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO fromAuhtorEntityToAuthorDto(AuthorEntities entity);
    AuthorEntities fromAuthorDtoToAuthorEntity(AuthorDTO dto);
}
