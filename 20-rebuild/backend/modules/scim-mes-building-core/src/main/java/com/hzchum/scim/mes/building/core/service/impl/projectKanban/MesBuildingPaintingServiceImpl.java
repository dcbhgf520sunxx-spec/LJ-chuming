package com.hzchum.scim.mes.building.core.service.impl.projectKanban;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.PaintingDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.projectKanban.MesBuildingPainting;
import com.hzchum.scim.mes.building.core.api.service.projectKanban.MesBuildingPaintingService;
import com.hzchum.scim.mes.building.core.mapper.projectKanban.MesBuildingPaintingMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingPaintingServiceImpl extends ServiceImpl<MesBuildingPaintingMapper, MesBuildingPainting> implements MesBuildingPaintingService {
   @Resource
   private MesBuildingPaintingMapper paintingMapper;

   @Override
   public List<PaintingDO> paintingList(Long projectId, Long monomerId, Integer paintingType) {
      return this.paintingMapper.paintingList(projectId, monomerId, paintingType);
   }
}
