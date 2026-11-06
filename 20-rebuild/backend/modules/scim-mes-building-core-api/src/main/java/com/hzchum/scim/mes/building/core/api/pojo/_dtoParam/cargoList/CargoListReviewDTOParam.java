package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("发运审核查询")
public class CargoListReviewDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("发运是否审核通过 1通过 2不通过")
   private Integer checkStatus;
   @ApiModelProperty("车次编号")
   private String serialNumber;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("装车人名称")
   private String userName;
   @ApiModelProperty("过磅人名称")
   private String actualUserName;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("项目类型")
   private Integer projectType;
   @ApiModelProperty(notes = "页码")
   Integer pageNumber = 1;
   @ApiModelProperty(notes = "页数")
   Integer pageSize = 10;
   @ApiModelProperty(notes = "排序")
   List<String> sort;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getCheckStatus() {
      return this.checkStatus;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getActualUserName() {
      return this.actualUserName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public List<String> getSort() {
      return this.sort;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setCheckStatus(final Integer checkStatus) {
      this.checkStatus = checkStatus;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   public void setSort(final List<String> sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListReviewDTOParam)) {
         return false;
      }

      CargoListReviewDTOParam other = (CargoListReviewDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$checkStatus = this.getCheckStatus();
         Object other$checkStatus = other.getCheckStatus();
         if (this$checkStatus == null ? other$checkStatus == null : this$checkStatus.equals(other$checkStatus)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$projectType = this.getProjectType();
               Object other$projectType = other.getProjectType();
               if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                  Object this$pageNumber = this.getPageNumber();
                  Object other$pageNumber = other.getPageNumber();
                  if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                     Object this$pageSize = this.getPageSize();
                     Object other$pageSize = other.getPageSize();
                     if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$licensePlate = this.getLicensePlate();
                           Object other$licensePlate = other.getLicensePlate();
                           if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                              Object this$userName = this.getUserName();
                              Object other$userName = other.getUserName();
                              if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                 Object this$actualUserName = this.getActualUserName();
                                 Object other$actualUserName = other.getActualUserName();
                                 if (this$actualUserName == null ? other$actualUserName == null : this$actualUserName.equals(other$actualUserName)) {
                                    Object this$sort = this.getSort();
                                    Object other$sort = other.getSort();
                                    return this$sort == null ? other$sort == null : this$sort.equals(other$sort);
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
      return other instanceof CargoListReviewDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $checkStatus = this.getCheckStatus();
      result = result * 59 + ($checkStatus == null ? 43 : $checkStatus.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $actualUserName = this.getActualUserName();
      result = result * 59 + ($actualUserName == null ? 43 : $actualUserName.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListReviewDTOParam(projectId="
         + this.getProjectId()
         + ", checkStatus="
         + this.getCheckStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", userName="
         + this.getUserName()
         + ", actualUserName="
         + this.getActualUserName()
         + ", productType="
         + this.getProductType()
         + ", projectType="
         + this.getProjectType()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
