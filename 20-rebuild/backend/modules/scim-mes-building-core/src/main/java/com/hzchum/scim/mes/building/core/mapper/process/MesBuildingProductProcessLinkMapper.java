package com.hzchum.scim.mes.building.core.mapper.process;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProductProcessLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingProductProcessLinkMapper extends BaseMapper<MesBuildingProductProcessLink> {
   List<MesBuildingProductProcessLinkDO> getProcessListByTypeIdAndProductType(@Param("id") Long id, @Param("productType") Integer productType);

   List<MesBuildingProductProcessLinkDTO> findProcessLinkByLineAndClass(
      @Param("prodLineId") Long prodLineId, @Param("classId") Long classId, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   Integer isExistProductProcessLink(@Param("productId") Long productId, @Param("productType") Integer productType);
}
