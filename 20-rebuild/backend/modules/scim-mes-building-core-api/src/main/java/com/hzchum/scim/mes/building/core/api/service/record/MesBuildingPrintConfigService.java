package com.hzchum.scim.mes.building.core.api.service.record;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingPrintConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.PrintConfigDTOParam;

public interface MesBuildingPrintConfigService extends IService<MesBuildingPrintConfig> {
   MesBuildingPrintConfig getByProjectIdOrUserId(Long projectId, Long userId, Integer printType);

   boolean setPrintConfig(PrintConfigDTOParam param, Long userId);
}
