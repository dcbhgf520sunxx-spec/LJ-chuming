package com.hzchum.scim.mes.building.core.mapper.wage_manage;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesContractProjectAssemblingWeldingConfigReview;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.MesContractProjectAssemblingWeldingConfigReviewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesContractProjectAssemblingWeldingConfigReviewQueryDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesContractProjectAssemblingWeldingConfigReviewMapper extends BaseMapper<MesContractProjectAssemblingWeldingConfigReview> {
   List<MesContractProjectAssemblingWeldingConfigReviewDTO> listInfo(
      @Param("queryDTOParam") MesContractProjectAssemblingWeldingConfigReviewQueryDTOParam queryDTOParam
   );

   MesContractProjectAssemblingWeldingConfigReviewDTO detailById(@Param("id") Long id);
}
