package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam._package;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesEnclosurePackage对象", description = "包 ")
public class MesEnclosurePackageDOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("包id")
   List<Long> packageIds;
   @ApiModelProperty("项目id")
   private List<Long> projectIds;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty("包单号")
   private String serialNumber;
   @ApiModelProperty("打包人")
   private String userName;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("产品编号")
   private String productSerialNumber;
   @ApiModelProperty("开始日期")
   private LocalDateTime startDate;
   @ApiModelProperty("结束日期")
   private LocalDateTime endDate;
   @ApiModelProperty("打印类型")
   private Boolean printType;
   @ApiModelProperty("状态 [0 未装车, 1 已装车, 2发运]")
   private Boolean status;
   @ApiModelProperty("页码")
   private Integer pageNumber = 1;
   @ApiModelProperty("页数")
   private Integer pageSize = 10;
   @ApiModelProperty("排序")
   private List<String> sort;

   public static MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder builder() {
      return new MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder();
   }

   public List<Long> getPackageIds() {
      return this.packageIds;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public Boolean getPrintType() {
      return this.printType;
   }

   public Boolean getStatus() {
      return this.status;
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

   public void setPackageIds(final List<Long> packageIds) {
      this.packageIds = packageIds;
   }

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
   }

   public void setPrintType(final Boolean printType) {
      this.printType = printType;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
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

      if (!(o instanceof MesEnclosurePackageDOParam)) {
         return false;
      }

      MesEnclosurePackageDOParam other = (MesEnclosurePackageDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$printType = this.getPrintType();
               Object other$printType = other.getPrintType();
               if (this$printType == null ? other$printType == null : this$printType.equals(other$printType)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$pageNumber = this.getPageNumber();
                     Object other$pageNumber = other.getPageNumber();
                     if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                        Object this$pageSize = this.getPageSize();
                        Object other$pageSize = other.getPageSize();
                        if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                           Object this$packageIds = this.getPackageIds();
                           Object other$packageIds = other.getPackageIds();
                           if (this$packageIds == null ? other$packageIds == null : this$packageIds.equals(other$packageIds)) {
                              Object this$projectIds = this.getProjectIds();
                              Object other$projectIds = other.getProjectIds();
                              if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$userName = this.getUserName();
                                    Object other$userName = other.getUserName();
                                    if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                          Object this$productSerialNumber = this.getProductSerialNumber();
                                          Object other$productSerialNumber = other.getProductSerialNumber();
                                          if (this$productSerialNumber == null
                                             ? other$productSerialNumber == null
                                             : this$productSerialNumber.equals(other$productSerialNumber)) {
                                             Object this$startDate = this.getStartDate();
                                             Object other$startDate = other.getStartDate();
                                             if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                                Object this$endDate = this.getEndDate();
                                                Object other$endDate = other.getEndDate();
                                                if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
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
      return other instanceof MesEnclosurePackageDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $printType = this.getPrintType();
      result = result * 59 + ($printType == null ? 43 : $printType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $packageIds = this.getPackageIds();
      result = result * 59 + ($packageIds == null ? 43 : $packageIds.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosurePackageDOParam(packageIds="
         + this.getPackageIds()
         + ", projectIds="
         + this.getProjectIds()
         + ", projectId="
         + this.getProjectId()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", userName="
         + this.getUserName()
         + ", remark="
         + this.getRemark()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", printType="
         + this.getPrintType()
         + ", status="
         + this.getStatus()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }

   public MesEnclosurePackageDOParam() {
   }

   public MesEnclosurePackageDOParam(
      final List<Long> packageIds,
      final List<Long> projectIds,
      final Long projectId,
      final Integer productType,
      final Integer category,
      final String serialNumber,
      final String userName,
      final String remark,
      final String productSerialNumber,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final Boolean printType,
      final Boolean status,
      final Integer pageNumber,
      final Integer pageSize,
      final List<String> sort
   ) {
      this.packageIds = packageIds;
      this.projectIds = projectIds;
      this.projectId = projectId;
      this.productType = productType;
      this.category = category;
      this.serialNumber = serialNumber;
      this.userName = userName;
      this.remark = remark;
      this.productSerialNumber = productSerialNumber;
      this.startDate = startDate;
      this.endDate = endDate;
      this.printType = printType;
      this.status = status;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
      this.sort = sort;
   }

   public static class MesEnclosurePackageDOParamBuilder {
      private List<Long> packageIds;
      private List<Long> projectIds;
      private Long projectId;
      private Integer productType;
      private Integer category;
      private String serialNumber;
      private String userName;
      private String remark;
      private String productSerialNumber;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private Boolean printType;
      private Boolean status;
      private Integer pageNumber;
      private Integer pageSize;
      private List<String> sort;

      MesEnclosurePackageDOParamBuilder() {
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder packageIds(final List<Long> packageIds) {
         this.packageIds = packageIds;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder printType(final Boolean printType) {
         this.printType = printType;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder pageNumber(final Integer pageNumber) {
         this.pageNumber = pageNumber;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder pageSize(final Integer pageSize) {
         this.pageSize = pageSize;
         return this;
      }

      public MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder sort(final List<String> sort) {
         this.sort = sort;
         return this;
      }

      public MesEnclosurePackageDOParam build() {
         return new MesEnclosurePackageDOParam(
            this.packageIds,
            this.projectIds,
            this.projectId,
            this.productType,
            this.category,
            this.serialNumber,
            this.userName,
            this.remark,
            this.productSerialNumber,
            this.startDate,
            this.endDate,
            this.printType,
            this.status,
            this.pageNumber,
            this.pageSize,
            this.sort
         );
      }

      @Override
      public String toString() {
         return "MesEnclosurePackageDOParam.MesEnclosurePackageDOParamBuilder(packageIds="
            + this.packageIds
            + ", projectIds="
            + this.projectIds
            + ", projectId="
            + this.projectId
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", serialNumber="
            + this.serialNumber
            + ", userName="
            + this.userName
            + ", remark="
            + this.remark
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", printType="
            + this.printType
            + ", status="
            + this.status
            + ", pageNumber="
            + this.pageNumber
            + ", pageSize="
            + this.pageSize
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
