package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesProcessConversionRate;
import com.hzchum.scim.system.core.api.pojo.vo.MesProcessConversionRateVO;
import java.util.List;

public interface MesProcessConversionRateMapper extends BaseMapper<MesProcessConversionRate> {
   List<MesProcessConversionRateVO> listAllMesProcessConversionRate(Long artifactClassId);
}
