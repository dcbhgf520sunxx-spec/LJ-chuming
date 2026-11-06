package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ContractWageSummary对象", description = "员工工资统计表 ")
public class ContractWageSummaryDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "wageType", value = "工资类型 1管理人员工资 2生产人员工资", notes = "工资类型 1管理人员工资 2生产人员工资")
   private Integer wageType;
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份(1~12)", notes = "月份(1~12)")
   private Integer month;
   @ApiModelProperty(name = "employeeQuantity", value = "员工数量", notes = "员工数量")
   private Integer employeeQuantity;
   @ApiModelProperty(name = "totalWage", value = "工资总额", notes = "工资总额")
   private BigDecimal totalWage;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "attachments", value = "附件对象列表", notes = "附件对象列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "userId", value = "录入用户ID", notes = "录入用户ID")
   private Long userId;
   @ApiModelProperty(name = "boolConfirmStatus", value = "确认状态 0未确认 1已确认", notes = "确认状态 0未确认 1已确认")
   private Boolean boolConfirmStatus;

   public static ContractWageSummaryDTO.ContractWageSummaryDTOBuilder builder() {
      return new ContractWageSummaryDTO.ContractWageSummaryDTOBuilder();
   }

   public ContractWageSummaryDTO() {
   }

   public ContractWageSummaryDTO(
      final Long id,
      final Integer wageType,
      final Integer year,
      final Integer month,
      final Integer employeeQuantity,
      final BigDecimal totalWage,
      final String attachmentIds,
      final List<AttachmentDTO> attachments,
      final String remark,
      final Long userId,
      final Boolean boolConfirmStatus
   ) {
      this.id = id;
      this.wageType = wageType;
      this.year = year;
      this.month = month;
      this.employeeQuantity = employeeQuantity;
      this.totalWage = totalWage;
      this.attachmentIds = attachmentIds;
      this.attachments = attachments;
      this.remark = remark;
      this.userId = userId;
      this.boolConfirmStatus = boolConfirmStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getWageType() {
      return this.wageType;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getMonth() {
      return this.month;
   }

   public Integer getEmployeeQuantity() {
      return this.employeeQuantity;
   }

   public BigDecimal getTotalWage() {
      return this.totalWage;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getBoolConfirmStatus() {
      return this.boolConfirmStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWageType(final Integer wageType) {
      this.wageType = wageType;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setEmployeeQuantity(final Integer employeeQuantity) {
      this.employeeQuantity = employeeQuantity;
   }

   public void setTotalWage(final BigDecimal totalWage) {
      this.totalWage = totalWage;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setBoolConfirmStatus(final Boolean boolConfirmStatus) {
      this.boolConfirmStatus = boolConfirmStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWageSummaryDTO)) {
         return false;
      }

      ContractWageSummaryDTO other = (ContractWageSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$wageType = this.getWageType();
         Object other$wageType = other.getWageType();
         if (this$wageType == null ? other$wageType == null : this$wageType.equals(other$wageType)) {
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$month = this.getMonth();
               Object other$month = other.getMonth();
               if (this$month == null ? other$month == null : this$month.equals(other$month)) {
                  Object this$employeeQuantity = this.getEmployeeQuantity();
                  Object other$employeeQuantity = other.getEmployeeQuantity();
                  if (this$employeeQuantity == null ? other$employeeQuantity == null : this$employeeQuantity.equals(other$employeeQuantity)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$boolConfirmStatus = this.getBoolConfirmStatus();
                        Object other$boolConfirmStatus = other.getBoolConfirmStatus();
                        if (this$boolConfirmStatus == null ? other$boolConfirmStatus == null : this$boolConfirmStatus.equals(other$boolConfirmStatus)) {
                           Object this$totalWage = this.getTotalWage();
                           Object other$totalWage = other.getTotalWage();
                           if (this$totalWage == null ? other$totalWage == null : this$totalWage.equals(other$totalWage)) {
                              Object this$attachmentIds = this.getAttachmentIds();
                              Object other$attachmentIds = other.getAttachmentIds();
                              if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                                 Object this$attachments = this.getAttachments();
                                 Object other$attachments = other.getAttachments();
                                 if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ContractWageSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $wageType = this.getWageType();
      result = result * 59 + ($wageType == null ? 43 : $wageType.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $employeeQuantity = this.getEmployeeQuantity();
      result = result * 59 + ($employeeQuantity == null ? 43 : $employeeQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolConfirmStatus = this.getBoolConfirmStatus();
      result = result * 59 + ($boolConfirmStatus == null ? 43 : $boolConfirmStatus.hashCode());
      Object $totalWage = this.getTotalWage();
      result = result * 59 + ($totalWage == null ? 43 : $totalWage.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWageSummaryDTO(id="
         + this.getId()
         + ", wageType="
         + this.getWageType()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", employeeQuantity="
         + this.getEmployeeQuantity()
         + ", totalWage="
         + this.getTotalWage()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", boolConfirmStatus="
         + this.getBoolConfirmStatus()
         + ")";
   }

   public static class ContractWageSummaryDTOBuilder {
      private Long id;
      private Integer wageType;
      private Integer year;
      private Integer month;
      private Integer employeeQuantity;
      private BigDecimal totalWage;
      private String attachmentIds;
      private List<AttachmentDTO> attachments;
      private String remark;
      private Long userId;
      private Boolean boolConfirmStatus;

      ContractWageSummaryDTOBuilder() {
      }

      public ContractWageSummaryDTO.ContractWageSummaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWageSummaryDTO.ContractWageSummaryDTOBuilder wageType(final Integer wageType) {
         this.wageType = wageType;
         return this;
      }

      public ContractWageSummaryDTO.ContractWageSummaryDTOBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractWageSummaryDTO.ContractWageSummaryDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractWageSummaryDTO.ContractWageSummaryDTOBuilder employeeQuantity(final Integer employeeQuantity) {
         this.employeeQuantity = employeeQuantity;
         return this;
      }

      public ContractWageSummaryDTO.ContractWageSummaryDTOBuilder totalWage(final BigDecimal totalWage) {
         this.totalWage = totalWage;
         return this;
      }

      public ContractWageSummaryDTO.ContractWageSummaryDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractWageSummaryDTO.ContractWageSummaryDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractWageSummaryDTO.ContractWageSummaryDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractWageSummaryDTO.ContractWageSummaryDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractWageSummaryDTO.ContractWageSummaryDTOBuilder boolConfirmStatus(final Boolean boolConfirmStatus) {
         this.boolConfirmStatus = boolConfirmStatus;
         return this;
      }

      public ContractWageSummaryDTO build() {
         return new ContractWageSummaryDTO(
            this.id,
            this.wageType,
            this.year,
            this.month,
            this.employeeQuantity,
            this.totalWage,
            this.attachmentIds,
            this.attachments,
            this.remark,
            this.userId,
            this.boolConfirmStatus
         );
      }

      @Override
      public String toString() {
         return "ContractWageSummaryDTO.ContractWageSummaryDTOBuilder(id="
            + this.id
            + ", wageType="
            + this.wageType
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", employeeQuantity="
            + this.employeeQuantity
            + ", totalWage="
            + this.totalWage
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", boolConfirmStatus="
            + this.boolConfirmStatus
            + ")";
      }
   }
}
