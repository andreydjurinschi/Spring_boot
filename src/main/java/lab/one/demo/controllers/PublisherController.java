package lab.one.demo.controllers;

import lab.one.demo.dtos.PublisherDto;
import lab.one.demo.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    @Autowired
    private PublisherService service;

    @GetMapping
    public List<PublisherDto> getAll(){

        List<PublisherDto> publishers = service.allPublishers();
        return publishers;
    }


}
