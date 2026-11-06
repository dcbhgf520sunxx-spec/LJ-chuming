package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectGroupWeldingConfigLink;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("项目组焊配置关联DTO类")
public class MesContractProjectGroupWeldingConfigLinkDTO extends MesContractProjectGroupWeldingConfigLink {
   @ApiModelProperty(name = "assembleConfigName", value = "部件类型名称", notes = "部件类型名称")
   private String assembleConfigName;
   @ApiModelProperty(name = "assembleSpecPrefixList", value = "部件规格前缀列表", notes = "部件规格前缀列表")
   private List<String> assembleSpecPrefixList;
   @ApiModelProperty(name = "processIdList", value = "生产工序ID列表", notes = "生产工序ID列表")
   private List<Long> processIdList;
   @ApiModelProperty(name = "processNameList", value = "生产工序名称列表", notes = "生产工序名称列表")
   private List<String> processNameList;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectGroupWeldingConfigLinkDTO)) {
         return false;
      }

      MesContractProjectGroupWeldingConfigLinkDTO other = (MesContractProjectGroupWeldingConfigLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$assembleConfigName = this.getAssembleConfigName();
      Object other$assembleConfigName = other.getAssembleConfigName();
      if (this$assembleConfigName == null ? other$assembleConfigName == null : this$assembleConfigName.equals(other$assembleConfigName)) {
         Object this$assembleSpecPrefixList = this.getAssembleSpecPrefixList();
         Object other$assembleSpecPrefixList = other.getAssembleSpecPrefixList();
         if (this$assembleSpecPrefixList == null ? other$assembleSpecPrefixList == null : this$assembleSpecPrefixList.equals(other$assembleSpecPrefixList)) {
            Object this$processIdList = this.getProcessIdList();
            Object other$processIdList = other.getProcessIdList();
            if (this$processIdList == null ? other$processIdList == null : this$processIdList.equals(other$processIdList)) {
               Object this$processNameList = this.getProcessNameList();
               Object other$processNameList = other.getProcessNameList();
               return this$processNameList == null ? other$processNameList == null : this$processNameList.equals(other$processNameList);
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
      return other instanceof MesContractProjectGroupWeldingConfigLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $assembleConfigName = this.getAssembleConfigName();
      result = result * 59 + ($assembleConfigName == null ? 43 : $assembleConfigName.hashCode());
      Object $assembleSpecPrefixList = this.getAssembleSpecPrefixList();
      result = result * 59 + ($assembleSpecPrefixList == null ? 43 : $assembleSpecPrefixList.hashCode());
      Object $processIdList = this.getProcessIdList();
      result = result * 59 + ($processIdList == null ? 43 : $processIdList.hashCode());
      Object $processNameList = this.getProcessNameList();
      return result * 59 + ($processNameList == null ? 43 : $processNameList.hashCode());
   }

   public String getAssembleConfigName() {
      return this.assembleConfigName;
   }

   public List<String> getAssembleSpecPrefixList() {
      return this.assembleSpecPrefixList;
   }

   public List<Long> getProcessIdList() {
      return this.processIdList;
   }

   public List<String> getProcessNameList() {
      return this.processNameList;
   }

   public void setAssembleConfigName(final String assembleConfigName) {
      this.assembleConfigName = assembleConfigName;
   }

   public void setAssembleSpecPrefixList(final List<String> assembleSpecPrefixList) {
      this.assembleSpecPrefixList = assembleSpecPrefixList;
   }

   public void setProcessIdList(final List<Long> processIdList) {
      this.processIdList = processIdList;
   }

   public void setProcessNameList(final List<String> processNameList) {
      this.processNameList = processNameList;
   }

   @Override
   public String toString() {
      return "MesContractProjectGroupWeldingConfigLinkDTO(super="
         + super.toString()
         + ", assembleConfigName="
         + this.getAssembleConfigName()
         + ", assembleSpecPrefixList="
         + this.getAssembleSpecPrefixList()
         + ", processIdList="
         + this.getProcessIdList()
         + ", processNameList="
         + this.getProcessNameList()
         + ")";
   }
}
