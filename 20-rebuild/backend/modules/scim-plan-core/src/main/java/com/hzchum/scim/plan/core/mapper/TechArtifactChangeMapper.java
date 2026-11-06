package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactChange;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactChangeQueryDtoParam;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechArtifactChangeMapper extends BaseMapper<TechArtifactChange> {
   List<TechArtifactChangeDTO> selectByCondition(TechArtifactChangeQueryDtoParam param);

   List<TechArtifactChangeDTO> warehousingListByCondition(TechArtifactChangeQueryDtoParam param);

   List<TechArtifactChange> listNewChanges(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );
}
