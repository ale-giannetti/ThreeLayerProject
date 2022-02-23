package it.unikey.esercizioconnessionelibrary.PL.mapper;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.BookDTO;
import it.unikey.esercizioconnessionelibrary.PL.rest.BookRest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookRestMapper {
    BookRest fromBookDtoToBookRest(BookDTO dto);
    BookDTO fromBookRestToBookDto(BookRest rest);
}
