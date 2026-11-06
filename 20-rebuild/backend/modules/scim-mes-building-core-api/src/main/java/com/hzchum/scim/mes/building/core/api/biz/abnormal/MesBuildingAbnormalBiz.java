package com.hzchum.scim.mes.building.core.api.biz.abnormal;

import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalChangeReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalPreviewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalProcessPreviewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalSchedulingPreviewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProduceAbonrmalReportAndLimitDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal.AbnormalHandleDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal.TaskChangeDTOParam;
import java.util.List;

public interface MesBuildingAbnormalBiz {
   Boolean changeProductQuantity(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Integer productType,
      Integer oldQuantity,
      Integer newQuantity,
      String changeType,
      Boolean boolSurplusEnum,
      Long artifactId,
      String artifactSerialNumber,
      Long assembleId,
      String assembleSerialNumber
   );

   Boolean handleAbnormal(List<AbnormalHandleDTOParam> dtoParamList, Long id);

   ProduceAbonrmalReportAndLimitDTO reportList(Long id);

   AbnormalTaskDTO taskQuantityList(Long productId, Integer productType);

   Boolean changeTaskQuantity(Long id, List<TaskChangeDTOParam> dtoParamList);

   Integer updateAbnormalStatus(Long id);

   List<AbnormalChangeReportDTO> abonrmalChangeReport(Long id);

   List<AbnormalSchedulingPreviewDTO> handlePreview(Long abnormalId, List<TaskChangeDTOParam> taskList, List<AbnormalHandleDTOParam> reportList);

   List<AbnormalProcessPreviewDTO> changePreview(Long productId, Integer productType, Integer oldQuantity, Integer newQuantity);

   AbnormalPreviewDTO preview(Long id);

   AbnormalProductDTO productInfo(Long id, Integer productType);

   Boolean productChange(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Integer productType,
      Integer oldQuantity,
      Integer newQuantity,
      String changeType,
      Boolean boolSurplusEnum,
      Integer type,
      Long artifactId,
      String artifactSerialNumber,
      Long assembleId,
      String assembleSerialNumber
   );

   Boolean handlePart(Long id);

   Boolean checkAbnormalExist(Long productId, Integer productType);
}
