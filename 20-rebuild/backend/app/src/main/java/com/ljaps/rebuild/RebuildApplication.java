package com.ljaps.rebuild;

import java.util.Collections;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(excludeName={"org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration","org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration","org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration","org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration","org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration","com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAutoConfiguration"})
public class RebuildApplication {
    public static void main(String[] args) {
        SpringApplication.run(RebuildApplication.class, args);
    }

    @RestController
    static class HealthController {
        private final JdbcTemplate jdbc;
        private volatile boolean ready;

        HealthController(JdbcTemplate jdbc) { this.jdbc = jdbc; }

        @EventListener(ApplicationReadyEvent.class)
        public void applicationReady() { this.ready = true; }

        @GetMapping("/actuator/health")
        public Map<String, String> health() {
            jdbc.queryForObject("SELECT 1", Integer.class);
            return Collections.singletonMap("status", this.ready ? "UP" : "STARTING");
        }
    }
}
