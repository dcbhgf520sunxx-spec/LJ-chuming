package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesAssembleQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesAssembleQuotaConfigDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("部件定额配置DTO")
public class MesAssembleQuotaConfigDTO extends MesAssembleQuotaConfig {
   @ApiModelProperty("车间ID列表")
   private List<Long> workshopIdList;
   @ApiModelProperty("车间名称列表")
   private List<String> workshopNameList;
   @ApiModelProperty("构件类型ID列表")
   private List<Long> assembleClassIdList;
   @ApiModelProperty("构件类型名称列表")
   private List<String> assembleClassNameList;
   @ApiModelProperty("工序名称")
   private String processName;
   @ApiModelProperty("详情列表")
   private List<MesAssembleQuotaConfigDetail> detailList;

   public List<Long> getWorkshopIdList() {
      return CollUtil.isEmpty(this.workshopIdList) && StrUtil.isNotBlank(super.getWorkshopIds())
         ? Convert.toList(Long.class, super.getWorkshopIds().split(","))
         : this.workshopIdList;
   }

   public List<Long> getAssembleClassIdList() {
      return CollUtil.isEmpty(this.assembleClassIdList) && StrUtil.isNotBlank(super.getAssembleClassIds())
         ? Convert.toList(Long.class, super.getAssembleClassIds().split(","))
         : this.assembleClassIdList;
   }

   public List<String> getWorkshopNameList() {
      return this.workshopNameList;
   }

   public List<String> getAssembleClassNameList() {
      return this.assembleClassNameList;
   }

   public String getProcessName() {
      return this.processName;
   }

   public List<MesAssembleQuotaConfigDetail> getDetailList() {
      return this.detailList;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setWorkshopNameList(final List<String> workshopNameList) {
      this.workshopNameList = workshopNameList;
   }

   public void setAssembleClassIdList(final List<Long> assembleClassIdList) {
      this.assembleClassIdList = assembleClassIdList;
   }

   public void setAssembleClassNameList(final List<String> assembleClassNameList) {
      this.assembleClassNameList = assembleClassNameList;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setDetailList(final List<MesAssembleQuotaConfigDetail> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAssembleQuotaConfigDTO)) {
         return false;
      }

      MesAssembleQuotaConfigDTO other = (MesAssembleQuotaConfigDTO)o;
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
            Object this$assembleClassIdList = this.getAssembleClassIdList();
            Object other$assembleClassIdList = other.getAssembleClassIdList();
            if (this$assembleClassIdList == null ? other$assembleClassIdList == null : this$assembleClassIdList.equals(other$assembleClassIdList)) {
               Object this$assembleClassNameList = this.getAssembleClassNameList();
               Object other$assembleClassNameList = other.getAssembleClassNameList();
               if (this$assembleClassNameList == null ? other$assembleClassNameList == null : this$assembleClassNameList.equals(other$assembleClassNameList)) {
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
      return other instanceof MesAssembleQuotaConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $workshopNameList = this.getWorkshopNameList();
      result = result * 59 + ($workshopNameList == null ? 43 : $workshopNameList.hashCode());
      Object $assembleClassIdList = this.getAssembleClassIdList();
      result = result * 59 + ($assembleClassIdList == null ? 43 : $assembleClassIdList.hashCode());
      Object $assembleClassNameList = this.getAssembleClassNameList();
      result = result * 59 + ($assembleClassNameList == null ? 43 : $assembleClassNameList.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "MesAssembleQuotaConfigDTO(super="
         + super.toString()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", workshopNameList="
         + this.getWorkshopNameList()
         + ", assembleClassIdList="
         + this.getAssembleClassIdList()
         + ", assembleClassNameList="
         + this.getAssembleClassNameList()
         + ", processName="
         + this.getProcessName()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }
}
