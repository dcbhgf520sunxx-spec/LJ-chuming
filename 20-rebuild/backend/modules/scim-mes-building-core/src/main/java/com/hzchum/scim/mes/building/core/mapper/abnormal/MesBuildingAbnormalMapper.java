package com.hzchum.scim.mes.building.core.mapper.abnormal;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbnormalPreviewDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbnormalProcessPreviewDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.MesBuildingAbnormalDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.abnormal.MesBuildingAbnormal;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingAbnormalMapper extends BaseMapper<MesBuildingAbnormal> {
   List<MesBuildingAbnormalDO> listByCondition(
      @Param("id") Long id,
      @Param("productType") Integer productType,
      @Param("projectName") String projectName,
      @Param("serialNumber") String serialNumber,
      @Param("status") Integer status,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("date") LocalDateTime date
   );

   MesBuildingAbnormalDO selectDetailById(@Param("id") Long id);

   List<AbnormalProcessPreviewDO> changePreview(@Param("productId") Long productId, @Param("productType") Integer productType);

   List<AbnormalPreviewDO> preview(@Param("productId") Long productId, @Param("productType") Integer productType, @Param("type") Integer type);
}
