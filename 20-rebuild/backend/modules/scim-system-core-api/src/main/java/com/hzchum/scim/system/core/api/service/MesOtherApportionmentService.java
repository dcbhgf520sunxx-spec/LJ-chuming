package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesOtherApportionment;
import com.hzchum.scim.system.core.api.pojo.dto.MesOtherApportionmentDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesOtherApportionmentSaveDTOParam;
import java.util.List;

public interface MesOtherApportionmentService extends IService<MesOtherApportionment> {
   List<MesOtherApportionmentDTO> listInfo();

   MesOtherApportionmentDTO detailById(Long id);

   Boolean saveOtherApportionment(MesOtherApportionmentSaveDTOParam param);

   Boolean editOtherApportionment(MesOtherApportionmentSaveDTOParam param);

   Boolean updateStatus(Long id, Boolean status);

   Boolean deleteById(Long id);
}
