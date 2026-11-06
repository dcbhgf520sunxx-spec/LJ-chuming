package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.productionLine.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProductionLineSaveVORequest", description = "")
public class ProductionLineSaveVORequest {
   @ApiModelProperty(name = "name", notes = "生产线名称", value = "生产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @NotNull(message = "名称不能为空")
   private String name;
   @ApiModelProperty(name = "sort", notes = "排序", value = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "remark", notes = "备注", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @NotNull(message = "车间id不能为空")
   private Long workshopId;
   @ApiModelProperty(name = "type", value = "围护类型 2压型彩板 4夹心板 8桁架楼承板 16压型楼承板 32折边件 ", notes = "围护类型 2压型彩板 4夹心板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "linkIdList", value = "产品种类", notes = "产品种类")
   @JsonProperty("linkIdList")
   @JSONField(name = "linkIdList")
   private List<Long> linkIdList;
   @ApiModelProperty(name = "targetProduction", value = "目标产量", notes = "目标产量")
   @JsonProperty("targetProduction")
   @JSONField(name = "targetProduction")
   private BigDecimal targetProduction;

   public static ProductionLineSaveVORequest.ProductionLineSaveVORequestBuilder builder() {
      return new ProductionLineSaveVORequest.ProductionLineSaveVORequestBuilder();
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getType() {
      return this.type;
   }

   public List<Long> getLinkIdList() {
      return this.linkIdList;
   }

   public BigDecimal getTargetProduction() {
      return this.targetProduction;
   }

   @JsonProperty("name")
   public ProductionLineSaveVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public ProductionLineSaveVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("remark")
   public ProductionLineSaveVORequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("factoryId")
   public ProductionLineSaveVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public ProductionLineSaveVORequest setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("type")
   public ProductionLineSaveVORequest setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("linkIdList")
   public ProductionLineSaveVORequest setLinkIdList(final List<Long> linkIdList) {
      this.linkIdList = linkIdList;
      return this;
   }

   @JsonProperty("targetProduction")
   public ProductionLineSaveVORequest setTargetProduction(final BigDecimal targetProduction) {
      this.targetProduction = targetProduction;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionLineSaveVORequest(name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", type="
         + this.getType()
         + ", linkIdList="
         + this.getLinkIdList()
         + ", targetProduction="
         + this.getTargetProduction()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionLineSaveVORequest)) {
         return false;
      }

      ProductionLineSaveVORequest other = (ProductionLineSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                        Object this$linkIdList = this.getLinkIdList();
                        Object other$linkIdList = other.getLinkIdList();
                        if (this$linkIdList == null ? other$linkIdList == null : this$linkIdList.equals(other$linkIdList)) {
                           Object this$targetProduction = this.getTargetProduction();
                           Object other$targetProduction = other.getTargetProduction();
                           return this$targetProduction == null ? other$targetProduction == null : this$targetProduction.equals(other$targetProduction);
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
      return other instanceof ProductionLineSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $linkIdList = this.getLinkIdList();
      result = result * 59 + ($linkIdList == null ? 43 : $linkIdList.hashCode());
      Object $targetProduction = this.getTargetProduction();
      return result * 59 + ($targetProduction == null ? 43 : $targetProduction.hashCode());
   }

   public ProductionLineSaveVORequest(
      final String name,
      final Integer sort,
      final String remark,
      final Long factoryId,
      final Long workshopId,
      final Integer type,
      final List<Long> linkIdList,
      final BigDecimal targetProduction
   ) {
      this.name = name;
      this.sort = sort;
      this.remark = remark;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.type = type;
      this.linkIdList = linkIdList;
      this.targetProduction = targetProduction;
   }

   public ProductionLineSaveVORequest() {
   }

   public static class ProductionLineSaveVORequestBuilder {
      private String name;
      private Integer sort;
      private String remark;
      private Long factoryId;
      private Long workshopId;
      private Integer type;
      private List<Long> linkIdList;
      private BigDecimal targetProduction;

      ProductionLineSaveVORequestBuilder() {
      }

      @JsonProperty("name")
      public ProductionLineSaveVORequest.ProductionLineSaveVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public ProductionLineSaveVORequest.ProductionLineSaveVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("remark")
      public ProductionLineSaveVORequest.ProductionLineSaveVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("factoryId")
      public ProductionLineSaveVORequest.ProductionLineSaveVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public ProductionLineSaveVORequest.ProductionLineSaveVORequestBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("type")
      public ProductionLineSaveVORequest.ProductionLineSaveVORequestBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("linkIdList")
      public ProductionLineSaveVORequest.ProductionLineSaveVORequestBuilder linkIdList(final List<Long> linkIdList) {
         this.linkIdList = linkIdList;
         return this;
      }

      @JsonProperty("targetProduction")
      public ProductionLineSaveVORequest.ProductionLineSaveVORequestBuilder targetProduction(final BigDecimal targetProduction) {
         this.targetProduction = targetProduction;
         return this;
      }

      public ProductionLineSaveVORequest build() {
         return new ProductionLineSaveVORequest(
            this.name, this.sort, this.remark, this.factoryId, this.workshopId, this.type, this.linkIdList, this.targetProduction
         );
      }

      @Override
      public String toString() {
         return "ProductionLineSaveVORequest.ProductionLineSaveVORequestBuilder(name="
            + this.name
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", type="
            + this.type
            + ", linkIdList="
            + this.linkIdList
            + ", targetProduction="
            + this.targetProduction
            + ")";
      }
   }
}
