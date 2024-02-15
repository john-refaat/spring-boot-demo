package mojo.springframework.demo.controllers;

import mojo.springframework.demo.commands.IndexCommand;
import mojo.springframework.demo.domain.Index;
import mojo.springframework.demo.services.CompanyService;
import mojo.springframework.demo.services.IndexService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author john
 * @since 15/02/2024
 */
@ExtendWith(MockitoExtension.class)
class CompanyControllerTest {

    @Mock
    private CompanyService companyService;

    @Mock
    private IndexService indexService;

    @InjectMocks
    private CompanyController companyController;

    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(companyController).build();
    }

    @Test
    void newCompanyForm() throws Exception {

        //Given
        Set<IndexCommand> indices = new HashSet<>();
        indices.add(new IndexCommand());

        //When
        Mockito.when(indexService.findAllIndexes()).thenReturn(indices);

        mvc.perform(MockMvcRequestBuilders.get("/company/new"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("company"))
                .andExpect(MockMvcResultMatchers.view().name("company/newForm"));

        //Then
        Mockito.verify(indexService, Mockito.times(1)).findAllIndexes();

    }

    @Test
    void saveOrUpdateCompany() {

    }

    @Test
    void listCompanies() {
    }
}