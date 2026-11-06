package com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(description = "包 ")
public class MesBuildingPackageUpdateDTOParam {
   @ApiModelProperty("包id")
   @NotNull(message = "包id不能为空")
   private Long id;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty(name = "warehouseId", value = "存储仓库id", notes = "存储仓库id")
   private Long warehouseId;
   @ApiModelProperty(name = "attachmentIds", value = "附件ids")
   private List<Long> attachmentIds;
   @ApiModelProperty("包详情")
   @NotEmpty(message = "包详情不能为空")
   @Valid
   private List<MesBuildingLinkDTOParam> packageLinks;

   public Long getId() {
      return this.id;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<MesBuildingLinkDTOParam> getPackageLinks() {
      return this.packageLinks;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setPackageLinks(final List<MesBuildingLinkDTOParam> packageLinks) {
      this.packageLinks = packageLinks;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageUpdateDTOParam)) {
         return false;
      }

      MesBuildingPackageUpdateDTOParam other = (MesBuildingPackageUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$warehouseId = this.getWarehouseId();
         Object other$warehouseId = other.getWarehouseId();
         if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
               Object this$attachmentIds = this.getAttachmentIds();
               Object other$attachmentIds = other.getAttachmentIds();
               if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                  Object this$packageLinks = this.getPackageLinks();
                  Object other$packageLinks = other.getPackageLinks();
                  return this$packageLinks == null ? other$packageLinks == null : this$packageLinks.equals(other$packageLinks);
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
      return other instanceof MesBuildingPackageUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $packageLinks = this.getPackageLinks();
      return result * 59 + ($packageLinks == null ? 43 : $packageLinks.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPackageUpdateDTOParam(id="
         + this.getId()
         + ", remark="
         + this.getRemark()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", packageLinks="
         + this.getPackageLinks()
         + ")";
   }
}
