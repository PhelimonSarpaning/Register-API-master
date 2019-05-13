package edu.uark.controllers.advice;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.uark.controllers.exceptions.ConflictException;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;

@ControllerAdvice
public class BaseRestControllerAdvice {
	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	VndErrors notFoundExceptionHandler(NotFoundException e) {
		return new VndErrors("error", e.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(ConflictException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	VndErrors conflictExceptionHandler(ConflictException e) {
		return new VndErrors("error", e.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(UnprocessableEntityException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	VndErrors unprocessableEntityExceptionHandler(UnprocessableEntityException e) {
		return new VndErrors("error", e.getMessage());
	}
}
