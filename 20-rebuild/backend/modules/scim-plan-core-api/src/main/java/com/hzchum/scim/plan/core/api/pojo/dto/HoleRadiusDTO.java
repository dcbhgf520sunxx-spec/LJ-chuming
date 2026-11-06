package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;

@ApiModel("孔数,半径关系")
public class HoleRadiusDTO {
   @ApiModelProperty(name = "holeNumber", value = "孔数")
   private Integer holeNumber;
   @ApiModelProperty(name = "holeRadiusMap", value = "半径数量关系(mm)")
   private Map<Double, Long> holeRadiusMap;

   public static HoleRadiusDTO.HoleRadiusDTOBuilder builder() {
      return new HoleRadiusDTO.HoleRadiusDTOBuilder();
   }

   public Integer getHoleNumber() {
      return this.holeNumber;
   }

   public Map<Double, Long> getHoleRadiusMap() {
      return this.holeRadiusMap;
   }

   public void setHoleNumber(final Integer holeNumber) {
      this.holeNumber = holeNumber;
   }

   public void setHoleRadiusMap(final Map<Double, Long> holeRadiusMap) {
      this.holeRadiusMap = holeRadiusMap;
   }

   @Override
   public String toString() {
      return "HoleRadiusDTO(holeNumber=" + this.getHoleNumber() + ", holeRadiusMap=" + this.getHoleRadiusMap() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof HoleRadiusDTO)) {
         return false;
      } else {
         HoleRadiusDTO other = (HoleRadiusDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$holeNumber = this.getHoleNumber();
            Object other$holeNumber = other.getHoleNumber();
            if (this$holeNumber == null ? other$holeNumber == null : this$holeNumber.equals(other$holeNumber)) {
               Object this$holeRadiusMap = this.getHoleRadiusMap();
               Object other$holeRadiusMap = other.getHoleRadiusMap();
               return this$holeRadiusMap == null ? other$holeRadiusMap == null : this$holeRadiusMap.equals(other$holeRadiusMap);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof HoleRadiusDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $holeNumber = this.getHoleNumber();
      result = result * 59 + ($holeNumber == null ? 43 : $holeNumber.hashCode());
      Object $holeRadiusMap = this.getHoleRadiusMap();
      return result * 59 + ($holeRadiusMap == null ? 43 : $holeRadiusMap.hashCode());
   }

   public HoleRadiusDTO(final Integer holeNumber, final Map<Double, Long> holeRadiusMap) {
      this.holeNumber = holeNumber;
      this.holeRadiusMap = holeRadiusMap;
   }

   public HoleRadiusDTO() {
   }

   public static class HoleRadiusDTOBuilder {
      private Integer holeNumber;
      private Map<Double, Long> holeRadiusMap;

      HoleRadiusDTOBuilder() {
      }

      public HoleRadiusDTO.HoleRadiusDTOBuilder holeNumber(final Integer holeNumber) {
         this.holeNumber = holeNumber;
         return this;
      }

      public HoleRadiusDTO.HoleRadiusDTOBuilder holeRadiusMap(final Map<Double, Long> holeRadiusMap) {
         this.holeRadiusMap = holeRadiusMap;
         return this;
      }

      public HoleRadiusDTO build() {
         return new HoleRadiusDTO(this.holeNumber, this.holeRadiusMap);
      }

      @Override
      public String toString() {
         return "HoleRadiusDTO.HoleRadiusDTOBuilder(holeNumber=" + this.holeNumber + ", holeRadiusMap=" + this.holeRadiusMap + ")";
      }
   }
}
