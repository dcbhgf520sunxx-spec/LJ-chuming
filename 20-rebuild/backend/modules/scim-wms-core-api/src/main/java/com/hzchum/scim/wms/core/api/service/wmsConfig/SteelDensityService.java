package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SteelDensity;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SteelDensityClassTreeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SteelDensityDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SteelDensityDTOParam;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface SteelDensityService extends IService<SteelDensity> {
   List<SteelDensityDTO> getSteelDensityConf(Long classifyId, String createBy, String updateBy);

   Boolean saveSteelDensity(List<SteelDensityDTOParam> steelDensityDTOParams);

   Boolean updateSteelDensity(SteelDensityDTOParam steelDensityDTOParam);

   Boolean deletedSteelDensity(List<Long> ids);

   Map<Long, BigDecimal> getRedisSteelDensity();

   void refreshRedisSteelDensity();

   BigDecimal getRedisSteelDensityByClassifyId(Long classifyId);

   List<SteelDensityClassTreeDTO> getSteelClass();

   String checkSteelDensity(Map<String, BigDecimal> steelDensityMap);

   void updateSteelDensityRedis();
}
