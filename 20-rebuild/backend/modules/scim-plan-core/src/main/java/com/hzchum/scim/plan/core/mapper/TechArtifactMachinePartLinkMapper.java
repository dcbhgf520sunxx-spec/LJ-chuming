package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.ArtifactAssociationCount;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TechArtifactMachinePartLinkMapper extends BaseMapper<TechArtifactMachinePartLink> {
   List<TechArtifactDTO> selectArtifactPartByConditions(
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("machinePartSerialNumber") String machinePartSerialNumber,
      @Param("userId") Long userId,
      @Param("assembleSerialNumber") String assembleSerialNumber,
      @Param("permissionCheck") Integer permissionCheck,
      @Param("dateTimeList") List<LocalDateTime> dateTimeList,
      @Param("userName") String userName
   );

   List<ArtifactAssociationCount> getArtifactPartConvertCounts(@Param("artifactId") List<Long> artifactId);
}
