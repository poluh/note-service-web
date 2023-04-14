package service;

import com.example.demo.repository.*;
import com.example.demo.service.converter.*;
import lombok.*;
import org.mapstruct.factory.*;
import org.mockito.*;
import org.springframework.boot.test.context.*;
import org.springframework.context.annotation.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@TestConfiguration
public class TestConfig {

//    @Bean
//    UserService userService(UserRepository repository, UserMapper mapper) {
//        return new UserService(repository, mapper);
//    }

    @Bean
    UserMapper userMapper(UserRepository userRepository,
                          NoteRepository noteRepository) {
        val mapper = Mappers.getMapper(UserMapper.class);
        mapper.setNoteRepository(noteRepository);
        mapper.setUserRepository(userRepository);
        return mapper;
    }

    @Bean
    UserRepository userRepository() {
        val repo = Mockito.mock(UserRepository.class);
        when(repo.save(any()))
                .thenReturn(null);
        return repo;
    }

    @Bean
    NoteRepository noteRepository() {
        val repo = Mockito.mock(NoteRepository.class);
        return repo;
    }
}
