package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "AssembleDetailDTO", description = "构件工序详情")
public class AssembleDetailDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "planId", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "producedQuantity", notes = "已生产")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "usedQuantity", notes = "已使用")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   private Integer usedQuantity;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "processSummaryDetailsList", notes = "工序汇总")
   @JsonProperty("processSummaryDetailsList")
   @JSONField(name = "processSummaryDetailsList")
   private List<ProcessSummaryDetailsDTO> processSummaryDetailsList;

   public static AssembleDetailDTO.AssembleDetailDTOBuilder builder() {
      return new AssembleDetailDTO.AssembleDetailDTOBuilder();
   }

   public AssembleDetailDTO() {
   }

   public AssembleDetailDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final String serialNumber,
      final Integer quantity,
      final Integer producedQuantity,
      final Integer usedQuantity,
      final String remark,
      final List<ProcessSummaryDetailsDTO> processSummaryDetailsList
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.serialNumber = serialNumber;
      this.quantity = quantity;
      this.producedQuantity = producedQuantity;
      this.usedQuantity = usedQuantity;
      this.remark = remark;
      this.processSummaryDetailsList = processSummaryDetailsList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<ProcessSummaryDetailsDTO> getProcessSummaryDetailsList() {
      return this.processSummaryDetailsList;
   }

   @JsonProperty("id")
   public AssembleDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public AssembleDetailDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public AssembleDetailDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public AssembleDetailDTO setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("serialNumber")
   public AssembleDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("quantity")
   public AssembleDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public AssembleDetailDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("usedQuantity")
   public AssembleDetailDTO setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("remark")
   public AssembleDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("processSummaryDetailsList")
   public AssembleDetailDTO setProcessSummaryDetailsList(final List<ProcessSummaryDetailsDTO> processSummaryDetailsList) {
      this.processSummaryDetailsList = processSummaryDetailsList;
      return this;
   }

   @Override
   public String toString() {
      return "AssembleDetailDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", remark="
         + this.getRemark()
         + ", processSummaryDetailsList="
         + this.getProcessSummaryDetailsList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleDetailDTO)) {
         return false;
      }

      AssembleDetailDTO other = (AssembleDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$planId = this.getPlanId();
               Object other$planId = other.getPlanId();
               if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$producedQuantity = this.getProducedQuantity();
                     Object other$producedQuantity = other.getProducedQuantity();
                     if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                        Object this$usedQuantity = this.getUsedQuantity();
                        Object other$usedQuantity = other.getUsedQuantity();
                        if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$processSummaryDetailsList = this.getProcessSummaryDetailsList();
                                 Object other$processSummaryDetailsList = other.getProcessSummaryDetailsList();
                                 return this$processSummaryDetailsList == null
                                    ? other$processSummaryDetailsList == null
                                    : this$processSummaryDetailsList.equals(other$processSummaryDetailsList);
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
      return other instanceof AssembleDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $processSummaryDetailsList = this.getProcessSummaryDetailsList();
      return result * 59 + ($processSummaryDetailsList == null ? 43 : $processSummaryDetailsList.hashCode());
   }

   public static class AssembleDetailDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private String serialNumber;
      private Integer quantity;
      private Integer producedQuantity;
      private Integer usedQuantity;
      private String remark;
      private List<ProcessSummaryDetailsDTO> processSummaryDetailsList;

      AssembleDetailDTOBuilder() {
      }

      @JsonProperty("id")
      public AssembleDetailDTO.AssembleDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public AssembleDetailDTO.AssembleDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public AssembleDetailDTO.AssembleDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public AssembleDetailDTO.AssembleDetailDTOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("serialNumber")
      public AssembleDetailDTO.AssembleDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("quantity")
      public AssembleDetailDTO.AssembleDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public AssembleDetailDTO.AssembleDetailDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("usedQuantity")
      public AssembleDetailDTO.AssembleDetailDTOBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("remark")
      public AssembleDetailDTO.AssembleDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("processSummaryDetailsList")
      public AssembleDetailDTO.AssembleDetailDTOBuilder processSummaryDetailsList(final List<ProcessSummaryDetailsDTO> processSummaryDetailsList) {
         this.processSummaryDetailsList = processSummaryDetailsList;
         return this;
      }

      public AssembleDetailDTO build() {
         return new AssembleDetailDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.planId,
            this.serialNumber,
            this.quantity,
            this.producedQuantity,
            this.usedQuantity,
            this.remark,
            this.processSummaryDetailsList
         );
      }

      @Override
      public String toString() {
         return "AssembleDetailDTO.AssembleDetailDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", serialNumber="
            + this.serialNumber
            + ", quantity="
            + this.quantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", usedQuantity="
            + this.usedQuantity
            + ", remark="
            + this.remark
            + ", processSummaryDetailsList="
            + this.processSummaryDetailsList
            + ")";
      }
   }
}
