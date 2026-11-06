package com.ljaps.rebuild.business;

import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.security.GeneratorUserDetailService;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/** Restore only the current MES card buttons, without assigning them to any role. */
@Component
@Order(Integer.MIN_VALUE)
public class LocalMesBasePermissionInitializer implements ApplicationRunner {
    private final JdbcTemplate jdbc;
    private final Environment env;
    private final RedisUtils redis;
    private final TransactionTemplate tx;
    private static final Object[][] LEAVES={
        {32514L,"查看涂装创建方式配置","coating_create_type_config:get",true},
        {32515L,"编辑涂装创建方式配置","coating_create_type_config:edit",true},
        {6001001L,"查看APP仓库重量配置","app_show_weight_config:get",false},
        {6001002L,"编辑APP仓库重量配置","app_show_weight_config:edit",false},
        {6001003L,"查看零件排产展示层级","machine_part_scheduling:get",false},
        {6001004L,"编辑零件排产展示层级","machine_part_scheduling:edit",false},
        {6001005L,"查看原料损耗计算公式","raw_material_loss_formula:get",false},
        {6001006L,"编辑原料损耗计算公式","raw_material_loss_formula:edit",false}
    };
    public LocalMesBasePermissionInitializer(JdbcTemplate jdbc,Environment env,RedisUtils redis,PlatformTransactionManager manager){
        this.jdbc=jdbc;this.env=env;this.redis=redis;this.tx=new TransactionTemplate(manager);
    }
    private byte[] roleLinksDigest(){
        final MessageDigest digest;
        try{digest=MessageDigest.getInstance("SHA-256");}catch(NoSuchAlgorithmException error){throw new IllegalStateException(error);}
        jdbc.query(connection->{
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM sys_role_menu_link ORDER BY id",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            statement.setFetchSize(Integer.MIN_VALUE);
            return statement;
        },(RowCallbackHandler)row->{
            for(int column=1;column<=row.getMetaData().getColumnCount();column++){
                byte[] value=row.getBytes(column);
                int length=value==null?-1:value.length;
                digest.update((byte)(length>>>24));digest.update((byte)(length>>>16));digest.update((byte)(length>>>8));digest.update((byte)length);
                if(value!=null)digest.update(value);
            }
        });
        return digest.digest();
    }
    @Override public void run(ApplicationArguments arguments){
        if(!env.getProperty("ljaps.lifecycle.enabled",Boolean.class,false))return;
        String database=jdbc.queryForObject("SELECT DATABASE()",String.class);
        if(database==null || !(database.equals("plm7_rebuild") || database.startsWith("plm7_rebuild_qa_")))throw new IllegalStateException("MES menu initialization requires an explicitly rebuilt database");
        Boolean changed=tx.execute(status->{
            Integer parents=jdbc.queryForObject("SELECT COUNT(*) FROM sys_menu WHERE id=1176 AND category=0 AND type=1 AND component='/config-manage/mes/base/index' AND bool_delete_enum=0",Integer.class);
            if(parents==null || parents!=1)throw new IllegalStateException("Unexpected current MES configuration parent");
            byte[] roleLinks=roleLinksDigest();
            boolean any=false;
            for(Object[] leaf:LEAVES){
                List<Map<String,Object>> matches=jdbc.queryForList("SELECT id,pid,category,type,bool_delete_enum FROM sys_menu WHERE permission=?",leaf[2]);
                if(matches.isEmpty()){
                    if(Boolean.TRUE.equals(leaf[3]))throw new IllegalStateException("Missing known coating permission ID");
                    Integer occupied=jdbc.queryForObject("SELECT COUNT(*) FROM sys_menu WHERE id=?",Integer.class,leaf[0]);
                    if(occupied==null || occupied!=0)throw new IllegalStateException("MES permission seed ID is occupied");
                    jdbc.update("INSERT INTO sys_menu(id,pid,category,type,name,permission,sort) VALUES(?,1176,0,2,?,?,1)",leaf[0],leaf[1],leaf[2]);any=true;
                }else{
                    if(matches.size()!=1)throw new IllegalStateException("Duplicate MES card permission");
                    Map<String,Object> row=matches.get(0);
                    if(((Number)row.get("pid")).longValue()!=1176L || ((Number)row.get("category")).intValue()!=0 || ((Number)row.get("type")).intValue()!=2)throw new IllegalStateException("Unexpected MES permission parent/type");
                    if(Boolean.TRUE.equals(leaf[3]) && ((Number)row.get("id")).longValue()!=((Number)leaf[0]).longValue())throw new IllegalStateException("Known coating permission ID changed");
                    Object deleted=row.get("bool_delete_enum");
                    if(Boolean.TRUE.equals(deleted) || (deleted instanceof Number && ((Number)deleted).intValue()==1)){
                        if(!Boolean.TRUE.equals(leaf[3]))throw new IllegalStateException("Unexpected removed MES card permission");
                        jdbc.update("UPDATE sys_menu SET bool_delete_enum=0 WHERE id=? AND pid=1176 AND category=0 AND type=2 AND permission=? AND bool_delete_enum=1",leaf[0],leaf[2]);any=true;
                    }
                }
            }
            if(!Arrays.equals(roleLinks,roleLinksDigest()))throw new IllegalStateException("MES initialization changed role menu links");
            return any;
        });
        if(Boolean.TRUE.equals(changed)){redis.del("menus");GeneratorUserDetailService.USER_MAP.clear();}
    }
}
