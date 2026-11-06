package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContractGivingCreditDto extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "startDate", value = "授信开始时间", notes = "授信开始时间")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   private Long userId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "userName", value = "创建人名称", notes = "创建人名称")
   private String userName;
   @ApiModelProperty(name = "accreditingPartyId", value = "授信人员", notes = "授信人员")
   private Long accreditingPartyId;
   @ApiModelProperty(name = "lineOfCredit", value = "授信额度", notes = "授信额度")
   private BigDecimal lineOfCredit;
   @ApiModelProperty(name = "accreditingParty", value = "授信人员名称", notes = "授信人员名称")
   private String accreditingPartyName;
   @ApiModelProperty(name = "accreditingIdNumber", value = "身份证号码", notes = "身份证号码")
   private String accreditingIdNumber;
   @ApiModelProperty(name = "suretyId", value = "担保人", notes = "担保人")
   private Long suretyId;
   @ApiModelProperty(name = "suretyName", value = "担保人", notes = "担保人")
   private String suretyName;
   @ApiModelProperty(name = "idNumber", value = "身份证号码", notes = "身份证号码")
   private String idNumber;
   @ApiModelProperty(name = "annualInterest", value = "年息", notes = "年息")
   private BigDecimal annualInterest;
   @ApiModelProperty(name = "monthlyInterest", value = "月息", notes = "月息")
   private String monthlyInterest;
   @ApiModelProperty(name = "dayInterest", value = "日息", notes = "日息")
   private String dayInterest;
   private BigDecimal usedCredit;
   @ApiModelProperty(name = "remainingSum", value = "剩余额度", notes = "剩余额度")
   private BigDecimal remainingSum;
   @ApiModelProperty(name = "closingDate", value = "有效截至日期", notes = "有效截至日期")
   private LocalDateTime closingDate;
   @ApiModelProperty(name = "countDown", value = "剩余天数", notes = "剩余天数")
   private Integer countDown;
   @ApiModelProperty(name = "status", value = "状态 状态 0启用1禁用", notes = "状态 状态 0启用1禁用")
   private Integer status;
   @ApiModelProperty(name = "attachmentDTOS", value = "附件信息", notes = "附件信息")
   private AttachmentDTO attachmentDTOS;

   public static ContractGivingCreditDto.ContractGivingCreditDtoBuilder builder() {
      return new ContractGivingCreditDto.ContractGivingCreditDtoBuilder();
   }

   public ContractGivingCreditDto() {
   }

   public ContractGivingCreditDto(
      final Long id,
      final LocalDateTime startDate,
      final Long userId,
      final Long projectId,
      final String projectName,
      final String userName,
      final Long accreditingPartyId,
      final BigDecimal lineOfCredit,
      final String accreditingPartyName,
      final String accreditingIdNumber,
      final Long suretyId,
      final String suretyName,
      final String idNumber,
      final BigDecimal annualInterest,
      final String monthlyInterest,
      final String dayInterest,
      final BigDecimal usedCredit,
      final BigDecimal remainingSum,
      final LocalDateTime closingDate,
      final Integer countDown,
      final Integer status,
      final AttachmentDTO attachmentDTOS
   ) {
      this.id = id;
      this.startDate = startDate;
      this.userId = userId;
      this.projectId = projectId;
      this.projectName = projectName;
      this.userName = userName;
      this.accreditingPartyId = accreditingPartyId;
      this.lineOfCredit = lineOfCredit;
      this.accreditingPartyName = accreditingPartyName;
      this.accreditingIdNumber = accreditingIdNumber;
      this.suretyId = suretyId;
      this.suretyName = suretyName;
      this.idNumber = idNumber;
      this.annualInterest = annualInterest;
      this.monthlyInterest = monthlyInterest;
      this.dayInterest = dayInterest;
      this.usedCredit = usedCredit;
      this.remainingSum = remainingSum;
      this.closingDate = closingDate;
      this.countDown = countDown;
      this.status = status;
      this.attachmentDTOS = attachmentDTOS;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getAccreditingPartyId() {
      return this.accreditingPartyId;
   }

   public BigDecimal getLineOfCredit() {
      return this.lineOfCredit;
   }

   public String getAccreditingPartyName() {
      return this.accreditingPartyName;
   }

   public String getAccreditingIdNumber() {
      return this.accreditingIdNumber;
   }

   public Long getSuretyId() {
      return this.suretyId;
   }

   public String getSuretyName() {
      return this.suretyName;
   }

   public String getIdNumber() {
      return this.idNumber;
   }

   public BigDecimal getAnnualInterest() {
      return this.annualInterest;
   }

   public String getMonthlyInterest() {
      return this.monthlyInterest;
   }

   public String getDayInterest() {
      return this.dayInterest;
   }

   public BigDecimal getUsedCredit() {
      return this.usedCredit;
   }

   public BigDecimal getRemainingSum() {
      return this.remainingSum;
   }

   public LocalDateTime getClosingDate() {
      return this.closingDate;
   }

   public Integer getCountDown() {
      return this.countDown;
   }

   public Integer getStatus() {
      return this.status;
   }

   public AttachmentDTO getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   public ContractGivingCreditDto setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractGivingCreditDto setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public ContractGivingCreditDto setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractGivingCreditDto setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractGivingCreditDto setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ContractGivingCreditDto setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public ContractGivingCreditDto setAccreditingPartyId(final Long accreditingPartyId) {
      this.accreditingPartyId = accreditingPartyId;
      return this;
   }

   public ContractGivingCreditDto setLineOfCredit(final BigDecimal lineOfCredit) {
      this.lineOfCredit = lineOfCredit;
      return this;
   }

   public ContractGivingCreditDto setAccreditingPartyName(final String accreditingPartyName) {
      this.accreditingPartyName = accreditingPartyName;
      return this;
   }

   public ContractGivingCreditDto setAccreditingIdNumber(final String accreditingIdNumber) {
      this.accreditingIdNumber = accreditingIdNumber;
      return this;
   }

   public ContractGivingCreditDto setSuretyId(final Long suretyId) {
      this.suretyId = suretyId;
      return this;
   }

   public ContractGivingCreditDto setSuretyName(final String suretyName) {
      this.suretyName = suretyName;
      return this;
   }

   public ContractGivingCreditDto setIdNumber(final String idNumber) {
      this.idNumber = idNumber;
      return this;
   }

   public ContractGivingCreditDto setAnnualInterest(final BigDecimal annualInterest) {
      this.annualInterest = annualInterest;
      return this;
   }

   public ContractGivingCreditDto setMonthlyInterest(final String monthlyInterest) {
      this.monthlyInterest = monthlyInterest;
      return this;
   }

   public ContractGivingCreditDto setDayInterest(final String dayInterest) {
      this.dayInterest = dayInterest;
      return this;
   }

   public ContractGivingCreditDto setUsedCredit(final BigDecimal usedCredit) {
      this.usedCredit = usedCredit;
      return this;
   }

   public ContractGivingCreditDto setRemainingSum(final BigDecimal remainingSum) {
      this.remainingSum = remainingSum;
      return this;
   }

   public ContractGivingCreditDto setClosingDate(final LocalDateTime closingDate) {
      this.closingDate = closingDate;
      return this;
   }

   public ContractGivingCreditDto setCountDown(final Integer countDown) {
      this.countDown = countDown;
      return this;
   }

   public ContractGivingCreditDto setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public ContractGivingCreditDto setAttachmentDTOS(final AttachmentDTO attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractGivingCreditDto)) {
         return false;
      }

      ContractGivingCreditDto other = (ContractGivingCreditDto)o;
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
                  Object this$suretyId = this.getSuretyId();
                  Object other$suretyId = other.getSuretyId();
                  if (this$suretyId == null ? other$suretyId == null : this$suretyId.equals(other$suretyId)) {
                     Object this$countDown = this.getCountDown();
                     Object other$countDown = other.getCountDown();
                     if (this$countDown == null ? other$countDown == null : this$countDown.equals(other$countDown)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$startDate = this.getStartDate();
                           Object other$startDate = other.getStartDate();
                           if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                              Object this$projectName = this.getProjectName();
                              Object other$projectName = other.getProjectName();
                              if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                 Object this$userName = this.getUserName();
                                 Object other$userName = other.getUserName();
                                 if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                    Object this$lineOfCredit = this.getLineOfCredit();
                                    Object other$lineOfCredit = other.getLineOfCredit();
                                    if (this$lineOfCredit == null ? other$lineOfCredit == null : this$lineOfCredit.equals(other$lineOfCredit)) {
                                       Object this$accreditingPartyName = this.getAccreditingPartyName();
                                       Object other$accreditingPartyName = other.getAccreditingPartyName();
                                       if (this$accreditingPartyName == null
                                          ? other$accreditingPartyName == null
                                          : this$accreditingPartyName.equals(other$accreditingPartyName)) {
                                          Object this$accreditingIdNumber = this.getAccreditingIdNumber();
                                          Object other$accreditingIdNumber = other.getAccreditingIdNumber();
                                          if (this$accreditingIdNumber == null
                                             ? other$accreditingIdNumber == null
                                             : this$accreditingIdNumber.equals(other$accreditingIdNumber)) {
                                             Object this$suretyName = this.getSuretyName();
                                             Object other$suretyName = other.getSuretyName();
                                             if (this$suretyName == null ? other$suretyName == null : this$suretyName.equals(other$suretyName)) {
                                                Object this$idNumber = this.getIdNumber();
                                                Object other$idNumber = other.getIdNumber();
                                                if (this$idNumber == null ? other$idNumber == null : this$idNumber.equals(other$idNumber)) {
                                                   Object this$annualInterest = this.getAnnualInterest();
                                                   Object other$annualInterest = other.getAnnualInterest();
                                                   if (this$annualInterest == null
                                                      ? other$annualInterest == null
                                                      : this$annualInterest.equals(other$annualInterest)) {
                                                      Object this$monthlyInterest = this.getMonthlyInterest();
                                                      Object other$monthlyInterest = other.getMonthlyInterest();
                                                      if (this$monthlyInterest == null
                                                         ? other$monthlyInterest == null
                                                         : this$monthlyInterest.equals(other$monthlyInterest)) {
                                                         Object this$dayInterest = this.getDayInterest();
                                                         Object other$dayInterest = other.getDayInterest();
                                                         if (this$dayInterest == null ? other$dayInterest == null : this$dayInterest.equals(other$dayInterest)) {
                                                            Object this$usedCredit = this.getUsedCredit();
                                                            Object other$usedCredit = other.getUsedCredit();
                                                            if (this$usedCredit == null ? other$usedCredit == null : this$usedCredit.equals(other$usedCredit)) {
                                                               Object this$remainingSum = this.getRemainingSum();
                                                               Object other$remainingSum = other.getRemainingSum();
                                                               if (this$remainingSum == null
                                                                  ? other$remainingSum == null
                                                                  : this$remainingSum.equals(other$remainingSum)) {
                                                                  Object this$closingDate = this.getClosingDate();
                                                                  Object other$closingDate = other.getClosingDate();
                                                                  if (this$closingDate == null
                                                                     ? other$closingDate == null
                                                                     : this$closingDate.equals(other$closingDate)) {
                                                                     Object this$attachmentDTOS = this.getAttachmentDTOS();
                                                                     Object other$attachmentDTOS = other.getAttachmentDTOS();
                                                                     return this$attachmentDTOS == null
                                                                        ? other$attachmentDTOS == null
                                                                        : this$attachmentDTOS.equals(other$attachmentDTOS);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractGivingCreditDto;
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
      Object $suretyId = this.getSuretyId();
      result = result * 59 + ($suretyId == null ? 43 : $suretyId.hashCode());
      Object $countDown = this.getCountDown();
      result = result * 59 + ($countDown == null ? 43 : $countDown.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $lineOfCredit = this.getLineOfCredit();
      result = result * 59 + ($lineOfCredit == null ? 43 : $lineOfCredit.hashCode());
      Object $accreditingPartyName = this.getAccreditingPartyName();
      result = result * 59 + ($accreditingPartyName == null ? 43 : $accreditingPartyName.hashCode());
      Object $accreditingIdNumber = this.getAccreditingIdNumber();
      result = result * 59 + ($accreditingIdNumber == null ? 43 : $accreditingIdNumber.hashCode());
      Object $suretyName = this.getSuretyName();
      result = result * 59 + ($suretyName == null ? 43 : $suretyName.hashCode());
      Object $idNumber = this.getIdNumber();
      result = result * 59 + ($idNumber == null ? 43 : $idNumber.hashCode());
      Object $annualInterest = this.getAnnualInterest();
      result = result * 59 + ($annualInterest == null ? 43 : $annualInterest.hashCode());
      Object $monthlyInterest = this.getMonthlyInterest();
      result = result * 59 + ($monthlyInterest == null ? 43 : $monthlyInterest.hashCode());
      Object $dayInterest = this.getDayInterest();
      result = result * 59 + ($dayInterest == null ? 43 : $dayInterest.hashCode());
      Object $usedCredit = this.getUsedCredit();
      result = result * 59 + ($usedCredit == null ? 43 : $usedCredit.hashCode());
      Object $remainingSum = this.getRemainingSum();
      result = result * 59 + ($remainingSum == null ? 43 : $remainingSum.hashCode());
      Object $closingDate = this.getClosingDate();
      result = result * 59 + ($closingDate == null ? 43 : $closingDate.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      return result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "ContractGivingCreditDto(id="
         + this.getId()
         + ", startDate="
         + this.getStartDate()
         + ", userId="
         + this.getUserId()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", userName="
         + this.getUserName()
         + ", accreditingPartyId="
         + this.getAccreditingPartyId()
         + ", lineOfCredit="
         + this.getLineOfCredit()
         + ", accreditingPartyName="
         + this.getAccreditingPartyName()
         + ", accreditingIdNumber="
         + this.getAccreditingIdNumber()
         + ", suretyId="
         + this.getSuretyId()
         + ", suretyName="
         + this.getSuretyName()
         + ", idNumber="
         + this.getIdNumber()
         + ", annualInterest="
         + this.getAnnualInterest()
         + ", monthlyInterest="
         + this.getMonthlyInterest()
         + ", dayInterest="
         + this.getDayInterest()
         + ", usedCredit="
         + this.getUsedCredit()
         + ", remainingSum="
         + this.getRemainingSum()
         + ", closingDate="
         + this.getClosingDate()
         + ", countDown="
         + this.getCountDown()
         + ", status="
         + this.getStatus()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ")";
   }

   public static class ContractGivingCreditDtoBuilder {
      private Long id;
      private LocalDateTime startDate;
      private Long userId;
      private Long projectId;
      private String projectName;
      private String userName;
      private Long accreditingPartyId;
      private BigDecimal lineOfCredit;
      private String accreditingPartyName;
      private String accreditingIdNumber;
      private Long suretyId;
      private String suretyName;
      private String idNumber;
      private BigDecimal annualInterest;
      private String monthlyInterest;
      private String dayInterest;
      private BigDecimal usedCredit;
      private BigDecimal remainingSum;
      private LocalDateTime closingDate;
      private Integer countDown;
      private Integer status;
      private AttachmentDTO attachmentDTOS;

      ContractGivingCreditDtoBuilder() {
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder accreditingPartyId(final Long accreditingPartyId) {
         this.accreditingPartyId = accreditingPartyId;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder lineOfCredit(final BigDecimal lineOfCredit) {
         this.lineOfCredit = lineOfCredit;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder accreditingPartyName(final String accreditingPartyName) {
         this.accreditingPartyName = accreditingPartyName;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder accreditingIdNumber(final String accreditingIdNumber) {
         this.accreditingIdNumber = accreditingIdNumber;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder suretyId(final Long suretyId) {
         this.suretyId = suretyId;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder suretyName(final String suretyName) {
         this.suretyName = suretyName;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder idNumber(final String idNumber) {
         this.idNumber = idNumber;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder annualInterest(final BigDecimal annualInterest) {
         this.annualInterest = annualInterest;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder monthlyInterest(final String monthlyInterest) {
         this.monthlyInterest = monthlyInterest;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder dayInterest(final String dayInterest) {
         this.dayInterest = dayInterest;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder usedCredit(final BigDecimal usedCredit) {
         this.usedCredit = usedCredit;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder remainingSum(final BigDecimal remainingSum) {
         this.remainingSum = remainingSum;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder closingDate(final LocalDateTime closingDate) {
         this.closingDate = closingDate;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder countDown(final Integer countDown) {
         this.countDown = countDown;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ContractGivingCreditDto.ContractGivingCreditDtoBuilder attachmentDTOS(final AttachmentDTO attachmentDTOS) {
         this.attachmentDTOS = attachmentDTOS;
         return this;
      }

      public ContractGivingCreditDto build() {
         return new ContractGivingCreditDto(
            this.id,
            this.startDate,
            this.userId,
            this.projectId,
            this.projectName,
            this.userName,
            this.accreditingPartyId,
            this.lineOfCredit,
            this.accreditingPartyName,
            this.accreditingIdNumber,
            this.suretyId,
            this.suretyName,
            this.idNumber,
            this.annualInterest,
            this.monthlyInterest,
            this.dayInterest,
            this.usedCredit,
            this.remainingSum,
            this.closingDate,
            this.countDown,
            this.status,
            this.attachmentDTOS
         );
      }

      @Override
      public String toString() {
         return "ContractGivingCreditDto.ContractGivingCreditDtoBuilder(id="
            + this.id
            + ", startDate="
            + this.startDate
            + ", userId="
            + this.userId
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", userName="
            + this.userName
            + ", accreditingPartyId="
            + this.accreditingPartyId
            + ", lineOfCredit="
            + this.lineOfCredit
            + ", accreditingPartyName="
            + this.accreditingPartyName
            + ", accreditingIdNumber="
            + this.accreditingIdNumber
            + ", suretyId="
            + this.suretyId
            + ", suretyName="
            + this.suretyName
            + ", idNumber="
            + this.idNumber
            + ", annualInterest="
            + this.annualInterest
            + ", monthlyInterest="
            + this.monthlyInterest
            + ", dayInterest="
            + this.dayInterest
            + ", usedCredit="
            + this.usedCredit
            + ", remainingSum="
            + this.remainingSum
            + ", closingDate="
            + this.closingDate
            + ", countDown="
            + this.countDown
            + ", status="
            + this.status
            + ", attachmentDTOS="
            + this.attachmentDTOS
            + ")";
      }
   }
}
