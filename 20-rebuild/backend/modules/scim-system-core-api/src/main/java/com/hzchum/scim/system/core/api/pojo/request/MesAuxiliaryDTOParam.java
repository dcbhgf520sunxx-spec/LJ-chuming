package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class MesAuxiliaryDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "auxiliaryNameList", value = "配套件名称集合", notes = "配套件名称集合")
   private List<String> auxiliaryNameList;
   @ApiModelProperty(name = "artifactType", value = "配套件核算单位", notes = "配套件核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "basicClass", value = "基础材料类型", notes = "基础材料类型")
   private Integer basicClass;
   @ApiModelProperty(name = "meteDiff", value = "核算量误差值（可超过百分比）", notes = "核算量误差值（可超过百分比）")
   private BigDecimal meteDiff;
   @ApiModelProperty(name = "mesAuxiliaryRelevancyClassDTOParams", value = "配套件类型", notes = "配套件类型")
   private List<MesAuxiliaryRelevancyClassDTOParam> mesAuxiliaryRelevancyClassDTOParams;
   @ApiModelProperty(name = "delMesAuxiliaryRelevancyClassIds", value = "删除的明细Id", notes = "删除的明细Id")
   private List<Long> delMesAuxiliaryRelevancyClassIds;

   public Long getId() {
      return this.id;
   }

   public List<String> getAuxiliaryNameList() {
      return this.auxiliaryNameList;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getMeteDiff() {
      return this.meteDiff;
   }

   public List<MesAuxiliaryRelevancyClassDTOParam> getMesAuxiliaryRelevancyClassDTOParams() {
      return this.mesAuxiliaryRelevancyClassDTOParams;
   }

   public List<Long> getDelMesAuxiliaryRelevancyClassIds() {
      return this.delMesAuxiliaryRelevancyClassIds;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuxiliaryNameList(final List<String> auxiliaryNameList) {
      this.auxiliaryNameList = auxiliaryNameList;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMeteDiff(final BigDecimal meteDiff) {
      this.meteDiff = meteDiff;
   }

   public void setMesAuxiliaryRelevancyClassDTOParams(final List<MesAuxiliaryRelevancyClassDTOParam> mesAuxiliaryRelevancyClassDTOParams) {
      this.mesAuxiliaryRelevancyClassDTOParams = mesAuxiliaryRelevancyClassDTOParams;
   }

   public void setDelMesAuxiliaryRelevancyClassIds(final List<Long> delMesAuxiliaryRelevancyClassIds) {
      this.delMesAuxiliaryRelevancyClassIds = delMesAuxiliaryRelevancyClassIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAuxiliaryDTOParam)) {
         return false;
      }

      MesAuxiliaryDTOParam other = (MesAuxiliaryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$auxiliaryNameList = this.getAuxiliaryNameList();
            Object other$auxiliaryNameList = other.getAuxiliaryNameList();
            if (this$auxiliaryNameList == null ? other$auxiliaryNameList == null : this$auxiliaryNameList.equals(other$auxiliaryNameList)) {
               Object this$accountingUnit = this.getAccountingUnit();
               Object other$accountingUnit = other.getAccountingUnit();
               if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                  Object this$meteDiff = this.getMeteDiff();
                  Object other$meteDiff = other.getMeteDiff();
                  if (this$meteDiff == null ? other$meteDiff == null : this$meteDiff.equals(other$meteDiff)) {
                     Object this$mesAuxiliaryRelevancyClassDTOParams = this.getMesAuxiliaryRelevancyClassDTOParams();
                     Object other$mesAuxiliaryRelevancyClassDTOParams = other.getMesAuxiliaryRelevancyClassDTOParams();
                     if (this$mesAuxiliaryRelevancyClassDTOParams == null
                        ? other$mesAuxiliaryRelevancyClassDTOParams == null
                        : this$mesAuxiliaryRelevancyClassDTOParams.equals(other$mesAuxiliaryRelevancyClassDTOParams)) {
                        Object this$delMesAuxiliaryRelevancyClassIds = this.getDelMesAuxiliaryRelevancyClassIds();
                        Object other$delMesAuxiliaryRelevancyClassIds = other.getDelMesAuxiliaryRelevancyClassIds();
                        return this$delMesAuxiliaryRelevancyClassIds == null
                           ? other$delMesAuxiliaryRelevancyClassIds == null
                           : this$delMesAuxiliaryRelevancyClassIds.equals(other$delMesAuxiliaryRelevancyClassIds);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesAuxiliaryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $auxiliaryNameList = this.getAuxiliaryNameList();
      result = result * 59 + ($auxiliaryNameList == null ? 43 : $auxiliaryNameList.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $meteDiff = this.getMeteDiff();
      result = result * 59 + ($meteDiff == null ? 43 : $meteDiff.hashCode());
      Object $mesAuxiliaryRelevancyClassDTOParams = this.getMesAuxiliaryRelevancyClassDTOParams();
      result = result * 59 + ($mesAuxiliaryRelevancyClassDTOParams == null ? 43 : $mesAuxiliaryRelevancyClassDTOParams.hashCode());
      Object $delMesAuxiliaryRelevancyClassIds = this.getDelMesAuxiliaryRelevancyClassIds();
      return result * 59 + ($delMesAuxiliaryRelevancyClassIds == null ? 43 : $delMesAuxiliaryRelevancyClassIds.hashCode());
   }

   @Override
   public String toString() {
      return "MesAuxiliaryDTOParam(id="
         + this.getId()
         + ", auxiliaryNameList="
         + this.getAuxiliaryNameList()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", basicClass="
         + this.getBasicClass()
         + ", meteDiff="
         + this.getMeteDiff()
         + ", mesAuxiliaryRelevancyClassDTOParams="
         + this.getMesAuxiliaryRelevancyClassDTOParams()
         + ", delMesAuxiliaryRelevancyClassIds="
         + this.getDelMesAuxiliaryRelevancyClassIds()
         + ")";
   }
}
