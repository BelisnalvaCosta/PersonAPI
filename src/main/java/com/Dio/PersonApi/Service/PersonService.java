package com.Dio.PersonApi.Service;

import com.Dio.PersonApi.Entity.Person;
import com.Dio.PersonApi.Mapper.PersonMapper;
import com.Dio.PersonApi.Repository.PersonRepository;
import com.Dio.PersonApi.dto.Request.PersonDTO;
import com.Dio.PersonApi.dto.response.MessageResponseDTO;
import com.Dio.PersonApi.exception.PersonNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public MessageResponseDTO create(PersonDTO personDTO) {

        Person Person = PersonMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(Person);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedPerson.getId());

        return messageResponse;
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }

    public List<PersonDTO> ListAll() {
        List<Person> People = personRepository.findAll();
        return People.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        Person updatePerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatePerson);

        MessageResponseDTO messageResponse = createMessageResponse("Person sucessfully update with ID ", savedPerson.getId());

        return messageResponse;
    }

    private void Delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                        .orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }

    public void delete(Long id) {
    }
}