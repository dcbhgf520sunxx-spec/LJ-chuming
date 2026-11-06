package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.plan.core.api.pojo.vo.ProjectManagePlanMonomerVO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectProductInstallSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSupplierAccountDTO;
import com.hzchum.scim.project.core.api.pojo.dto.plan.ProjectMonomerDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectInstallPlanDTOParam;
import java.util.List;

public interface ProjectSubcontractManageBiz {
   ListVO<ProjectMonomerDTO> listInstallPlan(Long projectId, Long monomerId);

   ListVO<ProjectManagePlanMonomerVO> listInstallPlanV4(Long projectId, Long monomerId);

   Boolean setInstallPlan(ProjectInstallPlanDTOParam param);

   Boolean setInstallPlanV2(ProjectInstallPlanDTOParam param);

   List<ProjectSupplierAccountDTO> listInstallSupplier(Long projectId, Long monomerId);

   List<ProjectProductInstallSummaryDTO> listProductInstallSummary(Long projectId, Long monomerId, Integer monomerDetailType, Long areaId, Long supplierId);

   List<SupplierInfo> getInstallOrderSupplierInfoList(Long projectId);
}
