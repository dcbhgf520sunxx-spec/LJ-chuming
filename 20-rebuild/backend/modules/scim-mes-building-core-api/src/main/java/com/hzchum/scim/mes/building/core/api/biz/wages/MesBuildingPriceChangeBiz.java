package com.hzchum.scim.mes.building.core.api.biz.wages;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingPriceChange;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.put.ChangeProductWageDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProductTypeSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProductWageDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.StudSleeveDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MesBuildingPriceChangeBiz extends IBiz<MesBuildingPriceChange> {
   List<ProductTypeSummaryDTO> getProductTypeList(Long projectId, Long monomerId, Long areaId, Integer taskTypeEnum);

   List<MesBuildingProcess> getProductTypeProcessList(Long configId, Integer taskTypeEnum);

   List<ProductWageDTO> getProductPriceList(Long configId, Long processId, Long projectId, Long monomerId, Long areaId, Integer taskTypeEnum);

   PageVO<ProductWageDTO> getProductPricePage(
      Long configId,
      Long processId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer taskTypeEnum,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean changeProductWage(List<ChangeProductWageDTOParam> dtoParam);

   PageVO<StudSleeveDTO> studSleevePage(
      Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer auxiliaryTypeEnum, Integer pageNumber, Integer pageSize
   );

   List<StudSleeveDTO> studSleeveList(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer auxiliaryTypeEnum);

   PrintVO<List<Map<String, Object>>> studSleevePrint(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer auxiliaryTypeEnum);
}
