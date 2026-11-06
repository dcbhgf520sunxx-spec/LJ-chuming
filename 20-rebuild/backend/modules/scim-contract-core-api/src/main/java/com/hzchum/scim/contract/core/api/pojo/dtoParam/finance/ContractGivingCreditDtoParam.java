package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ContractGivingCreditDtoParam extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "startDate", value = "授信开始时间", notes = "授信开始时间")
   @NotNull(message = "授信开始日期不能为空!")
   private LocalDateTime startDate;
   @NotNull(message = "有效截至日期不能为空!")
   @ApiModelProperty(name = "closingDate", value = "有效截至日期", notes = "有效截至日期")
   private LocalDateTime closingDate;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   private Long userId;
   @ApiModelProperty(name = "userId", value = "项目id", notes = "项目id")
   @NotNull(message = "请选择一个项目!")
   private Long projectId;
   @NotNull(message = "授信人员不能为空")
   @ApiModelProperty(name = "accreditingPartyId", value = "授信人员", notes = "授信人员")
   private Long accreditingPartyId;
   @ApiModelProperty(name = "accreditingIdNumber", value = "授信人员身份证号码", notes = "授信人员身份证号码")
   @Size(min = 18, max = 18, message = "身份证号码长度为18位")
   @NotNull(message = "身份证号码不能为空")
   private String accreditingIdNumber;
   @ApiModelProperty(name = "suretyName", value = "担保人姓名（手动输入）", notes = "担保人姓名（手动输入）")
   @NotBlank(message = "担保人不能为空")
   private String suretyName;
   @NotNull(message = "身份证号码不能为空")
   @Size(min = 18, max = 18, message = "身份证号码长度为18位")
   @ApiModelProperty(name = "idNumber", value = "担保人身份证号码", notes = "担保人身份证号码")
   private String idNumber;
   @ApiModelProperty(name = "lineOfCredit", value = "授信额度", notes = "授信额度")
   @DecimalMin(value = "0", message = "授信额度不能小于0")
   private BigDecimal lineOfCredit;
   @NotNull(message = "年息不能为空")
   @ApiModelProperty(name = "annualInterest", value = "年息", notes = "年息")
   @DecimalMin(value = "0", message = "年息不能小于0")
   private BigDecimal annualInterest;
   @ApiModelProperty(name = "accessoryId", value = "附件id", notes = "附件id")
   private List<Long> accessoryId;

   public static ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder builder() {
      return new ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder();
   }

   public ContractGivingCreditDtoParam() {
   }

   public ContractGivingCreditDtoParam(
      final Long id,
      final LocalDateTime startDate,
      final LocalDateTime closingDate,
      final Long userId,
      final Long projectId,
      final Long accreditingPartyId,
      final String accreditingIdNumber,
      final String suretyName,
      final String idNumber,
      final BigDecimal lineOfCredit,
      final BigDecimal annualInterest,
      final List<Long> accessoryId
   ) {
      this.id = id;
      this.startDate = startDate;
      this.closingDate = closingDate;
      this.userId = userId;
      this.projectId = projectId;
      this.accreditingPartyId = accreditingPartyId;
      this.accreditingIdNumber = accreditingIdNumber;
      this.suretyName = suretyName;
      this.idNumber = idNumber;
      this.lineOfCredit = lineOfCredit;
      this.annualInterest = annualInterest;
      this.accessoryId = accessoryId;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getClosingDate() {
      return this.closingDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAccreditingPartyId() {
      return this.accreditingPartyId;
   }

   public String getAccreditingIdNumber() {
      return this.accreditingIdNumber;
   }

   public String getSuretyName() {
      return this.suretyName;
   }

   public String getIdNumber() {
      return this.idNumber;
   }

   public BigDecimal getLineOfCredit() {
      return this.lineOfCredit;
   }

   public BigDecimal getAnnualInterest() {
      return this.annualInterest;
   }

   public List<Long> getAccessoryId() {
      return this.accessoryId;
   }

   public ContractGivingCreditDtoParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractGivingCreditDtoParam setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public ContractGivingCreditDtoParam setClosingDate(final LocalDateTime closingDate) {
      this.closingDate = closingDate;
      return this;
   }

   public ContractGivingCreditDtoParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractGivingCreditDtoParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractGivingCreditDtoParam setAccreditingPartyId(final Long accreditingPartyId) {
      this.accreditingPartyId = accreditingPartyId;
      return this;
   }

   public ContractGivingCreditDtoParam setAccreditingIdNumber(final String accreditingIdNumber) {
      this.accreditingIdNumber = accreditingIdNumber;
      return this;
   }

   public ContractGivingCreditDtoParam setSuretyName(final String suretyName) {
      this.suretyName = suretyName;
      return this;
   }

   public ContractGivingCreditDtoParam setIdNumber(final String idNumber) {
      this.idNumber = idNumber;
      return this;
   }

   public ContractGivingCreditDtoParam setLineOfCredit(final BigDecimal lineOfCredit) {
      this.lineOfCredit = lineOfCredit;
      return this;
   }

   public ContractGivingCreditDtoParam setAnnualInterest(final BigDecimal annualInterest) {
      this.annualInterest = annualInterest;
      return this;
   }

   public ContractGivingCreditDtoParam setAccessoryId(final List<Long> accessoryId) {
      this.accessoryId = accessoryId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractGivingCreditDtoParam)) {
         return false;
      }

      ContractGivingCreditDtoParam other = (ContractGivingCreditDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$accreditingPartyId = this.getAccreditingPartyId();
               Object other$accreditingPartyId = other.getAccreditingPartyId();
               if (this$accreditingPartyId == null ? other$accreditingPartyId == null : this$accreditingPartyId.equals(other$accreditingPartyId)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$closingDate = this.getClosingDate();
                     Object other$closingDate = other.getClosingDate();
                     if (this$closingDate == null ? other$closingDate == null : this$closingDate.equals(other$closingDate)) {
                        Object this$accreditingIdNumber = this.getAccreditingIdNumber();
                        Object other$accreditingIdNumber = other.getAccreditingIdNumber();
                        if (this$accreditingIdNumber == null ? other$accreditingIdNumber == null : this$accreditingIdNumber.equals(other$accreditingIdNumber)) {
                           Object this$suretyName = this.getSuretyName();
                           Object other$suretyName = other.getSuretyName();
                           if (this$suretyName == null ? other$suretyName == null : this$suretyName.equals(other$suretyName)) {
                              Object this$idNumber = this.getIdNumber();
                              Object other$idNumber = other.getIdNumber();
                              if (this$idNumber == null ? other$idNumber == null : this$idNumber.equals(other$idNumber)) {
                                 Object this$lineOfCredit = this.getLineOfCredit();
                                 Object other$lineOfCredit = other.getLineOfCredit();
                                 if (this$lineOfCredit == null ? other$lineOfCredit == null : this$lineOfCredit.equals(other$lineOfCredit)) {
                                    Object this$annualInterest = this.getAnnualInterest();
                                    Object other$annualInterest = other.getAnnualInterest();
                                    if (this$annualInterest == null ? other$annualInterest == null : this$annualInterest.equals(other$annualInterest)) {
                                       Object this$accessoryId = this.getAccessoryId();
                                       Object other$accessoryId = other.getAccessoryId();
                                       return this$accessoryId == null ? other$accessoryId == null : this$accessoryId.equals(other$accessoryId);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractGivingCreditDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $accreditingPartyId = this.getAccreditingPartyId();
      result = result * 59 + ($accreditingPartyId == null ? 43 : $accreditingPartyId.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $closingDate = this.getClosingDate();
      result = result * 59 + ($closingDate == null ? 43 : $closingDate.hashCode());
      Object $accreditingIdNumber = this.getAccreditingIdNumber();
      result = result * 59 + ($accreditingIdNumber == null ? 43 : $accreditingIdNumber.hashCode());
      Object $suretyName = this.getSuretyName();
      result = result * 59 + ($suretyName == null ? 43 : $suretyName.hashCode());
      Object $idNumber = this.getIdNumber();
      result = result * 59 + ($idNumber == null ? 43 : $idNumber.hashCode());
      Object $lineOfCredit = this.getLineOfCredit();
      result = result * 59 + ($lineOfCredit == null ? 43 : $lineOfCredit.hashCode());
      Object $annualInterest = this.getAnnualInterest();
      result = result * 59 + ($annualInterest == null ? 43 : $annualInterest.hashCode());
      Object $accessoryId = this.getAccessoryId();
      return result * 59 + ($accessoryId == null ? 43 : $accessoryId.hashCode());
   }

   @Override
   public String toString() {
      return "ContractGivingCreditDtoParam(id="
         + this.getId()
         + ", startDate="
         + this.getStartDate()
         + ", closingDate="
         + this.getClosingDate()
         + ", userId="
         + this.getUserId()
         + ", projectId="
         + this.getProjectId()
         + ", accreditingPartyId="
         + this.getAccreditingPartyId()
         + ", accreditingIdNumber="
         + this.getAccreditingIdNumber()
         + ", suretyName="
         + this.getSuretyName()
         + ", idNumber="
         + this.getIdNumber()
         + ", lineOfCredit="
         + this.getLineOfCredit()
         + ", annualInterest="
         + this.getAnnualInterest()
         + ", accessoryId="
         + this.getAccessoryId()
         + ")";
   }

   public static class ContractGivingCreditDtoParamBuilder {
      private Long id;
      private LocalDateTime startDate;
      private LocalDateTime closingDate;
      private Long userId;
      private Long projectId;
      private Long accreditingPartyId;
      private String accreditingIdNumber;
      private String suretyName;
      private String idNumber;
      private BigDecimal lineOfCredit;
      private BigDecimal annualInterest;
      private List<Long> accessoryId;

      ContractGivingCreditDtoParamBuilder() {
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder closingDate(final LocalDateTime closingDate) {
         this.closingDate = closingDate;
         return this;
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder accreditingPartyId(final Long accreditingPartyId) {
         this.accreditingPartyId = accreditingPartyId;
         return this;
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder accreditingIdNumber(final String accreditingIdNumber) {
         this.accreditingIdNumber = accreditingIdNumber;
         return this;
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder suretyName(final String suretyName) {
         this.suretyName = suretyName;
         return this;
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder idNumber(final String idNumber) {
         this.idNumber = idNumber;
         return this;
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder lineOfCredit(final BigDecimal lineOfCredit) {
         this.lineOfCredit = lineOfCredit;
         return this;
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder annualInterest(final BigDecimal annualInterest) {
         this.annualInterest = annualInterest;
         return this;
      }

      public ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder accessoryId(final List<Long> accessoryId) {
         this.accessoryId = accessoryId;
         return this;
      }

      public ContractGivingCreditDtoParam build() {
         return new ContractGivingCreditDtoParam(
            this.id,
            this.startDate,
            this.closingDate,
            this.userId,
            this.projectId,
            this.accreditingPartyId,
            this.accreditingIdNumber,
            this.suretyName,
            this.idNumber,
            this.lineOfCredit,
            this.annualInterest,
            this.accessoryId
         );
      }

      @Override
      public String toString() {
         return "ContractGivingCreditDtoParam.ContractGivingCreditDtoParamBuilder(id="
            + this.id
            + ", startDate="
            + this.startDate
            + ", closingDate="
            + this.closingDate
            + ", userId="
            + this.userId
            + ", projectId="
            + this.projectId
            + ", accreditingPartyId="
            + this.accreditingPartyId
            + ", accreditingIdNumber="
            + this.accreditingIdNumber
            + ", suretyName="
            + this.suretyName
            + ", idNumber="
            + this.idNumber
            + ", lineOfCredit="
            + this.lineOfCredit
            + ", annualInterest="
            + this.annualInterest
            + ", accessoryId="
            + this.accessoryId
            + ")";
      }
   }
}
