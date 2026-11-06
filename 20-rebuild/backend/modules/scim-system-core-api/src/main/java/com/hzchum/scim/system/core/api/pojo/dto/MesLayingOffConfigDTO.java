package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.pojo._do.MesLayingOffConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("下料配置DTO类")
public class MesLayingOffConfigDTO extends MesLayingOffConfig {
   @ApiModelProperty(name = "steelClassificationName", value = "零件类型分类名称", notes = "零件类型分类名称")
   private String steelClassificationName;
   @ApiModelProperty(name = "specificationPrefixTypeList", value = "规格前缀类型列表", notes = "规格前缀类型列表")
   private List<String> specificationPrefixTypeList;
   @ApiModelProperty(name = "processIdList", value = "生产工序ID列表", notes = "生产工序ID列表")
   private List<Long> processIdList;
   @ApiModelProperty(name = "processNameList", value = "生产工序名称列表", notes = "生产工序名称列表")
   private List<String> processNameList;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesLayingOffConfigDTO)) {
         return false;
      }

      MesLayingOffConfigDTO other = (MesLayingOffConfigDTO)o;
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
      return other instanceof MesLayingOffConfigDTO;
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
      return result * 59 + ($processNameList == null ? 43 : $processNameList.hashCode());
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

   @Override
   public String toString() {
      return "MesLayingOffConfigDTO(super="
         + super.toString()
         + ", steelClassificationName="
         + this.getSteelClassificationName()
         + ", specificationPrefixTypeList="
         + this.getSpecificationPrefixTypeList()
         + ", processIdList="
         + this.getProcessIdList()
         + ", processNameList="
         + this.getProcessNameList()
         + ")";
   }
}
