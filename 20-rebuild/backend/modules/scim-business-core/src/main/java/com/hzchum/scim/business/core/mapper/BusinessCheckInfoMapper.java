package com.hzchum.scim.business.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.business.core.api.pojo._do.CheckInfoDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckInfo;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessCheckExcelDTO;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessCheckInfoMapper extends BaseMapper<BusinessCheckInfo> {
   List<CheckInfoDO> listInfo(
      @Param("projectId") Long projectId, @Param("type") Integer type, @Param("status") Integer status, @Param("dateTimeList") List<LocalDateTime> dateTimeList
   );

   Integer countList();

   List<BusinessCheckExcelDTO> listExcel(@Param("projectId") Long projectId, @Param("type") Integer type);
}
