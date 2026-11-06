package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactProcessFile;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactProcessFileDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileQueryDTOParam;
import java.util.List;

public interface TechArtifactProcessFileService extends IService<TechArtifactProcessFile> {
   List<TechArtifactProcessFileDTO> listByCondition(TechArtifactProcessFileQueryDTOParam param);
}
