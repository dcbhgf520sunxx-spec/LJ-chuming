package com.hzchum.scim.cut.core.api.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.cut.core.api.pojo._do.WmsNestMaterial;
import java.util.List;

public interface WmsNestMaterialService extends IService<WmsNestMaterial> {
   ResultVO getMaterial(String teamCode);

   JSONArray getPlant(Long materialId, Double thickness, String teamCode);

   WmsNestMaterial addMaterial(String name, String density, String teamCode);

   Boolean updatePlant(Double thickness, String material, String syncKey, String teamCode);

   Boolean getJobPlant(Long jobId, JSONArray jsonArray, String teamCode, String message);

   Boolean generateSurplus(List<String> guids);

   Boolean addSurplusPlate(Double thickness, Long materialId, String material, String teamCode);

   JSONArray getNspfPart(String guid, String teamCode, String jobName);

   Boolean saveOutbound(String guid, String childGuid, String childOrderNumber, Long factoryId, Long branchId);

   Boolean passed(String guid);

   void testOutbound(String Guid);

   void getdad(String guid, String teamCode);

   Boolean deleteNesting(String guid);

   Boolean deleteNestingByChildGuid(String stockCutGuid);
}
