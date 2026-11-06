package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleClassifyLink;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassifyLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAssembleClassifyLinkMapper extends BaseMapper<SysAssembleClassifyLink> {
   List<SteelClassifyLinkDTO> selectByCondition(@Param("assembleConfigId") Long assembleConfigId);
}
