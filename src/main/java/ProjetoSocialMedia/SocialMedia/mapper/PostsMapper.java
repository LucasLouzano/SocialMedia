package ProjetoSocialMedia.SocialMedia.mapper;

import ProjetoSocialMedia.SocialMedia.dto.PostDTORequestSave;
import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostsMapper {
    PostsMapper CONVERTER = Mappers.getMapper(PostsMapper.class);

    PostsDTO postsToPostsDTO(Posts posts);

//    PostDTORequestSave postsDtoToPosts(PostsDTO postsDTO);
}
