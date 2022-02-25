package it.unikey.esercizioconnessionelibrary.BLL.exception;

import java.time.LocalDate;

public class DateNotFoundException extends Exception{

    public DateNotFoundException(String message) {
        super();
    }

    public DateNotFoundException(LocalDate start_date, LocalDate end_date, String message){
        super();
    }
}
