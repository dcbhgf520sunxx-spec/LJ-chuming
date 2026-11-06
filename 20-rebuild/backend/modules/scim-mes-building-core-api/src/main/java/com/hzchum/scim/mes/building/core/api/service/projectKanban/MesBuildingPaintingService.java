package com.hzchum.scim.mes.building.core.api.service.projectKanban;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.PaintingDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.projectKanban.MesBuildingPainting;
import java.util.List;

public interface MesBuildingPaintingService extends IService<MesBuildingPainting> {
   List<PaintingDO> paintingList(Long projectId, Long monomerId, Integer paintingType);
}
