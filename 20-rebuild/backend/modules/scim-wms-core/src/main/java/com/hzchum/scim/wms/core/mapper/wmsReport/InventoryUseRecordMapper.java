package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseRecord;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryUseRecordDTO;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InventoryUseRecordMapper extends BaseMapper<InventoryUseRecord> {
   List<InventoryUseRecordDTO> getDetailDTOList(
      @Param("id") Long id, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime, @Param("formType") Integer formType
   );

   List<InventoryUseRecordDTO> getDetailDTOListNew(
      @Param("ids") List<Long> ids, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime, @Param("formType") Integer formType
   );
}
