//package ProjetoSocialMedia.SocialMedia.service.impl;
//
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class PostsServiceImplTest {

    /*@Mock
    private PostsRepository repository;

    @Mock
    private PostsMapper mapper;

    @InjectMocks
    private PostsServiceImpl service;

    @Test
    void findById() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setTexto("Texto");
        posts.setAuthor("author");
        posts.setCreateDateTime(LocalDateTime.now());

        when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(posts));

        Posts response = service.findById(1L);

        assertNotNull(response);
        assertEquals(Posts.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals("Texto", response.getTexto());
        assertEquals("author", response.getAuthor());

    }

    @Test
    void getTodosPostsDto() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());
        List<Posts> posts1 = List.of(posts);
        when(repository.findAll()).thenReturn(posts1);


        PostsDTO postsDTO = new PostsDTO();
        postsDTO.setTexto("Texto");
        postsDTO.setCreateDateTime(LocalDateTime.now());
        when(mapper.postsToPostsDTO(any())).thenReturn(postsDTO);

        // Chamando o método do serviço que queremos testar
        List<PostsDTO> postsDTOList = service.findAll();
        // Verificações
        assertNotNull(postsDTOList);
        assertEquals(1, postsDTOList.size());
        assertEquals("Texto", postsDTOList.get(0).getTexto());
        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).postsToPostsDTO(any());
    }

    @Test
    void salvarComSucesso() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("Lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());
        when(repository.save(any())).thenReturn(posts);

        // Configuração do mock do mapper para retornar o objeto PostsDTO
        var postsDTO = new PostsDTO();
        postsDTO.setTexto("Texto");
        when(mapper.postsToPostsDTO(eq(posts))).thenReturn(postsDTO);

        PostsDTO resposta = service.save(posts);

        // Verifica se a resposta não é nula
        assertNotNull(resposta);

        // Verifica se a classe da resposta é PostsDTO
        assertEquals(PostsDTO.class, resposta.getClass());

        // Verifica se os atributos da resposta são iguais aos atributos do objeto PostsDTO esperado
        assertEquals(postsDTO.getTexto(), resposta.getTexto());

        // Verifica se o método save do repository foi chamado com o objeto Posts correto
        verify(repository).save(eq(posts));
    }

    @Test
    void quandoAtualizarRetornaSucesso() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("Lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());

        when(repository.save(any())).thenReturn(posts);

        Posts post = service.update(posts);

        assertNotNull(post);
        assertEquals(Posts.class, post.getClass());
        assertEquals(1L, post.getId());
        assertEquals("Lucas", post.getAuthor());
        assertEquals("Texto", post.getTexto());
        assertNotNull(post.getCreateDateTime());
    }


    @Test
    void deletarComSucesso() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("Lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());
        when(repository.findById(anyLong())).thenReturn(Optional.of(posts));


        // Chamando o método delete no serviço
        Posts deletedPost = service.delete(1L);

        // Verificando se o método delete foi chamado uma vez com o objeto correto
        verify(repository, times(1)).delete(posts);

        // Verificando se o Posts retornado é o mesmo que foi excluído
        assertEquals(posts, deletedPost);
    }*/
//}

//        doNothing().when(repository).delete(posts);