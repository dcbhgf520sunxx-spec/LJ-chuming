package com.hzchum.scim.plan.core.api.manager;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanArtifactNoSchedulingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.SubscribeAuxiliaryWarehouseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.SubscribeProductWarehouseDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechProductSubscribeUpdateVORequest;
import java.util.Collection;
import java.util.List;

public interface TechMesWmsManager {
   PageVO<PlanArtifactNoSchedulingDTO> listPageArtifactNoSchedulingByCondition(
      Long projectId,
      Long monomerId,
      Long areaId,
      String name,
      String serialNumber,
      String specification,
      String material,
      Long structureClassId,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   );

   Boolean addSubscribeArtifactQuantity(List<TechProductSubscribeUpdateVORequest> subscribeSaveVORequestList);

   Boolean removeSubscribeArtifactQuantity(List<TechProductSubscribeUpdateVORequest> subscribeSaveVORequestList);

   void addEnclosureSubscribeQuantity(Collection<TechProductSubscribeUpdateVORequest> voRequestList);

   void addEnclosureSubscribeQuantity(TechProductSubscribeUpdateVORequest voRequest);

   void removeEnclosureSubscribeQuantity(Collection<TechProductSubscribeUpdateVORequest> voRequestList);

   void removeEnclosureSubscribeQuantity(TechProductSubscribeUpdateVORequest voRequest);

   void saveSubscribeProductWarehouseEntry(List<SubscribeProductWarehouseDTO> productWarehouseDTOS);

   void saveSubscribeAuxiliaryWarehouseEntry(List<SubscribeAuxiliaryWarehouseDTO> productWarehouseDTOS);
}
