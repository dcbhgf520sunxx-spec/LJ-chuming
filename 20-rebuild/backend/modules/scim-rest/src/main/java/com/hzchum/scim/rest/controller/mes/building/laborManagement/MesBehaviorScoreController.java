package com.hzchum.scim.rest.controller.mes.building.laborManagement;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.laborManagement.MesBehaviorScoreBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesBehaviorScoreQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesBehaviorTotalScoreParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES-劳务管理-行为计分")
@RequestMapping("/api/mes/building/labor-management/behavior-score")
@RestController
public class MesBehaviorScoreController {
   private static final Logger log = LoggerFactory.getLogger(MesBehaviorScoreController.class);
   @Autowired
   private MesBehaviorScoreBiz behaviorScoreBiz;

   @ApiOperation("分页查询")
   @GetMapping("page")
   public ResultVO pageInfo(
      MesBehaviorScoreQuery query,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false, defaultValue = "entryDate.asc") List<String> sort
   ) {
      log.info("API 调用 ：行为计分-分页查询");
      return ResultBuilder.success(this.behaviorScoreBiz.pageInfo(query, pageNumber, pageSize, sort));
   }

   @ApiOperation("行为总分查看")
   @GetMapping("behavior-total-score-info")
   public ResultVO behaviorTotalScoreInfo(@RequestParam(required = false) Integer year) {
      log.info("API 调用 ：行为计分-行为总分查看");
      return ResultBuilder.success(this.behaviorScoreBiz.behaviorTotalScoreInfo(year));
   }

   @ApiOperation("保存行为总分")
   @PostMapping("save-behavior-total-score")
   public ResultVO saveBehaviorTotalScore(@RequestBody MesBehaviorTotalScoreParam param) {
      log.info("API 调用 ：行为计分-保存行为总分");
      return ResultBuilder.success(this.behaviorScoreBiz.saveOrUpdateBehaviorTotalScore(param));
   }

   @ApiOperation("设置员工行为总分")
   @PutMapping("set-employee-behavior-total-score")
   public ResultVO setEmployeeBehaviorTotalScore(@RequestParam Long rosterId, @RequestParam Integer behaviorTotalScore) {
      log.info("API 调用 ：行为计分-设置员工行为总分");
      return ResultBuilder.success(this.behaviorScoreBiz.setEmployeeBehaviorTotalScore(rosterId, behaviorTotalScore));
   }

   @ApiOperation("违章记录")
   @GetMapping("violation-record")
   public ResultVO violationRecord(@RequestParam Long userId, @RequestParam Integer year) {
      log.info("API 调用 ：行为计分-违章记录");
      return ResultBuilder.success(this.behaviorScoreBiz.violationRecord(userId, year));
   }

   @ApiOperation("违章记录打印")
   @GetMapping("violation-record/print")
   public ResultVO violationRecordPrint(@RequestParam Long userId, @RequestParam Integer year) {
      log.info("API 调用 ：行为计分-违章记录打印");
      return ResultBuilder.success(this.behaviorScoreBiz.violationRecordPrint(userId, year));
   }
}
