package com.hzchum.scim.contract.core.api.pojo.dtoParam.visa;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(description = "结算请求类 ")
public class ContractSettlementDTOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("id")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Integer id;
   @ApiModelProperty("项目id")
   @NotNull(groups = Add.class, message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty("申请人")
   @NotNull(message = "申请人不能为空")
   private Long userId;
   @ApiModelProperty("签证额")
   @NotNull(message = "签证额不能为空")
   private BigDecimal visaAmount;
   @ApiModelProperty("违约额")
   @NotNull(message = "违约额不能为空")
   private BigDecimal breachAmount;
   @ApiModelProperty("加工结算额")
   private BigDecimal processingSettlementAmount;
   @ApiModelProperty("最终结算额")
   @NotNull(message = "最终结算额不能为空")
   private BigDecimal settlementAmount;
   @ApiModelProperty("结算日期")
   private LocalDate settlementDate;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("附件")
   private List<Long> attachmentIds;

   public Integer getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getVisaAmount() {
      return this.visaAmount;
   }

   public BigDecimal getBreachAmount() {
      return this.breachAmount;
   }

   public BigDecimal getProcessingSettlementAmount() {
      return this.processingSettlementAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public LocalDate getSettlementDate() {
      return this.settlementDate;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setVisaAmount(final BigDecimal visaAmount) {
      this.visaAmount = visaAmount;
   }

   public void setBreachAmount(final BigDecimal breachAmount) {
      this.breachAmount = breachAmount;
   }

   public void setProcessingSettlementAmount(final BigDecimal processingSettlementAmount) {
      this.processingSettlementAmount = processingSettlementAmount;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setSettlementDate(final LocalDate settlementDate) {
      this.settlementDate = settlementDate;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractSettlementDTOParam)) {
         return false;
      }

      ContractSettlementDTOParam other = (ContractSettlementDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$visaAmount = this.getVisaAmount();
               Object other$visaAmount = other.getVisaAmount();
               if (this$visaAmount == null ? other$visaAmount == null : this$visaAmount.equals(other$visaAmount)) {
                  Object this$breachAmount = this.getBreachAmount();
                  Object other$breachAmount = other.getBreachAmount();
                  if (this$breachAmount == null ? other$breachAmount == null : this$breachAmount.equals(other$breachAmount)) {
                     Object this$processingSettlementAmount = this.getProcessingSettlementAmount();
                     Object other$processingSettlementAmount = other.getProcessingSettlementAmount();
                     if (this$processingSettlementAmount == null
                        ? other$processingSettlementAmount == null
                        : this$processingSettlementAmount.equals(other$processingSettlementAmount)) {
                        Object this$settlementAmount = this.getSettlementAmount();
                        Object other$settlementAmount = other.getSettlementAmount();
                        if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                           Object this$settlementDate = this.getSettlementDate();
                           Object other$settlementDate = other.getSettlementDate();
                           if (this$settlementDate == null ? other$settlementDate == null : this$settlementDate.equals(other$settlementDate)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$attachmentIds = this.getAttachmentIds();
                                 Object other$attachmentIds = other.getAttachmentIds();
                                 return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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
      return other instanceof ContractSettlementDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $visaAmount = this.getVisaAmount();
      result = result * 59 + ($visaAmount == null ? 43 : $visaAmount.hashCode());
      Object $breachAmount = this.getBreachAmount();
      result = result * 59 + ($breachAmount == null ? 43 : $breachAmount.hashCode());
      Object $processingSettlementAmount = this.getProcessingSettlementAmount();
      result = result * 59 + ($processingSettlementAmount == null ? 43 : $processingSettlementAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $settlementDate = this.getSettlementDate();
      result = result * 59 + ($settlementDate == null ? 43 : $settlementDate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "ContractSettlementDTOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", userId="
         + this.getUserId()
         + ", visaAmount="
         + this.getVisaAmount()
         + ", breachAmount="
         + this.getBreachAmount()
         + ", processingSettlementAmount="
         + this.getProcessingSettlementAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", settlementDate="
         + this.getSettlementDate()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }
}
