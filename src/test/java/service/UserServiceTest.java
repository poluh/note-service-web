package service;

import com.example.demo.domain.entity.*;
import com.example.demo.domain.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.converter.*;
import com.example.demo.service.impl.*;
import lombok.extern.slf4j.*;
import lombok.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mapstruct.factory.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import org.springframework.test.context.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith({MockitoExtension.class})
@ContextConfiguration(classes = TestConfig.class)
public class UserServiceTest {

    @Mock
    UserRepository repository;
    @Mock
    NoteRepository noteRepository;

    UserMapper converter = Mappers.getMapper(UserMapper.class);

    UserService userService;

    @BeforeEach
    public void setUp() {
        converter.setUserRepository(repository);
        converter.setNoteRepository(noteRepository);
        userService = new UserService(repository, converter);
    }

    @Test
    public void userExistsTest() {

        assertFalse(userService.exists(1));

        when(repository.existsById(1))
                .thenReturn(true);

        assertTrue(userService.exists(1));

    }

    @Test
    public void newUserTest() {

        val user = UserRequest.builder()
                .name("SSS")
                .build();
        val entity = new User();
        entity.setName(user.getName());

        when(repository.save(any()))
                .thenReturn(entity);

        val resulted = userService.newUser(user);

        log.info("Original {}, resulted {}", user.getName(), resulted.getUsername());
        assertEquals(user.getName(), resulted.getUsername());
    }

    @Test
    public void noteCountTest() {

        val entity = new User();
        entity.setName("SSS");
        when(repository.save(any()))
                .thenReturn(entity);
        when(repository.count())
                .thenReturn(1L);

        val user = userService.newUser(UserRequest.builder()
                .name("SSS")
                .build());

        assertEquals(0, user.getCountOfNotes());
        assertEquals(1, user.getTotalUsers());

        when(repository.count())
                .thenReturn(2L);
        val second = userService.newUser(UserRequest.builder()
                .name("SSS")
                .build());

        assertEquals(2, second.getTotalUsers());

    }

}
