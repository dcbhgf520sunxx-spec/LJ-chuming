package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectAuxiliaryMaterialClassDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.AuxiliaryMaterialClassUpdateDtoParam;
import java.util.List;

public interface ProjectAuxiliaryMaterialClassBiz {
   PageVO<ProjectAuxiliaryMaterialClassDTO> list(Long projectId, String classifyName, Integer pageNumber, Integer pageSize);

   Boolean updateInstallReportMode(List<AuxiliaryMaterialClassUpdateDtoParam> paramList);
}
