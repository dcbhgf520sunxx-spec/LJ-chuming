package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClassification;
import org.apache.ibatis.annotations.Param;

public interface MesArtifactClassificationMapper extends BaseMapper<MesArtifactClassification> {
   Boolean hasIdBeenUsed(@Param("id") Long id);
}
