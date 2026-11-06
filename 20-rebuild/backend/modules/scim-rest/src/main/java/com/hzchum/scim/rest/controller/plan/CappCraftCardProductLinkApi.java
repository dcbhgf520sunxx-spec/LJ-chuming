package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardProductLinkBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductLinkListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductLinkUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductLinkVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "计划管理 - CAPP 产品工艺绑定")
@RequestMapping("api/plan/CappCraftCardProductLink")
public class CappCraftCardProductLinkApi {
   private static final Logger log = LoggerFactory.getLogger(CappCraftCardProductLinkApi.class);
   @Resource
   private TechCappCraftCardProductLinkBiz techCappCraftCardProductLinkBiz;

   @ApiOperation("工艺管理列表")
   @GetMapping("/list")
   public ResultVO<PageVO<CappCraftCardProductLinkVO>> list(CappCraftCardProductLinkListDTO cappCraftCardProductLinkListDTO) {
      log.info("API调用:工艺管理列表");
      return ResultBuilder.success(this.techCappCraftCardProductLinkBiz.list(cappCraftCardProductLinkListDTO));
   }

   @ApiOperation("工艺管理绑定")
   @PostMapping("/update")
   public ResultVO<Boolean> update(@RequestBody List<CappCraftCardProductLinkUpdateDTO> updateDTO) {
      log.info("API调用:工艺管理绑定");
      return ResultBuilder.success(this.techCappCraftCardProductLinkBiz.update(updateDTO));
   }
}
