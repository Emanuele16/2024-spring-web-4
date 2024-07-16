package org.spring_web4.spring_web4.db.serv;

import java.util.List;
import java.util.Optional;

import org.spring_web4.spring_web4.db.pojo.Farm;
import org.spring_web4.spring_web4.db.repo.FarmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {
    
    @Autowired
    private FarmRepo farmRepo;
    
    public List<Farm> getAllFarm(){
        return farmRepo.findAll();
    }

    public Optional<Farm> getFarmById(int id){
        return farmRepo.findById(id);
    }

    public void saveFarm(Farm farm){
        farmRepo.save(farm);
    }

    public void deleteFarm(Farm farm){
        farmRepo.delete(farm);
    }
}