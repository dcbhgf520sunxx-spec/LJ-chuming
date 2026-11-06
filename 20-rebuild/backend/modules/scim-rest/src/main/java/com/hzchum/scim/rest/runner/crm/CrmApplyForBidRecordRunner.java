package com.hzchum.scim.rest.runner.crm;

import com.hzchum.scim.crm.core.api.biz.CrmApplyBusinessBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyDeepDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyStructuralDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyTechnologyBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(99)
@Component
public class CrmApplyForBidRecordRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(CrmApplyForBidRecordRunner.class);
   @Resource
   private CrmApplyBusinessBiddingRecordBiz crmApplyBusinessBiddingRecordBiz;
   @Resource
   private CrmApplyTechnologyBiddingRecordBiz crmApplyTechnologyBiddingRecordBiz;
   @Resource
   private CrmApplyDeepDesignBiddingRecordBiz crmApplyDeepDesignBiddingRecordBiz;
   @Resource
   private CrmApplyStructuralDesignBiddingRecordBiz crmApplyStructuralDesignBiddingRecordBiz;
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;

   @Override
   public void run(String... args) throws Exception {
   }

   public CrmApplyForBidRecordRunner(
      final CrmApplyBusinessBiddingRecordBiz crmApplyBusinessBiddingRecordBiz,
      final CrmApplyTechnologyBiddingRecordBiz crmApplyTechnologyBiddingRecordBiz,
      final CrmApplyDeepDesignBiddingRecordBiz crmApplyDeepDesignBiddingRecordBiz,
      final CrmApplyStructuralDesignBiddingRecordBiz crmApplyStructuralDesignBiddingRecordBiz,
      final CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz
   ) {
      this.crmApplyBusinessBiddingRecordBiz = crmApplyBusinessBiddingRecordBiz;
      this.crmApplyTechnologyBiddingRecordBiz = crmApplyTechnologyBiddingRecordBiz;
      this.crmApplyDeepDesignBiddingRecordBiz = crmApplyDeepDesignBiddingRecordBiz;
      this.crmApplyStructuralDesignBiddingRecordBiz = crmApplyStructuralDesignBiddingRecordBiz;
      this.crmProjectInformationWarehousingBiz = crmProjectInformationWarehousingBiz;
   }
}
