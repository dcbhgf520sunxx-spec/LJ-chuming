package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("退货单详情查询类")
public class ProjectRejectDetailQueryDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   private List<Long> projectIds;
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "rejectSn", value = "外购退货单编号", notes = "外购退货单编号")
   private String rejectSn;
   @ApiModelProperty(name = "purchaseSn", value = "采购单号", notes = "采购单号")
   private String purchaseSn;
   @ApiModelProperty(name = "supplierName", value = "供应商", notes = "供应商")
   private String supplierName;
   @ApiModelProperty(name = "monomerOrArea", value = "单体区域名称", notes = "单体区域名称")
   private String monomerOrArea;
   @ApiModelProperty(name = "reviewTime", value = "申请时间")
   List<LocalDateTime> reviewTime;
   @ApiModelProperty(name = "specification", notes = "规格", value = "规格")
   private String specification;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "reviewerName", value = "审核人", notes = "审核人")
   private String reviewerName;
   @ApiModelProperty(name = "applicantName", value = "申请人", notes = "申请人")
   private String applicantName;

   ProjectRejectDetailQueryDTOParam(
      final Long projectId,
      final List<Long> projectIds,
      final Integer productType,
      final String rejectSn,
      final String purchaseSn,
      final String supplierName,
      final String monomerOrArea,
      final List<LocalDateTime> reviewTime,
      final String specification,
      final String name,
      final String serialNumber,
      final String reviewerName,
      final String applicantName
   ) {
      this.projectId = projectId;
      this.projectIds = projectIds;
      this.productType = productType;
      this.rejectSn = rejectSn;
      this.purchaseSn = purchaseSn;
      this.supplierName = supplierName;
      this.monomerOrArea = monomerOrArea;
      this.reviewTime = reviewTime;
      this.specification = specification;
      this.name = name;
      this.serialNumber = serialNumber;
      this.reviewerName = reviewerName;
      this.applicantName = applicantName;
   }

   public static ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder builder() {
      return new ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getRejectSn() {
      return this.rejectSn;
   }

   public String getPurchaseSn() {
      return this.purchaseSn;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getMonomerOrArea() {
      return this.monomerOrArea;
   }

   public List<LocalDateTime> getReviewTime() {
      return this.reviewTime;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setRejectSn(final String rejectSn) {
      this.rejectSn = rejectSn;
   }

   public void setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setMonomerOrArea(final String monomerOrArea) {
      this.monomerOrArea = monomerOrArea;
   }

   public void setReviewTime(final List<LocalDateTime> reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectRejectDetailQueryDTOParam)) {
         return false;
      }

      ProjectRejectDetailQueryDTOParam other = (ProjectRejectDetailQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$projectIds = this.getProjectIds();
            Object other$projectIds = other.getProjectIds();
            if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
               Object this$rejectSn = this.getRejectSn();
               Object other$rejectSn = other.getRejectSn();
               if (this$rejectSn == null ? other$rejectSn == null : this$rejectSn.equals(other$rejectSn)) {
                  Object this$purchaseSn = this.getPurchaseSn();
                  Object other$purchaseSn = other.getPurchaseSn();
                  if (this$purchaseSn == null ? other$purchaseSn == null : this$purchaseSn.equals(other$purchaseSn)) {
                     Object this$supplierName = this.getSupplierName();
                     Object other$supplierName = other.getSupplierName();
                     if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                        Object this$monomerOrArea = this.getMonomerOrArea();
                        Object other$monomerOrArea = other.getMonomerOrArea();
                        if (this$monomerOrArea == null ? other$monomerOrArea == null : this$monomerOrArea.equals(other$monomerOrArea)) {
                           Object this$reviewTime = this.getReviewTime();
                           Object other$reviewTime = other.getReviewTime();
                           if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$reviewerName = this.getReviewerName();
                                       Object other$reviewerName = other.getReviewerName();
                                       if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                          Object this$applicantName = this.getApplicantName();
                                          Object other$applicantName = other.getApplicantName();
                                          return this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectRejectDetailQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $rejectSn = this.getRejectSn();
      result = result * 59 + ($rejectSn == null ? 43 : $rejectSn.hashCode());
      Object $purchaseSn = this.getPurchaseSn();
      result = result * 59 + ($purchaseSn == null ? 43 : $purchaseSn.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $monomerOrArea = this.getMonomerOrArea();
      result = result * 59 + ($monomerOrArea == null ? 43 : $monomerOrArea.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $applicantName = this.getApplicantName();
      return result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectRejectDetailQueryDTOParam(projectId="
         + this.getProjectId()
         + ", projectIds="
         + this.getProjectIds()
         + ", productType="
         + this.getProductType()
         + ", rejectSn="
         + this.getRejectSn()
         + ", purchaseSn="
         + this.getPurchaseSn()
         + ", supplierName="
         + this.getSupplierName()
         + ", monomerOrArea="
         + this.getMonomerOrArea()
         + ", reviewTime="
         + this.getReviewTime()
         + ", specification="
         + this.getSpecification()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", reviewerName="
         + this.getReviewerName()
         + ", applicantName="
         + this.getApplicantName()
         + ")";
   }

   public static class ProjectRejectDetailQueryDTOParamBuilder {
      private Long projectId;
      private List<Long> projectIds;
      private Integer productType;
      private String rejectSn;
      private String purchaseSn;
      private String supplierName;
      private String monomerOrArea;
      private List<LocalDateTime> reviewTime;
      private String specification;
      private String name;
      private String serialNumber;
      private String reviewerName;
      private String applicantName;

      ProjectRejectDetailQueryDTOParamBuilder() {
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder rejectSn(final String rejectSn) {
         this.rejectSn = rejectSn;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder monomerOrArea(final String monomerOrArea) {
         this.monomerOrArea = monomerOrArea;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder reviewTime(final List<LocalDateTime> reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ProjectRejectDetailQueryDTOParam build() {
         return new ProjectRejectDetailQueryDTOParam(
            this.projectId,
            this.projectIds,
            this.productType,
            this.rejectSn,
            this.purchaseSn,
            this.supplierName,
            this.monomerOrArea,
            this.reviewTime,
            this.specification,
            this.name,
            this.serialNumber,
            this.reviewerName,
            this.applicantName
         );
      }

      @Override
      public String toString() {
         return "ProjectRejectDetailQueryDTOParam.ProjectRejectDetailQueryDTOParamBuilder(projectId="
            + this.projectId
            + ", projectIds="
            + this.projectIds
            + ", productType="
            + this.productType
            + ", rejectSn="
            + this.rejectSn
            + ", purchaseSn="
            + this.purchaseSn
            + ", supplierName="
            + this.supplierName
            + ", monomerOrArea="
            + this.monomerOrArea
            + ", reviewTime="
            + this.reviewTime
            + ", specification="
            + this.specification
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", reviewerName="
            + this.reviewerName
            + ", applicantName="
            + this.applicantName
            + ")";
      }
   }
}
