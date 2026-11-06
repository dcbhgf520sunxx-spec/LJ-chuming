package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectQhseProblemDO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.QhseProblemQueryDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectQhseProblemMapper extends BaseMapper<ProjectQhseProblem> {
   List<ProjectQhseProblemDO> selectQhseProblemList(QhseProblemQueryDTOParam param);

   List<ProjectQhseProblem> selectByCondition(
      @Param("projectId") Long projectId,
      @Param("supplierId") Long supplierId,
      @Param("problemTypeId") Long problemTypeId,
      @Param("boolChangeStatus") Boolean boolChangeStatus
   );

   int countNumber(@Param("projectId") Long projectId);
}
