package com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "WorkshopUpdateVORequest", description = "")
public class WorkshopUpdateVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "name", notes = "车间名", value = "车间名")
   @NotBlank(message = "车间名称不能为空")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "简称", value = "简称")
   private String shortName;
   @ApiModelProperty(name = "sort", notes = "排序", value = "排序")
   private Integer sort;
   @ApiModelProperty(name = "type", notes = "车间类型 1:建钢车间 2:桥梁车间 4:围护车间", value = "车间类型 1:建钢车间 2:桥梁车间 4:围护车间 ")
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

   public static WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder builder() {
      return new WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder();
   }

   public Long getId() {
      return this.id;
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

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getTon() {
      return this.ton;
   }

   public String getRemark() {
      return this.remark;
   }

   public WorkshopUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   public WorkshopUpdateVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   public WorkshopUpdateVORequest setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   public WorkshopUpdateVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("type")
   public WorkshopUpdateVORequest setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("ton")
   public WorkshopUpdateVORequest setTon(final BigDecimal ton) {
      this.ton = ton;
      return this;
   }

   public WorkshopUpdateVORequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopUpdateVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", sort="
         + this.getSort()
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

      if (!(o instanceof WorkshopUpdateVORequest)) {
         return false;
      }

      WorkshopUpdateVORequest other = (WorkshopUpdateVORequest)o;
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
      return other instanceof WorkshopUpdateVORequest;
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
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $ton = this.getTon();
      result = result * 59 + ($ton == null ? 43 : $ton.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public WorkshopUpdateVORequest(
      final Long id, final String name, final String shortName, final Integer sort, final Integer type, final BigDecimal ton, final String remark
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.sort = sort;
      this.type = type;
      this.ton = ton;
      this.remark = remark;
   }

   public WorkshopUpdateVORequest() {
   }

   public static class WorkshopUpdateVORequestBuilder {
      private Long id;
      private String name;
      private String shortName;
      private Integer sort;
      private Integer type;
      private BigDecimal ton;
      private String remark;

      WorkshopUpdateVORequestBuilder() {
      }

      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("type")
      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("ton")
      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder ton(final BigDecimal ton) {
         this.ton = ton;
         return this;
      }

      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WorkshopUpdateVORequest build() {
         return new WorkshopUpdateVORequest(this.id, this.name, this.shortName, this.sort, this.type, this.ton, this.remark);
      }

      @Override
      public String toString() {
         return "WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", sort="
            + this.sort
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
