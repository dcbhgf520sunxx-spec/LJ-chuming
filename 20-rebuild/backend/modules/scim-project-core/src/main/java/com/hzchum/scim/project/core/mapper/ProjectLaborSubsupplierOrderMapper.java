package com.hzchum.scim.project.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._do.ProjectLaborSubsupplierOrder;
import com.hzchum.scim.project.core.api.pojo.dto.sub.ProjectLaborOrderDTO;
import com.hzchum.scim.project.core.api.pojo.dto.sub.ProjectLaborProductDTO;
import java.util.List;

public interface ProjectLaborSubsupplierOrderMapper extends BaseMapper<ProjectLaborSubsupplierOrder> {
   List<ProjectLaborProductDTO> getCanSubSupplierProductList(Integer productType, Long areaId, String name, String serialNumber);

   Integer getProjectOrderCount(Long projectId);

   List<ProjectLaborOrderDTO> getLaborOrderList(Long projectId);
}
