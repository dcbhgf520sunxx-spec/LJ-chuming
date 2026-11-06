package com.hzchum.scim.mes.building.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingFactoryMapper extends BaseMapper<MesBuildingFactory> {
   List<NameInfo> listFactoryUser(Long currentUserId);

   MesBuildingFactory getFactoryById(@Param("factoryId") Long factoryId);
}
