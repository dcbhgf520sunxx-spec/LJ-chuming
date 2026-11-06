package com.hzchum.scim.mes.building.core.api.service.quota_config;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalWhitelist;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalWhitelistDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalWhitelistParam;
import java.util.List;

public interface MesProductionReportingApprovalWhitelistService extends IService<MesProductionReportingApprovalWhitelist> {
   List<MesProductionReportingApprovalWhitelistDTO> listInfo();

   Boolean addOrEdit(MesProductionReportingApprovalWhitelistParam param);

   Boolean deleteByid(Long id);
}
