package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesArtifactQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesArtifactQuotaConfigDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("构件定额配置DTO")
public class MesArtifactQuotaConfigDTO extends MesArtifactQuotaConfig {
   @ApiModelProperty("车间ID列表")
   private List<Long> workshopIdList;
   @ApiModelProperty("车间名称列表")
   private List<String> workshopNameList;
   @ApiModelProperty("构件类型ID列表")
   private List<Long> artifactClassIdList;
   @ApiModelProperty("构件类型名称列表")
   private List<String> artifactClassNameList;
   @ApiModelProperty("工序名称")
   private String processName;
   @ApiModelProperty("详情列表")
   private List<MesArtifactQuotaConfigDetail> detailList;

   public List<Long> getWorkshopIdList() {
      return CollUtil.isEmpty(this.workshopIdList) && StrUtil.isNotBlank(super.getWorkshopIds())
         ? Convert.toList(Long.class, super.getWorkshopIds().split(","))
         : this.workshopIdList;
   }

   public List<Long> getArtifactClassIdList() {
      return CollUtil.isEmpty(this.artifactClassIdList) && StrUtil.isNotBlank(super.getArtifactClassIds())
         ? Convert.toList(Long.class, super.getArtifactClassIds().split(","))
         : this.artifactClassIdList;
   }

   public List<String> getWorkshopNameList() {
      return this.workshopNameList;
   }

   public List<String> getArtifactClassNameList() {
      return this.artifactClassNameList;
   }

   public String getProcessName() {
      return this.processName;
   }

   public List<MesArtifactQuotaConfigDetail> getDetailList() {
      return this.detailList;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setWorkshopNameList(final List<String> workshopNameList) {
      this.workshopNameList = workshopNameList;
   }

   public void setArtifactClassIdList(final List<Long> artifactClassIdList) {
      this.artifactClassIdList = artifactClassIdList;
   }

   public void setArtifactClassNameList(final List<String> artifactClassNameList) {
      this.artifactClassNameList = artifactClassNameList;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setDetailList(final List<MesArtifactQuotaConfigDetail> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesArtifactQuotaConfigDTO)) {
         return false;
      }

      MesArtifactQuotaConfigDTO other = (MesArtifactQuotaConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$workshopIdList = this.getWorkshopIdList();
      Object other$workshopIdList = other.getWorkshopIdList();
      if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
         Object this$workshopNameList = this.getWorkshopNameList();
         Object other$workshopNameList = other.getWorkshopNameList();
         if (this$workshopNameList == null ? other$workshopNameList == null : this$workshopNameList.equals(other$workshopNameList)) {
            Object this$artifactClassIdList = this.getArtifactClassIdList();
            Object other$artifactClassIdList = other.getArtifactClassIdList();
            if (this$artifactClassIdList == null ? other$artifactClassIdList == null : this$artifactClassIdList.equals(other$artifactClassIdList)) {
               Object this$artifactClassNameList = this.getArtifactClassNameList();
               Object other$artifactClassNameList = other.getArtifactClassNameList();
               if (this$artifactClassNameList == null ? other$artifactClassNameList == null : this$artifactClassNameList.equals(other$artifactClassNameList)) {
                  Object this$processName = this.getProcessName();
                  Object other$processName = other.getProcessName();
                  if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                     Object this$detailList = this.getDetailList();
                     Object other$detailList = other.getDetailList();
                     return this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesArtifactQuotaConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $workshopNameList = this.getWorkshopNameList();
      result = result * 59 + ($workshopNameList == null ? 43 : $workshopNameList.hashCode());
      Object $artifactClassIdList = this.getArtifactClassIdList();
      result = result * 59 + ($artifactClassIdList == null ? 43 : $artifactClassIdList.hashCode());
      Object $artifactClassNameList = this.getArtifactClassNameList();
      result = result * 59 + ($artifactClassNameList == null ? 43 : $artifactClassNameList.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "MesArtifactQuotaConfigDTO(super="
         + super.toString()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", workshopNameList="
         + this.getWorkshopNameList()
         + ", artifactClassIdList="
         + this.getArtifactClassIdList()
         + ", artifactClassNameList="
         + this.getArtifactClassNameList()
         + ", processName="
         + this.getProcessName()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }
}
