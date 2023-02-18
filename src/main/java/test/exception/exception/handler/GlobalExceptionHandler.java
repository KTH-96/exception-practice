package test.exception.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import test.exception.exception.ErrorResponse;
import test.exception.exception.custom.CustomException;

/**
 * ResponseEntityExceptionHandler를 상속받은 이유
 * 상속받지 않는다면 예외들은 ModelAndView 객체를 반환하는 DefaultHandlerExceptionResolver로 리다이렉트된다.
 * 그래서 클라이언트가 일관되지 못한 에러 응답을 받을 것이므로 일관된 오류 응답을 반환하기 위해서는 ResponseEntityExceptionHandler를 상속받는 것이 좋다
 * 출처: https://mangkyu.tistory.com/204
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {CustomException.class})
	protected ResponseEntity<ErrorResponse> customException(CustomException e) {
		log.error("CustomException.ErrorMessage = {}", e.getErrorMessage());
		return ErrorResponse.toResponseEntity(e.getErrorMessage());
	}
}
