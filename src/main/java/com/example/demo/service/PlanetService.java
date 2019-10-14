package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PlanetDTO;
import com.example.demo.entities.Planet;
import com.example.demo.repository.PlanetRepository;

@Service
public class PlanetService {

	private PlanetRepository repository;

	public PlanetService(PlanetRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Transactional
	public List<PlanetDTO> findAll() throws Exception{
		
		List <Planet> entities = repository.findAll();
		List <PlanetDTO> dtos = new ArrayList<>();
		
		try {
			for(Planet i: entities) {
				PlanetDTO dtoAux = new PlanetDTO();
				
				dtoAux.setId(i.getId());
				dtoAux.setName(i.getName());
				
				dtos.add(dtoAux);
			}
			
			return dtos;
			
		} catch (Exception e) {
			
			throw new Exception();
		
		}
	}
	
	@Transactional
	public PlanetDTO findById(int id) throws Exception {
		
		Optional <Planet> entityOpt = repository.findById(id);
		PlanetDTO dto = new PlanetDTO();

		try {
			
			Planet entity = entityOpt.get();
						
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Transactional
	public PlanetDTO save(PlanetDTO dto) throws Exception{
		
		try {
			
			Planet entity = new Planet();
			
			entity.setName(dto.getName());
			
			entity = repository.save(entity);
			
			dto.setId(entity.getId());
			
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Transactional
	public boolean delete(int id) throws Exception{
		
		try {
			if(repository.existsById(id)) {
				repository.deleteById(id);
				return true;
			} else {
				throw new Exception();	
			}
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Transactional
	public PlanetDTO update(int id, PlanetDTO dto) throws Exception{
				
		try {
	
			if(repository.existsById(id)) {
				
				Optional<Planet> entityOpt = repository.findById(id);
				
				Planet entity = entityOpt.get();

			entity.setName(dto.getName());
			
			repository.save(entity);
			
			dto.setId(entity.getId());
	
			return dto;
			
			} else {
				throw new Exception();		
			}
			
		} catch (Exception e) {
			throw new Exception();	
		}
	}
}
