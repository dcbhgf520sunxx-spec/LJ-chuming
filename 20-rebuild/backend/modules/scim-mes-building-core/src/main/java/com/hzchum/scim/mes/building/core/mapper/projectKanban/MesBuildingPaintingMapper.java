package com.hzchum.scim.mes.building.core.mapper.projectKanban;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.PaintingDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.projectKanban.MesBuildingPainting;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingPaintingMapper extends BaseMapper<MesBuildingPainting> {
   List<PaintingDO> paintingList(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("paintingType") Integer paintingType);
}
