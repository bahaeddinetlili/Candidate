package com.microservices.candidate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/candidats")
public class CandidatRestApi {

    @Autowired
    private CandidatServices candidatServices;

    @PostMapping
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        return new ResponseEntity<>(candidatServices.addCandidat(candidat), HttpStatus.CREATED);
    }


    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidat> updateCandidat(@RequestBody  Candidat candidat, @PathVariable(value = "id") int id) {
        return  new ResponseEntity<>(candidatServices.updateCandidat(candidat,id),HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id) {
        return  new ResponseEntity<>(candidatServices.deleteCandidat(id),HttpStatus.OK);
    }



}
