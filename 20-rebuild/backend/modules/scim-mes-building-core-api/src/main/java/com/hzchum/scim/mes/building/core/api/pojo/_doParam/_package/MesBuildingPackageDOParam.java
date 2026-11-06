package com.hzchum.scim.mes.building.core.api.pojo._doParam._package;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingPackage对象", description = "包 ")
public class MesBuildingPackageDOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("包id")
   List<Long> packageIds;
   @ApiModelProperty("项目id")
   private List<Long> projectIds;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("区域id")
   private Long areaId;
   @ApiModelProperty(value = "产品类型", name = "productType", notes = " 1零件 2构件 4围护 8配套件 16部件")
   private Integer productType;
   @ApiModelProperty(name = "category", notes = "2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
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
   private Integer status;
   @ApiModelProperty("是否已发运")
   private Boolean boolShip;
   @ApiModelProperty("项目类型")
   private Integer projectType;
   @ApiModelProperty("页码")
   private Integer pageNumber = 1;
   @ApiModelProperty("页数")
   private Integer pageSize = 10;
   @ApiModelProperty("排序")
   private List<String> sort;
   @ApiModelProperty("是否精确查询")
   private Boolean boolAccurateQuery;
   @ApiModelProperty("单体名称")
   private String monomerName;
   @ApiModelProperty("产品名称")
   private String productName;
   @ApiModelProperty("批次名称")
   private String areaBatchName;
   @ApiModelProperty("入库类型列表")
   private List<Integer> warehouseTypeList;

   private static Boolean $default$boolAccurateQuery() {
      return Boolean.FALSE;
   }

   public static MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder builder() {
      return new MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder();
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

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public Integer getStatus() {
      return this.status;
   }

   public Boolean getBoolShip() {
      return this.boolShip;
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

   public Boolean getBoolAccurateQuery() {
      return this.boolAccurateQuery;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getAreaBatchName() {
      return this.areaBatchName;
   }

   public List<Integer> getWarehouseTypeList() {
      return this.warehouseTypeList;
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

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
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

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setBoolShip(final Boolean boolShip) {
      this.boolShip = boolShip;
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

   public void setBoolAccurateQuery(final Boolean boolAccurateQuery) {
      this.boolAccurateQuery = boolAccurateQuery;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setProductName(final String productName) {
      this.productName = productName;
   }

   public void setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
   }

   public void setWarehouseTypeList(final List<Integer> warehouseTypeList) {
      this.warehouseTypeList = warehouseTypeList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageDOParam)) {
         return false;
      }

      MesBuildingPackageDOParam other = (MesBuildingPackageDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
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
                           Object this$boolShip = this.getBoolShip();
                           Object other$boolShip = other.getBoolShip();
                           if (this$boolShip == null ? other$boolShip == null : this$boolShip.equals(other$boolShip)) {
                              Object this$projectType = this.getProjectType();
                              Object other$projectType = other.getProjectType();
                              if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                                 Object this$pageNumber = this.getPageNumber();
                                 Object other$pageNumber = other.getPageNumber();
                                 if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                                    Object this$pageSize = this.getPageSize();
                                    Object other$pageSize = other.getPageSize();
                                    if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                                       Object this$boolAccurateQuery = this.getBoolAccurateQuery();
                                       Object other$boolAccurateQuery = other.getBoolAccurateQuery();
                                       if (this$boolAccurateQuery == null
                                          ? other$boolAccurateQuery == null
                                          : this$boolAccurateQuery.equals(other$boolAccurateQuery)) {
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
                                                                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                                                                     Object this$monomerName = this.getMonomerName();
                                                                     Object other$monomerName = other.getMonomerName();
                                                                     if (this$monomerName == null
                                                                        ? other$monomerName == null
                                                                        : this$monomerName.equals(other$monomerName)) {
                                                                        Object this$productName = this.getProductName();
                                                                        Object other$productName = other.getProductName();
                                                                        if (this$productName == null
                                                                           ? other$productName == null
                                                                           : this$productName.equals(other$productName)) {
                                                                           Object this$areaBatchName = this.getAreaBatchName();
                                                                           Object other$areaBatchName = other.getAreaBatchName();
                                                                           if (this$areaBatchName == null
                                                                              ? other$areaBatchName == null
                                                                              : this$areaBatchName.equals(other$areaBatchName)) {
                                                                              Object this$warehouseTypeList = this.getWarehouseTypeList();
                                                                              Object other$warehouseTypeList = other.getWarehouseTypeList();
                                                                              return this$warehouseTypeList == null
                                                                                 ? other$warehouseTypeList == null
                                                                                 : this$warehouseTypeList.equals(other$warehouseTypeList);
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
      return other instanceof MesBuildingPackageDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $printType = this.getPrintType();
      result = result * 59 + ($printType == null ? 43 : $printType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $boolShip = this.getBoolShip();
      result = result * 59 + ($boolShip == null ? 43 : $boolShip.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $boolAccurateQuery = this.getBoolAccurateQuery();
      result = result * 59 + ($boolAccurateQuery == null ? 43 : $boolAccurateQuery.hashCode());
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
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
      Object $warehouseTypeList = this.getWarehouseTypeList();
      return result * 59 + ($warehouseTypeList == null ? 43 : $warehouseTypeList.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPackageDOParam(packageIds="
         + this.getPackageIds()
         + ", projectIds="
         + this.getProjectIds()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
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
         + ", boolShip="
         + this.getBoolShip()
         + ", projectType="
         + this.getProjectType()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ", boolAccurateQuery="
         + this.getBoolAccurateQuery()
         + ", monomerName="
         + this.getMonomerName()
         + ", productName="
         + this.getProductName()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", warehouseTypeList="
         + this.getWarehouseTypeList()
         + ")";
   }

   public MesBuildingPackageDOParam() {
      this.boolAccurateQuery = $default$boolAccurateQuery();
   }

   public MesBuildingPackageDOParam(
      final List<Long> packageIds,
      final List<Long> projectIds,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer productType,
      final Integer category,
      final String serialNumber,
      final String userName,
      final String remark,
      final String productSerialNumber,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final Boolean printType,
      final Integer status,
      final Boolean boolShip,
      final Integer projectType,
      final Integer pageNumber,
      final Integer pageSize,
      final List<String> sort,
      final Boolean boolAccurateQuery,
      final String monomerName,
      final String productName,
      final String areaBatchName,
      final List<Integer> warehouseTypeList
   ) {
      this.packageIds = packageIds;
      this.projectIds = projectIds;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
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
      this.boolShip = boolShip;
      this.projectType = projectType;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
      this.sort = sort;
      this.boolAccurateQuery = boolAccurateQuery;
      this.monomerName = monomerName;
      this.productName = productName;
      this.areaBatchName = areaBatchName;
      this.warehouseTypeList = warehouseTypeList;
   }

   public static class MesBuildingPackageDOParamBuilder {
      private List<Long> packageIds;
      private List<Long> projectIds;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer productType;
      private Integer category;
      private String serialNumber;
      private String userName;
      private String remark;
      private String productSerialNumber;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private Boolean printType;
      private Integer status;
      private Boolean boolShip;
      private Integer projectType;
      private Integer pageNumber;
      private Integer pageSize;
      private List<String> sort;
      private boolean boolAccurateQuery$set;
      private Boolean boolAccurateQuery$value;
      private String monomerName;
      private String productName;
      private String areaBatchName;
      private List<Integer> warehouseTypeList;

      MesBuildingPackageDOParamBuilder() {
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder packageIds(final List<Long> packageIds) {
         this.packageIds = packageIds;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder printType(final Boolean printType) {
         this.printType = printType;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder boolShip(final Boolean boolShip) {
         this.boolShip = boolShip;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder pageNumber(final Integer pageNumber) {
         this.pageNumber = pageNumber;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder pageSize(final Integer pageSize) {
         this.pageSize = pageSize;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder sort(final List<String> sort) {
         this.sort = sort;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder boolAccurateQuery(final Boolean boolAccurateQuery) {
         this.boolAccurateQuery$value = boolAccurateQuery;
         this.boolAccurateQuery$set = true;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder areaBatchName(final String areaBatchName) {
         this.areaBatchName = areaBatchName;
         return this;
      }

      public MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder warehouseTypeList(final List<Integer> warehouseTypeList) {
         this.warehouseTypeList = warehouseTypeList;
         return this;
      }

      public MesBuildingPackageDOParam build() {
         Boolean boolAccurateQuery$value = this.boolAccurateQuery$value;
         if (!this.boolAccurateQuery$set) {
            boolAccurateQuery$value = MesBuildingPackageDOParam.$default$boolAccurateQuery();
         }

         return new MesBuildingPackageDOParam(
            this.packageIds,
            this.projectIds,
            this.projectId,
            this.monomerId,
            this.areaId,
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
            this.boolShip,
            this.projectType,
            this.pageNumber,
            this.pageSize,
            this.sort,
            boolAccurateQuery$value,
            this.monomerName,
            this.productName,
            this.areaBatchName,
            this.warehouseTypeList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPackageDOParam.MesBuildingPackageDOParamBuilder(packageIds="
            + this.packageIds
            + ", projectIds="
            + this.projectIds
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
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
            + ", boolShip="
            + this.boolShip
            + ", projectType="
            + this.projectType
            + ", pageNumber="
            + this.pageNumber
            + ", pageSize="
            + this.pageSize
            + ", sort="
            + this.sort
            + ", boolAccurateQuery$value="
            + this.boolAccurateQuery$value
            + ", monomerName="
            + this.monomerName
            + ", productName="
            + this.productName
            + ", areaBatchName="
            + this.areaBatchName
            + ", warehouseTypeList="
            + this.warehouseTypeList
            + ")";
      }
   }
}
