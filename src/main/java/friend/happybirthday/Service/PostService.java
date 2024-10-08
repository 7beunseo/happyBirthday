package friend.happybirthday.Service;

import friend.happybirthday.Entity.DeletePostDto;
import friend.happybirthday.Entity.Post;
import friend.happybirthday.Entity.RequestPostDto;
import friend.happybirthday.Entity.ResponsePostDto;
import friend.happybirthday.Exception.NoPostException;
import friend.happybirthday.Exception.NoSetPasswordException;
import friend.happybirthday.Exception.PostIdNotFoundException;
import friend.happybirthday.Exception.WrongPasswordExcpetion;
import friend.happybirthday.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    //만들기
    public void createPost(RequestPostDto requestPostDto) {
        Post savePost = RequestPostDto.DtoToEntity(requestPostDto);
        postRepository.save(savePost);
    }


    //조회
    public List<ResponsePostDto> readAllPost() {
        List<Post> posts = postRepository.findAll().stream().toList();

        if (posts.isEmpty()) {
            throw new NoPostException("글이 비었습니다.");
        }

        return posts.stream().map(ResponsePostDto::entityToDto).collect(Collectors.toList());
    }

    public void deletePost(DeletePostDto deletePostDto) {
        Post post = postRepository.findById(deletePostDto.getId())
                .orElseThrow(() -> new PostIdNotFoundException("id에 해당하는 글이 존재하지 않습니다."));

        System.out.println(post.getPassword());
        if (post.getPassword() == null || post.getPassword().equals("null")) {
            throw new NoSetPasswordException("비밀번호를 설정하지 않아, 글을 삭제할 수 없습니다.");
        }
        else if (!Objects.equals(post.getPassword(), deletePostDto.getPassword())) {
            throw new WrongPasswordExcpetion("잘못된 비밀번호입니다.");
        }
        else {
            postRepository.delete(post);
        }
    }
}
