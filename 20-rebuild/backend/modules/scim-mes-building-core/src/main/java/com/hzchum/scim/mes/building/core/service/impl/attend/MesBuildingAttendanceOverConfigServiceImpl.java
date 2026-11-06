package com.hzchum.scim.mes.building.core.service.impl.attend;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigService;
import com.hzchum.scim.mes.building.core.mapper.attend.MesBuildingAttendanceOverConfigMapper;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingAttendanceOverConfigServiceImpl
   extends ServiceImpl<MesBuildingAttendanceOverConfigMapper, MesBuildingAttendanceOverConfig>
   implements MesBuildingAttendanceOverConfigService {
   @Override
   public List<MesBuildingAttendanceOverConfig> getListByIdStr(String ids) {
      if (StringUtils.isBlank(ids)) {
         return Collections.emptyList();
      }

      String[] split = StringUtils.split(ids, ",");
      List<Long> idList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
      return CollectionUtils.isEmpty(idList) ? Collections.emptyList() : this.listByIds(idList);
   }
}
