package com.hzchum.scim.mes.building.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesWorkShopProctionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWorkshopDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingWorkshopMapper extends BaseMapper<MesBuildingWorkshop> {
   List<NameInfo> listWorkShopUser(@Param("factoryId") Long factoryId, @Param("currentUserId") Long currentUserId, @Param("type") Integer type);

   MesBuildingWorkshop getWorkshopById(@Param("workshopId") Long workshopId);

   List<MesWorkShopProctionLineDTO> listShopLineLink(@Param("dtoParam") MesBuildingWorkshopDTOParam dtoParam, @Param("type") Integer type);
}
