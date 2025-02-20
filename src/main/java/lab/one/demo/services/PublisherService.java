package lab.one.demo.services;

import lab.one.demo.dtos.PublisherDto;
import lab.one.demo.entities.Publisher;
import lab.one.demo.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public PublisherDto mapToDto(Publisher publisher){
        return new PublisherDto(publisher.getId(), publisher.getName());
    }

    public Publisher mapToEntity(PublisherDto publisherDto){
        return new Publisher(publisherDto.getName());
    }

    public List<PublisherDto> allPublishers(){
        List<Publisher> publishers = publisherRepository.findAll();
        List<PublisherDto> publisherDtos = new ArrayList<>();

        for(Publisher publisher : publishers){
            publisherDtos.add(mapToDto(publisher));
        }
        return publisherDtos;
    }

    public PublisherDto createPublisher(PublisherDto publisherDto){
    Publisher publisher = mapToEntity(publisherDto);
    Publisher savedPublisher =publisherRepository.save(publisher);
    return mapToDto(savedPublisher);
    }
}
