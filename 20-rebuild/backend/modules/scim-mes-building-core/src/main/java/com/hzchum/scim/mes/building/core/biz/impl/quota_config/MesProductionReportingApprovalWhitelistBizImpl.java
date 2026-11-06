package com.hzchum.scim.mes.building.core.biz.impl.quota_config;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesProductionReportingApprovalWhitelistBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalWhitelist;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalWhitelistDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalWhitelistParam;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesProductionReportingApprovalWhitelistService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesProductionReportingApprovalWhitelistMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesProductionReportingApprovalWhitelistBizImpl
   extends IBizImpl<MesProductionReportingApprovalWhitelistService, MesProductionReportingApprovalWhitelistMapper, MesProductionReportingApprovalWhitelist>
   implements MesProductionReportingApprovalWhitelistBiz {
   @Override
   public List<MesProductionReportingApprovalWhitelistDTO> listInfo() {
      return this.baseService.listInfo();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addOrEdit(MesProductionReportingApprovalWhitelistParam param) {
      return this.baseService.addOrEdit(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchAddOrEdit(List<MesProductionReportingApprovalWhitelistParam> paramList) {
      paramList.forEach(this.baseService::addOrEdit);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(Long id) {
      return this.baseService.deleteByid(id);
   }
}
