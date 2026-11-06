package com.hzchum.scim.mes.building.core.api.biz.kpi;

import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.CompleteMeteYearDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProductionCompleteYieldKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.CarModleKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.CargoListKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.CargoListSummayKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.ProductionLineCompleteYieldKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.ProjectCargoListKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.ProjectCompleteYieldKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.QhseKpiDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.kpi.QhseTypeKpiDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingKpiBiz {
   CompleteMeteYearDTO completeByYear(LocalDateTime dateTime);

   List<ProductionCompleteYieldKpiDO> completeYieldGropMonth(LocalDateTime dateTime);

   List<ProductionLineCompleteYieldKpiDTO> productionLineCompleteYieldGropMonth(LocalDateTime dateTime);

   List<ProjectCompleteYieldKpiDTO> projectCompleteYield(LocalDateTime dateTime);

   List<CargoListKpiDTO> cargoListGroupByMonth(LocalDateTime dateTime);

   List<QhseKpiDTO> qhseType(LocalDateTime dateTime);

   List<QhseTypeKpiDTO> qualityQhseType(LocalDateTime dateTime);

   CargoListSummayKpiDTO cargoListSummary(LocalDateTime dateTime);

   List<CargoListKpiDTO> cargoListAmountGroupByMonth(LocalDateTime dateTime);

   List<CarModleKpiDTO> carModelByYear(LocalDateTime dateTime);

   List<ProjectCargoListKpiDTO> projectCargoListByYear(LocalDateTime dateTime);

   List<ProjectCargoListKpiDTO> projectCargoListByDay(LocalDateTime dateTime);
}
