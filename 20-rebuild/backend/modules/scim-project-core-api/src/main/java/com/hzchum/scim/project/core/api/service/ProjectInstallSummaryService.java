package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallReport;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallSummary;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectInstallMeteDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallBoardQueryDTOParam;
import java.math.BigDecimal;
import java.util.List;

public interface ProjectInstallSummaryService extends IService<ProjectInstallSummary> {
   ProjectInstallMeteDO getActualInstallMete(Long projectId, Long monomerId, Long areaId, Integer productType, Integer category);

   BigDecimal getActualInstallQuantity(List<Long> areaIds);

   BigDecimal getActualInstallQuantity(Integer projectType, Integer productType, Long productId);

   Boolean saveInstallSummary(ProjectInstallReport installReport);

   List<ProjectInstallBoardDTO> listInstallBoard(InstallBoardQueryDTOParam param);

   List<ProjectInstallBoardDTO> listInstallBoardV2(InstallBoardQueryDTOParam param);

   List getAreaInstallData(List<Long> areas, Integer productType);
}
