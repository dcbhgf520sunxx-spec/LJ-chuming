package com.hzchum.scim.rest.controller.mes.building.scheduling;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingCloudcutJobService;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingCloudcutJobDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mes/building/scheduling/cloudcut_job")
@Api(tags = "云切作业")
public class MesBuildingCloudcutJobController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingCloudcutJobController.class);
   @Resource
   private MesBuildingCloudcutJobService mesBuildingCloudcutJobService;

   @GetMapping("/page")
   @ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MesBuildingCloudcutJobDTO")
   @ApiOperation("云切作业分页查询")
   public ResultVO pageMesBuildingCloudcutJob(MesBuildingCloudcutJobDTO mesBuildingCloudcutJobDTO) {
      return ResultBuilder.success(this.mesBuildingCloudcutJobService.pageMesBuildingCloudcutJob(mesBuildingCloudcutJobDTO));
   }

   @GetMapping("/{id}")
   @ApiImplicitParam(name = "id", value = "云切作业ID", required = true, dataType = "Long")
   @ApiOperation("信息")
   public ResultVO getMesBuildingCloudcutJob(@PathVariable("id") Long id) {
      return ResultBuilder.success(this.mesBuildingCloudcutJobService.getById(id));
   }

   @PostMapping("/add")
   @ApiImplicitParam(name = "param", value = "云切作业参数", required = true, dataType = "MesBuildingCloudcutJobDTO")
   @ApiOperation("新增云切作业")
   public ResultVO saveMesBuildingCloudcutJob(@RequestBody MesBuildingCloudcutJobDTO mesBuildingCloudcutJobDTO) {
      log.info("API 调用 ：新增云切作业，参数{}", mesBuildingCloudcutJobDTO);
      return ResultBuilder.success(this.mesBuildingCloudcutJobService.saveMesBuildingCloudcutJob(mesBuildingCloudcutJobDTO));
   }

   @PutMapping("/update")
   @ApiImplicitParam(name = "param", value = "云切作业参数", required = true, dataType = "MesBuildingCloudcutJobDTO")
   @ApiOperation("修改云切作业")
   public ResultVO updateMesBuildingCloudcutJob(@RequestBody MesBuildingCloudcutJobDTO mesBuildingCloudcutJobDTO) {
      log.info("API 调用 ：修改云切作业，参数{}", mesBuildingCloudcutJobDTO);
      return ResultBuilder.success(this.mesBuildingCloudcutJobService.updateMesBuildingCloudcutJob(mesBuildingCloudcutJobDTO));
   }

   @DeleteMapping("/delete")
   @ApiImplicitParam(name = "param", value = "云切作业参数", required = true, dataType = "List<Long>")
   @ApiOperation("云切作业删除")
   public ResultVO deleteMesBuildingCloudcutJob(@RequestBody List<Long> idList) {
      log.info("API 调用 ：云切作业删除，参数：{}", idList);
      return ResultBuilder.success(this.mesBuildingCloudcutJobService.deleteMesBuildingCloudcutJob(idList));
   }

   @GetMapping("/teamList")
   @ApiOperation("云切作业班组列表")
   public ResultVO teamList() {
      return ResultBuilder.success(this.mesBuildingCloudcutJobService.teamList());
   }

   public MesBuildingCloudcutJobController(final MesBuildingCloudcutJobService mesBuildingCloudcutJobService) {
      this.mesBuildingCloudcutJobService = mesBuildingCloudcutJobService;
   }
}
