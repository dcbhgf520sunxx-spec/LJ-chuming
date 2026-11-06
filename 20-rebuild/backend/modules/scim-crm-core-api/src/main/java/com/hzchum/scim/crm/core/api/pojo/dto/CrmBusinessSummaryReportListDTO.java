package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmBusinessSummaryReportListDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "departmentId", value = "填报人所在部门", notes = "填报人所在部门")
   private Long departmentId;
   @ApiModelProperty(name = "departmentName", value = "填报人所在部门名称", notes = "填报人所在部门名称")
   private String departmentName;
   @ApiModelProperty(name = "informantUserId", value = "填报人id", notes = "填报人id")
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人姓名", notes = "销售人姓名")
   private String informantUserName;
   @ApiModelProperty(name = "projectInformationWarehousingNum", value = "项目信息登记数量", notes = "项目信息登记数量")
   private Integer projectInformationWarehousingNum;
   @ApiModelProperty(name = "governmentWarehousingNum", value = "政府备案数量", notes = "政府备案数量")
   private Integer governmentWarehousingNum;
   @ApiModelProperty(name = "biddingPlatformWarehousingNum", value = "平台注册数量", notes = "平台注册数量")
   private Integer biddingPlatformWarehousingNum;
   @ApiModelProperty(name = "supplierWarehousingNum", value = "业主供应商入库数量项目投标报名数量", notes = "业主供应商入库数量")
   private Integer supplierWarehousingNum;
   @ApiModelProperty(name = "applyForBidRecordNum", value = "项目投标报名数量", notes = "项目目投标报名数量")
   private Integer applyForBidRecordNum;

   public CrmBusinessSummaryReportListDTO(
      final Long id,
      final String projectName,
      final Long departmentId,
      final String departmentName,
      final Long informantUserId,
      final String informantUserName,
      final Integer projectInformationWarehousingNum,
      final Integer governmentWarehousingNum,
      final Integer biddingPlatformWarehousingNum,
      final Integer supplierWarehousingNum,
      final Integer applyForBidRecordNum
   ) {
      this.id = id;
      this.projectName = projectName;
      this.departmentId = departmentId;
      this.departmentName = departmentName;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.projectInformationWarehousingNum = projectInformationWarehousingNum;
      this.governmentWarehousingNum = governmentWarehousingNum;
      this.biddingPlatformWarehousingNum = biddingPlatformWarehousingNum;
      this.supplierWarehousingNum = supplierWarehousingNum;
      this.applyForBidRecordNum = applyForBidRecordNum;
   }

   public CrmBusinessSummaryReportListDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public Integer getProjectInformationWarehousingNum() {
      return this.projectInformationWarehousingNum;
   }

   public Integer getGovernmentWarehousingNum() {
      return this.governmentWarehousingNum;
   }

   public Integer getBiddingPlatformWarehousingNum() {
      return this.biddingPlatformWarehousingNum;
   }

   public Integer getSupplierWarehousingNum() {
      return this.supplierWarehousingNum;
   }

   public Integer getApplyForBidRecordNum() {
      return this.applyForBidRecordNum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
   }

   public void setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
   }

   public void setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
   }

   public void setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
   }

   public void setProjectInformationWarehousingNum(final Integer projectInformationWarehousingNum) {
      this.projectInformationWarehousingNum = projectInformationWarehousingNum;
   }

   public void setGovernmentWarehousingNum(final Integer governmentWarehousingNum) {
      this.governmentWarehousingNum = governmentWarehousingNum;
   }

   public void setBiddingPlatformWarehousingNum(final Integer biddingPlatformWarehousingNum) {
      this.biddingPlatformWarehousingNum = biddingPlatformWarehousingNum;
   }

   public void setSupplierWarehousingNum(final Integer supplierWarehousingNum) {
      this.supplierWarehousingNum = supplierWarehousingNum;
   }

   public void setApplyForBidRecordNum(final Integer applyForBidRecordNum) {
      this.applyForBidRecordNum = applyForBidRecordNum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBusinessSummaryReportListDTO)) {
         return false;
      }

      CrmBusinessSummaryReportListDTO other = (CrmBusinessSummaryReportListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$departmentId = this.getDepartmentId();
         Object other$departmentId = other.getDepartmentId();
         if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
            Object this$informantUserId = this.getInformantUserId();
            Object other$informantUserId = other.getInformantUserId();
            if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
               Object this$projectInformationWarehousingNum = this.getProjectInformationWarehousingNum();
               Object other$projectInformationWarehousingNum = other.getProjectInformationWarehousingNum();
               if (this$projectInformationWarehousingNum == null
                  ? other$projectInformationWarehousingNum == null
                  : this$projectInformationWarehousingNum.equals(other$projectInformationWarehousingNum)) {
                  Object this$governmentWarehousingNum = this.getGovernmentWarehousingNum();
                  Object other$governmentWarehousingNum = other.getGovernmentWarehousingNum();
                  if (this$governmentWarehousingNum == null
                     ? other$governmentWarehousingNum == null
                     : this$governmentWarehousingNum.equals(other$governmentWarehousingNum)) {
                     Object this$biddingPlatformWarehousingNum = this.getBiddingPlatformWarehousingNum();
                     Object other$biddingPlatformWarehousingNum = other.getBiddingPlatformWarehousingNum();
                     if (this$biddingPlatformWarehousingNum == null
                        ? other$biddingPlatformWarehousingNum == null
                        : this$biddingPlatformWarehousingNum.equals(other$biddingPlatformWarehousingNum)) {
                        Object this$supplierWarehousingNum = this.getSupplierWarehousingNum();
                        Object other$supplierWarehousingNum = other.getSupplierWarehousingNum();
                        if (this$supplierWarehousingNum == null
                           ? other$supplierWarehousingNum == null
                           : this$supplierWarehousingNum.equals(other$supplierWarehousingNum)) {
                           Object this$applyForBidRecordNum = this.getApplyForBidRecordNum();
                           Object other$applyForBidRecordNum = other.getApplyForBidRecordNum();
                           if (this$applyForBidRecordNum == null
                              ? other$applyForBidRecordNum == null
                              : this$applyForBidRecordNum.equals(other$applyForBidRecordNum)) {
                              Object this$projectName = this.getProjectName();
                              Object other$projectName = other.getProjectName();
                              if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                 Object this$departmentName = this.getDepartmentName();
                                 Object other$departmentName = other.getDepartmentName();
                                 if (this$departmentName == null ? other$departmentName == null : this$departmentName.equals(other$departmentName)) {
                                    Object this$informantUserName = this.getInformantUserName();
                                    Object other$informantUserName = other.getInformantUserName();
                                    return this$informantUserName == null
                                       ? other$informantUserName == null
                                       : this$informantUserName.equals(other$informantUserName);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmBusinessSummaryReportListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $projectInformationWarehousingNum = this.getProjectInformationWarehousingNum();
      result = result * 59 + ($projectInformationWarehousingNum == null ? 43 : $projectInformationWarehousingNum.hashCode());
      Object $governmentWarehousingNum = this.getGovernmentWarehousingNum();
      result = result * 59 + ($governmentWarehousingNum == null ? 43 : $governmentWarehousingNum.hashCode());
      Object $biddingPlatformWarehousingNum = this.getBiddingPlatformWarehousingNum();
      result = result * 59 + ($biddingPlatformWarehousingNum == null ? 43 : $biddingPlatformWarehousingNum.hashCode());
      Object $supplierWarehousingNum = this.getSupplierWarehousingNum();
      result = result * 59 + ($supplierWarehousingNum == null ? 43 : $supplierWarehousingNum.hashCode());
      Object $applyForBidRecordNum = this.getApplyForBidRecordNum();
      result = result * 59 + ($applyForBidRecordNum == null ? 43 : $applyForBidRecordNum.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantUserName = this.getInformantUserName();
      return result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
   }

   @Override
   public String toString() {
      return "CrmBusinessSummaryReportListDTO(id="
         + this.getId()
         + ", projectName="
         + this.getProjectName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", departmentName="
         + this.getDepartmentName()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", projectInformationWarehousingNum="
         + this.getProjectInformationWarehousingNum()
         + ", governmentWarehousingNum="
         + this.getGovernmentWarehousingNum()
         + ", biddingPlatformWarehousingNum="
         + this.getBiddingPlatformWarehousingNum()
         + ", supplierWarehousingNum="
         + this.getSupplierWarehousingNum()
         + ", applyForBidRecordNum="
         + this.getApplyForBidRecordNum()
         + ")";
   }
}
