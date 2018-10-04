package com.gfi.academy.restfulservices;

import com.gfi.academy.restfulservices.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles({"testing"})
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void before() {
        employeeRepository.deleteAll();
    }

    @Test
    public void fetch_all_employees() throws Exception {
        this.mockMvc
                .perform(get("/api/employees"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void fetch_non_existing_employee_should_return_exception() throws Exception {
        this.mockMvc
                .perform(get("/api/employees/2"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void fetch_existing_employee_should_return_employee() throws Exception {
        this.mockMvc
                .perform(get("/api/employees/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
