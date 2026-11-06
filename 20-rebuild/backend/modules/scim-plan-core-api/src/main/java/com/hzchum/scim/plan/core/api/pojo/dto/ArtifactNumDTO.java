package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("构件图纸序列号")
public class ArtifactNumDTO {
   @ApiModelProperty(name = "boolExist", value = "是否有图纸")
   private Boolean boolExist;
   @ApiModelProperty(name = "numbers", value = "构件产品图纸序列号")
   private List<Integer> numbers;

   public Boolean getBoolExist() {
      return this.boolExist;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public void setBoolExist(final Boolean boolExist) {
      this.boolExist = boolExist;
   }

   public void setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtifactNumDTO)) {
         return false;
      } else {
         ArtifactNumDTO other = (ArtifactNumDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$boolExist = this.getBoolExist();
            Object other$boolExist = other.getBoolExist();
            if (this$boolExist == null ? other$boolExist == null : this$boolExist.equals(other$boolExist)) {
               Object this$numbers = this.getNumbers();
               Object other$numbers = other.getNumbers();
               return this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactNumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolExist = this.getBoolExist();
      result = result * 59 + ($boolExist == null ? 43 : $boolExist.hashCode());
      Object $numbers = this.getNumbers();
      return result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactNumDTO(boolExist=" + this.getBoolExist() + ", numbers=" + this.getNumbers() + ")";
   }
}
