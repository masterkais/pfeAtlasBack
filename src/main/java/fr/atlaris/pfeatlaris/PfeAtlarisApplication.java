package fr.atlaris.pfeatlaris;

import fr.atlaris.pfeatlaris.DAO.GroupDao;
import fr.atlaris.pfeatlaris.DAO.UserDao;
import fr.atlaris.pfeatlaris.entities.Group;
import fr.atlaris.pfeatlaris.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PfeAtlarisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PfeAtlarisApplication.class, args);
    }

     @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
     @Autowired
    GroupDao groupDao;
    @Autowired
    UserDao userDao;
    @Override
        public void run(String... args) throws Exception {

            User admin = new User();
            admin.setPassword("admin");
            admin.setFirstName("admin");
            admin.setUserName("admin");
            admin.setPassword(getBCPE().encode(admin.getPassword()));
            List<Group> admingroups = new ArrayList<>();
            Group admins=groupDao.findByPrivileged("ADMIN");
            admingroups.add(admins);
            admin.setGroups(admingroups);
            userDao.saveAndFlush(admin);
    }
}
