package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesAuxiliary;
import com.hzchum.scim.system.core.api.pojo.dto.MesAuxiliaryDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesAuxiliaryDTOParam;
import java.util.List;
import java.util.Map;

public interface MesAuxiliaryService extends IService<MesAuxiliary> {
   List<MesAuxiliaryDTO> selectList(Integer basicClass, String auxiliaryName, String className);

   MesAuxiliaryDTO selectById(Long id);

   Boolean save(List<MesAuxiliaryDTOParam> dtoParams);

   Boolean update(MesAuxiliaryDTOParam dtoParam);

   Boolean deleted(List<Long> ids);

   Map<Long, String> getClassification(Integer basicClass, String accountingUnit);
}
