package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProduceTeamReportDTO", description = "班组生产上报记录表 ")
public class ProduceInspectionTeamReportDO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "taskId", value = "任务Id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "productId", value = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "inspectionQuantity", value = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "boolAdoptEnum", value = "是否通过质检")
   @JsonProperty("boolAdoptEnum")
   @JSONField(name = "boolAdoptEnum")
   private Boolean boolAdoptEnum;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "productName", notes = "产品名称")
   @JsonProperty("productName")
   @JSONField(name = "productName")
   private String productName;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "areaBatch", notes = "批次")
   @JsonProperty("areaBatch")
   @JSONField(name = "areaBatch")
   private AreaDetailDO areaBatch;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "user", notes = "质检上报人")
   @JsonProperty("user")
   @JSONField(name = "user")
   private IdAndNameDO user;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "inspectReportNumber", notes = "上报次数")
   @JsonProperty("inspectReportNumber")
   @JSONField(name = "inspectReportNumber")
   private Long inspectReportNumber;
   @ApiModelProperty(name = "boolOneCode", notes = "任务是否一物一码")
   @JsonProperty("boolOneCode")
   @JSONField(name = "boolOneCode")
   private Boolean boolOneCode;
   @ApiModelProperty(name = "number", notes = "码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "reportUser", notes = "生产上报人")
   @JsonProperty("reportUser")
   @JSONField(name = "reportUser")
   private String reportUser;
   @ApiModelProperty(name = "inspectionUserNme", notes = "质检人")
   @JsonProperty("inspectionUserNme")
   @JSONField(name = "inspectionUserNme")
   private String inspectionUserNme;

   public static ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder builder() {
      return new ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder();
   }

   public ProduceInspectionTeamReportDO() {
   }

   public ProduceInspectionTeamReportDO(
      final Long id,
      final Long taskId,
      final Long productId,
      final Integer inspectionQuantity,
      final Boolean boolAdoptEnum,
      final String serialNumber,
      final String productName,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final AreaDetailDO areaBatch,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups,
      final IdAndNameDO process,
      final IdAndNameDO user,
      final Integer taskTypeEnum,
      final Long inspectReportNumber,
      final Boolean boolOneCode,
      final Integer number,
      final String reportUser,
      final String inspectionUserNme
   ) {
      this.id = id;
      this.taskId = taskId;
      this.productId = productId;
      this.inspectionQuantity = inspectionQuantity;
      this.boolAdoptEnum = boolAdoptEnum;
      this.serialNumber = serialNumber;
      this.productName = productName;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.areaBatch = areaBatch;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.process = process;
      this.user = user;
      this.taskTypeEnum = taskTypeEnum;
      this.inspectReportNumber = inspectReportNumber;
      this.boolOneCode = boolOneCode;
      this.number = number;
      this.reportUser = reportUser;
      this.inspectionUserNme = inspectionUserNme;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Boolean getBoolAdoptEnum() {
      return this.boolAdoptEnum;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProductName() {
      return this.productName;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public AreaDetailDO getAreaBatch() {
      return this.areaBatch;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public IdAndNameDO getUser() {
      return this.user;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Long getInspectReportNumber() {
      return this.inspectReportNumber;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public Integer getNumber() {
      return this.number;
   }

   public String getReportUser() {
      return this.reportUser;
   }

   public String getInspectionUserNme() {
      return this.inspectionUserNme;
   }

   @JsonProperty("id")
   public ProduceInspectionTeamReportDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public ProduceInspectionTeamReportDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("productId")
   public ProduceInspectionTeamReportDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public ProduceInspectionTeamReportDO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("boolAdoptEnum")
   public ProduceInspectionTeamReportDO setBoolAdoptEnum(final Boolean boolAdoptEnum) {
      this.boolAdoptEnum = boolAdoptEnum;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProduceInspectionTeamReportDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("productName")
   public ProduceInspectionTeamReportDO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("project")
   public ProduceInspectionTeamReportDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public ProduceInspectionTeamReportDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public ProduceInspectionTeamReportDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("areaBatch")
   public ProduceInspectionTeamReportDO setAreaBatch(final AreaDetailDO areaBatch) {
      this.areaBatch = areaBatch;
      return this;
   }

   @JsonProperty("workshop")
   public ProduceInspectionTeamReportDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public ProduceInspectionTeamReportDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public ProduceInspectionTeamReportDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("process")
   public ProduceInspectionTeamReportDO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("user")
   public ProduceInspectionTeamReportDO setUser(final IdAndNameDO user) {
      this.user = user;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ProduceInspectionTeamReportDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("inspectReportNumber")
   public ProduceInspectionTeamReportDO setInspectReportNumber(final Long inspectReportNumber) {
      this.inspectReportNumber = inspectReportNumber;
      return this;
   }

   @JsonProperty("boolOneCode")
   public ProduceInspectionTeamReportDO setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   @JsonProperty("number")
   public ProduceInspectionTeamReportDO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("reportUser")
   public ProduceInspectionTeamReportDO setReportUser(final String reportUser) {
      this.reportUser = reportUser;
      return this;
   }

   @JsonProperty("inspectionUserNme")
   public ProduceInspectionTeamReportDO setInspectionUserNme(final String inspectionUserNme) {
      this.inspectionUserNme = inspectionUserNme;
      return this;
   }

   @Override
   public String toString() {
      return "ProduceInspectionTeamReportDO(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", productId="
         + this.getProductId()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", boolAdoptEnum="
         + this.getBoolAdoptEnum()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productName="
         + this.getProductName()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", process="
         + this.getProcess()
         + ", user="
         + this.getUser()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", inspectReportNumber="
         + this.getInspectReportNumber()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", number="
         + this.getNumber()
         + ", reportUser="
         + this.getReportUser()
         + ", inspectionUserNme="
         + this.getInspectionUserNme()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceInspectionTeamReportDO)) {
         return false;
      }

      ProduceInspectionTeamReportDO other = (ProduceInspectionTeamReportDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$inspectionQuantity = this.getInspectionQuantity();
               Object other$inspectionQuantity = other.getInspectionQuantity();
               if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                  Object this$boolAdoptEnum = this.getBoolAdoptEnum();
                  Object other$boolAdoptEnum = other.getBoolAdoptEnum();
                  if (this$boolAdoptEnum == null ? other$boolAdoptEnum == null : this$boolAdoptEnum.equals(other$boolAdoptEnum)) {
                     Object this$taskTypeEnum = this.getTaskTypeEnum();
                     Object other$taskTypeEnum = other.getTaskTypeEnum();
                     if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                        Object this$inspectReportNumber = this.getInspectReportNumber();
                        Object other$inspectReportNumber = other.getInspectReportNumber();
                        if (this$inspectReportNumber == null ? other$inspectReportNumber == null : this$inspectReportNumber.equals(other$inspectReportNumber)) {
                           Object this$boolOneCode = this.getBoolOneCode();
                           Object other$boolOneCode = other.getBoolOneCode();
                           if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                              Object this$number = this.getNumber();
                              Object other$number = other.getNumber();
                              if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$productName = this.getProductName();
                                    Object other$productName = other.getProductName();
                                    if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                                       Object this$project = this.getProject();
                                       Object other$project = other.getProject();
                                       if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                          Object this$monomer = this.getMonomer();
                                          Object other$monomer = other.getMonomer();
                                          if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                             Object this$area = this.getArea();
                                             Object other$area = other.getArea();
                                             if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                Object this$areaBatch = this.getAreaBatch();
                                                Object other$areaBatch = other.getAreaBatch();
                                                if (this$areaBatch == null ? other$areaBatch == null : this$areaBatch.equals(other$areaBatch)) {
                                                   Object this$workshop = this.getWorkshop();
                                                   Object other$workshop = other.getWorkshop();
                                                   if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                      Object this$productionLine = this.getProductionLine();
                                                      Object other$productionLine = other.getProductionLine();
                                                      if (this$productionLine == null
                                                         ? other$productionLine == null
                                                         : this$productionLine.equals(other$productionLine)) {
                                                         Object this$groups = this.getGroups();
                                                         Object other$groups = other.getGroups();
                                                         if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                                                            Object this$process = this.getProcess();
                                                            Object other$process = other.getProcess();
                                                            if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                                               Object this$user = this.getUser();
                                                               Object other$user = other.getUser();
                                                               if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                                                                  Object this$reportUser = this.getReportUser();
                                                                  Object other$reportUser = other.getReportUser();
                                                                  if (this$reportUser == null
                                                                     ? other$reportUser == null
                                                                     : this$reportUser.equals(other$reportUser)) {
                                                                     Object this$inspectionUserNme = this.getInspectionUserNme();
                                                                     Object other$inspectionUserNme = other.getInspectionUserNme();
                                                                     return this$inspectionUserNme == null
                                                                        ? other$inspectionUserNme == null
                                                                        : this$inspectionUserNme.equals(other$inspectionUserNme);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProduceInspectionTeamReportDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $boolAdoptEnum = this.getBoolAdoptEnum();
      result = result * 59 + ($boolAdoptEnum == null ? 43 : $boolAdoptEnum.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $inspectReportNumber = this.getInspectReportNumber();
      result = result * 59 + ($inspectReportNumber == null ? 43 : $inspectReportNumber.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $reportUser = this.getReportUser();
      result = result * 59 + ($reportUser == null ? 43 : $reportUser.hashCode());
      Object $inspectionUserNme = this.getInspectionUserNme();
      return result * 59 + ($inspectionUserNme == null ? 43 : $inspectionUserNme.hashCode());
   }

   public static class ProduceInspectionTeamReportDOBuilder {
      private Long id;
      private Long taskId;
      private Long productId;
      private Integer inspectionQuantity;
      private Boolean boolAdoptEnum;
      private String serialNumber;
      private String productName;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private AreaDetailDO areaBatch;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private IdAndNameDO process;
      private IdAndNameDO user;
      private Integer taskTypeEnum;
      private Long inspectReportNumber;
      private Boolean boolOneCode;
      private Integer number;
      private String reportUser;
      private String inspectionUserNme;

      ProduceInspectionTeamReportDOBuilder() {
      }

      @JsonProperty("id")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("productId")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("boolAdoptEnum")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder boolAdoptEnum(final Boolean boolAdoptEnum) {
         this.boolAdoptEnum = boolAdoptEnum;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("productName")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("project")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("areaBatch")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder areaBatch(final AreaDetailDO areaBatch) {
         this.areaBatch = areaBatch;
         return this;
      }

      @JsonProperty("workshop")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("process")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("user")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder user(final IdAndNameDO user) {
         this.user = user;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("inspectReportNumber")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder inspectReportNumber(final Long inspectReportNumber) {
         this.inspectReportNumber = inspectReportNumber;
         return this;
      }

      @JsonProperty("boolOneCode")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      @JsonProperty("number")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("reportUser")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder reportUser(final String reportUser) {
         this.reportUser = reportUser;
         return this;
      }

      @JsonProperty("inspectionUserNme")
      public ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder inspectionUserNme(final String inspectionUserNme) {
         this.inspectionUserNme = inspectionUserNme;
         return this;
      }

      public ProduceInspectionTeamReportDO build() {
         return new ProduceInspectionTeamReportDO(
            this.id,
            this.taskId,
            this.productId,
            this.inspectionQuantity,
            this.boolAdoptEnum,
            this.serialNumber,
            this.productName,
            this.project,
            this.monomer,
            this.area,
            this.areaBatch,
            this.workshop,
            this.productionLine,
            this.groups,
            this.process,
            this.user,
            this.taskTypeEnum,
            this.inspectReportNumber,
            this.boolOneCode,
            this.number,
            this.reportUser,
            this.inspectionUserNme
         );
      }

      @Override
      public String toString() {
         return "ProduceInspectionTeamReportDO.ProduceInspectionTeamReportDOBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", productId="
            + this.productId
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", boolAdoptEnum="
            + this.boolAdoptEnum
            + ", serialNumber="
            + this.serialNumber
            + ", productName="
            + this.productName
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", areaBatch="
            + this.areaBatch
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", process="
            + this.process
            + ", user="
            + this.user
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", inspectReportNumber="
            + this.inspectReportNumber
            + ", boolOneCode="
            + this.boolOneCode
            + ", number="
            + this.number
            + ", reportUser="
            + this.reportUser
            + ", inspectionUserNme="
            + this.inspectionUserNme
            + ")";
      }
   }
}
