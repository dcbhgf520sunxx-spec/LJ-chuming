package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectDrillHoleConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectDrillHoleConfigLinkDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("项目钻孔配置关联DTO类")
public class MesContractProjectDrillHoleConfigLinkDTO extends MesContractProjectDrillHoleConfigLink {
   @ApiModelProperty(name = "steelClassificationName", value = "零件类型分类名称", notes = "零件类型分类名称")
   private String steelClassificationName;
   @ApiModelProperty(name = "specificationPrefixTypeList", value = "规格前缀类型列表", notes = "规格前缀类型列表")
   private List<String> specificationPrefixTypeList;
   @ApiModelProperty(name = "processIdList", value = "生产工序ID列表", notes = "生产工序ID列表")
   private List<Long> processIdList;
   @ApiModelProperty(name = "processNameList", value = "生产工序名称列表", notes = "生产工序名称列表")
   private List<String> processNameList;
   @ApiModelProperty(name = "detailList", value = "计价详情", notes = "计价详情")
   private List<MesContractProjectDrillHoleConfigLinkDetail> detailList;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectDrillHoleConfigLinkDTO)) {
         return false;
      }

      MesContractProjectDrillHoleConfigLinkDTO other = (MesContractProjectDrillHoleConfigLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$steelClassificationName = this.getSteelClassificationName();
      Object other$steelClassificationName = other.getSteelClassificationName();
      if (this$steelClassificationName == null ? other$steelClassificationName == null : this$steelClassificationName.equals(other$steelClassificationName)) {
         Object this$specificationPrefixTypeList = this.getSpecificationPrefixTypeList();
         Object other$specificationPrefixTypeList = other.getSpecificationPrefixTypeList();
         if (this$specificationPrefixTypeList == null
            ? other$specificationPrefixTypeList == null
            : this$specificationPrefixTypeList.equals(other$specificationPrefixTypeList)) {
            Object this$processIdList = this.getProcessIdList();
            Object other$processIdList = other.getProcessIdList();
            if (this$processIdList == null ? other$processIdList == null : this$processIdList.equals(other$processIdList)) {
               Object this$processNameList = this.getProcessNameList();
               Object other$processNameList = other.getProcessNameList();
               if (this$processNameList == null ? other$processNameList == null : this$processNameList.equals(other$processNameList)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesContractProjectDrillHoleConfigLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $steelClassificationName = this.getSteelClassificationName();
      result = result * 59 + ($steelClassificationName == null ? 43 : $steelClassificationName.hashCode());
      Object $specificationPrefixTypeList = this.getSpecificationPrefixTypeList();
      result = result * 59 + ($specificationPrefixTypeList == null ? 43 : $specificationPrefixTypeList.hashCode());
      Object $processIdList = this.getProcessIdList();
      result = result * 59 + ($processIdList == null ? 43 : $processIdList.hashCode());
      Object $processNameList = this.getProcessNameList();
      result = result * 59 + ($processNameList == null ? 43 : $processNameList.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   public String getSteelClassificationName() {
      return this.steelClassificationName;
   }

   public List<String> getSpecificationPrefixTypeList() {
      return this.specificationPrefixTypeList;
   }

   public List<Long> getProcessIdList() {
      return this.processIdList;
   }

   public List<String> getProcessNameList() {
      return this.processNameList;
   }

   public List<MesContractProjectDrillHoleConfigLinkDetail> getDetailList() {
      return this.detailList;
   }

   public void setSteelClassificationName(final String steelClassificationName) {
      this.steelClassificationName = steelClassificationName;
   }

   public void setSpecificationPrefixTypeList(final List<String> specificationPrefixTypeList) {
      this.specificationPrefixTypeList = specificationPrefixTypeList;
   }

   public void setProcessIdList(final List<Long> processIdList) {
      this.processIdList = processIdList;
   }

   public void setProcessNameList(final List<String> processNameList) {
      this.processNameList = processNameList;
   }

   public void setDetailList(final List<MesContractProjectDrillHoleConfigLinkDetail> detailList) {
      this.detailList = detailList;
   }

   @Override
   public String toString() {
      return "MesContractProjectDrillHoleConfigLinkDTO(super="
         + super.toString()
         + ", steelClassificationName="
         + this.getSteelClassificationName()
         + ", specificationPrefixTypeList="
         + this.getSpecificationPrefixTypeList()
         + ", processIdList="
         + this.getProcessIdList()
         + ", processNameList="
         + this.getProcessNameList()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }
}
