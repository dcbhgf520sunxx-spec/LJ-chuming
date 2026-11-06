package com.hzchum.scim.rest.controller.bid;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.bid.core.api.service.BiddingSupplierService;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bidding/common")
@EnableAsync
public class CommonProjectApi {
   private static final Logger log = LoggerFactory.getLogger(CommonProjectApi.class);
   private final BiddingSupplierService biddingSupplierService;

   @GetMapping("/query")
   @PreAuthorize("@permission.check('supplier:get')")
   public ResultVO getSupplierList(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String socialCreditCode,
      @RequestParam(required = false) Set<Long> subjectIds,
      @RequestParam(required = false) Set<Long> regionIds,
      @RequestParam(required = false, defaultValue = "1") Boolean boolEnableEnum,
      @RequestParam(required = false, defaultValue = "1") Integer page,
      @RequestParam(required = false, defaultValue = "10") Integer size
   ) {
      log.info("API 调用 : 查询已入驻(未添加)的供应商");
      return ResultBuilder.success(this.biddingSupplierService.getSupplierList(name, socialCreditCode, subjectIds, regionIds, boolEnableEnum, page, size));
   }

   public CommonProjectApi(final BiddingSupplierService biddingSupplierService) {
      this.biddingSupplierService = biddingSupplierService;
   }
}
