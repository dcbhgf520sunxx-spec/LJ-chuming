package com.hzchum.scim.project.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ProjectConstructionLog对象", description = "施工日志表 ")
@Entity
@TableName("project_construction_log")
@Table(name = "project_construction_log")
@org.hibernate.annotations.Table(appliesTo = "project_construction_log", comment = "施工日志表 ")
public class ProjectConstructionLog extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "constructionDate", value = "施工日期", notes = "施工日期")
   @JsonProperty("constructionDate")
   @JSONField(name = "constructionDate")
   @TableField("construction_date")
   @Column(name = "construction_date", columnDefinition = "date  COMMENT '施工日期'", nullable = false)
   private LocalDate constructionDate;
   @ApiModelProperty(name = "morningWeather", value = "上午天气", notes = "上午天气")
   @JsonProperty("morningWeather")
   @JSONField(name = "morningWeather")
   @TableField("morning_weather")
   @Column(name = "morning_weather", columnDefinition = "varchar(255)  COMMENT '上午天气'")
   private String morningWeather;
   @ApiModelProperty(name = "afternoonWeather", value = "下午天气", notes = "下午天气")
   @JsonProperty("afternoonWeather")
   @JSONField(name = "afternoonWeather")
   @TableField("afternoon_weather")
   @Column(name = "afternoon_weather", columnDefinition = "varchar(255)  COMMENT '下午天气'")
   private String afternoonWeather;
   @ApiModelProperty(name = "morningWind", value = "上午风力", notes = "上午风力")
   @JsonProperty("morningWind")
   @JSONField(name = "morningWind")
   @TableField("morning_wind")
   @Column(name = "morning_wind", columnDefinition = "varchar(255)  COMMENT '上午风力'")
   private String morningWind;
   @ApiModelProperty(name = "afternoonWind", value = "下午风力", notes = "下午风力")
   @JsonProperty("afternoonWind")
   @JSONField(name = "afternoonWind")
   @TableField("afternoon_wind")
   @Column(name = "afternoon_wind", columnDefinition = "varchar(255)  COMMENT '下午风力'")
   private String afternoonWind;
   @ApiModelProperty(name = "morningTemperature", value = "上午温度", notes = "上午温度")
   @JsonProperty("morningTemperature")
   @JSONField(name = "morningTemperature")
   @TableField("morning_temperature")
   @Column(name = "morning_temperature", columnDefinition = "varchar(255)  COMMENT '上午温度'")
   private String morningTemperature;
   @ApiModelProperty(name = "afternoonTemperature", value = "下午温度", notes = "下午温度")
   @JsonProperty("afternoonTemperature")
   @JSONField(name = "afternoonTemperature")
   @TableField("afternoon_temperature")
   @Column(name = "afternoon_temperature", columnDefinition = "varchar(255)  COMMENT '下午温度'")
   private String afternoonTemperature;
   @ApiModelProperty(name = "constructionDesc", value = "施工部分描述", notes = "施工部分描述")
   @JsonProperty("constructionDesc")
   @JSONField(name = "constructionDesc")
   @TableField("construction_desc")
   @Column(name = "construction_desc", columnDefinition = "varchar(1024)  COMMENT '施工部分描述'")
   private String constructionDesc;
   @ApiModelProperty(name = "machineWorkDesc", value = "机械作业描述", notes = "机械作业描述")
   @JsonProperty("machineWorkDesc")
   @JSONField(name = "machineWorkDesc")
   @TableField("machine_work_desc")
   @Column(name = "machine_work_desc", columnDefinition = "varchar(1024)  COMMENT '机械作业描述'")
   private String machineWorkDesc;
   @ApiModelProperty(name = "groupWorkDesc", value = "班组上岗情况", notes = "班组上岗情况")
   @JsonProperty("groupWorkDesc")
   @JSONField(name = "groupWorkDesc")
   @TableField("group_work_desc")
   @Column(name = "group_work_desc", columnDefinition = "varchar(1024)  COMMENT '班组上岗情况'")
   private String groupWorkDesc;
   @ApiModelProperty(name = "qualityInspectionDesc", value = "质量检查情况", notes = "质量检查情况")
   @JsonProperty("qualityInspectionDesc")
   @JSONField(name = "qualityInspectionDesc")
   @TableField("quality_inspection_desc")
   @Column(name = "quality_inspection_desc", columnDefinition = "varchar(1024)  COMMENT '质量检查情况'")
   private String qualityInspectionDesc;
   @ApiModelProperty(name = "safetyInspectionDesc", value = "安全检查情况", notes = "安全检查情况")
   @JsonProperty("safetyInspectionDesc")
   @JSONField(name = "safetyInspectionDesc")
   @TableField("safety_inspection_desc")
   @Column(name = "safety_inspection_desc", columnDefinition = "varchar(1024)  COMMENT '安全检查情况'")
   private String safetyInspectionDesc;
   @ApiModelProperty(name = "siteImportantEvent", value = "工地重大事件", notes = "工地重大事件")
   @JsonProperty("siteImportantEvent")
   @JSONField(name = "siteImportantEvent")
   @TableField("site_important_event")
   @Column(name = "site_important_event", columnDefinition = "varchar(1024)  COMMENT '工地重大事件'")
   private String siteImportantEvent;
   @ApiModelProperty(name = "existingProblemDesc", value = "存在问题描述", notes = "存在问题描述")
   @JsonProperty("existingProblemDesc")
   @JSONField(name = "existingProblemDesc")
   @TableField("existing_problem_desc")
   @Column(name = "existing_problem_desc", columnDefinition = "varchar(1024)  COMMENT '存在问题描述'")
   private String existingProblemDesc;
   @ApiModelProperty(name = "recorderId", value = "记录用户id", notes = "记录用户id")
   @TableField("recorder_id")
   @Column(name = "recorder_id", columnDefinition = "bigint(20)  COMMENT '记录用户id'", nullable = false)
   private Long recorderId;
   @ApiModelProperty(name = "recorderName", value = "记录用户", notes = "记录用户")
   @TableField("recorder_name")
   @Column(name = "recorder_name", columnDefinition = "varchar(64)  COMMENT '记录用户'")
   private String recorderName;
   @ApiModelProperty(name = "managerId", value = "负责人id", notes = "负责人id")
   @JsonProperty("managerId")
   @JSONField(name = "managerId")
   @TableField("manager_id")
   @Column(name = "manager_id", columnDefinition = "bigint(20)  COMMENT '负责人id'", nullable = false)
   private Long managerId;
   @ApiModelProperty(name = "managerName", value = "负责人", notes = "负责人")
   @JsonProperty("managerName")
   @JSONField(name = "managerName")
   @TableField("manager_name")
   @Column(name = "manager_name", columnDefinition = "varchar(64)  COMMENT '负责人'", nullable = true)
   private String managerName;
   @ApiModelProperty(name = "userId", value = "填写人id", notes = "填写人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '填写人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "填写人", notes = "填写人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(64)  COMMENT '填写人'")
   private String userName;

   public static ProjectConstructionLog.ProjectConstructionLogBuilder builder() {
      return new ProjectConstructionLog.ProjectConstructionLogBuilder();
   }

   public ProjectConstructionLog() {
   }

   public ProjectConstructionLog(
      final Long id,
      final Long projectId,
      final LocalDate constructionDate,
      final String morningWeather,
      final String afternoonWeather,
      final String morningWind,
      final String afternoonWind,
      final String morningTemperature,
      final String afternoonTemperature,
      final String constructionDesc,
      final String machineWorkDesc,
      final String groupWorkDesc,
      final String qualityInspectionDesc,
      final String safetyInspectionDesc,
      final String siteImportantEvent,
      final String existingProblemDesc,
      final Long recorderId,
      final String recorderName,
      final Long managerId,
      final String managerName,
      final Long userId,
      final String userName
   ) {
      this.id = id;
      this.projectId = projectId;
      this.constructionDate = constructionDate;
      this.morningWeather = morningWeather;
      this.afternoonWeather = afternoonWeather;
      this.morningWind = morningWind;
      this.afternoonWind = afternoonWind;
      this.morningTemperature = morningTemperature;
      this.afternoonTemperature = afternoonTemperature;
      this.constructionDesc = constructionDesc;
      this.machineWorkDesc = machineWorkDesc;
      this.groupWorkDesc = groupWorkDesc;
      this.qualityInspectionDesc = qualityInspectionDesc;
      this.safetyInspectionDesc = safetyInspectionDesc;
      this.siteImportantEvent = siteImportantEvent;
      this.existingProblemDesc = existingProblemDesc;
      this.recorderId = recorderId;
      this.recorderName = recorderName;
      this.managerId = managerId;
      this.managerName = managerName;
      this.userId = userId;
      this.userName = userName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDate getConstructionDate() {
      return this.constructionDate;
   }

   public String getMorningWeather() {
      return this.morningWeather;
   }

   public String getAfternoonWeather() {
      return this.afternoonWeather;
   }

   public String getMorningWind() {
      return this.morningWind;
   }

   public String getAfternoonWind() {
      return this.afternoonWind;
   }

   public String getMorningTemperature() {
      return this.morningTemperature;
   }

   public String getAfternoonTemperature() {
      return this.afternoonTemperature;
   }

   public String getConstructionDesc() {
      return this.constructionDesc;
   }

   public String getMachineWorkDesc() {
      return this.machineWorkDesc;
   }

   public String getGroupWorkDesc() {
      return this.groupWorkDesc;
   }

   public String getQualityInspectionDesc() {
      return this.qualityInspectionDesc;
   }

   public String getSafetyInspectionDesc() {
      return this.safetyInspectionDesc;
   }

   public String getSiteImportantEvent() {
      return this.siteImportantEvent;
   }

   public String getExistingProblemDesc() {
      return this.existingProblemDesc;
   }

   public Long getRecorderId() {
      return this.recorderId;
   }

   public String getRecorderName() {
      return this.recorderName;
   }

   public Long getManagerId() {
      return this.managerId;
   }

   public String getManagerName() {
      return this.managerName;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   @JsonProperty("id")
   public ProjectConstructionLog setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ProjectConstructionLog setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("constructionDate")
   public ProjectConstructionLog setConstructionDate(final LocalDate constructionDate) {
      this.constructionDate = constructionDate;
      return this;
   }

   @JsonProperty("morningWeather")
   public ProjectConstructionLog setMorningWeather(final String morningWeather) {
      this.morningWeather = morningWeather;
      return this;
   }

   @JsonProperty("afternoonWeather")
   public ProjectConstructionLog setAfternoonWeather(final String afternoonWeather) {
      this.afternoonWeather = afternoonWeather;
      return this;
   }

   @JsonProperty("morningWind")
   public ProjectConstructionLog setMorningWind(final String morningWind) {
      this.morningWind = morningWind;
      return this;
   }

   @JsonProperty("afternoonWind")
   public ProjectConstructionLog setAfternoonWind(final String afternoonWind) {
      this.afternoonWind = afternoonWind;
      return this;
   }

   @JsonProperty("morningTemperature")
   public ProjectConstructionLog setMorningTemperature(final String morningTemperature) {
      this.morningTemperature = morningTemperature;
      return this;
   }

   @JsonProperty("afternoonTemperature")
   public ProjectConstructionLog setAfternoonTemperature(final String afternoonTemperature) {
      this.afternoonTemperature = afternoonTemperature;
      return this;
   }

   @JsonProperty("constructionDesc")
   public ProjectConstructionLog setConstructionDesc(final String constructionDesc) {
      this.constructionDesc = constructionDesc;
      return this;
   }

   @JsonProperty("machineWorkDesc")
   public ProjectConstructionLog setMachineWorkDesc(final String machineWorkDesc) {
      this.machineWorkDesc = machineWorkDesc;
      return this;
   }

   @JsonProperty("groupWorkDesc")
   public ProjectConstructionLog setGroupWorkDesc(final String groupWorkDesc) {
      this.groupWorkDesc = groupWorkDesc;
      return this;
   }

   @JsonProperty("qualityInspectionDesc")
   public ProjectConstructionLog setQualityInspectionDesc(final String qualityInspectionDesc) {
      this.qualityInspectionDesc = qualityInspectionDesc;
      return this;
   }

   @JsonProperty("safetyInspectionDesc")
   public ProjectConstructionLog setSafetyInspectionDesc(final String safetyInspectionDesc) {
      this.safetyInspectionDesc = safetyInspectionDesc;
      return this;
   }

   @JsonProperty("siteImportantEvent")
   public ProjectConstructionLog setSiteImportantEvent(final String siteImportantEvent) {
      this.siteImportantEvent = siteImportantEvent;
      return this;
   }

   @JsonProperty("existingProblemDesc")
   public ProjectConstructionLog setExistingProblemDesc(final String existingProblemDesc) {
      this.existingProblemDesc = existingProblemDesc;
      return this;
   }

   public ProjectConstructionLog setRecorderId(final Long recorderId) {
      this.recorderId = recorderId;
      return this;
   }

   public ProjectConstructionLog setRecorderName(final String recorderName) {
      this.recorderName = recorderName;
      return this;
   }

   @JsonProperty("managerId")
   public ProjectConstructionLog setManagerId(final Long managerId) {
      this.managerId = managerId;
      return this;
   }

   @JsonProperty("managerName")
   public ProjectConstructionLog setManagerName(final String managerName) {
      this.managerName = managerName;
      return this;
   }

   @JsonProperty("userId")
   public ProjectConstructionLog setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public ProjectConstructionLog setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectConstructionLog(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", constructionDate="
         + this.getConstructionDate()
         + ", morningWeather="
         + this.getMorningWeather()
         + ", afternoonWeather="
         + this.getAfternoonWeather()
         + ", morningWind="
         + this.getMorningWind()
         + ", afternoonWind="
         + this.getAfternoonWind()
         + ", morningTemperature="
         + this.getMorningTemperature()
         + ", afternoonTemperature="
         + this.getAfternoonTemperature()
         + ", constructionDesc="
         + this.getConstructionDesc()
         + ", machineWorkDesc="
         + this.getMachineWorkDesc()
         + ", groupWorkDesc="
         + this.getGroupWorkDesc()
         + ", qualityInspectionDesc="
         + this.getQualityInspectionDesc()
         + ", safetyInspectionDesc="
         + this.getSafetyInspectionDesc()
         + ", siteImportantEvent="
         + this.getSiteImportantEvent()
         + ", existingProblemDesc="
         + this.getExistingProblemDesc()
         + ", recorderId="
         + this.getRecorderId()
         + ", recorderName="
         + this.getRecorderName()
         + ", managerId="
         + this.getManagerId()
         + ", managerName="
         + this.getManagerName()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectConstructionLog)) {
         return false;
      }

      ProjectConstructionLog other = (ProjectConstructionLog)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$recorderId = this.getRecorderId();
            Object other$recorderId = other.getRecorderId();
            if (this$recorderId == null ? other$recorderId == null : this$recorderId.equals(other$recorderId)) {
               Object this$managerId = this.getManagerId();
               Object other$managerId = other.getManagerId();
               if (this$managerId == null ? other$managerId == null : this$managerId.equals(other$managerId)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$constructionDate = this.getConstructionDate();
                     Object other$constructionDate = other.getConstructionDate();
                     if (this$constructionDate == null ? other$constructionDate == null : this$constructionDate.equals(other$constructionDate)) {
                        Object this$morningWeather = this.getMorningWeather();
                        Object other$morningWeather = other.getMorningWeather();
                        if (this$morningWeather == null ? other$morningWeather == null : this$morningWeather.equals(other$morningWeather)) {
                           Object this$afternoonWeather = this.getAfternoonWeather();
                           Object other$afternoonWeather = other.getAfternoonWeather();
                           if (this$afternoonWeather == null ? other$afternoonWeather == null : this$afternoonWeather.equals(other$afternoonWeather)) {
                              Object this$morningWind = this.getMorningWind();
                              Object other$morningWind = other.getMorningWind();
                              if (this$morningWind == null ? other$morningWind == null : this$morningWind.equals(other$morningWind)) {
                                 Object this$afternoonWind = this.getAfternoonWind();
                                 Object other$afternoonWind = other.getAfternoonWind();
                                 if (this$afternoonWind == null ? other$afternoonWind == null : this$afternoonWind.equals(other$afternoonWind)) {
                                    Object this$morningTemperature = this.getMorningTemperature();
                                    Object other$morningTemperature = other.getMorningTemperature();
                                    if (this$morningTemperature == null
                                       ? other$morningTemperature == null
                                       : this$morningTemperature.equals(other$morningTemperature)) {
                                       Object this$afternoonTemperature = this.getAfternoonTemperature();
                                       Object other$afternoonTemperature = other.getAfternoonTemperature();
                                       if (this$afternoonTemperature == null
                                          ? other$afternoonTemperature == null
                                          : this$afternoonTemperature.equals(other$afternoonTemperature)) {
                                          Object this$constructionDesc = this.getConstructionDesc();
                                          Object other$constructionDesc = other.getConstructionDesc();
                                          if (this$constructionDesc == null
                                             ? other$constructionDesc == null
                                             : this$constructionDesc.equals(other$constructionDesc)) {
                                             Object this$machineWorkDesc = this.getMachineWorkDesc();
                                             Object other$machineWorkDesc = other.getMachineWorkDesc();
                                             if (this$machineWorkDesc == null
                                                ? other$machineWorkDesc == null
                                                : this$machineWorkDesc.equals(other$machineWorkDesc)) {
                                                Object this$groupWorkDesc = this.getGroupWorkDesc();
                                                Object other$groupWorkDesc = other.getGroupWorkDesc();
                                                if (this$groupWorkDesc == null ? other$groupWorkDesc == null : this$groupWorkDesc.equals(other$groupWorkDesc)) {
                                                   Object this$qualityInspectionDesc = this.getQualityInspectionDesc();
                                                   Object other$qualityInspectionDesc = other.getQualityInspectionDesc();
                                                   if (this$qualityInspectionDesc == null
                                                      ? other$qualityInspectionDesc == null
                                                      : this$qualityInspectionDesc.equals(other$qualityInspectionDesc)) {
                                                      Object this$safetyInspectionDesc = this.getSafetyInspectionDesc();
                                                      Object other$safetyInspectionDesc = other.getSafetyInspectionDesc();
                                                      if (this$safetyInspectionDesc == null
                                                         ? other$safetyInspectionDesc == null
                                                         : this$safetyInspectionDesc.equals(other$safetyInspectionDesc)) {
                                                         Object this$siteImportantEvent = this.getSiteImportantEvent();
                                                         Object other$siteImportantEvent = other.getSiteImportantEvent();
                                                         if (this$siteImportantEvent == null
                                                            ? other$siteImportantEvent == null
                                                            : this$siteImportantEvent.equals(other$siteImportantEvent)) {
                                                            Object this$existingProblemDesc = this.getExistingProblemDesc();
                                                            Object other$existingProblemDesc = other.getExistingProblemDesc();
                                                            if (this$existingProblemDesc == null
                                                               ? other$existingProblemDesc == null
                                                               : this$existingProblemDesc.equals(other$existingProblemDesc)) {
                                                               Object this$recorderName = this.getRecorderName();
                                                               Object other$recorderName = other.getRecorderName();
                                                               if (this$recorderName == null
                                                                  ? other$recorderName == null
                                                                  : this$recorderName.equals(other$recorderName)) {
                                                                  Object this$managerName = this.getManagerName();
                                                                  Object other$managerName = other.getManagerName();
                                                                  if (this$managerName == null
                                                                     ? other$managerName == null
                                                                     : this$managerName.equals(other$managerName)) {
                                                                     Object this$userName = this.getUserName();
                                                                     Object other$userName = other.getUserName();
                                                                     return this$userName == null
                                                                        ? other$userName == null
                                                                        : this$userName.equals(other$userName);
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
      return other instanceof ProjectConstructionLog;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $recorderId = this.getRecorderId();
      result = result * 59 + ($recorderId == null ? 43 : $recorderId.hashCode());
      Object $managerId = this.getManagerId();
      result = result * 59 + ($managerId == null ? 43 : $managerId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $constructionDate = this.getConstructionDate();
      result = result * 59 + ($constructionDate == null ? 43 : $constructionDate.hashCode());
      Object $morningWeather = this.getMorningWeather();
      result = result * 59 + ($morningWeather == null ? 43 : $morningWeather.hashCode());
      Object $afternoonWeather = this.getAfternoonWeather();
      result = result * 59 + ($afternoonWeather == null ? 43 : $afternoonWeather.hashCode());
      Object $morningWind = this.getMorningWind();
      result = result * 59 + ($morningWind == null ? 43 : $morningWind.hashCode());
      Object $afternoonWind = this.getAfternoonWind();
      result = result * 59 + ($afternoonWind == null ? 43 : $afternoonWind.hashCode());
      Object $morningTemperature = this.getMorningTemperature();
      result = result * 59 + ($morningTemperature == null ? 43 : $morningTemperature.hashCode());
      Object $afternoonTemperature = this.getAfternoonTemperature();
      result = result * 59 + ($afternoonTemperature == null ? 43 : $afternoonTemperature.hashCode());
      Object $constructionDesc = this.getConstructionDesc();
      result = result * 59 + ($constructionDesc == null ? 43 : $constructionDesc.hashCode());
      Object $machineWorkDesc = this.getMachineWorkDesc();
      result = result * 59 + ($machineWorkDesc == null ? 43 : $machineWorkDesc.hashCode());
      Object $groupWorkDesc = this.getGroupWorkDesc();
      result = result * 59 + ($groupWorkDesc == null ? 43 : $groupWorkDesc.hashCode());
      Object $qualityInspectionDesc = this.getQualityInspectionDesc();
      result = result * 59 + ($qualityInspectionDesc == null ? 43 : $qualityInspectionDesc.hashCode());
      Object $safetyInspectionDesc = this.getSafetyInspectionDesc();
      result = result * 59 + ($safetyInspectionDesc == null ? 43 : $safetyInspectionDesc.hashCode());
      Object $siteImportantEvent = this.getSiteImportantEvent();
      result = result * 59 + ($siteImportantEvent == null ? 43 : $siteImportantEvent.hashCode());
      Object $existingProblemDesc = this.getExistingProblemDesc();
      result = result * 59 + ($existingProblemDesc == null ? 43 : $existingProblemDesc.hashCode());
      Object $recorderName = this.getRecorderName();
      result = result * 59 + ($recorderName == null ? 43 : $recorderName.hashCode());
      Object $managerName = this.getManagerName();
      result = result * 59 + ($managerName == null ? 43 : $managerName.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class ProjectConstructionLogBuilder {
      private Long id;
      private Long projectId;
      private LocalDate constructionDate;
      private String morningWeather;
      private String afternoonWeather;
      private String morningWind;
      private String afternoonWind;
      private String morningTemperature;
      private String afternoonTemperature;
      private String constructionDesc;
      private String machineWorkDesc;
      private String groupWorkDesc;
      private String qualityInspectionDesc;
      private String safetyInspectionDesc;
      private String siteImportantEvent;
      private String existingProblemDesc;
      private Long recorderId;
      private String recorderName;
      private Long managerId;
      private String managerName;
      private Long userId;
      private String userName;

      ProjectConstructionLogBuilder() {
      }

      @JsonProperty("id")
      public ProjectConstructionLog.ProjectConstructionLogBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ProjectConstructionLog.ProjectConstructionLogBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("constructionDate")
      public ProjectConstructionLog.ProjectConstructionLogBuilder constructionDate(final LocalDate constructionDate) {
         this.constructionDate = constructionDate;
         return this;
      }

      @JsonProperty("morningWeather")
      public ProjectConstructionLog.ProjectConstructionLogBuilder morningWeather(final String morningWeather) {
         this.morningWeather = morningWeather;
         return this;
      }

      @JsonProperty("afternoonWeather")
      public ProjectConstructionLog.ProjectConstructionLogBuilder afternoonWeather(final String afternoonWeather) {
         this.afternoonWeather = afternoonWeather;
         return this;
      }

      @JsonProperty("morningWind")
      public ProjectConstructionLog.ProjectConstructionLogBuilder morningWind(final String morningWind) {
         this.morningWind = morningWind;
         return this;
      }

      @JsonProperty("afternoonWind")
      public ProjectConstructionLog.ProjectConstructionLogBuilder afternoonWind(final String afternoonWind) {
         this.afternoonWind = afternoonWind;
         return this;
      }

      @JsonProperty("morningTemperature")
      public ProjectConstructionLog.ProjectConstructionLogBuilder morningTemperature(final String morningTemperature) {
         this.morningTemperature = morningTemperature;
         return this;
      }

      @JsonProperty("afternoonTemperature")
      public ProjectConstructionLog.ProjectConstructionLogBuilder afternoonTemperature(final String afternoonTemperature) {
         this.afternoonTemperature = afternoonTemperature;
         return this;
      }

      @JsonProperty("constructionDesc")
      public ProjectConstructionLog.ProjectConstructionLogBuilder constructionDesc(final String constructionDesc) {
         this.constructionDesc = constructionDesc;
         return this;
      }

      @JsonProperty("machineWorkDesc")
      public ProjectConstructionLog.ProjectConstructionLogBuilder machineWorkDesc(final String machineWorkDesc) {
         this.machineWorkDesc = machineWorkDesc;
         return this;
      }

      @JsonProperty("groupWorkDesc")
      public ProjectConstructionLog.ProjectConstructionLogBuilder groupWorkDesc(final String groupWorkDesc) {
         this.groupWorkDesc = groupWorkDesc;
         return this;
      }

      @JsonProperty("qualityInspectionDesc")
      public ProjectConstructionLog.ProjectConstructionLogBuilder qualityInspectionDesc(final String qualityInspectionDesc) {
         this.qualityInspectionDesc = qualityInspectionDesc;
         return this;
      }

      @JsonProperty("safetyInspectionDesc")
      public ProjectConstructionLog.ProjectConstructionLogBuilder safetyInspectionDesc(final String safetyInspectionDesc) {
         this.safetyInspectionDesc = safetyInspectionDesc;
         return this;
      }

      @JsonProperty("siteImportantEvent")
      public ProjectConstructionLog.ProjectConstructionLogBuilder siteImportantEvent(final String siteImportantEvent) {
         this.siteImportantEvent = siteImportantEvent;
         return this;
      }

      @JsonProperty("existingProblemDesc")
      public ProjectConstructionLog.ProjectConstructionLogBuilder existingProblemDesc(final String existingProblemDesc) {
         this.existingProblemDesc = existingProblemDesc;
         return this;
      }

      public ProjectConstructionLog.ProjectConstructionLogBuilder recorderId(final Long recorderId) {
         this.recorderId = recorderId;
         return this;
      }

      public ProjectConstructionLog.ProjectConstructionLogBuilder recorderName(final String recorderName) {
         this.recorderName = recorderName;
         return this;
      }

      @JsonProperty("managerId")
      public ProjectConstructionLog.ProjectConstructionLogBuilder managerId(final Long managerId) {
         this.managerId = managerId;
         return this;
      }

      @JsonProperty("managerName")
      public ProjectConstructionLog.ProjectConstructionLogBuilder managerName(final String managerName) {
         this.managerName = managerName;
         return this;
      }

      @JsonProperty("userId")
      public ProjectConstructionLog.ProjectConstructionLogBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public ProjectConstructionLog.ProjectConstructionLogBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectConstructionLog build() {
         return new ProjectConstructionLog(
            this.id,
            this.projectId,
            this.constructionDate,
            this.morningWeather,
            this.afternoonWeather,
            this.morningWind,
            this.afternoonWind,
            this.morningTemperature,
            this.afternoonTemperature,
            this.constructionDesc,
            this.machineWorkDesc,
            this.groupWorkDesc,
            this.qualityInspectionDesc,
            this.safetyInspectionDesc,
            this.siteImportantEvent,
            this.existingProblemDesc,
            this.recorderId,
            this.recorderName,
            this.managerId,
            this.managerName,
            this.userId,
            this.userName
         );
      }

      @Override
      public String toString() {
         return "ProjectConstructionLog.ProjectConstructionLogBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", constructionDate="
            + this.constructionDate
            + ", morningWeather="
            + this.morningWeather
            + ", afternoonWeather="
            + this.afternoonWeather
            + ", morningWind="
            + this.morningWind
            + ", afternoonWind="
            + this.afternoonWind
            + ", morningTemperature="
            + this.morningTemperature
            + ", afternoonTemperature="
            + this.afternoonTemperature
            + ", constructionDesc="
            + this.constructionDesc
            + ", machineWorkDesc="
            + this.machineWorkDesc
            + ", groupWorkDesc="
            + this.groupWorkDesc
            + ", qualityInspectionDesc="
            + this.qualityInspectionDesc
            + ", safetyInspectionDesc="
            + this.safetyInspectionDesc
            + ", siteImportantEvent="
            + this.siteImportantEvent
            + ", existingProblemDesc="
            + this.existingProblemDesc
            + ", recorderId="
            + this.recorderId
            + ", recorderName="
            + this.recorderName
            + ", managerId="
            + this.managerId
            + ", managerName="
            + this.managerName
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
