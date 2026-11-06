package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.groups.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "GroupsSaveVORequest", description = "")
public class GroupsUpdateVORequest {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
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

   public static GroupsUpdateVORequest.GroupsUpdateVORequestBuilder builder() {
      return new GroupsUpdateVORequest.GroupsUpdateVORequestBuilder();
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

   @JsonProperty("id")
   public GroupsUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public GroupsUpdateVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public GroupsUpdateVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("remark")
   public GroupsUpdateVORequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "GroupsUpdateVORequest(id=" + this.getId() + ", name=" + this.getName() + ", sort=" + this.getSort() + ", remark=" + this.getRemark() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GroupsUpdateVORequest)) {
         return false;
      }

      GroupsUpdateVORequest other = (GroupsUpdateVORequest)o;
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof GroupsUpdateVORequest;
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
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public GroupsUpdateVORequest(final Long id, final String name, final Integer sort, final String remark) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.remark = remark;
   }

   public GroupsUpdateVORequest() {
   }

   public static class GroupsUpdateVORequestBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private String remark;

      GroupsUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public GroupsUpdateVORequest.GroupsUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public GroupsUpdateVORequest.GroupsUpdateVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public GroupsUpdateVORequest.GroupsUpdateVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("remark")
      public GroupsUpdateVORequest.GroupsUpdateVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public GroupsUpdateVORequest build() {
         return new GroupsUpdateVORequest(this.id, this.name, this.sort, this.remark);
      }

      @Override
      public String toString() {
         return "GroupsUpdateVORequest.GroupsUpdateVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
