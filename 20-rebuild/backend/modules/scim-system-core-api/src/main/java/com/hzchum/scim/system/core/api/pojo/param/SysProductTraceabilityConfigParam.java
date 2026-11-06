package com.hzchum.scim.system.core.api.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(value = "SysProductTraceabilityConfigSaveParam对象", description = "产品溯源配置表新增/修改参数")
public class SysProductTraceabilityConfigParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "systemName", value = "系统名称", notes = "系统名称")
   @Size(max = 64, message = "系统名称字数过多!")
   @NotBlank(message = "系统名称不能为空")
   private String systemName;
   @ApiModelProperty(name = "companyName", value = "公司名称", notes = "公司名称")
   @Size(max = 64, message = "公司名称字数过多!")
   @NotBlank(message = "公司名称不能为空")
   private String companyName;
   @ApiModelProperty(name = "productionBaseName", value = "生产基地名称", notes = "生产基地名称")
   @Size(max = 64, message = "生产基地名称字数过多!")
   private String productionBaseName;
   @ApiModelProperty(name = "projectIdList", value = "项目id列表", notes = "项目id列表")
   private List<Long> projectIdList;

   public static SysProductTraceabilityConfigParam.SysProductTraceabilityConfigParamBuilder builder() {
      return new SysProductTraceabilityConfigParam.SysProductTraceabilityConfigParamBuilder();
   }

   public SysProductTraceabilityConfigParam() {
   }

   public SysProductTraceabilityConfigParam(
      final Long id, final String systemName, final String companyName, final String productionBaseName, final List<Long> projectIdList
   ) {
      this.id = id;
      this.systemName = systemName;
      this.companyName = companyName;
      this.productionBaseName = productionBaseName;
      this.projectIdList = projectIdList;
   }

   public Long getId() {
      return this.id;
   }

   public String getSystemName() {
      return this.systemName;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getProductionBaseName() {
      return this.productionBaseName;
   }

   public List<Long> getProjectIdList() {
      return this.projectIdList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSystemName(final String systemName) {
      this.systemName = systemName;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setProductionBaseName(final String productionBaseName) {
      this.productionBaseName = productionBaseName;
   }

   public void setProjectIdList(final List<Long> projectIdList) {
      this.projectIdList = projectIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysProductTraceabilityConfigParam)) {
         return false;
      }

      SysProductTraceabilityConfigParam other = (SysProductTraceabilityConfigParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$systemName = this.getSystemName();
         Object other$systemName = other.getSystemName();
         if (this$systemName == null ? other$systemName == null : this$systemName.equals(other$systemName)) {
            Object this$companyName = this.getCompanyName();
            Object other$companyName = other.getCompanyName();
            if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
               Object this$productionBaseName = this.getProductionBaseName();
               Object other$productionBaseName = other.getProductionBaseName();
               if (this$productionBaseName == null ? other$productionBaseName == null : this$productionBaseName.equals(other$productionBaseName)) {
                  Object this$projectIdList = this.getProjectIdList();
                  Object other$projectIdList = other.getProjectIdList();
                  return this$projectIdList == null ? other$projectIdList == null : this$projectIdList.equals(other$projectIdList);
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
      return other instanceof SysProductTraceabilityConfigParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $systemName = this.getSystemName();
      result = result * 59 + ($systemName == null ? 43 : $systemName.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $productionBaseName = this.getProductionBaseName();
      result = result * 59 + ($productionBaseName == null ? 43 : $productionBaseName.hashCode());
      Object $projectIdList = this.getProjectIdList();
      return result * 59 + ($projectIdList == null ? 43 : $projectIdList.hashCode());
   }

   @Override
   public String toString() {
      return "SysProductTraceabilityConfigParam(id="
         + this.getId()
         + ", systemName="
         + this.getSystemName()
         + ", companyName="
         + this.getCompanyName()
         + ", productionBaseName="
         + this.getProductionBaseName()
         + ", projectIdList="
         + this.getProjectIdList()
         + ")";
   }

   public static class SysProductTraceabilityConfigParamBuilder {
      private Long id;
      private String systemName;
      private String companyName;
      private String productionBaseName;
      private List<Long> projectIdList;

      SysProductTraceabilityConfigParamBuilder() {
      }

      public SysProductTraceabilityConfigParam.SysProductTraceabilityConfigParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysProductTraceabilityConfigParam.SysProductTraceabilityConfigParamBuilder systemName(final String systemName) {
         this.systemName = systemName;
         return this;
      }

      public SysProductTraceabilityConfigParam.SysProductTraceabilityConfigParamBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public SysProductTraceabilityConfigParam.SysProductTraceabilityConfigParamBuilder productionBaseName(final String productionBaseName) {
         this.productionBaseName = productionBaseName;
         return this;
      }

      public SysProductTraceabilityConfigParam.SysProductTraceabilityConfigParamBuilder projectIdList(final List<Long> projectIdList) {
         this.projectIdList = projectIdList;
         return this;
      }

      public SysProductTraceabilityConfigParam build() {
         return new SysProductTraceabilityConfigParam(this.id, this.systemName, this.companyName, this.productionBaseName, this.projectIdList);
      }

      @Override
      public String toString() {
         return "SysProductTraceabilityConfigParam.SysProductTraceabilityConfigParamBuilder(id="
            + this.id
            + ", systemName="
            + this.systemName
            + ", companyName="
            + this.companyName
            + ", productionBaseName="
            + this.productionBaseName
            + ", projectIdList="
            + this.projectIdList
            + ")";
      }
   }
}
