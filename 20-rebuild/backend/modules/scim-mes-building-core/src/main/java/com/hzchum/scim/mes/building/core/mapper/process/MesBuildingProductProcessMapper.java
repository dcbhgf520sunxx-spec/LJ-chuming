package com.hzchum.scim.mes.building.core.mapper.process;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProductProcessDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingProductProcessMapper extends BaseMapper<MesBuildingProductProcess> {
   MesBuildingProductProcessDO selectByNameAndType(@Param("name") String name, @Param("productType") Integer productType);

   List<String> listProcessByProductType(@Param("productType") Integer productType);

   List<MesBuildingProductProcess> selectByType(@Param("productType") Integer productType);

   List<MesBuildingProductProcessDTO> selectByProductTypeAndProcessIds(@Param("productType") Integer productType, @Param("processIds") List<Long> processIds);

   List<MesBuildingProductProcessDTO> selectProductLineAndProcessByTeamIds(@Param("teamIds") List<Long> teamIds);
}
