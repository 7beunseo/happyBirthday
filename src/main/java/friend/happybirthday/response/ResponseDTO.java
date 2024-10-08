package friend.happybirthday.response;

import friend.happybirthday.Code.SuccessCode;
import lombok.Data;

@Data
public class ResponseDTO<T> {
    private Integer status;
    private String code;
    private String message;
    private T data;


    public ResponseDTO(SuccessCode responseCode) {
        this.status = responseCode.getStatus().value();
        this.code = responseCode.name();
        this.message = responseCode.getMessage();
        this.data = (T) "성공";
    }

    public ResponseDTO(SuccessCode responseCode, T data) {
        this.status = responseCode.getStatus().value();
        this.code = responseCode.name();
        this.message = responseCode.getMessage();
        this.data = data;
    }
}
