package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.groups.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "SchedulingGroupsTreeVORequest", description = "生产线列表请求类")
public class SchedulingGroupsTreeVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "生产线名称", value = "生产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "type", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("type")
   @JSONField(name = "type")
   @NotNull(message = "可生产的板材类型,不能为空")
   private Integer type;

   public static SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder builder() {
      return new SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public SchedulingGroupsTreeVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public SchedulingGroupsTreeVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("factoryId")
   public SchedulingGroupsTreeVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public SchedulingGroupsTreeVORequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public SchedulingGroupsTreeVORequest setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("type")
   public SchedulingGroupsTreeVORequest setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "SchedulingGroupsTreeVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", type="
         + this.getType()
         + ")";
   }

   public SchedulingGroupsTreeVORequest(
      final Long id, final String name, final Long factoryId, final Long workshopId, final Long productionLineId, final Integer type
   ) {
      this.id = id;
      this.name = name;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.type = type;
   }

   public SchedulingGroupsTreeVORequest() {
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingGroupsTreeVORequest)) {
         return false;
      }

      SchedulingGroupsTreeVORequest other = (SchedulingGroupsTreeVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SchedulingGroupsTreeVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class SchedulingGroupsTreeVORequestBuilder {
      private Long id;
      private String name;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Integer type;

      SchedulingGroupsTreeVORequestBuilder() {
      }

      @JsonProperty("id")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("factoryId")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("type")
      public SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SchedulingGroupsTreeVORequest build() {
         return new SchedulingGroupsTreeVORequest(this.id, this.name, this.factoryId, this.workshopId, this.productionLineId, this.type);
      }

      @Override
      public String toString() {
         return "SchedulingGroupsTreeVORequest.SchedulingGroupsTreeVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", type="
            + this.type
            + ")";
      }
   }
}
