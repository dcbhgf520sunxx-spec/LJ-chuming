package com.hzchum.scim.mes.building.core.api.biz.abnormal;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.abnormal.ProduceSurplusDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal.ProduceSurplusDTOParam;
import java.util.List;

public interface MesBuildingProduceSurplusBiz {
   List<ProduceSurplusDTO> surplusList(ProduceSurplusDTOParam dtoParam);

   PageVO<ProduceSurplusDTO> surplusPage(ProduceSurplusDTOParam copy, String sort, Integer pageNumber, Integer pageSize);
}
