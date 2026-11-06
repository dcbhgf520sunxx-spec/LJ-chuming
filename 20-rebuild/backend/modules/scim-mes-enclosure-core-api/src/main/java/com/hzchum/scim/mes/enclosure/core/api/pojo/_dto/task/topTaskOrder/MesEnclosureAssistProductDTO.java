package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.topTaskOrder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureAssistProductDTO", description = "任务工单产品信息")
public class MesEnclosureAssistProductDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "assistId", value = "协同id", notes = "协同id")
   @JsonProperty("assistId")
   @JSONField(name = "assistId")
   private Long assistId;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "生产线", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", value = "生产组", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "config", value = "配置信息", notes = "配置信息")
   @JsonProperty("config")
   @JSONField(name = "config")
   private IdAndNameDO config;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "process", value = "工序", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "totalTaskMete", value = "任务量", notes = "任务量")
   @JsonProperty("totalTaskMete")
   @JSONField(name = "totalTaskMete")
   private QuantityAndWeightDetailDO totalTaskMete;
   @ApiModelProperty(name = "totalCompleteMete", value = "完成量", notes = "完成量")
   @JsonProperty("totalCompleteMete")
   @JSONField(name = "totalCompleteMete")
   private QuantityAndWeightDetailDO totalCompleteMete;
   @ApiModelProperty(name = "totalCanAssistMete", value = "总可协同量", notes = "总可协同量")
   @JsonProperty("totalCanAssistMete")
   @JSONField(name = "totalCanAssistMete")
   @JsonInclude(Include.NON_NULL)
   private QuantityAndWeightDetailDO totalCanAssistMete;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;

   public static MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder builder() {
      return new MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder();
   }

   public MesEnclosureAssistProductDTO() {
   }

   public MesEnclosureAssistProductDTO(
      final Long id,
      final Long factoryId,
      final Long assistId,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups,
      final Integer taskTypeEnum,
      final AreaDetailDO area,
      final IdAndNameDO config,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final IdAndNameDO process,
      final QuantityAndWeightDetailDO totalTaskMete,
      final QuantityAndWeightDetailDO totalCompleteMete,
      final QuantityAndWeightDetailDO totalCanAssistMete,
      final LocalDateTime askCompleteTime
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.assistId = assistId;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.taskTypeEnum = taskTypeEnum;
      this.area = area;
      this.config = config;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.process = process;
      this.totalTaskMete = totalTaskMete;
      this.totalCompleteMete = totalCompleteMete;
      this.totalCanAssistMete = totalCanAssistMete;
      this.askCompleteTime = askCompleteTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getAssistId() {
      return this.assistId;
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

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public IdAndNameDO getConfig() {
      return this.config;
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

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public QuantityAndWeightDetailDO getTotalTaskMete() {
      return this.totalTaskMete;
   }

   public QuantityAndWeightDetailDO getTotalCompleteMete() {
      return this.totalCompleteMete;
   }

   public QuantityAndWeightDetailDO getTotalCanAssistMete() {
      return this.totalCanAssistMete;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   @JsonProperty("id")
   public MesEnclosureAssistProductDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureAssistProductDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("assistId")
   public MesEnclosureAssistProductDTO setAssistId(final Long assistId) {
      this.assistId = assistId;
      return this;
   }

   @JsonProperty("workshop")
   public MesEnclosureAssistProductDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesEnclosureAssistProductDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public MesEnclosureAssistProductDTO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesEnclosureAssistProductDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("area")
   public MesEnclosureAssistProductDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("config")
   public MesEnclosureAssistProductDTO setConfig(final IdAndNameDO config) {
      this.config = config;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureAssistProductDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesEnclosureAssistProductDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesEnclosureAssistProductDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("process")
   public MesEnclosureAssistProductDTO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("totalTaskMete")
   public MesEnclosureAssistProductDTO setTotalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
      this.totalTaskMete = totalTaskMete;
      return this;
   }

   @JsonProperty("totalCompleteMete")
   public MesEnclosureAssistProductDTO setTotalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
      this.totalCompleteMete = totalCompleteMete;
      return this;
   }

   @JsonProperty("totalCanAssistMete")
   public MesEnclosureAssistProductDTO setTotalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
      this.totalCanAssistMete = totalCanAssistMete;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureAssistProductDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureAssistProductDTO(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", assistId="
         + this.getAssistId()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", area="
         + this.getArea()
         + ", config="
         + this.getConfig()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", process="
         + this.getProcess()
         + ", totalTaskMete="
         + this.getTotalTaskMete()
         + ", totalCompleteMete="
         + this.getTotalCompleteMete()
         + ", totalCanAssistMete="
         + this.getTotalCanAssistMete()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureAssistProductDTO)) {
         return false;
      }

      MesEnclosureAssistProductDTO other = (MesEnclosureAssistProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$assistId = this.getAssistId();
            Object other$assistId = other.getAssistId();
            if (this$assistId == null ? other$assistId == null : this$assistId.equals(other$assistId)) {
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                  Object this$workshop = this.getWorkshop();
                  Object other$workshop = other.getWorkshop();
                  if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                     Object this$productionLine = this.getProductionLine();
                     Object other$productionLine = other.getProductionLine();
                     if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                        Object this$groups = this.getGroups();
                        Object other$groups = other.getGroups();
                        if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$config = this.getConfig();
                              Object other$config = other.getConfig();
                              if (this$config == null ? other$config == null : this$config.equals(other$config)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$process = this.getProcess();
                                          Object other$process = other.getProcess();
                                          if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                             Object this$totalTaskMete = this.getTotalTaskMete();
                                             Object other$totalTaskMete = other.getTotalTaskMete();
                                             if (this$totalTaskMete == null ? other$totalTaskMete == null : this$totalTaskMete.equals(other$totalTaskMete)) {
                                                Object this$totalCompleteMete = this.getTotalCompleteMete();
                                                Object other$totalCompleteMete = other.getTotalCompleteMete();
                                                if (this$totalCompleteMete == null
                                                   ? other$totalCompleteMete == null
                                                   : this$totalCompleteMete.equals(other$totalCompleteMete)) {
                                                   Object this$totalCanAssistMete = this.getTotalCanAssistMete();
                                                   Object other$totalCanAssistMete = other.getTotalCanAssistMete();
                                                   if (this$totalCanAssistMete == null
                                                      ? other$totalCanAssistMete == null
                                                      : this$totalCanAssistMete.equals(other$totalCanAssistMete)) {
                                                      Object this$askCompleteTime = this.getAskCompleteTime();
                                                      Object other$askCompleteTime = other.getAskCompleteTime();
                                                      return this$askCompleteTime == null
                                                         ? other$askCompleteTime == null
                                                         : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof MesEnclosureAssistProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $assistId = this.getAssistId();
      result = result * 59 + ($assistId == null ? 43 : $assistId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $config = this.getConfig();
      result = result * 59 + ($config == null ? 43 : $config.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $totalTaskMete = this.getTotalTaskMete();
      result = result * 59 + ($totalTaskMete == null ? 43 : $totalTaskMete.hashCode());
      Object $totalCompleteMete = this.getTotalCompleteMete();
      result = result * 59 + ($totalCompleteMete == null ? 43 : $totalCompleteMete.hashCode());
      Object $totalCanAssistMete = this.getTotalCanAssistMete();
      result = result * 59 + ($totalCanAssistMete == null ? 43 : $totalCanAssistMete.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   public static class MesEnclosureAssistProductDTOBuilder {
      private Long id;
      private Long factoryId;
      private Long assistId;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private Integer taskTypeEnum;
      private AreaDetailDO area;
      private IdAndNameDO config;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private IdAndNameDO process;
      private QuantityAndWeightDetailDO totalTaskMete;
      private QuantityAndWeightDetailDO totalCompleteMete;
      private QuantityAndWeightDetailDO totalCanAssistMete;
      private LocalDateTime askCompleteTime;

      MesEnclosureAssistProductDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("assistId")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder assistId(final Long assistId) {
         this.assistId = assistId;
         return this;
      }

      @JsonProperty("workshop")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("area")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("config")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder config(final IdAndNameDO config) {
         this.config = config;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("process")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("totalTaskMete")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder totalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
         this.totalTaskMete = totalTaskMete;
         return this;
      }

      @JsonProperty("totalCompleteMete")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder totalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
         this.totalCompleteMete = totalCompleteMete;
         return this;
      }

      @JsonProperty("totalCanAssistMete")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder totalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
         this.totalCanAssistMete = totalCanAssistMete;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesEnclosureAssistProductDTO build() {
         return new MesEnclosureAssistProductDTO(
            this.id,
            this.factoryId,
            this.assistId,
            this.workshop,
            this.productionLine,
            this.groups,
            this.taskTypeEnum,
            this.area,
            this.config,
            this.serialNumber,
            this.specification,
            this.length,
            this.process,
            this.totalTaskMete,
            this.totalCompleteMete,
            this.totalCanAssistMete,
            this.askCompleteTime
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureAssistProductDTO.MesEnclosureAssistProductDTOBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", assistId="
            + this.assistId
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", area="
            + this.area
            + ", config="
            + this.config
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", process="
            + this.process
            + ", totalTaskMete="
            + this.totalTaskMete
            + ", totalCompleteMete="
            + this.totalCompleteMete
            + ", totalCanAssistMete="
            + this.totalCanAssistMete
            + ", askCompleteTime="
            + this.askCompleteTime
            + ")";
      }
   }
}
