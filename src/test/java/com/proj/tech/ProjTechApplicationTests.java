package com.proj.tech;

import com.proj.tech.dao.UserProfessorDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
class ProjTechApplicationTests {

    private final UserProfessorDao userProfessorDao;
    private final MockMvc mockMvc;

    public ProjTechApplicationTests(UserProfessorDao userProfessorDao, MockMvc mockMvc) {
        this.userProfessorDao = userProfessorDao;
        this.mockMvc = mockMvc;
    }

    @Test
    @WithMockUser(username = "admin", roles = "admin")
    void shouldLoadAWindowAndReturnNullIfNotFound() throws Exception {
        given(userProfessorDao.findById(999L)).willReturn(Optional.empty());
        mockMvc.perform(get("/api/users/-1").accept(MediaType.APPLICATION_JSON))
                // check the HTTP response
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("admin"));
    }

}
