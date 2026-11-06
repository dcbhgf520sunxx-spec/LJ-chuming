package com.hzchum.scim.system.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("车间下质检用户列表")
public class MesShopInspectUserTreeDTO {
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "inspectUsers", value = "质检用户列表", notes = "质检用户列表")
   @JsonProperty("inspectUsers")
   @JSONField(name = "inspectUsers")
   private List<IdAndNameDTO> inspectUsers;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public List<IdAndNameDTO> getInspectUsers() {
      return this.inspectUsers;
   }

   @JsonProperty("workshopId")
   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   @JsonProperty("inspectUsers")
   public void setInspectUsers(final List<IdAndNameDTO> inspectUsers) {
      this.inspectUsers = inspectUsers;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesShopInspectUserTreeDTO)) {
         return false;
      } else {
         MesShopInspectUserTreeDTO other = (MesShopInspectUserTreeDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$inspectUsers = this.getInspectUsers();
               Object other$inspectUsers = other.getInspectUsers();
               return this$inspectUsers == null ? other$inspectUsers == null : this$inspectUsers.equals(other$inspectUsers);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesShopInspectUserTreeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $inspectUsers = this.getInspectUsers();
      return result * 59 + ($inspectUsers == null ? 43 : $inspectUsers.hashCode());
   }

   @Override
   public String toString() {
      return "MesShopInspectUserTreeDTO(workshopId=" + this.getWorkshopId() + ", inspectUsers=" + this.getInspectUsers() + ")";
   }
}
