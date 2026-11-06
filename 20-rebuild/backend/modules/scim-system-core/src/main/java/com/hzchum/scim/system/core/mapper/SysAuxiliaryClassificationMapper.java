package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysAuxiliaryClassification;
import com.hzchum.scim.system.core.api.pojo.dto.SysAuxiliaryClassificationDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuxiliaryClassificationMapper extends BaseMapper<SysAuxiliaryClassification> {
   List<SysAuxiliaryClassificationDTO> selectByCondition(@Param("name") String name);
}
