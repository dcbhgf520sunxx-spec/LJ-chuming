package com.hzchum.scim.mes.enclosure.core.api.service.cargoList;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.AppSupplierPersonalDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.SupplierPriceDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureSupplierPrice;
import java.util.List;

public interface MesEnclosureSupplierPriceService extends IService<MesEnclosureSupplierPrice> {
   List<SupplierPriceDO> listByCondition(Long projectId, String name, Integer status, String licensePlate);

   PageVO page(Long projectId, String name, Integer status, Integer pageNumber, Integer pageSize);

   List<AppSupplierPersonalDO> getSupplierAndLicensePlate(Long projectId);
}
