package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingSinglePartArtifactPrint;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ExternalArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.PrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SingPringReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartArtifactPrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartReportDTO;
import java.util.List;

public interface MesBuildingSinglePartArtifactPrintBiz extends IBiz<MesBuildingSinglePartArtifactPrint> {
   Boolean assistArtifactReport(List<ExternalArtifactDTO> externalArtifactDTOS);

   PageVO<SinglePartArtifactPrintDTO> getPrintList(
      Integer printType, Long projectId, Long monomerId, Long areaId, String serialNumber, Integer pageNumber, Integer pageSize
   );

   PageVO<SingPringReportDTO> record(Long productId, Long workshopId, Integer pageNumber, Integer pageSize);

   Boolean savePrint(PrintDTO dto);

   Boolean report(SinglePartReportDTO report);
}
