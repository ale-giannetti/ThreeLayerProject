package it.unikey.esercizioconnessionelibrary.BLL.mapper;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.BookDTO;
import it.unikey.esercizioconnessionelibrary.DAL.entities.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    BookDTO fromBookEntitiesToBookDto(BookEntity entity);
    BookEntity fromBookDtoToBookEntity(BookDTO dto);
}
