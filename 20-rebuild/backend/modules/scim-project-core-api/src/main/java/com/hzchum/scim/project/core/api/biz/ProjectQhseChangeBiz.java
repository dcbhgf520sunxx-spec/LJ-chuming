package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseChangeDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseChangeAuditDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseChangeSaveDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseChangeUpdateDTOParam;

public interface ProjectQhseChangeBiz {
   PageVO<ProjectQhseChangeDTO> listProblemChange(Long problemId, Integer auditStatus, Integer pageNumber, Integer pageSize);

   Boolean saveChange(ProjectQhseChangeSaveDTOParam param);

   Boolean saveChangeV2(ProjectQhseChangeSaveDTOParam param);

   Boolean updateChange(ProjectQhseChangeUpdateDTOParam param);

   Boolean checkChange(ProjectQhseChangeAuditDTOParam param);

   Boolean checkChangeV2(ProjectQhseChangeAuditDTOParam param);

   Boolean delete(Long id);
}
