package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CutSurplusRecord;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.CutSurplusDTO;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CutSurplusRecordMapper extends BaseMapper<CutSurplusRecord> {
   List<CutSurplusDTO> getList(@Param("projectId") Long projectId, @Param("cutTaskId") String cutTaskId, @Param("endTime") List<LocalDateTime> endTime);
}
