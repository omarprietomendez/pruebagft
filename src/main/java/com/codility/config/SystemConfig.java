package main.java.com.codility.config;

import main.java.com.codility.repository.UserRepository;
import main.java.com.codility.service.LegacyPaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@ComponentScan(basePackages = "com.codility.utils")
@PropertySource("classpath:production.properties")
@Import(MaintenanceConfig.class)
public class SystemConfig {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public LegacyPaymentsService paymentsService;

    @PostConstruct
    public void init(){
        userRepository.initialize();
    }


}
