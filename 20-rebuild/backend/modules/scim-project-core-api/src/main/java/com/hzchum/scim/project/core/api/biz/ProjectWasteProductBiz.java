package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectReturnProductChildDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectWasteProductChildDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectWasteProductMainDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectReturnProductCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.ProjectWasteProductMainDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReturnProductChildQueryDTOParam;
import java.util.Date;
import java.util.List;

public interface ProjectWasteProductBiz {
   PageVO<ProjectReturnProductChildDO> listReturnAndWaste(ProjectReturnProductChildQueryDTOParam param, Integer pageNumber, Integer pageSize);

   PageVO<ProjectWasteProductMainDTO> pageListWasteMain(
      Integer productType,
      Integer relationType,
      String serialNumber,
      String projectName,
      Date createTimeStartDate,
      Date createTimeEndDate,
      String createUserName,
      String auditUserName,
      Integer auditStatus,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<ProjectWasteProductMainDTO>> printListWasteMain(
      Integer productType,
      Integer relationType,
      String serialNumber,
      String projectName,
      Date createTimeStartDate,
      Date createTimeEndDate,
      String createUserName,
      String auditUserName,
      Integer auditStatus
   );

   Boolean saveWasteHandle(ProjectWasteProductMainDTOParam param);

   Boolean auditWasteHandle(ProjectReturnProductCheckDTOParam param);

   Boolean delete(List<Long> idList);

   List<ProjectWasteProductChildDTO> listWasteChildByMainId(Long id);

   PrintVO<List<ProjectWasteProductChildDTO>> printListWasteChild(Long id);
}
