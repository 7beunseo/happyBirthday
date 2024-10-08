package friend.happybirthday.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.processing.Pattern;

import java.time.LocalDateTime;

@Table(name = "post")
@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name= "writer")
    private String writer;

    // 등록일자
    @Column(name="created_at")
    private LocalDateTime createdAt; //작성일 - 시간은 안 보여주더라

    @Lob
    @Column(name = "content", columnDefinition = "MEDIUMTEXT")
    private String content;
}
