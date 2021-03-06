package com.hero.main.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hero.main.model.heroModel;

@Component
@Service
public interface heroService {

	   public heroModel updateHeroe(heroModel heroe);
	   public List<heroModel> getAllheroe();
	   public heroModel getHeroById(Long id);
	   public List<heroModel> getHeroByName(String heroe);
	   public String deleteHeroById(Long id);
}
