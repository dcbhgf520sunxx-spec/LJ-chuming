package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.qhse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class PersonalDTO {
   @ApiModelProperty(name = "userId", value = "用户id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "用户名")
   private String userName;
   @ApiModelProperty(name = "quantity", notes = "总数量")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalWeight", notes = "总重量")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "inspectionQuantity", notes = "通过质检数量")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "inspectionWeight", notes = "通过质检重量")
   private BigDecimal inspectionWeight;
   @ApiModelProperty(name = "problemQuantity", notes = "问题上报数量")
   private Integer problemQuantity;
   @ApiModelProperty(name = "problemWeight", notes = "问题上报重量")
   private BigDecimal problemWeight;

   public static PersonalDTO.PersonalDTOBuilder builder() {
      return new PersonalDTO.PersonalDTOBuilder();
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public BigDecimal getInspectionWeight() {
      return this.inspectionWeight;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
   }

   public BigDecimal getProblemWeight() {
      return this.problemWeight;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
   }

   public void setInspectionWeight(final BigDecimal inspectionWeight) {
      this.inspectionWeight = inspectionWeight;
   }

   public void setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
   }

   public void setProblemWeight(final BigDecimal problemWeight) {
      this.problemWeight = problemWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PersonalDTO)) {
         return false;
      }

      PersonalDTO other = (PersonalDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$totalQuantity = this.getTotalQuantity();
         Object other$totalQuantity = other.getTotalQuantity();
         if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
            Object this$inspectionQuantity = this.getInspectionQuantity();
            Object other$inspectionQuantity = other.getInspectionQuantity();
            if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
               Object this$problemQuantity = this.getProblemQuantity();
               Object other$problemQuantity = other.getProblemQuantity();
               if (this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity)) {
                  Object this$userName = this.getUserName();
                  Object other$userName = other.getUserName();
                  if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                     Object this$totalWeight = this.getTotalWeight();
                     Object other$totalWeight = other.getTotalWeight();
                     if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                        Object this$inspectionWeight = this.getInspectionWeight();
                        Object other$inspectionWeight = other.getInspectionWeight();
                        if (this$inspectionWeight == null ? other$inspectionWeight == null : this$inspectionWeight.equals(other$inspectionWeight)) {
                           Object this$problemWeight = this.getProblemWeight();
                           Object other$problemWeight = other.getProblemWeight();
                           return this$problemWeight == null ? other$problemWeight == null : this$problemWeight.equals(other$problemWeight);
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
      return other instanceof PersonalDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      result = result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $inspectionWeight = this.getInspectionWeight();
      result = result * 59 + ($inspectionWeight == null ? 43 : $inspectionWeight.hashCode());
      Object $problemWeight = this.getProblemWeight();
      return result * 59 + ($problemWeight == null ? 43 : $problemWeight.hashCode());
   }

   @Override
   public String toString() {
      return "PersonalDTO(userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", inspectionWeight="
         + this.getInspectionWeight()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ", problemWeight="
         + this.getProblemWeight()
         + ")";
   }

   public PersonalDTO(
      final Long userId,
      final String userName,
      final Integer totalQuantity,
      final BigDecimal totalWeight,
      final Integer inspectionQuantity,
      final BigDecimal inspectionWeight,
      final Integer problemQuantity,
      final BigDecimal problemWeight
   ) {
      this.userId = userId;
      this.userName = userName;
      this.totalQuantity = totalQuantity;
      this.totalWeight = totalWeight;
      this.inspectionQuantity = inspectionQuantity;
      this.inspectionWeight = inspectionWeight;
      this.problemQuantity = problemQuantity;
      this.problemWeight = problemWeight;
   }

   public PersonalDTO() {
   }

   public static class PersonalDTOBuilder {
      private Long userId;
      private String userName;
      private Integer totalQuantity;
      private BigDecimal totalWeight;
      private Integer inspectionQuantity;
      private BigDecimal inspectionWeight;
      private Integer problemQuantity;
      private BigDecimal problemWeight;

      PersonalDTOBuilder() {
      }

      public PersonalDTO.PersonalDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public PersonalDTO.PersonalDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public PersonalDTO.PersonalDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public PersonalDTO.PersonalDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public PersonalDTO.PersonalDTOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public PersonalDTO.PersonalDTOBuilder inspectionWeight(final BigDecimal inspectionWeight) {
         this.inspectionWeight = inspectionWeight;
         return this;
      }

      public PersonalDTO.PersonalDTOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      public PersonalDTO.PersonalDTOBuilder problemWeight(final BigDecimal problemWeight) {
         this.problemWeight = problemWeight;
         return this;
      }

      public PersonalDTO build() {
         return new PersonalDTO(
            this.userId,
            this.userName,
            this.totalQuantity,
            this.totalWeight,
            this.inspectionQuantity,
            this.inspectionWeight,
            this.problemQuantity,
            this.problemWeight
         );
      }

      @Override
      public String toString() {
         return "PersonalDTO.PersonalDTOBuilder(userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalWeight="
            + this.totalWeight
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", inspectionWeight="
            + this.inspectionWeight
            + ", problemQuantity="
            + this.problemQuantity
            + ", problemWeight="
            + this.problemWeight
            + ")";
      }
   }
}
