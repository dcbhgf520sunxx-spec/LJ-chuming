package com.hzchum.scim.mes.building.core.api.service.cargoList;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.AppSupplierPersonalDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.SupplierPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingSupplierPrice;
import java.util.List;

public interface MesBuildingSupplierPriceService extends IService<MesBuildingSupplierPrice> {
   List<SupplierPriceDO> listByCondition(Long projectId, String name, Integer status, String licensePlate);

   PageVO page(Long projectId, String name, Integer status, Integer pageNumber, Integer pageSize);

   List<AppSupplierPersonalDO> getSupplierAndLicensePlate(Long projectId);

   List<MesBuildingSupplierPrice> getSupplierPriceList(Integer year, Long branchCompanyId);
}
