package com.hzchum.scim.mes.building.core.api.service.process;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProductProcessLinkDTO;
import java.util.List;

public interface MesBuildingProductProcessLinkService extends IService<MesBuildingProductProcessLink> {
   boolean checkProductProcessLinkAndInsert(List<MesBuildingProductProcessLink> mesBuildingProductProcessLinkList);

   List<MesBuildingProductProcessLinkDO> getProcessListByTypeIdAndProductType(Long id, Integer productType);

   List<MesBuildingProductProcessLinkDTO> findProcessLinkByLineAndClass(Long prodLineId, Long classId, Integer taskTypeEnum);

   Integer isExistProductProcessLink(Long productId, Integer productType);
}
