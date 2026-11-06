package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysCity;
import com.hzchum.scim.system.core.api.pojo.dto.SysAreaDTO;
import java.util.List;
import java.util.Map;

public interface SysCityService extends IService<SysCity> {
   Boolean saves(List<SysAreaDTO> areaDTOList);

   Map<Long, SysCity> listMapByIds(List<Long> cityIds);
}
