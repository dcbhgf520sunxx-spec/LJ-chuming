package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesCoatingConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesCoatingConfigDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesCoatingConfigMapper extends BaseMapper<MesCoatingConfig> {
   List<MesCoatingConfigDTO> listInfo();

   MesCoatingConfigDTO detailById(@Param("id") Long id);

   Boolean artifactClassificationIsExist(@Param("id") Long id, @Param("artifactClassificationIdList") List<Long> artifactClassificationIdList);
}
