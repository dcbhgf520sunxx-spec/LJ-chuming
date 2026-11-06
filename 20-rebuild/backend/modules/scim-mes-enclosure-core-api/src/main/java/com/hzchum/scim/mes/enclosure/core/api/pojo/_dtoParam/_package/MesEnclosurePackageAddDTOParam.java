package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam._package;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosurePackageAddDTOParam", description = "包 ")
public class MesEnclosurePackageAddDTOParam {
   @ApiModelProperty(name = "id", value = "包id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "包id不能为空")
   private Long id;
   @ApiModelProperty(name = "packageLinks", value = "产品详情")
   @JsonProperty("packageLinks")
   @JSONField(name = "packageLinks")
   @NotEmpty(message = "产品详情不能为空")
   private List<MesEnclosureLinkDTOParam> packageLinks;

   public Long getId() {
      return this.id;
   }

   public List<MesEnclosureLinkDTOParam> getPackageLinks() {
      return this.packageLinks;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("packageLinks")
   public void setPackageLinks(final List<MesEnclosureLinkDTOParam> packageLinks) {
      this.packageLinks = packageLinks;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesEnclosurePackageAddDTOParam)) {
         return false;
      } else {
         MesEnclosurePackageAddDTOParam other = (MesEnclosurePackageAddDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$packageLinks = this.getPackageLinks();
               Object other$packageLinks = other.getPackageLinks();
               return this$packageLinks == null ? other$packageLinks == null : this$packageLinks.equals(other$packageLinks);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosurePackageAddDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $packageLinks = this.getPackageLinks();
      return result * 59 + ($packageLinks == null ? 43 : $packageLinks.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosurePackageAddDTOParam(id=" + this.getId() + ", packageLinks=" + this.getPackageLinks() + ")";
   }
}
