package com.hzchum.scim.cut.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CutTaskProject对象", description = "")
@Entity
@TableName("cut_task_project")
@Table(name = "cut_task_project")
public class CutTaskProject extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "areaName")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   @TableField("area_name")
   @Column(name = "area_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String areaName;
   @ApiModelProperty(name = "areaNum")
   @JsonProperty("areaNum")
   @JSONField(name = "areaNum")
   @TableField("area_num")
   @Column(name = "area_num", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer areaNum;
   @ApiModelProperty(name = "cutTaskId")
   @JsonProperty("cutTaskId")
   @JSONField(name = "cutTaskId")
   @TableField("cut_task_id")
   @Column(name = "cut_task_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String cutTaskId;
   @ApiModelProperty(name = "cutTaskName")
   @JsonProperty("cutTaskName")
   @JSONField(name = "cutTaskName")
   @TableField("cut_task_name")
   @Column(name = "cut_task_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String cutTaskName;
   @ApiModelProperty(name = "material")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String material;
   @ApiModelProperty(name = "monomerName")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   @TableField("monomer_name")
   @Column(name = "monomer_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String monomerName;
   @ApiModelProperty(name = "monomerNum")
   @JsonProperty("monomerNum")
   @JSONField(name = "monomerNum")
   @TableField("monomer_num")
   @Column(name = "monomer_num", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer monomerNum;
   @ApiModelProperty(name = "projectId")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "projectName")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   @TableField("project_name")
   @Column(name = "project_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String projectName;
   @ApiModelProperty(name = "reduce")
   @JsonProperty("reduce")
   @JSONField(name = "reduce")
   @TableField("reduce")
   @Column(name = "reduce", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal reduce;
   @ApiModelProperty(name = "relationType")
   @JsonProperty("relationType")
   @JSONField(name = "relationType")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer relationType;
   @ApiModelProperty(name = "state", value = "0 初始状态  1已投料  2", notes = "0 初始状态  1已投料  2")
   @JsonProperty("state")
   @JSONField(name = "state")
   @TableField("state")
   @Column(name = "state", columnDefinition = "varchar(255) default '0' COMMENT '0 初始状态  1已投料  2'", nullable = true)
   private String state;
   @ApiModelProperty(name = "sum")
   @JsonProperty("sum")
   @JSONField(name = "sum")
   @TableField("sum")
   @Column(name = "sum", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer sum;
   @ApiModelProperty(name = "thick")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @TableField("thick")
   @Column(name = "thick", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String thick;
   @ApiModelProperty(name = "totalNum")
   @JsonProperty("totalNum")
   @JSONField(name = "totalNum")
   @TableField("total_num")
   @Column(name = "total_num", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer totalNum;
   @ApiModelProperty(name = "totalWeight")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   @TableField("total_weight")
   @Column(name = "total_weight", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "nestingState")
   @JsonProperty("nestingState")
   @JSONField(name = "nestingState")
   @TableField("nesting_state")
   @Column(name = "nesting_state", columnDefinition = "int default '0' COMMENT ''", nullable = true)
   private Integer nestingState;
   @ApiModelProperty(name = "areaId")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "monomerId")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaList")
   @JsonProperty("areaList")
   @JSONField(name = "areaList")
   @TableField("area_list")
   @Column(name = "area_list", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String areaList;
   @ApiModelProperty(name = "monomerList")
   @JsonProperty("monomerList")
   @JSONField(name = "monomerList")
   @TableField("monomer_list")
   @Column(name = "monomer_list", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String monomerList;
   @ApiModelProperty(name = "packNum")
   @JsonProperty("packNum")
   @JSONField(name = "packNum")
   @TableField("pack_num")
   @Column(name = "pack_num", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer packNum;
   @ApiModelProperty(name = "packWeight")
   @JsonProperty("packWeight")
   @JSONField(name = "packWeight")
   @TableField("pack_weight")
   @Column(name = "pack_weight", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal packWeight;
   @ApiModelProperty(name = "importTime")
   @JsonProperty("importTime")
   @JSONField(name = "importTime")
   @TableField("import_time")
   @Column(name = "import_time", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String importTime;
   @ApiModelProperty(name = "currentName")
   @JsonProperty("currentName")
   @JSONField(name = "currentName")
   @TableField("current_name")
   @Column(name = "current_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String currentName;
   @ApiModelProperty(name = "plateNum")
   @JsonProperty("plateNum")
   @JSONField(name = "plateNum")
   @TableField("plate_num")
   @Column(name = "plate_num", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer plateNum;
   @ApiModelProperty(name = "plateWeight")
   @JsonProperty("plateWeight")
   @JSONField(name = "plateWeight")
   @TableField("plate_weight")
   @Column(name = "plate_weight", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal plateWeight;
   @ApiModelProperty(name = "projectNumber")
   @JsonProperty("projectNumber")
   @JSONField(name = "projectNumber")
   @TableField("project_number")
   @Column(name = "project_number", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String projectNumber;

   public static CutTaskProject.CutTaskProjectBuilder builder() {
      return new CutTaskProject.CutTaskProjectBuilder();
   }

   public CutTaskProject() {
   }

   public CutTaskProject(
      final Long id,
      final String areaName,
      final Integer areaNum,
      final String cutTaskId,
      final String cutTaskName,
      final String material,
      final String monomerName,
      final Integer monomerNum,
      final Long projectId,
      final String projectName,
      final BigDecimal reduce,
      final Integer relationType,
      final String state,
      final Integer sum,
      final String thick,
      final Integer totalNum,
      final BigDecimal totalWeight,
      final Integer nestingState,
      final Long areaId,
      final Long monomerId,
      final String areaList,
      final String monomerList,
      final Integer packNum,
      final BigDecimal packWeight,
      final String importTime,
      final String currentName,
      final Integer plateNum,
      final BigDecimal plateWeight,
      final String projectNumber
   ) {
      this.id = id;
      this.areaName = areaName;
      this.areaNum = areaNum;
      this.cutTaskId = cutTaskId;
      this.cutTaskName = cutTaskName;
      this.material = material;
      this.monomerName = monomerName;
      this.monomerNum = monomerNum;
      this.projectId = projectId;
      this.projectName = projectName;
      this.reduce = reduce;
      this.relationType = relationType;
      this.state = state;
      this.sum = sum;
      this.thick = thick;
      this.totalNum = totalNum;
      this.totalWeight = totalWeight;
      this.nestingState = nestingState;
      this.areaId = areaId;
      this.monomerId = monomerId;
      this.areaList = areaList;
      this.monomerList = monomerList;
      this.packNum = packNum;
      this.packWeight = packWeight;
      this.importTime = importTime;
      this.currentName = currentName;
      this.plateNum = plateNum;
      this.plateWeight = plateWeight;
      this.projectNumber = projectNumber;
   }

   public Long getId() {
      return this.id;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Integer getAreaNum() {
      return this.areaNum;
   }

   public String getCutTaskId() {
      return this.cutTaskId;
   }

   public String getCutTaskName() {
      return this.cutTaskName;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Integer getMonomerNum() {
      return this.monomerNum;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getReduce() {
      return this.reduce;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public String getState() {
      return this.state;
   }

   public Integer getSum() {
      return this.sum;
   }

   public String getThick() {
      return this.thick;
   }

   public Integer getTotalNum() {
      return this.totalNum;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public Integer getNestingState() {
      return this.nestingState;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getAreaList() {
      return this.areaList;
   }

   public String getMonomerList() {
      return this.monomerList;
   }

   public Integer getPackNum() {
      return this.packNum;
   }

   public BigDecimal getPackWeight() {
      return this.packWeight;
   }

   public String getImportTime() {
      return this.importTime;
   }

   public String getCurrentName() {
      return this.currentName;
   }

   public Integer getPlateNum() {
      return this.plateNum;
   }

   public BigDecimal getPlateWeight() {
      return this.plateWeight;
   }

   public String getProjectNumber() {
      return this.projectNumber;
   }

   @JsonProperty("id")
   public CutTaskProject setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("areaName")
   public CutTaskProject setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("areaNum")
   public CutTaskProject setAreaNum(final Integer areaNum) {
      this.areaNum = areaNum;
      return this;
   }

   @JsonProperty("cutTaskId")
   public CutTaskProject setCutTaskId(final String cutTaskId) {
      this.cutTaskId = cutTaskId;
      return this;
   }

   @JsonProperty("cutTaskName")
   public CutTaskProject setCutTaskName(final String cutTaskName) {
      this.cutTaskName = cutTaskName;
      return this;
   }

   @JsonProperty("material")
   public CutTaskProject setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("monomerName")
   public CutTaskProject setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("monomerNum")
   public CutTaskProject setMonomerNum(final Integer monomerNum) {
      this.monomerNum = monomerNum;
      return this;
   }

   @JsonProperty("projectId")
   public CutTaskProject setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("projectName")
   public CutTaskProject setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("reduce")
   public CutTaskProject setReduce(final BigDecimal reduce) {
      this.reduce = reduce;
      return this;
   }

   @JsonProperty("relationType")
   public CutTaskProject setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   @JsonProperty("state")
   public CutTaskProject setState(final String state) {
      this.state = state;
      return this;
   }

   @JsonProperty("sum")
   public CutTaskProject setSum(final Integer sum) {
      this.sum = sum;
      return this;
   }

   @JsonProperty("thick")
   public CutTaskProject setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("totalNum")
   public CutTaskProject setTotalNum(final Integer totalNum) {
      this.totalNum = totalNum;
      return this;
   }

   @JsonProperty("totalWeight")
   public CutTaskProject setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("nestingState")
   public CutTaskProject setNestingState(final Integer nestingState) {
      this.nestingState = nestingState;
      return this;
   }

   @JsonProperty("areaId")
   public CutTaskProject setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("monomerId")
   public CutTaskProject setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaList")
   public CutTaskProject setAreaList(final String areaList) {
      this.areaList = areaList;
      return this;
   }

   @JsonProperty("monomerList")
   public CutTaskProject setMonomerList(final String monomerList) {
      this.monomerList = monomerList;
      return this;
   }

   @JsonProperty("packNum")
   public CutTaskProject setPackNum(final Integer packNum) {
      this.packNum = packNum;
      return this;
   }

   @JsonProperty("packWeight")
   public CutTaskProject setPackWeight(final BigDecimal packWeight) {
      this.packWeight = packWeight;
      return this;
   }

   @JsonProperty("importTime")
   public CutTaskProject setImportTime(final String importTime) {
      this.importTime = importTime;
      return this;
   }

   @JsonProperty("currentName")
   public CutTaskProject setCurrentName(final String currentName) {
      this.currentName = currentName;
      return this;
   }

   @JsonProperty("plateNum")
   public CutTaskProject setPlateNum(final Integer plateNum) {
      this.plateNum = plateNum;
      return this;
   }

   @JsonProperty("plateWeight")
   public CutTaskProject setPlateWeight(final BigDecimal plateWeight) {
      this.plateWeight = plateWeight;
      return this;
   }

   @JsonProperty("projectNumber")
   public CutTaskProject setProjectNumber(final String projectNumber) {
      this.projectNumber = projectNumber;
      return this;
   }

   @Override
   public String toString() {
      return "CutTaskProject(id="
         + this.getId()
         + ", areaName="
         + this.getAreaName()
         + ", areaNum="
         + this.getAreaNum()
         + ", cutTaskId="
         + this.getCutTaskId()
         + ", cutTaskName="
         + this.getCutTaskName()
         + ", material="
         + this.getMaterial()
         + ", monomerName="
         + this.getMonomerName()
         + ", monomerNum="
         + this.getMonomerNum()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", reduce="
         + this.getReduce()
         + ", relationType="
         + this.getRelationType()
         + ", state="
         + this.getState()
         + ", sum="
         + this.getSum()
         + ", thick="
         + this.getThick()
         + ", totalNum="
         + this.getTotalNum()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", nestingState="
         + this.getNestingState()
         + ", areaId="
         + this.getAreaId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaList="
         + this.getAreaList()
         + ", monomerList="
         + this.getMonomerList()
         + ", packNum="
         + this.getPackNum()
         + ", packWeight="
         + this.getPackWeight()
         + ", importTime="
         + this.getImportTime()
         + ", currentName="
         + this.getCurrentName()
         + ", plateNum="
         + this.getPlateNum()
         + ", plateWeight="
         + this.getPlateWeight()
         + ", projectNumber="
         + this.getProjectNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutTaskProject)) {
         return false;
      }

      CutTaskProject other = (CutTaskProject)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$areaNum = this.getAreaNum();
         Object other$areaNum = other.getAreaNum();
         if (this$areaNum == null ? other$areaNum == null : this$areaNum.equals(other$areaNum)) {
            Object this$monomerNum = this.getMonomerNum();
            Object other$monomerNum = other.getMonomerNum();
            if (this$monomerNum == null ? other$monomerNum == null : this$monomerNum.equals(other$monomerNum)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$relationType = this.getRelationType();
                  Object other$relationType = other.getRelationType();
                  if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                     Object this$sum = this.getSum();
                     Object other$sum = other.getSum();
                     if (this$sum == null ? other$sum == null : this$sum.equals(other$sum)) {
                        Object this$totalNum = this.getTotalNum();
                        Object other$totalNum = other.getTotalNum();
                        if (this$totalNum == null ? other$totalNum == null : this$totalNum.equals(other$totalNum)) {
                           Object this$nestingState = this.getNestingState();
                           Object other$nestingState = other.getNestingState();
                           if (this$nestingState == null ? other$nestingState == null : this$nestingState.equals(other$nestingState)) {
                              Object this$areaId = this.getAreaId();
                              Object other$areaId = other.getAreaId();
                              if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                 Object this$monomerId = this.getMonomerId();
                                 Object other$monomerId = other.getMonomerId();
                                 if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                    Object this$packNum = this.getPackNum();
                                    Object other$packNum = other.getPackNum();
                                    if (this$packNum == null ? other$packNum == null : this$packNum.equals(other$packNum)) {
                                       Object this$plateNum = this.getPlateNum();
                                       Object other$plateNum = other.getPlateNum();
                                       if (this$plateNum == null ? other$plateNum == null : this$plateNum.equals(other$plateNum)) {
                                          Object this$areaName = this.getAreaName();
                                          Object other$areaName = other.getAreaName();
                                          if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                             Object this$cutTaskId = this.getCutTaskId();
                                             Object other$cutTaskId = other.getCutTaskId();
                                             if (this$cutTaskId == null ? other$cutTaskId == null : this$cutTaskId.equals(other$cutTaskId)) {
                                                Object this$cutTaskName = this.getCutTaskName();
                                                Object other$cutTaskName = other.getCutTaskName();
                                                if (this$cutTaskName == null ? other$cutTaskName == null : this$cutTaskName.equals(other$cutTaskName)) {
                                                   Object this$material = this.getMaterial();
                                                   Object other$material = other.getMaterial();
                                                   if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                      Object this$monomerName = this.getMonomerName();
                                                      Object other$monomerName = other.getMonomerName();
                                                      if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                                         Object this$projectName = this.getProjectName();
                                                         Object other$projectName = other.getProjectName();
                                                         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                            Object this$reduce = this.getReduce();
                                                            Object other$reduce = other.getReduce();
                                                            if (this$reduce == null ? other$reduce == null : this$reduce.equals(other$reduce)) {
                                                               Object this$state = this.getState();
                                                               Object other$state = other.getState();
                                                               if (this$state == null ? other$state == null : this$state.equals(other$state)) {
                                                                  Object this$thick = this.getThick();
                                                                  Object other$thick = other.getThick();
                                                                  if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                                     Object this$totalWeight = this.getTotalWeight();
                                                                     Object other$totalWeight = other.getTotalWeight();
                                                                     if (this$totalWeight == null
                                                                        ? other$totalWeight == null
                                                                        : this$totalWeight.equals(other$totalWeight)) {
                                                                        Object this$areaList = this.getAreaList();
                                                                        Object other$areaList = other.getAreaList();
                                                                        if (this$areaList == null
                                                                           ? other$areaList == null
                                                                           : this$areaList.equals(other$areaList)) {
                                                                           Object this$monomerList = this.getMonomerList();
                                                                           Object other$monomerList = other.getMonomerList();
                                                                           if (this$monomerList == null
                                                                              ? other$monomerList == null
                                                                              : this$monomerList.equals(other$monomerList)) {
                                                                              Object this$packWeight = this.getPackWeight();
                                                                              Object other$packWeight = other.getPackWeight();
                                                                              if (this$packWeight == null
                                                                                 ? other$packWeight == null
                                                                                 : this$packWeight.equals(other$packWeight)) {
                                                                                 Object this$importTime = this.getImportTime();
                                                                                 Object other$importTime = other.getImportTime();
                                                                                 if (this$importTime == null
                                                                                    ? other$importTime == null
                                                                                    : this$importTime.equals(other$importTime)) {
                                                                                    Object this$currentName = this.getCurrentName();
                                                                                    Object other$currentName = other.getCurrentName();
                                                                                    if (this$currentName == null
                                                                                       ? other$currentName == null
                                                                                       : this$currentName.equals(other$currentName)) {
                                                                                       Object this$plateWeight = this.getPlateWeight();
                                                                                       Object other$plateWeight = other.getPlateWeight();
                                                                                       if (this$plateWeight == null
                                                                                          ? other$plateWeight == null
                                                                                          : this$plateWeight.equals(other$plateWeight)) {
                                                                                          Object this$projectNumber = this.getProjectNumber();
                                                                                          Object other$projectNumber = other.getProjectNumber();
                                                                                          return this$projectNumber == null
                                                                                             ? other$projectNumber == null
                                                                                             : this$projectNumber.equals(other$projectNumber);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CutTaskProject;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $areaNum = this.getAreaNum();
      result = result * 59 + ($areaNum == null ? 43 : $areaNum.hashCode());
      Object $monomerNum = this.getMonomerNum();
      result = result * 59 + ($monomerNum == null ? 43 : $monomerNum.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $sum = this.getSum();
      result = result * 59 + ($sum == null ? 43 : $sum.hashCode());
      Object $totalNum = this.getTotalNum();
      result = result * 59 + ($totalNum == null ? 43 : $totalNum.hashCode());
      Object $nestingState = this.getNestingState();
      result = result * 59 + ($nestingState == null ? 43 : $nestingState.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $packNum = this.getPackNum();
      result = result * 59 + ($packNum == null ? 43 : $packNum.hashCode());
      Object $plateNum = this.getPlateNum();
      result = result * 59 + ($plateNum == null ? 43 : $plateNum.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $cutTaskId = this.getCutTaskId();
      result = result * 59 + ($cutTaskId == null ? 43 : $cutTaskId.hashCode());
      Object $cutTaskName = this.getCutTaskName();
      result = result * 59 + ($cutTaskName == null ? 43 : $cutTaskName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $reduce = this.getReduce();
      result = result * 59 + ($reduce == null ? 43 : $reduce.hashCode());
      Object $state = this.getState();
      result = result * 59 + ($state == null ? 43 : $state.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $areaList = this.getAreaList();
      result = result * 59 + ($areaList == null ? 43 : $areaList.hashCode());
      Object $monomerList = this.getMonomerList();
      result = result * 59 + ($monomerList == null ? 43 : $monomerList.hashCode());
      Object $packWeight = this.getPackWeight();
      result = result * 59 + ($packWeight == null ? 43 : $packWeight.hashCode());
      Object $importTime = this.getImportTime();
      result = result * 59 + ($importTime == null ? 43 : $importTime.hashCode());
      Object $currentName = this.getCurrentName();
      result = result * 59 + ($currentName == null ? 43 : $currentName.hashCode());
      Object $plateWeight = this.getPlateWeight();
      result = result * 59 + ($plateWeight == null ? 43 : $plateWeight.hashCode());
      Object $projectNumber = this.getProjectNumber();
      return result * 59 + ($projectNumber == null ? 43 : $projectNumber.hashCode());
   }

   public static class CutTaskProjectBuilder {
      private Long id;
      private String areaName;
      private Integer areaNum;
      private String cutTaskId;
      private String cutTaskName;
      private String material;
      private String monomerName;
      private Integer monomerNum;
      private Long projectId;
      private String projectName;
      private BigDecimal reduce;
      private Integer relationType;
      private String state;
      private Integer sum;
      private String thick;
      private Integer totalNum;
      private BigDecimal totalWeight;
      private Integer nestingState;
      private Long areaId;
      private Long monomerId;
      private String areaList;
      private String monomerList;
      private Integer packNum;
      private BigDecimal packWeight;
      private String importTime;
      private String currentName;
      private Integer plateNum;
      private BigDecimal plateWeight;
      private String projectNumber;

      CutTaskProjectBuilder() {
      }

      @JsonProperty("id")
      public CutTaskProject.CutTaskProjectBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("areaName")
      public CutTaskProject.CutTaskProjectBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("areaNum")
      public CutTaskProject.CutTaskProjectBuilder areaNum(final Integer areaNum) {
         this.areaNum = areaNum;
         return this;
      }

      @JsonProperty("cutTaskId")
      public CutTaskProject.CutTaskProjectBuilder cutTaskId(final String cutTaskId) {
         this.cutTaskId = cutTaskId;
         return this;
      }

      @JsonProperty("cutTaskName")
      public CutTaskProject.CutTaskProjectBuilder cutTaskName(final String cutTaskName) {
         this.cutTaskName = cutTaskName;
         return this;
      }

      @JsonProperty("material")
      public CutTaskProject.CutTaskProjectBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("monomerName")
      public CutTaskProject.CutTaskProjectBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("monomerNum")
      public CutTaskProject.CutTaskProjectBuilder monomerNum(final Integer monomerNum) {
         this.monomerNum = monomerNum;
         return this;
      }

      @JsonProperty("projectId")
      public CutTaskProject.CutTaskProjectBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("projectName")
      public CutTaskProject.CutTaskProjectBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("reduce")
      public CutTaskProject.CutTaskProjectBuilder reduce(final BigDecimal reduce) {
         this.reduce = reduce;
         return this;
      }

      @JsonProperty("relationType")
      public CutTaskProject.CutTaskProjectBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      @JsonProperty("state")
      public CutTaskProject.CutTaskProjectBuilder state(final String state) {
         this.state = state;
         return this;
      }

      @JsonProperty("sum")
      public CutTaskProject.CutTaskProjectBuilder sum(final Integer sum) {
         this.sum = sum;
         return this;
      }

      @JsonProperty("thick")
      public CutTaskProject.CutTaskProjectBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("totalNum")
      public CutTaskProject.CutTaskProjectBuilder totalNum(final Integer totalNum) {
         this.totalNum = totalNum;
         return this;
      }

      @JsonProperty("totalWeight")
      public CutTaskProject.CutTaskProjectBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("nestingState")
      public CutTaskProject.CutTaskProjectBuilder nestingState(final Integer nestingState) {
         this.nestingState = nestingState;
         return this;
      }

      @JsonProperty("areaId")
      public CutTaskProject.CutTaskProjectBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("monomerId")
      public CutTaskProject.CutTaskProjectBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaList")
      public CutTaskProject.CutTaskProjectBuilder areaList(final String areaList) {
         this.areaList = areaList;
         return this;
      }

      @JsonProperty("monomerList")
      public CutTaskProject.CutTaskProjectBuilder monomerList(final String monomerList) {
         this.monomerList = monomerList;
         return this;
      }

      @JsonProperty("packNum")
      public CutTaskProject.CutTaskProjectBuilder packNum(final Integer packNum) {
         this.packNum = packNum;
         return this;
      }

      @JsonProperty("packWeight")
      public CutTaskProject.CutTaskProjectBuilder packWeight(final BigDecimal packWeight) {
         this.packWeight = packWeight;
         return this;
      }

      @JsonProperty("importTime")
      public CutTaskProject.CutTaskProjectBuilder importTime(final String importTime) {
         this.importTime = importTime;
         return this;
      }

      @JsonProperty("currentName")
      public CutTaskProject.CutTaskProjectBuilder currentName(final String currentName) {
         this.currentName = currentName;
         return this;
      }

      @JsonProperty("plateNum")
      public CutTaskProject.CutTaskProjectBuilder plateNum(final Integer plateNum) {
         this.plateNum = plateNum;
         return this;
      }

      @JsonProperty("plateWeight")
      public CutTaskProject.CutTaskProjectBuilder plateWeight(final BigDecimal plateWeight) {
         this.plateWeight = plateWeight;
         return this;
      }

      @JsonProperty("projectNumber")
      public CutTaskProject.CutTaskProjectBuilder projectNumber(final String projectNumber) {
         this.projectNumber = projectNumber;
         return this;
      }

      public CutTaskProject build() {
         return new CutTaskProject(
            this.id,
            this.areaName,
            this.areaNum,
            this.cutTaskId,
            this.cutTaskName,
            this.material,
            this.monomerName,
            this.monomerNum,
            this.projectId,
            this.projectName,
            this.reduce,
            this.relationType,
            this.state,
            this.sum,
            this.thick,
            this.totalNum,
            this.totalWeight,
            this.nestingState,
            this.areaId,
            this.monomerId,
            this.areaList,
            this.monomerList,
            this.packNum,
            this.packWeight,
            this.importTime,
            this.currentName,
            this.plateNum,
            this.plateWeight,
            this.projectNumber
         );
      }

      @Override
      public String toString() {
         return "CutTaskProject.CutTaskProjectBuilder(id="
            + this.id
            + ", areaName="
            + this.areaName
            + ", areaNum="
            + this.areaNum
            + ", cutTaskId="
            + this.cutTaskId
            + ", cutTaskName="
            + this.cutTaskName
            + ", material="
            + this.material
            + ", monomerName="
            + this.monomerName
            + ", monomerNum="
            + this.monomerNum
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", reduce="
            + this.reduce
            + ", relationType="
            + this.relationType
            + ", state="
            + this.state
            + ", sum="
            + this.sum
            + ", thick="
            + this.thick
            + ", totalNum="
            + this.totalNum
            + ", totalWeight="
            + this.totalWeight
            + ", nestingState="
            + this.nestingState
            + ", areaId="
            + this.areaId
            + ", monomerId="
            + this.monomerId
            + ", areaList="
            + this.areaList
            + ", monomerList="
            + this.monomerList
            + ", packNum="
            + this.packNum
            + ", packWeight="
            + this.packWeight
            + ", importTime="
            + this.importTime
            + ", currentName="
            + this.currentName
            + ", plateNum="
            + this.plateNum
            + ", plateWeight="
            + this.plateWeight
            + ", projectNumber="
            + this.projectNumber
            + ")";
      }
   }
}
