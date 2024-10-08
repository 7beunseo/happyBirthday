package friend.happybirthday.Code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    /**
     * 400 BAD_REQUEST: 잘못된 요청
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 잘못됐습니다."),
    SUCCESS_BUT_MESSAGE_IS_EMPTY(HttpStatus.OK, "글이 비어있습니다."),
    NO_SET_PASSWORD(HttpStatus.NOT_ACCEPTABLE, "비밀번호를 설정하지 않아, 글을 지울 수 없습니다."),


    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 글이 존재하지 않습니다."),

    /**
     * 406
     * **/
    NOT_NULL_CONTENT(HttpStatus.NOT_ACCEPTABLE, "내용 없이 저장할 수 없습니다."),
    UNAVAILABLE_VALUE(HttpStatus.NOT_ACCEPTABLE, "비밀번호는 4자리만 입력 가능합니다.");

    private final HttpStatus status;
    private final String message;
}