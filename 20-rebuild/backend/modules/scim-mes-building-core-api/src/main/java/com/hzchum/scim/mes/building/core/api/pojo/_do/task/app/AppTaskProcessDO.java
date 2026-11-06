package com.hzchum.scim.mes.building.core.api.pojo._do.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "AppTaskProcessDO", description = "用户可上报的工序类 ")
public class AppTaskProcessDO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "classId", notes = "配置类型id")
   @JsonProperty("classId")
   @JSONField(name = "classId")
   private Long classId;
   @ApiModelProperty(name = "className", notes = "配置类型名称")
   @JsonProperty("className")
   @JSONField(name = "className")
   private String className;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "orderNumber", notes = "任务工单")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
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
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "areaBatch", notes = "批次")
   @JsonProperty("areaBatch")
   @JSONField(name = "areaBatch")
   private NameInfo areaBatch;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "receivedQuantity", notes = "已完成数")
   @JsonProperty("receivedQuantity")
   @JSONField(name = "receivedQuantity")
   private Integer receivedQuantity;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "status", notes = "任务状态[0 正常,1暂停(可异常上报),2,暂停(正在处理中,无法上报)]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "technologyStatus", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("technologyStatus")
   @JSONField(name = "technologyStatus")
   private Boolean technologyStatus;
   @ApiModelProperty(name = "hasCraft", notes = "是否存在工艺")
   @JsonProperty("hasCraft")
   @JSONField(name = "hasCraft")
   private Boolean hasCraft;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "picturePath", notes = "图片路径")
   @JsonProperty("picturePath")
   @JSONField(name = "picturePath")
   private String picturePath;
   @ApiModelProperty(name = "reportType", notes = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(name = "sequence", notes = "顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;
   @ApiModelProperty(name = "firstProcess", notes = "是否是第一道工序")
   @JsonProperty("firstProcess")
   @JSONField(name = "firstProcess")
   private Boolean boolFirstProcess;
   @ApiModelProperty(name = "assistProductionLine", notes = "协同生产线")
   @JsonProperty("assistProductionLine")
   @JSONField(name = "assistProductionLine")
   private ProductionLineDetailDO assistProductionLine;
   @ApiModelProperty(name = "assistGroup", notes = "协同生产组")
   @JsonProperty("assistGroup")
   @JSONField(name = "assistGroup")
   private GroupsCurrencyDO assistGroup;

   public static AppTaskProcessDO.AppTaskProcessDOBuilder builder() {
      return new AppTaskProcessDO.AppTaskProcessDOBuilder();
   }

   public AppTaskProcessDO() {
   }

   public AppTaskProcessDO(
      final Long id,
      final Long classId,
      final String className,
      final ProjectDetailDO project,
      final String orderNumber,
      final MonomerDetailDO monomer,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups,
      final AreaDetailDO area,
      final NameInfo areaBatch,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final Integer receivedQuantity,
      final IdAndNameDO process,
      final Integer status,
      final Boolean technologyStatus,
      final Boolean hasCraft,
      final LocalDateTime askCompleteTime,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final String picturePath,
      final Integer reportType,
      final Integer sequence,
      final Boolean boolFirstProcess,
      final ProductionLineDetailDO assistProductionLine,
      final GroupsCurrencyDO assistGroup
   ) {
      this.id = id;
      this.classId = classId;
      this.className = className;
      this.project = project;
      this.orderNumber = orderNumber;
      this.monomer = monomer;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.area = area;
      this.areaBatch = areaBatch;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.receivedQuantity = receivedQuantity;
      this.process = process;
      this.status = status;
      this.technologyStatus = technologyStatus;
      this.hasCraft = hasCraft;
      this.askCompleteTime = askCompleteTime;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.picturePath = picturePath;
      this.reportType = reportType;
      this.sequence = sequence;
      this.boolFirstProcess = boolFirstProcess;
      this.assistProductionLine = assistProductionLine;
      this.assistGroup = assistGroup;
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassId() {
      return this.classId;
   }

   public String getClassName() {
      return this.className;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
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

   public AreaDetailDO getArea() {
      return this.area;
   }

   public NameInfo getAreaBatch() {
      return this.areaBatch;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getReceivedQuantity() {
      return this.receivedQuantity;
   }

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Boolean getTechnologyStatus() {
      return this.technologyStatus;
   }

   public Boolean getHasCraft() {
      return this.hasCraft;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getPicturePath() {
      return this.picturePath;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public Boolean getBoolFirstProcess() {
      return this.boolFirstProcess;
   }

   public ProductionLineDetailDO getAssistProductionLine() {
      return this.assistProductionLine;
   }

   public GroupsCurrencyDO getAssistGroup() {
      return this.assistGroup;
   }

   @JsonProperty("id")
   public AppTaskProcessDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("classId")
   public AppTaskProcessDO setClassId(final Long classId) {
      this.classId = classId;
      return this;
   }

   @JsonProperty("className")
   public AppTaskProcessDO setClassName(final String className) {
      this.className = className;
      return this;
   }

   @JsonProperty("project")
   public AppTaskProcessDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("orderNumber")
   public AppTaskProcessDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("monomer")
   public AppTaskProcessDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("workshop")
   public AppTaskProcessDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AppTaskProcessDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public AppTaskProcessDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("area")
   public AppTaskProcessDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("areaBatch")
   public AppTaskProcessDO setAreaBatch(final NameInfo areaBatch) {
      this.areaBatch = areaBatch;
      return this;
   }

   @JsonProperty("productId")
   public AppTaskProcessDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public AppTaskProcessDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public AppTaskProcessDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("receivedQuantity")
   public AppTaskProcessDO setReceivedQuantity(final Integer receivedQuantity) {
      this.receivedQuantity = receivedQuantity;
      return this;
   }

   @JsonProperty("process")
   public AppTaskProcessDO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("status")
   public AppTaskProcessDO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("technologyStatus")
   public AppTaskProcessDO setTechnologyStatus(final Boolean technologyStatus) {
      this.technologyStatus = technologyStatus;
      return this;
   }

   @JsonProperty("hasCraft")
   public AppTaskProcessDO setHasCraft(final Boolean hasCraft) {
      this.hasCraft = hasCraft;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AppTaskProcessDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("serialNumber")
   public AppTaskProcessDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public AppTaskProcessDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public AppTaskProcessDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public AppTaskProcessDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("picturePath")
   public AppTaskProcessDO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   @JsonProperty("reportType")
   public AppTaskProcessDO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("sequence")
   public AppTaskProcessDO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("firstProcess")
   public AppTaskProcessDO setBoolFirstProcess(final Boolean boolFirstProcess) {
      this.boolFirstProcess = boolFirstProcess;
      return this;
   }

   @JsonProperty("assistProductionLine")
   public AppTaskProcessDO setAssistProductionLine(final ProductionLineDetailDO assistProductionLine) {
      this.assistProductionLine = assistProductionLine;
      return this;
   }

   @JsonProperty("assistGroup")
   public AppTaskProcessDO setAssistGroup(final GroupsCurrencyDO assistGroup) {
      this.assistGroup = assistGroup;
      return this;
   }

   @Override
   public String toString() {
      return "AppTaskProcessDO(id="
         + this.getId()
         + ", classId="
         + this.getClassId()
         + ", className="
         + this.getClassName()
         + ", project="
         + this.getProject()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", monomer="
         + this.getMonomer()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", productId="
         + this.getProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", receivedQuantity="
         + this.getReceivedQuantity()
         + ", process="
         + this.getProcess()
         + ", status="
         + this.getStatus()
         + ", technologyStatus="
         + this.getTechnologyStatus()
         + ", hasCraft="
         + this.getHasCraft()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", picturePath="
         + this.getPicturePath()
         + ", reportType="
         + this.getReportType()
         + ", sequence="
         + this.getSequence()
         + ", boolFirstProcess="
         + this.getBoolFirstProcess()
         + ", assistProductionLine="
         + this.getAssistProductionLine()
         + ", assistGroup="
         + this.getAssistGroup()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppTaskProcessDO)) {
         return false;
      }

      AppTaskProcessDO other = (AppTaskProcessDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classId = this.getClassId();
         Object other$classId = other.getClassId();
         if (this$classId == null ? other$classId == null : this$classId.equals(other$classId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$receivedQuantity = this.getReceivedQuantity();
                     Object other$receivedQuantity = other.getReceivedQuantity();
                     if (this$receivedQuantity == null ? other$receivedQuantity == null : this$receivedQuantity.equals(other$receivedQuantity)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$technologyStatus = this.getTechnologyStatus();
                           Object other$technologyStatus = other.getTechnologyStatus();
                           if (this$technologyStatus == null ? other$technologyStatus == null : this$technologyStatus.equals(other$technologyStatus)) {
                              Object this$hasCraft = this.getHasCraft();
                              Object other$hasCraft = other.getHasCraft();
                              if (this$hasCraft == null ? other$hasCraft == null : this$hasCraft.equals(other$hasCraft)) {
                                 Object this$reportType = this.getReportType();
                                 Object other$reportType = other.getReportType();
                                 if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                                    Object this$sequence = this.getSequence();
                                    Object other$sequence = other.getSequence();
                                    if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                                       Object this$boolFirstProcess = this.getBoolFirstProcess();
                                       Object other$boolFirstProcess = other.getBoolFirstProcess();
                                       if (this$boolFirstProcess == null
                                          ? other$boolFirstProcess == null
                                          : this$boolFirstProcess.equals(other$boolFirstProcess)) {
                                          Object this$className = this.getClassName();
                                          Object other$className = other.getClassName();
                                          if (this$className == null ? other$className == null : this$className.equals(other$className)) {
                                             Object this$project = this.getProject();
                                             Object other$project = other.getProject();
                                             if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                Object this$orderNumber = this.getOrderNumber();
                                                Object other$orderNumber = other.getOrderNumber();
                                                if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                                   Object this$monomer = this.getMonomer();
                                                   Object other$monomer = other.getMonomer();
                                                   if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
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
                                                               Object this$area = this.getArea();
                                                               Object other$area = other.getArea();
                                                               if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                                  Object this$areaBatch = this.getAreaBatch();
                                                                  Object other$areaBatch = other.getAreaBatch();
                                                                  if (this$areaBatch == null ? other$areaBatch == null : this$areaBatch.equals(other$areaBatch)
                                                                     )
                                                                   {
                                                                     Object this$process = this.getProcess();
                                                                     Object other$process = other.getProcess();
                                                                     if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                                                        Object this$askCompleteTime = this.getAskCompleteTime();
                                                                        Object other$askCompleteTime = other.getAskCompleteTime();
                                                                        if (this$askCompleteTime == null
                                                                           ? other$askCompleteTime == null
                                                                           : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                           Object this$serialNumber = this.getSerialNumber();
                                                                           Object other$serialNumber = other.getSerialNumber();
                                                                           if (this$serialNumber == null
                                                                              ? other$serialNumber == null
                                                                              : this$serialNumber.equals(other$serialNumber)) {
                                                                              Object this$specification = this.getSpecification();
                                                                              Object other$specification = other.getSpecification();
                                                                              if (this$specification == null
                                                                                 ? other$specification == null
                                                                                 : this$specification.equals(other$specification)) {
                                                                                 Object this$length = this.getLength();
                                                                                 Object other$length = other.getLength();
                                                                                 if (this$length == null
                                                                                    ? other$length == null
                                                                                    : this$length.equals(other$length)) {
                                                                                    Object this$material = this.getMaterial();
                                                                                    Object other$material = other.getMaterial();
                                                                                    if (this$material == null
                                                                                       ? other$material == null
                                                                                       : this$material.equals(other$material)) {
                                                                                       Object this$picturePath = this.getPicturePath();
                                                                                       Object other$picturePath = other.getPicturePath();
                                                                                       if (this$picturePath == null
                                                                                          ? other$picturePath == null
                                                                                          : this$picturePath.equals(other$picturePath)) {
                                                                                          Object this$assistProductionLine = this.getAssistProductionLine();
                                                                                          Object other$assistProductionLine = other.getAssistProductionLine();
                                                                                          if (this$assistProductionLine == null
                                                                                             ? other$assistProductionLine == null
                                                                                             : this$assistProductionLine.equals(other$assistProductionLine)) {
                                                                                             Object this$assistGroup = this.getAssistGroup();
                                                                                             Object other$assistGroup = other.getAssistGroup();
                                                                                             return this$assistGroup == null
                                                                                                ? other$assistGroup == null
                                                                                                : this$assistGroup.equals(other$assistGroup);
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
      return other instanceof AppTaskProcessDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classId = this.getClassId();
      result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $receivedQuantity = this.getReceivedQuantity();
      result = result * 59 + ($receivedQuantity == null ? 43 : $receivedQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $technologyStatus = this.getTechnologyStatus();
      result = result * 59 + ($technologyStatus == null ? 43 : $technologyStatus.hashCode());
      Object $hasCraft = this.getHasCraft();
      result = result * 59 + ($hasCraft == null ? 43 : $hasCraft.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $boolFirstProcess = this.getBoolFirstProcess();
      result = result * 59 + ($boolFirstProcess == null ? 43 : $boolFirstProcess.hashCode());
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $picturePath = this.getPicturePath();
      result = result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
      Object $assistProductionLine = this.getAssistProductionLine();
      result = result * 59 + ($assistProductionLine == null ? 43 : $assistProductionLine.hashCode());
      Object $assistGroup = this.getAssistGroup();
      return result * 59 + ($assistGroup == null ? 43 : $assistGroup.hashCode());
   }

   public static class AppTaskProcessDOBuilder {
      private Long id;
      private Long classId;
      private String className;
      private ProjectDetailDO project;
      private String orderNumber;
      private MonomerDetailDO monomer;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private AreaDetailDO area;
      private NameInfo areaBatch;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private Integer receivedQuantity;
      private IdAndNameDO process;
      private Integer status;
      private Boolean technologyStatus;
      private Boolean hasCraft;
      private LocalDateTime askCompleteTime;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private String picturePath;
      private Integer reportType;
      private Integer sequence;
      private Boolean boolFirstProcess;
      private ProductionLineDetailDO assistProductionLine;
      private GroupsCurrencyDO assistGroup;

      AppTaskProcessDOBuilder() {
      }

      @JsonProperty("id")
      public AppTaskProcessDO.AppTaskProcessDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("classId")
      public AppTaskProcessDO.AppTaskProcessDOBuilder classId(final Long classId) {
         this.classId = classId;
         return this;
      }

      @JsonProperty("className")
      public AppTaskProcessDO.AppTaskProcessDOBuilder className(final String className) {
         this.className = className;
         return this;
      }

      @JsonProperty("project")
      public AppTaskProcessDO.AppTaskProcessDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("orderNumber")
      public AppTaskProcessDO.AppTaskProcessDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("monomer")
      public AppTaskProcessDO.AppTaskProcessDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("workshop")
      public AppTaskProcessDO.AppTaskProcessDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public AppTaskProcessDO.AppTaskProcessDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public AppTaskProcessDO.AppTaskProcessDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("area")
      public AppTaskProcessDO.AppTaskProcessDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("areaBatch")
      public AppTaskProcessDO.AppTaskProcessDOBuilder areaBatch(final NameInfo areaBatch) {
         this.areaBatch = areaBatch;
         return this;
      }

      @JsonProperty("productId")
      public AppTaskProcessDO.AppTaskProcessDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public AppTaskProcessDO.AppTaskProcessDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public AppTaskProcessDO.AppTaskProcessDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("receivedQuantity")
      public AppTaskProcessDO.AppTaskProcessDOBuilder receivedQuantity(final Integer receivedQuantity) {
         this.receivedQuantity = receivedQuantity;
         return this;
      }

      @JsonProperty("process")
      public AppTaskProcessDO.AppTaskProcessDOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("status")
      public AppTaskProcessDO.AppTaskProcessDOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("technologyStatus")
      public AppTaskProcessDO.AppTaskProcessDOBuilder technologyStatus(final Boolean technologyStatus) {
         this.technologyStatus = technologyStatus;
         return this;
      }

      @JsonProperty("hasCraft")
      public AppTaskProcessDO.AppTaskProcessDOBuilder hasCraft(final Boolean hasCraft) {
         this.hasCraft = hasCraft;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AppTaskProcessDO.AppTaskProcessDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("serialNumber")
      public AppTaskProcessDO.AppTaskProcessDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public AppTaskProcessDO.AppTaskProcessDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public AppTaskProcessDO.AppTaskProcessDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public AppTaskProcessDO.AppTaskProcessDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("picturePath")
      public AppTaskProcessDO.AppTaskProcessDOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      @JsonProperty("reportType")
      public AppTaskProcessDO.AppTaskProcessDOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("sequence")
      public AppTaskProcessDO.AppTaskProcessDOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("firstProcess")
      public AppTaskProcessDO.AppTaskProcessDOBuilder boolFirstProcess(final Boolean boolFirstProcess) {
         this.boolFirstProcess = boolFirstProcess;
         return this;
      }

      @JsonProperty("assistProductionLine")
      public AppTaskProcessDO.AppTaskProcessDOBuilder assistProductionLine(final ProductionLineDetailDO assistProductionLine) {
         this.assistProductionLine = assistProductionLine;
         return this;
      }

      @JsonProperty("assistGroup")
      public AppTaskProcessDO.AppTaskProcessDOBuilder assistGroup(final GroupsCurrencyDO assistGroup) {
         this.assistGroup = assistGroup;
         return this;
      }

      public AppTaskProcessDO build() {
         return new AppTaskProcessDO(
            this.id,
            this.classId,
            this.className,
            this.project,
            this.orderNumber,
            this.monomer,
            this.workshop,
            this.productionLine,
            this.groups,
            this.area,
            this.areaBatch,
            this.productId,
            this.taskTypeEnum,
            this.quantity,
            this.receivedQuantity,
            this.process,
            this.status,
            this.technologyStatus,
            this.hasCraft,
            this.askCompleteTime,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.picturePath,
            this.reportType,
            this.sequence,
            this.boolFirstProcess,
            this.assistProductionLine,
            this.assistGroup
         );
      }

      @Override
      public String toString() {
         return "AppTaskProcessDO.AppTaskProcessDOBuilder(id="
            + this.id
            + ", classId="
            + this.classId
            + ", className="
            + this.className
            + ", project="
            + this.project
            + ", orderNumber="
            + this.orderNumber
            + ", monomer="
            + this.monomer
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", area="
            + this.area
            + ", areaBatch="
            + this.areaBatch
            + ", productId="
            + this.productId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", receivedQuantity="
            + this.receivedQuantity
            + ", process="
            + this.process
            + ", status="
            + this.status
            + ", technologyStatus="
            + this.technologyStatus
            + ", hasCraft="
            + this.hasCraft
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", picturePath="
            + this.picturePath
            + ", reportType="
            + this.reportType
            + ", sequence="
            + this.sequence
            + ", boolFirstProcess="
            + this.boolFirstProcess
            + ", assistProductionLine="
            + this.assistProductionLine
            + ", assistGroup="
            + this.assistGroup
            + ")";
      }
   }
}
