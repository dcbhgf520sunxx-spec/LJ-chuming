package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubVisaDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubVisaSumInfo;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectSubVisaQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectSubVisaCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectSubVisaDTOParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ProjectSubVisaBiz {
   Boolean delVisaReason(List<Long> ids);

   PageVO<ProjectSubVisaDTO> list(ProjectSubVisaQueryDTOParam param, Integer pageNumber, Integer pageSize);

   ProjectSubVisaDTO getById(Long id);

   Boolean exportSubVisa(Long id, HttpServletResponse response);

   Boolean save(ProjectSubVisaDTOParam param);

   Boolean update(ProjectSubVisaDTOParam param);

   Boolean delete(List<Long> ids);

   Boolean checkSubVisa(ProjectSubVisaCheckDTOParam param);

   ProjectSubVisaSumInfo getSumInfo(Long projectId);
}
