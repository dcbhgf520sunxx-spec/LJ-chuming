package com.hzchum.scim.mes.building.core.api.service.team;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingMachinePartTeamDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingPartCutConfigWorkShopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingPartCutConfigWorkShopDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingProductDetailDTOParam;
import java.util.List;

public interface MesBuildingMachinePartTeamDetailService extends IService<MesBuildingMachinePartTeamDetail> {
   MesBuildingMachinePartTeamDetailDTO partCutConfigTeamList(Integer partProdMode, Integer processType, Integer deviceType);

   MesBuildingMachinePartTeamDetailDTO partCutConfigTeamListFeature(MesBuildingPartCutConfigWorkShopDTOParam mesBuildingPartCutConfigWorkShopDTOParam);

   List<MesBuildingMachinePartTeamDetailDTO> partCutConfigTeamListCutType(
      Integer partProdMode, Integer processType, Integer partType, Long teamId, Long wokshopId
   );

   List<MesBuildingMachinePartTeamDetailDTO> partCutConfigTeamListCutTypeFeature(
      MesBuildingPartCutConfigWorkShopDTOParam mesBuildingPartCutConfigWorkShopDTOParam
   );

   List<MesBuildingPartCutConfigWorkShopDTO> getNoProcessTeam(MachinePartNestingProductDetailDTOParam machinePartNestingProductDetailDTOParam);
}
