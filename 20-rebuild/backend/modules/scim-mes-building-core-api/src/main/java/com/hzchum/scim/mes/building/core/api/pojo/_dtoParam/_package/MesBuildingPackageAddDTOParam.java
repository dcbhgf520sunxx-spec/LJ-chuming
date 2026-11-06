package com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingPackageAddDTOParam", description = "包 ")
public class MesBuildingPackageAddDTOParam {
   @ApiModelProperty(name = "id", value = "包id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "包id不能为空")
   private Long id;
   @ApiModelProperty(name = "warehouseId", value = "存储仓库id", notes = "存储仓库id")
   private Long warehouseId;
   @ApiModelProperty(name = "attachmentIds", value = "附件ids")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "packageLinks", value = "包详情")
   @JsonProperty("packageLinks")
   @JSONField(name = "packageLinks")
   @Valid
   @NotEmpty(message = "包详情不能为空")
   private List<MesBuildingLinkDTOParam> packageLinks;

   public Long getId() {
      return this.id;
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

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @JsonProperty("packageLinks")
   public void setPackageLinks(final List<MesBuildingLinkDTOParam> packageLinks) {
      this.packageLinks = packageLinks;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageAddDTOParam)) {
         return false;
      }

      MesBuildingPackageAddDTOParam other = (MesBuildingPackageAddDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$warehouseId = this.getWarehouseId();
         Object other$warehouseId = other.getWarehouseId();
         if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPackageAddDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $packageLinks = this.getPackageLinks();
      return result * 59 + ($packageLinks == null ? 43 : $packageLinks.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPackageAddDTOParam(id="
         + this.getId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", packageLinks="
         + this.getPackageLinks()
         + ")";
   }
}
