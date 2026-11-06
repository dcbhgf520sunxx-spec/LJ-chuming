package com.hzchum.scim.mes.building.core.mapper.statistica;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.statistica.MesBuildingStructureClassificationTypeLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingStructureClassificationTypeLink;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MesBuildingStructureClassificationTypeLinkMapper extends BaseMapper<MesBuildingStructureClassificationTypeLink> {
   List<MesBuildingStructureClassificationTypeLinkDO> getArtifactRivetWeldConfig(Long id);
}
