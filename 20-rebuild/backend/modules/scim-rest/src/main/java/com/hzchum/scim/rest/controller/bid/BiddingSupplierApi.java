package com.hzchum.scim.rest.controller.bid;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.bid.core.api.enums.CommonEnum;
import com.hzchum.scim.bid.core.api.pojo.dto.BiddingSupplierDTO;
import com.hzchum.scim.bid.core.api.service.BiddingSupplierService;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bidding/supplier")
public class BiddingSupplierApi {
   private static final Logger log = LoggerFactory.getLogger(BiddingSupplierApi.class);
   @Resource
   private BiddingSupplierService biddingSupplierService;

   @PostMapping("/save")
   @PreAuthorize("@permission.check('supplier:add')")
   public ResultVO saveSupplier(@Validated(Add.class) @RequestBody ValidList<BiddingSupplierDTO> supplierDTOS) {
      log.info("API 调用 : 批量新增招标供应商");
      return ResultBuilder.success(this.biddingSupplierService.saveSupplier(supplierDTOS));
   }

   @GetMapping("/query/supplier")
   @PreAuthorize("@permission.check('supplier:get')")
   public ResultVO querySupplier(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String code,
      @RequestParam(required = false) Set<Long> subjectIds,
      @RequestParam(required = false) Set<Long> regionIds,
      @RequestParam @EnumValidator(value = CommonEnum.class, message = "类型不正确") Integer black,
      @RequestParam(required = false, defaultValue = "1") Integer page,
      @RequestParam(required = false, defaultValue = "10") Integer size
   ) {
      log.info("API 调用 : 查询我的供应商列表");
      return ResultBuilder.success(this.biddingSupplierService.querySupplier(name, code, subjectIds, regionIds, black, page, size));
   }

   @GetMapping("/invite/supplier")
   @PreAuthorize("@permission.check('supplier:get')")
   public ResultVO getInvite(@RequestParam Set<Long> subjectIds) {
      log.info("API 调用 : 查询可邀请的供应商");
      return ResultBuilder.success(this.biddingSupplierService.getInvite(subjectIds));
   }

   @GetMapping("/detail/{id}")
   @PreAuthorize("@permission.check('supplier:detail')")
   public ResultVO getDetail(@PathVariable Long id) {
      log.info("API 调用 : 查询指定供应商详情");
      return ResultBuilder.success(this.biddingSupplierService.getDetail(id));
   }

   @DeleteMapping
   @PreAuthorize("@permission.check('supplier:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API调用-批量删除供应商");
      return ResultBuilder.success(this.biddingSupplierService.deleteSupplier(ids));
   }

   @PostMapping("/update/black")
   @PreAuthorize("@permission.check('supplier:black')")
   public ResultVO update(@RequestBody List<Long> ids, @RequestParam @EnumValidator(value = CommonEnum.class, message = "类型不正确") Integer black) {
      log.info("API调用-批量设置黑名单");
      return ResultBuilder.success(this.biddingSupplierService.setBlacklist(ids, black));
   }

   @GetMapping("/supplier/{id}")
   @PreAuthorize("@permission.check('supplier:get')")
   public ResultVO getSupplier(@PathVariable Long id) {
      log.info("API 调用 : 查询我的供应商列表(未邀请/未投标)");
      return ResultBuilder.success(this.biddingSupplierService.getSupplier(id));
   }
}
