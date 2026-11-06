package com.hzchum.scim.business.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.business.core.api.pojo._do.AuxiliaryMaterialSummaryDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessAuxiliaryMaterial;
import org.apache.ibatis.annotations.Param;

public interface BusinessAuxiliaryMaterialMapper extends BaseMapper<BusinessAuxiliaryMaterial> {
   AuxiliaryMaterialSummaryDO summary(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId);
}
