package com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

public class ProjectProductionTaskDOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "项目Id不能为空!")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaIdList", value = "区域Id")
   private List<Long> areaIdList;
   @ApiModelProperty(name = "processId", value = "工序Id")
   private Long processId;
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "workShopId", value = "车间Id")
   private Long workShopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线Id", notes = "生产线Id")
   private Long productionLineId;
   @ApiModelProperty(name = "teamId", value = "班组Id", notes = "班组Id")
   private Long teamId;
   @ApiModelProperty(name = "boolCompany", value = "是否完成", notes = "是否完成")
   private Boolean boolCompany;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "产品规格", notes = "产品规格")
   private String specification;
   @ApiModelProperty(name = "dateTimeList", value = "任务创建时间范围", notes = "任务创建时间范围")
   private List<LocalDateTime> dateTimeList;
   @ApiModelProperty("是否精确查询")
   private Boolean boolAccurateQuery;
   @ApiModelProperty("页码")
   private Integer pageNumber;
   @ApiModelProperty("页大小")
   private Integer pageSize;

   private static Boolean $default$boolAccurateQuery() {
      return Boolean.FALSE;
   }

   private static Integer $default$pageNumber() {
      return 1;
   }

   private static Integer $default$pageSize() {
      return 20;
   }

   public static ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder builder() {
      return new ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public List<Long> getAreaIdList() {
      return this.areaIdList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Boolean getBoolCompany() {
      return this.boolCompany;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public List<LocalDateTime> getDateTimeList() {
      return this.dateTimeList;
   }

   public Boolean getBoolAccurateQuery() {
      return this.boolAccurateQuery;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaIdList(final List<Long> areaIdList) {
      this.areaIdList = areaIdList;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   public void setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setBoolCompany(final Boolean boolCompany) {
      this.boolCompany = boolCompany;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setDateTimeList(final List<LocalDateTime> dateTimeList) {
      this.dateTimeList = dateTimeList;
   }

   public void setBoolAccurateQuery(final Boolean boolAccurateQuery) {
      this.boolAccurateQuery = boolAccurateQuery;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionTaskDOParam)) {
         return false;
      }

      ProjectProductionTaskDOParam other = (ProjectProductionTaskDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$workShopId = this.getWorkShopId();
                  Object other$workShopId = other.getWorkShopId();
                  if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
                     Object this$productionLineId = this.getProductionLineId();
                     Object other$productionLineId = other.getProductionLineId();
                     if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                        Object this$teamId = this.getTeamId();
                        Object other$teamId = other.getTeamId();
                        if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                           Object this$boolCompany = this.getBoolCompany();
                           Object other$boolCompany = other.getBoolCompany();
                           if (this$boolCompany == null ? other$boolCompany == null : this$boolCompany.equals(other$boolCompany)) {
                              Object this$boolAccurateQuery = this.getBoolAccurateQuery();
                              Object other$boolAccurateQuery = other.getBoolAccurateQuery();
                              if (this$boolAccurateQuery == null ? other$boolAccurateQuery == null : this$boolAccurateQuery.equals(other$boolAccurateQuery)) {
                                 Object this$pageNumber = this.getPageNumber();
                                 Object other$pageNumber = other.getPageNumber();
                                 if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                                    Object this$pageSize = this.getPageSize();
                                    Object other$pageSize = other.getPageSize();
                                    if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                                       Object this$areaIdList = this.getAreaIdList();
                                       Object other$areaIdList = other.getAreaIdList();
                                       if (this$areaIdList == null ? other$areaIdList == null : this$areaIdList.equals(other$areaIdList)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$dateTimeList = this.getDateTimeList();
                                                Object other$dateTimeList = other.getDateTimeList();
                                                return this$dateTimeList == null ? other$dateTimeList == null : this$dateTimeList.equals(other$dateTimeList);
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
      return other instanceof ProjectProductionTaskDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $boolCompany = this.getBoolCompany();
      result = result * 59 + ($boolCompany == null ? 43 : $boolCompany.hashCode());
      Object $boolAccurateQuery = this.getBoolAccurateQuery();
      result = result * 59 + ($boolAccurateQuery == null ? 43 : $boolAccurateQuery.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $areaIdList = this.getAreaIdList();
      result = result * 59 + ($areaIdList == null ? 43 : $areaIdList.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $dateTimeList = this.getDateTimeList();
      return result * 59 + ($dateTimeList == null ? 43 : $dateTimeList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductionTaskDOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaIdList="
         + this.getAreaIdList()
         + ", processId="
         + this.getProcessId()
         + ", productType="
         + this.getProductType()
         + ", workShopId="
         + this.getWorkShopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
         + ", boolCompany="
         + this.getBoolCompany()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", dateTimeList="
         + this.getDateTimeList()
         + ", boolAccurateQuery="
         + this.getBoolAccurateQuery()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ")";
   }

   public ProjectProductionTaskDOParam() {
      this.boolAccurateQuery = $default$boolAccurateQuery();
      this.pageNumber = $default$pageNumber();
      this.pageSize = $default$pageSize();
   }

   public ProjectProductionTaskDOParam(
      final Long projectId,
      final Long monomerId,
      final List<Long> areaIdList,
      final Long processId,
      final Integer productType,
      final Long workShopId,
      final Long productionLineId,
      final Long teamId,
      final Boolean boolCompany,
      final String serialNumber,
      final String specification,
      final List<LocalDateTime> dateTimeList,
      final Boolean boolAccurateQuery,
      final Integer pageNumber,
      final Integer pageSize
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaIdList = areaIdList;
      this.processId = processId;
      this.productType = productType;
      this.workShopId = workShopId;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
      this.boolCompany = boolCompany;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.dateTimeList = dateTimeList;
      this.boolAccurateQuery = boolAccurateQuery;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
   }

   public static class ProjectProductionTaskDOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private List<Long> areaIdList;
      private Long processId;
      private Integer productType;
      private Long workShopId;
      private Long productionLineId;
      private Long teamId;
      private Boolean boolCompany;
      private String serialNumber;
      private String specification;
      private List<LocalDateTime> dateTimeList;
      private boolean boolAccurateQuery$set;
      private Boolean boolAccurateQuery$value;
      private boolean pageNumber$set;
      private Integer pageNumber$value;
      private boolean pageSize$set;
      private Integer pageSize$value;

      ProjectProductionTaskDOParamBuilder() {
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder areaIdList(final List<Long> areaIdList) {
         this.areaIdList = areaIdList;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder boolCompany(final Boolean boolCompany) {
         this.boolCompany = boolCompany;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder dateTimeList(final List<LocalDateTime> dateTimeList) {
         this.dateTimeList = dateTimeList;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder boolAccurateQuery(final Boolean boolAccurateQuery) {
         this.boolAccurateQuery$value = boolAccurateQuery;
         this.boolAccurateQuery$set = true;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder pageNumber(final Integer pageNumber) {
         this.pageNumber$value = pageNumber;
         this.pageNumber$set = true;
         return this;
      }

      public ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder pageSize(final Integer pageSize) {
         this.pageSize$value = pageSize;
         this.pageSize$set = true;
         return this;
      }

      public ProjectProductionTaskDOParam build() {
         Boolean boolAccurateQuery$value = this.boolAccurateQuery$value;
         if (!this.boolAccurateQuery$set) {
            boolAccurateQuery$value = ProjectProductionTaskDOParam.$default$boolAccurateQuery();
         }

         Integer pageNumber$value = this.pageNumber$value;
         if (!this.pageNumber$set) {
            pageNumber$value = ProjectProductionTaskDOParam.$default$pageNumber();
         }

         Integer pageSize$value = this.pageSize$value;
         if (!this.pageSize$set) {
            pageSize$value = ProjectProductionTaskDOParam.$default$pageSize();
         }

         return new ProjectProductionTaskDOParam(
            this.projectId,
            this.monomerId,
            this.areaIdList,
            this.processId,
            this.productType,
            this.workShopId,
            this.productionLineId,
            this.teamId,
            this.boolCompany,
            this.serialNumber,
            this.specification,
            this.dateTimeList,
            boolAccurateQuery$value,
            pageNumber$value,
            pageSize$value
         );
      }

      @Override
      public String toString() {
         return "ProjectProductionTaskDOParam.ProjectProductionTaskDOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaIdList="
            + this.areaIdList
            + ", processId="
            + this.processId
            + ", productType="
            + this.productType
            + ", workShopId="
            + this.workShopId
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
            + ", boolCompany="
            + this.boolCompany
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", dateTimeList="
            + this.dateTimeList
            + ", boolAccurateQuery$value="
            + this.boolAccurateQuery$value
            + ", pageNumber$value="
            + this.pageNumber$value
            + ", pageSize$value="
            + this.pageSize$value
            + ")";
      }
   }
}
