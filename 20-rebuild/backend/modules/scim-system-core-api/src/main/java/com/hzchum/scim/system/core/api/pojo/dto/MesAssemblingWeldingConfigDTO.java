package com.hzchum.scim.system.core.api.pojo.dto;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.pojo._do.MesAssemblingWeldingConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("装焊配置DTO类")
public class MesAssemblingWeldingConfigDTO extends MesAssemblingWeldingConfig {
   @ApiModelProperty(name = "artifactTypeName", value = "构件类型名称", notes = "构件类型名称")
   private String artifactTypeName;
   @ApiModelProperty(name = "processList", value = "工序列表", notes = "工序列表")
   private List<NameInfo> processList;
   @ApiModelProperty(name = "artifactNameList", value = "构件名称列表", notes = "构件名称列表")
   private List<String> artifactNameList;

   public List<String> getArtifactNameList() {
      return CollUtil.isEmpty(this.artifactNameList) && StrUtil.isNotBlank(super.getArtifact())
         ? StrUtil.split(super.getArtifact(), ",")
         : this.artifactNameList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAssemblingWeldingConfigDTO)) {
         return false;
      }

      MesAssemblingWeldingConfigDTO other = (MesAssemblingWeldingConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$artifactTypeName = this.getArtifactTypeName();
      Object other$artifactTypeName = other.getArtifactTypeName();
      if (this$artifactTypeName == null ? other$artifactTypeName == null : this$artifactTypeName.equals(other$artifactTypeName)) {
         Object this$processList = this.getProcessList();
         Object other$processList = other.getProcessList();
         if (this$processList == null ? other$processList == null : this$processList.equals(other$processList)) {
            Object this$artifactNameList = this.getArtifactNameList();
            Object other$artifactNameList = other.getArtifactNameList();
            return this$artifactNameList == null ? other$artifactNameList == null : this$artifactNameList.equals(other$artifactNameList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesAssemblingWeldingConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $artifactTypeName = this.getArtifactTypeName();
      result = result * 59 + ($artifactTypeName == null ? 43 : $artifactTypeName.hashCode());
      Object $processList = this.getProcessList();
      result = result * 59 + ($processList == null ? 43 : $processList.hashCode());
      Object $artifactNameList = this.getArtifactNameList();
      return result * 59 + ($artifactNameList == null ? 43 : $artifactNameList.hashCode());
   }

   public String getArtifactTypeName() {
      return this.artifactTypeName;
   }

   public List<NameInfo> getProcessList() {
      return this.processList;
   }

   public void setArtifactTypeName(final String artifactTypeName) {
      this.artifactTypeName = artifactTypeName;
   }

   public void setProcessList(final List<NameInfo> processList) {
      this.processList = processList;
   }

   public void setArtifactNameList(final List<String> artifactNameList) {
      this.artifactNameList = artifactNameList;
   }

   @Override
   public String toString() {
      return "MesAssemblingWeldingConfigDTO(super="
         + super.toString()
         + ", artifactTypeName="
         + this.getArtifactTypeName()
         + ", processList="
         + this.getProcessList()
         + ", artifactNameList="
         + this.getArtifactNameList()
         + ")";
   }
}
