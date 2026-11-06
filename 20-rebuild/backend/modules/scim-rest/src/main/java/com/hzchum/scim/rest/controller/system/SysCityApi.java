package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo.dto.SysAreaDTO;
import com.hzchum.scim.system.core.api.service.SysCityService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-城市")
@RestController
@RequestMapping("/api/city")
public class SysCityApi {
   private static final Logger log = LoggerFactory.getLogger(SysCityApi.class);
   @Resource
   private SysCityService cityService;

   @PostMapping("/saveList")
   public ResultVO saveList(@RequestBody List<SysAreaDTO> areaDTOList) {
      Boolean saves = this.cityService.saves(areaDTOList);
      return ResultBuilder.success(saves);
   }

   public SysCityApi(final SysCityService cityService) {
      this.cityService = cityService;
   }
}
