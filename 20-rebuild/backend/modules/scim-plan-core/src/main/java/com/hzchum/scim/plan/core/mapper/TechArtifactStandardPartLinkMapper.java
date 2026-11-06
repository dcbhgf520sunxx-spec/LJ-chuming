package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactStandardPartLink;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactStandardPartLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechArtifactStandardPartLinkMapper extends BaseMapper<TechArtifactStandardPartLink> {
   List<TechArtifactStandardPartLinkDTO> listByCondition(@Param("artifactIdList") List<Long> artifactIdList, @Param("nameList") List<String> nameList);
}
