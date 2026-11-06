package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
public class ProjectProductionKanBanDetailDTO {
   @ApiModelProperty(name = "taskProcessId", notes = "工序任务Id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   private Long taskProcessId;
   @ApiModelProperty(name = "productId", notes = "产品Id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "assistId", notes = "协同Id")
   @JsonProperty("assistId")
   @JSONField(name = "assistId")
   private Long assistId;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "processId", notes = "工序Id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "classId", notes = "产品类型Id")
   @JsonProperty("classId")
   @JSONField(name = "classId")
   private Long classId;
   @ApiModelProperty(name = "taskId", notes = "任务Id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "partId", notes = "零件Id")
   @JsonProperty("partId")
   @JSONField(name = "partId")
   private Long partId;
   @ApiModelProperty(name = "name", notes = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "productionLineName", notes = "生产线名称")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "workShopName", notes = "车间名称")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "processName", notes = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "configName", notes = "切割方式")
   @JsonProperty("configName")
   @JSONField(name = "configName")
   private String configName;
   @ApiModelProperty(name = "teamUserName", notes = "班组长名称")
   @JsonProperty("teamUserName")
   @JSONField(name = "teamUserName")
   private String teamUserName;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "companyQuantity", notes = "完成数量")
   @JsonProperty("companyQuantity")
   @JSONField(name = "companyQuantity")
   private Integer companyQuantity;
   @ApiModelProperty(name = "boolAssist", notes = "是否协同")
   @JsonProperty("boolAssist")
   @JSONField(name = "boolAssist")
   private Boolean boolAssist;
   @ApiModelProperty(name = "inspectionUserName", notes = "质检人,多个以逗号分隔")
   @JsonProperty("inspectionUserName")
   @JSONField(name = "inspectionUserName")
   private String inspectionUserName;

   public static ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder builder() {
      return new ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder();
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getAssistId() {
      return this.assistId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getClassId() {
      return this.classId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getPartId() {
      return this.partId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getConfigName() {
      return this.configName;
   }

   public String getTeamUserName() {
      return this.teamUserName;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompanyQuantity() {
      return this.companyQuantity;
   }

   public Boolean getBoolAssist() {
      return this.boolAssist;
   }

   public String getInspectionUserName() {
      return this.inspectionUserName;
   }

   @JsonProperty("taskProcessId")
   public void setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
   }

   @JsonProperty("productId")
   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   @JsonProperty("assistId")
   public void setAssistId(final Long assistId) {
      this.assistId = assistId;
   }

   @JsonProperty("teamId")
   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   @JsonProperty("processId")
   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   @JsonProperty("classId")
   public void setClassId(final Long classId) {
      this.classId = classId;
   }

   @JsonProperty("taskId")
   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   @JsonProperty("partId")
   public void setPartId(final Long partId) {
      this.partId = partId;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("productionLineName")
   public void setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
   }

   @JsonProperty("workShopName")
   public void setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("configName")
   public void setConfigName(final String configName) {
      this.configName = configName;
   }

   @JsonProperty("teamUserName")
   public void setTeamUserName(final String teamUserName) {
      this.teamUserName = teamUserName;
   }

   @JsonProperty("orderNumber")
   public void setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
   }

   @JsonProperty("taskQuantity")
   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   @JsonProperty("companyQuantity")
   public void setCompanyQuantity(final Integer companyQuantity) {
      this.companyQuantity = companyQuantity;
   }

   @JsonProperty("boolAssist")
   public void setBoolAssist(final Boolean boolAssist) {
      this.boolAssist = boolAssist;
   }

   @JsonProperty("inspectionUserName")
   public void setInspectionUserName(final String inspectionUserName) {
      this.inspectionUserName = inspectionUserName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionKanBanDetailDTO)) {
         return false;
      }

      ProjectProductionKanBanDetailDTO other = (ProjectProductionKanBanDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskProcessId = this.getTaskProcessId();
      Object other$taskProcessId = other.getTaskProcessId();
      if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$assistId = this.getAssistId();
            Object other$assistId = other.getAssistId();
            if (this$assistId == null ? other$assistId == null : this$assistId.equals(other$assistId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$classId = this.getClassId();
                     Object other$classId = other.getClassId();
                     if (this$classId == null ? other$classId == null : this$classId.equals(other$classId)) {
                        Object this$taskId = this.getTaskId();
                        Object other$taskId = other.getTaskId();
                        if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                           Object this$partId = this.getPartId();
                           Object other$partId = other.getPartId();
                           if (this$partId == null ? other$partId == null : this$partId.equals(other$partId)) {
                              Object this$taskQuantity = this.getTaskQuantity();
                              Object other$taskQuantity = other.getTaskQuantity();
                              if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                                 Object this$companyQuantity = this.getCompanyQuantity();
                                 Object other$companyQuantity = other.getCompanyQuantity();
                                 if (this$companyQuantity == null ? other$companyQuantity == null : this$companyQuantity.equals(other$companyQuantity)) {
                                    Object this$boolAssist = this.getBoolAssist();
                                    Object other$boolAssist = other.getBoolAssist();
                                    if (this$boolAssist == null ? other$boolAssist == null : this$boolAssist.equals(other$boolAssist)) {
                                       Object this$name = this.getName();
                                       Object other$name = other.getName();
                                       if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$productionLineName = this.getProductionLineName();
                                                Object other$productionLineName = other.getProductionLineName();
                                                if (this$productionLineName == null
                                                   ? other$productionLineName == null
                                                   : this$productionLineName.equals(other$productionLineName)) {
                                                   Object this$workShopName = this.getWorkShopName();
                                                   Object other$workShopName = other.getWorkShopName();
                                                   if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
                                                      Object this$processName = this.getProcessName();
                                                      Object other$processName = other.getProcessName();
                                                      if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                                         Object this$configName = this.getConfigName();
                                                         Object other$configName = other.getConfigName();
                                                         if (this$configName == null ? other$configName == null : this$configName.equals(other$configName)) {
                                                            Object this$teamUserName = this.getTeamUserName();
                                                            Object other$teamUserName = other.getTeamUserName();
                                                            if (this$teamUserName == null
                                                               ? other$teamUserName == null
                                                               : this$teamUserName.equals(other$teamUserName)) {
                                                               Object this$orderNumber = this.getOrderNumber();
                                                               Object other$orderNumber = other.getOrderNumber();
                                                               if (this$orderNumber == null
                                                                  ? other$orderNumber == null
                                                                  : this$orderNumber.equals(other$orderNumber)) {
                                                                  Object this$inspectionUserName = this.getInspectionUserName();
                                                                  Object other$inspectionUserName = other.getInspectionUserName();
                                                                  return this$inspectionUserName == null
                                                                     ? other$inspectionUserName == null
                                                                     : this$inspectionUserName.equals(other$inspectionUserName);
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
      return other instanceof ProjectProductionKanBanDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $assistId = this.getAssistId();
      result = result * 59 + ($assistId == null ? 43 : $assistId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $classId = this.getClassId();
      result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $partId = this.getPartId();
      result = result * 59 + ($partId == null ? 43 : $partId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $companyQuantity = this.getCompanyQuantity();
      result = result * 59 + ($companyQuantity == null ? 43 : $companyQuantity.hashCode());
      Object $boolAssist = this.getBoolAssist();
      result = result * 59 + ($boolAssist == null ? 43 : $boolAssist.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $configName = this.getConfigName();
      result = result * 59 + ($configName == null ? 43 : $configName.hashCode());
      Object $teamUserName = this.getTeamUserName();
      result = result * 59 + ($teamUserName == null ? 43 : $teamUserName.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $inspectionUserName = this.getInspectionUserName();
      return result * 59 + ($inspectionUserName == null ? 43 : $inspectionUserName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductionKanBanDetailDTO(taskProcessId="
         + this.getTaskProcessId()
         + ", productId="
         + this.getProductId()
         + ", assistId="
         + this.getAssistId()
         + ", teamId="
         + this.getTeamId()
         + ", processId="
         + this.getProcessId()
         + ", classId="
         + this.getClassId()
         + ", taskId="
         + this.getTaskId()
         + ", partId="
         + this.getPartId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", workShopName="
         + this.getWorkShopName()
         + ", processName="
         + this.getProcessName()
         + ", configName="
         + this.getConfigName()
         + ", teamUserName="
         + this.getTeamUserName()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", companyQuantity="
         + this.getCompanyQuantity()
         + ", boolAssist="
         + this.getBoolAssist()
         + ", inspectionUserName="
         + this.getInspectionUserName()
         + ")";
   }

   public ProjectProductionKanBanDetailDTO() {
   }

   public ProjectProductionKanBanDetailDTO(
      final Long taskProcessId,
      final Long productId,
      final Long assistId,
      final Long teamId,
      final Long processId,
      final Long classId,
      final Long taskId,
      final Long partId,
      final String name,
      final String serialNumber,
      final String specification,
      final String productionLineName,
      final String workShopName,
      final String processName,
      final String configName,
      final String teamUserName,
      final String orderNumber,
      final Integer taskQuantity,
      final Integer companyQuantity,
      final Boolean boolAssist,
      final String inspectionUserName
   ) {
      this.taskProcessId = taskProcessId;
      this.productId = productId;
      this.assistId = assistId;
      this.teamId = teamId;
      this.processId = processId;
      this.classId = classId;
      this.taskId = taskId;
      this.partId = partId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.productionLineName = productionLineName;
      this.workShopName = workShopName;
      this.processName = processName;
      this.configName = configName;
      this.teamUserName = teamUserName;
      this.orderNumber = orderNumber;
      this.taskQuantity = taskQuantity;
      this.companyQuantity = companyQuantity;
      this.boolAssist = boolAssist;
      this.inspectionUserName = inspectionUserName;
   }

   public static class ProjectProductionKanBanDetailDTOBuilder {
      private Long taskProcessId;
      private Long productId;
      private Long assistId;
      private Long teamId;
      private Long processId;
      private Long classId;
      private Long taskId;
      private Long partId;
      private String name;
      private String serialNumber;
      private String specification;
      private String productionLineName;
      private String workShopName;
      private String processName;
      private String configName;
      private String teamUserName;
      private String orderNumber;
      private Integer taskQuantity;
      private Integer companyQuantity;
      private Boolean boolAssist;
      private String inspectionUserName;

      ProjectProductionKanBanDetailDTOBuilder() {
      }

      @JsonProperty("taskProcessId")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("productId")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("assistId")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder assistId(final Long assistId) {
         this.assistId = assistId;
         return this;
      }

      @JsonProperty("teamId")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("processId")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("classId")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder classId(final Long classId) {
         this.classId = classId;
         return this;
      }

      @JsonProperty("taskId")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("partId")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder partId(final Long partId) {
         this.partId = partId;
         return this;
      }

      @JsonProperty("name")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("productionLineName")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("workShopName")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder workShopName(final String workShopName) {
         this.workShopName = workShopName;
         return this;
      }

      @JsonProperty("processName")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("configName")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder configName(final String configName) {
         this.configName = configName;
         return this;
      }

      @JsonProperty("teamUserName")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder teamUserName(final String teamUserName) {
         this.teamUserName = teamUserName;
         return this;
      }

      @JsonProperty("orderNumber")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("taskQuantity")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("companyQuantity")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder companyQuantity(final Integer companyQuantity) {
         this.companyQuantity = companyQuantity;
         return this;
      }

      @JsonProperty("boolAssist")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder boolAssist(final Boolean boolAssist) {
         this.boolAssist = boolAssist;
         return this;
      }

      @JsonProperty("inspectionUserName")
      public ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder inspectionUserName(final String inspectionUserName) {
         this.inspectionUserName = inspectionUserName;
         return this;
      }

      public ProjectProductionKanBanDetailDTO build() {
         return new ProjectProductionKanBanDetailDTO(
            this.taskProcessId,
            this.productId,
            this.assistId,
            this.teamId,
            this.processId,
            this.classId,
            this.taskId,
            this.partId,
            this.name,
            this.serialNumber,
            this.specification,
            this.productionLineName,
            this.workShopName,
            this.processName,
            this.configName,
            this.teamUserName,
            this.orderNumber,
            this.taskQuantity,
            this.companyQuantity,
            this.boolAssist,
            this.inspectionUserName
         );
      }

      @Override
      public String toString() {
         return "ProjectProductionKanBanDetailDTO.ProjectProductionKanBanDetailDTOBuilder(taskProcessId="
            + this.taskProcessId
            + ", productId="
            + this.productId
            + ", assistId="
            + this.assistId
            + ", teamId="
            + this.teamId
            + ", processId="
            + this.processId
            + ", classId="
            + this.classId
            + ", taskId="
            + this.taskId
            + ", partId="
            + this.partId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", productionLineName="
            + this.productionLineName
            + ", workShopName="
            + this.workShopName
            + ", processName="
            + this.processName
            + ", configName="
            + this.configName
            + ", teamUserName="
            + this.teamUserName
            + ", orderNumber="
            + this.orderNumber
            + ", taskQuantity="
            + this.taskQuantity
            + ", companyQuantity="
            + this.companyQuantity
            + ", boolAssist="
            + this.boolAssist
            + ", inspectionUserName="
            + this.inspectionUserName
            + ")";
      }
   }
}
