package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysCountry;
import com.hzchum.scim.system.core.api.pojo.dto.AddressResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.AddressSimpleInfoDTO;
import java.util.List;
import java.util.Map;

public interface SysCountryService extends IService<SysCountry> {
   List<AddressResponseVO> listAll();

   AddressSimpleInfoDTO regionalCascadeSplit(List<Long> regionalIds);

   List<AddressResponseVO> listAllNew();

   Map<Long, SysCountry> listMapByIds(List<Long> countryIds);
}
