package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesProcessConversionRate;
import com.hzchum.scim.system.core.api.pojo.request.MesProcessConversionRateDTO;
import com.hzchum.scim.system.core.api.pojo.vo.MesProcessConversionRateVO;
import java.util.List;

public interface MesProcessConversionRateService extends IService<MesProcessConversionRate> {
   List<MesProcessConversionRateVO> listAllMesProcessConversionRate(Long artifactClassId);

   Boolean saveMesProcessConversionRate(MesProcessConversionRateDTO mesProcessConversionRateDTO);

   String updateMesProcessConversionRate(MesProcessConversionRate mesProcessConversionRate);

   void removeMesProcessConversionRate(List<Long> ids);
}
