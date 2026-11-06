package com.hzchum.scim.mes.enclosure.core.api.biz.factory;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineSumDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureProductionLine;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureProductionLineDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.ProductionLineDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamsForLineDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.util.IdAndNameDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureProductionLineDTOParam;
import java.util.List;
import java.util.Set;

public interface MesEnclosureProductionLineBiz extends IBiz<MesEnclosureProductionLine> {
   Boolean productionLineUpdateState(MesEnclosureProductionLineDTOParam dtoParam);

   Boolean saveProductionLine(MesEnclosureProductionLineDTOParam dtoParam);

   Boolean removeByIds(List<Long> ids);

   List<ProductionLineDTO> productionLineList(Long factoryId, Long workshopId, Long productionLineId, Integer productType);

   List<IdAndNameDTO> getTypeByProductType(Integer productType, Integer productionLineTypeEnum);

   PageVO<MesEnclosureProductionLineDTO> productionLinePage(MesEnclosureProductionLineDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   List<MesEnclosureProductionLineDTO> listByCondition(MesEnclosureProductionLineDTOParam dtoParam);

   Boolean update(MesEnclosureProductionLineDTOParam dtoParam);

   List<MesEnclosureProductionLineSumDO> selectProductLine(
      String factoryId, String workShopId, String productionLineId, Integer pageNumber, Integer pageSize, int type
   );

   MesEnclosureProductionLine selectByid(Long productionLineId);

   List<MesEnclosureProductionLineSumDO> selectProductLineByids(Set<Long> lineIds);

   List<String> productionLineByNameList(MesEnclosureProductionLineDTOParam dtoParam);

   TeamsForLineDTO getTeamsByLine(Long id);

   Boolean saveTeamLink(Long id, List<Long> teamIds);

   Boolean saveInspectTeam(Long id, List<Long> teamIds);
}
