package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam._package;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosurePackage对象", description = "包 ")
public class MesEnclosurePackageDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty("产品类型")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty("boolApp")
   private Boolean boolApp;
   @ApiModelProperty(name = "packageLinks", value = "包详情")
   @Valid
   @NotEmpty(message = "包详情不能为空")
   private List<MesEnclosureLinkDTOParam> packageLinks;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getBoolApp() {
      return this.boolApp;
   }

   public List<MesEnclosureLinkDTOParam> getPackageLinks() {
      return this.packageLinks;
   }

   public MesEnclosurePackageDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesEnclosurePackageDTOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public MesEnclosurePackageDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public MesEnclosurePackageDTOParam setBoolApp(final Boolean boolApp) {
      this.boolApp = boolApp;
      return this;
   }

   public MesEnclosurePackageDTOParam setPackageLinks(final List<MesEnclosureLinkDTOParam> packageLinks) {
      this.packageLinks = packageLinks;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosurePackageDTOParam)) {
         return false;
      }

      MesEnclosurePackageDTOParam other = (MesEnclosurePackageDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$boolApp = this.getBoolApp();
            Object other$boolApp = other.getBoolApp();
            if (this$boolApp == null ? other$boolApp == null : this$boolApp.equals(other$boolApp)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosurePackageDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolApp = this.getBoolApp();
      result = result * 59 + ($boolApp == null ? 43 : $boolApp.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $packageLinks = this.getPackageLinks();
      return result * 59 + ($packageLinks == null ? 43 : $packageLinks.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosurePackageDTOParam(projectId="
         + this.getProjectId()
         + ", remark="
         + this.getRemark()
         + ", productType="
         + this.getProductType()
         + ", boolApp="
         + this.getBoolApp()
         + ", packageLinks="
         + this.getPackageLinks()
         + ")";
   }
}
