package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractChange;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractChangeDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractChangeMapper extends BaseMapper<ContractChange> {
   List<ContractChangeDTO> selectByCondition(
      @Param("userId") Long userId,
      @Param("projectId") Long projectId,
      @Param("year") Integer year,
      @Param("type") Integer type,
      @Param("name") String name,
      @Param("userName") String userName,
      @Param("auditorName") String auditorName,
      @Param("auditStatus") Integer auditStatus
   );
}
