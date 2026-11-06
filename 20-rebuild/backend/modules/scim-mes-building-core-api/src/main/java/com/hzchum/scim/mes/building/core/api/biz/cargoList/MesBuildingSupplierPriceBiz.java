package com.hzchum.scim.mes.building.core.api.biz.cargoList;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.AppSupplierPersonalDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.SupplierPriceCarLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.SupplierPriceSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.SupplierPriceSaveVORequestParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.SupplierPriceUpdateDTOParam;
import java.util.List;
import java.util.Map;

public interface MesBuildingSupplierPriceBiz {
   Boolean save(SupplierPriceSaveDTOParam request);

   Boolean update(SupplierPriceUpdateDTOParam request);

   boolean deleteById(Long id);

   Map<String, Object> getInfo(Long projectId, String licensePlate, Long cargoListId);

   ListVO<AppSupplierPersonalDO> getSupplierAndLicensePlate(Long projectId);

   List<SupplierPriceCarLinkDTO> getCarLinkList(Long id);

   List<NameInfo> listProjectSupplier(Long projectId);

   Boolean saveV2(SupplierPriceSaveVORequestParam body);

   Boolean updateV2(SupplierPriceUpdateDTOParam body);
}
