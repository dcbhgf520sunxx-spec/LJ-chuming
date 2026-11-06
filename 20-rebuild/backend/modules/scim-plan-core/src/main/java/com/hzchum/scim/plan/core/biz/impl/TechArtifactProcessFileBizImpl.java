package com.hzchum.scim.plan.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.TechArtifactProcessFileBiz;
import com.hzchum.scim.plan.core.api.biz.approve.TechnologicalAchievementBiz;
import com.hzchum.scim.plan.core.api.enums.BindStatusEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactProcessFile;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactProcessFileLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactProcessFileRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactClassSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactProcessFileAttachmentDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSnDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactProcessFileDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactProcessFileLinkDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactProcessFileRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.ArtifactProcessFileBindDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.MonomerArtifactSnDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileEditDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileQueryDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileSaveDTOParam;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactProcessFileLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactProcessFileRecordService;
import com.hzchum.scim.plan.core.api.service.TechArtifactProcessFileService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.mapper.TechArtifactProcessFileMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class TechArtifactProcessFileBizImpl
   extends IBizImpl<TechArtifactProcessFileService, TechArtifactProcessFileMapper, TechArtifactProcessFile>
   implements TechArtifactProcessFileBiz {
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final AttachmentService attachmentService;
   private final UserService userService;
   private final TechArtifactService artifactService;
   private final TechArtifactProcessFileRecordService artifactProcessFileRecordService;
   private final TechArtifactProcessFileLinkService artifactProcessFileLinkService;
   private final SysStructureClassificationService structureClassificationService;
   @Resource
   private TechnologicalAchievementBiz achievementBiz;

   @Override
   public PageVO<TechArtifactProcessFileDTO> pageListProcessFileByCondition(TechArtifactProcessFileQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<TechArtifactProcessFileDTO> processFileDTOList = this.baseService.listByCondition(param);
      if (CollectionUtils.isNotEmpty(processFileDTOList)) {
         List<Long> processFileIds = processFileDTOList.stream().map(TechArtifactProcessFileDTO::getId).collect(Collectors.toList());
         List<TechArtifactProcessFileLink> linkList = this.artifactProcessFileLinkService
            .list(Wrappers.lambdaQuery(TechArtifactProcessFileLink.class).in(TechArtifactProcessFileLink::getProcessFileId, processFileIds));
         Map<Long, List<Long>> processFileProjectIdListMap = linkList.stream()
            .collect(
               Collectors.groupingBy(
                  TechArtifactProcessFileLink::getProcessFileId, Collectors.mapping(TechArtifactProcessFileLink::getProjectId, Collectors.toList())
               )
            );
         Set<Long> projectIds = linkList.stream().map(TechArtifactProcessFileLink::getProjectId).collect(Collectors.toSet());
         Set<Long> singleProjectIds = processFileDTOList.stream()
            .map(TechArtifactProcessFileDTO::getProjectId)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
         projectIds.addAll(singleProjectIds);
         List<ProjectInfo> projectInfoList = this.projectService.listSimpleByIdList(projectIds);
         List<TechArtifactProcessFileRecord> processFileRecordList = this.artifactProcessFileRecordService
            .list(Wrappers.lambdaQuery(TechArtifactProcessFileRecord.class).in(TechArtifactProcessFileRecord::getProcessFileId, processFileIds));
         List<Long> recordAttachmentIds = processFileRecordList.stream().map(TechArtifactProcessFileRecord::getAttachmentId).collect(Collectors.toList());
         Map<Long, AttachmentDTO> attachmentDTOMap = this.attachmentService
            .listByIdList(recordAttachmentIds)
            .stream()
            .collect(Collectors.toMap(AttachmentDTO::getId, Function.identity()));
         List<Long> recordUserIds = processFileRecordList.stream().map(TechArtifactProcessFileRecord::getUserId).distinct().collect(Collectors.toList());
         Map<Long, User> userMap = this.userService.listByIds(recordUserIds).stream().collect(Collectors.toMap(User::getId, Function.identity()));
         Map<Long, List<TechArtifactProcessFileRecordDTO>> processFileIdGroupMap = processFileRecordList.stream().map(record -> {
            TechArtifactProcessFileRecordDTO recordDTO = BeanUtil.copy(record, TechArtifactProcessFileRecordDTO.class);
            recordDTO.setAttachmentDTO(attachmentDTOMap.get(record.getAttachmentId()));
            recordDTO.setUserName(userMap.containsKey(record.getUserId()) ? userMap.get(record.getUserId()).getName() : null);
            return recordDTO;
         }).collect(Collectors.groupingBy(TechArtifactProcessFileRecordDTO::getProcessFileId));
         processFileDTOList.forEach(
            processFile -> {
               List<ProjectInfo> projectList = Collections.emptyList();
               if (processFile.getBoolSingleProject()) {
                  projectList = projectInfoList.stream().filter(p -> p.getId().equals(processFile.getProjectId())).collect(Collectors.toList());
               } else if (processFileProjectIdListMap.containsKey(processFile.getId())) {
                  List<Long> projectIdList = processFileProjectIdListMap.get(processFile.getId());
                  projectList = projectInfoList.stream().filter(p -> projectIdList.contains(p.getId())).collect(Collectors.toList());
               }

               processFile.setProjectList(projectList);
               processFile.setAttachmentDTO(attachmentDTOMap.get(processFile.getAttachmentId()));
               List<TechArtifactProcessFileRecordDTO> recordDTOS = processFileIdGroupMap.get(processFile.getId())
                  .stream()
                  .sorted(Comparator.comparing(TechArtifactProcessFileRecordDTO::getId).reversed())
                  .collect(Collectors.toList());
               processFile.setProcessFileRecordDTOList(recordDTOS);
            }
         );
      }

      return new PageVO<>(processFileDTOList);
   }

   @Override
   public ResultVO saveProcessFile(TechArtifactProcessFileSaveDTOParam param) throws RuntimeException {
      Preconditions.checkArgument(param.getProjectId() != null || param.getBoolSingleProject().equals(false), "项目专用文件必须输入项目信息!");
      if (param.getBoolSingleProject()) {
         ContractProject project = this.projectService.getById(param.getProjectId());
         Preconditions.checkArgument(project != null, "专用项目不存在!");
      } else {
         param.setProjectId(null);
      }

      param.getFileList()
         .forEach(
            f -> {
               int count = this.baseService
                  .count(
                     Wrappers.lambdaQuery(
                        TechArtifactProcessFile.builder()
                           .fileName(f.getFileName())
                           .processType(param.getProcessType())
                           .boolSingleProject(param.getBoolSingleProject())
                           .projectId(param.getProjectId())
                           .build()
                     )
                  );
               Preconditions.checkArgument(count == 0, "文件名称不能重复!");
               AttachmentDTO attachmentDTO = this.attachmentService.getById(f.getAttachmentId());
               Preconditions.checkArgument(attachmentDTO != null, "上传文件不存在");
            }
         );
      return this.achievementBiz.createTechnologyApprove(param);
   }

   @Override
   public ResultVO newSaveProcessFile(TechArtifactProcessFileSaveDTOParam param) {
      Preconditions.checkArgument(param.getProjectId() != null || param.getBoolSingleProject().equals(false), "项目专用文件必须输入项目信息!");
      if (param.getBoolSingleProject()) {
         ContractProject project = this.projectService.getById(param.getProjectId());
         Preconditions.checkArgument(project != null, "专用项目不存在!");
      } else {
         param.setProjectId(null);
      }

      param.getFileList()
         .forEach(
            f -> {
               int count = this.baseService
                  .count(
                     Wrappers.lambdaQuery(
                        TechArtifactProcessFile.builder()
                           .fileName(f.getFileName())
                           .processType(param.getProcessType())
                           .boolSingleProject(param.getBoolSingleProject())
                           .projectId(param.getProjectId())
                           .build()
                     )
                  );
               Preconditions.checkArgument(count == 0, "文件名称不能重复!");
               AttachmentDTO attachmentDTO = this.attachmentService.getById(f.getAttachmentId());
               Preconditions.checkArgument(attachmentDTO != null, "上传文件不存在");
               TechArtifactProcessFile processFile = BeanUtil.copy(param, TechArtifactProcessFile.class);
               BeanUtil.copy(f, processFile);
               processFile.setFileVersion(1);
               processFile.setUserId(attachmentDTO.getCreateUserId());
               processFile.setUploadTime(attachmentDTO.getCreateTime());
               processFile.setBindQuantity(0);
               this.baseService.save(processFile);
               TechArtifactProcessFileRecord record = BeanUtil.copy(f, TechArtifactProcessFileRecord.class);
               record.setProcessFileId(processFile.getId());
               record.setFileVersion(1);
               record.setUploadTime(processFile.getUploadTime());
               record.setUserId(processFile.getUserId());
               this.artifactProcessFileRecordService.save(record);
            }
         );
      return null;
   }

   @Override
   public Boolean updateProcessFile(TechArtifactProcessFileEditDTOParam param) {
      TechArtifactProcessFile processFile = this.baseService.getById(param.getId());
      Preconditions.checkArgument(processFile != null, "修改失败,文件不存在!");
      Long oldAttachmentId = processFile.getAttachmentId();
      if (!param.getFileName().equals(processFile.getFileName())) {
         int count = this.baseService
            .count(
               Wrappers.lambdaQuery(
                  TechArtifactProcessFile.builder()
                     .fileName(param.getFileName())
                     .processType(processFile.getProcessType())
                     .boolSingleProject(processFile.getBoolSingleProject())
                     .projectId(processFile.getProjectId())
                     .build()
               )
            );
         Preconditions.checkArgument(count == 0, "文件名称已存在!");
      }

      if (!param.getAttachmentId().equals(oldAttachmentId)) {
         AttachmentDTO attachmentDTO = this.attachmentService.getById(param.getAttachmentId());
         Preconditions.checkArgument(attachmentDTO != null, "变更上传的文件不存在!");
         processFile.setFileVersion(processFile.getFileVersion() + 1);
         processFile.setUserId(attachmentDTO.getCreateUserId());
         processFile.setUploadTime(attachmentDTO.getCreateTime());
         TechArtifactProcessFileRecord record = TechArtifactProcessFileRecord.builder()
            .processFileId(param.getId())
            .attachmentId(param.getAttachmentId())
            .fileName(param.getFileName())
            .fileVersion(processFile.getFileVersion())
            .uploadTime(processFile.getUploadTime())
            .remark(processFile.getRemark())
            .userId(processFile.getUserId())
            .build();
         this.artifactProcessFileRecordService.save(record);
      } else {
         TechArtifactProcessFileRecord fileRecord = this.artifactProcessFileRecordService
            .getOne(
               Wrappers.lambdaQuery(
                  TechArtifactProcessFileRecord.builder()
                     .processFileId(param.getId())
                     .attachmentId(oldAttachmentId)
                     .fileVersion(processFile.getFileVersion())
                     .build()
               )
            );
         fileRecord.setFileName(param.getFileName());
         fileRecord.setRemark(param.getRemark());
         this.artifactProcessFileRecordService.updateById(fileRecord);
      }

      BeanUtil.copy(param, processFile);
      this.baseService.updateById(processFile);
      return true;
   }

   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(id -> {
         TechArtifactProcessFile processFile = this.baseService.getById(id);
         Preconditions.checkArgument(processFile != null, "删除失败,工艺文件不存在!");
         int count = this.artifactProcessFileLinkService.count(Wrappers.lambdaQuery(TechArtifactProcessFileLink.builder().processFileId(id).build()));
         Preconditions.checkArgument(count == 0, "删除失败,工艺文件已绑定构件");
         this.artifactProcessFileRecordService.remove(Wrappers.lambdaQuery(TechArtifactProcessFileRecord.builder().processFileId(id).build()));
         this.baseService.removeById(id);
      });
      return true;
   }

   @Override
   public List<ArtifactClassSummaryDTO> listClassSnQuantity(Integer processType, Boolean boolBindStatus, Long projectId, Long monomerId) {
      List<ArtifactClassSummaryDTO> classSummaryDTOList = this.artifactService.listClassSnQuantity(projectId, monomerId);
      if (boolBindStatus != null) {
         Preconditions.checkArgument(processType != null, "工艺类型不能为空!");
         List<TechArtifactProcessFileLink> processFileLinkList = this.artifactProcessFileLinkService
            .list(
               Wrappers.lambdaQuery(TechArtifactProcessFileLink.class)
                  .eq(TechArtifactProcessFileLink::getProcessType, processType)
                  .eq(TechArtifactProcessFileLink::getProjectId, projectId)
                  .eq(monomerId != null, TechArtifactProcessFileLink::getMonomerId, monomerId)
            );
         Map<Long, Long> structureClassQuantityMap = processFileLinkList.stream()
            .collect(Collectors.groupingBy(TechArtifactProcessFileLink::getStructureClassId, Collectors.counting()));
         if (boolBindStatus) {
            classSummaryDTOList = classSummaryDTOList.stream()
               .filter(s -> structureClassQuantityMap.containsKey(s.getStructureClassId()))
               .collect(Collectors.toList());
            classSummaryDTOList.forEach(s -> s.setQuantity(Math.toIntExact(structureClassQuantityMap.get(s.getStructureClassId()))));
         } else {
            classSummaryDTOList.forEach(
               s -> s.setQuantity(s.getQuantity() - Math.toIntExact(structureClassQuantityMap.getOrDefault(s.getStructureClassId(), 0L)))
            );
            classSummaryDTOList = classSummaryDTOList.stream().filter(s -> s.getQuantity() > 0).collect(Collectors.toList());
         }
      }

      return classSummaryDTOList;
   }

   @Override
   public List<ArtifactSnDTO> listArtifactSn(
      Long projectId,
      Long monomerId,
      Long processFileId,
      Boolean boolBindStatus,
      String name,
      String serialNumber,
      String specification,
      String material,
      String structureClassIds
   ) {
      List<Long> structureClassIdList = Collections.emptyList();
      if (StringUtils.isNotBlank(structureClassIds)) {
         String[] split = StringUtils.split(structureClassIds, ",");
         structureClassIdList = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
      }

      TechArtifactProcessFile processFile = this.baseService.getById(processFileId);
      Preconditions.checkArgument(processFile != null, "当前工艺文件不存在!");
      List<ArtifactSnDTO> artifactSnDTOList = this.artifactService
         .listArtifactSn(projectId, monomerId, name, serialNumber, specification, material, structureClassIdList);
      if (CollectionUtils.isNotEmpty(artifactSnDTOList)) {
         Set<Long> monomerIds = artifactSnDTOList.stream().map(ArtifactSnDTO::getMonomerId).collect(Collectors.toSet());
         Set<String> serialNumberSet = artifactSnDTOList.stream().map(ArtifactSnDTO::getSerialNumber).collect(Collectors.toSet());
         List<TechArtifactProcessFileLink> processFileLinkList = this.artifactProcessFileLinkService
            .list(
               Wrappers.lambdaQuery(TechArtifactProcessFileLink.class)
                  .eq(TechArtifactProcessFileLink::getProcessType, processFile.getProcessType())
                  .in(TechArtifactProcessFileLink::getMonomerId, monomerIds)
                  .in(TechArtifactProcessFileLink::getSerialNumber, serialNumberSet)
            );
         Map<Long, TechArtifactProcessFileDTO> processFileDTOMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(processFileLinkList)) {
            Set<Long> processFileIds = processFileLinkList.stream().map(TechArtifactProcessFileLink::getProcessFileId).collect(Collectors.toSet());
            List<TechArtifactProcessFile> processFileList = this.baseService.listByIds(processFileIds);
            List<Long> attachmentIds = processFileList.stream().map(TechArtifactProcessFile::getAttachmentId).distinct().collect(Collectors.toList());
            Map<Long, AttachmentDTO> attachmentDTOMap = this.attachmentService
               .listByIdList(attachmentIds)
               .stream()
               .collect(Collectors.toMap(AttachmentDTO::getId, Function.identity()));
            processFileDTOMap = processFileList.stream().map(s -> {
               TechArtifactProcessFileDTO processFileDTO = BeanUtil.copy(s, TechArtifactProcessFileDTO.class);
               processFileDTO.setAttachmentDTO(attachmentDTOMap.get(s.getAttachmentId()));
               return processFileDTO;
            }).collect(Collectors.toMap(TechArtifactProcessFileDTO::getId, Function.identity()));
         }

         Map<Long, TechArtifactProcessFileDTO> finalProcessFileDTOMap = processFileDTOMap;
         Map<Long, Map<String, Long>> monomerSnLinkMap = processFileLinkList.stream()
            .collect(
               Collectors.groupingBy(
                  TechArtifactProcessFileLink::getMonomerId,
                  Collectors.toMap(TechArtifactProcessFileLink::getSerialNumber, TechArtifactProcessFileLink::getProcessFileId)
               )
            );
         artifactSnDTOList.forEach(
            artifactSnDTO -> {
               if (monomerSnLinkMap.containsKey(artifactSnDTO.getMonomerId())
                  && monomerSnLinkMap.get(artifactSnDTO.getMonomerId()).containsKey(artifactSnDTO.getSerialNumber())) {
                  Long fileId = monomerSnLinkMap.get(artifactSnDTO.getMonomerId()).get(artifactSnDTO.getSerialNumber());
                  artifactSnDTO.setBindStatus(fileId.equals(processFileId) ? BindStatusEnum.BIND_CURRENT.getType() : BindStatusEnum.BIND_OTHER.getType());
                  artifactSnDTO.setProcessFileDTO(finalProcessFileDTOMap.get(fileId));
               } else {
                  artifactSnDTO.setBindStatus(BindStatusEnum.UN_BIND.getType());
               }
            }
         );
         if (boolBindStatus != null) {
            if (boolBindStatus) {
               artifactSnDTOList = artifactSnDTOList.stream()
                  .filter(artifactSnDTO -> !artifactSnDTO.getBindStatus().equals(BindStatusEnum.UN_BIND.getType()))
                  .collect(Collectors.toList());
            } else {
               artifactSnDTOList = artifactSnDTOList.stream()
                  .filter(artifactSnDTO -> artifactSnDTO.getBindStatus().equals(BindStatusEnum.UN_BIND.getType()))
                  .collect(Collectors.toList());
            }
         }
      }

      return artifactSnDTOList;
   }

   @Override
   public Boolean bindArtifactProcessFile(ArtifactProcessFileBindDTOParam param) {
      TechArtifactProcessFile processFile = this.baseService.getById(param.getProcessFileId());
      Preconditions.checkArgument(processFile != null, "工艺文件不存在!");
      List<Long> monomerIds = param.getDetails().stream().map(MonomerArtifactSnDTOParam::getMonomerId).distinct().collect(Collectors.toList());
      List<PlanMonomer> monomerList = this.monomerService.listByIds(monomerIds);
      Map<Long, PlanMonomer> monomerMap = monomerList.stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      Set<Long> projectIdSet = monomerList.stream().map(PlanMonomer::getProjectId).collect(Collectors.toSet());
      Preconditions.checkArgument(
         !processFile.getBoolSingleProject() || projectIdSet.size() == 1 && projectIdSet.iterator().next().equals(processFile.getProjectId()),
         "该文件只能绑定专用项目下的构件!"
      );
      List<String> serialNumberList = param.getDetails().stream().map(MonomerArtifactSnDTOParam::getSerialNumber).distinct().collect(Collectors.toList());
      Map<Long, Map<String, TechArtifactProcessFileLink>> linkMap = this.artifactProcessFileLinkService
         .list(
            Wrappers.lambdaQuery(TechArtifactProcessFileLink.class)
               .in(TechArtifactProcessFileLink::getMonomerId, monomerIds)
               .in(TechArtifactProcessFileLink::getSerialNumber, serialNumberList)
               .eq(TechArtifactProcessFileLink::getProcessType, processFile.getProcessType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               TechArtifactProcessFileLink::getMonomerId, Collectors.toMap(TechArtifactProcessFileLink::getSerialNumber, Function.identity())
            )
         );
      Map<Long, Map<String, List<TechArtifact>>> monomerIdSnListMap = this.artifactService
         .list(Wrappers.lambdaQuery(TechArtifact.class).in(TechArtifact::getMonomerId, monomerIds).in(TechArtifact::getSerialNumber, serialNumberList))
         .stream()
         .collect(Collectors.groupingBy(TechArtifact::getMonomerId, Collectors.groupingBy(TechArtifact::getSerialNumber)));
      List<TechArtifactProcessFileLink> linkList = new ArrayList<>(32);
      Map<Long, Map<String, TechArtifactProcessFileLink>> newLinkMap = new HashMap<>(16);
      List<TechArtifactProcessFileLink> unbindLinkIdList = new ArrayList<>(16);
      param.getDetails()
         .forEach(
            monomerSnParam -> {
               PlanMonomer monomer = monomerMap.get(monomerSnParam.getMonomerId());
               Preconditions.checkArgument(monomer != null, "单体不存在!");
               Preconditions.checkArgument(
                  monomerIdSnListMap.containsKey(monomerSnParam.getMonomerId())
                     && monomerIdSnListMap.get(monomerSnParam.getMonomerId()).containsKey(monomerSnParam.getSerialNumber()),
                  "单体[" + monomer.getName() + "]内不存在构件编号[" + monomerSnParam.getSerialNumber() + "]"
               );
               if (linkMap.containsKey(monomerSnParam.getMonomerId())
                  && linkMap.get(monomerSnParam.getMonomerId()).containsKey(monomerSnParam.getSerialNumber())) {
                  TechArtifactProcessFileLink processFileLink = linkMap.get(monomerSnParam.getMonomerId()).get(monomerSnParam.getSerialNumber());
                  Preconditions.checkArgument(
                     !processFileLink.getProcessFileId().equals(param.getProcessFileId()),
                     "该工艺文件已绑定单体[" + monomer.getName() + "]下的构件[" + monomerSnParam.getSerialNumber() + "]"
                  );
                  unbindLinkIdList.add(processFileLink);
               }

               Preconditions.checkArgument(
                  !newLinkMap.containsKey(monomerSnParam.getMonomerId())
                     || !newLinkMap.get(monomerSnParam.getMonomerId()).containsKey(monomerSnParam.getSerialNumber()),
                  "单体[" + monomer.getName() + "]下的构件[" + monomerSnParam.getSerialNumber() + "]出现重复"
               );
               TechArtifact artifact = monomerIdSnListMap.get(monomerSnParam.getMonomerId()).get(monomerSnParam.getSerialNumber()).iterator().next();
               TechArtifactProcessFileLink link = TechArtifactProcessFileLink.builder()
                  .projectId(monomer.getProjectId())
                  .monomerId(monomerSnParam.getMonomerId())
                  .structureClassId(artifact.getStructureClassId())
                  .serialNumber(monomerSnParam.getSerialNumber())
                  .specification(artifact.getSpecification())
                  .name(artifact.getName())
                  .material(artifact.getMaterial())
                  .processFileId(param.getProcessFileId())
                  .processType(processFile.getProcessType())
                  .build();
               linkList.add(link);
               if (newLinkMap.containsKey(monomerSnParam.getMonomerId())) {
                  Map<String, TechArtifactProcessFileLink> processFileLinkMap = newLinkMap.get(monomerSnParam.getMonomerId());
                  processFileLinkMap.put(monomerSnParam.getSerialNumber(), link);
               } else {
                  Map<String, TechArtifactProcessFileLink> processFileLinkMap = new HashMap<>(16);
                  processFileLinkMap.put(monomerSnParam.getSerialNumber(), link);
                  newLinkMap.put(monomerSnParam.getMonomerId(), processFileLinkMap);
               }
            }
         );
      if (CollectionUtils.isNotEmpty(unbindLinkIdList)) {
         this.artifactProcessFileLinkService.removeByIds(unbindLinkIdList.stream().map(TechArtifactProcessFileLink::getId).collect(Collectors.toSet()));
         Set<Long> processFileIds = unbindLinkIdList.stream().map(TechArtifactProcessFileLink::getProcessFileId).collect(Collectors.toSet());
         List<TechArtifactProcessFile> processFileList = this.baseService.listByIds(processFileIds);
         Map<Long, Long> unbindProcessFileQuantityMap = unbindLinkIdList.stream()
            .collect(Collectors.groupingBy(TechArtifactProcessFileLink::getProcessFileId, Collectors.counting()));
         processFileList.forEach(
            techArtifactProcessFile -> techArtifactProcessFile.setBindQuantity(
               techArtifactProcessFile.getBindQuantity() - Math.toIntExact(unbindProcessFileQuantityMap.get(techArtifactProcessFile.getId()))
            )
         );
         this.baseService.updateBatchById(processFileList);
      }

      this.artifactProcessFileLinkService.saveBatch(linkList);
      processFile.setBindQuantity(processFile.getBindQuantity() + linkList.size());
      this.baseService.updateById(processFile);
      return true;
   }

   @Override
   public PageVO<TechArtifactProcessFileLinkDTO> listBindByCondition(
      Long processFileId,
      Long projectId,
      Long monomerId,
      Long structureClassId,
      String name,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<TechArtifactProcessFileLink> processFileLinks = this.artifactProcessFileLinkService
         .listByCondition(processFileId, projectId, monomerId, structureClassId, name, serialNumber, specification, material);
      List<TechArtifactProcessFileLinkDTO> processFileLinkDTOS = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(processFileLinks)) {
         Map<Long, String> classMap = this.structureClassificationService
            .list()
            .stream()
            .collect(Collectors.toMap(SysStructureClassification::getId, SysStructureClassification::getClassificationName));
         List<Long> projectIds = processFileLinks.stream().map(TechArtifactProcessFileLink::getProjectId).distinct().collect(Collectors.toList());
         List<Long> monomerIds = processFileLinks.stream().map(TechArtifactProcessFileLink::getMonomerId).distinct().collect(Collectors.toList());
         Map<Long, ProjectInfo> projectInfoMap = this.projectService
            .listSimpleByIdList(projectIds)
            .stream()
            .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         Map<Long, String> monomerMap = this.monomerService.listByIds(monomerIds).stream().collect(Collectors.toMap(PlanMonomer::getId, PlanMonomer::getName));
         processFileLinkDTOS = processFileLinks.stream().map(link -> {
            TechArtifactProcessFileLinkDTO linkDTO = BeanUtil.copy(link, TechArtifactProcessFileLinkDTO.class);
            linkDTO.setProject(projectInfoMap.get(link.getProjectId()));
            linkDTO.setMonomerName(monomerMap.get(link.getMonomerId()));
            linkDTO.setStructureClassName(classMap.get(link.getStructureClassId()));
            return linkDTO;
         }).collect(Collectors.toList());
      }

      return new PageVO<>(PageUtils.getPageInfo(processFileLinkDTOS, processFileLinks));
   }

   @Override
   public Boolean unbind(ArtifactProcessFileBindDTOParam param) {
      TechArtifactProcessFile processFile = this.baseService.getById(param.getProcessFileId());
      Preconditions.checkArgument(processFile != null, "工艺文件不存在!");
      List<Long> monomerIds = param.getDetails().stream().map(MonomerArtifactSnDTOParam::getMonomerId).distinct().collect(Collectors.toList());
      Set<Long> projectIdSet = this.monomerService.listByIds(monomerIds).stream().map(PlanMonomer::getProjectId).collect(Collectors.toSet());
      Preconditions.checkArgument(
         !processFile.getBoolSingleProject() || projectIdSet.size() == 1 && projectIdSet.iterator().next().equals(processFile.getProjectId()),
         "构件编号不在该文件专用项目之内,无法解绑!"
      );
      List<String> snList = param.getDetails().stream().map(MonomerArtifactSnDTOParam::getSerialNumber).distinct().collect(Collectors.toList());
      List<TechArtifactProcessFileLink> linkList = this.artifactProcessFileLinkService
         .list(
            Wrappers.lambdaQuery(TechArtifactProcessFileLink.class)
               .eq(TechArtifactProcessFileLink::getProcessFileId, param.getProcessFileId())
               .in(TechArtifactProcessFileLink::getMonomerId, monomerIds)
               .in(TechArtifactProcessFileLink::getSerialNumber, snList)
         );
      Map<Long, Map<String, TechArtifactProcessFileLink>> linkMap = linkList.stream()
         .collect(
            Collectors.groupingBy(
               TechArtifactProcessFileLink::getMonomerId, Collectors.toMap(TechArtifactProcessFileLink::getSerialNumber, Function.identity())
            )
         );
      List<Long> linkIds = new ArrayList<>(16);
      param.getDetails()
         .forEach(
            monomerArtifactSnDTOParam -> {
               Preconditions.checkArgument(
                  linkMap.containsKey(monomerArtifactSnDTOParam.getMonomerId())
                     && linkMap.get(monomerArtifactSnDTOParam.getMonomerId()).containsKey(monomerArtifactSnDTOParam.getSerialNumber()),
                  "工艺文件未绑定构件编号"
               );
               TechArtifactProcessFileLink processFileLink = linkMap.get(monomerArtifactSnDTOParam.getMonomerId())
                  .get(monomerArtifactSnDTOParam.getSerialNumber());
               linkIds.add(processFileLink.getId());
            }
         );
      this.artifactProcessFileLinkService.removeByIds(linkIds);
      processFile.setBindQuantity(processFile.getBindQuantity() - linkIds.size());
      this.baseService.updateById(processFile);
      return true;
   }

   @Override
   public Boolean unbindAllArtifact(Long processFileId) {
      TechArtifactProcessFile processFile = this.baseService.getById(processFileId);
      Preconditions.checkArgument(processFile != null, "工艺文件不存在!");
      this.artifactProcessFileLinkService.remove(Wrappers.lambdaQuery(TechArtifactProcessFileLink.builder().processFileId(processFileId).build()));
      processFile.setBindQuantity(0);
      this.baseService.updateById(processFile);
      return true;
   }

   @Override
   public List<ArtifactProcessFileAttachmentDTO> listAttachment(Long monomerId, String serialNumber) {
      List<TechArtifactProcessFileLink> processFileLinkList = this.artifactProcessFileLinkService
         .list(Wrappers.lambdaQuery(TechArtifactProcessFileLink.builder().monomerId(monomerId).serialNumber(serialNumber).build()));
      return processFileLinkList.stream()
         .map(
            link -> {
               TechArtifactProcessFile processFile = this.baseService.getById(link.getProcessFileId());
               return ArtifactProcessFileAttachmentDTO.builder()
                  .processType(link.getProcessType())
                  .fileName(processFile.getFileName())
                  .attachmentDTO(this.attachmentService.getById(processFile.getAttachmentId()))
                  .build();
            }
         )
         .collect(Collectors.toList());
   }

   public TechArtifactProcessFileBizImpl(
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final AttachmentService attachmentService,
      final UserService userService,
      final TechArtifactService artifactService,
      final TechArtifactProcessFileRecordService artifactProcessFileRecordService,
      final TechArtifactProcessFileLinkService artifactProcessFileLinkService,
      final SysStructureClassificationService structureClassificationService
   ) {
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.attachmentService = attachmentService;
      this.userService = userService;
      this.artifactService = artifactService;
      this.artifactProcessFileRecordService = artifactProcessFileRecordService;
      this.artifactProcessFileLinkService = artifactProcessFileLinkService;
      this.structureClassificationService = structureClassificationService;
   }
}
