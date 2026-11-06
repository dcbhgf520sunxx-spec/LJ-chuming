package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ModifyAndAddAndDeleteParm;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerSimpleDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerUpdateDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectTreeResponseVO;
import java.util.List;
import java.util.Map;

public interface PlanMonomerBiz {
   PageVO<PlanMonomerDTO> pageListMonomer(Long projectId, String name, Integer pageNumber, Integer pageSize);

   Boolean saveMonomer(PlanMonomerSaveDTOParam dtoParam);

   Boolean updateMonomer(PlanMonomerUpdateDTOParam dtoParam);

   Boolean removeMonomer(List<Long> ids);

   PlanMonomerSimpleDTO getMonomerSimpleById(Long monomerId);

   ListVO<ProjectTreeResponseVO> listProjectTreeResponseVO(
      Integer status,
      Integer settlementStatus,
      Integer projectType,
      Boolean ifUserRelated,
      Integer lumpSumSystemType,
      Integer level,
      Integer productType,
      Boolean hasTask,
      Boolean hasInspectTask
   );

   ListVO<Map<String, Object>> listMonomerSimpleByProjectId(Long projectId, Long monomerId, Integer productType);

   ProjectPlanDetailDTO enclosureMonomerAreaByProjectId(Long projectId);

   List<Map<String, Object>> listSimpleByProjectId(Long projectId);

   ListVO<PlanMonomerDTO> getMonomerAndAreaByProjectId(Long projectId);

   boolean modifyAndAddAndDelete(ModifyAndAddAndDeleteParm modifyAndAddAndDeleteParm);
}
