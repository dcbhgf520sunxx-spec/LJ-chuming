package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesCoatingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesCoatingProcessDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("涂装工艺表DTO类")
public class MesCoatingProcessDTO extends MesCoatingProcess {
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "detailList", value = "详情列表", notes = "详情列表")
   private List<MesCoatingProcessDetail> detailList;
   @ApiModelProperty(name = "contractProjectSerialNumber", value = "合同项目编号", notes = "合同项目编号")
   private String contractProjectSerialNumber;
   @ApiModelProperty(name = "contractProjectShortName", value = "合同项目简称", notes = "合同项目简称")
   private String contractProjectShortName;
   @ApiModelProperty(name = "primer", value = "底漆", notes = "底漆")
   private String primer;
   @ApiModelProperty(name = "intermediatePaint", value = "中间漆", notes = "中间漆")
   private String intermediatePaint;
   @ApiModelProperty(name = "topcoat", value = "面漆", notes = "面漆")
   private String topcoat;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesCoatingProcessDTO)) {
         return false;
      }

      MesCoatingProcessDTO other = (MesCoatingProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$createUserName = this.getCreateUserName();
      Object other$createUserName = other.getCreateUserName();
      if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
         Object this$detailList = this.getDetailList();
         Object other$detailList = other.getDetailList();
         if (this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesCoatingProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $detailList = this.getDetailList();
      result = result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
      Object $contractProjectSerialNumber = this.getContractProjectSerialNumber();
      result = result * 59 + ($contractProjectSerialNumber == null ? 43 : $contractProjectSerialNumber.hashCode());
      Object $contractProjectShortName = this.getContractProjectShortName();
      result = result * 59 + ($contractProjectShortName == null ? 43 : $contractProjectShortName.hashCode());
      Object $primer = this.getPrimer();
      result = result * 59 + ($primer == null ? 43 : $primer.hashCode());
      Object $intermediatePaint = this.getIntermediatePaint();
      result = result * 59 + ($intermediatePaint == null ? 43 : $intermediatePaint.hashCode());
      Object $topcoat = this.getTopcoat();
      return result * 59 + ($topcoat == null ? 43 : $topcoat.hashCode());
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public List<MesCoatingProcessDetail> getDetailList() {
      return this.detailList;
   }

   public String getContractProjectSerialNumber() {
      return this.contractProjectSerialNumber;
   }

   public String getContractProjectShortName() {
      return this.contractProjectShortName;
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

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setDetailList(final List<MesCoatingProcessDetail> detailList) {
      this.detailList = detailList;
   }

   public void setContractProjectSerialNumber(final String contractProjectSerialNumber) {
      this.contractProjectSerialNumber = contractProjectSerialNumber;
   }

   public void setContractProjectShortName(final String contractProjectShortName) {
      this.contractProjectShortName = contractProjectShortName;
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
   public String toString() {
      return "MesCoatingProcessDTO(super="
         + super.toString()
         + ", createUserName="
         + this.getCreateUserName()
         + ", detailList="
         + this.getDetailList()
         + ", contractProjectSerialNumber="
         + this.getContractProjectSerialNumber()
         + ", contractProjectShortName="
         + this.getContractProjectShortName()
         + ", primer="
         + this.getPrimer()
         + ", intermediatePaint="
         + this.getIntermediatePaint()
         + ", topcoat="
         + this.getTopcoat()
         + ")";
   }
}
