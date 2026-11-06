package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReject;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectRejectDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectRejectDetailDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectRejectDetailQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectRejectQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectRejectProductDTOParam;
import java.util.List;
import java.util.Map;

public interface ProjectRejectService extends IService<ProjectReject> {
   Boolean saveProjectReject(Long projectId, List<ProjectRejectProductDTOParam> paramList);

   PageVO<ProjectRejectDTO> getProjectRejectPage(ProjectRejectQueryDTOParam param, Integer pageNumber, Integer pageSize);

   Boolean check(WmsApproveOpinionDTOParam param);

   ProjectRejectDTO getDetail(Long rejectId, Integer productType);

   PageVO<ProjectRejectDetailDTO> getProjectRejectDetailPage(ProjectRejectDetailQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> getProjectRejectDetailPrint(ProjectRejectDetailQueryDTOParam param);
}
