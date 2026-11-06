package com.hzchum.scim.mes.building.core.api.biz.scheduling;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.cut.core.api.pojo._do.NestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingNestCutPlateDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingNestCutPlateBindingLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingNestCutPlateDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingNestCutPlateBiz extends IBiz<MesBuildingNestCutPlate> {
   Boolean saveMesBuildingNestCutPlate(NestCutPlate nestCutPlate);

   Boolean bindingSteelPlate(MesBuildingNestCutPlateDTOParam dtoParam);

   List<MesBuildingMachineTaskOrderDTO> getAllnetCut(
      Integer boolNestCut,
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      String serialNumber,
      Integer processType,
      List<Long> processIds,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String cutNumber,
      Long cutConfigId
   );

   Boolean savePlateBinding(Long nestCutPlateId, String barcode);

   List<MesBuildingNestCutPlateBindingLink> getPlateBindingLinkList(Long nestCutPlateId);

   List<MesBuildingNestCutPlateDO> getMachinePartTaskIssuedDetails(Long id);

   Boolean deletePlateBinding(List<Long> bindingIds);
}
