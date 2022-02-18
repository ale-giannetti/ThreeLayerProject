package it.unikey.esercizioconnessionelibrary.BLL.service.impl;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.BorrowDTO;
import it.unikey.esercizioconnessionelibrary.BLL.exception.NotFoundException;
import it.unikey.esercizioconnessionelibrary.BLL.mapper.BorrowMapper;
import it.unikey.esercizioconnessionelibrary.BLL.service.BorrowService;
import it.unikey.esercizioconnessionelibrary.DAL.entities.BarrowPk;
import it.unikey.esercizioconnessionelibrary.DAL.entities.BorrowEntity;
import it.unikey.esercizioconnessionelibrary.DAL.repository.BarrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService<BorrowDTO> {

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
    public BorrowDTO getById(BarrowPk id) throws NotFoundException {
        if (!barrowRepository.existsById((id))) {
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
        if (!barrowRepository.existsById(entity.getBarrowPk())) {
            throw new NotFoundException("Il prestito non è presente nel DB");
        }
        BorrowEntity borrowUpdated = barrowRepository.save(borrowMapper.fromBorrowDtoToBorrowEntity(entity));
        return borrowMapper.fromBorrowEntityToBorrowDto(borrowUpdated);
    }

    @Override
    public void delete(BarrowPk id) throws NotFoundException {
        if (!barrowRepository.existsById(id)) {
            throw new NotFoundException("Il prestito non è presente nel DB");
        }
        barrowRepository.deleteById(id);
    }
}




