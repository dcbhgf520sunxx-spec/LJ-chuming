package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContractGivingCreditDetailDto {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "userId", value = "创建人信息", notes = "创建人信息")
   private NameInfo user;
   @ApiModelProperty(name = "creditId", value = "授信id", notes = "授信id")
   private Long creditId;
   @ApiModelProperty(name = "project", value = "项目信息", notes = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "purchaseId", value = "采购id", notes = "采购id")
   private Long purchaseId;
   @ApiModelProperty(name = "purchaseId", value = "采购单单号", notes = "采购单单号")
   private String purchaseNumber;
   @ApiModelProperty(name = "useAmount", value = "使用额度", notes = "使用额度")
   private BigDecimal useAmount;
   @ApiModelProperty(name = "residueAmount", value = "剩余额度", notes = "剩余额度")
   private BigDecimal residueAmount;
   @ApiModelProperty(name = "paymentReasonId", value = "付款事由", notes = "付款事由")
   private Integer paymentReasonId;
   @ApiModelProperty(name = "auditStatus", value = "审批状态 审批状态：1 待审核 2 通过 4 不通过", notes = "审批状态 审批状态：1 待审核 2 通过 4 不通过")
   private Integer auditStatus;
   @ApiModelProperty(name = "createTime", value = "使用时间", notes = "使用时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "isStatus", value = "是否还款", notes = "是否还款")
   private Integer isStatus;

   public static ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder builder() {
      return new ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder();
   }

   public ContractGivingCreditDetailDto() {
   }

   public ContractGivingCreditDetailDto(
      final Long id,
      final NameInfo user,
      final Long creditId,
      final ProjectInfo project,
      final Long purchaseId,
      final String purchaseNumber,
      final BigDecimal useAmount,
      final BigDecimal residueAmount,
      final Integer paymentReasonId,
      final Integer auditStatus,
      final LocalDateTime createTime,
      final Integer isStatus
   ) {
      this.id = id;
      this.user = user;
      this.creditId = creditId;
      this.project = project;
      this.purchaseId = purchaseId;
      this.purchaseNumber = purchaseNumber;
      this.useAmount = useAmount;
      this.residueAmount = residueAmount;
      this.paymentReasonId = paymentReasonId;
      this.auditStatus = auditStatus;
      this.createTime = createTime;
      this.isStatus = isStatus;
   }

   public Long getId() {
      return this.id;
   }

   public NameInfo getUser() {
      return this.user;
   }

   public Long getCreditId() {
      return this.creditId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public String getPurchaseNumber() {
      return this.purchaseNumber;
   }

   public BigDecimal getUseAmount() {
      return this.useAmount;
   }

   public BigDecimal getResidueAmount() {
      return this.residueAmount;
   }

   public Integer getPaymentReasonId() {
      return this.paymentReasonId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getIsStatus() {
      return this.isStatus;
   }

   public ContractGivingCreditDetailDto setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractGivingCreditDetailDto setUser(final NameInfo user) {
      this.user = user;
      return this;
   }

   public ContractGivingCreditDetailDto setCreditId(final Long creditId) {
      this.creditId = creditId;
      return this;
   }

   public ContractGivingCreditDetailDto setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public ContractGivingCreditDetailDto setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
      return this;
   }

   public ContractGivingCreditDetailDto setPurchaseNumber(final String purchaseNumber) {
      this.purchaseNumber = purchaseNumber;
      return this;
   }

   public ContractGivingCreditDetailDto setUseAmount(final BigDecimal useAmount) {
      this.useAmount = useAmount;
      return this;
   }

   public ContractGivingCreditDetailDto setResidueAmount(final BigDecimal residueAmount) {
      this.residueAmount = residueAmount;
      return this;
   }

   public ContractGivingCreditDetailDto setPaymentReasonId(final Integer paymentReasonId) {
      this.paymentReasonId = paymentReasonId;
      return this;
   }

   public ContractGivingCreditDetailDto setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public ContractGivingCreditDetailDto setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public ContractGivingCreditDetailDto setIsStatus(final Integer isStatus) {
      this.isStatus = isStatus;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractGivingCreditDetailDto)) {
         return false;
      }

      ContractGivingCreditDetailDto other = (ContractGivingCreditDetailDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$creditId = this.getCreditId();
         Object other$creditId = other.getCreditId();
         if (this$creditId == null ? other$creditId == null : this$creditId.equals(other$creditId)) {
            Object this$purchaseId = this.getPurchaseId();
            Object other$purchaseId = other.getPurchaseId();
            if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
               Object this$paymentReasonId = this.getPaymentReasonId();
               Object other$paymentReasonId = other.getPaymentReasonId();
               if (this$paymentReasonId == null ? other$paymentReasonId == null : this$paymentReasonId.equals(other$paymentReasonId)) {
                  Object this$auditStatus = this.getAuditStatus();
                  Object other$auditStatus = other.getAuditStatus();
                  if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                     Object this$isStatus = this.getIsStatus();
                     Object other$isStatus = other.getIsStatus();
                     if (this$isStatus == null ? other$isStatus == null : this$isStatus.equals(other$isStatus)) {
                        Object this$user = this.getUser();
                        Object other$user = other.getUser();
                        if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$purchaseNumber = this.getPurchaseNumber();
                              Object other$purchaseNumber = other.getPurchaseNumber();
                              if (this$purchaseNumber == null ? other$purchaseNumber == null : this$purchaseNumber.equals(other$purchaseNumber)) {
                                 Object this$useAmount = this.getUseAmount();
                                 Object other$useAmount = other.getUseAmount();
                                 if (this$useAmount == null ? other$useAmount == null : this$useAmount.equals(other$useAmount)) {
                                    Object this$residueAmount = this.getResidueAmount();
                                    Object other$residueAmount = other.getResidueAmount();
                                    if (this$residueAmount == null ? other$residueAmount == null : this$residueAmount.equals(other$residueAmount)) {
                                       Object this$createTime = this.getCreateTime();
                                       Object other$createTime = other.getCreateTime();
                                       return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof ContractGivingCreditDetailDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $creditId = this.getCreditId();
      result = result * 59 + ($creditId == null ? 43 : $creditId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      result = result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $isStatus = this.getIsStatus();
      result = result * 59 + ($isStatus == null ? 43 : $isStatus.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $purchaseNumber = this.getPurchaseNumber();
      result = result * 59 + ($purchaseNumber == null ? 43 : $purchaseNumber.hashCode());
      Object $useAmount = this.getUseAmount();
      result = result * 59 + ($useAmount == null ? 43 : $useAmount.hashCode());
      Object $residueAmount = this.getResidueAmount();
      result = result * 59 + ($residueAmount == null ? 43 : $residueAmount.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ContractGivingCreditDetailDto(id="
         + this.getId()
         + ", user="
         + this.getUser()
         + ", creditId="
         + this.getCreditId()
         + ", project="
         + this.getProject()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", purchaseNumber="
         + this.getPurchaseNumber()
         + ", useAmount="
         + this.getUseAmount()
         + ", residueAmount="
         + this.getResidueAmount()
         + ", paymentReasonId="
         + this.getPaymentReasonId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", createTime="
         + this.getCreateTime()
         + ", isStatus="
         + this.getIsStatus()
         + ")";
   }

   public static class ContractGivingCreditDetailDtoBuilder {
      private Long id;
      private NameInfo user;
      private Long creditId;
      private ProjectInfo project;
      private Long purchaseId;
      private String purchaseNumber;
      private BigDecimal useAmount;
      private BigDecimal residueAmount;
      private Integer paymentReasonId;
      private Integer auditStatus;
      private LocalDateTime createTime;
      private Integer isStatus;

      ContractGivingCreditDetailDtoBuilder() {
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder user(final NameInfo user) {
         this.user = user;
         return this;
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder creditId(final Long creditId) {
         this.creditId = creditId;
         return this;
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder purchaseNumber(final String purchaseNumber) {
         this.purchaseNumber = purchaseNumber;
         return this;
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder useAmount(final BigDecimal useAmount) {
         this.useAmount = useAmount;
         return this;
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder residueAmount(final BigDecimal residueAmount) {
         this.residueAmount = residueAmount;
         return this;
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder paymentReasonId(final Integer paymentReasonId) {
         this.paymentReasonId = paymentReasonId;
         return this;
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder isStatus(final Integer isStatus) {
         this.isStatus = isStatus;
         return this;
      }

      public ContractGivingCreditDetailDto build() {
         return new ContractGivingCreditDetailDto(
            this.id,
            this.user,
            this.creditId,
            this.project,
            this.purchaseId,
            this.purchaseNumber,
            this.useAmount,
            this.residueAmount,
            this.paymentReasonId,
            this.auditStatus,
            this.createTime,
            this.isStatus
         );
      }

      @Override
      public String toString() {
         return "ContractGivingCreditDetailDto.ContractGivingCreditDetailDtoBuilder(id="
            + this.id
            + ", user="
            + this.user
            + ", creditId="
            + this.creditId
            + ", project="
            + this.project
            + ", purchaseId="
            + this.purchaseId
            + ", purchaseNumber="
            + this.purchaseNumber
            + ", useAmount="
            + this.useAmount
            + ", residueAmount="
            + this.residueAmount
            + ", paymentReasonId="
            + this.paymentReasonId
            + ", auditStatus="
            + this.auditStatus
            + ", createTime="
            + this.createTime
            + ", isStatus="
            + this.isStatus
            + ")";
      }
   }
}
