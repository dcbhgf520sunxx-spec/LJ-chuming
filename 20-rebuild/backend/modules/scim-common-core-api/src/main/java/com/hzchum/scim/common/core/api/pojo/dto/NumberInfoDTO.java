package com.hzchum.scim.common.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "NumberInfoDTO", description = "构件一物一码数据")
public class NumberInfoDTO {
   private Long productId;
   private Integer number;
   private Long taskProcessId;
   private Integer taskType;

   public static NumberInfoDTO.NumberInfoDTOBuilder builder() {
      return new NumberInfoDTO.NumberInfoDTOBuilder();
   }

   public NumberInfoDTO() {
   }

   public NumberInfoDTO(final Long productId, final Integer number, final Long taskProcessId, final Integer taskType) {
      this.productId = productId;
      this.number = number;
      this.taskProcessId = taskProcessId;
      this.taskType = taskType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public NumberInfoDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public NumberInfoDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public NumberInfoDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   public NumberInfoDTO setTaskType(final Integer taskType) {
      this.taskType = taskType;
      return this;
   }

   @Override
   public String toString() {
      return "NumberInfoDTO(productId="
         + this.getProductId()
         + ", number="
         + this.getNumber()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", taskType="
         + this.getTaskType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NumberInfoDTO)) {
         return false;
      }

      NumberInfoDTO other = (NumberInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$taskProcessId = this.getTaskProcessId();
            Object other$taskProcessId = other.getTaskProcessId();
            if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
               Object this$taskType = this.getTaskType();
               Object other$taskType = other.getTaskType();
               return this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType);
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
      return other instanceof NumberInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $taskType = this.getTaskType();
      return result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
   }

   public static class NumberInfoDTOBuilder {
      private Long productId;
      private Integer number;
      private Long taskProcessId;
      private Integer taskType;

      NumberInfoDTOBuilder() {
      }

      public NumberInfoDTO.NumberInfoDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public NumberInfoDTO.NumberInfoDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public NumberInfoDTO.NumberInfoDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public NumberInfoDTO.NumberInfoDTOBuilder taskType(final Integer taskType) {
         this.taskType = taskType;
         return this;
      }

      public NumberInfoDTO build() {
         return new NumberInfoDTO(this.productId, this.number, this.taskProcessId, this.taskType);
      }

      @Override
      public String toString() {
         return "NumberInfoDTO.NumberInfoDTOBuilder(productId="
            + this.productId
            + ", number="
            + this.number
            + ", taskProcessId="
            + this.taskProcessId
            + ", taskType="
            + this.taskType
            + ")";
      }
   }
}
