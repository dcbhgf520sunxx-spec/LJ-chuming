package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class MonomerUserLinkDTO {
   @ApiModelProperty(name = "deepenedPersonId", notes = "深化负责人id")
   private Long deepenedPersonId;
   @ApiModelProperty(name = "deepenedPersonName", notes = "深化负责人名字")
   private String deepenedPersonName;

   public Long getDeepenedPersonId() {
      return this.deepenedPersonId;
   }

   public String getDeepenedPersonName() {
      return this.deepenedPersonName;
   }

   public void setDeepenedPersonId(final Long deepenedPersonId) {
      this.deepenedPersonId = deepenedPersonId;
   }

   public void setDeepenedPersonName(final String deepenedPersonName) {
      this.deepenedPersonName = deepenedPersonName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MonomerUserLinkDTO)) {
         return false;
      } else {
         MonomerUserLinkDTO other = (MonomerUserLinkDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$deepenedPersonId = this.getDeepenedPersonId();
            Object other$deepenedPersonId = other.getDeepenedPersonId();
            if (this$deepenedPersonId == null ? other$deepenedPersonId == null : this$deepenedPersonId.equals(other$deepenedPersonId)) {
               Object this$deepenedPersonName = this.getDeepenedPersonName();
               Object other$deepenedPersonName = other.getDeepenedPersonName();
               return this$deepenedPersonName == null ? other$deepenedPersonName == null : this$deepenedPersonName.equals(other$deepenedPersonName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonomerUserLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $deepenedPersonId = this.getDeepenedPersonId();
      result = result * 59 + ($deepenedPersonId == null ? 43 : $deepenedPersonId.hashCode());
      Object $deepenedPersonName = this.getDeepenedPersonName();
      return result * 59 + ($deepenedPersonName == null ? 43 : $deepenedPersonName.hashCode());
   }

   @Override
   public String toString() {
      return "MonomerUserLinkDTO(deepenedPersonId=" + this.getDeepenedPersonId() + ", deepenedPersonName=" + this.getDeepenedPersonName() + ")";
   }
}
