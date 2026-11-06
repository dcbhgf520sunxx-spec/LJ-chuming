package com.hzchum.scim.mes.building.core.api.service.warehouse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingSinglePartArtifactPrintRecord;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SingPringReportDTO;
import java.util.List;

public interface MesBuildingSinglePartArtifactPrintRecordService extends IService<MesBuildingSinglePartArtifactPrintRecord> {
   List<SingPringReportDTO> listRecord(Long productId, Long workshopId);

   List<MesBuildingSinglePartArtifactPrintRecord> listBydata(List<NumberInfoDTO> infoDTOS);
}
