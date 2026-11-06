package com.hzchum.scim.rest.controller.manage;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.gdMap.ProjectManageGdMapBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目管理-地图")
@RestController
@RequestMapping("/api/mes/map")
@Validated
public class ManageGdMapController {
   private static final Logger log = LoggerFactory.getLogger(ManageGdMapController.class);
   @Resource
   private ProjectManageGdMapBiz gdMapBiz;

   @ApiOperation("获取访问密钥")
   @GetMapping("/key")
   public ResultVO getGdMapKey(@RequestParam Integer type) {
      log.info("API 调用 ：查询可执行的项目");
      return ResultBuilder.success(this.gdMapBiz.getkey(type));
   }
}
