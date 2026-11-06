package com.hzchum.scim.mes.building.core.api.biz.quota_config;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalWhitelist;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalWhitelistDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalWhitelistParam;
import java.util.List;

public interface MesProductionReportingApprovalWhitelistBiz extends IBiz<MesProductionReportingApprovalWhitelist> {
   List<MesProductionReportingApprovalWhitelistDTO> listInfo();

   Boolean addOrEdit(MesProductionReportingApprovalWhitelistParam param);

   Boolean batchAddOrEdit(List<MesProductionReportingApprovalWhitelistParam> paramList);

   Boolean delete(Long id);
}
