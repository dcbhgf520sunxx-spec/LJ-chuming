import java.util.Arrays;
import com.hzchum.scim.wms.core.service.impl.wmsUse.OutboundServiceImpl;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;

/** Real batch orchestration must submit once after all native rows are saved. */
public final class OutsourcingBatchSubmissionProbe {
    private static final class Service extends OutboundServiceImpl {
        int saves;
        int submissions;
        @Override public Boolean saveOutsourcingOutbound(SteelPlateOutboundDTOParam param) {
            saves++;
            param.setId(9002L);
            return true;
        }
        @Override public synchronized Boolean submitReview(OutboundDTOParam param) {
            if (saves != 2 || !Long.valueOf(9002L).equals(param.getId())) throw new AssertionError("Submit before all owned rows saved");
            if (param.getList() == null || !param.getList().isEmpty()) throw new AssertionError("Batch must retain native saved times");
            submissions++;
            return true;
        }
    }
    public static void main(String[] args) {
        Service service = new Service();
        BatchOutboundDTOParam param = new BatchOutboundDTOParam();
        BatchOutboundDetailDTOParam first = new BatchOutboundDetailDTOParam(); first.setId(77L);
        BatchOutboundDetailDTOParam second = new BatchOutboundDetailDTOParam(); second.setId(78L);
        param.setList(Arrays.asList(first, second));
        param.setOutboundTypeSelection(8); param.setBoolSubmitCheck(true);
        service.BatchOutsourcingSubmitReview(param);
        if (service.saves != 2 || service.submissions != 1) throw new AssertionError("Actual batch true did not submit once");
        param.setBoolSubmitCheck(false); service.BatchOutsourcingSubmitReview(param);
        if (service.saves != 4 || service.submissions != 1) throw new AssertionError("Draft branch submitted unexpectedly");
        System.out.println("outsourcing_batch_submission_checks=4");
    }
}
