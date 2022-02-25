package it.unikey.esercizioconnessionelibrary.BLL.service.impl;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.AuthorDTO;
import it.unikey.esercizioconnessionelibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnessionelibrary.BLL.exception.NotFoundException;
import it.unikey.esercizioconnessionelibrary.BLL.mapper.AuthorMapper;
import it.unikey.esercizioconnessionelibrary.BLL.service.RegistryService;
import it.unikey.esercizioconnessionelibrary.DAL.entities.AuthorEntities;
import it.unikey.esercizioconnessionelibrary.DAL.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements RegistryService<AuthorDTO> {

    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepostory;

    @Override
    public AuthorDTO insert(AuthorDTO entity) {
        return authorMapper.fromAuhtorEntityToAuthorDto(authorRepostory
                .save(authorMapper
                        .fromAuthorDtoToAuthorEntity(entity)));
    }

    @Override
    public AuthorDTO getById(Integer id) throws NotFoundException {
        if (!authorRepostory.existsById(id)) {
            throw new NotFoundException("L'autore non è presente nel DB");
        }
        return authorMapper.fromAuhtorEntityToAuthorDto(authorRepostory.getById(id));
    }

    @Override
    public Set<AuthorDTO> getAll() {
        return authorRepostory.findAll()
                .stream()
                .map(authorMapper::fromAuhtorEntityToAuthorDto)
                .collect(Collectors.toSet());
    }

    @Override
    public AuthorDTO update(AuthorDTO entity) throws NotFoundException {
        if (!authorRepostory.existsById(entity.getId())) {
            throw new NotFoundException("L'autore non è presente nel DB");
        }
        AuthorEntities authorUpdate = authorRepostory.save(authorMapper.fromAuthorDtoToAuthorEntity(entity));
        return authorMapper.fromAuhtorEntityToAuthorDto(authorUpdate);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if (!authorRepostory.existsById(id)) {
            throw new NotFoundException("L'autore non è presente nel DB");
        }
        authorRepostory.deleteById(id);
    }

    @Override
    public Set<CustomerDTO> getBySurname(String surname) throws NotFoundException {
        return null;
    }

    @Override
    public Set<CustomerDTO> getByNameAndSurame(String name, String surname) throws NotFoundException {
        return null;
    }
}


