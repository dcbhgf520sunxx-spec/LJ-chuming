package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo.dto.SysDictionaryDetailDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictionaryMapper extends BaseMapper<SysDictionary> {
   List<SysDictionaryDetailDTO> listAllDictionary(@Param("blurry") String blurry);

   List<SysDictionary> listByNameAndLabelLike(@Param("name") String name, @Param("label") String label);

   List<SysDictionary> listByNameAndValue(@Param("name") String name, @Param("value") String value);

   SysDictionary getByNameAndLabel(@Param("name") String name, @Param("label") String label);

   SysDictionary getByNameAndValue(@Param("name") String name, @Param("value") String value);

   List<String> selectByConditions(@Param("name") String name, @Param("valueList") List<String> valueList);

   List<SysDictionary> moreDistNameAndLabelLike(List<String> names);

   SysDictionary getByNameAndValueV2(@Param("currencyType") String currencyType, @Param("value") String value);
}
