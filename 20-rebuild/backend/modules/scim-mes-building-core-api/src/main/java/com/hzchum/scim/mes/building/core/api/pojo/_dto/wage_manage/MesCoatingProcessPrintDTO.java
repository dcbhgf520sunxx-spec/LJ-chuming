package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("涂装工艺打印DTO类")
public class MesCoatingProcessPrintDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "contractProjectSerialNumber", value = "合同项目编号", notes = "合同项目编号")
   private String contractProjectSerialNumber;
   @ApiModelProperty(name = "contractProjectShortName", value = "合同项目简称", notes = "合同项目简称")
   private String contractProjectShortName;
   @ApiModelProperty(name = "serialNumber", value = "工艺编号", notes = "工艺编号")
   private String serialNumber;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "artifactQuantity", value = "构件数量(件)", notes = "构件数量(件)")
   private Integer artifactQuantity;
   @ApiModelProperty(name = "totalArea", value = "总面积(㎡)", notes = "总面积(㎡)")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "primer", value = "底漆", notes = "底漆")
   private String primer;
   @ApiModelProperty(name = "intermediatePaint", value = "中间漆", notes = "中间漆")
   private String intermediatePaint;
   @ApiModelProperty(name = "topcoat", value = "面漆", notes = "面漆")
   private String topcoat;

   public Long getId() {
      return this.id;
   }

   public String getContractProjectSerialNumber() {
      return this.contractProjectSerialNumber;
   }

   public String getContractProjectShortName() {
      return this.contractProjectShortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getArtifactQuantity() {
      return this.artifactQuantity;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public String getPrimer() {
      return this.primer;
   }

   public String getIntermediatePaint() {
      return this.intermediatePaint;
   }

   public String getTopcoat() {
      return this.topcoat;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setContractProjectSerialNumber(final String contractProjectSerialNumber) {
      this.contractProjectSerialNumber = contractProjectSerialNumber;
   }

   public void setContractProjectShortName(final String contractProjectShortName) {
      this.contractProjectShortName = contractProjectShortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setArtifactQuantity(final Integer artifactQuantity) {
      this.artifactQuantity = artifactQuantity;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setPrimer(final String primer) {
      this.primer = primer;
   }

   public void setIntermediatePaint(final String intermediatePaint) {
      this.intermediatePaint = intermediatePaint;
   }

   public void setTopcoat(final String topcoat) {
      this.topcoat = topcoat;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesCoatingProcessPrintDTO)) {
         return false;
      }

      MesCoatingProcessPrintDTO other = (MesCoatingProcessPrintDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactQuantity = this.getArtifactQuantity();
         Object other$artifactQuantity = other.getArtifactQuantity();
         if (this$artifactQuantity == null ? other$artifactQuantity == null : this$artifactQuantity.equals(other$artifactQuantity)) {
            Object this$contractProjectSerialNumber = this.getContractProjectSerialNumber();
            Object other$contractProjectSerialNumber = other.getContractProjectSerialNumber();
            if (this$contractProjectSerialNumber == null
               ? other$contractProjectSerialNumber == null
               : this$contractProjectSerialNumber.equals(other$contractProjectSerialNumber)) {
               Object this$contractProjectShortName = this.getContractProjectShortName();
               Object other$contractProjectShortName = other.getContractProjectShortName();
               if (this$contractProjectShortName == null
                  ? other$contractProjectShortName == null
                  : this$contractProjectShortName.equals(other$contractProjectShortName)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$createUserName = this.getCreateUserName();
                     Object other$createUserName = other.getCreateUserName();
                     if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                        Object this$totalArea = this.getTotalArea();
                        Object other$totalArea = other.getTotalArea();
                        if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                           Object this$primer = this.getPrimer();
                           Object other$primer = other.getPrimer();
                           if (this$primer == null ? other$primer == null : this$primer.equals(other$primer)) {
                              Object this$intermediatePaint = this.getIntermediatePaint();
                              Object other$intermediatePaint = other.getIntermediatePaint();
                              if (this$intermediatePaint == null ? other$intermediatePaint == null : this$intermediatePaint.equals(other$intermediatePaint)) {
                                 Object this$topcoat = this.getTopcoat();
                                 Object other$topcoat = other.getTopcoat();
                                 return this$topcoat == null ? other$topcoat == null : this$topcoat.equals(other$topcoat);
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
      return other instanceof MesCoatingProcessPrintDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactQuantity = this.getArtifactQuantity();
      result = result * 59 + ($artifactQuantity == null ? 43 : $artifactQuantity.hashCode());
      Object $contractProjectSerialNumber = this.getContractProjectSerialNumber();
      result = result * 59 + ($contractProjectSerialNumber == null ? 43 : $contractProjectSerialNumber.hashCode());
      Object $contractProjectShortName = this.getContractProjectShortName();
      result = result * 59 + ($contractProjectShortName == null ? 43 : $contractProjectShortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $primer = this.getPrimer();
      result = result * 59 + ($primer == null ? 43 : $primer.hashCode());
      Object $intermediatePaint = this.getIntermediatePaint();
      result = result * 59 + ($intermediatePaint == null ? 43 : $intermediatePaint.hashCode());
      Object $topcoat = this.getTopcoat();
      return result * 59 + ($topcoat == null ? 43 : $topcoat.hashCode());
   }

   @Override
   public String toString() {
      return "MesCoatingProcessPrintDTO(id="
         + this.getId()
         + ", contractProjectSerialNumber="
         + this.getContractProjectSerialNumber()
         + ", contractProjectShortName="
         + this.getContractProjectShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", createUserName="
         + this.getCreateUserName()
         + ", artifactQuantity="
         + this.getArtifactQuantity()
         + ", totalArea="
         + this.getTotalArea()
         + ", primer="
         + this.getPrimer()
         + ", intermediatePaint="
         + this.getIntermediatePaint()
         + ", topcoat="
         + this.getTopcoat()
         + ")";
   }
}
