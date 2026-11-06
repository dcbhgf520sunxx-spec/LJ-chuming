package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTypeSettingMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleTypesettingPartLink;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechAssembleTypesettingPartLinkMapper extends BaseMapper<TechAssembleTypesettingPartLink> {
   List<MesBuildingTypeSettingMachinePartDTO> listByTypeSettingId(@Param("ids") List<Long> ids);
}
