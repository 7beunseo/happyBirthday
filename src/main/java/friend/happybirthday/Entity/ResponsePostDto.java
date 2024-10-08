package friend.happybirthday.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsePostDto {
    private Long id;
    private String content;
    private String writer;
    private String password;
    private LocalDateTime createdAt;

    public static ResponsePostDto entityToDto(Post post) {
        return ResponsePostDto.builder()
                .id(post.getId())
                .content(post.getContent())
                .writer(post.getWriter())
                .password(post.getPassword())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
