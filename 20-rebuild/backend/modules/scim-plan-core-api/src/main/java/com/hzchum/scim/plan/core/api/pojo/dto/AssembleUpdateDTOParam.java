package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AssembleUpdateDTOParam {
   @NotNull(message = "组立id不能为空")
   @ApiModelProperty(name = "id", value = "组立id")
   private Long id;
   @Valid
   @ApiModelProperty(name = "detailUpdateDTOParams", value = "修改腹板或翼缘列表")
   private List<AssembleDetailUpdateDTOParam> detailUpdateDTOParams;

   public Long getId() {
      return this.id;
   }

   public List<AssembleDetailUpdateDTOParam> getDetailUpdateDTOParams() {
      return this.detailUpdateDTOParams;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setDetailUpdateDTOParams(final List<AssembleDetailUpdateDTOParam> detailUpdateDTOParams) {
      this.detailUpdateDTOParams = detailUpdateDTOParams;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AssembleUpdateDTOParam)) {
         return false;
      } else {
         AssembleUpdateDTOParam other = (AssembleUpdateDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$detailUpdateDTOParams = this.getDetailUpdateDTOParams();
               Object other$detailUpdateDTOParams = other.getDetailUpdateDTOParams();
               return this$detailUpdateDTOParams == null ? other$detailUpdateDTOParams == null : this$detailUpdateDTOParams.equals(other$detailUpdateDTOParams);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $detailUpdateDTOParams = this.getDetailUpdateDTOParams();
      return result * 59 + ($detailUpdateDTOParams == null ? 43 : $detailUpdateDTOParams.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleUpdateDTOParam(id=" + this.getId() + ", detailUpdateDTOParams=" + this.getDetailUpdateDTOParams() + ")";
   }
}
