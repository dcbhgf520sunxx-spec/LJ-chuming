package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysEnclosureDictionary;
import com.hzchum.scim.system.core.api.pojo.dto.SysDictionaryDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionaryDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysTrussFloorPlateCodeDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysEnclosureDictionaryMapper extends BaseMapper<SysEnclosureDictionary> {
   List<SysDictionaryDetailDTO> listAllEnclosure(@Param("type") Integer type);

   List<SysEnclosureDictionaryDTO> listByNameAndLabelLike(@Param("name") String name, @Param("label") String label, @Param("type") Integer type);

   List<String> listByTypeAndName(@Param("type") Integer type, @Param("name") String name);

   List<SysEnclosureDictionaryDTO> listByCode(@Param("code") String code, @Param("type") Integer type);

   SysEnclosureDictionary getByNameAndLabel(@Param("name") String name, @Param("label") String label, @Param("type") Integer type);

   SysEnclosureDictionary getSort(@Param("name") String name, @Param("type") Integer type);

   List<SysTrussFloorPlateCodeDTO> listCodes(@Param("status") Boolean status);
}
