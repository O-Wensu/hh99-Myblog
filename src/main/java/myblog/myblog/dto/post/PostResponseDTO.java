package myblog.myblog.dto.post;

import lombok.*;
import myblog.myblog.domain.Post;
import myblog.myblog.dto.comment.CommentResponseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@NoArgsConstructor
public class PostResponseDTO {

    private Long id;
    private String title;
    private String username;
    private String content;
    private int likeCount;
    private List<CommentResponseDto> commentList;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostResponseDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.username = post.getMember().getUsername();
        this.likeCount = post.getLikeCount();
        this.commentList = post.getCommentList().stream().map(CommentResponseDto::new).collect(Collectors.toList());
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}
