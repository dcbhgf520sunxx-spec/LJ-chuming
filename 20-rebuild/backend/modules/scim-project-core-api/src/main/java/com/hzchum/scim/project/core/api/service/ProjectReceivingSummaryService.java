package com.hzchum.scim.project.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallReport;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingRecord;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingSummary;
import com.hzchum.scim.project.core.api.pojo.daoParam.ReceivingBoardQueryDOParam;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingInstallDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingMeteDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectBaseQueryDTOParam;
import java.math.BigDecimal;
import java.util.List;

public interface ProjectReceivingSummaryService extends IService<ProjectReceivingSummary> {
   Boolean updateReceivingSummary(ProjectReceivingRecord record);

   Boolean reduceMete(ProjectReceivingRecord record);

   Boolean updateRawMaterialReceivingSummary(ProjectReceivingRecord record);

   ProjectReceivingMeteDTO getReceivingMete(Integer projectType, Integer productType, Long productId);

   ProjectReceivingMeteDTO getReceivingMete(Long projectId, Long monomerId, Long areaId, Integer productType, Integer category);

   BigDecimal getReceivingQuantity(List<Long> areaIds);

   List<ProjectReceivingBoardDTO> listReceivingBoard(ReceivingBoardQueryDOParam param);

   List<ProjectReceivingInstallDTO> listReceivingInstall(ProjectBaseQueryDTOParam dtoParam);

   List<ProjectReceivingInstallDTO> listReceivingInstallV2(ProjectBaseQueryDTOParam dtoParam);

   List<ProjectReceivingInstallDTO> getListMethodReceivingInstall(ProjectBaseQueryDTOParam doParam);

   Boolean updateInstallQuantity(ProjectInstallReport report);
}
