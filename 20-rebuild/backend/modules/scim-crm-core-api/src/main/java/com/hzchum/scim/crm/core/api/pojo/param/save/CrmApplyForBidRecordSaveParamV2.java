package com.hzchum.scim.crm.core.api.pojo.param.save;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CrmApplyForBidRecordSaveParamV2 {
   @ApiModelProperty(name = "informantUserId", value = "填报人id", notes = "填报人id")
   private Long informantUserId;
   @ApiModelProperty(name = "departmentId", value = "所属部门", notes = "所属部门")
   private Long departmentId;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   private Long createUserId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "biddingMethodId", value = "招标方式id", notes = "招标方式id")
   private Long biddingMethodId;
   @ApiModelProperty(name = "crmBiddingRegulationsTypeEnum", value = "招标规定枚举", notes = "招标规定枚举")
   private Integer crmBiddingRegulationsTypeEnum;
   @ApiModelProperty(name = "tenderSubmissionMethodId", value = "标书提交方式", notes = "标书提交方式")
   private Long tenderSubmissionMethodId;
   @ApiModelProperty(name = "bidExpirationDate", value = "投标截至日期", notes = "投标截至日期")
   private LocalDateTime bidExpirationDate;
   @ApiModelProperty(name = "bidOpeningDate", value = "开标日期", notes = "开标日期")
   private LocalDateTime bidOpeningDate;
   @ApiModelProperty(name = "bidEvaluationMethodId", value = "评标方式", notes = "评标方式")
   private Long bidEvaluationMethodId;
   @ApiModelProperty(name = "isControlledBiddingPrice", value = "有无招标控制价", notes = "有无招标控制价")
   private Boolean isControlledBiddingPrice;
   @ApiModelProperty(name = "controlledBiddingPrice", value = "招标控制价", notes = "招标控制价")
   private BigDecimal controlledBiddingPrice;
   @ApiModelProperty(name = "settlementMethodId", value = "结算方式", notes = "结算方式")
   private Long settlementMethodId;
   @ApiModelProperty(name = "isTenderBond", value = "有无投标保证金", notes = "有无投标保证金")
   private Boolean isTenderBond;
   @ApiModelProperty(name = "tenderBond", value = "投标保证金(万元)", notes = "投标保证金(万元)")
   private BigDecimal tenderBond;
   @ApiModelProperty(name = "tenderBondDeadline", value = "投标保证金截止日", notes = "投标保证金截止日")
   private LocalDateTime tenderBondDeadline;
   @ApiModelProperty(name = "companyName", value = "单位名称", notes = "单位名称")
   private String companyName;
   @ApiModelProperty(name = "depositBank", value = "开户行", notes = "开户行")
   private String depositBank;
   @ApiModelProperty(name = "account", value = "银行账号", notes = "银行账号")
   private String account;
   @ApiModelProperty(name = "isCashDeposit", value = "是否履约保证金", notes = "是否履约保证金")
   private Boolean isCashDeposit;
   @ApiModelProperty(name = "cashDeposit", value = "履约保证金金额", notes = "履约保证金金额")
   private BigDecimal cashDeposit;
   @ApiModelProperty(name = "typeOfPerformanceBondId", value = "履约保证金类型", notes = "履约保证金类型")
   private Long typeOfPerformanceBondId;
   @ApiModelProperty(name = "warrantyRatio", value = "保修比例", notes = "保修比例")
   private String warrantyRatio;
   @ApiModelProperty(name = "warrantyRatio", value = "保修期限", notes = "保修期限")
   private String warrantyDate;
   @ApiModelProperty(name = "startDate", value = "计划开工日期", notes = "计划开工日期")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "计划完工日期", notes = "计划完工日期")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "isMaterialAdjustment", value = "是否材料调差", notes = "是否材料调差")
   private Boolean isMaterialAdjustment;
   @ApiModelProperty(name = "materialAdjustment", value = "材料调差", notes = "材料调差")
   private String materialAdjustment;
   @ApiModelProperty(name = "materialBrandRegulations", value = "材料品牌规定", notes = "材料品牌规定")
   private String materialBrandRegulations;
   @ApiModelProperty(name = "isSpecialRulesForMaterials", value = "是否材料特殊规定", notes = "是否材料特殊规定")
   private Boolean isSpecialRulesForMaterials;
   @ApiModelProperty(name = "specialRulesForMaterials", value = "材料特殊规定", notes = "材料特殊规定")
   private String specialRulesForMaterials;
   @ApiModelProperty(name = "isOfferSample", value = "是否提供样品", notes = "是否提供样品")
   private Boolean isOfferSample;
   @ApiModelProperty(name = "offerSample", value = "样品", notes = "样品")
   private String offerSample;
   @ApiModelProperty(name = "paymentMethod", value = "付款方式", notes = "付款方式")
   private String paymentMethod;
   @ApiModelProperty(name = "tenderRequirement", value = "标书类型  参考CrmTenderRequirementTypeEnum", notes = "标书类型")
   private List<Integer> tenderRequirement;
   @ApiModelProperty(name = "attachmentIds", value = "附件id集合", notes = "附件id集合")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public Long getBiddingMethodId() {
      return this.biddingMethodId;
   }

   public Integer getCrmBiddingRegulationsTypeEnum() {
      return this.crmBiddingRegulationsTypeEnum;
   }

   public Long getTenderSubmissionMethodId() {
      return this.tenderSubmissionMethodId;
   }

   public LocalDateTime getBidExpirationDate() {
      return this.bidExpirationDate;
   }

   public LocalDateTime getBidOpeningDate() {
      return this.bidOpeningDate;
   }

   public Long getBidEvaluationMethodId() {
      return this.bidEvaluationMethodId;
   }

   public Boolean getIsControlledBiddingPrice() {
      return this.isControlledBiddingPrice;
   }

   public BigDecimal getControlledBiddingPrice() {
      return this.controlledBiddingPrice;
   }

   public Long getSettlementMethodId() {
      return this.settlementMethodId;
   }

   public Boolean getIsTenderBond() {
      return this.isTenderBond;
   }

   public BigDecimal getTenderBond() {
      return this.tenderBond;
   }

   public LocalDateTime getTenderBondDeadline() {
      return this.tenderBondDeadline;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getDepositBank() {
      return this.depositBank;
   }

   public String getAccount() {
      return this.account;
   }

   public Boolean getIsCashDeposit() {
      return this.isCashDeposit;
   }

   public BigDecimal getCashDeposit() {
      return this.cashDeposit;
   }

   public Long getTypeOfPerformanceBondId() {
      return this.typeOfPerformanceBondId;
   }

   public String getWarrantyRatio() {
      return this.warrantyRatio;
   }

   public String getWarrantyDate() {
      return this.warrantyDate;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public Boolean getIsMaterialAdjustment() {
      return this.isMaterialAdjustment;
   }

   public String getMaterialAdjustment() {
      return this.materialAdjustment;
   }

   public String getMaterialBrandRegulations() {
      return this.materialBrandRegulations;
   }

   public Boolean getIsSpecialRulesForMaterials() {
      return this.isSpecialRulesForMaterials;
   }

   public String getSpecialRulesForMaterials() {
      return this.specialRulesForMaterials;
   }

   public Boolean getIsOfferSample() {
      return this.isOfferSample;
   }

   public String getOfferSample() {
      return this.offerSample;
   }

   public String getPaymentMethod() {
      return this.paymentMethod;
   }

   public List<Integer> getTenderRequirement() {
      return this.tenderRequirement;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
   }

   public void setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
   }

   public void setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public void setBiddingMethodId(final Long biddingMethodId) {
      this.biddingMethodId = biddingMethodId;
   }

   public void setCrmBiddingRegulationsTypeEnum(final Integer crmBiddingRegulationsTypeEnum) {
      this.crmBiddingRegulationsTypeEnum = crmBiddingRegulationsTypeEnum;
   }

   public void setTenderSubmissionMethodId(final Long tenderSubmissionMethodId) {
      this.tenderSubmissionMethodId = tenderSubmissionMethodId;
   }

   public void setBidExpirationDate(final LocalDateTime bidExpirationDate) {
      this.bidExpirationDate = bidExpirationDate;
   }

   public void setBidOpeningDate(final LocalDateTime bidOpeningDate) {
      this.bidOpeningDate = bidOpeningDate;
   }

   public void setBidEvaluationMethodId(final Long bidEvaluationMethodId) {
      this.bidEvaluationMethodId = bidEvaluationMethodId;
   }

   public void setIsControlledBiddingPrice(final Boolean isControlledBiddingPrice) {
      this.isControlledBiddingPrice = isControlledBiddingPrice;
   }

   public void setControlledBiddingPrice(final BigDecimal controlledBiddingPrice) {
      this.controlledBiddingPrice = controlledBiddingPrice;
   }

   public void setSettlementMethodId(final Long settlementMethodId) {
      this.settlementMethodId = settlementMethodId;
   }

   public void setIsTenderBond(final Boolean isTenderBond) {
      this.isTenderBond = isTenderBond;
   }

   public void setTenderBond(final BigDecimal tenderBond) {
      this.tenderBond = tenderBond;
   }

   public void setTenderBondDeadline(final LocalDateTime tenderBondDeadline) {
      this.tenderBondDeadline = tenderBondDeadline;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setDepositBank(final String depositBank) {
      this.depositBank = depositBank;
   }

   public void setAccount(final String account) {
      this.account = account;
   }

   public void setIsCashDeposit(final Boolean isCashDeposit) {
      this.isCashDeposit = isCashDeposit;
   }

   public void setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
   }

   public void setTypeOfPerformanceBondId(final Long typeOfPerformanceBondId) {
      this.typeOfPerformanceBondId = typeOfPerformanceBondId;
   }

   public void setWarrantyRatio(final String warrantyRatio) {
      this.warrantyRatio = warrantyRatio;
   }

   public void setWarrantyDate(final String warrantyDate) {
      this.warrantyDate = warrantyDate;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
   }

   public void setIsMaterialAdjustment(final Boolean isMaterialAdjustment) {
      this.isMaterialAdjustment = isMaterialAdjustment;
   }

   public void setMaterialAdjustment(final String materialAdjustment) {
      this.materialAdjustment = materialAdjustment;
   }

   public void setMaterialBrandRegulations(final String materialBrandRegulations) {
      this.materialBrandRegulations = materialBrandRegulations;
   }

   public void setIsSpecialRulesForMaterials(final Boolean isSpecialRulesForMaterials) {
      this.isSpecialRulesForMaterials = isSpecialRulesForMaterials;
   }

   public void setSpecialRulesForMaterials(final String specialRulesForMaterials) {
      this.specialRulesForMaterials = specialRulesForMaterials;
   }

   public void setIsOfferSample(final Boolean isOfferSample) {
      this.isOfferSample = isOfferSample;
   }

   public void setOfferSample(final String offerSample) {
      this.offerSample = offerSample;
   }

   public void setPaymentMethod(final String paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   public void setTenderRequirement(final List<Integer> tenderRequirement) {
      this.tenderRequirement = tenderRequirement;
   }

   public void setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmApplyForBidRecordSaveParamV2)) {
         return false;
      }

      CrmApplyForBidRecordSaveParamV2 other = (CrmApplyForBidRecordSaveParamV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$informantUserId = this.getInformantUserId();
      Object other$informantUserId = other.getInformantUserId();
      if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
         Object this$departmentId = this.getDepartmentId();
         Object other$departmentId = other.getDepartmentId();
         if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
               Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
               if (this$crmProjectInformationWarehousingId == null
                  ? other$crmProjectInformationWarehousingId == null
                  : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
                  Object this$biddingMethodId = this.getBiddingMethodId();
                  Object other$biddingMethodId = other.getBiddingMethodId();
                  if (this$biddingMethodId == null ? other$biddingMethodId == null : this$biddingMethodId.equals(other$biddingMethodId)) {
                     Object this$crmBiddingRegulationsTypeEnum = this.getCrmBiddingRegulationsTypeEnum();
                     Object other$crmBiddingRegulationsTypeEnum = other.getCrmBiddingRegulationsTypeEnum();
                     if (this$crmBiddingRegulationsTypeEnum == null
                        ? other$crmBiddingRegulationsTypeEnum == null
                        : this$crmBiddingRegulationsTypeEnum.equals(other$crmBiddingRegulationsTypeEnum)) {
                        Object this$tenderSubmissionMethodId = this.getTenderSubmissionMethodId();
                        Object other$tenderSubmissionMethodId = other.getTenderSubmissionMethodId();
                        if (this$tenderSubmissionMethodId == null
                           ? other$tenderSubmissionMethodId == null
                           : this$tenderSubmissionMethodId.equals(other$tenderSubmissionMethodId)) {
                           Object this$bidEvaluationMethodId = this.getBidEvaluationMethodId();
                           Object other$bidEvaluationMethodId = other.getBidEvaluationMethodId();
                           if (this$bidEvaluationMethodId == null
                              ? other$bidEvaluationMethodId == null
                              : this$bidEvaluationMethodId.equals(other$bidEvaluationMethodId)) {
                              Object this$isControlledBiddingPrice = this.getIsControlledBiddingPrice();
                              Object other$isControlledBiddingPrice = other.getIsControlledBiddingPrice();
                              if (this$isControlledBiddingPrice == null
                                 ? other$isControlledBiddingPrice == null
                                 : this$isControlledBiddingPrice.equals(other$isControlledBiddingPrice)) {
                                 Object this$settlementMethodId = this.getSettlementMethodId();
                                 Object other$settlementMethodId = other.getSettlementMethodId();
                                 if (this$settlementMethodId == null
                                    ? other$settlementMethodId == null
                                    : this$settlementMethodId.equals(other$settlementMethodId)) {
                                    Object this$isTenderBond = this.getIsTenderBond();
                                    Object other$isTenderBond = other.getIsTenderBond();
                                    if (this$isTenderBond == null ? other$isTenderBond == null : this$isTenderBond.equals(other$isTenderBond)) {
                                       Object this$isCashDeposit = this.getIsCashDeposit();
                                       Object other$isCashDeposit = other.getIsCashDeposit();
                                       if (this$isCashDeposit == null ? other$isCashDeposit == null : this$isCashDeposit.equals(other$isCashDeposit)) {
                                          Object this$typeOfPerformanceBondId = this.getTypeOfPerformanceBondId();
                                          Object other$typeOfPerformanceBondId = other.getTypeOfPerformanceBondId();
                                          if (this$typeOfPerformanceBondId == null
                                             ? other$typeOfPerformanceBondId == null
                                             : this$typeOfPerformanceBondId.equals(other$typeOfPerformanceBondId)) {
                                             Object this$isMaterialAdjustment = this.getIsMaterialAdjustment();
                                             Object other$isMaterialAdjustment = other.getIsMaterialAdjustment();
                                             if (this$isMaterialAdjustment == null
                                                ? other$isMaterialAdjustment == null
                                                : this$isMaterialAdjustment.equals(other$isMaterialAdjustment)) {
                                                Object this$isSpecialRulesForMaterials = this.getIsSpecialRulesForMaterials();
                                                Object other$isSpecialRulesForMaterials = other.getIsSpecialRulesForMaterials();
                                                if (this$isSpecialRulesForMaterials == null
                                                   ? other$isSpecialRulesForMaterials == null
                                                   : this$isSpecialRulesForMaterials.equals(other$isSpecialRulesForMaterials)) {
                                                   Object this$isOfferSample = this.getIsOfferSample();
                                                   Object other$isOfferSample = other.getIsOfferSample();
                                                   if (this$isOfferSample == null
                                                      ? other$isOfferSample == null
                                                      : this$isOfferSample.equals(other$isOfferSample)) {
                                                      Object this$informantDateTime = this.getInformantDateTime();
                                                      Object other$informantDateTime = other.getInformantDateTime();
                                                      if (this$informantDateTime == null
                                                         ? other$informantDateTime == null
                                                         : this$informantDateTime.equals(other$informantDateTime)) {
                                                         Object this$bidExpirationDate = this.getBidExpirationDate();
                                                         Object other$bidExpirationDate = other.getBidExpirationDate();
                                                         if (this$bidExpirationDate == null
                                                            ? other$bidExpirationDate == null
                                                            : this$bidExpirationDate.equals(other$bidExpirationDate)) {
                                                            Object this$bidOpeningDate = this.getBidOpeningDate();
                                                            Object other$bidOpeningDate = other.getBidOpeningDate();
                                                            if (this$bidOpeningDate == null
                                                               ? other$bidOpeningDate == null
                                                               : this$bidOpeningDate.equals(other$bidOpeningDate)) {
                                                               Object this$controlledBiddingPrice = this.getControlledBiddingPrice();
                                                               Object other$controlledBiddingPrice = other.getControlledBiddingPrice();
                                                               if (this$controlledBiddingPrice == null
                                                                  ? other$controlledBiddingPrice == null
                                                                  : this$controlledBiddingPrice.equals(other$controlledBiddingPrice)) {
                                                                  Object this$tenderBond = this.getTenderBond();
                                                                  Object other$tenderBond = other.getTenderBond();
                                                                  if (this$tenderBond == null
                                                                     ? other$tenderBond == null
                                                                     : this$tenderBond.equals(other$tenderBond)) {
                                                                     Object this$tenderBondDeadline = this.getTenderBondDeadline();
                                                                     Object other$tenderBondDeadline = other.getTenderBondDeadline();
                                                                     if (this$tenderBondDeadline == null
                                                                        ? other$tenderBondDeadline == null
                                                                        : this$tenderBondDeadline.equals(other$tenderBondDeadline)) {
                                                                        Object this$companyName = this.getCompanyName();
                                                                        Object other$companyName = other.getCompanyName();
                                                                        if (this$companyName == null
                                                                           ? other$companyName == null
                                                                           : this$companyName.equals(other$companyName)) {
                                                                           Object this$depositBank = this.getDepositBank();
                                                                           Object other$depositBank = other.getDepositBank();
                                                                           if (this$depositBank == null
                                                                              ? other$depositBank == null
                                                                              : this$depositBank.equals(other$depositBank)) {
                                                                              Object this$account = this.getAccount();
                                                                              Object other$account = other.getAccount();
                                                                              if (this$account == null
                                                                                 ? other$account == null
                                                                                 : this$account.equals(other$account)) {
                                                                                 Object this$cashDeposit = this.getCashDeposit();
                                                                                 Object other$cashDeposit = other.getCashDeposit();
                                                                                 if (this$cashDeposit == null
                                                                                    ? other$cashDeposit == null
                                                                                    : this$cashDeposit.equals(other$cashDeposit)) {
                                                                                    Object this$warrantyRatio = this.getWarrantyRatio();
                                                                                    Object other$warrantyRatio = other.getWarrantyRatio();
                                                                                    if (this$warrantyRatio == null
                                                                                       ? other$warrantyRatio == null
                                                                                       : this$warrantyRatio.equals(other$warrantyRatio)) {
                                                                                       Object this$warrantyDate = this.getWarrantyDate();
                                                                                       Object other$warrantyDate = other.getWarrantyDate();
                                                                                       if (this$warrantyDate == null
                                                                                          ? other$warrantyDate == null
                                                                                          : this$warrantyDate.equals(other$warrantyDate)) {
                                                                                          Object this$startDate = this.getStartDate();
                                                                                          Object other$startDate = other.getStartDate();
                                                                                          if (this$startDate == null
                                                                                             ? other$startDate == null
                                                                                             : this$startDate.equals(other$startDate)) {
                                                                                             Object this$endDate = this.getEndDate();
                                                                                             Object other$endDate = other.getEndDate();
                                                                                             if (this$endDate == null
                                                                                                ? other$endDate == null
                                                                                                : this$endDate.equals(other$endDate)) {
                                                                                                Object this$materialAdjustment = this.getMaterialAdjustment();
                                                                                                Object other$materialAdjustment = other.getMaterialAdjustment();
                                                                                                if (this$materialAdjustment == null
                                                                                                   ? other$materialAdjustment == null
                                                                                                   : this$materialAdjustment.equals(other$materialAdjustment)) {
                                                                                                   Object this$materialBrandRegulations = this.getMaterialBrandRegulations();
                                                                                                   Object other$materialBrandRegulations = other.getMaterialBrandRegulations();
                                                                                                   if (this$materialBrandRegulations == null
                                                                                                      ? other$materialBrandRegulations == null
                                                                                                      : this$materialBrandRegulations.equals(
                                                                                                         other$materialBrandRegulations
                                                                                                      )) {
                                                                                                      Object this$specialRulesForMaterials = this.getSpecialRulesForMaterials();
                                                                                                      Object other$specialRulesForMaterials = other.getSpecialRulesForMaterials();
                                                                                                      if (this$specialRulesForMaterials == null
                                                                                                         ? other$specialRulesForMaterials == null
                                                                                                         : this$specialRulesForMaterials.equals(
                                                                                                            other$specialRulesForMaterials
                                                                                                         )) {
                                                                                                         Object this$offerSample = this.getOfferSample();
                                                                                                         Object other$offerSample = other.getOfferSample();
                                                                                                         if (this$offerSample == null
                                                                                                            ? other$offerSample == null
                                                                                                            : this$offerSample.equals(other$offerSample)) {
                                                                                                            Object this$paymentMethod = this.getPaymentMethod();
                                                                                                            Object other$paymentMethod = other.getPaymentMethod();
                                                                                                            if (this$paymentMethod == null
                                                                                                               ? other$paymentMethod == null
                                                                                                               : this$paymentMethod.equals(other$paymentMethod)
                                                                                                               )
                                                                                                             {
                                                                                                               Object this$tenderRequirement = this.getTenderRequirement();
                                                                                                               Object other$tenderRequirement = other.getTenderRequirement();
                                                                                                               if (this$tenderRequirement == null
                                                                                                                  ? other$tenderRequirement == null
                                                                                                                  : this$tenderRequirement.equals(
                                                                                                                     other$tenderRequirement
                                                                                                                  )) {
                                                                                                                  Object this$attachmentIds = this.getAttachmentIds();
                                                                                                                  Object other$attachmentIds = other.getAttachmentIds();
                                                                                                                  if (this$attachmentIds == null
                                                                                                                     ? other$attachmentIds == null
                                                                                                                     : this$attachmentIds.equals(
                                                                                                                        other$attachmentIds
                                                                                                                     )) {
                                                                                                                     Object this$remark = this.getRemark();
                                                                                                                     Object other$remark = other.getRemark();
                                                                                                                     return this$remark == null
                                                                                                                        ? other$remark == null
                                                                                                                        : this$remark.equals(other$remark);
                                                                                                                  } else {
                                                                                                                     return false;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  return false;
                                                                                                               }
                                                                                                            } else {
                                                                                                               return false;
                                                                                                            }
                                                                                                         } else {
                                                                                                            return false;
                                                                                                         }
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmApplyForBidRecordSaveParamV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $biddingMethodId = this.getBiddingMethodId();
      result = result * 59 + ($biddingMethodId == null ? 43 : $biddingMethodId.hashCode());
      Object $crmBiddingRegulationsTypeEnum = this.getCrmBiddingRegulationsTypeEnum();
      result = result * 59 + ($crmBiddingRegulationsTypeEnum == null ? 43 : $crmBiddingRegulationsTypeEnum.hashCode());
      Object $tenderSubmissionMethodId = this.getTenderSubmissionMethodId();
      result = result * 59 + ($tenderSubmissionMethodId == null ? 43 : $tenderSubmissionMethodId.hashCode());
      Object $bidEvaluationMethodId = this.getBidEvaluationMethodId();
      result = result * 59 + ($bidEvaluationMethodId == null ? 43 : $bidEvaluationMethodId.hashCode());
      Object $isControlledBiddingPrice = this.getIsControlledBiddingPrice();
      result = result * 59 + ($isControlledBiddingPrice == null ? 43 : $isControlledBiddingPrice.hashCode());
      Object $settlementMethodId = this.getSettlementMethodId();
      result = result * 59 + ($settlementMethodId == null ? 43 : $settlementMethodId.hashCode());
      Object $isTenderBond = this.getIsTenderBond();
      result = result * 59 + ($isTenderBond == null ? 43 : $isTenderBond.hashCode());
      Object $isCashDeposit = this.getIsCashDeposit();
      result = result * 59 + ($isCashDeposit == null ? 43 : $isCashDeposit.hashCode());
      Object $typeOfPerformanceBondId = this.getTypeOfPerformanceBondId();
      result = result * 59 + ($typeOfPerformanceBondId == null ? 43 : $typeOfPerformanceBondId.hashCode());
      Object $isMaterialAdjustment = this.getIsMaterialAdjustment();
      result = result * 59 + ($isMaterialAdjustment == null ? 43 : $isMaterialAdjustment.hashCode());
      Object $isSpecialRulesForMaterials = this.getIsSpecialRulesForMaterials();
      result = result * 59 + ($isSpecialRulesForMaterials == null ? 43 : $isSpecialRulesForMaterials.hashCode());
      Object $isOfferSample = this.getIsOfferSample();
      result = result * 59 + ($isOfferSample == null ? 43 : $isOfferSample.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $bidExpirationDate = this.getBidExpirationDate();
      result = result * 59 + ($bidExpirationDate == null ? 43 : $bidExpirationDate.hashCode());
      Object $bidOpeningDate = this.getBidOpeningDate();
      result = result * 59 + ($bidOpeningDate == null ? 43 : $bidOpeningDate.hashCode());
      Object $controlledBiddingPrice = this.getControlledBiddingPrice();
      result = result * 59 + ($controlledBiddingPrice == null ? 43 : $controlledBiddingPrice.hashCode());
      Object $tenderBond = this.getTenderBond();
      result = result * 59 + ($tenderBond == null ? 43 : $tenderBond.hashCode());
      Object $tenderBondDeadline = this.getTenderBondDeadline();
      result = result * 59 + ($tenderBondDeadline == null ? 43 : $tenderBondDeadline.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $depositBank = this.getDepositBank();
      result = result * 59 + ($depositBank == null ? 43 : $depositBank.hashCode());
      Object $account = this.getAccount();
      result = result * 59 + ($account == null ? 43 : $account.hashCode());
      Object $cashDeposit = this.getCashDeposit();
      result = result * 59 + ($cashDeposit == null ? 43 : $cashDeposit.hashCode());
      Object $warrantyRatio = this.getWarrantyRatio();
      result = result * 59 + ($warrantyRatio == null ? 43 : $warrantyRatio.hashCode());
      Object $warrantyDate = this.getWarrantyDate();
      result = result * 59 + ($warrantyDate == null ? 43 : $warrantyDate.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $materialAdjustment = this.getMaterialAdjustment();
      result = result * 59 + ($materialAdjustment == null ? 43 : $materialAdjustment.hashCode());
      Object $materialBrandRegulations = this.getMaterialBrandRegulations();
      result = result * 59 + ($materialBrandRegulations == null ? 43 : $materialBrandRegulations.hashCode());
      Object $specialRulesForMaterials = this.getSpecialRulesForMaterials();
      result = result * 59 + ($specialRulesForMaterials == null ? 43 : $specialRulesForMaterials.hashCode());
      Object $offerSample = this.getOfferSample();
      result = result * 59 + ($offerSample == null ? 43 : $offerSample.hashCode());
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $tenderRequirement = this.getTenderRequirement();
      result = result * 59 + ($tenderRequirement == null ? 43 : $tenderRequirement.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CrmApplyForBidRecordSaveParamV2(informantUserId="
         + this.getInformantUserId()
         + ", departmentId="
         + this.getDepartmentId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", createUserId="
         + this.getCreateUserId()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", biddingMethodId="
         + this.getBiddingMethodId()
         + ", crmBiddingRegulationsTypeEnum="
         + this.getCrmBiddingRegulationsTypeEnum()
         + ", tenderSubmissionMethodId="
         + this.getTenderSubmissionMethodId()
         + ", bidExpirationDate="
         + this.getBidExpirationDate()
         + ", bidOpeningDate="
         + this.getBidOpeningDate()
         + ", bidEvaluationMethodId="
         + this.getBidEvaluationMethodId()
         + ", isControlledBiddingPrice="
         + this.getIsControlledBiddingPrice()
         + ", controlledBiddingPrice="
         + this.getControlledBiddingPrice()
         + ", settlementMethodId="
         + this.getSettlementMethodId()
         + ", isTenderBond="
         + this.getIsTenderBond()
         + ", tenderBond="
         + this.getTenderBond()
         + ", tenderBondDeadline="
         + this.getTenderBondDeadline()
         + ", companyName="
         + this.getCompanyName()
         + ", depositBank="
         + this.getDepositBank()
         + ", account="
         + this.getAccount()
         + ", isCashDeposit="
         + this.getIsCashDeposit()
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", typeOfPerformanceBondId="
         + this.getTypeOfPerformanceBondId()
         + ", warrantyRatio="
         + this.getWarrantyRatio()
         + ", warrantyDate="
         + this.getWarrantyDate()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", isMaterialAdjustment="
         + this.getIsMaterialAdjustment()
         + ", materialAdjustment="
         + this.getMaterialAdjustment()
         + ", materialBrandRegulations="
         + this.getMaterialBrandRegulations()
         + ", isSpecialRulesForMaterials="
         + this.getIsSpecialRulesForMaterials()
         + ", specialRulesForMaterials="
         + this.getSpecialRulesForMaterials()
         + ", isOfferSample="
         + this.getIsOfferSample()
         + ", offerSample="
         + this.getOfferSample()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", tenderRequirement="
         + this.getTenderRequirement()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public CrmApplyForBidRecordSaveParamV2(
      final Long informantUserId,
      final Long departmentId,
      final LocalDateTime informantDateTime,
      final Long createUserId,
      final Long crmProjectInformationWarehousingId,
      final Long biddingMethodId,
      final Integer crmBiddingRegulationsTypeEnum,
      final Long tenderSubmissionMethodId,
      final LocalDateTime bidExpirationDate,
      final LocalDateTime bidOpeningDate,
      final Long bidEvaluationMethodId,
      final Boolean isControlledBiddingPrice,
      final BigDecimal controlledBiddingPrice,
      final Long settlementMethodId,
      final Boolean isTenderBond,
      final BigDecimal tenderBond,
      final LocalDateTime tenderBondDeadline,
      final String companyName,
      final String depositBank,
      final String account,
      final Boolean isCashDeposit,
      final BigDecimal cashDeposit,
      final Long typeOfPerformanceBondId,
      final String warrantyRatio,
      final String warrantyDate,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final Boolean isMaterialAdjustment,
      final String materialAdjustment,
      final String materialBrandRegulations,
      final Boolean isSpecialRulesForMaterials,
      final String specialRulesForMaterials,
      final Boolean isOfferSample,
      final String offerSample,
      final String paymentMethod,
      final List<Integer> tenderRequirement,
      final List<AttachmentDTO> attachmentIds,
      final String remark
   ) {
      this.informantUserId = informantUserId;
      this.departmentId = departmentId;
      this.informantDateTime = informantDateTime;
      this.createUserId = createUserId;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.biddingMethodId = biddingMethodId;
      this.crmBiddingRegulationsTypeEnum = crmBiddingRegulationsTypeEnum;
      this.tenderSubmissionMethodId = tenderSubmissionMethodId;
      this.bidExpirationDate = bidExpirationDate;
      this.bidOpeningDate = bidOpeningDate;
      this.bidEvaluationMethodId = bidEvaluationMethodId;
      this.isControlledBiddingPrice = isControlledBiddingPrice;
      this.controlledBiddingPrice = controlledBiddingPrice;
      this.settlementMethodId = settlementMethodId;
      this.isTenderBond = isTenderBond;
      this.tenderBond = tenderBond;
      this.tenderBondDeadline = tenderBondDeadline;
      this.companyName = companyName;
      this.depositBank = depositBank;
      this.account = account;
      this.isCashDeposit = isCashDeposit;
      this.cashDeposit = cashDeposit;
      this.typeOfPerformanceBondId = typeOfPerformanceBondId;
      this.warrantyRatio = warrantyRatio;
      this.warrantyDate = warrantyDate;
      this.startDate = startDate;
      this.endDate = endDate;
      this.isMaterialAdjustment = isMaterialAdjustment;
      this.materialAdjustment = materialAdjustment;
      this.materialBrandRegulations = materialBrandRegulations;
      this.isSpecialRulesForMaterials = isSpecialRulesForMaterials;
      this.specialRulesForMaterials = specialRulesForMaterials;
      this.isOfferSample = isOfferSample;
      this.offerSample = offerSample;
      this.paymentMethod = paymentMethod;
      this.tenderRequirement = tenderRequirement;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public CrmApplyForBidRecordSaveParamV2() {
   }
}
