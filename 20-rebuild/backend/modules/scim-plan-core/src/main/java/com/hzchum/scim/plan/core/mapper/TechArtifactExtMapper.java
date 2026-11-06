package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechArtifactExtMapper extends BaseMapper<TechArtifactExt> {
   List<TechArtifactExt> listArtifact(@Param("NumberInfos") List<NumberInfoDTO> NumberInfos);

   List<TechArtifactExt> listAllArtifactExt(@Param("monomerId") Long monomerId, @Param("serialNumberList") List<String> serialNumberList);
}
