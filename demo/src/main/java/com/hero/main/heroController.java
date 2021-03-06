package com.hero.main;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hero.main.model.heroModel;
import com.hero.main.service.*;

@RestController
public class heroController {
	
    @Autowired
    private heroService heroserv;
    
    
    @GetMapping("/heroe")
    public ResponseEntity<List<heroModel>> getAllheroes(){
        return ResponseEntity.ok().body(heroserv.getAllheroe());
    }
    
    
    @GetMapping("/heroe/{id}")
    public ResponseEntity getAllheroById(@PathVariable Long id){
    	ResponseEntity msg= ResponseEntity.ok().body(heroserv.getHeroById(id));
            if (msg.ok(200) != null){
                return ResponseEntity.ok().body(heroserv.getHeroById(id));
            }else{
               return ResponseEntity.status(404).body("no encontrado");
            }

     }
    
    @PostMapping("/heroe")
    public ResponseEntity savehero(@RequestBody heroModel hero){
    ResponseEntity msg = ResponseEntity.ok().body(heroserv.getHeroById(hero.getId()));
    if (ResponseEntity.status(202) != null){
        return ResponseEntity.ok().body(heroserv.updateHeroe(hero));
    }else{
       return ResponseEntity.status(404).body("no encontrado");
    }

}
    
    @RequestMapping(method = RequestMethod.GET)
     public ResponseEntity getHeroLikeName(@RequestParam(value="name") String name){
            return ResponseEntity.ok().body(heroserv.getHeroByName(name));
     }
    
    @DeleteMapping("/heroe/{id}")
    public ResponseEntity deleteHeroById(@PathVariable Long id){
        ResponseEntity msg = ResponseEntity.ok().body(heroserv.deleteHeroById(id));
        if (msg.ok(200) != null){
            return ResponseEntity.status(200).body("elimando!");
        }else{
           return ResponseEntity.status(404).body("no encontrado");
        }

     }
    
}