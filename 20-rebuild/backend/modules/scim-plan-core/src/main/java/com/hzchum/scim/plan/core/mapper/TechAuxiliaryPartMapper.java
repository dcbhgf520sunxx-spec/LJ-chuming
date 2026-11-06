package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryPart;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechAuxiliaryPartQueryDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechAuxiliaryPartMapper extends BaseMapper<TechAuxiliaryPart> {
   List<TechAuxiliaryPartDTO> selectAuxiliaryPartList(TechAuxiliaryPartQueryDTOParam param);

   List<TechAuxiliaryPartSummaryDTO> selectAuxiliaryPartSummary(
      @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId
   );
}
