package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysTablePrintTemplate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysTablePrintTemplateMapper extends BaseMapper<SysTablePrintTemplate> {
   List<SysTablePrintTemplate> listByType(String type);

   List<SysTablePrintTemplate> list(@Param("name") String name, @Param("type") String type, @Param("enabled") Boolean enabled);

   List<SysTablePrintTemplate> listByTypes(List<String> types);
}
