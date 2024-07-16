package org.spring_web4.spring_web4.web.controller;

import java.util.List;
import java.util.Optional;

import org.spring_web4.spring_web4.db.pojo.Farm;
import org.spring_web4.spring_web4.db.pojo.Farmer;
import org.spring_web4.spring_web4.db.serv.FarmService;
import org.spring_web4.spring_web4.db.serv.FarmerService;
import org.spring_web4.spring_web4.web.dto.FarmerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmers")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @Autowired
    private FarmService farmService;

    @GetMapping("addFarmer")
    public ResponseEntity<Void> addFarmer(){

        Farm farm1 = new Farm("Farm1", "narnia");
        Farm farm2 = new Farm("Farm2", "egitto");
        Farm farm3 = new Farm("Farm3", "singapore");

        farmService.saveFarm(farm1);
        farmService.saveFarm(farm2);
        farmService.saveFarm(farm3);

        Farmer farmer1 = new Farmer("Aldo", "BHO", 18, farm1);
        Farmer farmer2 = new Farmer("Giovanni", "BHO", 33,farm2);
        Farmer farmer3 = new Farmer("Giacomo", "BHO", 72,farm3);

        farmerService.saveFarmer(farmer1);
        farmerService.saveFarmer(farmer2);
        farmerService.saveFarmer(farmer3);
        
        return ResponseEntity.ok().build();

    }

    @GetMapping("farmers")
    public ResponseEntity<List<Farmer>> getAllFarmers(){
        List<Farmer> list = farmerService.getAllFarmers();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/addFarmer")
    public ResponseEntity<Farmer> addFarmer(@RequestBody Farmer farmer) {
        Optional<Farm> optionalFarm = farmService.getFarmById(farmer.getFarm().getId());
        if (optionalFarm.isPresent()) {
            farmer.setFarm(optionalFarm.get());
            Farmer newFarmer = farmer;
            farmerService.saveFarmer(newFarmer);
            return ResponseEntity.status(HttpStatus.CREATED).body(newFarmer);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/deleteFarmer/{id}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable int id){
        Optional<Farmer> optFarmer = farmerService.getFarmerById(id);

        if (optFarmer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Farmer farmer = optFarmer.get();
        farmerService.deleteFarmer(farmer);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable int id, @RequestBody FarmerDto FarmerD){
        Optional<Farmer> optFar = farmerService.getFarmerById(id);
        if(optFar.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Farmer farmer = optFar.get();
        farmer.update(FarmerD);
        farmerService.saveFarmer(farmer);

        return ResponseEntity.ok(farmer);
    }
}
