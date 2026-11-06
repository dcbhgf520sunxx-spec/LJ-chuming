package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "ProduceTeamReportDTO", description = "班组生产上报记录表 ")
public class ProduceTeamReportDO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序表id", notes = "任务工序表id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   private Long taskProcessId;
   @ApiModelProperty(name = "quantity", value = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "inspectionQuantity", value = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "reportType", value = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
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
   private NameInfo areaBatch;
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
   @ApiModelProperty(name = "user", notes = "上报人")
   @JsonProperty("user")
   @JSONField(name = "user")
   private IdAndNameDO user;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "number", notes = "一物一码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "boolOneCode", notes = "一物一码号")
   @JsonProperty("boolOneCode")
   @JSONField(name = "boolOneCode")
   private Boolean boolOneCode;
   @ApiModelProperty(name = "inspectionUserNme", notes = "质检人")
   @JsonProperty("inspectionUserNme")
   @JSONField(name = "inspectionUserNme")
   private String inspectionUserNme;
   @ApiModelProperty(name = "reportUser", notes = "生产上报人")
   @JsonProperty("reportUser")
   @JSONField(name = "reportUser")
   private String reportUser;
   @ApiModelProperty(name = "isReversible", value = "是否被处理 [0 不可撤回, 1 可撤回]", notes = "是否被处理 [0 不可撤回, 1 可撤回]")
   @JsonProperty("isReversible")
   @JSONField(name = "isReversible")
   private Boolean isReversible;
   @ApiModelProperty(name = "markingTime", value = "打标时间", notes = "打标时间")
   @JsonProperty("markingTime")
   @JSONField(name = "markingTime")
   private LocalDateTime markingTime;
   @ApiModelProperty(name = "boolMarked", value = "是否打标", notes = "是否打标")
   @JsonProperty("boolMarked")
   @JSONField(name = "boolMarked")
   private Boolean boolMarked;
   @ApiModelProperty(name = "markedQuantity", value = "打标数量", notes = "打标数量")
   @JsonProperty("markedQuantity")
   @JSONField(name = "markedQuantity")
   private Integer markedQuantity;

   public static ProduceTeamReportDO.ProduceTeamReportDOBuilder builder() {
      return new ProduceTeamReportDO.ProduceTeamReportDOBuilder();
   }

   public ProduceTeamReportDO() {
   }

   public ProduceTeamReportDO(
      final Long id,
      final Long productId,
      final Long taskProcessId,
      final Integer quantity,
      final Integer inspectionQuantity,
      final Integer reportType,
      final String specification,
      final String serialNumber,
      final String productName,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final NameInfo areaBatch,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups,
      final IdAndNameDO process,
      final IdAndNameDO user,
      final Integer taskTypeEnum,
      final Integer number,
      final Boolean boolOneCode,
      final String inspectionUserNme,
      final String reportUser,
      final Boolean isReversible,
      final LocalDateTime markingTime,
      final Boolean boolMarked,
      final Integer markedQuantity
   ) {
      this.id = id;
      this.productId = productId;
      this.taskProcessId = taskProcessId;
      this.quantity = quantity;
      this.inspectionQuantity = inspectionQuantity;
      this.reportType = reportType;
      this.specification = specification;
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
      this.number = number;
      this.boolOneCode = boolOneCode;
      this.inspectionUserNme = inspectionUserNme;
      this.reportUser = reportUser;
      this.isReversible = isReversible;
      this.markingTime = markingTime;
      this.boolMarked = boolMarked;
      this.markedQuantity = markedQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public String getSpecification() {
      return this.specification;
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

   public NameInfo getAreaBatch() {
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

   public Integer getNumber() {
      return this.number;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public String getInspectionUserNme() {
      return this.inspectionUserNme;
   }

   public String getReportUser() {
      return this.reportUser;
   }

   public Boolean getIsReversible() {
      return this.isReversible;
   }

   public LocalDateTime getMarkingTime() {
      return this.markingTime;
   }

   public Boolean getBoolMarked() {
      return this.boolMarked;
   }

   public Integer getMarkedQuantity() {
      return this.markedQuantity;
   }

   @JsonProperty("id")
   public ProduceTeamReportDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public ProduceTeamReportDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public ProduceTeamReportDO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("quantity")
   public ProduceTeamReportDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public ProduceTeamReportDO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("reportType")
   public ProduceTeamReportDO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("specification")
   public ProduceTeamReportDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProduceTeamReportDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("productName")
   public ProduceTeamReportDO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("project")
   public ProduceTeamReportDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public ProduceTeamReportDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public ProduceTeamReportDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("areaBatch")
   public ProduceTeamReportDO setAreaBatch(final NameInfo areaBatch) {
      this.areaBatch = areaBatch;
      return this;
   }

   @JsonProperty("workshop")
   public ProduceTeamReportDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public ProduceTeamReportDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public ProduceTeamReportDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("process")
   public ProduceTeamReportDO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("user")
   public ProduceTeamReportDO setUser(final IdAndNameDO user) {
      this.user = user;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ProduceTeamReportDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("number")
   public ProduceTeamReportDO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("boolOneCode")
   public ProduceTeamReportDO setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   @JsonProperty("inspectionUserNme")
   public ProduceTeamReportDO setInspectionUserNme(final String inspectionUserNme) {
      this.inspectionUserNme = inspectionUserNme;
      return this;
   }

   @JsonProperty("reportUser")
   public ProduceTeamReportDO setReportUser(final String reportUser) {
      this.reportUser = reportUser;
      return this;
   }

   @JsonProperty("isReversible")
   public ProduceTeamReportDO setIsReversible(final Boolean isReversible) {
      this.isReversible = isReversible;
      return this;
   }

   @JsonProperty("markingTime")
   public ProduceTeamReportDO setMarkingTime(final LocalDateTime markingTime) {
      this.markingTime = markingTime;
      return this;
   }

   @JsonProperty("boolMarked")
   public ProduceTeamReportDO setBoolMarked(final Boolean boolMarked) {
      this.boolMarked = boolMarked;
      return this;
   }

   @JsonProperty("markedQuantity")
   public ProduceTeamReportDO setMarkedQuantity(final Integer markedQuantity) {
      this.markedQuantity = markedQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProduceTeamReportDO(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", quantity="
         + this.getQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", reportType="
         + this.getReportType()
         + ", specification="
         + this.getSpecification()
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
         + ", number="
         + this.getNumber()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", inspectionUserNme="
         + this.getInspectionUserNme()
         + ", reportUser="
         + this.getReportUser()
         + ", isReversible="
         + this.getIsReversible()
         + ", markingTime="
         + this.getMarkingTime()
         + ", boolMarked="
         + this.getBoolMarked()
         + ", markedQuantity="
         + this.getMarkedQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceTeamReportDO)) {
         return false;
      }

      ProduceTeamReportDO other = (ProduceTeamReportDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$taskProcessId = this.getTaskProcessId();
            Object other$taskProcessId = other.getTaskProcessId();
            if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$inspectionQuantity = this.getInspectionQuantity();
                  Object other$inspectionQuantity = other.getInspectionQuantity();
                  if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                     Object this$reportType = this.getReportType();
                     Object other$reportType = other.getReportType();
                     if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                        Object this$taskTypeEnum = this.getTaskTypeEnum();
                        Object other$taskTypeEnum = other.getTaskTypeEnum();
                        if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                           Object this$number = this.getNumber();
                           Object other$number = other.getNumber();
                           if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                              Object this$boolOneCode = this.getBoolOneCode();
                              Object other$boolOneCode = other.getBoolOneCode();
                              if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                                 Object this$isReversible = this.getIsReversible();
                                 Object other$isReversible = other.getIsReversible();
                                 if (this$isReversible == null ? other$isReversible == null : this$isReversible.equals(other$isReversible)) {
                                    Object this$boolMarked = this.getBoolMarked();
                                    Object other$boolMarked = other.getBoolMarked();
                                    if (this$boolMarked == null ? other$boolMarked == null : this$boolMarked.equals(other$boolMarked)) {
                                       Object this$markedQuantity = this.getMarkedQuantity();
                                       Object other$markedQuantity = other.getMarkedQuantity();
                                       if (this$markedQuantity == null ? other$markedQuantity == null : this$markedQuantity.equals(other$markedQuantity)) {
                                          Object this$specification = this.getSpecification();
                                          Object other$specification = other.getSpecification();
                                          if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
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
                                                                              Object this$inspectionUserNme = this.getInspectionUserNme();
                                                                              Object other$inspectionUserNme = other.getInspectionUserNme();
                                                                              if (this$inspectionUserNme == null
                                                                                 ? other$inspectionUserNme == null
                                                                                 : this$inspectionUserNme.equals(other$inspectionUserNme)) {
                                                                                 Object this$reportUser = this.getReportUser();
                                                                                 Object other$reportUser = other.getReportUser();
                                                                                 if (this$reportUser == null
                                                                                    ? other$reportUser == null
                                                                                    : this$reportUser.equals(other$reportUser)) {
                                                                                    Object this$markingTime = this.getMarkingTime();
                                                                                    Object other$markingTime = other.getMarkingTime();
                                                                                    return this$markingTime == null
                                                                                       ? other$markingTime == null
                                                                                       : this$markingTime.equals(other$markingTime);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProduceTeamReportDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $isReversible = this.getIsReversible();
      result = result * 59 + ($isReversible == null ? 43 : $isReversible.hashCode());
      Object $boolMarked = this.getBoolMarked();
      result = result * 59 + ($boolMarked == null ? 43 : $boolMarked.hashCode());
      Object $markedQuantity = this.getMarkedQuantity();
      result = result * 59 + ($markedQuantity == null ? 43 : $markedQuantity.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
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
      Object $inspectionUserNme = this.getInspectionUserNme();
      result = result * 59 + ($inspectionUserNme == null ? 43 : $inspectionUserNme.hashCode());
      Object $reportUser = this.getReportUser();
      result = result * 59 + ($reportUser == null ? 43 : $reportUser.hashCode());
      Object $markingTime = this.getMarkingTime();
      return result * 59 + ($markingTime == null ? 43 : $markingTime.hashCode());
   }

   public static class ProduceTeamReportDOBuilder {
      private Long id;
      private Long productId;
      private Long taskProcessId;
      private Integer quantity;
      private Integer inspectionQuantity;
      private Integer reportType;
      private String specification;
      private String serialNumber;
      private String productName;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private NameInfo areaBatch;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private IdAndNameDO process;
      private IdAndNameDO user;
      private Integer taskTypeEnum;
      private Integer number;
      private Boolean boolOneCode;
      private String inspectionUserNme;
      private String reportUser;
      private Boolean isReversible;
      private LocalDateTime markingTime;
      private Boolean boolMarked;
      private Integer markedQuantity;

      ProduceTeamReportDOBuilder() {
      }

      @JsonProperty("id")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("quantity")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("reportType")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("specification")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("productName")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("project")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("areaBatch")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder areaBatch(final NameInfo areaBatch) {
         this.areaBatch = areaBatch;
         return this;
      }

      @JsonProperty("workshop")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("process")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("user")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder user(final IdAndNameDO user) {
         this.user = user;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("number")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("boolOneCode")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      @JsonProperty("inspectionUserNme")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder inspectionUserNme(final String inspectionUserNme) {
         this.inspectionUserNme = inspectionUserNme;
         return this;
      }

      @JsonProperty("reportUser")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder reportUser(final String reportUser) {
         this.reportUser = reportUser;
         return this;
      }

      @JsonProperty("isReversible")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder isReversible(final Boolean isReversible) {
         this.isReversible = isReversible;
         return this;
      }

      @JsonProperty("markingTime")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder markingTime(final LocalDateTime markingTime) {
         this.markingTime = markingTime;
         return this;
      }

      @JsonProperty("boolMarked")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder boolMarked(final Boolean boolMarked) {
         this.boolMarked = boolMarked;
         return this;
      }

      @JsonProperty("markedQuantity")
      public ProduceTeamReportDO.ProduceTeamReportDOBuilder markedQuantity(final Integer markedQuantity) {
         this.markedQuantity = markedQuantity;
         return this;
      }

      public ProduceTeamReportDO build() {
         return new ProduceTeamReportDO(
            this.id,
            this.productId,
            this.taskProcessId,
            this.quantity,
            this.inspectionQuantity,
            this.reportType,
            this.specification,
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
            this.number,
            this.boolOneCode,
            this.inspectionUserNme,
            this.reportUser,
            this.isReversible,
            this.markingTime,
            this.boolMarked,
            this.markedQuantity
         );
      }

      @Override
      public String toString() {
         return "ProduceTeamReportDO.ProduceTeamReportDOBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", taskProcessId="
            + this.taskProcessId
            + ", quantity="
            + this.quantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", reportType="
            + this.reportType
            + ", specification="
            + this.specification
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
            + ", number="
            + this.number
            + ", boolOneCode="
            + this.boolOneCode
            + ", inspectionUserNme="
            + this.inspectionUserNme
            + ", reportUser="
            + this.reportUser
            + ", isReversible="
            + this.isReversible
            + ", markingTime="
            + this.markingTime
            + ", boolMarked="
            + this.boolMarked
            + ", markedQuantity="
            + this.markedQuantity
            + ")";
      }
   }
}
