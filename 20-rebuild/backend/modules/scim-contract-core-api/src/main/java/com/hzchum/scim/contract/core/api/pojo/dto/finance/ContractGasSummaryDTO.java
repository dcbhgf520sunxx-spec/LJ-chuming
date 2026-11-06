package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ContractGasSummary对象", description = "气体用量统计表 ")
public class ContractGasSummaryDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "基础类型", notes = "基础类型")
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目表ID", notes = "科目表ID")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目表", notes = "科目表")
   private String classifyName;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "year", value = "年度 (例:2022)", notes = "年度 (例:2022)")
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份(1~12)", notes = "月份(1~12)")
   private Integer month;
   @ApiModelProperty(name = "yearMonthValue", value = "年月(格式 202208)", notes = "年月(格式 202208)")
   private Integer yearMonthValue;
   @ApiModelProperty(name = "usedMete", value = "使用量", notes = "使用量")
   private BigDecimal usedMete;
   @ApiModelProperty(name = "totalAmount", value = "总额(元)", notes = "总额(元)")
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "avgUnitPrice", value = "平均单价(元)", notes = "平均单价(元)")
   private BigDecimal avgUnitPrice;
   @ApiModelProperty(name = "boolConfirmStatus", value = "确认状态 0未确认 1已确认", notes = "确认状态 0未确认 1已确认")
   private Boolean boolConfirmStatus;
   @ApiModelProperty(name = "userId", value = "录入人ID", notes = "录入人ID")
   private Long userId;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID字符串", notes = "附件ID字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "attachments", value = "附件列表", notes = "附件列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static ContractGasSummaryDTO.ContractGasSummaryDTOBuilder builder() {
      return new ContractGasSummaryDTO.ContractGasSummaryDTOBuilder();
   }

   public ContractGasSummaryDTO() {
   }

   public ContractGasSummaryDTO(
      final Long id,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String accountingUnit,
      final Integer year,
      final Integer month,
      final Integer yearMonthValue,
      final BigDecimal usedMete,
      final BigDecimal totalAmount,
      final BigDecimal avgUnitPrice,
      final Boolean boolConfirmStatus,
      final Long userId,
      final String attachmentIds,
      final List<AttachmentDTO> attachments,
      final String remark
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.accountingUnit = accountingUnit;
      this.year = year;
      this.month = month;
      this.yearMonthValue = yearMonthValue;
      this.usedMete = usedMete;
      this.totalAmount = totalAmount;
      this.avgUnitPrice = avgUnitPrice;
      this.boolConfirmStatus = boolConfirmStatus;
      this.userId = userId;
      this.attachmentIds = attachmentIds;
      this.attachments = attachments;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getMonth() {
      return this.month;
   }

   public Integer getYearMonthValue() {
      return this.yearMonthValue;
   }

   public BigDecimal getUsedMete() {
      return this.usedMete;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public BigDecimal getAvgUnitPrice() {
      return this.avgUnitPrice;
   }

   public Boolean getBoolConfirmStatus() {
      return this.boolConfirmStatus;
   }

   public Long getUserId() {
      return this.userId;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setYearMonthValue(final Integer yearMonthValue) {
      this.yearMonthValue = yearMonthValue;
   }

   public void setUsedMete(final BigDecimal usedMete) {
      this.usedMete = usedMete;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setAvgUnitPrice(final BigDecimal avgUnitPrice) {
      this.avgUnitPrice = avgUnitPrice;
   }

   public void setBoolConfirmStatus(final Boolean boolConfirmStatus) {
      this.boolConfirmStatus = boolConfirmStatus;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractGasSummaryDTO)) {
         return false;
      }

      ContractGasSummaryDTO other = (ContractGasSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$year = this.getYear();
               Object other$year = other.getYear();
               if (this$year == null ? other$year == null : this$year.equals(other$year)) {
                  Object this$month = this.getMonth();
                  Object other$month = other.getMonth();
                  if (this$month == null ? other$month == null : this$month.equals(other$month)) {
                     Object this$yearMonthValue = this.getYearMonthValue();
                     Object other$yearMonthValue = other.getYearMonthValue();
                     if (this$yearMonthValue == null ? other$yearMonthValue == null : this$yearMonthValue.equals(other$yearMonthValue)) {
                        Object this$boolConfirmStatus = this.getBoolConfirmStatus();
                        Object other$boolConfirmStatus = other.getBoolConfirmStatus();
                        if (this$boolConfirmStatus == null ? other$boolConfirmStatus == null : this$boolConfirmStatus.equals(other$boolConfirmStatus)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$classifyName = this.getClassifyName();
                              Object other$classifyName = other.getClassifyName();
                              if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                 Object this$accountingUnit = this.getAccountingUnit();
                                 Object other$accountingUnit = other.getAccountingUnit();
                                 if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                    Object this$usedMete = this.getUsedMete();
                                    Object other$usedMete = other.getUsedMete();
                                    if (this$usedMete == null ? other$usedMete == null : this$usedMete.equals(other$usedMete)) {
                                       Object this$totalAmount = this.getTotalAmount();
                                       Object other$totalAmount = other.getTotalAmount();
                                       if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                                          Object this$avgUnitPrice = this.getAvgUnitPrice();
                                          Object other$avgUnitPrice = other.getAvgUnitPrice();
                                          if (this$avgUnitPrice == null ? other$avgUnitPrice == null : this$avgUnitPrice.equals(other$avgUnitPrice)) {
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
      return other instanceof ContractGasSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $yearMonthValue = this.getYearMonthValue();
      result = result * 59 + ($yearMonthValue == null ? 43 : $yearMonthValue.hashCode());
      Object $boolConfirmStatus = this.getBoolConfirmStatus();
      result = result * 59 + ($boolConfirmStatus == null ? 43 : $boolConfirmStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $usedMete = this.getUsedMete();
      result = result * 59 + ($usedMete == null ? 43 : $usedMete.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $avgUnitPrice = this.getAvgUnitPrice();
      result = result * 59 + ($avgUnitPrice == null ? 43 : $avgUnitPrice.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractGasSummaryDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", yearMonthValue="
         + this.getYearMonthValue()
         + ", usedMete="
         + this.getUsedMete()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", avgUnitPrice="
         + this.getAvgUnitPrice()
         + ", boolConfirmStatus="
         + this.getBoolConfirmStatus()
         + ", userId="
         + this.getUserId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ContractGasSummaryDTOBuilder {
      private Long id;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String accountingUnit;
      private Integer year;
      private Integer month;
      private Integer yearMonthValue;
      private BigDecimal usedMete;
      private BigDecimal totalAmount;
      private BigDecimal avgUnitPrice;
      private Boolean boolConfirmStatus;
      private Long userId;
      private String attachmentIds;
      private List<AttachmentDTO> attachments;
      private String remark;

      ContractGasSummaryDTOBuilder() {
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder yearMonthValue(final Integer yearMonthValue) {
         this.yearMonthValue = yearMonthValue;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder usedMete(final BigDecimal usedMete) {
         this.usedMete = usedMete;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder avgUnitPrice(final BigDecimal avgUnitPrice) {
         this.avgUnitPrice = avgUnitPrice;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder boolConfirmStatus(final Boolean boolConfirmStatus) {
         this.boolConfirmStatus = boolConfirmStatus;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ContractGasSummaryDTO.ContractGasSummaryDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractGasSummaryDTO build() {
         return new ContractGasSummaryDTO(
            this.id,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.accountingUnit,
            this.year,
            this.month,
            this.yearMonthValue,
            this.usedMete,
            this.totalAmount,
            this.avgUnitPrice,
            this.boolConfirmStatus,
            this.userId,
            this.attachmentIds,
            this.attachments,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractGasSummaryDTO.ContractGasSummaryDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", accountingUnit="
            + this.accountingUnit
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", yearMonthValue="
            + this.yearMonthValue
            + ", usedMete="
            + this.usedMete
            + ", totalAmount="
            + this.totalAmount
            + ", avgUnitPrice="
            + this.avgUnitPrice
            + ", boolConfirmStatus="
            + this.boolConfirmStatus
            + ", userId="
            + this.userId
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
