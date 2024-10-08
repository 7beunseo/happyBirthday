package friend.happybirthday.Entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestPostDto {
    @NotEmpty(message = "본문은 필수 입력 값입니다.")
    private String content;
    private String writer;
    private String password;

    public static Post DtoToEntity(RequestPostDto postDto) {
        return Post.builder()
                .content(postDto.getContent())
                .writer(postDto.getWriter())
                .password(postDto.getPassword())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
