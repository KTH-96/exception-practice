package test.exception.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

	//404 NOT_FOUND
	MEMBER_NOT_FOUND(NOT_FOUND, "해당 유저를 찾을 수 없습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
