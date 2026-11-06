package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.DictionaryInfo;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo.dto.SysDictionaryDTO;
import com.hzchum.scim.system.core.api.pojo.request.DictionarySaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.DictionaryUpdateRequestVO;
import java.util.List;
import java.util.Map;

public interface SysDictionaryService extends IService<SysDictionary> {
   ListVO<SysDictionaryDTO> listAllDictionary(String blurry);

   ListVO<SysDictionaryDTO> listMoreDictionary(List<String> blurrys);

   List<SysDictionary> moreDistNameAndLabelLike(List<String> names);

   PageVO<SysDictionary> pageByNameAndLabelLike(String name, String label, Integer pageNumber, Integer pageSize);

   List<SysDictionary> listByName(String name);

   Long saveDictionary(DictionarySaveDTOParam requestVO);

   Boolean updateDictionary(DictionaryUpdateRequestVO requestVO);

   Boolean deleteDictionary(Long id);

   Map<String, String> getValueLabelByName(String name);

   List<String> listLabelsByCondition(String name, String values);

   ListVO<DictionaryInfo> listDictionaryInfo(String name);

   SysDictionary getByNameAndValue(String name, String value);

   SysDictionary getByNameAndValueFromCache(String name, String value);

   SysDictionary saveWithCache(SysDictionary dictionary);

   SysDictionary updateWithCache(SysDictionary dictionary);

   Boolean deleteWithCache(String name, String value);

   SysDictionary getByNameAndValueV2(String currencyType, String value);

   PageVO<SysDictionaryDTO> pageInfo(String blurry, Integer pageNumber, Integer pageSize);
}
