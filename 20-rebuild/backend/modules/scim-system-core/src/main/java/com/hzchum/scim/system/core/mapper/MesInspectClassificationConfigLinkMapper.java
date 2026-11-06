package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectClassificationConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectClassificationConfigLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesInspectClassificationConfigLinkMapper extends BaseMapper<MesInspectClassificationConfigLink> {
   List<MesInspectClassificationConfigLinkDTO> findClassInfoByInspectId(@Param("idList") List<Long> idList);
}
