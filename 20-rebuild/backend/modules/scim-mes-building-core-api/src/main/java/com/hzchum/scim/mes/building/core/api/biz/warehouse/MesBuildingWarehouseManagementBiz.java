package com.hzchum.scim.mes.building.core.api.biz.warehouse;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WarehouseProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WorkshopWarehouseSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.AppWarehouseProductSaveParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.AppWarehouseProductScanQrCodeParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseManagementQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseProductMoveDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseProductSaveParam;
import java.util.List;
import java.util.Map;

public interface MesBuildingWarehouseManagementBiz {
   PageVO<WarehouseProductDTO> listUnSaveWarehouseProduct(WarehouseManagementQueryParam param, Integer pageNumber, Integer pageSize);

   Boolean saveWarehouseProduct(List<WarehouseProductSaveParam> paramList);

   List<ProjectInfo> listWarehouseProject();

   List<WorkshopWarehouseSummaryDTO> listWorkshopWarehouseSummary(Long projectId);

   PageVO<WarehouseProductDTO> listSaveWarehouseProduct(WarehouseManagementQueryParam param, Integer pageNumber, Integer pageSize);

   Boolean moveWarehouse(List<WarehouseProductMoveDTOParam> paramList);

   Map<String, Object> scanQrCodeWarehouse(AppWarehouseProductScanQrCodeParam param);

   Boolean appScanQrCodeSave(AppWarehouseProductSaveParam param);

   List<ProjectInfo> getUnIntoWarehouseLocationProjectList();

   Boolean appManualSelectCodeSave(AppWarehouseProductSaveParam param);
}
