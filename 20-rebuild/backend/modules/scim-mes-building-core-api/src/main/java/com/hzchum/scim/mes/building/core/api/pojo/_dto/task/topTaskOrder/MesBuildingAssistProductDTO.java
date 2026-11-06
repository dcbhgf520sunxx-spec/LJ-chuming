package com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingAssistProductDTO", description = "任务工单产品信息")
public class MesBuildingAssistProductDTO {
   @ApiModelProperty(name = "任务id", value = "任务id", notes = "任务id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "任务id", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "产品id", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private NameInfo monomer;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
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
   @ApiModelProperty(name = "booleanAssist", value = "是否协同过", notes = "是否协同过")
   @JsonProperty("booleanAssist")
   @JSONField(name = "booleanAssist")
   private Boolean booleanAssist;
   @ApiModelProperty(name = "totalAssistQuantity", value = "总协同数", notes = "总协同数")
   @JsonProperty("totalAssistQuantity")
   @JSONField(name = "totalAssistQuantity")
   private Integer totalAssistQuantity;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Integer factoryId;
   @ApiModelProperty(name = "sequence", value = "工序顺序", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;
   @ApiModelProperty(name = "mesBuildingAssistDetailDTOS", value = "协同详细信息", notes = "协同详细信息")
   @JsonProperty("mesBuildingAssistDetailDTOS")
   @JSONField(name = "mesBuildingAssistDetailDTOS")
   private List<MesBuildingAssistDetailDTO> mesBuildingAssistDetailDTOS;
   @ApiModelProperty(name = "boolOnecode", value = "是否一物一码", notes = "是否一物一码")
   @JsonProperty("boolOnecode")
   @JSONField(name = "boolOnecode")
   private Boolean boolOnecode;
   @ApiModelProperty(name = "numberList", value = "可以协同的一物一码号", notes = "可以协同的一物一码号")
   @JsonProperty("numberList")
   @JSONField(name = "numberList")
   private List<Integer> numberList;
   @ApiModelProperty(name = "boolOperations", value = "是否可以批量操作", notes = "是否可以批量操作")
   @JsonProperty("boolOperations")
   @JSONField(name = "boolOperations")
   private Boolean boolOperations;
   @ApiModelProperty(name = "artifactTaskId", notes = "构件任务Id")
   @JsonProperty("artifactTaskId")
   @JSONField(name = "artifactTaskId")
   private Long artifactTaskId;

   public static MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder builder() {
      return new MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder();
   }

   public MesBuildingAssistProductDTO() {
   }

   public MesBuildingAssistProductDTO(
      final Long id,
      final Long taskId,
      final Long productId,
      final AreaDetailDO area,
      final NameInfo monomer,
      final Integer taskTypeEnum,
      final IdAndNameDO config,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final IdAndNameDO process,
      final QuantityAndWeightDetailDO totalTaskMete,
      final QuantityAndWeightDetailDO totalCompleteMete,
      final QuantityAndWeightDetailDO totalCanAssistMete,
      final LocalDateTime askCompleteTime,
      final Boolean booleanAssist,
      final Integer totalAssistQuantity,
      final Integer factoryId,
      final Integer sequence,
      final List<MesBuildingAssistDetailDTO> mesBuildingAssistDetailDTOS,
      final Boolean boolOnecode,
      final List<Integer> numberList,
      final Boolean boolOperations,
      final Long artifactTaskId
   ) {
      this.id = id;
      this.taskId = taskId;
      this.productId = productId;
      this.area = area;
      this.monomer = monomer;
      this.taskTypeEnum = taskTypeEnum;
      this.config = config;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.process = process;
      this.totalTaskMete = totalTaskMete;
      this.totalCompleteMete = totalCompleteMete;
      this.totalCanAssistMete = totalCanAssistMete;
      this.askCompleteTime = askCompleteTime;
      this.booleanAssist = booleanAssist;
      this.totalAssistQuantity = totalAssistQuantity;
      this.factoryId = factoryId;
      this.sequence = sequence;
      this.mesBuildingAssistDetailDTOS = mesBuildingAssistDetailDTOS;
      this.boolOnecode = boolOnecode;
      this.numberList = numberList;
      this.boolOperations = boolOperations;
      this.artifactTaskId = artifactTaskId;
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

   public AreaDetailDO getArea() {
      return this.area;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
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

   public Boolean getBooleanAssist() {
      return this.booleanAssist;
   }

   public Integer getTotalAssistQuantity() {
      return this.totalAssistQuantity;
   }

   public Integer getFactoryId() {
      return this.factoryId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public List<MesBuildingAssistDetailDTO> getMesBuildingAssistDetailDTOS() {
      return this.mesBuildingAssistDetailDTOS;
   }

   public Boolean getBoolOnecode() {
      return this.boolOnecode;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public Boolean getBoolOperations() {
      return this.boolOperations;
   }

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   @JsonProperty("id")
   public MesBuildingAssistProductDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingAssistProductDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingAssistProductDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("area")
   public MesBuildingAssistProductDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingAssistProductDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingAssistProductDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("config")
   public MesBuildingAssistProductDTO setConfig(final IdAndNameDO config) {
      this.config = config;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingAssistProductDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingAssistProductDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingAssistProductDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("process")
   public MesBuildingAssistProductDTO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("totalTaskMete")
   public MesBuildingAssistProductDTO setTotalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
      this.totalTaskMete = totalTaskMete;
      return this;
   }

   @JsonProperty("totalCompleteMete")
   public MesBuildingAssistProductDTO setTotalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
      this.totalCompleteMete = totalCompleteMete;
      return this;
   }

   @JsonProperty("totalCanAssistMete")
   public MesBuildingAssistProductDTO setTotalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
      this.totalCanAssistMete = totalCanAssistMete;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingAssistProductDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("booleanAssist")
   public MesBuildingAssistProductDTO setBooleanAssist(final Boolean booleanAssist) {
      this.booleanAssist = booleanAssist;
      return this;
   }

   @JsonProperty("totalAssistQuantity")
   public MesBuildingAssistProductDTO setTotalAssistQuantity(final Integer totalAssistQuantity) {
      this.totalAssistQuantity = totalAssistQuantity;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingAssistProductDTO setFactoryId(final Integer factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingAssistProductDTO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("mesBuildingAssistDetailDTOS")
   public MesBuildingAssistProductDTO setMesBuildingAssistDetailDTOS(final List<MesBuildingAssistDetailDTO> mesBuildingAssistDetailDTOS) {
      this.mesBuildingAssistDetailDTOS = mesBuildingAssistDetailDTOS;
      return this;
   }

   @JsonProperty("boolOnecode")
   public MesBuildingAssistProductDTO setBoolOnecode(final Boolean boolOnecode) {
      this.boolOnecode = boolOnecode;
      return this;
   }

   @JsonProperty("numberList")
   public MesBuildingAssistProductDTO setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @JsonProperty("boolOperations")
   public MesBuildingAssistProductDTO setBoolOperations(final Boolean boolOperations) {
      this.boolOperations = boolOperations;
      return this;
   }

   @JsonProperty("artifactTaskId")
   public MesBuildingAssistProductDTO setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssistProductDTO(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", productId="
         + this.getProductId()
         + ", area="
         + this.getArea()
         + ", monomer="
         + this.getMonomer()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
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
         + ", booleanAssist="
         + this.getBooleanAssist()
         + ", totalAssistQuantity="
         + this.getTotalAssistQuantity()
         + ", factoryId="
         + this.getFactoryId()
         + ", sequence="
         + this.getSequence()
         + ", mesBuildingAssistDetailDTOS="
         + this.getMesBuildingAssistDetailDTOS()
         + ", boolOnecode="
         + this.getBoolOnecode()
         + ", numberList="
         + this.getNumberList()
         + ", boolOperations="
         + this.getBoolOperations()
         + ", artifactTaskId="
         + this.getArtifactTaskId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssistProductDTO)) {
         return false;
      }

      MesBuildingAssistProductDTO other = (MesBuildingAssistProductDTO)o;
      if (!other.canEqual(this)) {
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
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                  Object this$booleanAssist = this.getBooleanAssist();
                  Object other$booleanAssist = other.getBooleanAssist();
                  if (this$booleanAssist == null ? other$booleanAssist == null : this$booleanAssist.equals(other$booleanAssist)) {
                     Object this$totalAssistQuantity = this.getTotalAssistQuantity();
                     Object other$totalAssistQuantity = other.getTotalAssistQuantity();
                     if (this$totalAssistQuantity == null ? other$totalAssistQuantity == null : this$totalAssistQuantity.equals(other$totalAssistQuantity)) {
                        Object this$factoryId = this.getFactoryId();
                        Object other$factoryId = other.getFactoryId();
                        if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                           Object this$sequence = this.getSequence();
                           Object other$sequence = other.getSequence();
                           if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                              Object this$boolOnecode = this.getBoolOnecode();
                              Object other$boolOnecode = other.getBoolOnecode();
                              if (this$boolOnecode == null ? other$boolOnecode == null : this$boolOnecode.equals(other$boolOnecode)) {
                                 Object this$boolOperations = this.getBoolOperations();
                                 Object other$boolOperations = other.getBoolOperations();
                                 if (this$boolOperations == null ? other$boolOperations == null : this$boolOperations.equals(other$boolOperations)) {
                                    Object this$artifactTaskId = this.getArtifactTaskId();
                                    Object other$artifactTaskId = other.getArtifactTaskId();
                                    if (this$artifactTaskId == null ? other$artifactTaskId == null : this$artifactTaskId.equals(other$artifactTaskId)) {
                                       Object this$area = this.getArea();
                                       Object other$area = other.getArea();
                                       if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                          Object this$monomer = this.getMonomer();
                                          Object other$monomer = other.getMonomer();
                                          if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                             Object this$config = this.getConfig();
                                             Object other$config = other.getConfig();
                                             if (this$config == null ? other$config == null : this$config.equals(other$config)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$length = this.getLength();
                                                      Object other$length = other.getLength();
                                                      if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                         Object this$process = this.getProcess();
                                                         Object other$process = other.getProcess();
                                                         if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                                            Object this$totalTaskMete = this.getTotalTaskMete();
                                                            Object other$totalTaskMete = other.getTotalTaskMete();
                                                            if (this$totalTaskMete == null
                                                               ? other$totalTaskMete == null
                                                               : this$totalTaskMete.equals(other$totalTaskMete)) {
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
                                                                     if (this$askCompleteTime == null
                                                                        ? other$askCompleteTime == null
                                                                        : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                        Object this$mesBuildingAssistDetailDTOS = this.getMesBuildingAssistDetailDTOS();
                                                                        Object other$mesBuildingAssistDetailDTOS = other.getMesBuildingAssistDetailDTOS();
                                                                        if (this$mesBuildingAssistDetailDTOS == null
                                                                           ? other$mesBuildingAssistDetailDTOS == null
                                                                           : this$mesBuildingAssistDetailDTOS.equals(other$mesBuildingAssistDetailDTOS)) {
                                                                           Object this$numberList = this.getNumberList();
                                                                           Object other$numberList = other.getNumberList();
                                                                           return this$numberList == null
                                                                              ? other$numberList == null
                                                                              : this$numberList.equals(other$numberList);
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
      return other instanceof MesBuildingAssistProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $booleanAssist = this.getBooleanAssist();
      result = result * 59 + ($booleanAssist == null ? 43 : $booleanAssist.hashCode());
      Object $totalAssistQuantity = this.getTotalAssistQuantity();
      result = result * 59 + ($totalAssistQuantity == null ? 43 : $totalAssistQuantity.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $boolOnecode = this.getBoolOnecode();
      result = result * 59 + ($boolOnecode == null ? 43 : $boolOnecode.hashCode());
      Object $boolOperations = this.getBoolOperations();
      result = result * 59 + ($boolOperations == null ? 43 : $boolOperations.hashCode());
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
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
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $mesBuildingAssistDetailDTOS = this.getMesBuildingAssistDetailDTOS();
      result = result * 59 + ($mesBuildingAssistDetailDTOS == null ? 43 : $mesBuildingAssistDetailDTOS.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   public static class MesBuildingAssistProductDTOBuilder {
      private Long id;
      private Long taskId;
      private Long productId;
      private AreaDetailDO area;
      private NameInfo monomer;
      private Integer taskTypeEnum;
      private IdAndNameDO config;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private IdAndNameDO process;
      private QuantityAndWeightDetailDO totalTaskMete;
      private QuantityAndWeightDetailDO totalCompleteMete;
      private QuantityAndWeightDetailDO totalCanAssistMete;
      private LocalDateTime askCompleteTime;
      private Boolean booleanAssist;
      private Integer totalAssistQuantity;
      private Integer factoryId;
      private Integer sequence;
      private List<MesBuildingAssistDetailDTO> mesBuildingAssistDetailDTOS;
      private Boolean boolOnecode;
      private List<Integer> numberList;
      private Boolean boolOperations;
      private Long artifactTaskId;

      MesBuildingAssistProductDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("area")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("monomer")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("config")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder config(final IdAndNameDO config) {
         this.config = config;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("process")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("totalTaskMete")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder totalTaskMete(final QuantityAndWeightDetailDO totalTaskMete) {
         this.totalTaskMete = totalTaskMete;
         return this;
      }

      @JsonProperty("totalCompleteMete")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder totalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
         this.totalCompleteMete = totalCompleteMete;
         return this;
      }

      @JsonProperty("totalCanAssistMete")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder totalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
         this.totalCanAssistMete = totalCanAssistMete;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("booleanAssist")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder booleanAssist(final Boolean booleanAssist) {
         this.booleanAssist = booleanAssist;
         return this;
      }

      @JsonProperty("totalAssistQuantity")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder totalAssistQuantity(final Integer totalAssistQuantity) {
         this.totalAssistQuantity = totalAssistQuantity;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder factoryId(final Integer factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("mesBuildingAssistDetailDTOS")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder mesBuildingAssistDetailDTOS(
         final List<MesBuildingAssistDetailDTO> mesBuildingAssistDetailDTOS
      ) {
         this.mesBuildingAssistDetailDTOS = mesBuildingAssistDetailDTOS;
         return this;
      }

      @JsonProperty("boolOnecode")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder boolOnecode(final Boolean boolOnecode) {
         this.boolOnecode = boolOnecode;
         return this;
      }

      @JsonProperty("numberList")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      @JsonProperty("boolOperations")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder boolOperations(final Boolean boolOperations) {
         this.boolOperations = boolOperations;
         return this;
      }

      @JsonProperty("artifactTaskId")
      public MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder artifactTaskId(final Long artifactTaskId) {
         this.artifactTaskId = artifactTaskId;
         return this;
      }

      public MesBuildingAssistProductDTO build() {
         return new MesBuildingAssistProductDTO(
            this.id,
            this.taskId,
            this.productId,
            this.area,
            this.monomer,
            this.taskTypeEnum,
            this.config,
            this.serialNumber,
            this.specification,
            this.length,
            this.process,
            this.totalTaskMete,
            this.totalCompleteMete,
            this.totalCanAssistMete,
            this.askCompleteTime,
            this.booleanAssist,
            this.totalAssistQuantity,
            this.factoryId,
            this.sequence,
            this.mesBuildingAssistDetailDTOS,
            this.boolOnecode,
            this.numberList,
            this.boolOperations,
            this.artifactTaskId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssistProductDTO.MesBuildingAssistProductDTOBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", productId="
            + this.productId
            + ", area="
            + this.area
            + ", monomer="
            + this.monomer
            + ", taskTypeEnum="
            + this.taskTypeEnum
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
            + ", booleanAssist="
            + this.booleanAssist
            + ", totalAssistQuantity="
            + this.totalAssistQuantity
            + ", factoryId="
            + this.factoryId
            + ", sequence="
            + this.sequence
            + ", mesBuildingAssistDetailDTOS="
            + this.mesBuildingAssistDetailDTOS
            + ", boolOnecode="
            + this.boolOnecode
            + ", numberList="
            + this.numberList
            + ", boolOperations="
            + this.boolOperations
            + ", artifactTaskId="
            + this.artifactTaskId
            + ")";
      }
   }
}
