package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysCountry;
import com.hzchum.scim.system.core.api.pojo.dto.AddressResponseVO;
import java.util.List;

public interface SysCountryMapper extends BaseMapper<SysCountry> {
   List<AddressResponseVO> listAllCountry();
}
