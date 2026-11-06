package com.hzchum.scim.mes.enclosure.core.api.biz.cargoList;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.AppSupplierPersonalDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList.SupplierPriceCarLinkDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.save.SupplierPriceSaveDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.update.SupplierPriceUpdateDTOParam;
import java.util.List;
import java.util.Map;

public interface MesEnclosureSupplierPriceBiz {
   Boolean save(SupplierPriceSaveDTOParam request);

   Boolean update(SupplierPriceUpdateDTOParam request);

   boolean deleteById(Long id);

   Map<String, Object> getInfo(Long projectId, String licensePlate);

   ListVO<AppSupplierPersonalDO> getSupplierAndLicensePlate(Long projectId);

   List<SupplierPriceCarLinkDTO> getCarLinkList(Long id);
}
