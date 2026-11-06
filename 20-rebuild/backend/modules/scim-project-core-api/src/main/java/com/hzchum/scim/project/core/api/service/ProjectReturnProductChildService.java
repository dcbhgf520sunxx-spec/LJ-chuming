package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductChild;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectReturnProductChildDO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReturnProductQueryDTOParam;
import java.util.List;

public interface ProjectReturnProductChildService extends IService<ProjectReturnProductChild> {
   List<ProjectReturnProductChildDO> projectReturnChildsByTypeArtifact(ProjectReturnProductQueryDTOParam param);

   List<ProjectReturnProductChildDO> projectReturnChildsByTypeEenclosure(ProjectReturnProductQueryDTOParam param);

   List<ProjectReturnProductChildDO> projectReturnChildsByTypeStandardPartArtifact(ProjectReturnProductQueryDTOParam param);

   List<ProjectReturnProductChildDO> projectReturnChildsByTypeStandardPartEenclosure(ProjectReturnProductQueryDTOParam param);
}
