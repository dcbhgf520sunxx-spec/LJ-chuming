package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.productionLine.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProductionLineUpdateVORequest", description = "")
public class ProductionLineUpdateVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "name", notes = "生产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @NotNull(message = "名称不能为空")
   private String name;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "type", value = "可生产板材类型", notes = "可生产板材类型")
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

   public static ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder builder() {
      return new ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder();
   }

   public Long getId() {
      return this.id;
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

   public Integer getType() {
      return this.type;
   }

   public List<Long> getLinkIdList() {
      return this.linkIdList;
   }

   public BigDecimal getTargetProduction() {
      return this.targetProduction;
   }

   @JsonProperty("id")
   public ProductionLineUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProductionLineUpdateVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public ProductionLineUpdateVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("remark")
   public ProductionLineUpdateVORequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("type")
   public ProductionLineUpdateVORequest setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("linkIdList")
   public ProductionLineUpdateVORequest setLinkIdList(final List<Long> linkIdList) {
      this.linkIdList = linkIdList;
      return this;
   }

   @JsonProperty("targetProduction")
   public ProductionLineUpdateVORequest setTargetProduction(final BigDecimal targetProduction) {
      this.targetProduction = targetProduction;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionLineUpdateVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
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

      if (!(o instanceof ProductionLineUpdateVORequest)) {
         return false;
      }

      ProductionLineUpdateVORequest other = (ProductionLineUpdateVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionLineUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
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

   public ProductionLineUpdateVORequest(
      final Long id,
      final String name,
      final Integer sort,
      final String remark,
      final Integer type,
      final List<Long> linkIdList,
      final BigDecimal targetProduction
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.remark = remark;
      this.type = type;
      this.linkIdList = linkIdList;
      this.targetProduction = targetProduction;
   }

   public ProductionLineUpdateVORequest() {
   }

   public static class ProductionLineUpdateVORequestBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private String remark;
      private Integer type;
      private List<Long> linkIdList;
      private BigDecimal targetProduction;

      ProductionLineUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("remark")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("type")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("linkIdList")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder linkIdList(final List<Long> linkIdList) {
         this.linkIdList = linkIdList;
         return this;
      }

      @JsonProperty("targetProduction")
      public ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder targetProduction(final BigDecimal targetProduction) {
         this.targetProduction = targetProduction;
         return this;
      }

      public ProductionLineUpdateVORequest build() {
         return new ProductionLineUpdateVORequest(this.id, this.name, this.sort, this.remark, this.type, this.linkIdList, this.targetProduction);
      }

      @Override
      public String toString() {
         return "ProductionLineUpdateVORequest.ProductionLineUpdateVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
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
