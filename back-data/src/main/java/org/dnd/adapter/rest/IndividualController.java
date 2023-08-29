package org.dnd.adapter.rest;


import lombok.RequiredArgsConstructor;
import org.dnd.adapter.rest.mapper.IndividualMapper;
import org.dnd.adapter.rest.model.IndividualDto;
import org.dnd.app.exeption.IndividualNotFoundException;
import org.dnd.app.service.GetIndividualInbound;
import org.dnd.app.service.PostIndividualInbound;
import org.dnd.domain.individual.Individual;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("back/data/v1/individual")
public class IndividualController {

    private final GetIndividualInbound getIndividualInbound;
    private final PostIndividualInbound postIndividualInbound;
    private final IndividualMapper individualMapper;

    @GetMapping
    public ResponseEntity<IndividualDto> getIndividual(@RequestParam String icp) {
        return new ResponseEntity<>(
                individualMapper.toDto(getIndividualInbound.handleRequest(icp)), HttpStatus.OK);
    }

    @GetMapping("/v1")
    public ResponseEntity<Individual> getIndividualv1(@RequestParam String icp) {
        return new ResponseEntity<>(getIndividualInbound.handleRequest(icp), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IndividualDto> postIndividual(@RequestBody IndividualDto dto) {
        var individual = individualMapper.toEntity(dto);
        return new ResponseEntity<>(
                individualMapper.toDto(postIndividualInbound.handleRequest(individual)), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IndividualNotFoundException.class)
    public Error getIndividualHandler(IndividualNotFoundException e) {
        return new Error(e.getMessage());
    }
}
