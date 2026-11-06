package com.hzchum.scim.mes.building.core.mapper.quota_config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalWhitelist;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalWhitelistDTO;
import java.util.List;

public interface MesProductionReportingApprovalWhitelistMapper extends BaseMapper<MesProductionReportingApprovalWhitelist> {
   List<MesProductionReportingApprovalWhitelistDTO> listInfo();
}
