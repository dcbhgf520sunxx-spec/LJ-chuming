package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesBoltSleeve;
import com.hzchum.scim.system.core.api.pojo.dto.MesBoltSleeveDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesBoltSleeveSaveDTOParam;
import java.util.List;

public interface MesBoltSleeveService extends IService<MesBoltSleeve> {
   List<MesBoltSleeveDTO> listInfo();

   MesBoltSleeveDTO detailById(Long id);

   Boolean saveMesBoltSleeve(MesBoltSleeveSaveDTOParam param);

   Boolean updateMesBoltSleeve(MesBoltSleeveSaveDTOParam param);

   Boolean deleteById(Long id);
}
