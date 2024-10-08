package friend.happybirthday.Entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeletePostDto {
    private Long id;
    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    private String password;
}
