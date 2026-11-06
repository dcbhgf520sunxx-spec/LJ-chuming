package com.hzchum.scim.rest.controller.mes.enclosure.process;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.enclosure.core.api.biz.process.MesEnclosureProcessBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.process.MesEnclosureProcess;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.process.MesEnclosureProcessDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.process.MesEnclosureProcessService;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.process.process.get.ProcessListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.process.process.put.ProcessUpdateVORequest;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.Objects;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES工序-围护")
@RestController
@RequestMapping("/api/mes/enclosure/process")
public class MesEnclosureProcessController {
   private static final Logger log = LoggerFactory.getLogger(MesEnclosureProcessController.class);
   @Autowired
   private MesEnclosureProcessService processService;
   @Autowired
   private MesEnclosureProcessBiz processBiz;

   @ApiOperation("获取工序列表(围护)")
   @GetMapping("/group")
   public ResultVO processGroupList() {
      log.info("API 调用 ：获取工序列表(围护)");
      return ResultBuilder.success(this.processBiz.list());
   }

   @ApiOperation("分页获取工序列表(围护)")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public ResultVO processPage(
      ProcessListVORequest voRequest,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取工序列表(围护)");
      return ResultBuilder.success(this.processBiz.processPage(BeanUtil.copy(voRequest, MesEnclosureProcessDTOParam.class), sort, pageNumber, pageSize));
   }

   @ApiOperation("修改工序上报类型(围护)")
   @PutMapping
   public ResultVO processUpdate(@RequestBody @Valid ProcessUpdateVORequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：修改工序上报类型(围护)");
      Preconditions.checkArgument(voRequest.getId() != null, "id不能为空");
      return ResultBuilder.success(this.processService.updateById(BeanUtil.copy(voRequest, MesEnclosureProcess.class).setUserId(UserUtil.getCurrentUserId())));
   }
}
