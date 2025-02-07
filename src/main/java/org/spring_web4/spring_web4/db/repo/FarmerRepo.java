package org.spring_web4.spring_web4.db.repo;

import org.spring_web4.spring_web4.db.pojo.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Integer> {

}
