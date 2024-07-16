package org.spring_web4.spring_web4.db.serv;

import java.util.List;
import java.util.Optional;

import org.spring_web4.spring_web4.db.pojo.Farmer;
import org.spring_web4.spring_web4.db.repo.FarmerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {
    
    @Autowired
    private FarmerRepo farmerRepo;

    public List<Farmer> getAllFarmers() {
        return farmerRepo.findAll();
    }

    public Optional<Farmer> getFarmerById(int id) {
        return farmerRepo.findById(id);
    }

    public void saveFarmer(Farmer farmer) {
        farmerRepo.save(farmer);
    }

    public void deleteFarmer(Farmer farmer) {
        farmerRepo.delete(farmer);
    }
}
