package com.hzchum.scim.mes.building.core.service.impl.wages;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingTechArtifactAuxiliaryPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.StudSleeveDTO;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingTechArtifactAuxiliaryPriceService;
import com.hzchum.scim.mes.building.core.mapper.wages.MesBuildingTechArtifactAuxiliaryPriceMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTechArtifactAuxiliaryPriceServiceImpl
   extends ServiceImpl<MesBuildingTechArtifactAuxiliaryPriceMapper, MesBuildingTechArtifactAuxiliaryPrice>
   implements MesBuildingTechArtifactAuxiliaryPriceService {
   @Override
   public List<StudSleeveDTO> studSleeveList(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer auxiliaryTypeEnum) {
      return this.baseMapper.studSleeveList(projectId, startDate, endDate, auxiliaryTypeEnum);
   }
}
