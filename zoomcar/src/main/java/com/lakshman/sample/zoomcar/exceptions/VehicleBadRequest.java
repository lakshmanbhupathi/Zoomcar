package com.lakshman.sample.zoomcar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,reason = "Vehicle type is invalid")
public class VehicleBadRequest extends RuntimeException {
}
