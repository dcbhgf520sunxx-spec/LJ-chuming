package com.hzchum.scim.mes.building.core.mapper.cargoList;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.AppSupplierPersonalDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.SupplierPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingSupplierPrice;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingSupplierPriceMapper extends BaseMapper<MesBuildingSupplierPrice> {
   List<SupplierPriceDO> listByCondition(
      @Param("projectIds") List<Long> projectIds, @Param("name") String name, @Param("status") Integer status, @Param("licensePlate") String licensePlate
   );

   List<AppSupplierPersonalDO> getSupplierAndLicensePlate(@Param("projectId") Long projectId);

   List<MesBuildingSupplierPrice> getSupplierPriceList(Integer year, Long branchCompanyId);
}
