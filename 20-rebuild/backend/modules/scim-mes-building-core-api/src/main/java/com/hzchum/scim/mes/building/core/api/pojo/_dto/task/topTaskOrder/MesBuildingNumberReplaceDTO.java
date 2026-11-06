package com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingNumberReplaceDTO", description = "码号是否可以操作返回类")
public class MesBuildingNumberReplaceDTO {
   private Integer number;
   private Boolean boolReplace;

   public static MesBuildingNumberReplaceDTO.MesBuildingNumberReplaceDTOBuilder builder() {
      return new MesBuildingNumberReplaceDTO.MesBuildingNumberReplaceDTOBuilder();
   }

   public MesBuildingNumberReplaceDTO() {
   }

   public MesBuildingNumberReplaceDTO(final Integer number, final Boolean boolReplace) {
      this.number = number;
      this.boolReplace = boolReplace;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Boolean getBoolReplace() {
      return this.boolReplace;
   }

   public MesBuildingNumberReplaceDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public MesBuildingNumberReplaceDTO setBoolReplace(final Boolean boolReplace) {
      this.boolReplace = boolReplace;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNumberReplaceDTO(number=" + this.getNumber() + ", boolReplace=" + this.getBoolReplace() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingNumberReplaceDTO)) {
         return false;
      } else {
         MesBuildingNumberReplaceDTO other = (MesBuildingNumberReplaceDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$number = this.getNumber();
            Object other$number = other.getNumber();
            if (this$number == null ? other$number == null : this$number.equals(other$number)) {
               Object this$boolReplace = this.getBoolReplace();
               Object other$boolReplace = other.getBoolReplace();
               return this$boolReplace == null ? other$boolReplace == null : this$boolReplace.equals(other$boolReplace);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingNumberReplaceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $boolReplace = this.getBoolReplace();
      return result * 59 + ($boolReplace == null ? 43 : $boolReplace.hashCode());
   }

   public static class MesBuildingNumberReplaceDTOBuilder {
      private Integer number;
      private Boolean boolReplace;

      MesBuildingNumberReplaceDTOBuilder() {
      }

      public MesBuildingNumberReplaceDTO.MesBuildingNumberReplaceDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesBuildingNumberReplaceDTO.MesBuildingNumberReplaceDTOBuilder boolReplace(final Boolean boolReplace) {
         this.boolReplace = boolReplace;
         return this;
      }

      public MesBuildingNumberReplaceDTO build() {
         return new MesBuildingNumberReplaceDTO(this.number, this.boolReplace);
      }

      @Override
      public String toString() {
         return "MesBuildingNumberReplaceDTO.MesBuildingNumberReplaceDTOBuilder(number=" + this.number + ", boolReplace=" + this.boolReplace + ")";
      }
   }
}
