package com.ljaps.rebuild.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import javax.annotation.PreDestroy;
import org.springframework.aop.framework.Advised;
import org.springframework.boot.*;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.*;
import org.springframework.transaction.support.TransactionTemplate;

/** Explicitly enable local business lifecycle code, never global annotation scanning of external jobs. */
@Component
@Order(Integer.MAX_VALUE)
public class LocalBusinessLifecycle implements ApplicationRunner {
    private static final String BASE="com.hzchum.scim.rest.";
    static final String[] INITIALIZERS={
        "runner.CountryRunner","runner.DepartmentInitRunner","runner.RoleInitRunner","runner.PermissionTypeRunner",
        "runner.TechEnclosureTypeRunner","runner.common.ClassificationInitRunner","runner.mes.enclosure.enclosureProcessRunner","runner.common.SteelDensityRunner","runner.ConfigRunner",
        "runner.InventoryConfigurationRunner","runner.SysKitWmsCommonConfigRunner","runner.SysHomeEnableConfigRunner",
        "runner.MesBuildingProcessRunner","runner.MesSectionWarehouseConfigV2Runner","runner.SupplierPaymentAttributeRunner",
        "runner.MesContractProjectWageConfigRunner","runner.MesWeighbridgeManagementRunner",
        "runner.redis.ReportNumberRedisRunner","runner.SubcontractClassConfigRunner","runner.CappConfigRunner",
        "runner.SystemChargingMethodConfigRunner","runner.crm.CrmBusinessLicenseQueryConfigRunner",
        "runner.crm.CrmPageManagementConfigRunner","runner.UserLoginRunner"
    };
    static final String[][] JOBS={
        {"WipStatisticsSchedule","generateDailyReport","daily"},
        {"MesLossWorkProgressStatisticsTwoSchedule","task3","daily"},
        {"MaterialMonthSummarySchedule","calculateAveragePrice","monthly"},
        {"MaterialMonthSummarySchedule","manufacturedStatistics","monthly"},
        {"ScheduledTasks","generateInspectionTaskAbsencesRecord","daily"},
        {"SupplierAnnualEvaluateResetSchedule","resetSupplierAnnualEvaluateStatus","yearly"},
        {"CrmProjectValidityDeadlineCheckSchedule","crmProjectValidityDeadlineCheckSchedule","daily"},
        {"ProjectBehaviorScoreSchedule","task","yearly"},
        {"MesLossWorkProgressStatisticsSchedule","task3","daily"},
        {"MesProductionReportingSchedule","schedule","daily"},
        {"ProjectAttendanceSchedule","createAttendanceTask","daily"},
        {"ManufactureCostSchedule","task3","daily"},
        {"MesBehaviorScoreSchedule","task","yearly"},
        {"ProductProductionSummarySchedule","task1","monthly"}
    };
    private final ApplicationContext context; private final JdbcTemplate jdbc; private final Environment env;
    private final TransactionTemplate tx; private final ThreadPoolTaskScheduler scheduler=new ThreadPoolTaskScheduler();
    private final List<Map<String,Object>> initialization=new ArrayList<>(), jobs=new ArrayList<>();
    private volatile boolean ready;
    private Boolean initializerIdempotent;
    public LocalBusinessLifecycle(ApplicationContext context,JdbcTemplate jdbc,Environment env,PlatformTransactionManager manager){
        this.context=context;this.jdbc=jdbc;this.env=env;tx=new TransactionTemplate(manager);tx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
    }
    public boolean isReady(){return ready;}
    public Map<String,Object> registry(){Map<String,Object> r=new LinkedHashMap<>();r.put("enabled",env.getProperty("ljaps.lifecycle.enabled",Boolean.class,false));r.put("ready",ready);r.put("initializers",initialization);r.put("qa_initializer_second_unchanged",initializerIdempotent);r.put("jobs",jobs);return r;}
    public void run(ApplicationArguments arguments) throws Exception {
        if(!env.getProperty("ljaps.lifecycle.enabled",Boolean.class,false)){ready=true;return;}
        String database=jdbc.queryForObject("SELECT DATABASE()",String.class);
        if(database==null || !(database.equals("plm7_rebuild") || database.startsWith("plm7_rebuild_qa_")))throw new IllegalStateException("Business lifecycle requires an explicitly rebuilt database");
        if(env.getProperty("ljaps.lifecycle.qa-run-all",Boolean.class,false) && !database.startsWith("plm7_rebuild_qa_"))throw new IllegalStateException("Manual lifecycle exercise is restricted to disposable QA databases");
        jdbc.execute("CREATE TABLE IF NOT EXISTS rebuild_job_execution (job_name VARCHAR(190) NOT NULL, period_key VARCHAR(32) NOT NULL,status VARCHAR(16) NOT NULL,started_at DATETIME(6),finished_at DATETIME(6),error_class VARCHAR(190),PRIMARY KEY(job_name,period_key)) ENGINE=InnoDB");
        List<Object> runners=new ArrayList<>();
        Map<Object,String> initializerNames=new IdentityHashMap<>();
        for(String name:INITIALIZERS){Object bean=create(BASE+name);runners.add(bean);initializerNames.put(bean,BASE+name);}
        runners.add((CommandLineRunner)(args)->{
            Object bean=context.getBean("scmSupplierConfigBizImpl");
            unwrap(bean).getClass().getMethod("initEvaluationCategory").invoke(unwrap(bean));
        });
        initializerNames.put(runners.get(runners.size()-1),"com.hzchum.scim.scm.core.biz.impl.scm.ScmSupplierConfigBizImpl#initEvaluationCategory");
        runners.sort(Comparator.comparingInt(r->{Order o=org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation(org.springframework.aop.support.AopUtils.getTargetClass(r),Order.class);return o==null?Integer.MAX_VALUE:o.value();}));
        for(Object runner:runners){
            String name=initializerNames.get(runner);
            tx.execute(s->{try{((CommandLineRunner)runner).run();return null;}catch(Exception e){throw new IllegalStateException("Initializer failed: "+name,e);}});
            Map<String,Object> row=new LinkedHashMap<>();row.put("class",name);row.put("status","SUCCEEDED");initialization.add(row);
        }
        if(env.getProperty("ljaps.lifecycle.qa-run-all",Boolean.class,false)){
            List<Map<String,Object>> before=checksums();
            for(Object runner:runners)tx.execute(s->{try{((CommandLineRunner)runner).run();return null;}catch(Exception e){throw new IllegalStateException(e);}});
            initializerIdempotent=before.equals(checksums());
            saveEvidence();
            if(!initializerIdempotent)throw new IllegalStateException("Initializers changed business rows on a second run");
        }
        scheduler.setPoolSize(5);scheduler.setThreadNamePrefix("local-business-");scheduler.setWaitForTasksToCompleteOnShutdown(false);scheduler.initialize();
        Map<String,Object> instances=new HashMap<>();
        for(String[] spec:JOBS){
            String className=BASE+"schedule."+spec[0];Object bean=instances.get(className);
            if(bean==null){bean=create(className);instances.put(className,bean);}
            Object target=unwrap(bean);Method method=target.getClass().getMethod(spec[1]);Scheduled original=method.getAnnotation(Scheduled.class);
            if(original==null)throw new IllegalStateException("Missing source cron: "+className);
            String cron=env.resolveRequiredPlaceholders(original.cron());String zone=original.zone().isEmpty()?"Asia/Shanghai":original.zone();
            Map<String,Object> row=new LinkedHashMap<>();String identity=className+"#"+spec[1];row.put("job",identity);row.put("cron",cron);row.put("zone",zone);row.put("period",spec[2]);jobs.add(row);
            final Object action=target;
            scheduler.schedule(()->{try{execute(identity,spec[2],action,method);}catch(RuntimeException error){org.slf4j.LoggerFactory.getLogger(getClass()).error("Local business task failed: "+identity,error);}},new CronTrigger(cron,TimeZone.getTimeZone(zone)));
            if(env.getProperty("ljaps.lifecycle.qa-run-all",Boolean.class,false)){
                row.put("qa_first",execute(identity,spec[2],action,method));row.put("qa_second",execute(identity,spec[2],action,method));saveEvidence();
            }
        }
        ready=true;saveEvidence();
    }
    private List<Map<String,Object>> checksums(){
        List<String> tables=jdbc.queryForList("SELECT table_name FROM information_schema.tables WHERE table_schema=DATABASE() AND table_name NOT LIKE 'rebuild_%' ORDER BY table_name",String.class);
        return jdbc.queryForList("CHECKSUM TABLE "+String.join(",",tables));
    }
    private Object create(String name) throws Exception{return context.getAutowireCapableBeanFactory().createBean(Class.forName(name));}
    private Object unwrap(Object bean) throws Exception {while(bean instanceof Advised){Object next=((Advised)bean).getTargetSource().getTarget();if(next==null)break;bean=next;}return bean;}
    private String execute(String identity,String cadence,Object target,Method method){
        LocalDate now=LocalDate.now(ZoneId.of("Asia/Shanghai"));String period=cadence.equals("yearly")?String.valueOf(now.getYear()):cadence.equals("monthly")?YearMonth.from(now).toString():now.toString();
        try{return tx.execute(status->{
            jdbc.update("INSERT IGNORE INTO rebuild_job_execution(job_name,period_key,status) VALUES(?,?,'PENDING')",identity,period);
            String previous=jdbc.queryForObject("SELECT status FROM rebuild_job_execution WHERE job_name=? AND period_key=? FOR UPDATE",String.class,identity,period);
            if("SUCCEEDED".equals(previous))return "SKIPPED_SUCCEEDED";
            jdbc.update("UPDATE rebuild_job_execution SET status='RUNNING',started_at=NOW(6),finished_at=NULL,error_class=NULL WHERE job_name=? AND period_key=?",identity,period);
            try{method.invoke(target);}catch(InvocationTargetException e){throw new IllegalStateException("Business task execution failed",e.getCause());}catch(Exception e){throw new IllegalStateException(e);}
            jdbc.update("UPDATE rebuild_job_execution SET status='SUCCEEDED',finished_at=NOW(6) WHERE job_name=? AND period_key=?",identity,period);return "SUCCEEDED";
        });}catch(RuntimeException e){
            Throwable root=e;while(root.getCause()!=null)root=root.getCause();final String errorClass=root.getClass().getName();
            tx.execute(s->{jdbc.update("INSERT INTO rebuild_job_execution(job_name,period_key,status,started_at,finished_at,error_class) VALUES(?,?,'FAILED',NOW(6),NOW(6),?) ON DUPLICATE KEY UPDATE status='FAILED',finished_at=NOW(6),error_class=VALUES(error_class)",identity,period,errorClass);return null;});
            if(env.getProperty("ljaps.lifecycle.qa-run-all",Boolean.class,false))return "FAILED:"+errorClass;
            throw e;
        }
    }
    private void saveEvidence(){try{Path p=Paths.get("/evidence/lifecycle-registration.json");Files.createDirectories(p.getParent());new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(p.toFile(),registry());}catch(Exception e){throw new IllegalStateException("Cannot write lifecycle evidence",e);}}
    @PreDestroy public void stop(){scheduler.shutdown();}
}
