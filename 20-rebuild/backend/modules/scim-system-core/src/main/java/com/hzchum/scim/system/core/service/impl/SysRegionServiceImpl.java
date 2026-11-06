package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysRegion;
import com.hzchum.scim.system.core.api.service.SysRegionService;
import com.hzchum.scim.system.core.mapper.SysRegionMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class SysRegionServiceImpl extends ServiceImpl<SysRegionMapper, SysRegion> implements SysRegionService {
   @Override
   public Map<Long, SysRegion> listMapByIds(List<Long> regionIds) {
      return CollectionUtils.isEmpty(regionIds)
         ? new HashMap<>()
         : this.baseMapper.selectBatchIds(regionIds).stream().collect(Collectors.toMap(SysRegion::getId, item -> (SysRegion)item));
   }
}
