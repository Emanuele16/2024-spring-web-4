package org.spring_web4.spring_web4.web.controller;

import java.util.List;
import java.util.Optional;

import org.spring_web4.spring_web4.db.pojo.Farm;
import org.spring_web4.spring_web4.db.serv.FarmService;
import org.spring_web4.spring_web4.web.dto.FarmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farms")
public class FarmController {

    @Autowired
    private FarmService farmService;

    @GetMapping("addFarms")
    public ResponseEntity<Void> addFarm(){
        Farm farm1 = new Farm("f10", "domodossola");
        Farm farm2 = new Farm("f11", "brontosauro");

        farmService.saveFarm(farm1);
        farmService.saveFarm(farm2);

        return ResponseEntity.ok().build();
    }

    @GetMapping("farms")
    public ResponseEntity<List<Farm>> getAllFarm(){
        List<Farm> list = farmService.getAllFarm();

        return ResponseEntity.ok(list);
    }

    @PostMapping("newFarm")
    public ResponseEntity<Farm> create(@RequestBody FarmDto farmDto) {
        Farm farm = new Farm(farmDto.getName(), farmDto.getCity());
        farmService.saveFarm(farm);

        return ResponseEntity.ok(farm);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Farm> updateFarm(@PathVariable int id, @RequestBody FarmDto farmDto) {
        Optional<Farm> optionalFarm = farmService.getFarmById(id);
        if (optionalFarm.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Farm farm = optionalFarm.get();
        farm.update(farmDto);
        farmService.saveFarm(farm);

        return ResponseEntity.ok(farm);
    }
}