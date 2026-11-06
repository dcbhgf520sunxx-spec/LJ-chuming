package com.hzchum.scim.rest.controller.mes.building.factory;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingTeamBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingMachinePartTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingTeamLeaderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesProcessTeamListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingPartCutConfigWorkShopDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingPartTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingProductDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.team.get.TeamListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.team.post.PartTeamVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.team.post.TeamSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.team.put.TeamUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.voUtils.IdsVoRequest;
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

@Api(tags = "MES班组")
@RestController
@RequestMapping("/api/mes/building/team")
public class MesBuildingTeamController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingTeamController.class);
   @Autowired
   private MesBuildingTeamBiz teamBiz;
   @Autowired
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;

   @ApiOperation("获取班组列表")
   @GetMapping
   @PreAuthorize("@permission.check('productionLine_team:get')")
   public ResultVO<ListVO<MesBuildingTeamDTO>> teamList(TeamListVORequest vORequest) {
      log.info("API 调用 ：获取班组列表");
      return ResultBuilder.success(new ListVO<>(this.teamBiz.listByCondition(BeanUtil.copy(vORequest, MesBuildingTeamDTOParam.class))));
   }

   @ApiOperation("获取班组列表(无权限)")
   @GetMapping("/find")
   public ResultVO<ListVO<MesBuildingTeamDTO>> teamListV2(TeamListVORequest vORequest) {
      log.info("API 调用 ：获取班组列表");
      return ResultBuilder.success(new ListVO<>(this.teamBiz.listByCondition(BeanUtil.copy(vORequest, MesBuildingTeamDTOParam.class))));
   }

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "partProdMode", value = "零件生产模式1 数控切割 2 半自动切割", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "processType", value = "工序类型4 下料类 8 钻孔类", dataType = "Integer", paramType = "query", required = true)
      }
   )
   @ApiOperation("获取零件切割配置班组")
   @GetMapping("/partCutConfigTeamList")
   public ResultVO partCutConfigTeamList(
      @RequestParam Integer partProdMode, @RequestParam Integer processType, @RequestParam(required = false) Integer deviceType
   ) {
      log.info("API 调用 ：获取零件切割配置班组列表(零件排产使用获取切割配置)");
      return ResultBuilder.success(this.mesBuildingMachinePartTeamDetailService.partCutConfigTeamList(partProdMode, processType, deviceType));
   }

   @ApiOperation("获取零件切割配置班组切割方式或者钻孔方式")
   @PostMapping("/partCutConfigTeamList/partCutConfigTeamFeatureList")
   public ResultVO partCutConfigTeamListCutType(@RequestBody MesBuildingPartCutConfigWorkShopDTOParam mesBuildingPartCutConfigWorkShopDTOParam) {
      log.info("API 调用 ：获取零件切割配置班组切割或者钻孔方式列表(零件排产使用获取切割配置)");
      return ResultBuilder.success(this.mesBuildingMachinePartTeamDetailService.partCutConfigTeamListFeature(mesBuildingPartCutConfigWorkShopDTOParam));
   }

   @ApiOperation("查询型材无工序的构件产线和班组")
   @ApiImplicitParams(@ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MachinePartNestingProductDetailDTOParam"))
   @PostMapping("/getNoProcessTeam")
   public ResultVO getNoProcessTeam(@RequestBody MachinePartNestingProductDetailDTOParam machinePartNestingProductDetailDTOParam) {
      log.info("API 调用 ：查询型材无工序的构件产线和班组");
      return ResultBuilder.success(this.mesBuildingMachinePartTeamDetailService.getNoProcessTeam(machinePartNestingProductDetailDTOParam));
   }

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "partProdMode", value = "零件生产模式1 数控切割 2 半自动切割", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "processType", value = "工序类型4 下料类 8 钻孔类", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "partType", value = "零件类型1 板材零件 2 型材零件", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "teamId", value = "班组id", dataType = "Long", paramType = "query", required = true)
      }
   )
   @ApiOperation("获取零件切割配置班组切割方式或者钻孔方式")
   @GetMapping("/partCutConfigTeamList/cutType")
   public ResultVO partCutConfigTeamListCutType(
      @RequestParam(required = false) Integer partProdMode,
      @RequestParam(required = false) Integer processType,
      @RequestParam(required = false) Integer partType,
      @RequestParam(required = false) Long teamId,
      @RequestParam(required = false) Long wokshopId
   ) {
      log.info("API 调用 ：获取零件切割配置班组切割或者钻孔方式列表(零件排产使用获取切割配置)");
      return ResultBuilder.success(
         this.mesBuildingMachinePartTeamDetailService.partCutConfigTeamListCutType(partProdMode, processType, partType, teamId, wokshopId)
      );
   }

   @ApiOperation("获取零件切割配置班组切割方式或者钻孔方式")
   @PostMapping("/partCutConfigTeamList/cutTypeFeature")
   public ResultVO partCutConfigTeamListCutTypeFeature(@RequestBody MesBuildingPartCutConfigWorkShopDTOParam mesBuildingPartCutConfigWorkShopDTOParam) {
      log.info("API 调用 ：获取零件切割配置班组切割或者钻孔方式列表(零件排产使用获取切割配置)");
      return ResultBuilder.success(this.mesBuildingMachinePartTeamDetailService.partCutConfigTeamListCutTypeFeature(mesBuildingPartCutConfigWorkShopDTOParam));
   }

   @ApiOperation("根据工序获取班组")
   @GetMapping("/process")
   @PreAuthorize("@permission.check('productionLine_team:get')")
   public ResultVO teamListByProcessId(@RequestParam Long processId, @RequestParam Long workshopId) {
      log.info("API 调用 ：根据工序获取班组列表");
      return ResultBuilder.success(new ListVO<>(this.teamBiz.listByProcessId(processId, workshopId)));
   }

   @ApiOperation("获取零件班组列表")
   @GetMapping("/part_team")
   @PreAuthorize("@permission.check('machine_productionLine_team:get')")
   public ResultVO teamList(MesBuildingPartTeamDTOParam vORequest) {
      log.info("API 调用 ：获取零件班组列表");
      return ResultBuilder.success(this.teamBiz.machinePartListByCondition(vORequest));
   }

   @ApiOperation("获取班组")
   @GetMapping("/{id}")
   @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "id", dataType = "Long", paramType = "query", required = true))
   @PreAuthorize("@permission.check('productionLine_team:get')")
   public ResultVO<MesBuildingTeamDTO> teamById(@PathVariable Long id) {
      log.info("API 调用 ：获取班组列表");
      return ResultBuilder.success(this.teamBiz.teamById(id));
   }

   @ApiOperation("获取班组")
   @GetMapping("/part_team/{id}")
   @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "id", dataType = "Long", paramType = "query", required = true))
   @PreAuthorize("@permission.check('machine_productionLine_team:get')")
   public ResultVO<MesBuildingMachinePartTeamDTO> machinePartById(@PathVariable Long id) {
      log.info("API 调用 ：获取班组列表");
      return ResultBuilder.success(this.teamBiz.machinePartTeamById(id));
   }

   @ApiOperation("分页获取班组列表")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "请求实体类", dataTypeClass = TeamListVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   @PreAuthorize("@permission.check('productionLine_team:get')")
   public ResultVO<PageVO<MesBuildingTeamDTO>> teamPage(
      TeamListVORequest voRequest,
      @RequestParam(name = "sort", required = false) Long sort,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取班组列表");
      return ResultBuilder.success(this.teamBiz.teamPage(BeanUtil.copy(voRequest, MesBuildingTeamDTOParam.class), sort, pageNumber, pageSize));
   }

   @ApiOperation("查询车间产线下的班组，以及班组下的组长")
   @GetMapping("/workshopProductionLineTeamLeader")
   public ResultVO workshopProductionLineTeamLeader(TeamListVORequest voRequest) {
      log.info("API 调用 ：获取班组列表");
      return ResultBuilder.success(this.teamBiz.workshopProductionLineTeamLeader(BeanUtil.copy(voRequest, MesBuildingTeamDTOParam.class)));
   }

   @ApiOperation("新增班组")
   @PostMapping
   @PreAuthorize("@permission.check('productionLine_team:add')")
   public ResultVO<Boolean> saveTeam(@RequestBody @Valid TeamSaveVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      Preconditions.checkArgument(request.getUserLinks().size() != 0, "添加失败，未填写班组人员");
      log.info("API 调用 ：新增班组");
      return ResultBuilder.success(this.teamBiz.saveTeam2(BeanUtil.copy(request, MesBuildingTeamDTOParam.class).setUserId(UserUtil.getCurrentUserId())));
   }

   @ApiOperation("新增零件班组")
   @PostMapping("part_team")
   @PreAuthorize("@permission.check('machine_productionLine_team:add')")
   public ResultVO<Boolean> saveMachinePartTeam(@RequestBody @Valid PartTeamVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：新增零件班组");
      return ResultBuilder.success(
         this.teamBiz.saveMachinePartTeam(BeanUtil.copy(request, MesBuildingPartTeamDTOParam.class).setUserId(UserUtil.getCurrentUserId()))
      );
   }

   @ApiOperation("修改班组")
   @PutMapping
   @PreAuthorize("@permission.check('productionLine_team:edit')")
   public ResultVO<Boolean> teamUpdate(@RequestBody @Valid TeamUpdateVORequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：修改班组");
      return ResultBuilder.success(this.teamBiz.teamUpdate(BeanUtil.copy(voRequest, MesBuildingTeamDTOParam.class).setUserId(UserUtil.getCurrentUserId())));
   }

   @ApiOperation("修改零件班组")
   @PutMapping("/part_team")
   @PreAuthorize("@permission.check('machine_productionLine_team:edit')")
   public ResultVO<Boolean> machinePartTeamUpdate(@RequestBody @Valid PartTeamVORequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：修改零件班组");
      return ResultBuilder.success(
         this.teamBiz.machinePartTeamUpdate(BeanUtil.copy(voRequest, MesBuildingPartTeamDTOParam.class).setUserId(UserUtil.getCurrentUserId()))
      );
   }

   @ApiOperation("删除班组")
   @DeleteMapping
   @PreAuthorize("@permission.check('productionLine_team:del')")
   public ResultVO<Boolean> teamDelete(@RequestBody IdsVoRequest voRequest) {
      log.info("API 调用 ：删除班组");
      return ResultBuilder.success(this.teamBiz.deleteTeamByIds(voRequest.getIds()));
   }

   @ApiOperation("删除班组")
   @ApiImplicitParams(@ApiImplicitParam(name = "ids", value = "班组id集合", dataType = "array", paramType = "query", required = true))
   @DeleteMapping("/part_team")
   @PreAuthorize("@permission.check('machine_productionLine_team:del')")
   public ResultVO<Boolean> machinePartTeamDelete(@RequestBody IdsVoRequest voRequest) {
      log.info("API 调用 ：删除班组");
      return ResultBuilder.success(this.teamBiz.deleteMachinePartTeamByIds(voRequest.getIds()));
   }

   @ApiOperation("根据用户查询所在班组")
   @GetMapping("/user")
   public ResultVO userTeam() {
      log.info("API 调用 ：根据用户查询所在班组");
      return ResultBuilder.success(new ListVO<>(this.teamBiz.useTeam(UserUtil.getCurrentUserId())));
   }

   @ApiOperation("关闭启用班组")
   @PutMapping("/status")
   @PreAuthorize("@permission.check('productionLine_team:editStatus')")
   public ResultVO<Boolean> teamStatus(@RequestParam(name = "teamId") Long teamId, @RequestParam(name = "teamStatus") Boolean teamStatus) {
      log.info("API 调用 ：关闭启用班组");
      return ResultBuilder.success(this.teamBiz.teamStatus(teamId, teamStatus));
   }

   @ApiOperation("查询全部班组长")
   @GetMapping("/leader")
   public ResultVO<ListVO<MesBuildingTeamLeaderDTO>> findAllTeamLeader(TeamListVORequest vORequest) {
      log.info("API 调用 ：查询全部班组长");
      return ResultBuilder.success(new ListVO<>(this.teamBiz.findAllTeamLeader(BeanUtil.copy(vORequest, MesBuildingTeamDTOParam.class))));
   }

   @ApiOperation("查询车间下配置的工序和班组")
   @GetMapping("/workshop/process/leader")
   public ResultVO<ListVO<MesProcessTeamListDTO>> findProcessTeamList(Long workShopId, Long productionLineId) {
      log.info("API 调用 ：查询车间下配置的工序和班组");
      return ResultBuilder.success(new ListVO<>(this.teamBiz.findProcessTeamList(workShopId, productionLineId)));
   }

   @ApiOperation("关闭启用班组")
   @PutMapping("/part_team/status")
   @PreAuthorize("@permission.check('machine_productionLine_team:editStatus')")
   public ResultVO<Boolean> machinePartTeamStatus(@RequestParam(name = "teamId") Long teamId, @RequestParam(name = "teamStatus") Boolean teamStatus) {
      log.info("API 调用 ：关闭启用班组");
      return ResultBuilder.success(this.teamBiz.machinePartTeamStatus(teamId, teamStatus));
   }
}
