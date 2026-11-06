package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ProjectPlanDetailSaveParam;
import java.util.List;
import java.util.Map;

public interface ProjectPlanBiz {
   PageVO<ProjectPlanDTO> page(Integer year, String projectNoOrName, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<ProjectPlanDTO> enclosurePlanPage(Integer year, String projectNoOrName, Integer pageNumber, Integer pageSize);

   Map<String, Object> countInfo(Integer year, String projectNoOrName);

   ProjectPlanDetailDTO DetailByProjectId(Long projectId);

   Boolean detailBatchSave(ProjectPlanDetailSaveParam param);
}
