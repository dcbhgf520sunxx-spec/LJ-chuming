package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanDetailUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.ProjectManagePlanMonomerVO;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface PlanDetailBiz {
   ListVO<PlanMonomerDTO> listDetailsByConditions(Long projectId, Long monomerId);

   void exportPlanDetails(Long monomerId, Integer productType, HttpServletResponse response);

   Boolean updatePlanDetail(PlanDetailUpdateDTOParam updateDTOParam);

   Boolean editPlanDetailList(Long areaId, List<PlanDetailUpdateDTOParam> paramList);

   PrintVO printOverallPlan(Long monomerId, Integer productType, Integer type);

   ListVO<PlanMonomerDTO> listDetailsByCondition(Long projectId, Long monomerId);

   List<ProjectManagePlanMonomerVO> listDetailsByConditionV4(Long projectId, Long monomerId);

   PrintVO<List<Map<String, Object>>> areaArtifactDetailsPrint(Long areaId);

   PageVO<ProjectProductDTO> getAreaArtifactOneCodeCompleteDetails(Long areaId, Long processId, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> areaArtifactOneCodeCompleteDetailsPrint(Long areaId, Long processId);

   ArtifactSumDTO getAreaArtifactOneCodeCompleteSummary(Long areaId, Long processId);

   List<NameInfo> getAreaArtifactOneCodeCompleteProcessList(Long areaId);

   List<NameInfo> getEnclosureCompleteProcessList(Long areaId);

   PageVO<ProjectProductDTO> getEnclosureCompleteDetails(Long areaId, Long processId, Integer pageNumber, Integer pageSize);

   ArtifactSumDTO getEnclosureCompleteSummary(Long areaId, Long processId);

   PrintVO<List<Map<String, Object>>> getEnclosureCompleteDetailsPrint(Long areaId, Long processId);

   PrintVO<List<Map<String, Object>>> areaEnclosureDetailsPrint(Long areaId);
}
