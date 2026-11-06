package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysProvinceNew;
import com.hzchum.scim.system.core.api.service.SysProvinceNewService;
import com.hzchum.scim.system.core.mapper.SysProvinceNewMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class SysProvinceNewServiceImpl extends ServiceImpl<SysProvinceNewMapper, SysProvinceNew> implements SysProvinceNewService {
   @Override
   public Map<Long, SysProvinceNew> listMapByIds(List<Long> provinceIds) {
      return CollectionUtils.isEmpty(provinceIds)
         ? new HashMap<>()
         : this.baseMapper.selectBatchIds(provinceIds).stream().collect(Collectors.toMap(SysProvinceNew::getId, item -> (SysProvinceNew)item));
   }
}
