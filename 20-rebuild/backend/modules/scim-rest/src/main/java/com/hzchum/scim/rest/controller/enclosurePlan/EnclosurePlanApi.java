package com.hzchum.scim.rest.controller.enclosurePlan;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.plan.core.api.biz.EnclosurePlanBiz;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailCreateDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailQureyDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailUpdateDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanTechDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureTechQureyDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "围护计划")
@RestController
@RequestMapping("/api/enclosurePlanDetail")
public class EnclosurePlanApi {
   private static final Logger log = LoggerFactory.getLogger(EnclosurePlanApi.class);
   @Resource
   private EnclosurePlanBiz enclosurePlanBiz;

   @GetMapping("")
   @ApiOperation("查询所有围护计划")
   public ResultVO<PageVO<EnclosurePlanDetailDto>> findAll(EnclosurePlanDetailQureyDto dto) {
      return this.enclosurePlanBiz.findAll(dto);
   }

   @GetMapping("/{projectId}")
   @ApiOperation("查询计划详情")
   public ResultVO<List<EnclosurePlanTechDto>> findByProjectId(@PathVariable("projectId") Long projectId) {
      return this.enclosurePlanBiz.findByProjectId(projectId);
   }

   @PostMapping("")
   @ApiOperation("创建批次计划")
   public ResultVO addEnclosurePlan(@Valid @RequestBody EnclosurePlanDetailCreateDto dto) {
      return this.enclosurePlanBiz.addEnclosurePlan(dto);
   }

   @GetMapping("/tech")
   @ApiOperation("查询批次计划")
   public ResultVO<PageVO<EnclosurePlan>> findBytechId(
      EnclosureTechQureyDto dto, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      return this.enclosurePlanBiz.findBytechId(dto, pageNumber, pageSize);
   }

   @DeleteMapping("/{id}")
   @ApiOperation("根据id删除计划")
   public ResultVO deleteById(@PathVariable("id") Long id) {
      return this.enclosurePlanBiz.deleteById(id);
   }

   @PutMapping("")
   @ApiOperation("根据id修改计划")
   public ResultVO modifyById(@Valid @RequestBody EnclosurePlanDetailUpdateDto dto) {
      return this.enclosurePlanBiz.modifyById(dto);
   }

   @GetMapping("/tech/{projectId}")
   @ApiOperation("查询项目下所有计划")
   public ResultVO<List<EnclosurePlan>> findAllPlan(@PathVariable("projectId") Long id) {
      return this.enclosurePlanBiz.findAllPlan(id);
   }
}
