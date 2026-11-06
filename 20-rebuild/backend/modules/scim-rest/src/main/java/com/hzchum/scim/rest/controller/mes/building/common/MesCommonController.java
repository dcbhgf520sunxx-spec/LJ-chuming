package com.hzchum.scim.rest.controller.mes.building.common;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES发运-公共")
@RestController
@RequestMapping("/api/mes/building")
public class MesCommonController {
   private static final Logger log = LoggerFactory.getLogger(MesCommonController.class);
   @Autowired
   private MesBuildingPackageService packageService;

   @ApiOperation("查询项目下的所有包单号")
   @GetMapping("/package/list")
   public ResultVO getPackageList(Long projectId) {
      log.info("API 调用 ：查询项目下的所有包单号");
      return ResultBuilder.success(new ListVO<>(this.packageService.listByProjectId(projectId)));
   }
}
