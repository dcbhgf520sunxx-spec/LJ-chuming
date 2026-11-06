package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractVisa;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractVisaMapper extends BaseMapper<ContractVisa> {
   int countByProject(@Param("projectId") Long projectId, @Param("mode") Integer mode);

   List<ContractVisa> selectListByCondition(
      @Param("projectId") Long projectId,
      @Param("status") Integer status,
      @Param("userName") String userName,
      @Param("checkUerName") String checkUerName,
      @Param("mode") Integer mode,
      @Param("year") String year,
      @Param("businessType") Integer businessType,
      @Param("type") Integer type
   );

   int getCount(LocalDateTime date, Integer mode);
}
