package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartWMSAcceptanceDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechStandardPartWMSDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartImportDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartQueryDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechStandardPartUpdateDtoParam;
import com.hzchum.scim.plan.core.api.pojo.voParam.StandardPartSaveVoParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TechStandardPartBiz extends IBiz<TechStandardPart> {
   PageVO<TechStandardPartDTO> pageListByCondition(TechStandardPartQueryDtoParam param, Integer pageNumber, Integer pageSize, Integer permissionCheck);

   void exportStandardPartTemplate(HttpServletResponse response);

   void importStandardPart(MultipartFile file, TechStandardPartImportDtoParam param, HttpServletResponse response);

   void importStandardPartV2(MultipartFile file, TechStandardPartImportDtoParam param, HttpServletResponse response);

   Boolean saveList(Integer productType, StandardPartSaveVoParam param);

   boolean checkWmsLink(Long projectId);

   Boolean updateList(List<TechStandardPartUpdateDtoParam> paramList);

   Boolean deleteList(Integer productType, List<Long> ids);

   boolean findStandPartWmsLink(Long projectId);

   PageVO<TechStandardPartWMSDTO> findWmsCargoAcceptance(TechStandardPartQueryDtoParam param, Integer pageNumber, Integer pageSize);

   List<TechStandardPartWMSAcceptanceDTO> findWmsAcceptanceList(List<Long> ids);

   Boolean exportStandardPartList(TechStandardPartQueryDtoParam dtoParam, HttpServletResponse response);

   TechStandardPartDetailDTO getTechStandardPartById(Long id);
}
