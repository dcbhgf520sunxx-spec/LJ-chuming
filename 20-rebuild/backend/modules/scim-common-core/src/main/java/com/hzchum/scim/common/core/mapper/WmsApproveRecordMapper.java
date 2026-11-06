package com.hzchum.scim.common.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveRecordDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WmsApproveRecordMapper extends BaseMapper<WmsApproveRecord> {
   List<WmsApproveRecordDTO> getList(@Param("vo") WmsApproveRecordDTOParam vo, @Param("currentUserId") Long currentUserId);

   List<WmsApproveRecordDTO> getOaList(@Param("vo") WmsApproveRecordDTOParam vo, @Param("currentUserId") Long currentUserId);

   Integer selectSubmitAndReviewCount(
      @Param("status") Integer status, @Param("currentUserId") Long currentUserId, @Param("componentNameList") List<String> componentNameList
   );

   Integer selectRejectedCanCheckCount(
      @Param("status") Integer status,
      @Param("reviewStatus") Integer reviewStatus,
      @Param("currentUserId") Long currentUserId,
      @Param("startTime") String startTime,
      @Param("componentNameList") List<String> componentNameList
   );
}
