package org.spring_web4.spring_web4.db.pojo;

import java.util.List;

import org.spring_web4.spring_web4.web.dto.FarmDto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "farm")
    @JsonIgnore
    private List<Farmer> farmers;

    public Farm(String name, String city, List<Farmer> farmers) {
        this.name = name;
        this.city = city;
        this.farmers = farmers;
    }

    public Farm() {
    }

    public Farm(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }

    public void update(FarmDto fDto){
        setName(fDto.getName());
        setCity(fDto.getCity());
    }

    @Override
    public String toString() {
        return "Farm{\n" +
                "\tid=" + id + ",\n" +
                "\tname='" + name + '\'' + ",\n" +
                "\tlocation='" + city + '\'' + "\n" +
                "}";
    }
}
