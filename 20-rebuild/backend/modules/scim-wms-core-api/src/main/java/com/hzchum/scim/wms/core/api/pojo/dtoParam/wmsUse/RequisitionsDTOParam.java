package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class RequisitionsDTOParam {
   private Long id;
   @ApiModelProperty(name = "serialNumber", notes = "申购单号")
   @NotBlank(message = "申购单号不能为空")
   private String serialNumber;
   @ApiModelProperty(name = "projectId", notes = "项目ID")
   private Long projectId;
   @Valid
   private List<SteelCoilPurchaseApplyListDetailDTOParam> steelCoilList;
   @Valid
   private List<SteelPlatePurchaseApplyListDetailDTOParam> steelPlateList;
   @Valid
   private List<SectionSteelPurchaseApplyListDetailDTOParam> sectionSteelList;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<SteelCoilPurchaseApplyListDetailDTOParam> getSteelCoilList() {
      return this.steelCoilList;
   }

   public List<SteelPlatePurchaseApplyListDetailDTOParam> getSteelPlateList() {
      return this.steelPlateList;
   }

   public List<SectionSteelPurchaseApplyListDetailDTOParam> getSectionSteelList() {
      return this.sectionSteelList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSteelCoilList(final List<SteelCoilPurchaseApplyListDetailDTOParam> steelCoilList) {
      this.steelCoilList = steelCoilList;
   }

   public void setSteelPlateList(final List<SteelPlatePurchaseApplyListDetailDTOParam> steelPlateList) {
      this.steelPlateList = steelPlateList;
   }

   public void setSectionSteelList(final List<SectionSteelPurchaseApplyListDetailDTOParam> sectionSteelList) {
      this.sectionSteelList = sectionSteelList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RequisitionsDTOParam)) {
         return false;
      }

      RequisitionsDTOParam other = (RequisitionsDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$steelCoilList = this.getSteelCoilList();
               Object other$steelCoilList = other.getSteelCoilList();
               if (this$steelCoilList == null ? other$steelCoilList == null : this$steelCoilList.equals(other$steelCoilList)) {
                  Object this$steelPlateList = this.getSteelPlateList();
                  Object other$steelPlateList = other.getSteelPlateList();
                  if (this$steelPlateList == null ? other$steelPlateList == null : this$steelPlateList.equals(other$steelPlateList)) {
                     Object this$sectionSteelList = this.getSectionSteelList();
                     Object other$sectionSteelList = other.getSectionSteelList();
                     return this$sectionSteelList == null ? other$sectionSteelList == null : this$sectionSteelList.equals(other$sectionSteelList);
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
      return other instanceof RequisitionsDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $steelCoilList = this.getSteelCoilList();
      result = result * 59 + ($steelCoilList == null ? 43 : $steelCoilList.hashCode());
      Object $steelPlateList = this.getSteelPlateList();
      result = result * 59 + ($steelPlateList == null ? 43 : $steelPlateList.hashCode());
      Object $sectionSteelList = this.getSectionSteelList();
      return result * 59 + ($sectionSteelList == null ? 43 : $sectionSteelList.hashCode());
   }

   @Override
   public String toString() {
      return "RequisitionsDTOParam(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", steelCoilList="
         + this.getSteelCoilList()
         + ", steelPlateList="
         + this.getSteelPlateList()
         + ", sectionSteelList="
         + this.getSectionSteelList()
         + ")";
   }
}
