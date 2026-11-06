package com.hzchum.scim.project.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectConstructionDataDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ConstructionDataQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ConstructionDataSaveDTOParam;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface ProjectConstructionDataBiz {
   PageVO<ProjectConstructionDataDTO> list(ConstructionDataQueryDTOParam param, Integer pageNumber, Integer pageSize);

   Boolean uploadFile(MultipartFile file, ConstructionDataSaveDTOParam param);

   Boolean removeData(List<Long> ids);
}
