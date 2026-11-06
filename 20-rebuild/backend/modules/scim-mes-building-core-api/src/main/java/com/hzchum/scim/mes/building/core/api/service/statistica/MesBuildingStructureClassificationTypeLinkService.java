package com.hzchum.scim.mes.building.core.api.service.statistica;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingStructureClassificationTypeLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingStructureClassificationTypeLinkDTO;
import java.util.List;
import java.util.Set;

public interface MesBuildingStructureClassificationTypeLinkService extends IService<MesBuildingStructureClassificationTypeLink> {
   ListVO getArtifactRivetWeldConfig(Long id);

   Boolean saveRivetWeldConfig(List<MesBuildingStructureClassificationTypeLinkDTO> linkDTOS);

   Boolean updateRivetWeldConfig(MesBuildingStructureClassificationTypeLinkDTO linkDTO);

   Boolean removeRivetWeldConfig(Set<Long> ids);
}
