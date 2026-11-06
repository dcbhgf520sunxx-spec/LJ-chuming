package com.hzchum.scim.mes.building.core.api.service.qhse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseAcceptDeviation;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseAcceptDeviationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDTO;
import org.springframework.transaction.annotation.Transactional;

public interface MesBuildingQhseAcceptDeviationService extends IService<MesBuildingQhseAcceptDeviation> {
   PageVO<MesBuildingQhseDTO> findAcceptDeviationList(Integer status, Integer pageNumber, Integer pageSize);

   @Transactional
   Boolean saveQhseAcceptDeviation(MesBuildingQhseAcceptDeviationDTO qhseAcceptDeviationDTO);

   @Transactional
   Boolean updateQhseAcceptDeviation(MesBuildingQhseAcceptDeviationDTO qhseAcceptDeviationDTO);

   @Transactional
   Boolean rejectQhseAcceptDeviation(MesBuildingQhseAcceptDeviationDTO qhseAcceptDeviationDTO);
}
