package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.comment.Comments;
import ProjetoSocialMedia.SocialMedia.service.impl.CommentsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsServiceImpl service;


    @GetMapping("/{id}")
    public ResponseEntity<Comments> getCommentsById(@PathVariable Long id) {
      Comments comments = service.findById(id);
      if (comments == null){
          return ResponseEntity.notFound().build();
      }
        return ResponseEntity.ok(comments);
    }

    @GetMapping
    public ResponseEntity<List<Comments>> getComments() {
        List<Comments> commentsList = service.findAll();
        if (commentsList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(commentsList);
    }

    @PostMapping
    public ResponseEntity<Comments> save(@RequestBody @Valid Comments comments) {
        Comments comments1 = service.save(comments);
        return ResponseEntity.ok(comments1);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Comments> update(@PathVariable Long id,  @RequestBody @Valid Comments comments) {
        Comments coments = service.update(id,comments);
        if (coments == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(coments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comments> deleteComent(@PathVariable Long id) {
        Comments comments = service.deleteById(id);
        if (comments != null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(comments);
    }

}