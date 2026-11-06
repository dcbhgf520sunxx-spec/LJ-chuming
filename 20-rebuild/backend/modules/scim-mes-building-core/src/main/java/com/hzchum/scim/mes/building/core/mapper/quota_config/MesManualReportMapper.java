package com.hzchum.scim.mes.building.core.mapper.quota_config;

import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesManualReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesManualReportQuery;
import java.util.List;
import lombok.NonNull;

public interface MesManualReportMapper {
   List<MesManualReportDTO> unreportedEnclosureList(@NonNull MesManualReportQuery query);

   List<MesManualReportDTO> flexibleProcessUnreportedList(@NonNull MesManualReportQuery query);
}
