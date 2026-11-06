package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallSummary;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectInstallMeteDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallBoardQueryDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectInstallSummaryMapper extends BaseMapper<ProjectInstallSummary> {
   ProjectInstallMeteDO selectActualInstallMete(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("productType") Integer productType,
      @Param("category") Integer category
   );

   List<ProjectInstallBoardDTO> selectInstallBoard(InstallBoardQueryDTOParam param);

   List<ProjectInstallBoardDTO> selectInstallBoardV2(InstallBoardQueryDTOParam param);
}
