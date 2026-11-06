package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysProvince;
import com.hzchum.scim.system.core.api.pojo.dto.AddressResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.ProvinceResponseVO;
import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface SysProvinceMapper extends BaseMapper<SysProvince> {
   List<SysProvince> listByCountryId(@Param("countryId") Long countryId);

   Long findIdByNameAndCode(@Param("name") String name, @Param("code") String code);

   List<AddressResponseVO> listProvinceByCountryId(Long countryId);

   @Select("SELECT id,name,code,id cityList FROM sys_province WHERE country_id =1 and bool_delete_enum = 0")
   @Results(@Result(property = "cityList", column = "cityList", many = @Many(select = "com.hzchum.scim.system.core.mapper.CityMapper.findByProvinceId")))
   List<ProvinceResponseVO> findChineseProvince();
}
