package com.hzchum.scim.wms.core.mapper.wmsConfig;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.DownloadSectionSteelDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpecStandardDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelSpecStandardDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.StandardDetailDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SectionSteelSpecStandardDetailMapper extends BaseMapper<SectionSteelSpecStandardDetail> {
   List<SectionSteelSpecStandardDetail> getBySpecId(Long id);

   @Select("select code from wms_section_steel_spec_standard_detail ORDER BY code desc limit 1")
   Integer getMaxCode();

   @Select("SELECT standard_id FROM wms_section_steel_spec_standard_detail WHERE spec_id = #{id} and bool_delete_enum = false")
   List<Long> getStandardId(Long id);

   @Update("UPDATE wms_section_steel_spec_standard_detail SET unit_net =  #{detail.unitNet} WHERE standard_id = #{detail.id} and spec_id = #{specId}")
   void updateBySpecId(@Param("detail") StandardDetailDTOParam detail, @Param("specId") Long id);

   List<DownloadSectionSteelDO> download(Long sectionSteelId, Long standardId);

   List<SectionSteelSpecStandardDetailDTO> selectDetailBySpecId(@Param("specId") Long specId);
}
