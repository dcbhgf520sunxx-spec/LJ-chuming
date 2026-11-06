package com.hzchum.scim.rest.controller.bid;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.UpdateBatch;
import com.hzchum.scim.bid.core.api.biz.ProjectTenderingBiz;
import com.hzchum.scim.bid.core.api.enums.MenuEnum;
import com.hzchum.scim.bid.core.api.enums.OperationCheckEnum;
import com.hzchum.scim.bid.core.api.enums.OperationOuThErEnum;
import com.hzchum.scim.bid.core.api.pojo.dto.EvaluationBidDTO;
import com.hzchum.scim.bid.core.api.pojo.dto.ProjectTenderingDTO;
import com.hzchum.scim.bid.core.api.pojo.dto.TendQueryConditionsDTO;
import com.hzchum.scim.bid.core.api.service.ProjectTenderingService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAsync
@RequestMapping("/api/bidding/tendering")
@Api(tags = "招采-招标项目API")
public class ProjectTenderingApi {
   private static final Logger log = LoggerFactory.getLogger(ProjectTenderingApi.class);
   @Resource
   private ProjectTenderingService projectTenderingService;
   @Resource
   private ProjectTenderingBiz projectTenderingBiz;

   @PostMapping("/save")
   @PreAuthorize("@permission.check('createList:add')")
   public ResultVO save(@Validated(Add.class) @RequestBody ProjectTenderingDTO projectTenderingDTO) {
      log.info("API 调用 : 新增招标项目信息");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未传入用户信息token");
      return ResultBuilder.success(this.projectTenderingService.saveInstance(projectTenderingDTO));
   }

   @GetMapping("/all")
   @PreAuthorize("@permission.check('createList:get')")
   public ResultVO getPageAll(
      TendQueryConditionsDTO dto,
      @RequestParam(required = false, defaultValue = "0") @EnumValidator(value = MenuEnum.class, message = "类型不正确") Integer menu,
      @RequestParam(name = "sort[]", required = false) List<String> sort,
      @RequestParam(required = false, defaultValue = "1") Integer page,
      @RequestParam(required = false, defaultValue = "10") Integer size
   ) {
      log.info("API 调用 : 查询所有招采项目信息");
      return ResultBuilder.success(this.projectTenderingService.getPageAll(dto, page, size, sort, menu));
   }

   @GetMapping("/detail/{id}")
   @PreAuthorize("@permission.check('createList:getDetail')")
   public ResultVO getDetail(@PathVariable Long id) {
      log.info("API 调用 : 查询指定招采项目信息");
      return ResultBuilder.success(this.projectTenderingBiz.getDetail(id));
   }

   @GetMapping("/material/detail/export/{id}")
   @PreAuthorize("@permission.check('createList:export')")
   public void projectDetailExport(@PathVariable Long id, HttpServletResponse response) throws IOException {
      log.info("Api 调用 : 招标项目基础信息详情下载");
      this.projectTenderingBiz.projectDetailExport(id, response);
   }

   @GetMapping("/material/project/export/{id}")
   @PreAuthorize("@permission.check('createList:export')")
   public void projectExport(@PathVariable Long id, HttpServletResponse response) throws IOException {
      log.info("Api 调用 : 招标项目投标详情下载");
      this.projectTenderingBiz.projectExport(id, response);
   }

   @PutMapping("/update")
   @PreAuthorize("@permission.check('createList:edit')")
   public ResultVO updateProject(@Validated(UpdateBatch.class) @RequestBody ProjectTenderingDTO projectTenderingDTO) {
      log.info("API 调用 : 修改项目信息");
      return ResultBuilder.success(this.projectTenderingService.updateProject(projectTenderingDTO));
   }

   @PutMapping("/projectProgress")
   @PreAuthorize("@permission.check('createList:editProgress')")
   public ResultVO projectProgress(
      @RequestParam Long id,
      @RequestParam(required = false) Long bidDeadline,
      @RequestParam(required = false) Long bidOpeningTime,
      @RequestParam @EnumValidator(value = OperationOuThErEnum.class, message = "类型不正确") Integer projectProgress
   ) {
      log.info("API 调用 : 修改招采项目进度");
      return ResultBuilder.success(this.projectTenderingService.checkProjectProgress(id, projectProgress, bidDeadline, bidOpeningTime));
   }

   @PutMapping("/check")
   @PreAuthorize("@permission.check('createList:editAgreeIt')")
   public ResultVO checkProject(@RequestParam Long id, @RequestParam @EnumValidator(value = OperationCheckEnum.class, message = "类型不正确") Integer status) {
      log.info("API 调用 : 审核招采项目");

      Integer update;
      try {
         Future future = this.projectTenderingService.checkProject(id, status);
         update = (Integer)future.get();
      } catch (ExecutionException | InterruptedException e) {
         e.printStackTrace();
         throw new IllegalArgumentException(e.getMessage());
      }

      return ResultBuilder.success(update);
   }

   @PutMapping("/modify/time")
   @PreAuthorize("@permission.check('createList:editTime')")
   public ResultVO modifyTime(@RequestParam Long id, @RequestParam Long bidDeadline, @RequestParam Long bidOpeningTime) {
      log.info("API 调用 : 修改投标截止时间和开标时间");
      return ResultBuilder.success(this.projectTenderingService.modifyTime(id, bidDeadline, bidOpeningTime));
   }

   @PostMapping("/save/supplier")
   @PreAuthorize("@permission.check('createList:editSupplier')")
   public ResultVO saveSupplier(@RequestParam Long id, @RequestBody List<Long> ids) {
      log.info("API 调用 : 邀请供应商");

      Boolean bool;
      try {
         Future future = this.projectTenderingBiz.saveSupplier(id, ids);
         bool = (Boolean)future.get();
      } catch (ExecutionException | InterruptedException e) {
         e.printStackTrace();
         throw new IllegalArgumentException(e.getMessage());
      }

      return ResultBuilder.success(bool);
   }

   @GetMapping("/get/manually/{id}")
   @PreAuthorize("@permission.check('createList:getDetail')")
   public ResultVO getManually(@PathVariable Long id) {
      log.info("API 调用 : 应标/投标详情");
      return ResultBuilder.success(this.projectTenderingBiz.getManually(id));
   }

   @GetMapping("/evaluation/{id}")
   @PreAuthorize("@permission.check('createList:getDetail')")
   public ResultVO getEvaluation(@PathVariable Long id) {
      log.info("API 调用 : 开标详情");
      return ResultBuilder.success(this.projectTenderingBiz.getEvaluation(id));
   }

   @GetMapping("/detail/supplier")
   @PreAuthorize("@permission.check('createList:getDetail')")
   public ResultVO getDetailSupplier(@RequestParam Long id, @RequestParam Long supplierId) {
      log.info("API 调用 : 查询(邀请/投标)的供应商详情");
      return ResultBuilder.success(this.projectTenderingBiz.getDetailSupplier(id, supplierId));
   }

   @PutMapping("/evaluation/bid")
   @PreAuthorize("@permission.check('createList:editBid')")
   public ResultVO evaluationBid(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long bidDeadline,
      @RequestParam(required = false) Long bidOpeningTime,
      @RequestBody List<EvaluationBidDTO> evaluationBidDTOS
   ) {
      log.info("API 调用 : 评标");

      Boolean bool;
      try {
         Future future = this.projectTenderingBiz.evaluationBid(projectId, bidDeadline, bidOpeningTime, evaluationBidDTOS);
         bool = (Boolean)future.get();
      } catch (ExecutionException | InterruptedException e) {
         e.printStackTrace();
         throw new IllegalArgumentException(e.getMessage());
      }

      return ResultBuilder.success(bool);
   }

   @GetMapping("/all/overview")
   @PreAuthorize("@permission.check('createList:getAll')")
   public ResultVO getOverview(@RequestParam(required = false) Long startTime, @RequestParam(required = false) Long endTime) {
      log.info("API 调用 : 招采总览(项目类型)");
      return ResultBuilder.success(this.projectTenderingService.getOverview(startTime, endTime));
   }

   @GetMapping("/bid/type")
   @PreAuthorize("@permission.check('createList:getAll')")
   public ResultVO getBidType(
      @RequestParam(required = false) Long projectType, @RequestParam(required = false) Long startTime, @RequestParam(required = false) Long endTime
   ) {
      log.info("API 调用 : 招采总览(招标方式)");
      return ResultBuilder.success(this.projectTenderingService.getBidType(startTime, endTime, projectType));
   }
}
