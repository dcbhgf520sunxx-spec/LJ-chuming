package com.hzchum.scim.business.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.business.core.api.pojo._do.ArtifactSummaryDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import org.apache.ibatis.annotations.Param;

public interface BusinessArtifactMapper extends BaseMapper<BusinessArtifact> {
   ArtifactSummaryDO summary(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId);
}
