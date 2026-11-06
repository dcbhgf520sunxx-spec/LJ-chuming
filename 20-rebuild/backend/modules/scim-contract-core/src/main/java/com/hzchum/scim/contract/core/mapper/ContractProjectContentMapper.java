package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectContentDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractProjectContentMapper extends BaseMapper<ContractProjectContent> {
   List<String> selectProjectContentNameList(@Param("projectId") Long projectId);

   List<Integer> selectNoList(@Param("projectId") Long projectId);

   List<ProjectContentDTO> selectProjectContent(@Param("projectId") Long projectId);
}
