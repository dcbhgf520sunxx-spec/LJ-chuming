package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.RejectDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.RejectDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.ReceiptMeteDTO;
import com.hzchum.scim.wms.core.api.service.wmsUse.RejectDetailService;
import com.hzchum.scim.wms.core.mapper.wmsUse.RejectDetailMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RejectDetailServiceImpl extends ServiceImpl<RejectDetailMapper, RejectDetail> implements RejectDetailService {
   @Override
   public List<RejectDetail> selectPassDetailByInboundDetailIds(List<Long> inboundDetailIds) {
      return CollectionUtil.isEmpty(inboundDetailIds) ? new ArrayList<>() : this.baseMapper.selectPassDetailByInboundDetailIds(inboundDetailIds);
   }

   @Override
   public List<ReceiptMeteDTO> getPurchaseRejectMete(List<Long> purchaseIds) {
      return this.baseMapper.getPurchaseRejectMete(purchaseIds);
   }

   @Override
   public List<RejectDetailDO> selectPassDetail(Long workshopId, LocalDateTime startDay, LocalDateTime endDay) {
      return this.baseMapper.selectPassDetail(workshopId, startDay, endDay);
   }
}
