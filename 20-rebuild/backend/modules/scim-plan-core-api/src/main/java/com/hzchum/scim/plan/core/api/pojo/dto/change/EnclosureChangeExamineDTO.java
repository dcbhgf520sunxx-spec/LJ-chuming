package com.hzchum.scim.plan.core.api.pojo.dto.change;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("围护数量变更审核")
public class EnclosureChangeExamineDTO {
   @ApiModelProperty("围护Id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty("处理状态")
   @JsonProperty("handleStatusEnum")
   @JSONField(name = "handleStatusEnum")
   private Integer handleStatusEnum;

   public static EnclosureChangeExamineDTO.EnclosureChangeExamineDTOBuilder builder() {
      return new EnclosureChangeExamineDTO.EnclosureChangeExamineDTOBuilder();
   }

   public EnclosureChangeExamineDTO(final Long id, final Integer handleStatusEnum) {
      this.id = id;
      this.handleStatusEnum = handleStatusEnum;
   }

   public EnclosureChangeExamineDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getHandleStatusEnum() {
      return this.handleStatusEnum;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("handleStatusEnum")
   public void setHandleStatusEnum(final Integer handleStatusEnum) {
      this.handleStatusEnum = handleStatusEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof EnclosureChangeExamineDTO)) {
         return false;
      } else {
         EnclosureChangeExamineDTO other = (EnclosureChangeExamineDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$handleStatusEnum = this.getHandleStatusEnum();
               Object other$handleStatusEnum = other.getHandleStatusEnum();
               return this$handleStatusEnum == null ? other$handleStatusEnum == null : this$handleStatusEnum.equals(other$handleStatusEnum);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureChangeExamineDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $handleStatusEnum = this.getHandleStatusEnum();
      return result * 59 + ($handleStatusEnum == null ? 43 : $handleStatusEnum.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureChangeExamineDTO(id=" + this.getId() + ", handleStatusEnum=" + this.getHandleStatusEnum() + ")";
   }

   public static class EnclosureChangeExamineDTOBuilder {
      private Long id;
      private Integer handleStatusEnum;

      EnclosureChangeExamineDTOBuilder() {
      }

      @JsonProperty("id")
      public EnclosureChangeExamineDTO.EnclosureChangeExamineDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("handleStatusEnum")
      public EnclosureChangeExamineDTO.EnclosureChangeExamineDTOBuilder handleStatusEnum(final Integer handleStatusEnum) {
         this.handleStatusEnum = handleStatusEnum;
         return this;
      }

      public EnclosureChangeExamineDTO build() {
         return new EnclosureChangeExamineDTO(this.id, this.handleStatusEnum);
      }

      @Override
      public String toString() {
         return "EnclosureChangeExamineDTO.EnclosureChangeExamineDTOBuilder(id=" + this.id + ", handleStatusEnum=" + this.handleStatusEnum + ")";
      }
   }
}
