package com.hzchum.scim.mes.building.core.api.service.wage_manage;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesContractProjectAssemblingWeldingConfigReviewRecord;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam;

public interface MesContractProjectAssemblingWeldingConfigReviewRecordService extends IService<MesContractProjectAssemblingWeldingConfigReviewRecord> {
   PageVO<MesContractProjectAssemblingWeldingConfigReviewRecord> pageInfo(
      MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam queryDTOParam, Integer pageNumber, Integer pageSize
   );
}
