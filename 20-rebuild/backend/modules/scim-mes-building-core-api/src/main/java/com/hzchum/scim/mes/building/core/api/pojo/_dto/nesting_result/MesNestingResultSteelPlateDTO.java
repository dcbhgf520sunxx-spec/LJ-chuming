package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingPartCheckDrillDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("套料成果钢板DTO")
public class MesNestingResultSteelPlateDTO extends MesBuildingBoChuNestingResult {
   @ApiModelProperty("混套jobIdList")
   private List<Integer> mixedJobIdList;
   @ApiModelProperty("是否混套(0:否,1:是)")
   private Boolean isMixNest;
   @ApiModelProperty("机床名称")
   private String machineToolName;
   @ApiModelProperty("设备mid")
   private String mid;
   @ApiModelProperty("零件List")
   private List<MesBuildingPartCheckDrillDTO> partList;

   public List<Integer> getMixedJobIdList() {
      return CollUtil.isEmpty(this.mixedJobIdList) && StrUtil.isNotBlank(super.getMixedJobIds())
         ? Convert.toList(Integer.class, StrUtil.split(super.getMixedJobIds(), ","))
         : this.mixedJobIdList;
   }

   public Boolean getIsMixNest() {
      return this.isMixNest;
   }

   public String getMachineToolName() {
      return this.machineToolName;
   }

   public String getMid() {
      return this.mid;
   }

   public List<MesBuildingPartCheckDrillDTO> getPartList() {
      return this.partList;
   }

   public void setMixedJobIdList(final List<Integer> mixedJobIdList) {
      this.mixedJobIdList = mixedJobIdList;
   }

   public void setIsMixNest(final Boolean isMixNest) {
      this.isMixNest = isMixNest;
   }

   public void setMachineToolName(final String machineToolName) {
      this.machineToolName = machineToolName;
   }

   public void setMid(final String mid) {
      this.mid = mid;
   }

   public void setPartList(final List<MesBuildingPartCheckDrillDTO> partList) {
      this.partList = partList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesNestingResultSteelPlateDTO)) {
         return false;
      }

      MesNestingResultSteelPlateDTO other = (MesNestingResultSteelPlateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$isMixNest = this.getIsMixNest();
      Object other$isMixNest = other.getIsMixNest();
      if (this$isMixNest == null ? other$isMixNest == null : this$isMixNest.equals(other$isMixNest)) {
         Object this$mixedJobIdList = this.getMixedJobIdList();
         Object other$mixedJobIdList = other.getMixedJobIdList();
         if (this$mixedJobIdList == null ? other$mixedJobIdList == null : this$mixedJobIdList.equals(other$mixedJobIdList)) {
            Object this$machineToolName = this.getMachineToolName();
            Object other$machineToolName = other.getMachineToolName();
            if (this$machineToolName == null ? other$machineToolName == null : this$machineToolName.equals(other$machineToolName)) {
               Object this$mid = this.getMid();
               Object other$mid = other.getMid();
               if (this$mid == null ? other$mid == null : this$mid.equals(other$mid)) {
                  Object this$partList = this.getPartList();
                  Object other$partList = other.getPartList();
                  return this$partList == null ? other$partList == null : this$partList.equals(other$partList);
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
      return other instanceof MesNestingResultSteelPlateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isMixNest = this.getIsMixNest();
      result = result * 59 + ($isMixNest == null ? 43 : $isMixNest.hashCode());
      Object $mixedJobIdList = this.getMixedJobIdList();
      result = result * 59 + ($mixedJobIdList == null ? 43 : $mixedJobIdList.hashCode());
      Object $machineToolName = this.getMachineToolName();
      result = result * 59 + ($machineToolName == null ? 43 : $machineToolName.hashCode());
      Object $mid = this.getMid();
      result = result * 59 + ($mid == null ? 43 : $mid.hashCode());
      Object $partList = this.getPartList();
      return result * 59 + ($partList == null ? 43 : $partList.hashCode());
   }

   @Override
   public String toString() {
      return "MesNestingResultSteelPlateDTO(mixedJobIdList="
         + this.getMixedJobIdList()
         + ", isMixNest="
         + this.getIsMixNest()
         + ", machineToolName="
         + this.getMachineToolName()
         + ", mid="
         + this.getMid()
         + ", partList="
         + this.getPartList()
         + ")";
   }
}
