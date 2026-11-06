import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;

/** Offline preparation checks; no service bean, database, network or message send is invoked. */
public class PreparationProbe {
    private static int checks;
    private static void require(boolean value) { if(!value)throw new AssertionError();checks++; }
    private static void rejects(Method method,Object target,Object... arguments) throws Exception {
        try {method.invoke(target,arguments);throw new AssertionError("Missing rejection");}
        catch(InvocationTargetException error) {require(error.getCause() instanceof IllegalArgumentException);}
    }
    public static void main(String[] args) throws Exception {
        Class<?> type=Class.forName("com.hzchum.scim.common.core.service.impl.zhongnanoa.ShrPersonnelOrganizationServierImpl");
        Object shr=type.newInstance();
        Method endpoint=type.getDeclaredMethod("shrEndpoint",String.class);endpoint.setAccessible(true);
        Field host=type.getDeclaredField("shrHost");host.setAccessible(true);
        rejects(endpoint,shr,"/shr/resful/orgList");
        for(String invalid:Arrays.asList("file:///tmp/test","https://user:secret@shr.example.test","https://shr.example.test/?secret=test","invalid")) {
            host.set(shr,invalid);rejects(endpoint,shr,"/shr/resful/orgList");
        }
        host.set(shr,"https://shr.example.test/proxy///");
        require(endpoint.invoke(shr,"/shr/resful/orgList").equals("https://shr.example.test/proxy/shr/resful/orgList"));
        Method rows=type.getDeclaredMethod("requireSyncRows",java.util.List.class,String.class);rows.setAccessible(true);
        rejects(rows,shr,null,"部门");rejects(rows,shr,Collections.emptyList(),"人员");
        rows.invoke(shr,Collections.singletonList(new Object()),"岗位");require(true);
        Class<?> messages=Class.forName("com.hzchum.scim.system.core.api.common.utils.notification.MessagePushUtil");
        Object sender=messages.newInstance();
        Method body=messages.getDeclaredMethod("textMessageBody",String.class,java.util.List.class,boolean.class);body.setAccessible(true);
        String content="测试\"引号\"\n换行\\路径";
        ObjectMapper json=new ObjectMapper();
        JsonNode robot=json.readTree((String)body.invoke(sender,content,Collections.singletonList("test-recipient"),false));
        require(robot.size()==2 && robot.path("msgtype").asText().equals("text"));
        require(robot.path("text").path("content").asText().equals(content));
        JsonNode wms=json.readTree((String)body.invoke(sender,content,Collections.singletonList("test-recipient"),true));
        require(wms.path("text").path("content").asText().equals(content));
        require(wms.path("text").path("mentioned_mobile_list").get(0).asText().equals("test-recipient"));
        require(wms.path("agentid").asInt()==1000002 && wms.path("touser").asText().equals("@all"));
        require(wms.path("duplicate_check_interval").asInt()==1800 && wms.path("safe").asInt()==0);
        Field enabled=messages.getDeclaredField("webhookEnabled");enabled.setAccessible(true);
        require(!enabled.getBoolean(sender));
        System.out.println("integration_preparation_checks="+checks);
    }
}
