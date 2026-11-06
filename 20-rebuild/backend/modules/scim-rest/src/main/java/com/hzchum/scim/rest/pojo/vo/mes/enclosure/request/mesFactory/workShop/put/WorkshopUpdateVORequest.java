package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.workShop.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "WorkshopUpdateVORequest", description = "")
public class WorkshopUpdateVORequest {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "name", notes = "车间名", value = "车间名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "sort", notes = "排序", value = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "remark", notes = "备注", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "type", notes = "车间类型 1:建钢车间 2:桥梁车间 4:围护车间", value = "车间类型 1:建钢车间 2:桥梁车间 4:围护车间 ")
   @JsonProperty("type")
   @JSONField(name = "type")
   @NotNull(message = "车间类型")
   private String type;

   public static WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder builder() {
      return new WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder();
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

   public String getType() {
      return this.type;
   }

   @JsonProperty("id")
   public WorkshopUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public WorkshopUpdateVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public WorkshopUpdateVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("remark")
   public WorkshopUpdateVORequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("type")
   public WorkshopUpdateVORequest setType(final String type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopUpdateVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", type="
         + this.getType()
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
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  return this$type == null ? other$type == null : this$type.equals(other$type);
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
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   public WorkshopUpdateVORequest(final Long id, final String name, final Integer sort, final String remark, final String type) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.remark = remark;
      this.type = type;
   }

   public WorkshopUpdateVORequest() {
   }

   public static class WorkshopUpdateVORequestBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private String remark;
      private String type;

      WorkshopUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("remark")
      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("type")
      public WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public WorkshopUpdateVORequest build() {
         return new WorkshopUpdateVORequest(this.id, this.name, this.sort, this.remark, this.type);
      }

      @Override
      public String toString() {
         return "WorkshopUpdateVORequest.WorkshopUpdateVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ", type="
            + this.type
            + ")";
      }
   }
}
