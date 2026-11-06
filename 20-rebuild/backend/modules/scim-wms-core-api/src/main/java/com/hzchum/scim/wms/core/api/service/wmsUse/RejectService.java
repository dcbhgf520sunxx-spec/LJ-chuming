package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Reject;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.QuantityMeteDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.RejectDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.RejectDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.RejectInboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryRejectDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryRejectInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.RejectDTOParam;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RejectService extends IService<Reject> {
   PageVO<RejectInboundDTO> getInbound(QueryRejectInboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   InboundDTO getInboundDetailList(Long id);

   PageVO<RejectDTO> pageInfo(QueryRejectDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   RejectDetailDTO detailList(Long id);

   ListVO<MaterialInventoryDTO> getMatByDetailId(Long id);

   Boolean saveReject(RejectDTOParam param);

   Boolean saveRejectV2(RejectDTOParam param);

   List<Long> getIds(QueryRejectDTOParam param);

   Boolean passed(Long id, String approvalComments);

   Boolean passedV2(Long id, String approvalComments);

   Boolean returned(Long id, String approvalComments);

   Boolean detailByIds(List<Long> ids);

   BigDecimal getSumRejectAmount(Long purchaseId, Long supplierId, Long inboundId);

   BigDecimal getSumRejectAmountV2(Long purchaseId, Long supplierId, Long inboundId);

   BigDecimal getTotalAmount(List<Long> ids);

   Boolean review(Long approveRecordId, Integer decision, String opinion);

   Boolean revocation(Long id);

   QuantityMeteDTO getCountMete(@Param("purchaseId") Long purchaseId, @Param("status") List<Integer> status);
}
