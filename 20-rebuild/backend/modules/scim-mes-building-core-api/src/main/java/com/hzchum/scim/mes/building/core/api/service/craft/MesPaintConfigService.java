package com.hzchum.scim.mes.building.core.api.service.craft;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigQuery;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface MesPaintConfigService extends IService<MesPaintConfig> {
   List<String> UNIT_LIST = Arrays.asList("kg", "L");
   List<String> PACKAGE_UNIT = Arrays.asList("桶", "组");

   PageVO<MesPaintConfigDTO> pageInfo(MesPaintConfigQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MesPaintConfigDTO> listInfo(MesPaintConfigQuery query);

   Boolean add(MesPaintConfigParam param);

   Boolean edit(MesPaintConfigParam param);

   void templateDownload(HttpServletResponse response);

   void importData(MultipartFile file, HttpServletResponse response);

   Boolean deleteById(Long id);

   List<MesPaintConfigDTO> paintingCraftSelectList(MesPaintConfigQuery query);

   List<String> paintBrandList(String paintBrand);

   List<String> paintTypeList(String paintType);

   List<NameInfo> paintSelectList(Integer paintingTypeEnum);
}
