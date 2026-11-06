package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("项目装焊配置工价修改审批表新增类")
public class MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   private Long id;
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   @NotNull(groups = {Add.class, Update.class}, message = "项目ID不能为空")
   private Long contractProjectId;
   @ApiModelProperty(name = "contractProjectAssemblingWeldingConfigId", value = "项目装焊配置ID", notes = "项目装焊配置ID")
   @NotNull(groups = Add.class, message = "项目装焊配置ID不能为空")
   private Long contractProjectAssemblingWeldingConfigId;
   @ApiModelProperty(name = "contractProjectAssemblingWeldingConfigDetailId", value = "项目装焊配置详情ID", notes = "项目装焊配置详情ID")
   @NotNull(groups = Add.class, message = "项目装焊配置ID不能为空")
   private Long contractProjectAssemblingWeldingConfigDetailId;
   @ApiModelProperty(name = "initiatorId", value = "发起人ID", notes = "发起人ID")
   @NotNull(groups = Add.class, message = "发起人ID不能为空")
   private Long initiatorId;
   @ApiModelProperty(name = "initiationDate", value = "发起日期", notes = "发起日期")
   @NotNull(groups = Add.class, message = "发起日期不能为空")
   private LocalDateTime initiationDate;
   @ApiModelProperty(name = "reviewerId", value = "审批人ID", notes = "审批人ID")
   @NotNull(groups = Update.class, message = "审批人ID不能为空")
   private Long reviewerId;
   @ApiModelProperty(name = "reviewDate", value = "审批日期", notes = "审批日期")
   @NotNull(groups = Update.class, message = "审批日期不能为空")
   private LocalDateTime reviewDate;
   @ApiModelProperty(name = "organizationInsidePrice", value = "编制内单价(元)", notes = "编制内单价(元)")
   @NotNull(groups = Add.class, message = "编制内单价(元)不能为空")
   @Positive(groups = Add.class, message = "编制内单价要大于0")
   private BigDecimal organizationInsidePrice;
   @ApiModelProperty(name = "organizationOutsidePrice", value = "编制外单价(元)", notes = "编制外单价(元)")
   @NotNull(groups = Add.class, message = "编制外单价(元)不能为空")
   @Positive(groups = Add.class, message = "编制外单价要大于0")
   private BigDecimal organizationOutsidePrice;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "reviewStatus", value = "审批状态(AuditStatusEnum)", notes = "审批状态(AuditStatusEnum)")
   @NotNull(groups = Update.class, message = "审批状态(AuditStatusEnum)不能为空")
   @EnumValidator(groups = Update.class, value = AuditStatusEnum.class, message = "审批状态不存在")
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewRemark", value = "审批备注", notes = "审批备注")
   private String reviewRemark;

   public static MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder builder() {
      return new MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder();
   }

   public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam() {
   }

   public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam(
      final Long id,
      final Long contractProjectId,
      final Long contractProjectAssemblingWeldingConfigId,
      final Long contractProjectAssemblingWeldingConfigDetailId,
      final Long initiatorId,
      final LocalDateTime initiationDate,
      final Long reviewerId,
      final LocalDateTime reviewDate,
      final BigDecimal organizationInsidePrice,
      final BigDecimal organizationOutsidePrice,
      final String remark,
      final Integer reviewStatus,
      final String reviewRemark
   ) {
      this.id = id;
      this.contractProjectId = contractProjectId;
      this.contractProjectAssemblingWeldingConfigId = contractProjectAssemblingWeldingConfigId;
      this.contractProjectAssemblingWeldingConfigDetailId = contractProjectAssemblingWeldingConfigDetailId;
      this.initiatorId = initiatorId;
      this.initiationDate = initiationDate;
      this.reviewerId = reviewerId;
      this.reviewDate = reviewDate;
      this.organizationInsidePrice = organizationInsidePrice;
      this.organizationOutsidePrice = organizationOutsidePrice;
      this.remark = remark;
      this.reviewStatus = reviewStatus;
      this.reviewRemark = reviewRemark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public Long getContractProjectAssemblingWeldingConfigId() {
      return this.contractProjectAssemblingWeldingConfigId;
   }

   public Long getContractProjectAssemblingWeldingConfigDetailId() {
      return this.contractProjectAssemblingWeldingConfigDetailId;
   }

   public Long getInitiatorId() {
      return this.initiatorId;
   }

   public LocalDateTime getInitiationDate() {
      return this.initiationDate;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public LocalDateTime getReviewDate() {
      return this.reviewDate;
   }

   public BigDecimal getOrganizationInsidePrice() {
      return this.organizationInsidePrice;
   }

   public BigDecimal getOrganizationOutsidePrice() {
      return this.organizationOutsidePrice;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getReviewRemark() {
      return this.reviewRemark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
   }

   public void setContractProjectAssemblingWeldingConfigId(final Long contractProjectAssemblingWeldingConfigId) {
      this.contractProjectAssemblingWeldingConfigId = contractProjectAssemblingWeldingConfigId;
   }

   public void setContractProjectAssemblingWeldingConfigDetailId(final Long contractProjectAssemblingWeldingConfigDetailId) {
      this.contractProjectAssemblingWeldingConfigDetailId = contractProjectAssemblingWeldingConfigDetailId;
   }

   public void setInitiatorId(final Long initiatorId) {
      this.initiatorId = initiatorId;
   }

   public void setInitiationDate(final LocalDateTime initiationDate) {
      this.initiationDate = initiationDate;
   }

   public void setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
   }

   public void setReviewDate(final LocalDateTime reviewDate) {
      this.reviewDate = reviewDate;
   }

   public void setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
   }

   public void setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setReviewRemark(final String reviewRemark) {
      this.reviewRemark = reviewRemark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam)) {
         return false;
      }

      MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam other = (MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
            Object this$contractProjectAssemblingWeldingConfigId = this.getContractProjectAssemblingWeldingConfigId();
            Object other$contractProjectAssemblingWeldingConfigId = other.getContractProjectAssemblingWeldingConfigId();
            if (this$contractProjectAssemblingWeldingConfigId == null
               ? other$contractProjectAssemblingWeldingConfigId == null
               : this$contractProjectAssemblingWeldingConfigId.equals(other$contractProjectAssemblingWeldingConfigId)) {
               Object this$contractProjectAssemblingWeldingConfigDetailId = this.getContractProjectAssemblingWeldingConfigDetailId();
               Object other$contractProjectAssemblingWeldingConfigDetailId = other.getContractProjectAssemblingWeldingConfigDetailId();
               if (this$contractProjectAssemblingWeldingConfigDetailId == null
                  ? other$contractProjectAssemblingWeldingConfigDetailId == null
                  : this$contractProjectAssemblingWeldingConfigDetailId.equals(other$contractProjectAssemblingWeldingConfigDetailId)) {
                  Object this$initiatorId = this.getInitiatorId();
                  Object other$initiatorId = other.getInitiatorId();
                  if (this$initiatorId == null ? other$initiatorId == null : this$initiatorId.equals(other$initiatorId)) {
                     Object this$reviewerId = this.getReviewerId();
                     Object other$reviewerId = other.getReviewerId();
                     if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                        Object this$reviewStatus = this.getReviewStatus();
                        Object other$reviewStatus = other.getReviewStatus();
                        if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                           Object this$initiationDate = this.getInitiationDate();
                           Object other$initiationDate = other.getInitiationDate();
                           if (this$initiationDate == null ? other$initiationDate == null : this$initiationDate.equals(other$initiationDate)) {
                              Object this$reviewDate = this.getReviewDate();
                              Object other$reviewDate = other.getReviewDate();
                              if (this$reviewDate == null ? other$reviewDate == null : this$reviewDate.equals(other$reviewDate)) {
                                 Object this$organizationInsidePrice = this.getOrganizationInsidePrice();
                                 Object other$organizationInsidePrice = other.getOrganizationInsidePrice();
                                 if (this$organizationInsidePrice == null
                                    ? other$organizationInsidePrice == null
                                    : this$organizationInsidePrice.equals(other$organizationInsidePrice)) {
                                    Object this$organizationOutsidePrice = this.getOrganizationOutsidePrice();
                                    Object other$organizationOutsidePrice = other.getOrganizationOutsidePrice();
                                    if (this$organizationOutsidePrice == null
                                       ? other$organizationOutsidePrice == null
                                       : this$organizationOutsidePrice.equals(other$organizationOutsidePrice)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                          Object this$reviewRemark = this.getReviewRemark();
                                          Object other$reviewRemark = other.getReviewRemark();
                                          return this$reviewRemark == null ? other$reviewRemark == null : this$reviewRemark.equals(other$reviewRemark);
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
      return other instanceof MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $contractProjectAssemblingWeldingConfigId = this.getContractProjectAssemblingWeldingConfigId();
      result = result * 59 + ($contractProjectAssemblingWeldingConfigId == null ? 43 : $contractProjectAssemblingWeldingConfigId.hashCode());
      Object $contractProjectAssemblingWeldingConfigDetailId = this.getContractProjectAssemblingWeldingConfigDetailId();
      result = result * 59 + ($contractProjectAssemblingWeldingConfigDetailId == null ? 43 : $contractProjectAssemblingWeldingConfigDetailId.hashCode());
      Object $initiatorId = this.getInitiatorId();
      result = result * 59 + ($initiatorId == null ? 43 : $initiatorId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $initiationDate = this.getInitiationDate();
      result = result * 59 + ($initiationDate == null ? 43 : $initiationDate.hashCode());
      Object $reviewDate = this.getReviewDate();
      result = result * 59 + ($reviewDate == null ? 43 : $reviewDate.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      result = result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $reviewRemark = this.getReviewRemark();
      return result * 59 + ($reviewRemark == null ? 43 : $reviewRemark.hashCode());
   }

   @Override
   public String toString() {
      return "MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", contractProjectAssemblingWeldingConfigId="
         + this.getContractProjectAssemblingWeldingConfigId()
         + ", contractProjectAssemblingWeldingConfigDetailId="
         + this.getContractProjectAssemblingWeldingConfigDetailId()
         + ", initiatorId="
         + this.getInitiatorId()
         + ", initiationDate="
         + this.getInitiationDate()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewDate="
         + this.getReviewDate()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ", remark="
         + this.getRemark()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewRemark="
         + this.getReviewRemark()
         + ")";
   }

   public static class MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder {
      private Long id;
      private Long contractProjectId;
      private Long contractProjectAssemblingWeldingConfigId;
      private Long contractProjectAssemblingWeldingConfigDetailId;
      private Long initiatorId;
      private LocalDateTime initiationDate;
      private Long reviewerId;
      private LocalDateTime reviewDate;
      private BigDecimal organizationInsidePrice;
      private BigDecimal organizationOutsidePrice;
      private String remark;
      private Integer reviewStatus;
      private String reviewRemark;

      MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder() {
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder contractProjectId(
         final Long contractProjectId
      ) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder contractProjectAssemblingWeldingConfigId(
         final Long contractProjectAssemblingWeldingConfigId
      ) {
         this.contractProjectAssemblingWeldingConfigId = contractProjectAssemblingWeldingConfigId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder contractProjectAssemblingWeldingConfigDetailId(
         final Long contractProjectAssemblingWeldingConfigDetailId
      ) {
         this.contractProjectAssemblingWeldingConfigDetailId = contractProjectAssemblingWeldingConfigDetailId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder initiatorId(
         final Long initiatorId
      ) {
         this.initiatorId = initiatorId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder initiationDate(
         final LocalDateTime initiationDate
      ) {
         this.initiationDate = initiationDate;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder reviewerId(
         final Long reviewerId
      ) {
         this.reviewerId = reviewerId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder reviewDate(
         final LocalDateTime reviewDate
      ) {
         this.reviewDate = reviewDate;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder organizationInsidePrice(
         final BigDecimal organizationInsidePrice
      ) {
         this.organizationInsidePrice = organizationInsidePrice;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder organizationOutsidePrice(
         final BigDecimal organizationOutsidePrice
      ) {
         this.organizationOutsidePrice = organizationOutsidePrice;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder remark(
         final String remark
      ) {
         this.remark = remark;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder reviewStatus(
         final Integer reviewStatus
      ) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder reviewRemark(
         final String reviewRemark
      ) {
         this.reviewRemark = reviewRemark;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam build() {
         return new MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam(
            this.id,
            this.contractProjectId,
            this.contractProjectAssemblingWeldingConfigId,
            this.contractProjectAssemblingWeldingConfigDetailId,
            this.initiatorId,
            this.initiationDate,
            this.reviewerId,
            this.reviewDate,
            this.organizationInsidePrice,
            this.organizationOutsidePrice,
            this.remark,
            this.reviewStatus,
            this.reviewRemark
         );
      }

      @Override
      public String toString() {
         return "MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParamBuilder(id="
            + this.id
            + ", contractProjectId="
            + this.contractProjectId
            + ", contractProjectAssemblingWeldingConfigId="
            + this.contractProjectAssemblingWeldingConfigId
            + ", contractProjectAssemblingWeldingConfigDetailId="
            + this.contractProjectAssemblingWeldingConfigDetailId
            + ", initiatorId="
            + this.initiatorId
            + ", initiationDate="
            + this.initiationDate
            + ", reviewerId="
            + this.reviewerId
            + ", reviewDate="
            + this.reviewDate
            + ", organizationInsidePrice="
            + this.organizationInsidePrice
            + ", organizationOutsidePrice="
            + this.organizationOutsidePrice
            + ", remark="
            + this.remark
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewRemark="
            + this.reviewRemark
            + ")";
      }
   }
}
