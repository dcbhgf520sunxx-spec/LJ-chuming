package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactProcessFile;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactProcessFileDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileQueryDTOParam;
import java.util.List;

public interface TechArtifactProcessFileMapper extends BaseMapper<TechArtifactProcessFile> {
   List<TechArtifactProcessFileDTO> selectByCondition(TechArtifactProcessFileQueryDTOParam param);
}
