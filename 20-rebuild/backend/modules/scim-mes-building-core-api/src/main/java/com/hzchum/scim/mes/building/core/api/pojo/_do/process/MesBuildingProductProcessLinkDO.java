package com.hzchum.scim.mes.building.core.api.pojo._do.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingProductProcessLinkDO对象", description = "")
public class MesBuildingProductProcessLinkDO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productProcessId", notes = "产品工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "name", notes = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "sequence", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;
   @ApiModelProperty(name = "nodeTime", value = "时间节点", notes = "时间节点")
   @JsonProperty("nodeTime")
   @JSONField(name = "nodeTime")
   private Integer nodeTime;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "typeId", value = "类型id", notes = "类型id")
   @JsonProperty("typeId")
   @JSONField(name = "typeId")
   private Long typeId;
   @ApiModelProperty(name = "type", value = "工序类型", notes = "工序类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;

   public static MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder builder() {
      return new MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder();
   }

   public MesBuildingProductProcessLinkDO() {
   }

   public MesBuildingProductProcessLinkDO(
      final Long id,
      final Long productProcessId,
      final Long processId,
      final String name,
      final Integer sequence,
      final Integer nodeTime,
      final Integer productType,
      final Long typeId,
      final Integer type
   ) {
      this.id = id;
      this.productProcessId = productProcessId;
      this.processId = processId;
      this.name = name;
      this.sequence = sequence;
      this.nodeTime = nodeTime;
      this.productType = productType;
      this.typeId = typeId;
      this.type = type;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public Integer getNodeTime() {
      return this.nodeTime;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getTypeId() {
      return this.typeId;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public MesBuildingProductProcessLinkDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesBuildingProductProcessLinkDO setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProductProcessLinkDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProductProcessLinkDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingProductProcessLinkDO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("nodeTime")
   public MesBuildingProductProcessLinkDO setNodeTime(final Integer nodeTime) {
      this.nodeTime = nodeTime;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProductProcessLinkDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("typeId")
   public MesBuildingProductProcessLinkDO setTypeId(final Long typeId) {
      this.typeId = typeId;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingProductProcessLinkDO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductProcessLinkDO(id="
         + this.getId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", processId="
         + this.getProcessId()
         + ", name="
         + this.getName()
         + ", sequence="
         + this.getSequence()
         + ", nodeTime="
         + this.getNodeTime()
         + ", productType="
         + this.getProductType()
         + ", typeId="
         + this.getTypeId()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductProcessLinkDO)) {
         return false;
      }

      MesBuildingProductProcessLinkDO other = (MesBuildingProductProcessLinkDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                        Object this$typeId = this.getTypeId();
                        Object other$typeId = other.getTypeId();
                        if (this$typeId == null ? other$typeId == null : this$typeId.equals(other$typeId)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductProcessLinkDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      Object $typeId = this.getTypeId();
      result = result * 59 + ($typeId == null ? 43 : $typeId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesBuildingProductProcessLinkDOBuilder {
      private Long id;
      private Long productProcessId;
      private Long processId;
      private String name;
      private Integer sequence;
      private Integer nodeTime;
      private Integer productType;
      private Long typeId;
      private Integer type;

      MesBuildingProductProcessLinkDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("nodeTime")
      public MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder nodeTime(final Integer nodeTime) {
         this.nodeTime = nodeTime;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("typeId")
      public MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder typeId(final Long typeId) {
         this.typeId = typeId;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesBuildingProductProcessLinkDO build() {
         return new MesBuildingProductProcessLinkDO(
            this.id, this.productProcessId, this.processId, this.name, this.sequence, this.nodeTime, this.productType, this.typeId, this.type
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductProcessLinkDO.MesBuildingProductProcessLinkDOBuilder(id="
            + this.id
            + ", productProcessId="
            + this.productProcessId
            + ", processId="
            + this.processId
            + ", name="
            + this.name
            + ", sequence="
            + this.sequence
            + ", nodeTime="
            + this.nodeTime
            + ", productType="
            + this.productType
            + ", typeId="
            + this.typeId
            + ", type="
            + this.type
            + ")";
      }
   }
}
