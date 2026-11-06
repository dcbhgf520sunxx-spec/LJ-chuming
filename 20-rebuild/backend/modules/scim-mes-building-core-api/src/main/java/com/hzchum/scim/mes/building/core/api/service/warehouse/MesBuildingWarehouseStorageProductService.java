package com.hzchum.scim.mes.building.core.api.service.warehouse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseStorageProduct;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WarehouseProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseManagementQueryParam;
import java.util.Collection;
import java.util.List;

public interface MesBuildingWarehouseStorageProductService extends IService<MesBuildingWarehouseStorageProduct> {
   List<MesBuildingWarehouseStorageProduct> listByWarehouseRecordIds(Collection<Long> warehouseRecordIds);

   List<MesBuildingWarehouseStorageProduct> listByWarehouseRecordId(Long warehouseRecordId);

   List<MesBuildingWarehouseStorageProduct> listByWarehouseSummaryIds(Collection<Long> warehouseSummaryIds);

   List<MesBuildingWarehouseStorageProduct> listByWarehouseSummaryId(Long warehouseSummaryId);

   List<WarehouseProductDTO> listUnSavedWarehouseProduct(WarehouseManagementQueryParam param);

   List<WarehouseProductDTO> getUnOutWarehouseProductList(WarehouseManagementQueryParam param);
}
