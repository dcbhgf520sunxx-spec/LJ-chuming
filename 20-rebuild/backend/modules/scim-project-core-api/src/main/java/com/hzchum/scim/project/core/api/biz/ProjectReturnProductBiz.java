package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductMain;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectReturnProductChildDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReturnProductChildDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectReturnProductMainDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductMainDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductMainQueryParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReturnProductQueryDTOParam;
import java.util.List;

public interface ProjectReturnProductBiz extends IBiz<ProjectReturnProductMain> {
   PageVO<ProjectReturnProductChildDO> listShipCanReturnProduct(ProjectReturnProductQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectReturnProductChildDO> listWarehouseCanReturnProduct(ProjectReturnProductQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectReturnProductChildDO> listSchedulingCanReturnProduct(ProjectReturnProductQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectReturnProductMainDTO> pageList(ProjectReturnProductMainQueryParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<ProjectReturnProductMainDTO>> returnProductPrint(ProjectReturnProductMainQueryParam param);

   Boolean saveReturn(ProjectReturnProductMainDTOParam param);

   Boolean auditReturn(ProjectReturnProductCheckDTOParam projectReturnProductMainDTOParam);

   Boolean deleteReturn(List<Long> idList);

   List<ProjectReturnProductChildDTO> listReturnChild(Long id);

   PrintVO<List<ProjectReturnProductChildDTO>> printListReturnChild(Long id);
}
