package friend.happybirthday.Controller;

import friend.happybirthday.Code.SuccessCode;
import friend.happybirthday.Entity.DeletePostDto;
import friend.happybirthday.Entity.RequestPostDto;
import friend.happybirthday.Entity.ResponsePostDto;
import friend.happybirthday.Service.PostService;
import friend.happybirthday.response.ResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class PostController {
    private final PostService postService;

    @PostMapping("/happy-birthday")
    public ResponseEntity<ResponseDTO<?>> createPost(@Valid @RequestBody RequestPostDto requestPostDto) {
        postService.createPost(requestPostDto);
        return ResponseEntity
                .status(SuccessCode.SUCCESS_MESSAGE_REGISTER.getStatus().value())
                .body(new ResponseDTO<>(SuccessCode.SUCCESS_MESSAGE_REGISTER));
    }


    @GetMapping("/happy-birthday")
    public ResponseEntity<ResponseDTO<?>> readAllPost() {
        List< ResponsePostDto> postDtos = postService.readAllPost();
        return ResponseEntity
                .status(SuccessCode.SUCCESS_READ_ALL_MESSAGE.getStatus().value())
                .body(new ResponseDTO<>(SuccessCode.SUCCESS_READ_ALL_MESSAGE, postDtos));
    }

    @DeleteMapping("/")
    public ResponseEntity<ResponseDTO<?>> deletePost(@Valid @RequestBody DeletePostDto deletePostDto) {
        postService.deletePost(deletePostDto);
        return ResponseEntity
                .status(SuccessCode.SUCCESS_MESSAGE_DELETE.getStatus().value())
                .body(new ResponseDTO<>(SuccessCode.SUCCESS_MESSAGE_DELETE));

    }
}
