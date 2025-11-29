package _bits.LegalizaMais.controller;

import _bits.LegalizaMais.domain.client.dto.ClientRequestDTO;
import _bits.LegalizaMais.domain.client.dto.ClientResponseDTO;
import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.workService.dto.WorkServiceRequestDTO;
import _bits.LegalizaMais.domain.workService.dto.WorkServiceResponseDTO;
import _bits.LegalizaMais.domain.workService.entity.WorkService;
import _bits.LegalizaMais.exception.ExampleException;
import _bits.LegalizaMais.service.WorkServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("service")
public class WorkServiceController {

    @Autowired
    private WorkServiceService service;

    @GetMapping
    public ResponseEntity<List<WorkServiceResponseDTO>> listAllServices(){
        return ResponseEntity.ok().body(service.listAllServices());
    }

    @PostMapping
    public ResponseEntity<WorkServiceResponseDTO> save(@Valid @RequestBody WorkServiceRequestDTO data){
        Optional<WorkService> inserted = service.save(WorkServiceRequestDTO.newService(data));
        if (inserted.isEmpty()) throw new ExampleException("Couldn't insert the service");

        WorkServiceResponseDTO response = WorkServiceResponseDTO.fromService(inserted.get());
        URI location = URI.create("/service/" + response.getId());
        return ResponseEntity
                .created(location)
                .body(response);
    }
}
