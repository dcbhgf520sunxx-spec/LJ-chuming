package com.hzchum.scim.mes.enclosure.core.api.biz.process;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process.MesEnclosureProcessDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.process.MesEnclosureProcessDTOParam;
import java.util.List;

public interface MesEnclosureProcessBiz {
   Boolean removeByIds(List<Long> ids);

   List<MesEnclosureProcessDTO> listByCondition(Boolean organizationType);

   List<MesEnclosureProcessDTO> list();

   PageVO<MesEnclosureProcessDTO> processPage(MesEnclosureProcessDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize);

   Boolean saveList(List<MesEnclosureProcessDTOParam> nameList);

   List<MesEnclosureProcessDTO> listRivetWeldAssembleList();
}
