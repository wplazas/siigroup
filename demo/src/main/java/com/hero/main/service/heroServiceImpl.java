package com.hero.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hero.main.model.heroModel;
import com.hero.main.repository.heroRepository;

@Component
@Service
public class heroServiceImpl implements heroService {

    @Autowired
    private heroRepository herorepo;
    
	@Override
	public heroModel updateHeroe(heroModel heroe) {
		java.util.Optional<heroModel>heroModelDB = this.herorepo.findById(heroe.getId());
        if (heroModelDB.isPresent()){
        	heroModel heroeUpdate = heroModelDB.get();
        	heroeUpdate.setnombre(heroe.getnombre());
        	heroeUpdate.setpoderes(heroe.getpoderes());
        	herorepo.save(heroeUpdate);
            return heroeUpdate; 
        }else{
            //error aqui!;
            return null;
        }
	}

	@Override
	public List<heroModel> getAllheroe() {		
		return herorepo.findAll();
	}



	@Override
	public List<heroModel>  getHeroByName(String heroe) {
		List<heroModel>herodataB = (List<heroModel>) this.herorepo.getHeroLikeName(heroe);
		return herodataB;
	}

	@Override
	public heroModel getHeroById(Long id) {
        Optional<heroModel>herodataB = this.herorepo.findById(id);
        try {
	        if (herodataB==null) {
				return null;
	        	
	        }else {
	    		return herodataB.get();
	
	        }
	        }catch(Exception ex) {
	        	return null;
	        }
		}

	@Override
	public String deleteHeroById(Long id) {
		try {
	        herorepo.deleteById(id);			
		}catch(Exception ex) {
			return "No Encontrado, o Error ";
		}
		return "Ok";
	}


}

	

