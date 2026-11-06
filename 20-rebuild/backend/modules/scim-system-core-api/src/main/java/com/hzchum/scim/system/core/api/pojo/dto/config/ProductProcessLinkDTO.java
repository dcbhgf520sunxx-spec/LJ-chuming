package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProductProcessLinkDTO", description = "总工序关联表")
public class ProductProcessLinkDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "productProcessId", notes = "产品工序id")
   private Long productProcessId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   private Long processId;
   @ApiModelProperty(name = "sequence", notes = "工序顺序")
   private Integer sequence;
   @ApiModelProperty(name = "name", notes = "工序名称")
   private String name;
   @ApiModelProperty(name = "nodeTime", notes = "时间节点")
   private Integer nodeTime;
   @ApiModelProperty(name = "productType", notes = "工序类型")
   private Integer productType;
   @ApiModelProperty(name = "type", value = "工序类型", notes = "工序类型")
   private Integer type;

   public Long getId() {
      return this.id;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public String getName() {
      return this.name;
   }

   public Integer getNodeTime() {
      return this.nodeTime;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getType() {
      return this.type;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setSequence(final Integer sequence) {
      this.sequence = sequence;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setNodeTime(final Integer nodeTime) {
      this.nodeTime = nodeTime;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProcessLinkDTO)) {
         return false;
      }

      ProductProcessLinkDTO other = (ProductProcessLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productProcessId = this.getProductProcessId();
         Object other$productProcessId = other.getProductProcessId();
         if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$sequence = this.getSequence();
               Object other$sequence = other.getSequence();
               if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                  Object this$nodeTime = this.getNodeTime();
                  Object other$nodeTime = other.getNodeTime();
                  if (this$nodeTime == null ? other$nodeTime == null : this$nodeTime.equals(other$nodeTime)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof ProductProcessLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $nodeTime = this.getNodeTime();
      result = result * 59 + ($nodeTime == null ? 43 : $nodeTime.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ProductProcessLinkDTO(id="
         + this.getId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", processId="
         + this.getProcessId()
         + ", sequence="
         + this.getSequence()
         + ", name="
         + this.getName()
         + ", nodeTime="
         + this.getNodeTime()
         + ", productType="
         + this.getProductType()
         + ", type="
         + this.getType()
         + ")";
   }
}
