package com.hzchum.scim.mes.building.core.mapper.statistica;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.statistica.MesBuildingAssembleLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingAssembleRiveWeldLink;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MesBuildingAssembleRiveWeldLinkMapper extends BaseMapper<MesBuildingAssembleRiveWeldLink> {
   List<MesBuildingAssembleLinkDO> getAssembleRivetWeldConfig();
}
