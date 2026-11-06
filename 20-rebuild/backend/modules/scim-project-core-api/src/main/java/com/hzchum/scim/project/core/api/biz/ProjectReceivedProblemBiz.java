package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivedProblem;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedProblemDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivedProblemDetailsDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.put.ProjectReceivedProblemPutDTOParam;

public interface ProjectReceivedProblemBiz extends IBiz<ProjectReceivedProblem> {
   PageVO<ProjectReceivedProblemDTO> getProblemPage(Long projectId, Long supplierId, Integer pageNumber, Integer pageSize);

   ProjectReceivedProblemDetailsDTO getProblemDetails(Long problemId);

   boolean closeProblem(ProjectReceivedProblemPutDTOParam param);
}
