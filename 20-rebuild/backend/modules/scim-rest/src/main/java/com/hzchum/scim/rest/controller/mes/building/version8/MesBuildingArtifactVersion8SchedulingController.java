package com.hzchum.scim.rest.controller.mes.building.version8;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingArtifactSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.LineSchedulingInfoDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingArtifactSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingAssembleSchedulingDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.delete.MesBuildingArtifactSchedulingRecordDeleteVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.get.MesBuildingArtifactSchedulingVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post.MesBuildingArtifactSchedulingSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post.MesBuildingAssembleSchedulingSaveVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES构件排产")
@RestController
@RequestMapping("/api/mes/building/v8")
public class MesBuildingArtifactVersion8SchedulingController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingArtifactVersion8SchedulingController.class);
   @Resource
   private MesBuildingArtifactSchedulingBiz artifactSchedulingBiz;
   @Autowired
   private MesBuildingProductionLineBiz productionLineBiz;

   @ApiOperation("v8保存构件排产")
   @PostMapping("/scheduling/artifact")
   public ResultVO saveArtifactSchedulingListV8(@RequestBody @Validated List<MesBuildingArtifactSchedulingSaveVORequest> voRequestList) {
      log.info("API 调用 ：保存构件排产");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .saveArtifactSchedulingListV8(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("v8构件排产-获取生产线排产信息")
   @GetMapping("/scheduling/line/info")
   public ResultVO getSchedulingLineTreeV8(@Validated LineSchedulingInfoDTOParam dtoParam) {
      log.info("API 调用 ：v8构件排产-获取生产线排产信息");
      return ResultBuilder.success(this.productionLineBiz.getProductionLineSchedulingInfoV8(dtoParam, dtoParam.getMesProductEnum()));
   }

   @ApiOperation("v8构件预排产数")
   @GetMapping("/artifact/record/count")
   public ResultVO getArtifactSchedulingRecordCountV8(@RequestParam("areaIdList") List<Long> areaIdList) {
      log.info("API 调用 ：v8构件预排产数");
      return ResultBuilder.success(this.artifactSchedulingBiz.getArtifactSchedulingRecordCountV8(areaIdList));
   }

   @ApiOperation("v8构件预排产种类汇总")
   @GetMapping("/artifact/record/type/list")
   public ResultVO getArtifactRecordTypeList(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：v8构件预排产种类汇总");
      return ResultBuilder.success(
         new ListVO<>(this.artifactSchedulingBiz.getArtifactRecordTypeListV8(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)))
      );
   }

   @ApiOperation("v8构件预排产记录")
   @GetMapping("/artifact/record")
   public ResultVO getArtifactSchedulingRecordPage(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：v8构件预排产记录");
      return ResultBuilder.success(
         this.artifactSchedulingBiz.getArtifactSchedulingRecordListV8(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class))
      );
   }

   @ApiOperation("v8删除构件排产记录")
   @DeleteMapping("/artifact/record")
   public ResultVO deleteArtifactScheduling(@RequestBody List<MesBuildingArtifactSchedulingRecordDeleteVORequest> voRequestList) {
      log.info("API 调用 ：v8删除构件排产记录");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .deleteArtifactSchedulingV8(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("v8预排产部件所需部件数量列表")
   @GetMapping("/scheduling/assemble/list/{areaId}")
   public ResultVO getArtifactSchedulingAssembleV8(@PathVariable("areaId") Long areaId) {
      log.info("API 调用 ：v8预排产部件所需部件数量列表");
      return ResultBuilder.success(this.artifactSchedulingBiz.getArtifactSchedulingAssembleV8(areaId));
   }

   @ApiOperation("v8保存部件排产")
   @PostMapping("/scheduling/assemble")
   public ResultVO saveAssembleSchedulingListV8(@RequestBody @Validated List<MesBuildingAssembleSchedulingSaveVORequest> voRequestList) {
      log.info("API 调用 ：保存部件排产");
      return ResultBuilder.success(
         this.artifactSchedulingBiz
            .saveAssembleSchedulingListV8(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MesBuildingAssembleSchedulingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("v8部件预排产种类汇总")
   @GetMapping("/assemble/record/type/list/{areaId}")
   public ResultVO getAssembleRecordTypeList(@PathVariable("areaId") Long areaId) {
      log.info("API 调用 ：v8部件预排产种类汇总");
      return ResultBuilder.success(new ListVO<>(this.artifactSchedulingBiz.getAssembleRecordTypeListV8(areaId)));
   }

   @ApiOperation("v8部件排产生产线排产信息")
   @GetMapping("/scheduling/assemble/line/info/{areaId}")
   public ResultVO getSchedulingAssembleLineTreeV8(@PathVariable("areaId") Long areaId) {
      log.info("API 调用 ：v8部件排产生产线排产信息");
      return ResultBuilder.success(this.productionLineBiz.getArtifactSchedulingLineInfoSummaryV8(areaId));
   }
}
