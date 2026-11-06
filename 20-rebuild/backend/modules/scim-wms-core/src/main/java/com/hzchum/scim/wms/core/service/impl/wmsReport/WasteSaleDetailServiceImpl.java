package com.hzchum.scim.wms.core.service.impl.wmsReport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WasteSaleDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDetailWholeInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDetailDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDetailQueryDtoParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.WasteSaleDetailService;
import com.hzchum.scim.wms.core.mapper.wmsReport.WasteSaleDetailMapper;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WasteSaleDetailServiceImpl extends ServiceImpl<WasteSaleDetailMapper, WasteSaleDetail> implements WasteSaleDetailService {
   @Override
   public List<WasteSaleDetailDTO> listByWasteSaleIds(Collection<Long> wasteSaleIds) {
      return this.baseMapper.selectByWasteSaleIds(wasteSaleIds);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void saveList(Long wasteSaleId, Collection<WasteSaleDetailDtoParam> wasteSaleDetailList) {
      wasteSaleDetailList.forEach(detailDtoParam -> {
         WasteSaleDetail wasteSaleDetail = BeanUtil.copy(detailDtoParam, WasteSaleDetail.class);
         wasteSaleDetail.setWasteSaleId(wasteSaleId);
         wasteSaleDetail.setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
         this.baseMapper.insert(wasteSaleDetail);
      });
   }

   @Override
   public List<WasteSaleDetailWholeInfoDTO> listWasteSaleDetailWholeInfo(WasteSaleDetailQueryDtoParam param) {
      return this.baseMapper.listWasteSaleDetailWholeInfo(param);
   }
}
