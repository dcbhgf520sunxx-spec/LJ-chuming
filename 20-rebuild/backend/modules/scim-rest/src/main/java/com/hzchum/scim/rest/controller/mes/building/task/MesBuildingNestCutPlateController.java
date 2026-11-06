package com.hzchum.scim.rest.controller.mes.building.task;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlateBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingNestCutPlateDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post.MesBuildingNestCutPlateVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES钢板切割")
@RestController
@RequestMapping("/api/mes/building/nest_cut")
public class MesBuildingNestCutPlateController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingNestCutPlateController.class);
   @Resource
   private MesBuildingNestCutPlateBiz nestCutPlateBiz;

   @ApiOperation("绑定钢板")
   @PostMapping("")
   public ResultVO bindingSteelPlate(MesBuildingNestCutPlateVORequest voRequest) {
      log.info("API 调用 ：绑定钢板");
      return ResultBuilder.success(this.nestCutPlateBiz.bindingSteelPlate(BeanUtil.copy(voRequest, MesBuildingNestCutPlateDTOParam.class)));
   }
}
