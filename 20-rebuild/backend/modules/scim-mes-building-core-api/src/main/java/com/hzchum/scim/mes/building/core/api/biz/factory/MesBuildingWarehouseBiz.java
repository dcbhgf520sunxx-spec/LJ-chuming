package com.hzchum.scim.mes.building.core.api.biz.factory;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWarehouse;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWarehouseDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWarehouseQueryDTOParam;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MesBuildingWarehouseBiz extends IBiz<MesBuildingWarehouse> {
   PageVO<MesBuildingWarehouseDTO> pageList(MesBuildingWarehouseQueryDTOParam param, Integer pageNumber, Integer pageSize);

   List<MesBuildingWarehouseDTO> listWarehouse(MesBuildingWarehouseQueryDTOParam param);

   List<Map<String, Object>> getWorkshopWarehouseTree(Long factoryId, Boolean boolEnableEnum);

   Boolean saveWarehouse(MesBuildingWarehouseDTOParam param);

   Boolean updateWarehouse(MesBuildingWarehouseDTOParam param);

   Boolean updateWarehouseStatus(Long id, Boolean boolEnableEnum);

   Boolean removeWarehouse(Set<Long> ids);
}
