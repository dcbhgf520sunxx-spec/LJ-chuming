package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.pojo._do.MesSectionWarehouseConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesSectionWarehouseConfigDTO;
import com.hzchum.scim.system.core.api.pojo.vo.MesSectionWarehouseConfigVO;
import java.util.List;
import java.util.Map;

public interface MesSectionWarehouseConfigService extends IService<MesSectionWarehouseConfig> {
   Map<Integer, List<MesSectionWarehouseConfigDTO>> getSectionWarehouseConfigList(
      Integer productType, Integer productClassificationEnum, Integer productSectionNameEnum
   );

   List<MesSectionWarehouseConfigDTO> getSimplenessList(Integer productType, Integer productClassificationEnum, Integer productSectionNameEnum);

   List<NameInfo> getSectionConfigNameList(Integer productType, Integer productClassificationEnum, Integer productSectionNameEnum);

   Boolean updateSectionWarehouseConfig(MesSectionWarehouseConfigVO vo);

   int deleteAllFromTable(String tableName);
}
