package com.hzchum.scim.mes.building.core.mapper.temp_work;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work.MesTempWork;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkRecordQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesTempWorkMapper extends BaseMapper<MesTempWork> {
   List<MesTempWorkDTO> listInfo(MesTempWorkQuery query);

   MesTempWorkDTO detailById(@Param("id") Long id);

   List<MesTempWorkRecordDTO> recordList(MesTempWorkRecordQuery query);
}
