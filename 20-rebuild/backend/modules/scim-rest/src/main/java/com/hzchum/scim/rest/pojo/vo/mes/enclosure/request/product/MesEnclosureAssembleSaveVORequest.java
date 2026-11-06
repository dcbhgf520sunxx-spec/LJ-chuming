package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureAssembleDTOParam", description = "组立信息  ")
public class MesEnclosureAssembleSaveVORequest extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
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
   @ApiModelProperty(name = "regionId", notes = "区域id")
   @JsonProperty("regionId")
   @JSONField(name = "regionId")
   private Long regionId;
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

   public static MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder builder() {
      return new MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder();
   }

   public MesEnclosureAssembleSaveVORequest() {
   }

   public MesEnclosureAssembleSaveVORequest(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long regionId,
      final String serialNumber,
      final Integer quantity,
      final Integer producedQuantity,
      final Integer usedQuantity,
      final String remark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.regionId = regionId;
      this.serialNumber = serialNumber;
      this.quantity = quantity;
      this.producedQuantity = producedQuantity;
      this.usedQuantity = usedQuantity;
      this.remark = remark;
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

   public Long getRegionId() {
      return this.regionId;
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

   @JsonProperty("id")
   public MesEnclosureAssembleSaveVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureAssembleSaveVORequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureAssembleSaveVORequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("regionId")
   public MesEnclosureAssembleSaveVORequest setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureAssembleSaveVORequest setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureAssembleSaveVORequest setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public MesEnclosureAssembleSaveVORequest setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("usedQuantity")
   public MesEnclosureAssembleSaveVORequest setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureAssembleSaveVORequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureAssembleSaveVORequest(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", regionId="
         + this.getRegionId()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureAssembleSaveVORequest)) {
         return false;
      }

      MesEnclosureAssembleSaveVORequest other = (MesEnclosureAssembleSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
               Object this$regionId = this.getRegionId();
               Object other$regionId = other.getRegionId();
               if (this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureAssembleSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MesEnclosureAssembleSaveVORequestBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long regionId;
      private String serialNumber;
      private Integer quantity;
      private Integer producedQuantity;
      private Integer usedQuantity;
      private String remark;

      MesEnclosureAssembleSaveVORequestBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("regionId")
      public MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("usedQuantity")
      public MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesEnclosureAssembleSaveVORequest build() {
         return new MesEnclosureAssembleSaveVORequest(
            this.id, this.projectId, this.monomerId, this.regionId, this.serialNumber, this.quantity, this.producedQuantity, this.usedQuantity, this.remark
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureAssembleSaveVORequest.MesEnclosureAssembleSaveVORequestBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", regionId="
            + this.regionId
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
            + ")";
      }
   }
}
