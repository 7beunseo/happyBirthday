package friend.happybirthday.Code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum SuccessCode {
    /**
     * notice
     */
    SUCCESS_MESSAGE_REGISTER(HttpStatus.CREATED, "글을 작성했습니다."),
    SUCCESS_MESSAGE_DELETE(HttpStatus.OK, "글이 성공적으로 삭제되었습니다."),
    SUCCESS_READ_ALL_MESSAGE(HttpStatus.OK, "글을 성공적으로 불러왔습니다.")

    ;

    private final HttpStatus status;
    private final String message;
}