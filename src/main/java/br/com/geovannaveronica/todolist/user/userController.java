package br.com.geovannaveronica.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Modificadores / Tipos de acessos
 * Public
 * Private
 * Protected
 */

 @RestController
 @RequestMapping("/users")
public class userController {
    
    @Autowired
    private IUserRepository userRepository;


    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel UserModel) {
        var user = this.userRepository.findByUsername(UserModel.getUsername());
        
        if(user != null){
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario ja existe");

        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12, UserModel.getPassword().toCharArray());
        
        UserModel.setPassword(passwordHashred);
        
        var userCreated = this.userRepository.save(UserModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);

    }
}
