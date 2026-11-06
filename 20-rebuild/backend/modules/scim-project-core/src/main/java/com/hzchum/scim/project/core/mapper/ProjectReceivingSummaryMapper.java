package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingSummary;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectReceivingMeteDO;
import com.hzchum.scim.project.core.api.pojo.daoParam.ReceivingBoardQueryDOParam;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReceivingInstallDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectBaseQueryDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectReceivingSummaryMapper extends BaseMapper<ProjectReceivingSummary> {
   ProjectReceivingMeteDO selectAreaReceivingMete(@Param("areaId") Long areaId);

   ProjectReceivingMeteDO selectReceivingMete(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("productType") Integer productType,
      @Param("category") Integer category
   );

   List<ProjectReceivingBoardDTO> selectReceivingBoard(ReceivingBoardQueryDOParam doParam);

   List<ProjectReceivingInstallDTO> selectReceivingInstall(ProjectBaseQueryDTOParam doParam);

   List<ProjectReceivingInstallDTO> selectReceivingInstallV2(ProjectBaseQueryDTOParam dtoParam);

   List<ProjectReceivingInstallDTO> getListMethodReceivingInstall(ProjectBaseQueryDTOParam doParam);
}
