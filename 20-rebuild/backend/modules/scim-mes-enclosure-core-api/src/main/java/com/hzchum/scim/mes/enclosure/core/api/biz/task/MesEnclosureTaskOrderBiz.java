package com.hzchum.scim.mes.enclosure.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTaskOrder;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.MesEnclosureTaskOrderDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.TechEnclosureDetailDTO;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface MesEnclosureTaskOrderBiz extends IBiz<MesEnclosureTaskOrder> {
   List<ProjectInfo> getProjectWithOrder(Integer year, String name, Integer projectType, Integer lumpSumSystemType);

   PageVO<MesEnclosureTaskOrderDTO> getOrders(String orderNumber, Long projectId, String userName, Integer pageNumber, Integer pageSize);

   PageVO<TechEnclosureDetailDTO> orderDetail(Long id);

   PageVO<TechEnclosureDetailDTO> orderDetail(Long id, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> orderDetailPrint(Long id);

   Boolean orderDetailDownload(Long id, HttpServletResponse response);

   Boolean savePrint(Long id);

   Boolean deleteOrder(List<Long> ids);
}
