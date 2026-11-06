package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam._package;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(description = "包 ")
public class MesEnclosurePackageUpdateDTOParam {
   @ApiModelProperty("包id")
   @NotNull(message = "包id不能为空")
   private Long id;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("产品详情")
   @NotEmpty(message = "包详情不能为空")
   @Valid
   private List<MesEnclosureLinkDTOParam> packageLinks;

   public Long getId() {
      return this.id;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<MesEnclosureLinkDTOParam> getPackageLinks() {
      return this.packageLinks;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setPackageLinks(final List<MesEnclosureLinkDTOParam> packageLinks) {
      this.packageLinks = packageLinks;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosurePackageUpdateDTOParam)) {
         return false;
      }

      MesEnclosurePackageUpdateDTOParam other = (MesEnclosurePackageUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$remark = this.getRemark();
         Object other$remark = other.getRemark();
         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
            Object this$packageLinks = this.getPackageLinks();
            Object other$packageLinks = other.getPackageLinks();
            return this$packageLinks == null ? other$packageLinks == null : this$packageLinks.equals(other$packageLinks);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosurePackageUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $packageLinks = this.getPackageLinks();
      return result * 59 + ($packageLinks == null ? 43 : $packageLinks.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosurePackageUpdateDTOParam(id=" + this.getId() + ", remark=" + this.getRemark() + ", packageLinks=" + this.getPackageLinks() + ")";
   }
}
