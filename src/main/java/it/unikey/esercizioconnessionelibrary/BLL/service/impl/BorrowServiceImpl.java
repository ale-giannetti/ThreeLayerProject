package it.unikey.esercizioconnessionelibrary.BLL.service.impl;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.BorrowDTO;
import it.unikey.esercizioconnessionelibrary.BLL.exception.DateNotFoundException;
import it.unikey.esercizioconnessionelibrary.BLL.exception.NotFoundException;
import it.unikey.esercizioconnessionelibrary.BLL.mapper.BorrowMapper;
import it.unikey.esercizioconnessionelibrary.BLL.service.CrudService;
import it.unikey.esercizioconnessionelibrary.BLL.service.DateService;
import it.unikey.esercizioconnessionelibrary.DAL.entities.BorrowEntity;
import it.unikey.esercizioconnessionelibrary.DAL.repository.BarrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements DateService<BorrowDTO> {

    private final BarrowRepository barrowRepository;
    private final BorrowMapper borrowMapper;

    @Override
    public BorrowDTO insert(BorrowDTO entity) {
        return borrowMapper
                .fromBorrowEntityToBorrowDto((barrowRepository
                        .save(borrowMapper
                                .fromBorrowDtoToBorrowEntity(entity))));
    }

    @Override
    public BorrowDTO getById(Integer id) throws NotFoundException {
        if (!barrowRepository.existsById(id)) {
            throw new NotFoundException("Il prestito non è presente nel DB");
        }
        return borrowMapper.fromBorrowEntityToBorrowDto(barrowRepository.getById(id));
    }

    @Override
    public Set<BorrowDTO> getAll() {
        return barrowRepository.findAll()
                .stream()
                .map(borrowMapper::fromBorrowEntityToBorrowDto)
                .collect(Collectors.toSet());
    }

    @Override
    public BorrowDTO update(BorrowDTO entity) throws NotFoundException {
        if (!barrowRepository.existsById(entity.getId())) {
            throw new NotFoundException("Il prestito non è presente nel DB");
        }
        BorrowEntity borrowUpdated = barrowRepository.save(borrowMapper.fromBorrowDtoToBorrowEntity(entity));
        return borrowMapper.fromBorrowEntityToBorrowDto(borrowUpdated);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if (!barrowRepository.existsById(id)) {
            throw new NotFoundException("Il prestito non è presente nel DB");
        }
        barrowRepository.deleteById(id);
    }

    @Override
    public Set<BorrowDTO> getAllBorrowsByDate(LocalDate start_date, LocalDate end_date) throws DateNotFoundException {
    if(end_date.isBefore(start_date) || start_date == null || end_date== null){
        throw new DateNotFoundException("Le date inserite non presenti nel DB!");
    }
    return barrowRepository.findBorrowEntityBetweenStartDateAndEndDate(start_date, end_date).stream()
            .map(borrowMapper::fromBorrowEntityToBorrowDto)
            .collect(Collectors.toSet());
    }

    @Override
    public Set<BorrowDTO> getByEndDate(LocalDate end_date) throws DateNotFoundException {
       if(end_date == null){
           throw new DateNotFoundException("La data non è presente nel Db!");
       }
       return barrowRepository.findBorrowEntityByEndDate(end_date).stream()
               .map(borrowMapper::fromBorrowEntityToBorrowDto)
               .collect(Collectors.toSet());
    }

    @Override
    public Set<BorrowDTO> getByEndDateNull() {
        return barrowRepository.findBorrowEntityByEndDateIsNull().stream()
                .map(borrowMapper::fromBorrowEntityToBorrowDto)
                .collect(Collectors.toSet());
    }


}




