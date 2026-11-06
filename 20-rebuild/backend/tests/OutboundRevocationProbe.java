import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.service.impl.wmsUse.OutboundServiceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/** Execute the complete actual revocation method; no database or HTTP writes. */
public final class OutboundRevocationProbe {
    private static int checks;
    private static final List<String> failures = new ArrayList<>();
    private static final class Service extends OutboundServiceImpl {
        int failCalls;
        int approvalRevocations;
        Integer actualFreeze;
        Long actualParent;
        Integer actualStatus;
        Boolean actualInventory;
        @Override public Boolean fail(Long id, Integer status, Integer freeze, Boolean inventory) {
            failCalls++;
            actualParent=id; actualStatus=status; actualFreeze=freeze; actualInventory=inventory;
            return true;
        }
    }
    private static void field(Object target, String name, Object value) throws Exception {
        for (Class<?> type=target.getClass(); type!=null; type=type.getSuperclass()) {
            try { Field field=type.getDeclaredField(name); field.setAccessible(true); field.set(target,value); return; }
            catch (NoSuchFieldException absent) { }
        }
        throw new AssertionError("Missing real injected dependency " + name);
    }
    private static void user(long id) {
        SecurityUser user = new SecurityUser(id,"fixture","Ordinary creator",null,null,null,"",null,null,
            Collections.emptyList(),null,null,Collections.emptyList(),Collections.emptyList(),true,"",
            Collections.emptyList(),false,false,1,null,null,null);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,null,Collections.emptyList()));
    }
    private static Service service(int outboundType, boolean scheduling, int status, Long record) throws Exception {
        Service service = new Service();
        Outbound row=Outbound.builder().id(9101L).applicantId(42L).reviewStatus(status)
            .outboundTypeSelection(outboundType).boolScheduling(scheduling).approveRecordId(record).build();
        OutboundMapper mapper=(OutboundMapper)Proxy.newProxyInstance(OutboundMapper.class.getClassLoader(),new Class<?>[]{OutboundMapper.class},(proxy,method,args)-> {
            if (method.getName().equals("selectById") && Objects.equals(args[0],9101L)) return row;
            throw new AssertionError("Unexpected database operation " + method.getName());
        });
        WmsApproveRecordService approval=(WmsApproveRecordService)Proxy.newProxyInstance(WmsApproveRecordService.class.getClassLoader(),new Class<?>[]{WmsApproveRecordService.class},(proxy,method,args)-> {
            if (method.getName().equals("revocation") && Objects.equals(args[0],record)) { service.approvalRevocations++; return true; }
            throw new AssertionError("Unexpected approval operation " + method.getName());
        });
        field(service,"baseMapper",mapper); field(service,"wmsApproveRecordService",approval);
        return service;
    }
    private static void mapping(String label,int type,boolean scheduling,int expected,boolean hasRecord) throws Exception {
        Service service=service(type,scheduling,16,hasRecord?7201L:null); user(42L);
        boolean result=service.revocation(9101L);
        boolean okay=result && service.failCalls==1 && service.actualParent.equals(9101L)
            && service.actualStatus.equals(8) && service.actualInventory.equals(true)
            && Objects.equals(service.actualFreeze,expected) && service.approvalRevocations==(hasRecord?1:0);
        checks++;
        if (!okay) failures.add(label+": expectedFreeze="+expected+", actualFreeze="+service.actualFreeze+", failCalls="+service.failCalls);
        System.out.println("revocation_case="+label+":"+(okay?"PASS":"FAIL"));
    }
    private static void denied(String label,long actor,int status) throws Exception {
        Service service=service(8,false,status,7201L); user(actor); boolean refused=false;
        try { service.revocation(9101L); } catch (IllegalArgumentException expected) { refused=true; }
        boolean okay=refused && service.failCalls==0 && service.approvalRevocations==0;
        checks++; if(!okay)failures.add(label+": foreign/nonpending request reached terminal boundary");
        System.out.println("revocation_case="+label+":"+(okay?"PASS":"FAIL"));
    }
    public static void main(String[] args) throws Exception {
        try {
            mapping("production",1,false,13,true);
            mapping("scheduled-production",1,true,101,true);
            mapping("construction",256,false,107,true);
            mapping("sale",2,false,28,true);
            mapping("borrow",4,false,27,true);
            mapping("outsourcing",8,false,29,true);
            mapping("scraps",16,false,30,true);
            mapping("outsourcing-no-approval-record",8,false,29,false);
            denied("foreign-owner",99L,16);
            denied("already-terminal",42L,2);
            if(!failures.isEmpty())throw new AssertionError(failures.toString());
            if(checks!=10)throw new AssertionError("Missing revocation branch");
            System.out.println("outbound_revocation_checks=10");
        } finally { SecurityContextHolder.clearContext(); }
    }
}
