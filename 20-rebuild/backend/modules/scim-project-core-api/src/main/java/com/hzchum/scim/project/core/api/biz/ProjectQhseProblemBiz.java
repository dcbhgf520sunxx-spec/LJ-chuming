package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemDTOV2;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemSumInfo;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemSumInfoV2;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.QhseProblemQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.QhseProblemQueryDTOParamV2;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseProblemDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseProblemDTOParamV2;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ProjectQhseProblemBiz {
   PageVO<ProjectQhseProblemDTO> pageList(QhseProblemQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectQhseProblemDTOV2> pageAppListManage(QhseProblemQueryDTOParamV2 param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectQhseProblemDTOV2> pageAppListManageHistory(Long projectId, Integer pageNumber, Integer pageSize);

   PageVO<ProjectQhseProblemDTOV2> pageListV2(QhseProblemQueryDTOParamV2 param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectQhseProblemDTOV2> pageAppListLabor(QhseProblemQueryDTOParamV2 param, Integer pageNumber, Integer pageSize);

   ProjectQhseProblemDTOV2 getByIdV2(Long id);

   ProjectQhseProblemDTO getById(Long id);

   Boolean printQhseProblem(Long id, HttpServletResponse response);

   Boolean saveQhseProblem(ProjectQhseProblemDTOParam param);

   Boolean saveQhseProblemV2(ProjectQhseProblemDTOParamV2 param);

   Boolean updateQhseProblem(ProjectQhseProblemDTOParam param);

   Boolean delete(List<Long> ids);

   Boolean closeProblem(Long id);

   ProjectQhseProblemSumInfo getSumInfo(Long projectId, Long supplierId);

   ProjectQhseProblemSumInfoV2 getSumInfoV2();

   PageVO<ProjectQhseProblemDTO> listByCondition(Long projectId, Long problemTypeId, Boolean boolChangeStatus, Integer pageNumber, Integer pageSize);

   void downloadProblemV2(Long id);
}
