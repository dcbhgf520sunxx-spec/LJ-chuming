package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAssembleSaveNestingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.ArtifactAssociationCount;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechAssembleDetailMapper extends BaseMapper<TechAssembleDetail> {
   List<TechAssembleSaveNestingDTO> listNestingDetail(@Param("ids") List<Long> ids, @Param("productionLineTypeEnum") Integer productionLineTypeEnum);

   List<ArtifactAssociationCount> getArtifactPartConvertCounts(List<Long> artifactId);
}
