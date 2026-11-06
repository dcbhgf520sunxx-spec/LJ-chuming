package com.hzchum.scim.mes.building.core.api.service.statistica;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingAssembleRiveWeldLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingAssembleLinkDTO;
import java.util.List;
import java.util.Set;

public interface MesBuildingAssembleRiveWeldLinkService extends IService<MesBuildingAssembleRiveWeldLink> {
   ListVO getAssembleRivetWeldConfig();

   Boolean saveAssembleRivetWeldConfig(List<MesBuildingAssembleLinkDTO> dtoList);

   Boolean updateAssembleRivetWeldConfig(MesBuildingAssembleLinkDTO dto);

   Boolean removeAssembleRivetWeldConfig(Set<Long> ids);
}
