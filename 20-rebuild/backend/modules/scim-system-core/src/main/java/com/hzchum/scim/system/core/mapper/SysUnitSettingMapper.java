package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysUnitSetting;
import com.hzchum.scim.system.core.api.pojo.dto.UnitSettingResponseVO;
import java.util.List;

public interface SysUnitSettingMapper extends BaseMapper<SysUnitSetting> {
   List<UnitSettingResponseVO> listUnitSetting();
}
