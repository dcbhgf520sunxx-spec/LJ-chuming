package com.ljaps.rebuild;

import org.springframework.jdbc.core.JdbcTemplate;

public class HealthReadinessProbe {
    static class Database extends JdbcTemplate {
        boolean unavailable;
        @Override public <T> T queryForObject(String sql,Class<T> type) {
            if(unavailable)throw new IllegalStateException("database unavailable");
            return type.cast(Integer.valueOf(1));
        }
    }
    public static void main(String[] args) {
        Database database=new Database();
        RebuildApplication.HealthController health=new RebuildApplication.HealthController(database);
        if(!"STARTING".equals(health.health().get("status")))throw new AssertionError("Initialization must finish before UP");
        health.applicationReady();
        if(!"UP".equals(health.health().get("status")))throw new AssertionError("Ready application must report UP");
        database.unavailable=true;
        try {health.health();throw new AssertionError("Database failure must fail health");}
        catch(IllegalStateException expected){}
        System.out.println("health_readiness_checks=3");
    }
}
