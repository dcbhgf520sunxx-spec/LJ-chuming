package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.system.core.api.pojo._do.SysEnclosureDictionary;
import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionaryDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysTrussFloorPlateCodeDTO;
import com.hzchum.scim.system.core.api.pojo.request.EnclosureDictionaryDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.TrussFloorPlateSaveDTOParam;
import java.util.List;

public interface SysEnclosureDictionaryService extends IService<SysEnclosureDictionary> {
   ListVO listAllDictionary(Integer type);

   ListVO<SysEnclosureDictionaryDTO> listByName(String name, String code, Integer type, String label);

   ListVO<SysEnclosureDictionaryDTO> listByCode(String code);

   Integer saveBatchDictionary(List<EnclosureDictionaryDTOParam> requestVO);

   Long saveDictionary(EnclosureDictionaryDTOParam requestVO);

   Boolean deleteDictionary(Long id);

   Boolean saveUpdateEnclosureDictionary(TrussFloorPlateSaveDTOParam requestVO);

   Boolean updateStatus(String code, Boolean status);

   Boolean deleteByCodes(List<String> codes);

   Boolean updateDictionary(EnclosureDictionaryDTOParam requestVO);

   List<SysTrussFloorPlateCodeDTO> listCodes(Boolean status);

   List<String> listByTypeAndName(Integer type, String name);
}
