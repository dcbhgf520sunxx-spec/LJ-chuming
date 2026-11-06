package com.hzchum.scim.mes.building.core.mapper.warehouse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingSinglePartArtifactPrintRecord;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SingPringReportDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingSinglePartArtifactPrintRecordMapper extends BaseMapper<MesBuildingSinglePartArtifactPrintRecord> {
   List<SingPringReportDTO> listRecord(@Param("productId") Long productId, @Param("workshopId") Long workshopId);

   List<MesBuildingSinglePartArtifactPrintRecord> listBydata(@Param("infoDTOS") List<NumberInfoDTO> infoDTOS);
}
