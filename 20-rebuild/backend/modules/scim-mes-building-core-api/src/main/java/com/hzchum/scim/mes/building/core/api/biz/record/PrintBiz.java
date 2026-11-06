package com.hzchum.scim.mes.building.core.api.biz.record;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.PrintReportDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProjectReturnRepairArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProjectReturnRepairSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.ProjectReturnRepairQueryDTOParam;
import java.math.BigDecimal;
import java.util.List;

public interface PrintBiz {
   Long savePrintRecord(Integer type, PrintReportDTOParam param);

   Boolean savePrint(Long warehouseId, BigDecimal quantity);

   PageVO<ProjectReturnRepairSummaryDTO> listArtifactReturnProject(ProjectReturnRepairQueryDTOParam param, Integer pageNumber, Integer pageSize);

   List<ProjectReturnRepairArtifactDTO> listReturnRepairArtifact(Long projectId);
}
