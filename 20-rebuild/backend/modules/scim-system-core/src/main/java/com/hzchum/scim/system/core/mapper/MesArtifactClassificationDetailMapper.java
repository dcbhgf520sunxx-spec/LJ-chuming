package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClassificationDetail;
import org.apache.ibatis.annotations.Param;

public interface MesArtifactClassificationDetailMapper extends BaseMapper<MesArtifactClassificationDetail> {
   int deleteByArtifactClassificationId(@Param("artifactClassificationId") Long artifactClassificationId);
}
