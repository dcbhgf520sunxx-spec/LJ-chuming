package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactAuxiliaryLink;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactAuxiliaryLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechArtifactAuxiliaryLinkMapper extends BaseMapper<TechArtifactAuxiliaryLink> {
   List<TechArtifactAuxiliaryLinkDTO> listByCondition(
      @Param("artifactIdList") List<Long> artifactIdList, @Param("auxiliaryPartNameList") List<String> auxiliaryPartNameList
   );
}
