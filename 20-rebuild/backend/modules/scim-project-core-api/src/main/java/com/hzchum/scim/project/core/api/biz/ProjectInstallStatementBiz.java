package com.hzchum.scim.project.core.api.biz;

import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallStatementDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallSumDTO;
import java.util.List;
import java.util.Map;

public interface ProjectInstallStatementBiz {
   List<ProjectInstallStatementDTO> listInstallStatement(Long projectId, Integer projectType, Integer productType, Integer year, Integer month);

   List<ProjectInstallSumDTO> getInstallSum(Long monomerId);

   List<Map<String, Object>> listInstallPlan(Long projectId);

   Map<String, Number> getMyTaskQuantity();
}
