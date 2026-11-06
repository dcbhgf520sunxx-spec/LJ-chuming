package com.hzchum.scim.mes.building.core.api.service.statistica;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingArtifactTypeConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingArtifactTypeConfigDTO;
import java.util.Set;

public interface MesBuildingArtifactTypeConfigService extends IService<MesBuildingArtifactTypeConfig> {
   ListVO getArtifactTypeConfig();

   Boolean setArtifactTypeConfig(MesBuildingArtifactTypeConfigDTO dto);

   Boolean updateArtifactTypeConfig(MesBuildingArtifactTypeConfigDTO dto);

   Boolean removeArtifactTypeConfig(Set<Long> ids);
}
