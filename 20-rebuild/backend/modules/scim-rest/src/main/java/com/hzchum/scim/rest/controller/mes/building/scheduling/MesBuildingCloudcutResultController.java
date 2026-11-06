package com.hzchum.scim.rest.controller.mes.building.scheduling;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingCloudcutResultService;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingCloudcutResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/mes/building/scheduling/cloudcut_result")
@Api(tags = "云切结果")
public class MesBuildingCloudcutResultController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingCloudcutResultController.class);
   @Resource
   private MesBuildingCloudcutResultService mesBuildingCloudcutResultService;

   @GetMapping("/page")
   @ApiImplicitParam(name = "mesBuildingCloudcutResultDTO", value = "查询参数", required = true, dataType = "MesBuildingCloudcutResultDTO")
   @ApiOperation("云切结果分页查询")
   public ResultVO pageMesBuildingCloudcutResult(MesBuildingCloudcutResultDTO mesBuildingCloudcutResultDTO) {
      log.info("Api调用:云切结果分页查询，参数：{}", mesBuildingCloudcutResultDTO);
      return ResultBuilder.success(this.mesBuildingCloudcutResultService.pageMesBuildingCloudcutResult(mesBuildingCloudcutResultDTO));
   }

   @GetMapping("/{id}")
   @ApiImplicitParam(name = "id", value = "云切结果ID", required = true, dataType = "Long")
   @ApiOperation("信息")
   public ResultVO get(@PathVariable("id") Long id) {
      return ResultBuilder.success(this.mesBuildingCloudcutResultService.getById(id));
   }

   @PostMapping("/add")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "multipartFile", value = "云切结果文件", required = true, dataType = "MultipartFile"),
            @ApiImplicitParam(name = "cloudcutId", value = "云切ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "partType", value = "云切类型：零件类型[8 板材零件 4 型材零件]", required = true, dataType = "Integer")
      }
   )
   @ApiOperation("新增云切结果")
   public ResultVO saveMesBuildingCloudcutResult(
      @RequestParam(name = "multipartFile") MultipartFile multipartFile,
      @RequestParam(name = "cloudcutId") Long cloudcutId,
      @RequestParam(name = "partType") Integer partType
   ) {
      log.info("Api调用:云切结果保存，参数：multipartFile：{}，id：{}，partType：{}", multipartFile, cloudcutId, partType);
      return ResultBuilder.success(this.mesBuildingCloudcutResultService.saveMesBuildingCloudcutResult(multipartFile, cloudcutId, partType));
   }

   @PutMapping("/update")
   @ApiImplicitParam(name = "mesBuildingCloudcutResultDTO", value = "云切结果参数", required = true, dataType = "MesBuildingCloudcutResultDTO")
   @ApiOperation("修改云切结果")
   public ResultVO updateMesBuildingCloudcutResult(@RequestBody @Valid MesBuildingCloudcutResultDTO mesBuildingCloudcutResultDTO) {
      log.info("Api调用:云切结果修改，参数：{}", mesBuildingCloudcutResultDTO);
      return ResultBuilder.success(this.mesBuildingCloudcutResultService.updateMesBuildingCloudcutResult(mesBuildingCloudcutResultDTO));
   }

   @PostMapping("/updateStatus")
   @ApiImplicitParam(name = "mesBuildingCloudcutResultDTO", value = "云切结果参数", required = true, dataType = "MesBuildingCloudcutResultDTO")
   @ApiOperation("修改云切结果状态")
   public ResultVO updateMesBuildingCloudcutResultStatus(@RequestBody @Valid List<MesBuildingCloudcutResultDTO> mesBuildingCloudcutResultDTOList) {
      log.info("Api调用:修改云切结果状态，参数：{}", mesBuildingCloudcutResultDTOList);
      return ResultBuilder.success(this.mesBuildingCloudcutResultService.updateMesBuildingCloudcutResultStatus(mesBuildingCloudcutResultDTOList));
   }

   @PostMapping("/send")
   @ApiImplicitParam(name = "mesBuildingCloudcutResultDTO", value = "云切结果参数", required = true, dataType = "MesBuildingCloudcutResultDTO")
   @ApiOperation("下发云切结果")
   public ResultVO sendMesBuildingCloudcutResult(@RequestBody List<MesBuildingCloudcutResultDTO> mesBuildingCloudcutResultDTOList) {
      log.info("Api调用:云切结果修改，参数：{}", mesBuildingCloudcutResultDTOList);
      return ResultBuilder.success(this.mesBuildingCloudcutResultService.sendMesBuildingCloudcutResult(mesBuildingCloudcutResultDTOList));
   }

   @PostMapping("/checkFile")
   @ApiImplicitParam(name = "mesBuildingCloudcutResultDTO", value = "云切结果参数", required = true, dataType = "MesBuildingCloudcutResultDTO")
   @ApiOperation("云切结果文件校验")
   public ResultVO checkFile(@RequestParam(name = "multipartFile") MultipartFile multipartFile, @RequestParam(name = "cloudcutId") Long cloudcutId) {
      log.info("Api调用:云切结果文件校验，参数：multipartFile：{}，id：{}", multipartFile, cloudcutId);
      return ResultBuilder.success(this.mesBuildingCloudcutResultService.checkFile(multipartFile, cloudcutId));
   }

   @DeleteMapping("/delete")
   @ApiImplicitParam(name = "idList", value = "云切结果参数", required = true, dataType = "List<Long>")
   @ApiOperation("云切结果删除")
   public ResultVO deleteMesBuildingCloudcutResult(@RequestBody List<Long> idList) {
      log.info("Api调用:云切结果删除，参数：{}", idList);
      return ResultBuilder.success(this.mesBuildingCloudcutResultService.deleteMesBuildingCloudcutResult(idList));
   }

   public MesBuildingCloudcutResultController(final MesBuildingCloudcutResultService mesBuildingCloudcutResultService) {
      this.mesBuildingCloudcutResultService = mesBuildingCloudcutResultService;
   }
}
