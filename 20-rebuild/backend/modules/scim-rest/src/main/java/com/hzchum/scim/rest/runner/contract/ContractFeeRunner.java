package com.hzchum.scim.rest.runner.contract;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.AuditTypeEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractTestingFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageFee;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWaterElectricityPropertyFee;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractTestingFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageFeeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWaterElectricityPropertyFeeService;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ContractFeeRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ContractFeeRunner.class);
   private final InitializationService initializationService;
   private final ContractTestingFeeService testingFeeService;
   private final ContractReimbursementFeeService reimbursementFeeService;
   private final ContractWageFeeService wageFeeService;
   private final ContractWaterElectricityPropertyFeeService waterElectricityPropertyFeeService;
   private final ContractAuditLedgerService auditLedgerService;
   private final UserService userService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      String datasource = this.initializationService.selectSql("SELECT DATABASE()").get(0);
      Map<Integer, Map<Long, ContractAuditLedger>> paymentEnumPaymentIdAuditMap = this.auditLedgerService
         .list(Wrappers.lambdaQuery(ContractAuditLedger.class).eq(ContractAuditLedger::getAuditType, AuditTypeEnum.EXPENSE_ENTRY_APPROVE.getType()))
         .stream()
         .collect(Collectors.groupingBy(ContractAuditLedger::getPaymentEnum, Collectors.toMap(s -> Long.valueOf(s.getPaymentId()), Function.identity())));
      List<String> columnList = this.initializationService
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='contract_testing_fee' AND TABLE_SCHEMA ='" + datasource + "'");
      if (columnList.contains("bool_confirm_status")) {
         this.initializationService.updateSql("ALTER TABLE contract_testing_fee DROP COLUMN bool_confirm_status;");
      }

      Map<Long, ContractAuditLedger> paymentIdAuditLedgerMap = paymentEnumPaymentIdAuditMap.getOrDefault(
         AuditPaymentEnum.TESTING_FEE.getType(), Collections.emptyMap()
      );
      List<ContractTestingFee> testingFeeList = this.testingFeeService
         .list(
            Wrappers.lambdaQuery(ContractTestingFee.class)
               .notIn(CollectionUtils.isNotEmpty(paymentIdAuditLedgerMap), ContractTestingFee::getId, paymentIdAuditLedgerMap.keySet())
         );
      if (CollectionUtils.isNotEmpty(testingFeeList)) {
         List<Long> userIds = testingFeeList.stream().map(ContractTestingFee::getUserId).collect(Collectors.toList());
         Map<Long, User> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));
         testingFeeList.forEach(fee -> {
            fee.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
            fee.setAuditorId(fee.getUserId());
            fee.setAuditorName(userMap.containsKey(fee.getUserId()) ? userMap.get(fee.getUserId()).getName() : null);
            fee.setAuditTime(fee.getCreateTime());
         });
         this.testingFeeService.updateBatchById(testingFeeList);
      }

      paymentIdAuditLedgerMap = paymentEnumPaymentIdAuditMap.getOrDefault(AuditPaymentEnum.WATER_ELECTRICITY_FEE.getType(), Collections.emptyMap());
      List<ContractWaterElectricityPropertyFee> waterElectricityFeeList = this.waterElectricityPropertyFeeService
         .list(
            Wrappers.lambdaQuery(ContractWaterElectricityPropertyFee.class)
               .notIn(CollectionUtils.isNotEmpty(paymentIdAuditLedgerMap), ContractWaterElectricityPropertyFee::getId, paymentIdAuditLedgerMap.keySet())
         );
      if (CollectionUtils.isNotEmpty(waterElectricityFeeList)) {
         List<Long> userIds = waterElectricityFeeList.stream().map(ContractWaterElectricityPropertyFee::getUserId).collect(Collectors.toList());
         Map<Long, User> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));
         waterElectricityFeeList.forEach(fee -> {
            fee.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
            fee.setAuditorId(fee.getUserId());
            fee.setAuditorName(userMap.containsKey(fee.getUserId()) ? userMap.get(fee.getUserId()).getName() : null);
            fee.setAuditTime(fee.getCreateTime());
         });
         this.waterElectricityPropertyFeeService.updateBatchById(waterElectricityFeeList);
      }

      paymentIdAuditLedgerMap = paymentEnumPaymentIdAuditMap.getOrDefault(AuditPaymentEnum.STAFF_WAGE.getType(), Collections.emptyMap());
      List<ContractWageFee> wageFeeList = this.wageFeeService
         .list(
            Wrappers.lambdaQuery(ContractWageFee.class)
               .notIn(CollectionUtils.isNotEmpty(paymentIdAuditLedgerMap), ContractWageFee::getId, paymentIdAuditLedgerMap.keySet())
         );
      if (CollectionUtils.isNotEmpty(wageFeeList)) {
         List<Long> userIds = wageFeeList.stream().map(ContractWageFee::getFounderId).collect(Collectors.toList());
         Map<Long, User> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));
         wageFeeList.forEach(fee -> {
            fee.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
            fee.setAuditorId(fee.getFounderId());
            fee.setAuditorName(userMap.containsKey(fee.getFounderId()) ? userMap.get(fee.getFounderId()).getName() : null);
            fee.setAuditTime(fee.getCreateTime());
         });
         this.wageFeeService.updateBatchById(wageFeeList);
      }

      List<ContractReimbursementFee> reimbursementFeeList = this.reimbursementFeeService.list();
      if (CollectionUtils.isNotEmpty(reimbursementFeeList)) {
         Map<Long, ContractAuditLedger> reimbursementIdAuditLedgerMap = paymentEnumPaymentIdAuditMap.getOrDefault(
            AuditPaymentEnum.REIMBURSEMENT_FEE.getType(), Collections.emptyMap()
         );
         List<Long> userIds = reimbursementFeeList.stream().map(ContractReimbursementFee::getWrittenById).collect(Collectors.toList());
         Map<Long, User> userMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));
         reimbursementFeeList.forEach(
            reimbursementFee -> {
               ContractAuditLedger auditLedger = reimbursementIdAuditLedgerMap.get(reimbursementFee.getId());
               if (auditLedger == null || !auditLedger.getAuditStatusEnum().equals(reimbursementFee.getAuditStatusEnum())) {
                  reimbursementFee.setAuditStatusEnum(auditLedger == null ? AuditStatusEnum.SUCCEED.getType() : auditLedger.getAuditStatusEnum());
                  reimbursementFee.setAuditorId(reimbursementFee.getWrittenById());
                  reimbursementFee.setAuditorName(
                     userMap.containsKey(reimbursementFee.getWrittenById()) ? userMap.get(reimbursementFee.getWrittenById()).getName() : null
                  );
                  reimbursementFee.setAuditTime(reimbursementFee.getCreateTime());
               }
            }
         );
         this.reimbursementFeeService.updateBatchById(reimbursementFeeList);
      }
   }

   public ContractFeeRunner(
      final InitializationService initializationService,
      final ContractTestingFeeService testingFeeService,
      final ContractReimbursementFeeService reimbursementFeeService,
      final ContractWageFeeService wageFeeService,
      final ContractWaterElectricityPropertyFeeService waterElectricityPropertyFeeService,
      final ContractAuditLedgerService auditLedgerService,
      final UserService userService
   ) {
      this.initializationService = initializationService;
      this.testingFeeService = testingFeeService;
      this.reimbursementFeeService = reimbursementFeeService;
      this.wageFeeService = wageFeeService;
      this.waterElectricityPropertyFeeService = waterElectricityPropertyFeeService;
      this.auditLedgerService = auditLedgerService;
      this.userService = userService;
   }
}
