package com.lakshman.sample.zoomcar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.CONFLICT,reason = "Vehicle already occupied on given dates")
public class BookingFailedException extends RuntimeException {
}
