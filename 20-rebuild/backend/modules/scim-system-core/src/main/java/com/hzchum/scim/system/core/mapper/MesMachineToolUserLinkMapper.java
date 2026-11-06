package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo.dto.change.SimpleUser;
import com.hzchum.scim.system.core.api.pojo._do.MesMachineToolUserLink;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesMachineToolUserLinkMapper extends BaseMapper<MesMachineToolUserLink> {
   List<SimpleUser> findUserInfoByCondition(
      @Param("partProcessId") Long partProcessId, @Param("toolConfigIds") List<Long> toolConfigIds, @Param("userIds") List<Long> userIds
   );
}
