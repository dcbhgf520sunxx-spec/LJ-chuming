package com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingPackage对象", description = "包 ")
public class MesBuildingPackageDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty("boolApp")
   private Boolean boolApp;
   @ApiModelProperty(name = "packageLinks", value = "包详情")
   @Valid
   @NotEmpty(message = "包详情不能为空")
   private List<MesBuildingLinkDTOParam> packageLinks;
   @ApiModelProperty(name = "serialNumber", value = "包单号")
   private String serialNumber;
   @ApiModelProperty(name = "warehouseId", value = "存储仓库id", notes = "存储仓库id")
   private Long warehouseId;
   @ApiModelProperty(name = "attachmentIds", value = "附件ids")
   private List<Long> attachmentIds;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolApp() {
      return this.boolApp;
   }

   public List<MesBuildingLinkDTOParam> getPackageLinks() {
      return this.packageLinks;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public MesBuildingPackageDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingPackageDTOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public MesBuildingPackageDTOParam setBoolApp(final Boolean boolApp) {
      this.boolApp = boolApp;
      return this;
   }

   public MesBuildingPackageDTOParam setPackageLinks(final List<MesBuildingLinkDTOParam> packageLinks) {
      this.packageLinks = packageLinks;
      return this;
   }

   public MesBuildingPackageDTOParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesBuildingPackageDTOParam setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   public MesBuildingPackageDTOParam setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageDTOParam)) {
         return false;
      }

      MesBuildingPackageDTOParam other = (MesBuildingPackageDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$boolApp = this.getBoolApp();
         Object other$boolApp = other.getBoolApp();
         if (this$boolApp == null ? other$boolApp == null : this$boolApp.equals(other$boolApp)) {
            Object this$warehouseId = this.getWarehouseId();
            Object other$warehouseId = other.getWarehouseId();
            if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                  Object this$packageLinks = this.getPackageLinks();
                  Object other$packageLinks = other.getPackageLinks();
                  if (this$packageLinks == null ? other$packageLinks == null : this$packageLinks.equals(other$packageLinks)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$attachmentIds = this.getAttachmentIds();
                        Object other$attachmentIds = other.getAttachmentIds();
                        return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPackageDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolApp = this.getBoolApp();
      result = result * 59 + ($boolApp == null ? 43 : $boolApp.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $packageLinks = this.getPackageLinks();
      result = result * 59 + ($packageLinks == null ? 43 : $packageLinks.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPackageDTOParam(projectId="
         + this.getProjectId()
         + ", remark="
         + this.getRemark()
         + ", boolApp="
         + this.getBoolApp()
         + ", packageLinks="
         + this.getPackageLinks()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }
}
