package com.hzchum.scim.mes.building.core.mapper.temp_work;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work.MesTempWorkApproval;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkApprovalDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesTempWorkApprovalMapper extends BaseMapper<MesTempWorkApproval> {
   List<MesTempWorkApprovalDTO> listByTempWorkIds(@Param("tempWorkIds") List<Long> tempWorkIds);

   Integer getMaxSort(@Param("tempWorkId") Long tempWorkId);
}
