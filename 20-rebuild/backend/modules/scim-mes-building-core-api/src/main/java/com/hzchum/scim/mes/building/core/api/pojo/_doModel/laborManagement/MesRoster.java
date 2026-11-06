package com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "MesRoster对象", description = "花名册表")
@Entity
@TableName("mes_roster")
@Table(name = "mes_roster")
@org.hibernate.annotations.Table(appliesTo = "mes_roster", comment = "花名册表")
public class MesRoster extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("姓名")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) COMMENT '姓名'", nullable = true)
   private String name;
   @ApiModelProperty("身份证号")
   @TableField("id_number")
   @Column(name = "id_number", columnDefinition = "varchar(255) COMMENT '身份证号'", nullable = true)
   private String idNumber;
   @ApiModelProperty("头像附件id")
   @TableField(value = "avatar_attachment_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "avatar_attachment_id", columnDefinition = "bigint(20) COMMENT '头像附件id'", nullable = true)
   private Long avatarAttachmentId;
   @ApiModelProperty("性别(0: 男, 1: 女)")
   @TableField("sex")
   @Column(name = "sex", columnDefinition = "int COMMENT '性别(0: 男, 1: 女)'", nullable = true)
   private Integer sex;
   @ApiModelProperty("年龄")
   @TableField("age")
   @Column(name = "age", columnDefinition = "int COMMENT '年龄'", nullable = true)
   private Integer age;
   @ApiModelProperty("出生日期")
   @TableField("birth_date")
   @Column(name = "birth_date", columnDefinition = "datetime COMMENT '出生日期'", nullable = true)
   private LocalDate birthDate;
   @ApiModelProperty("民族")
   @TableField("nation")
   @Column(name = "nation", columnDefinition = "varchar(255) COMMENT '民族'", nullable = true)
   private String nation;
   @ApiModelProperty("家庭住址")
   @TableField("home_address")
   @Column(name = "home_address", columnDefinition = "varchar(255) COMMENT '家庭住址'", nullable = true)
   private String homeAddress;
   @ApiModelProperty("员工类别")
   @TableField("employee_category")
   @Column(name = "employee_category", columnDefinition = "int COMMENT '员工类别'", nullable = true)
   private Integer employeeCategory;
   @ApiModelProperty("供应商ID(雇主单位)")
   @TableField(value = "supplier_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "supplier_id", columnDefinition = "bigint(20) COMMENT '供应商ID(雇主单位)'", nullable = true)
   private Long supplierId;
   @ApiModelProperty("入职日期")
   @TableField("entry_date")
   @Column(name = "entry_date", columnDefinition = "datetime COMMENT '入职日期'", nullable = true)
   private LocalDate entryDate;
   @ApiModelProperty("工种")
   @TableField("work_type")
   @Column(name = "work_type", columnDefinition = "varchar(255) COMMENT '工种'", nullable = true)
   private String workType;
   @ApiModelProperty("有无证书(0: 无, 1: 有)")
   @TableField("bool_cert")
   @Column(name = "bool_cert", columnDefinition = "tinyint(1) COMMENT '有无证书(0: 无, 1: 有)'", nullable = true)
   private Boolean boolCert;
   @ApiModelProperty("证书附件IDs")
   @TableField(value = "cert_attachment_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "cert_attachment_ids", columnDefinition = "varchar(255) COMMENT '证书附件IDs'", nullable = true)
   private String certAttachmentIds;
   @ApiModelProperty("体检附件IDs")
   @TableField("physical_examination_attachment_ids")
   @Column(name = "physical_examination_attachment_ids", columnDefinition = "varchar(255) COMMENT '体检附件IDs'", nullable = true)
   private String physicalExaminationAttachmentIds;
   @ApiModelProperty("状态(1: 在岗, 2: 离职)")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int default 1 COMMENT '状态'", nullable = true)
   private Integer status;
   @ApiModelProperty("用户ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) COMMENT '用户ID'", nullable = true)
   private Long userId;
   @ApiModelProperty("行为总分")
   @TableField("behavior_total_score")
   @Column(name = "behavior_total_score", columnDefinition = "int COMMENT '行为总分'", nullable = true)
   private Integer behaviorTotalScore;

   public static MesRoster.MesRosterBuilder builder() {
      return new MesRoster.MesRosterBuilder();
   }

   public MesRoster() {
   }

   public MesRoster(
      final Long id,
      final String name,
      final String idNumber,
      final Long avatarAttachmentId,
      final Integer sex,
      final Integer age,
      final LocalDate birthDate,
      final String nation,
      final String homeAddress,
      final Integer employeeCategory,
      final Long supplierId,
      final LocalDate entryDate,
      final String workType,
      final Boolean boolCert,
      final String certAttachmentIds,
      final String physicalExaminationAttachmentIds,
      final Integer status,
      final Long userId,
      final Integer behaviorTotalScore
   ) {
      this.id = id;
      this.name = name;
      this.idNumber = idNumber;
      this.avatarAttachmentId = avatarAttachmentId;
      this.sex = sex;
      this.age = age;
      this.birthDate = birthDate;
      this.nation = nation;
      this.homeAddress = homeAddress;
      this.employeeCategory = employeeCategory;
      this.supplierId = supplierId;
      this.entryDate = entryDate;
      this.workType = workType;
      this.boolCert = boolCert;
      this.certAttachmentIds = certAttachmentIds;
      this.physicalExaminationAttachmentIds = physicalExaminationAttachmentIds;
      this.status = status;
      this.userId = userId;
      this.behaviorTotalScore = behaviorTotalScore;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getIdNumber() {
      return this.idNumber;
   }

   public Long getAvatarAttachmentId() {
      return this.avatarAttachmentId;
   }

   public Integer getSex() {
      return this.sex;
   }

   public Integer getAge() {
      return this.age;
   }

   public LocalDate getBirthDate() {
      return this.birthDate;
   }

   public String getNation() {
      return this.nation;
   }

   public String getHomeAddress() {
      return this.homeAddress;
   }

   public Integer getEmployeeCategory() {
      return this.employeeCategory;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public LocalDate getEntryDate() {
      return this.entryDate;
   }

   public String getWorkType() {
      return this.workType;
   }

   public Boolean getBoolCert() {
      return this.boolCert;
   }

   public String getCertAttachmentIds() {
      return this.certAttachmentIds;
   }

   public String getPhysicalExaminationAttachmentIds() {
      return this.physicalExaminationAttachmentIds;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getBehaviorTotalScore() {
      return this.behaviorTotalScore;
   }

   public MesRoster setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesRoster setName(final String name) {
      this.name = name;
      return this;
   }

   public MesRoster setIdNumber(final String idNumber) {
      this.idNumber = idNumber;
      return this;
   }

   public MesRoster setAvatarAttachmentId(final Long avatarAttachmentId) {
      this.avatarAttachmentId = avatarAttachmentId;
      return this;
   }

   public MesRoster setSex(final Integer sex) {
      this.sex = sex;
      return this;
   }

   public MesRoster setAge(final Integer age) {
      this.age = age;
      return this;
   }

   public MesRoster setBirthDate(final LocalDate birthDate) {
      this.birthDate = birthDate;
      return this;
   }

   public MesRoster setNation(final String nation) {
      this.nation = nation;
      return this;
   }

   public MesRoster setHomeAddress(final String homeAddress) {
      this.homeAddress = homeAddress;
      return this;
   }

   public MesRoster setEmployeeCategory(final Integer employeeCategory) {
      this.employeeCategory = employeeCategory;
      return this;
   }

   public MesRoster setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public MesRoster setEntryDate(final LocalDate entryDate) {
      this.entryDate = entryDate;
      return this;
   }

   public MesRoster setWorkType(final String workType) {
      this.workType = workType;
      return this;
   }

   public MesRoster setBoolCert(final Boolean boolCert) {
      this.boolCert = boolCert;
      return this;
   }

   public MesRoster setCertAttachmentIds(final String certAttachmentIds) {
      this.certAttachmentIds = certAttachmentIds;
      return this;
   }

   public MesRoster setPhysicalExaminationAttachmentIds(final String physicalExaminationAttachmentIds) {
      this.physicalExaminationAttachmentIds = physicalExaminationAttachmentIds;
      return this;
   }

   public MesRoster setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public MesRoster setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public MesRoster setBehaviorTotalScore(final Integer behaviorTotalScore) {
      this.behaviorTotalScore = behaviorTotalScore;
      return this;
   }

   @Override
   public String toString() {
      return "MesRoster(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", idNumber="
         + this.getIdNumber()
         + ", avatarAttachmentId="
         + this.getAvatarAttachmentId()
         + ", sex="
         + this.getSex()
         + ", age="
         + this.getAge()
         + ", birthDate="
         + this.getBirthDate()
         + ", nation="
         + this.getNation()
         + ", homeAddress="
         + this.getHomeAddress()
         + ", employeeCategory="
         + this.getEmployeeCategory()
         + ", supplierId="
         + this.getSupplierId()
         + ", entryDate="
         + this.getEntryDate()
         + ", workType="
         + this.getWorkType()
         + ", boolCert="
         + this.getBoolCert()
         + ", certAttachmentIds="
         + this.getCertAttachmentIds()
         + ", physicalExaminationAttachmentIds="
         + this.getPhysicalExaminationAttachmentIds()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ", behaviorTotalScore="
         + this.getBehaviorTotalScore()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesRoster)) {
         return false;
      }

      MesRoster other = (MesRoster)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$avatarAttachmentId = this.getAvatarAttachmentId();
         Object other$avatarAttachmentId = other.getAvatarAttachmentId();
         if (this$avatarAttachmentId == null ? other$avatarAttachmentId == null : this$avatarAttachmentId.equals(other$avatarAttachmentId)) {
            Object this$sex = this.getSex();
            Object other$sex = other.getSex();
            if (this$sex == null ? other$sex == null : this$sex.equals(other$sex)) {
               Object this$age = this.getAge();
               Object other$age = other.getAge();
               if (this$age == null ? other$age == null : this$age.equals(other$age)) {
                  Object this$employeeCategory = this.getEmployeeCategory();
                  Object other$employeeCategory = other.getEmployeeCategory();
                  if (this$employeeCategory == null ? other$employeeCategory == null : this$employeeCategory.equals(other$employeeCategory)) {
                     Object this$supplierId = this.getSupplierId();
                     Object other$supplierId = other.getSupplierId();
                     if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                        Object this$boolCert = this.getBoolCert();
                        Object other$boolCert = other.getBoolCert();
                        if (this$boolCert == null ? other$boolCert == null : this$boolCert.equals(other$boolCert)) {
                           Object this$status = this.getStatus();
                           Object other$status = other.getStatus();
                           if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$behaviorTotalScore = this.getBehaviorTotalScore();
                                 Object other$behaviorTotalScore = other.getBehaviorTotalScore();
                                 if (this$behaviorTotalScore == null
                                    ? other$behaviorTotalScore == null
                                    : this$behaviorTotalScore.equals(other$behaviorTotalScore)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$idNumber = this.getIdNumber();
                                       Object other$idNumber = other.getIdNumber();
                                       if (this$idNumber == null ? other$idNumber == null : this$idNumber.equals(other$idNumber)) {
                                          Object this$birthDate = this.getBirthDate();
                                          Object other$birthDate = other.getBirthDate();
                                          if (this$birthDate == null ? other$birthDate == null : this$birthDate.equals(other$birthDate)) {
                                             Object this$nation = this.getNation();
                                             Object other$nation = other.getNation();
                                             if (this$nation == null ? other$nation == null : this$nation.equals(other$nation)) {
                                                Object this$homeAddress = this.getHomeAddress();
                                                Object other$homeAddress = other.getHomeAddress();
                                                if (this$homeAddress == null ? other$homeAddress == null : this$homeAddress.equals(other$homeAddress)) {
                                                   Object this$entryDate = this.getEntryDate();
                                                   Object other$entryDate = other.getEntryDate();
                                                   if (this$entryDate == null ? other$entryDate == null : this$entryDate.equals(other$entryDate)) {
                                                      Object this$workType = this.getWorkType();
                                                      Object other$workType = other.getWorkType();
                                                      if (this$workType == null ? other$workType == null : this$workType.equals(other$workType)) {
                                                         Object this$certAttachmentIds = this.getCertAttachmentIds();
                                                         Object other$certAttachmentIds = other.getCertAttachmentIds();
                                                         if (this$certAttachmentIds == null
                                                            ? other$certAttachmentIds == null
                                                            : this$certAttachmentIds.equals(other$certAttachmentIds)) {
                                                            Object this$physicalExaminationAttachmentIds = this.getPhysicalExaminationAttachmentIds();
                                                            Object other$physicalExaminationAttachmentIds = other.getPhysicalExaminationAttachmentIds();
                                                            return this$physicalExaminationAttachmentIds == null
                                                               ? other$physicalExaminationAttachmentIds == null
                                                               : this$physicalExaminationAttachmentIds.equals(other$physicalExaminationAttachmentIds);
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
      return other instanceof MesRoster;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $avatarAttachmentId = this.getAvatarAttachmentId();
      result = result * 59 + ($avatarAttachmentId == null ? 43 : $avatarAttachmentId.hashCode());
      Object $sex = this.getSex();
      result = result * 59 + ($sex == null ? 43 : $sex.hashCode());
      Object $age = this.getAge();
      result = result * 59 + ($age == null ? 43 : $age.hashCode());
      Object $employeeCategory = this.getEmployeeCategory();
      result = result * 59 + ($employeeCategory == null ? 43 : $employeeCategory.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $boolCert = this.getBoolCert();
      result = result * 59 + ($boolCert == null ? 43 : $boolCert.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $behaviorTotalScore = this.getBehaviorTotalScore();
      result = result * 59 + ($behaviorTotalScore == null ? 43 : $behaviorTotalScore.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $idNumber = this.getIdNumber();
      result = result * 59 + ($idNumber == null ? 43 : $idNumber.hashCode());
      Object $birthDate = this.getBirthDate();
      result = result * 59 + ($birthDate == null ? 43 : $birthDate.hashCode());
      Object $nation = this.getNation();
      result = result * 59 + ($nation == null ? 43 : $nation.hashCode());
      Object $homeAddress = this.getHomeAddress();
      result = result * 59 + ($homeAddress == null ? 43 : $homeAddress.hashCode());
      Object $entryDate = this.getEntryDate();
      result = result * 59 + ($entryDate == null ? 43 : $entryDate.hashCode());
      Object $workType = this.getWorkType();
      result = result * 59 + ($workType == null ? 43 : $workType.hashCode());
      Object $certAttachmentIds = this.getCertAttachmentIds();
      result = result * 59 + ($certAttachmentIds == null ? 43 : $certAttachmentIds.hashCode());
      Object $physicalExaminationAttachmentIds = this.getPhysicalExaminationAttachmentIds();
      return result * 59 + ($physicalExaminationAttachmentIds == null ? 43 : $physicalExaminationAttachmentIds.hashCode());
   }

   public static class MesRosterBuilder {
      private Long id;
      private String name;
      private String idNumber;
      private Long avatarAttachmentId;
      private Integer sex;
      private Integer age;
      private LocalDate birthDate;
      private String nation;
      private String homeAddress;
      private Integer employeeCategory;
      private Long supplierId;
      private LocalDate entryDate;
      private String workType;
      private Boolean boolCert;
      private String certAttachmentIds;
      private String physicalExaminationAttachmentIds;
      private Integer status;
      private Long userId;
      private Integer behaviorTotalScore;

      MesRosterBuilder() {
      }

      public MesRoster.MesRosterBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesRoster.MesRosterBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesRoster.MesRosterBuilder idNumber(final String idNumber) {
         this.idNumber = idNumber;
         return this;
      }

      public MesRoster.MesRosterBuilder avatarAttachmentId(final Long avatarAttachmentId) {
         this.avatarAttachmentId = avatarAttachmentId;
         return this;
      }

      public MesRoster.MesRosterBuilder sex(final Integer sex) {
         this.sex = sex;
         return this;
      }

      public MesRoster.MesRosterBuilder age(final Integer age) {
         this.age = age;
         return this;
      }

      public MesRoster.MesRosterBuilder birthDate(final LocalDate birthDate) {
         this.birthDate = birthDate;
         return this;
      }

      public MesRoster.MesRosterBuilder nation(final String nation) {
         this.nation = nation;
         return this;
      }

      public MesRoster.MesRosterBuilder homeAddress(final String homeAddress) {
         this.homeAddress = homeAddress;
         return this;
      }

      public MesRoster.MesRosterBuilder employeeCategory(final Integer employeeCategory) {
         this.employeeCategory = employeeCategory;
         return this;
      }

      public MesRoster.MesRosterBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public MesRoster.MesRosterBuilder entryDate(final LocalDate entryDate) {
         this.entryDate = entryDate;
         return this;
      }

      public MesRoster.MesRosterBuilder workType(final String workType) {
         this.workType = workType;
         return this;
      }

      public MesRoster.MesRosterBuilder boolCert(final Boolean boolCert) {
         this.boolCert = boolCert;
         return this;
      }

      public MesRoster.MesRosterBuilder certAttachmentIds(final String certAttachmentIds) {
         this.certAttachmentIds = certAttachmentIds;
         return this;
      }

      public MesRoster.MesRosterBuilder physicalExaminationAttachmentIds(final String physicalExaminationAttachmentIds) {
         this.physicalExaminationAttachmentIds = physicalExaminationAttachmentIds;
         return this;
      }

      public MesRoster.MesRosterBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public MesRoster.MesRosterBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesRoster.MesRosterBuilder behaviorTotalScore(final Integer behaviorTotalScore) {
         this.behaviorTotalScore = behaviorTotalScore;
         return this;
      }

      public MesRoster build() {
         return new MesRoster(
            this.id,
            this.name,
            this.idNumber,
            this.avatarAttachmentId,
            this.sex,
            this.age,
            this.birthDate,
            this.nation,
            this.homeAddress,
            this.employeeCategory,
            this.supplierId,
            this.entryDate,
            this.workType,
            this.boolCert,
            this.certAttachmentIds,
            this.physicalExaminationAttachmentIds,
            this.status,
            this.userId,
            this.behaviorTotalScore
         );
      }

      @Override
      public String toString() {
         return "MesRoster.MesRosterBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", idNumber="
            + this.idNumber
            + ", avatarAttachmentId="
            + this.avatarAttachmentId
            + ", sex="
            + this.sex
            + ", age="
            + this.age
            + ", birthDate="
            + this.birthDate
            + ", nation="
            + this.nation
            + ", homeAddress="
            + this.homeAddress
            + ", employeeCategory="
            + this.employeeCategory
            + ", supplierId="
            + this.supplierId
            + ", entryDate="
            + this.entryDate
            + ", workType="
            + this.workType
            + ", boolCert="
            + this.boolCert
            + ", certAttachmentIds="
            + this.certAttachmentIds
            + ", physicalExaminationAttachmentIds="
            + this.physicalExaminationAttachmentIds
            + ", status="
            + this.status
            + ", userId="
            + this.userId
            + ", behaviorTotalScore="
            + this.behaviorTotalScore
            + ")";
      }
   }
}
