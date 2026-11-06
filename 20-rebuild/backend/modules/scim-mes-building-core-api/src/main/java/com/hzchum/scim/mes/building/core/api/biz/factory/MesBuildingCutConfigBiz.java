package com.hzchum.scim.mes.building.core.api.biz.factory;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingCutConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.CutSubTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingCutConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingCutConfigDTOParam;
import java.util.List;
import java.util.Map;

public interface MesBuildingCutConfigBiz extends IBiz<MesBuildingCutConfig> {
   List<MesBuildingCutConfigDTO> listByCondition(String name, Boolean boolNestCutEnum);

   Map<Boolean, List<MesBuildingCutConfigDTO>> getCutConfigList();

   Boolean saveCutConfig(MesBuildingCutConfigDTOParam copy);

   Boolean updateCutConfig(MesBuildingCutConfigDTOParam collect);

   Boolean removeCutConfig(List<Long> ids);

   List<CutSubTypeDTO> getCutSubTypes(String boolNestCutEnum);

   List<MesBuildingCutConfigDTO> listCondition();

   Boolean getBoolDrillHole(Long productId, Long cutConfigId);

   Map<Long, Boolean> getBoolDrillHoleFast(List<Long> productIdList, Long cutConfigId);

   Boolean getBoolDrillHoleNew(Long productId, Long cutConfigId, Long productProcessId);

   Map<Long, Boolean> getBoolDrillHoleNewFast(List<Long> productIdList, Long cutConfigId, Long productProcessId);

   Boolean getBoolDrillHole(Long productId, Long cutConfigId, String thick);

   List<Long> getBoolDrillHolePartIdList(List<Long> partIdList, Long cutConfigId, String thick);

   Map<Long, Integer> getBoolDrillHolePartIdMap(List<Long> partIdList, Long cutConfigId, String thick);
}
