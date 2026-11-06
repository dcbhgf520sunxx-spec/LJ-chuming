package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProcessListDetailDTO", description = "")
public class ProcessListDetailDTO {
   @ApiModelProperty(name = "id", notes = "工序id", value = "工序id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工序名", value = "工序名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "type", notes = "工序类型", value = "工序类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;

   public static ProcessListDetailDTO.ProcessListDetailDTOBuilder builder() {
      return new ProcessListDetailDTO.ProcessListDetailDTOBuilder();
   }

   public ProcessListDetailDTO() {
   }

   public ProcessListDetailDTO(final Long id, final String name, final Integer type) {
      this.id = id;
      this.name = name;
      this.type = type;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public ProcessListDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ProcessListDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("type")
   public ProcessListDetailDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessListDetailDTO(id=" + this.getId() + ", name=" + this.getName() + ", type=" + this.getType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessListDetailDTO)) {
         return false;
      }

      ProcessListDetailDTO other = (ProcessListDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessListDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class ProcessListDetailDTOBuilder {
      private Long id;
      private String name;
      private Integer type;

      ProcessListDetailDTOBuilder() {
      }

      @JsonProperty("id")
      public ProcessListDetailDTO.ProcessListDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ProcessListDetailDTO.ProcessListDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("type")
      public ProcessListDetailDTO.ProcessListDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ProcessListDetailDTO build() {
         return new ProcessListDetailDTO(this.id, this.name, this.type);
      }

      @Override
      public String toString() {
         return "ProcessListDetailDTO.ProcessListDetailDTOBuilder(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ")";
      }
   }
}
