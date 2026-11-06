package com.hzchum.scim.mes.enclosure.core.api.service.factory;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineSumDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.ProductionLineDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages.DistributionDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureProductionLine;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureProductionLineDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureProductionLineDTOParam;
import java.util.List;
import java.util.Set;

public interface MesEnclosureProductionLineService extends IService<MesEnclosureProductionLine> {
   PageVO<MesEnclosureProductionLineDTO> productionLinePage(MesEnclosureProductionLineDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   List<MesEnclosureProductionLineDTO> listByCondition(MesEnclosureProductionLineDTOParam dtoParam);

   List<DistributionDO> listByCondition(Long factory, Long workshopId);

   ListVO<NameInfo> listProductionLineSimple(Long workshopId);

   ListVO<NameInfo> listProductionLineUser(Long workshopId);

   List<ProductionLineDO> productionLineList(Long factoryId, Long workshopId, Long productionLineId, Integer productType);

   List<MesEnclosureProductionLineSumDO> selectProductLine(String factoryId, String workShopId, String productionLineId, int type);

   List<MesEnclosureProductionLineSumDO> selectProductLineByids(Set<Long> lineIds);

   MesEnclosureProductionLine getLineById(Long productionLineId);
}
