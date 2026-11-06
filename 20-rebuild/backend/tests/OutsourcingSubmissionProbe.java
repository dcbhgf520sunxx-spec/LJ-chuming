import java.time.LocalDateTime;
import com.hzchum.scim.wms.core.service.impl.wmsUse.OutboundServiceImpl;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;

/** Execute the real orchestration without a database or foreign-row mutation. */
public final class OutsourcingSubmissionProbe {
    private static final class Service extends OutboundServiceImpl {
        int saves;
        int submissions;
        @Override public Boolean saveOutsourcingOutbound(SteelPlateOutboundDTOParam param) {
            saves++;
            param.setId(9001L);
            return true;
        }
        @Override public synchronized Boolean submitReview(OutboundDTOParam param) {
            if (!Long.valueOf(9001L).equals(param.getId())) throw new AssertionError("Wrong native parent");
            if (param.getList() == null || !param.getList().isEmpty()) {
                throw new AssertionError("Single outsourcing must not send stock IDs as outbound detail IDs; row time was already saved");
            }
            submissions++;
            return true;
        }
    }
    public static void main(String[] args) {
        Service service = new Service();
        SteelPlateOutboundDTOParam param = new SteelPlateOutboundDTOParam();
        param.setMaterialId(77L);
        param.setOutboundTypeSelection(8);
        param.setBoolSubmitCheck(true);
        param.setOutboundTime(LocalDateTime.of(2026, 10, 24, 1, 2));
        service.outsourcingDirectSubmitReview(param);
        if (service.saves != 1 || service.submissions != 1) throw new AssertionError("Submit lifecycle changed");
        param.setBoolSubmitCheck(false);
        service.outsourcingDirectSubmitReview(param);
        if (service.saves != 2 || service.submissions != 1) throw new AssertionError("Draft lifecycle changed");
        System.out.println("outsourcing_submission_checks=4");
    }
}
