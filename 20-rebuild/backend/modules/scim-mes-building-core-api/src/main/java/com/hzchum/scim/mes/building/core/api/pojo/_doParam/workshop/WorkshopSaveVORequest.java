package com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "WorkshopSaveVORequest", description = "车间新增类")
public class WorkshopSaveVORequest {
   @ApiModelProperty(name = "name", notes = "车间名", value = "车间名")
   @JsonProperty("name")
   @JSONField(name = "name")
   @NotNull(message = "名称不能为空")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "简称", value = "简称")
   private String shortName;
   @ApiModelProperty(name = "sort", notes = "排序", value = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "type", notes = "车间类型 1:建钢车间 4:围护车间", value = "车间类型 1:建钢车间  4:围护车间 ")
   @JsonProperty("type")
   @JSONField(name = "type")
   @NotNull(message = "车间类型")
   private Integer type;
   @ApiModelProperty(name = "ton", value = "目标产量", notes = "目标产量")
   @JsonProperty("ton")
   @JSONField(name = "ton")
   private BigDecimal ton;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static WorkshopSaveVORequest.WorkshopSaveVORequestBuilder builder() {
      return new WorkshopSaveVORequest.WorkshopSaveVORequestBuilder();
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getTon() {
      return this.ton;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("name")
   public WorkshopSaveVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   public WorkshopSaveVORequest setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("sort")
   public WorkshopSaveVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("factoryId")
   public WorkshopSaveVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("type")
   public WorkshopSaveVORequest setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("ton")
   public WorkshopSaveVORequest setTon(final BigDecimal ton) {
      this.ton = ton;
      return this;
   }

   public WorkshopSaveVORequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopSaveVORequest(name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", sort="
         + this.getSort()
         + ", factoryId="
         + this.getFactoryId()
         + ", type="
         + this.getType()
         + ", ton="
         + this.getTon()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopSaveVORequest)) {
         return false;
      }

      WorkshopSaveVORequest other = (WorkshopSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$ton = this.getTon();
                     Object other$ton = other.getTon();
                     if (this$ton == null ? other$ton == null : this$ton.equals(other$ton)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WorkshopSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $ton = this.getTon();
      result = result * 59 + ($ton == null ? 43 : $ton.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public WorkshopSaveVORequest(
      final String name, final String shortName, final Integer sort, final Long factoryId, final Integer type, final BigDecimal ton, final String remark
   ) {
      this.name = name;
      this.shortName = shortName;
      this.sort = sort;
      this.factoryId = factoryId;
      this.type = type;
      this.ton = ton;
      this.remark = remark;
   }

   public WorkshopSaveVORequest() {
   }

   public static class WorkshopSaveVORequestBuilder {
      private String name;
      private String shortName;
      private Integer sort;
      private Long factoryId;
      private Integer type;
      private BigDecimal ton;
      private String remark;

      WorkshopSaveVORequestBuilder() {
      }

      @JsonProperty("name")
      public WorkshopSaveVORequest.WorkshopSaveVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WorkshopSaveVORequest.WorkshopSaveVORequestBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("sort")
      public WorkshopSaveVORequest.WorkshopSaveVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("factoryId")
      public WorkshopSaveVORequest.WorkshopSaveVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("type")
      public WorkshopSaveVORequest.WorkshopSaveVORequestBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("ton")
      public WorkshopSaveVORequest.WorkshopSaveVORequestBuilder ton(final BigDecimal ton) {
         this.ton = ton;
         return this;
      }

      public WorkshopSaveVORequest.WorkshopSaveVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WorkshopSaveVORequest build() {
         return new WorkshopSaveVORequest(this.name, this.shortName, this.sort, this.factoryId, this.type, this.ton, this.remark);
      }

      @Override
      public String toString() {
         return "WorkshopSaveVORequest.WorkshopSaveVORequestBuilder(name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", sort="
            + this.sort
            + ", factoryId="
            + this.factoryId
            + ", type="
            + this.type
            + ", ton="
            + this.ton
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
