package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
public class AppTaskProcessDTO {
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
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "orderNumber", notes = "任务工单")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   @JsonInclude(Include.NON_NULL)
   private String orderNumber;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   @JsonInclude(Include.NON_NULL)
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   @JsonInclude(Include.NON_NULL)
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   @JsonInclude(Include.NON_NULL)
   private GroupsCurrencyDO group;
   @ApiModelProperty(name = "assistProductionLine", notes = "协同生产线")
   @JsonProperty("assistProductionLine")
   @JSONField(name = "assistProductionLine")
   @JsonInclude(Include.NON_NULL)
   private ProductionLineDetailDO assistProductionLine;
   @ApiModelProperty(name = "assistGroup", notes = "协同生产组")
   @JsonProperty("assistGroup")
   @JSONField(name = "assistGroup")
   @JsonInclude(Include.NON_NULL)
   private GroupsCurrencyDO assistGroup;
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
   @ApiModelProperty(name = "boolMissingEnum", notes = "是否缺件")
   @JsonProperty("boolMissingEnum")
   @JSONField(name = "boolMissingEnum")
   @JsonInclude(Include.NON_NULL)
   private Boolean boolMissingEnum;

   public static AppTaskProcessDTO.AppTaskProcessDTOBuilder builder() {
      return new AppTaskProcessDTO.AppTaskProcessDTOBuilder();
   }

   public AppTaskProcessDTO() {
   }

   public AppTaskProcessDTO(
      final Long id,
      final Long classId,
      final String className,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final String orderNumber,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO group,
      final ProductionLineDetailDO assistProductionLine,
      final GroupsCurrencyDO assistGroup,
      final AreaDetailDO area,
      final NameInfo areaBatch,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final Integer receivedQuantity,
      final IdAndNameDO process,
      final Integer status,
      final Boolean technologyStatus,
      final LocalDateTime askCompleteTime,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final String picturePath,
      final Integer reportType,
      final Integer sequence,
      final Boolean boolFirstProcess,
      final Boolean boolMissingEnum
   ) {
      this.id = id;
      this.classId = classId;
      this.className = className;
      this.project = project;
      this.monomer = monomer;
      this.orderNumber = orderNumber;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.group = group;
      this.assistProductionLine = assistProductionLine;
      this.assistGroup = assistGroup;
      this.area = area;
      this.areaBatch = areaBatch;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.receivedQuantity = receivedQuantity;
      this.process = process;
      this.status = status;
      this.technologyStatus = technologyStatus;
      this.askCompleteTime = askCompleteTime;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.picturePath = picturePath;
      this.reportType = reportType;
      this.sequence = sequence;
      this.boolFirstProcess = boolFirstProcess;
      this.boolMissingEnum = boolMissingEnum;
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

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public GroupsCurrencyDO getGroup() {
      return this.group;
   }

   public ProductionLineDetailDO getAssistProductionLine() {
      return this.assistProductionLine;
   }

   public GroupsCurrencyDO getAssistGroup() {
      return this.assistGroup;
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

   public Boolean getBoolMissingEnum() {
      return this.boolMissingEnum;
   }

   @JsonProperty("id")
   public AppTaskProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("classId")
   public AppTaskProcessDTO setClassId(final Long classId) {
      this.classId = classId;
      return this;
   }

   @JsonProperty("className")
   public AppTaskProcessDTO setClassName(final String className) {
      this.className = className;
      return this;
   }

   @JsonProperty("project")
   public AppTaskProcessDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public AppTaskProcessDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("orderNumber")
   public AppTaskProcessDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("workshop")
   public AppTaskProcessDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AppTaskProcessDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public AppTaskProcessDTO setGroup(final GroupsCurrencyDO group) {
      this.group = group;
      return this;
   }

   @JsonProperty("assistProductionLine")
   public AppTaskProcessDTO setAssistProductionLine(final ProductionLineDetailDO assistProductionLine) {
      this.assistProductionLine = assistProductionLine;
      return this;
   }

   @JsonProperty("assistGroup")
   public AppTaskProcessDTO setAssistGroup(final GroupsCurrencyDO assistGroup) {
      this.assistGroup = assistGroup;
      return this;
   }

   @JsonProperty("area")
   public AppTaskProcessDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("areaBatch")
   public AppTaskProcessDTO setAreaBatch(final NameInfo areaBatch) {
      this.areaBatch = areaBatch;
      return this;
   }

   @JsonProperty("productId")
   public AppTaskProcessDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public AppTaskProcessDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public AppTaskProcessDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("receivedQuantity")
   public AppTaskProcessDTO setReceivedQuantity(final Integer receivedQuantity) {
      this.receivedQuantity = receivedQuantity;
      return this;
   }

   @JsonProperty("process")
   public AppTaskProcessDTO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("status")
   public AppTaskProcessDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("technologyStatus")
   public AppTaskProcessDTO setTechnologyStatus(final Boolean technologyStatus) {
      this.technologyStatus = technologyStatus;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AppTaskProcessDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("serialNumber")
   public AppTaskProcessDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public AppTaskProcessDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public AppTaskProcessDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public AppTaskProcessDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("picturePath")
   public AppTaskProcessDTO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   @JsonProperty("reportType")
   public AppTaskProcessDTO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("sequence")
   public AppTaskProcessDTO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("firstProcess")
   public AppTaskProcessDTO setBoolFirstProcess(final Boolean boolFirstProcess) {
      this.boolFirstProcess = boolFirstProcess;
      return this;
   }

   @JsonProperty("boolMissingEnum")
   public AppTaskProcessDTO setBoolMissingEnum(final Boolean boolMissingEnum) {
      this.boolMissingEnum = boolMissingEnum;
      return this;
   }

   @Override
   public String toString() {
      return "AppTaskProcessDTO(id="
         + this.getId()
         + ", classId="
         + this.getClassId()
         + ", className="
         + this.getClassName()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", group="
         + this.getGroup()
         + ", assistProductionLine="
         + this.getAssistProductionLine()
         + ", assistGroup="
         + this.getAssistGroup()
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
         + ", boolMissingEnum="
         + this.getBoolMissingEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppTaskProcessDTO)) {
         return false;
      }

      AppTaskProcessDTO other = (AppTaskProcessDTO)o;
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
                              Object this$reportType = this.getReportType();
                              Object other$reportType = other.getReportType();
                              if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                                 Object this$sequence = this.getSequence();
                                 Object other$sequence = other.getSequence();
                                 if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                                    Object this$boolFirstProcess = this.getBoolFirstProcess();
                                    Object other$boolFirstProcess = other.getBoolFirstProcess();
                                    if (this$boolFirstProcess == null ? other$boolFirstProcess == null : this$boolFirstProcess.equals(other$boolFirstProcess)) {
                                       Object this$boolMissingEnum = this.getBoolMissingEnum();
                                       Object other$boolMissingEnum = other.getBoolMissingEnum();
                                       if (this$boolMissingEnum == null ? other$boolMissingEnum == null : this$boolMissingEnum.equals(other$boolMissingEnum)) {
                                          Object this$className = this.getClassName();
                                          Object other$className = other.getClassName();
                                          if (this$className == null ? other$className == null : this$className.equals(other$className)) {
                                             Object this$project = this.getProject();
                                             Object other$project = other.getProject();
                                             if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                Object this$monomer = this.getMonomer();
                                                Object other$monomer = other.getMonomer();
                                                if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                   Object this$orderNumber = this.getOrderNumber();
                                                   Object other$orderNumber = other.getOrderNumber();
                                                   if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                                      Object this$workshop = this.getWorkshop();
                                                      Object other$workshop = other.getWorkshop();
                                                      if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                         Object this$productionLine = this.getProductionLine();
                                                         Object other$productionLine = other.getProductionLine();
                                                         if (this$productionLine == null
                                                            ? other$productionLine == null
                                                            : this$productionLine.equals(other$productionLine)) {
                                                            Object this$group = this.getGroup();
                                                            Object other$group = other.getGroup();
                                                            if (this$group == null ? other$group == null : this$group.equals(other$group)) {
                                                               Object this$assistProductionLine = this.getAssistProductionLine();
                                                               Object other$assistProductionLine = other.getAssistProductionLine();
                                                               if (this$assistProductionLine == null
                                                                  ? other$assistProductionLine == null
                                                                  : this$assistProductionLine.equals(other$assistProductionLine)) {
                                                                  Object this$assistGroup = this.getAssistGroup();
                                                                  Object other$assistGroup = other.getAssistGroup();
                                                                  if (this$assistGroup == null
                                                                     ? other$assistGroup == null
                                                                     : this$assistGroup.equals(other$assistGroup)) {
                                                                     Object this$area = this.getArea();
                                                                     Object other$area = other.getArea();
                                                                     if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                                        Object this$areaBatch = this.getAreaBatch();
                                                                        Object other$areaBatch = other.getAreaBatch();
                                                                        if (this$areaBatch == null
                                                                           ? other$areaBatch == null
                                                                           : this$areaBatch.equals(other$areaBatch)) {
                                                                           Object this$process = this.getProcess();
                                                                           Object other$process = other.getProcess();
                                                                           if (this$process == null
                                                                              ? other$process == null
                                                                              : this$process.equals(other$process)) {
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
                                                                                             return this$picturePath == null
                                                                                                ? other$picturePath == null
                                                                                                : this$picturePath.equals(other$picturePath);
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
      return other instanceof AppTaskProcessDTO;
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
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $boolFirstProcess = this.getBoolFirstProcess();
      result = result * 59 + ($boolFirstProcess == null ? 43 : $boolFirstProcess.hashCode());
      Object $boolMissingEnum = this.getBoolMissingEnum();
      result = result * 59 + ($boolMissingEnum == null ? 43 : $boolMissingEnum.hashCode());
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $group = this.getGroup();
      result = result * 59 + ($group == null ? 43 : $group.hashCode());
      Object $assistProductionLine = this.getAssistProductionLine();
      result = result * 59 + ($assistProductionLine == null ? 43 : $assistProductionLine.hashCode());
      Object $assistGroup = this.getAssistGroup();
      result = result * 59 + ($assistGroup == null ? 43 : $assistGroup.hashCode());
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
      return result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
   }

   public static class AppTaskProcessDTOBuilder {
      private Long id;
      private Long classId;
      private String className;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private String orderNumber;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO group;
      private ProductionLineDetailDO assistProductionLine;
      private GroupsCurrencyDO assistGroup;
      private AreaDetailDO area;
      private NameInfo areaBatch;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private Integer receivedQuantity;
      private IdAndNameDO process;
      private Integer status;
      private Boolean technologyStatus;
      private LocalDateTime askCompleteTime;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private String picturePath;
      private Integer reportType;
      private Integer sequence;
      private Boolean boolFirstProcess;
      private Boolean boolMissingEnum;

      AppTaskProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("classId")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder classId(final Long classId) {
         this.classId = classId;
         return this;
      }

      @JsonProperty("className")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder className(final String className) {
         this.className = className;
         return this;
      }

      @JsonProperty("project")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("orderNumber")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("workshop")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder group(final GroupsCurrencyDO group) {
         this.group = group;
         return this;
      }

      @JsonProperty("assistProductionLine")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder assistProductionLine(final ProductionLineDetailDO assistProductionLine) {
         this.assistProductionLine = assistProductionLine;
         return this;
      }

      @JsonProperty("assistGroup")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder assistGroup(final GroupsCurrencyDO assistGroup) {
         this.assistGroup = assistGroup;
         return this;
      }

      @JsonProperty("area")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("areaBatch")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder areaBatch(final NameInfo areaBatch) {
         this.areaBatch = areaBatch;
         return this;
      }

      @JsonProperty("productId")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("receivedQuantity")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder receivedQuantity(final Integer receivedQuantity) {
         this.receivedQuantity = receivedQuantity;
         return this;
      }

      @JsonProperty("process")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("status")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("technologyStatus")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder technologyStatus(final Boolean technologyStatus) {
         this.technologyStatus = technologyStatus;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("serialNumber")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("picturePath")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      @JsonProperty("reportType")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("sequence")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("firstProcess")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder boolFirstProcess(final Boolean boolFirstProcess) {
         this.boolFirstProcess = boolFirstProcess;
         return this;
      }

      @JsonProperty("boolMissingEnum")
      public AppTaskProcessDTO.AppTaskProcessDTOBuilder boolMissingEnum(final Boolean boolMissingEnum) {
         this.boolMissingEnum = boolMissingEnum;
         return this;
      }

      public AppTaskProcessDTO build() {
         return new AppTaskProcessDTO(
            this.id,
            this.classId,
            this.className,
            this.project,
            this.monomer,
            this.orderNumber,
            this.workshop,
            this.productionLine,
            this.group,
            this.assistProductionLine,
            this.assistGroup,
            this.area,
            this.areaBatch,
            this.productId,
            this.taskTypeEnum,
            this.quantity,
            this.receivedQuantity,
            this.process,
            this.status,
            this.technologyStatus,
            this.askCompleteTime,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.picturePath,
            this.reportType,
            this.sequence,
            this.boolFirstProcess,
            this.boolMissingEnum
         );
      }

      @Override
      public String toString() {
         return "AppTaskProcessDTO.AppTaskProcessDTOBuilder(id="
            + this.id
            + ", classId="
            + this.classId
            + ", className="
            + this.className
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", orderNumber="
            + this.orderNumber
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", group="
            + this.group
            + ", assistProductionLine="
            + this.assistProductionLine
            + ", assistGroup="
            + this.assistGroup
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
            + ", boolMissingEnum="
            + this.boolMissingEnum
            + ")";
      }
   }
}
