package it.unikey.esercizioconnessionelibrary.PL.controller;

import it.unikey.esercizioconnessionelibrary.BLL.DTO.BorrowDTO;
import it.unikey.esercizioconnessionelibrary.BLL.DTO.CustomerDTO;
import it.unikey.esercizioconnessionelibrary.BLL.exception.DateNotFoundException;
import it.unikey.esercizioconnessionelibrary.BLL.exception.NotFoundException;
import it.unikey.esercizioconnessionelibrary.BLL.service.impl.BorrowServiceImpl;
import it.unikey.esercizioconnessionelibrary.PL.mapper.BorrowRestMapper;
import it.unikey.esercizioconnessionelibrary.PL.rest.BorrowRest;
import it.unikey.esercizioconnessionelibrary.PL.rest.CustomerRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/borrow")
public class BorrowController {

    private final BorrowServiceImpl service;
    private final BorrowRestMapper borrowRestMapper;

    @GetMapping
    private ResponseEntity<Set<BorrowRest>> getAllBorrow(){
        Set<BorrowDTO> borrowDTOS = service.getAll();
        return new ResponseEntity<>(borrowDTOS.stream()
                .map(borrowRestMapper::formBorrowDtoToBorrowRest)
                .collect(Collectors.toSet()), HttpStatus.OK);
    }

    @GetMapping(path = "/id")
    private ResponseEntity<BorrowRest> getRestById(@PathVariable("id") Integer id) {
        try {
            BorrowDTO dto = service.getById(id);
            return new ResponseEntity<>(borrowRestMapper.formBorrowDtoToBorrowRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/dates")
    private ResponseEntity<Set<BorrowRest>> getBorrowTwoDate(
            @RequestParam ("start_date")LocalDate start_date,
            @RequestParam ("end_date")LocalDate end_date){
        try {
           Set<BorrowDTO> dto = service.getAllBorrowsByDate(start_date, end_date);
            return new ResponseEntity<>(dto.stream()
                    .map(borrowRestMapper::formBorrowDtoToBorrowRest)
                    .collect(Collectors.toSet()), HttpStatus.OK);
        } catch (DateNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/endDate")
    private ResponseEntity<Set<BorrowRest>> getAllBorrowEndDate(@PathVariable("endDate") LocalDate endDate){
        try {
            Set<BorrowDTO> dto = service.getByEndDate(endDate);
            return new ResponseEntity<>(dto.stream().map(borrowRestMapper::formBorrowDtoToBorrowRest)
                    .collect(Collectors.toSet()), HttpStatus.OK);
        } catch (DateNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/dateNull")
    private ResponseEntity<Set<BorrowRest>> getAllBorrowDateIsNull(){
        Set<BorrowDTO> dto = service.getByEndDateNull();
        return new ResponseEntity<>(dto.stream()
                .map(borrowRestMapper::formBorrowDtoToBorrowRest)
                .collect(Collectors.toSet()), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<BorrowRest> postBorrow(@RequestBody BorrowRest borrow) {
        if (borrow.getId() != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        BorrowDTO dtoInsert = service.insert(borrowRestMapper.fromBorrowRestToBorrowDto(borrow));
        return new ResponseEntity<>(borrowRestMapper.formBorrowDtoToBorrowRest(dtoInsert), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<BorrowRest> putEmployee(@RequestBody BorrowRest borrow){
        try {
            BorrowDTO dtoUpdated = service.update(borrowRestMapper.fromBorrowRestToBorrowDto(borrow));
            return new ResponseEntity<>(borrowRestMapper.formBorrowDtoToBorrowRest(dtoUpdated), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
