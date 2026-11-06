package com.hzchum.scim.mes.enclosure.core.mapper.cargoList;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.AppSupplierPersonalDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.SupplierPriceDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureSupplierPrice;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesEnclosureSupplierPriceMapper extends BaseMapper<MesEnclosureSupplierPrice> {
   List<SupplierPriceDO> listByCondition(
      @Param("projectIds") List<Long> projectIds, @Param("name") String name, @Param("status") Integer status, @Param("licensePlate") String licensePlate
   );

   List<AppSupplierPersonalDO> getSupplierAndLicensePlate(@Param("projectId") Long projectId);
}
