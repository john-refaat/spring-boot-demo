package mojo.springframework.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import mojo.springframework.demo.commands.CompanyCommand;
import mojo.springframework.demo.domain.Company;
import mojo.springframework.demo.services.CompanyService;
import mojo.springframework.demo.services.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author john
 * @since 15/02/2024
 */
@Slf4j
@Controller
public class CompanyController {

    private CompanyService companyService;
    private IndexService indexService;

    public CompanyController(CompanyService companyService, IndexService indexService) {
        this.companyService = companyService;
        this.indexService = indexService;
    }

    @GetMapping("/company/new")
    public String newCompanyForm(Model model) {
        model.addAttribute("company", new CompanyCommand());
        model.addAttribute("allIndices",indexService.findAllIndexes());
        return "company/newForm";
    }

    @PostMapping("/company")
    public String saveOrUpdateCompany(@ModelAttribute("company") CompanyCommand company) {
        log.info("Saving company: "+company);
        return "redirect:/companies";
    }

    @GetMapping("/companies")
    public String listCompanies(Model model) {
        model.addAttribute("companies", companyService.findAllCompanies());
        return "company/list";
    }


}
