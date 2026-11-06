package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactSpecAmend;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecAmendDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactSpecUncorrectedDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechArtifactSpecAmendMapper extends BaseMapper<TechArtifactSpecAmend> {
   List<TechArtifactSpecAmendDTO> selectListByCondition(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("oldSpecification") String oldSpecification,
      @Param("newSpecification") String newSpecification,
      @Param("specification") String specification,
      @Param("boolAmendStatus") Boolean boolAmendStatus
   );

   List<TechArtifactSpecUncorrectedDTO> uncorrectedList(
      @Param("inventoryOperationId") Long inventoryOperationId,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("maxLength") Long maxLength,
      @Param("minLength") Long minLength,
      @Param("structureClassId") Long structureClassId
   );
}
