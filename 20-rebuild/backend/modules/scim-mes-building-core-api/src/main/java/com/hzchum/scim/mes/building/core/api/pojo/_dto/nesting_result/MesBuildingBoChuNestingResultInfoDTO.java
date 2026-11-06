package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.plan.core.api.pojo.dto.TechMachinePartInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("套料成果信息DTO")
public class MesBuildingBoChuNestingResultInfoDTO extends MesBuildingBoChuNestingResult {
   @ApiModelProperty("混套jobIdList")
   private List<Integer> mixedJobIdList;
   @ApiModelProperty("机床名称")
   private String machineToolName;
   @ApiModelProperty("设备mid")
   private String mid;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("零件List")
   private List<TechMachinePartInfoDTO> partList;

   public List<Integer> getMixedJobIdList() {
      return CollUtil.isEmpty(this.mixedJobIdList) && StrUtil.isNotBlank(super.getMixedJobIds())
         ? Convert.toList(Integer.class, StrUtil.split(super.getMixedJobIds(), ","))
         : this.mixedJobIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoChuNestingResultInfoDTO)) {
         return false;
      }

      MesBuildingBoChuNestingResultInfoDTO other = (MesBuildingBoChuNestingResultInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
      return other instanceof MesBuildingBoChuNestingResultInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
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
      return "MesBuildingBoChuNestingResultInfoDTO(super="
         + super.toString()
         + ", mixedJobIdList="
         + this.getMixedJobIdList()
         + ", machineToolName="
         + this.getMachineToolName()
         + ", mid="
         + this.getMid()
         + ", projectId="
         + this.getProjectId()
         + ", partList="
         + this.getPartList()
         + ")";
   }

   public String getMachineToolName() {
      return this.machineToolName;
   }

   public String getMid() {
      return this.mid;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<TechMachinePartInfoDTO> getPartList() {
      return this.partList;
   }

   public void setMixedJobIdList(final List<Integer> mixedJobIdList) {
      this.mixedJobIdList = mixedJobIdList;
   }

   public void setMachineToolName(final String machineToolName) {
      this.machineToolName = machineToolName;
   }

   public void setMid(final String mid) {
      this.mid = mid;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setPartList(final List<TechMachinePartInfoDTO> partList) {
      this.partList = partList;
   }
}
