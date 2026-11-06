package com.hzchum.scim.mes.building.core.mapper.warehouse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseStorageProduct;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WarehouseProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseManagementQueryParam;
import java.util.List;

public interface MesBuildingWarehouseStorageProductMapper extends BaseMapper<MesBuildingWarehouseStorageProduct> {
   List<WarehouseProductDTO> selectUnSavedWarehouseProductList(WarehouseManagementQueryParam param);

   List<WarehouseProductDTO> selectUnOutWarehouseProductList(WarehouseManagementQueryParam param);
}
