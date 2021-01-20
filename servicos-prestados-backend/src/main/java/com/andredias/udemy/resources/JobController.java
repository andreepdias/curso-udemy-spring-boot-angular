package com.andredias.udemy.resources;

import com.andredias.udemy.model.entity.Client;
import com.andredias.udemy.model.entity.Job;
import com.andredias.udemy.model.repository.ClientRepository;
import com.andredias.udemy.model.repository.JobRepository;
import com.andredias.udemy.resources.dto.JobDTO;
import com.andredias.udemy.util.NumberConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/servicos-prestados")
public class JobController {

    private final ClientRepository clientRepository;
    private final JobRepository repository;
    private final NumberConverter numberConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Job save(@RequestBody @Valid JobDTO dto){
        LocalDate date = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Integer clientId = dto.getClientId();

        Client client = clientRepository
                .findById(clientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente."));

        Job job = new Job();
        job.setDescription(dto.getDescription());
        job.setDate(date);
        job.setClient(client);
        job.setPrice(numberConverter.converter(dto.getPrice()));

        return repository.save(job);
    }

    @GetMapping
    public List<Job> search(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ){
        return repository.findByNomeClienteAndMes("%"+nome+"%", mes);
    }
}
