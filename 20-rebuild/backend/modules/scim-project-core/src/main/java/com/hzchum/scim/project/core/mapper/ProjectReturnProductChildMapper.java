package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductChild;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectReturnProductChildDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReturnProductChildDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReturnProductChildQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReturnProductQueryDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectReturnProductChildMapper extends BaseMapper<ProjectReturnProductChild> {
   List<ProjectReturnProductChildDO> projectReturnChildsByTypeArtifact(ProjectReturnProductQueryDTOParam param);

   List<ProjectReturnProductChildDO> projectReturnChildsByTypeEenclosure(ProjectReturnProductQueryDTOParam param);

   List<ProjectReturnProductChildDO> projectReturnChildsByTypeStandardPartArtifact(ProjectReturnProductQueryDTOParam param);

   List<ProjectReturnProductChildDO> projectReturnChildsByTypeStandardPartEenclosure(ProjectReturnProductQueryDTOParam param);

   List<ProjectReturnProductChildDTO> listProjectReturnChilds(@Param("id") Long id);

   List<ProjectReturnProductChildDO> getReturnAndWaste(ProjectReturnProductChildQueryDTOParam param);
}
