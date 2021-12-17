package ru.madbrains.anton.madcourse.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.madbrains.anton.madcourse.company.ITCompany;
import ru.madbrains.anton.madcourse.company.employer.Developer;
import ru.madbrains.anton.madcourse.company.employer.Employer;
import ru.madbrains.anton.madcourse.company.employer.ITRole;
import ru.madbrains.anton.madcourse.company.employer.PM;
import ru.madbrains.anton.madcourse.dto.CompanyDTO;
import ru.madbrains.anton.madcourse.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public CompanyDTO company() {
        return CompanyDTO.from(companyService.getCompany());//отдаем companyDTO
    }

    @PostMapping("/employers/developers")
    public ResponseEntity addEmployer(@RequestBody Developer developer) {
        log.info("add developer");
        companyService.addDeveloper(developer);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/employers/PMs")
    public ResponseEntity addEmployer(@RequestBody PM pm) {
        log.info("add PM");
        companyService.addPM(pm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employers/{index}")
    public ResponseEntity<Employer<ITRole>> getEmployerByIndex(@PathVariable int index) {
        log.info("get employer by index = " + index);
        try {

            return ResponseEntity.ok(companyService.getEmployerByIndex(index));
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/employers/find")
    public ResponseEntity<List<Employer<ITRole>>> getEmployerByRole(@RequestParam(name = "role") ITRole role) {
        log.info("get employer by log ");
        return ResponseEntity.ok(companyService.getEmployersByRole(role));
    }


}
