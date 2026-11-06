package com.hzchum.scim.mes.building.core.api.service.wages;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingTechArtifactAuxiliaryPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.StudSleeveDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingTechArtifactAuxiliaryPriceService extends IService<MesBuildingTechArtifactAuxiliaryPrice> {
   List<StudSleeveDTO> studSleeveList(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer auxiliaryTypeEnum);
}
