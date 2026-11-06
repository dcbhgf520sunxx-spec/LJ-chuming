package com.hzchum.scim.mes.building.core.mapper._package;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.PackageDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackage;
import com.hzchum.scim.mes.building.core.api.pojo._doParam._package.MesBuildingPackageDOParam;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingPackageMapper extends BaseMapper<MesBuildingPackage> {
   List<PackageDO> listByCondition(MesBuildingPackageDOParam doParam);

   Integer countByDate(@Param("projectId") Long projectId, @Param("now") LocalDateTime now);
}
