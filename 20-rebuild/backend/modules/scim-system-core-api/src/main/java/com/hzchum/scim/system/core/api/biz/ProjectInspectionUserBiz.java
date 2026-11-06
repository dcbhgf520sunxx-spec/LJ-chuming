package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUser;
import com.hzchum.scim.system.core.api.pojo.dto.safety.ProjectInspectionUserLinkRecordDTO;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionUserDTO;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionLineDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.ProjectLineApplyRemovePointDTOParam;
import java.util.List;

public interface ProjectInspectionUserBiz extends IBiz<ProjectInspectionUser> {
   boolean saveLine(ProjectInspectionLineDTOParam projectInspectionLineDTOParam);

   boolean deleteLine(Long id);

   boolean updateLine(ProjectInspectionLineDTOParam projectInspectionLineDTOParam);

   List<ProjectInspectionUserDTO> getLine();

   ProjectInspectionDetailDTO getLineDetail(Long id);

   List<ProjectInspectionUserDTO> getAllInspectionUser();

   boolean updateLineStatus(Long id);

   boolean updateLineMandatoryInspection(Long id);

   boolean applyRemoveLine(ProjectLineApplyRemovePointDTOParam saveParam);

   PageVO<ProjectInspectionUserLinkRecordDTO> applyRemoveLinePage(Integer pageNumber, Integer pageSize);

   boolean auditResource(Long recordId, Integer auditStatus);

   Integer applyNum();
}
