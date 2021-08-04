package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskys/year")
    public ResponseEntity<List<Whisky>> findAllDistilleriesThatHaveBeenQueryInt(@RequestParam(name="year") int year){
        return new ResponseEntity<>(whiskyRepository.findWhiskysByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskys/{id}/age")
    public ResponseEntity<List<Whisky>> getAllWhiskysFromAParticularDistilleryOfASpecificAge(@PathVariable Long id, @RequestParam(name="age") int age){
        Distillery distillery = whiskyRepository.findById(id).get().getDistillery();
        return new ResponseEntity<>(whiskyRepository.findWhiskysByDistilleryAndAge(distillery, age), HttpStatus.OK);
    }

    //http://localhost:8080/whiskys/2/age?age=12

    @GetMapping(value = "/whiskys/region")
    public ResponseEntity<List<Whisky>> getAllWhiskysFromASpecificRegion(@RequestParam(name="region") String region){
        return new ResponseEntity<>(whiskyRepository.findWhiskysByDistilleryRegion(region), HttpStatus.OK);
    }

}
