package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> findDistilleriesFilterByRegion(@RequestParam(name = "region", required = false) String region){
        if (region == null) {
            return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(distilleryRepository.findDistilleriesByRegion(region), HttpStatus.OK);
    }

//    @GetMapping(value = "/distilleries/age")
//    public ResponseEntity<List<Distillery>> getAllDistilleriesFromASpecificWhiskyAge(@RequestParam(name = "age") int age){
//        return new ResponseEntity<>(distilleryRepository.findDistilleriesByWhiskyAge(age), HttpStatus.OK);
//    }

}
