package com.hzchum.scim.crm.core.api.pojo.param;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CrmUploadTenderDocumentsParam {
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", notes = "项目id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "attachmentDTOList", notes = "附件信息")
   @NotEmpty(message = "请先上传附件")
   private List<AttachmentDTO> attachmentDTOList;
   @ApiModelProperty(name = "crmTenderRequirementTypeEnum", notes = "标类型")
   @NotNull(message = "请先选择标书类型")
   private Integer crmTenderRequirementTypeEnum;
   @ApiModelProperty(name = "businessProjectBidManagerQuote", value = "商务投标报价", notes = "商务投标报价")
   private BigDecimal businessProjectBidManagerQuote;
   @ApiModelProperty(name = "businessProjectBidManagerEstimatedWorks", value = "商务工程量", notes = "商务工程量")
   private BigDecimal businessProjectBidManagerEstimatedWorks;
   @ApiModelProperty(name = "businessProjectBidManagerCost", value = "商务成本", notes = "商务成本")
   private BigDecimal businessProjectBidManagerCost;
   @ApiModelProperty(name = "businessProjectBidManagerGrossProfit", value = "商务毛利", notes = "商务毛利")
   private BigDecimal businessProjectBidManagerGrossProfit;
   @ApiModelProperty(name = "businessProjectBidManagerRemark", value = "商务投标备注", notes = "商务投标备注")
   private String businessProjectBidManagerRemark;

   public CrmUploadTenderDocumentsParam(
      final Long crmProjectInformationWarehousingId,
      final List<AttachmentDTO> attachmentDTOList,
      final Integer crmTenderRequirementTypeEnum,
      final BigDecimal businessProjectBidManagerQuote,
      final BigDecimal businessProjectBidManagerEstimatedWorks,
      final BigDecimal businessProjectBidManagerCost,
      final BigDecimal businessProjectBidManagerGrossProfit,
      final String businessProjectBidManagerRemark
   ) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.attachmentDTOList = attachmentDTOList;
      this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
      this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
      this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
      this.businessProjectBidManagerCost = businessProjectBidManagerCost;
      this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
      this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
   }

   public CrmUploadTenderDocumentsParam() {
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public Integer getCrmTenderRequirementTypeEnum() {
      return this.crmTenderRequirementTypeEnum;
   }

   public BigDecimal getBusinessProjectBidManagerQuote() {
      return this.businessProjectBidManagerQuote;
   }

   public BigDecimal getBusinessProjectBidManagerEstimatedWorks() {
      return this.businessProjectBidManagerEstimatedWorks;
   }

   public BigDecimal getBusinessProjectBidManagerCost() {
      return this.businessProjectBidManagerCost;
   }

   public BigDecimal getBusinessProjectBidManagerGrossProfit() {
      return this.businessProjectBidManagerGrossProfit;
   }

   public String getBusinessProjectBidManagerRemark() {
      return this.businessProjectBidManagerRemark;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public void setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
   }

   public void setCrmTenderRequirementTypeEnum(final Integer crmTenderRequirementTypeEnum) {
      this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
   }

   public void setBusinessProjectBidManagerQuote(final BigDecimal businessProjectBidManagerQuote) {
      this.businessProjectBidManagerQuote = businessProjectBidManagerQuote;
   }

   public void setBusinessProjectBidManagerEstimatedWorks(final BigDecimal businessProjectBidManagerEstimatedWorks) {
      this.businessProjectBidManagerEstimatedWorks = businessProjectBidManagerEstimatedWorks;
   }

   public void setBusinessProjectBidManagerCost(final BigDecimal businessProjectBidManagerCost) {
      this.businessProjectBidManagerCost = businessProjectBidManagerCost;
   }

   public void setBusinessProjectBidManagerGrossProfit(final BigDecimal businessProjectBidManagerGrossProfit) {
      this.businessProjectBidManagerGrossProfit = businessProjectBidManagerGrossProfit;
   }

   public void setBusinessProjectBidManagerRemark(final String businessProjectBidManagerRemark) {
      this.businessProjectBidManagerRemark = businessProjectBidManagerRemark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmUploadTenderDocumentsParam)) {
         return false;
      }

      CrmUploadTenderDocumentsParam other = (CrmUploadTenderDocumentsParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
      if (this$crmProjectInformationWarehousingId == null
         ? other$crmProjectInformationWarehousingId == null
         : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
         Object this$crmTenderRequirementTypeEnum = this.getCrmTenderRequirementTypeEnum();
         Object other$crmTenderRequirementTypeEnum = other.getCrmTenderRequirementTypeEnum();
         if (this$crmTenderRequirementTypeEnum == null
            ? other$crmTenderRequirementTypeEnum == null
            : this$crmTenderRequirementTypeEnum.equals(other$crmTenderRequirementTypeEnum)) {
            Object this$attachmentDTOList = this.getAttachmentDTOList();
            Object other$attachmentDTOList = other.getAttachmentDTOList();
            if (this$attachmentDTOList == null ? other$attachmentDTOList == null : this$attachmentDTOList.equals(other$attachmentDTOList)) {
               Object this$businessProjectBidManagerQuote = this.getBusinessProjectBidManagerQuote();
               Object other$businessProjectBidManagerQuote = other.getBusinessProjectBidManagerQuote();
               if (this$businessProjectBidManagerQuote == null
                  ? other$businessProjectBidManagerQuote == null
                  : this$businessProjectBidManagerQuote.equals(other$businessProjectBidManagerQuote)) {
                  Object this$businessProjectBidManagerEstimatedWorks = this.getBusinessProjectBidManagerEstimatedWorks();
                  Object other$businessProjectBidManagerEstimatedWorks = other.getBusinessProjectBidManagerEstimatedWorks();
                  if (this$businessProjectBidManagerEstimatedWorks == null
                     ? other$businessProjectBidManagerEstimatedWorks == null
                     : this$businessProjectBidManagerEstimatedWorks.equals(other$businessProjectBidManagerEstimatedWorks)) {
                     Object this$businessProjectBidManagerCost = this.getBusinessProjectBidManagerCost();
                     Object other$businessProjectBidManagerCost = other.getBusinessProjectBidManagerCost();
                     if (this$businessProjectBidManagerCost == null
                        ? other$businessProjectBidManagerCost == null
                        : this$businessProjectBidManagerCost.equals(other$businessProjectBidManagerCost)) {
                        Object this$businessProjectBidManagerGrossProfit = this.getBusinessProjectBidManagerGrossProfit();
                        Object other$businessProjectBidManagerGrossProfit = other.getBusinessProjectBidManagerGrossProfit();
                        if (this$businessProjectBidManagerGrossProfit == null
                           ? other$businessProjectBidManagerGrossProfit == null
                           : this$businessProjectBidManagerGrossProfit.equals(other$businessProjectBidManagerGrossProfit)) {
                           Object this$businessProjectBidManagerRemark = this.getBusinessProjectBidManagerRemark();
                           Object other$businessProjectBidManagerRemark = other.getBusinessProjectBidManagerRemark();
                           return this$businessProjectBidManagerRemark == null
                              ? other$businessProjectBidManagerRemark == null
                              : this$businessProjectBidManagerRemark.equals(other$businessProjectBidManagerRemark);
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
      return other instanceof CrmUploadTenderDocumentsParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $crmTenderRequirementTypeEnum = this.getCrmTenderRequirementTypeEnum();
      result = result * 59 + ($crmTenderRequirementTypeEnum == null ? 43 : $crmTenderRequirementTypeEnum.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      result = result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
      Object $businessProjectBidManagerQuote = this.getBusinessProjectBidManagerQuote();
      result = result * 59 + ($businessProjectBidManagerQuote == null ? 43 : $businessProjectBidManagerQuote.hashCode());
      Object $businessProjectBidManagerEstimatedWorks = this.getBusinessProjectBidManagerEstimatedWorks();
      result = result * 59 + ($businessProjectBidManagerEstimatedWorks == null ? 43 : $businessProjectBidManagerEstimatedWorks.hashCode());
      Object $businessProjectBidManagerCost = this.getBusinessProjectBidManagerCost();
      result = result * 59 + ($businessProjectBidManagerCost == null ? 43 : $businessProjectBidManagerCost.hashCode());
      Object $businessProjectBidManagerGrossProfit = this.getBusinessProjectBidManagerGrossProfit();
      result = result * 59 + ($businessProjectBidManagerGrossProfit == null ? 43 : $businessProjectBidManagerGrossProfit.hashCode());
      Object $businessProjectBidManagerRemark = this.getBusinessProjectBidManagerRemark();
      return result * 59 + ($businessProjectBidManagerRemark == null ? 43 : $businessProjectBidManagerRemark.hashCode());
   }

   @Override
   public String toString() {
      return "CrmUploadTenderDocumentsParam(crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ", crmTenderRequirementTypeEnum="
         + this.getCrmTenderRequirementTypeEnum()
         + ", businessProjectBidManagerQuote="
         + this.getBusinessProjectBidManagerQuote()
         + ", businessProjectBidManagerEstimatedWorks="
         + this.getBusinessProjectBidManagerEstimatedWorks()
         + ", businessProjectBidManagerCost="
         + this.getBusinessProjectBidManagerCost()
         + ", businessProjectBidManagerGrossProfit="
         + this.getBusinessProjectBidManagerGrossProfit()
         + ", businessProjectBidManagerRemark="
         + this.getBusinessProjectBidManagerRemark()
         + ")";
   }
}
