package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Integer>{

	
}
