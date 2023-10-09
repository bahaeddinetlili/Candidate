package com.microservices.candidate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatServices {
    @Autowired
    private CandidatRepository candidatRepository;



    public Candidat addCandidat(Candidat candidat) {

    return     candidatRepository.save(candidat);
    }


    public Candidat updateCandidat(Candidat newcandidat ,Integer id) {

           if(candidatRepository.findById(id).isPresent()) {

          Candidat existingCandidat = candidatRepository.findById(id).get();

          existingCandidat.setNom(newcandidat.getNom());
          existingCandidat.setPrenom((newcandidat.getPrenom()));
          existingCandidat.setEmail(newcandidat.getEmail());

          return candidatRepository.save(existingCandidat);

          }

           else

               return  null;

    }

     public String deleteCandidat(Integer id) {
     if (candidatRepository.findById(id).isPresent()){
         candidatRepository.deleteById(id);
         return "Candidat deleted Successfully";
     }
     else

         return "Candidat non deleted";


     }



}
