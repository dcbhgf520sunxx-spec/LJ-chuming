package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigUserLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesInspectConfigUserLinkMapper extends BaseMapper<MesInspectConfigUserLink> {
   List<MesInspectConfigUserLinkDTO> findInspectUserInfoByInspectId(@Param("idList") List<Long> idList);
}
