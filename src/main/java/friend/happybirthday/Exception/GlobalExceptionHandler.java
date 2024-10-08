package friend.happybirthday.Exception;


import friend.happybirthday.Code.ErrorCode;
import friend.happybirthday.Code.SuccessCode;
import friend.happybirthday.response.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // 컨트롤러 전역에서 발생하는 예외를 처리
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 입력값 검증
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity
                .status(ErrorCode.BAD_REQUEST.getStatus().value())
                .body(new ErrorResponseDTO(ErrorCode.BAD_REQUEST, errors));
    }

    @ExceptionHandler(NoPostException.class)
    protected ResponseEntity<ErrorResponseDTO> handleNoPostException(final NoPostException e) {
        return ResponseEntity
                .status(ErrorCode.SUCCESS_BUT_MESSAGE_IS_EMPTY.getStatus().value())
                .body(new ErrorResponseDTO(ErrorCode.SUCCESS_BUT_MESSAGE_IS_EMPTY));
    }


    @ExceptionHandler(PostIdNotFoundException.class)
    protected ResponseEntity<ErrorResponseDTO> handlePostIdNotFoundException(final PostIdNotFoundException e) {
        return ResponseEntity
                .status(ErrorCode.POST_NOT_FOUND.getStatus().value())
                .body(new ErrorResponseDTO(ErrorCode.POST_NOT_FOUND));
    }


    @ExceptionHandler(WrongPasswordExcpetion.class)
    protected ResponseEntity<ErrorResponseDTO> handleWrongPasswordException(final WrongPasswordExcpetion e) {
        return ResponseEntity
                .status(ErrorCode.WRONG_PASSWORD.getStatus().value())
                .body(new ErrorResponseDTO(ErrorCode.WRONG_PASSWORD));
    }

    @ExceptionHandler(NoSetPasswordException.class)
    protected ResponseEntity<ErrorResponseDTO> NoSetPasswordException(final NoSetPasswordException e) {
        return ResponseEntity
                .status(ErrorCode.NO_SET_PASSWORD.getStatus().value())
                .body(new ErrorResponseDTO(ErrorCode.NO_SET_PASSWORD));
    }
}
