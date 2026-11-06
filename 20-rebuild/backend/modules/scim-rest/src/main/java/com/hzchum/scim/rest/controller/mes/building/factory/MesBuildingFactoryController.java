package com.hzchum.scim.rest.controller.mes.building.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.BranchAttributeEnum;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingFactoryBiz;
import com.hzchum.scim.mes.building.core.api.enums.WorkShopTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingWorkshopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingFactoryDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.factory.get.FactoryListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.factory.get.FactoryProductionLineVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.factory.post.FactorySaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.factory.put.FactoryUpdateStatusVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.factory.put.FactoryUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.voUtils.IdsVoRequest;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES工厂")
@RestController
@RequestMapping("/api/mes/building/factory")
@PropertySource(value = "classpath:module/module.properties", encoding = "UTF-8")
public class MesBuildingFactoryController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingFactoryController.class);
   @Autowired
   private MesBuildingFactoryBiz factoryBiz;
   @Value("${factory-quantity}")
   private Integer factoryQuantity;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private BranchCompanyService branchCompanyService;

   @ApiOperation("获取工厂列表")
   @GetMapping
   public ResultVO<ListVO<MesBuildingFactoryDTO>> factoryList(FactoryListVORequest voRequest) {
      log.info("API 调用 ：获取工厂列表");
      return ResultBuilder.success(new ListVO<>(this.factoryBiz.listByCondition(BeanUtil.copy(voRequest, MesBuildingFactoryDTOParam.class))));
   }

   @ApiOperation("获取工厂列表")
   @GetMapping("/app")
   public ResultVO<ListVO<MesBuildingFactoryDTO>> appFactoryList(FactoryListVORequest voRequest) {
      log.info("API 调用 ：获取工厂列表");
      return ResultBuilder.success(new ListVO<>(this.factoryBiz.listByCondition(BeanUtil.copy(voRequest, MesBuildingFactoryDTOParam.class))));
   }

   @ApiOperation("根据id获取工厂")
   @GetMapping("/{id}")
   @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "id", dataType = "Long", paramType = "query", required = true))
   @PreAuthorize("@permission.check('factory:get')")
   public ResultVO<MesBuildingFactory> factoryById(@PathVariable Long id) {
      log.info("API 调用 ：获取工厂列表");
      return ResultBuilder.success(this.factoryBiz.getById(id));
   }

   @ApiOperation("分页获取工厂列表")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "工厂列表请求类", dataTypeClass = FactoryListVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   @PreAuthorize("@permission.check('factory:get')")
   public ResultVO<PageVO<MesBuildingFactoryDTO>> factoryPage(
      FactoryListVORequest voRequest,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取工厂列表");
      return ResultBuilder.success(this.factoryBiz.factoryPage(BeanUtil.copy(voRequest, MesBuildingFactoryDTOParam.class), sort, pageNumber, pageSize));
   }

   @ApiOperation("新增工厂")
   @PostMapping
   @PreAuthorize("@permission.check('factory:add')")
   public ResultVO<Boolean> factorySave(@RequestBody @Valid FactorySaveVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增工厂");
      BranchCompany branchCompany = this.branchCompanyService.getById(request.getBranchCompanyId());
      Preconditions.checkArgument(branchCompany != null, "选择分支机构不存在!");
      Preconditions.checkArgument(branchCompany.getEnabled().equals(EnableEnum.ENABLE.getType()), "选择分支机构已禁用!");
      Preconditions.checkArgument(branchCompany.getBranchAttributeEnum().equals(BranchAttributeEnum.MANUFACTURING.getType()), "选择分支机构属性必须为[加工]类型!");
      MesBuildingFactory factory = BeanUtil.copy(request, MesBuildingFactory.class);
      Preconditions.checkArgument(this.factoryBiz.list().size() < this.factoryQuantity, "操作失败，工厂添加数已达上限，无法新增工厂");
      List<MesBuildingFactory> factoryList = this.factoryBiz
         .list((Wrapper<MesBuildingFactory>)Wrappers.<MesBuildingFactory>lambdaQuery().eq(MesBuildingFactory::getName, factory.getName()));
      Preconditions.checkArgument(factoryList.size() == 0, "添加失败:已存在相同名称的工厂");
      return ResultBuilder.success(this.factoryBiz.save(factory.setUserId(UserUtil.getCurrentUserId())));
   }

   @ApiOperation("修改工厂")
   @PutMapping
   @PreAuthorize("@permission.check('factory:edit')")
   public ResultVO<Boolean> factoryUpdate(@RequestBody @Valid FactoryUpdateVORequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：修改工厂");
      MesBuildingFactory factory = this.factoryBiz.getById(voRequest.getId());
      Preconditions.checkArgument(factory != null, "修改工厂不存在!");
      if (!voRequest.getName().equals(factory.getName())) {
         int count = this.factoryBiz.count(Wrappers.lambdaQuery(MesBuildingFactory.builder().name(voRequest.getName()).build()));
         Preconditions.checkArgument(count == 0, "修改失败,工厂名称不能重复!");
      }

      if (!voRequest.getShortName().equals(factory.getShortName())) {
         int count = this.factoryBiz.count(Wrappers.lambdaQuery(MesBuildingFactory.builder().shortName(voRequest.getShortName()).build()));
         Preconditions.checkArgument(count == 0, "修改失败,工厂简称不能重复!");
      }

      if (!voRequest.getBranchCompanyId().equals(factory.getBranchCompanyId())) {
         BranchCompany branchCompany = this.branchCompanyService.getById(voRequest.getBranchCompanyId());
         Preconditions.checkArgument(branchCompany != null, "选择分支机构不存在!");
         Preconditions.checkArgument(branchCompany.getEnabled().equals(EnableEnum.ENABLE.getType()), "选择分支机构已禁用!");
         Preconditions.checkArgument(branchCompany.getBranchAttributeEnum().equals(BranchAttributeEnum.MANUFACTURING.getType()), "选择分支机构属性必须为[加工]类型!");
      }

      return ResultBuilder.success(this.factoryBiz.updateById(BeanUtil.copy(voRequest, MesBuildingFactory.class)));
   }

   @ApiOperation("删除工厂")
   @DeleteMapping
   @PreAuthorize("@permission.check('factory:del')")
   public ResultVO<Boolean> factoryDelete(@RequestBody IdsVoRequest voRequest) {
      log.info("API 调用 ：删除工厂");
      voRequest.getIds()
         .forEach(
            e -> Preconditions.checkArgument(
               this.workshopService.list((Wrapper<MesBuildingWorkshop>)Wrappers.<MesBuildingWorkshop>lambdaQuery().eq(MesBuildingWorkshop::getFactoryId, e)).size() == 0,
               "删除失败，请先删除改工厂下全部车间"
            )
         );
      return ResultBuilder.success(this.factoryBiz.removeByIds(voRequest.getIds()));
   }

   @ApiOperation("修改工厂禁用状态")
   @PutMapping("/changeState")
   @PreAuthorize("@permission.check('factory:editStatus')")
   public ResultVO<Boolean> factoryUpdateState(@RequestBody @Valid FactoryUpdateStatusVORequest voRequest) {
      log.info("API 调用 ：修改工厂禁用状态");
      return ResultBuilder.success(
         this.factoryBiz.factoryUpdateState(BeanUtil.copy(voRequest, MesBuildingFactoryDTOParam.class).setUserId(UserUtil.getCurrentUserId()))
      );
   }

   @ApiOperation("查询全部生产线，按工厂车间分组")
   @GetMapping("/production_line_group")
   public ResultVO<ListVO<MesBuildingFactoryDTO>> productionLineGroupByWorkshop(FactoryProductionLineVORequest voRequest) {
      log.info("API 调用 ：查询全部生产线，按工厂车间分组");
      voRequest.setWorkShopType(
         voRequest.getWorkShopType() == null ? WorkShopTypeEnum.BUILDING.getType() | WorkShopTypeEnum.BRIDGE.getType() : voRequest.getWorkShopType()
      );
      return ResultBuilder.success(
         new ListVO<>(
            this.factoryBiz.listProductionLineByFactoryByCondition(BeanUtil.copy(voRequest, MesBuildingFactoryDTOParam.class), voRequest.getWorkShopType())
         )
      );
   }

   @ApiOperation("查询车间产线(默认零件)")
   @GetMapping("/workshop")
   public ResultVO<ListVO<MesBuildingWorkshopDTO>> productionLineByWorkshop(FactoryProductionLineVORequest voRequest) {
      log.info("API 调用 ：查询车间产线(默认零件)");
      return ResultBuilder.success(
         new ListVO<>(
            this.factoryBiz
               .listProductionLineByWorkShopByCondition(BeanUtil.copy(voRequest, MesBuildingFactoryDTOParam.class), WorkShopTypeEnum.BUILDING.getType())
         )
      );
   }

   @ApiOperation("启用工厂列表选择")
   @GetMapping("/enable-factory-list-select")
   public ResultVO enableFactoryListSelect() {
      log.info("API 调用 ：启用工厂列表选择");
      return ResultBuilder.success(
         this.factoryBiz.list(Wrappers.lambdaQuery(MesBuildingFactory.class).eq(MesBuildingFactory::getBoolEnabledEnum, Boolean.TRUE))
      );
   }
}
