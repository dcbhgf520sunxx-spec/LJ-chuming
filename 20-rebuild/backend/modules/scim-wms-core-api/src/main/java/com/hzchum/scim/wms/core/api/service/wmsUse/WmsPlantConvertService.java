package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPlantConvert;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PlantConvertDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PlantConvertDTOParam;
import java.time.LocalDateTime;
import java.util.List;

public interface WmsPlantConvertService extends IService<WmsPlantConvert> {
   Integer getMaxDayConventNumber(LocalDateTime date);

   PageVO<PlantConvertDTO> pageInfo(PlantConvertDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   ResultVO<JSONObject> convertDetail(Long id);
}
