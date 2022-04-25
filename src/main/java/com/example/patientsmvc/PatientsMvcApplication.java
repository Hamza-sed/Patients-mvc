package com.example.patientsmvc;

import com.example.patientsmvc.entities.Patient;
import com.example.patientsmvc.repositories.PatientRepository;
import com.example.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //@Bean
   /* CommandLineRunner CommandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Hassan",new Date(),false,120));
            patientRepository.save(new Patient(null,"Hamza",new Date(),true,125));
            patientRepository.save(new Patient(null,"Othmane",new Date(),true,182));
            patientRepository.save(new Patient(null,"Marwane",new Date(),false,512));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }*/
   // @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("hamza","1234","1234");
            securityService.saveNewUser("mohamed","1234","1234");
            securityService.saveNewUser("youssfi","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("hamza","USER");
            securityService.addRoleToUser("mohamed","USER");
            securityService.addRoleToUser("mohamed","ADMIN");
            securityService.addRoleToUser("youssfi","USER");
        };
    }

}
