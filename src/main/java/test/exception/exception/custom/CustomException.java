package test.exception.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import test.exception.exception.ErrorMessage;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

	private final ErrorMessage errorMessage;
}
