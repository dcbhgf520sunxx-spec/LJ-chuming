package com.hzchum.scim.mes.building.core.api.service.wage_manage;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesContractProjectAssemblingWeldingConfigReview;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.MesContractProjectAssemblingWeldingConfigReviewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesContractProjectAssemblingWeldingConfigReviewQueryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam;

public interface MesContractProjectAssemblingWeldingConfigReviewService extends IService<MesContractProjectAssemblingWeldingConfigReview> {
   PageVO<MesContractProjectAssemblingWeldingConfigReviewDTO> pageInfo(
      MesContractProjectAssemblingWeldingConfigReviewQueryDTOParam queryDTOParam, Integer pageNumber, Integer pageSize
   );

   MesContractProjectAssemblingWeldingConfigReviewDTO detailById(Long id);

   Boolean saveData(MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam saveDTOParam);

   Boolean changeReviewStatus(MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam saveDTOParam);
}
