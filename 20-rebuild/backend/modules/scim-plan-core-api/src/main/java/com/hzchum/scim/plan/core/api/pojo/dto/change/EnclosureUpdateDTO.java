package com.hzchum.scim.plan.core.api.pojo.dto.change;

import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureImportV2DTO;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class EnclosureUpdateDTO extends EnclosureImportV2DTO implements Serializable {
   @ApiModelProperty(name = "id", value = "id")
   private Long id;

   public Long getId() {
      return this.id;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureUpdateDTO)) {
         return false;
      }

      EnclosureUpdateDTO other = (EnclosureUpdateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      return this$id == null ? other$id == null : this$id.equals(other$id);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureUpdateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureUpdateDTO(id=" + this.getId() + ")";
   }
}
