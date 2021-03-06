package com.hero.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hero.main.model.heroModel;

public interface heroRepository extends JpaRepository<heroModel,Long>{
	
	@Query(value="SELECT * FROM tb_heroes where nombre like :%nombre% ",nativeQuery=true)
     
     heroModel getHeroLikeName(@Param("nombre") String  nombre);



}
