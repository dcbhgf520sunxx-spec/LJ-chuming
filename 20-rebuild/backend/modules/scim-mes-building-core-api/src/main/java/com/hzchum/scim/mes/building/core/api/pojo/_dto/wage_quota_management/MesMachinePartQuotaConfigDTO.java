package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesMachinePartQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesMachinePartQuotaConfigDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("零件定额配置DTO")
public class MesMachinePartQuotaConfigDTO extends MesMachinePartQuotaConfig {
   @ApiModelProperty("车间ID列表")
   private List<Long> workshopIdList;
   @ApiModelProperty("车间名称列表")
   private List<String> workshopNameList;
   @ApiModelProperty("零件类型ID列表")
   private List<Long> machinePartClassIdList;
   @ApiModelProperty("零件类型名称列表")
   private List<String> machinePartClassNameList;
   @ApiModelProperty("工序名称")
   private String processName;
   @ApiModelProperty("工序类型")
   private Integer processType;
   @ApiModelProperty("详情列表")
   private List<MesMachinePartQuotaConfigDetail> detailList;

   public List<Long> getWorkshopIdList() {
      return CollUtil.isEmpty(this.workshopIdList) && StrUtil.isNotBlank(super.getWorkshopIds())
         ? Convert.toList(Long.class, super.getWorkshopIds().split(","))
         : this.workshopIdList;
   }

   public List<Long> getMachinePartClassIdList() {
      return CollUtil.isEmpty(this.machinePartClassIdList) && StrUtil.isNotBlank(super.getMachinePartClassIds())
         ? Convert.toList(Long.class, super.getMachinePartClassIds().split(","))
         : this.machinePartClassIdList;
   }

   public List<String> getWorkshopNameList() {
      return this.workshopNameList;
   }

   public List<String> getMachinePartClassNameList() {
      return this.machinePartClassNameList;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getProcessType() {
      return this.processType;
   }

   public List<MesMachinePartQuotaConfigDetail> getDetailList() {
      return this.detailList;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setWorkshopNameList(final List<String> workshopNameList) {
      this.workshopNameList = workshopNameList;
   }

   public void setMachinePartClassIdList(final List<Long> machinePartClassIdList) {
      this.machinePartClassIdList = machinePartClassIdList;
   }

   public void setMachinePartClassNameList(final List<String> machinePartClassNameList) {
      this.machinePartClassNameList = machinePartClassNameList;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setProcessType(final Integer processType) {
      this.processType = processType;
   }

   public void setDetailList(final List<MesMachinePartQuotaConfigDetail> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMachinePartQuotaConfigDTO)) {
         return false;
      }

      MesMachinePartQuotaConfigDTO other = (MesMachinePartQuotaConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$processType = this.getProcessType();
      Object other$processType = other.getProcessType();
      if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
         Object this$workshopIdList = this.getWorkshopIdList();
         Object other$workshopIdList = other.getWorkshopIdList();
         if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
            Object this$workshopNameList = this.getWorkshopNameList();
            Object other$workshopNameList = other.getWorkshopNameList();
            if (this$workshopNameList == null ? other$workshopNameList == null : this$workshopNameList.equals(other$workshopNameList)) {
               Object this$machinePartClassIdList = this.getMachinePartClassIdList();
               Object other$machinePartClassIdList = other.getMachinePartClassIdList();
               if (this$machinePartClassIdList == null
                  ? other$machinePartClassIdList == null
                  : this$machinePartClassIdList.equals(other$machinePartClassIdList)) {
                  Object this$machinePartClassNameList = this.getMachinePartClassNameList();
                  Object other$machinePartClassNameList = other.getMachinePartClassNameList();
                  if (this$machinePartClassNameList == null
                     ? other$machinePartClassNameList == null
                     : this$machinePartClassNameList.equals(other$machinePartClassNameList)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesMachinePartQuotaConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $workshopNameList = this.getWorkshopNameList();
      result = result * 59 + ($workshopNameList == null ? 43 : $workshopNameList.hashCode());
      Object $machinePartClassIdList = this.getMachinePartClassIdList();
      result = result * 59 + ($machinePartClassIdList == null ? 43 : $machinePartClassIdList.hashCode());
      Object $machinePartClassNameList = this.getMachinePartClassNameList();
      result = result * 59 + ($machinePartClassNameList == null ? 43 : $machinePartClassNameList.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "MesMachinePartQuotaConfigDTO(super="
         + super.toString()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", workshopNameList="
         + this.getWorkshopNameList()
         + ", machinePartClassIdList="
         + this.getMachinePartClassIdList()
         + ", machinePartClassNameList="
         + this.getMachinePartClassNameList()
         + ", processName="
         + this.getProcessName()
         + ", processType="
         + this.getProcessType()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }
}
