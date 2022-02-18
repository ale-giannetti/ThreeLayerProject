package it.unikey.esercizioconnesionilibrary.BLL.service.impl;

import it.unikey.esercizioconnesionilibrary.BLL.DTO.BorrowDTO;
import it.unikey.esercizioconnesionilibrary.BLL.exception.NotFoundException;
import it.unikey.esercizioconnesionilibrary.BLL.mapper.BorrowMapper;
import it.unikey.esercizioconnesionilibrary.BLL.service.BorrowService;
import it.unikey.esercizioconnesionilibrary.BLL.service.CrudService;
import it.unikey.esercizioconnesionilibrary.DAL.entity.BorrowEntity;
import it.unikey.esercizioconnesionilibrary.DAL.entity.BorrowPK;
import it.unikey.esercizioconnesionilibrary.DAL.entity.CustomerEntity;
import it.unikey.esercizioconnesionilibrary.DAL.repository.BorrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService<BorrowDTO> {

    private final BorrowRepository borrowRepository;
    private final BorrowMapper borrowMapper;

    @Override
    public BorrowDTO insert(BorrowDTO entity) {
        return borrowMapper
                .fromBorrowEntityToBorrowDTO(borrowRepository
                        .save(borrowMapper.fromBorrowDTOToBorrowEntity(entity)));
    }

    @Override
    public BorrowDTO getById(BorrowPK borrowPK) throws NotFoundException {
        if(!borrowRepository.existsById(borrowPK)){
            throw new NotFoundException("The borrow you're trying to get not found in DB");
        }
        return borrowMapper.fromBorrowEntityToBorrowDTO(borrowRepository.getById(borrowPK));
    }

    @Override
    public Set<BorrowDTO> getAll() {
        return borrowRepository.findAll().stream()
                .map(borrowMapper::fromBorrowEntityToBorrowDTO).collect(Collectors.toSet());
    }

    @Override
    public BorrowDTO update(BorrowDTO entity) throws NotFoundException {
        if(!borrowRepository.existsById(entity.getBorrowPK())){
            throw new NotFoundException("The borrow you're trying to update not found in DB");
        }
        BorrowEntity borrowUpdated = borrowRepository.save(borrowMapper.fromBorrowDTOToBorrowEntity(entity));
        return borrowMapper.fromBorrowEntityToBorrowDTO(borrowUpdated);
    }

    @Override
    public void delete(BorrowPK borrowPK) throws NotFoundException {
        if(!borrowRepository.existsById(borrowPK)){
            throw new NotFoundException("The borrow you're trying to delete not found in DB");
        }
        borrowRepository.deleteById(borrowPK);
    }

}
