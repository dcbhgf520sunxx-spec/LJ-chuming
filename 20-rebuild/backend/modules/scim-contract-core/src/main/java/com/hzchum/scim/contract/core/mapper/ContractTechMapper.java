package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractTech;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanTechDto;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractTechMapper extends BaseMapper<ContractTech> {
   List<EnclosurePlanTechDto> findByProjectId(@Param("projectId") Long projectId);
}
