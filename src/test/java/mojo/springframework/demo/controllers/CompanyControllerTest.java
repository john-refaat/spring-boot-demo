package mojo.springframework.demo.controllers;

import mojo.springframework.demo.commands.CompanyCommand;
import mojo.springframework.demo.commands.IndexCommand;
import mojo.springframework.demo.converters.StringToIndexCommandConverter;
import mojo.springframework.demo.domain.Index;
import mojo.springframework.demo.services.CompanyService;
import mojo.springframework.demo.services.IndexService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author john
 * @since 15/02/2024
 */
@ExtendWith(MockitoExtension.class)
class CompanyControllerTest {

    FormattingConversionService formattingConversionService;

    @Mock
    private CompanyService companyService;

    @Mock
    private IndexService indexService;


    @InjectMocks
    private CompanyController companyController;

    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        formattingConversionService = new FormattingConversionService();
        formattingConversionService.addConverter(new StringToIndexCommandConverter());
        mvc = MockMvcBuilders.standaloneSetup(companyController).setConversionService(formattingConversionService).build();
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
    void saveOrUpdateCompany() throws Exception {
        //Given
        System.out.println(Arrays.toString(new IndexCommand[]{new IndexCommand(2L, "index2")}));
        //When
        mvc.perform(MockMvcRequestBuilders.post("/company")
                        .param("name", "company1")
                        .param("indices", Arrays.toString(new IndexCommand[]{new IndexCommand(2L, "index2")})))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/companies"));

        //Then
        Mockito.verify(companyService, Mockito.times(1)).saveOrUpdate(ArgumentMatchers.any(CompanyCommand.class));
    }

    @Test
    void listCompanies() {
    }
}