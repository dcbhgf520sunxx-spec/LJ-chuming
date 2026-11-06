package com.hzchum.scim.common.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WmsApproveRecordDetailMapper extends BaseMapper<WmsApproveRecordDetail> {
   Integer selectCanCheckCount(
      @Param("currentUserId") Long currentUserId,
      @Param("status") Integer status,
      @Param("flowType") Integer flowType,
      @Param("componentNameList") List<String> componentNameList,
      @Param("approveSource") Integer approveSource
   );
}
