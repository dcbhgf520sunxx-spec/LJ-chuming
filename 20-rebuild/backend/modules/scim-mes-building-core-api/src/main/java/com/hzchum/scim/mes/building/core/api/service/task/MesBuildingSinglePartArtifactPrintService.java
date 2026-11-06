package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingSinglePartArtifactPrint;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartArtifactPrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartReportDTO;
import java.util.List;

public interface MesBuildingSinglePartArtifactPrintService extends IService<MesBuildingSinglePartArtifactPrint> {
   List<SinglePartArtifactPrintDTO> getPrintList(Integer printType, List<Long> projectIds, Long projectId, Long monomerId, Long areaId, String serialNumber);

   List<SinglePartArtifactPrintDTO> record(
      Long singId, List<Long> projectIds, Long projectId, Long monomerId, Long areaId, String serialNumber, String userName
   );

   List<MesBuildingSinglePartArtifactPrint> listByProductIds(List<SinglePartReportDTO> singlePartReportDTOS);

   List<MesBuildingSinglePartArtifactPrint> listBydata(List<NumberInfoDTO> numberInfoDTOS);
}
