package com.hzchum.scim.wms.core.service.impl.wmsUse;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.wms.core.api.enums.QualityTestingEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AppOutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundListDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAppService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class WmsAppServiceImpl implements WmsAppService {
   @Resource
   ReportService reportService;
   @Resource
   OutboundService outboundService;
   @Resource
   InboundService inboundService;
   @Resource
   TransferService transferService;

   @Override
   public PageVO<OutboundDetailDO> getOutboundDetail(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      return this.reportService.getOutboundDetail(param, pageNumber, pageSize, sort);
   }

   @Override
   public Boolean saveOutbound(SteelPlateOutboundDTOParam param) {
      return this.outboundService.saveOutbound(param);
   }

   @Override
   public MaterialInventoryDTO getOutboundMaterial(String barcode) {
      return this.outboundService.getMaterials(barcode);
   }

   @Override
   public Boolean outPassed(OutboundDTOParam param) {
      return this.outboundService.passed(param);
   }

   @Override
   public Boolean outReturned(Long id) {
      return this.outboundService.returned(id);
   }

   @Override
   public OutboundDTO getByCurrentUser() {
      return this.outboundService.getByCurrentUser();
   }

   @Override
   public Boolean outDeleteById(Long listId, Long materialId) {
      return this.outboundService.delete(listId, materialId);
   }

   @Override
   public PageVO<OutboundListDTO> outboundList(QueryOutboundDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      return this.outboundService.pageInfo(param, pageNumber, pageSize, sort);
   }

   @Override
   public OutboundDTO getOutboundDetail(Long id) {
      return this.outboundService.getOutboundById(id);
   }

   @Override
   public AppOutboundDTO getQuantity() {
      int iCount = this.inboundService
         .count(
            (Wrapper<Inbound>)(Wrappers.<Inbound>lambdaQuery().eq(Inbound::getReviewStatus, ReviewStatusEnum.AUDITING.getType()))
               .eq(Inbound::getQualityTestingEnum, QualityTestingEnum.UN_REVIEWED.getType())
         );
      int oCount = this.outboundService.count((Wrapper<Outbound>)Wrappers.<Outbound>lambdaQuery().eq(Outbound::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()));
      int count = this.transferService.count((Wrapper<Transfer>)Wrappers.<Transfer>lambdaQuery().eq(Transfer::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType()));
      return AppOutboundDTO.builder().storageInspection(iCount).outboundAudit(oCount).allocationInspection(count).build();
   }
}
