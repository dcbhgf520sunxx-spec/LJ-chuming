package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectLaborSubsupplierOrder;
import com.hzchum.scim.project.core.api.pojo.dto.sub.ProjectLaborOrderDTO;
import com.hzchum.scim.project.core.api.pojo.dto.sub.ProjectLaborProductDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.ProjectLaborOrderDTOParam;
import java.util.List;
import java.util.Map;

public interface ProjectLaborSubsupplierOrderBiz extends IBiz<ProjectLaborSubsupplierOrder> {
   PageVO<ProjectLaborProductDTO> getCanSubSupplierProductPage(
      Integer productType, Long areaId, String name, String serialNumber, Integer pageNumber, Integer pageSize
   );

   boolean saveSupplierOrder(ProjectLaborOrderDTOParam dtoParam);

   List<ProjectLaborOrderDTO> getLaborOrderList(Long projectId);

   PageVO<ProjectLaborProductDTO> getLaborOrderDetailsPage(Long projectId, Long orderId, String name, String serialNumber, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> getLaborOrderDetailsPrint(Long projectId, Long orderId, String name, String serialNumber);

   boolean delete(List<Long> ids);
}
