package com.hzchum.scim.mes.building.core.api.biz.craft;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigQuery;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface MesPaintConfigBiz extends IBiz<MesPaintConfig> {
   PageVO<MesPaintConfigDTO> pageInfo(MesPaintConfigQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean add(MesPaintConfigParam param);

   Boolean edit(MesPaintConfigParam param);

   void templateDownload(HttpServletResponse response);

   void importData(MultipartFile file, HttpServletResponse response);

   Boolean deleteById(Long id);

   List<MesPaintConfigDTO> paintingCraftSelectList(MesPaintConfigQuery query);

   List<String> paintBrandList(String paintBrand);

   List<NameInfo> paintSelectList(Integer paintingTypeEnum);

   List<Map<String, Object>> commonPaintList(List<Integer> paintingTypeEnumList, List<String> paintBrandList, List<String> paintTypeList);

   Boolean clear();

   List<Map<String, Object>> listAllPaintConfig(Integer paintingTypeEnum);
}
