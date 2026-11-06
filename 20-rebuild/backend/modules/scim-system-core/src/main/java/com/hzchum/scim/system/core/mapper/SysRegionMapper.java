package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysRegion;
import com.hzchum.scim.system.core.api.pojo.dto.AddressResponseVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRegionMapper extends BaseMapper<SysRegion> {
   List<AddressResponseVO> listByCityId(@Param("cityId") Long cityId);
}
