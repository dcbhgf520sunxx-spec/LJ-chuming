package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryMaterial;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialClassDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialPrintDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartPrintDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechAuxiliaryMaterialMapper extends BaseMapper<TechAuxiliaryMaterial> {
   List<TechStandardPartPrintDTO> listAuxiliaryMaterialPrint(AuxiliaryMaterialPrintDTOParam param);

   List<AuxiliaryMaterialClassDTO> selectClassByProjectId(@Param("projectId") Long projectId);
}
