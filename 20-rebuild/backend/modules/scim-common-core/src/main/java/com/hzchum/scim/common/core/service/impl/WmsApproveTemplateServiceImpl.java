package com.hzchum.scim.common.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ApproveObjectTypeEnum;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveTemplateVersionsFlowEnum;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.common.core.api.enums.ModuleTypeEnum;
import com.hzchum.scim.common.core.api.enums.UseEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveFlowOperation;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersions;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveTemplateVersionsFlow;
import com.hzchum.scim.common.core.api.pojo.dto.MountMessageDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveFlowOperationDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveTemplateDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveTemplateVersionsDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveTemplateVersionsFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsModuleApproveTemplateDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsModuleDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveFlowOperationDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveTemplateVersionsDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveTemplateVersionsFlowDTOParam;
import com.hzchum.scim.common.core.api.service.WmsApproveFlowOperationService;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateService;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateVersionsService;
import com.hzchum.scim.common.core.mapper.WmsApproveTemplateVersionsFlowMapper;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentDTO;
import com.hzchum.scim.system.core.api.pojo.dto.JobResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSimpleResponseVO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsApproveTemplateServiceImpl implements WmsApproveTemplateService {
   @Resource
   private WmsApproveTemplateVersionsFlowMapper wmsApproveTemplateVersionsFlowMapper;
   @Resource
   private UserService userService;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private JobService jobService;
   @Resource
   private WmsApproveTemplateVersionsService wmsApproveTemplateVersionsService;
   @Resource
   private WmsApproveFlowOperationService wmsApproveFlowOperationService;

   @Override
   public List<WmsApproveTemplateVersionsDTO> getAll() {
      List<WmsApproveTemplateDTO> wmsApproveTemplateDTOS = ApproveProcessTypeEnumV2.getTemplate();
      List<WmsApproveTemplateVersions> wmsApproveTemplateVersions = new ArrayList<>();
      List<WmsApproveTemplateVersionsFlow> wmsApproveTemplateVersionsFlows = new ArrayList<>();
      List<DepartmentDTO> departmentDTOSSystem = this.departmentService.departmentListAll();
      List<com.hzchum.scim.common.core.api.pojo.dto.DepartmentDTO> departmentDTOS = BeanUtil.copyToList(
         departmentDTOSSystem, com.hzchum.scim.common.core.api.pojo.dto.DepartmentDTO.class
      );
      Map<Long, com.hzchum.scim.common.core.api.pojo.dto.DepartmentDTO> departmentAllMap = departmentDTOS.stream()
         .collect(Collectors.toMap(com.hzchum.scim.common.core.api.pojo.dto.DepartmentDTO::getId, Function.identity()));
      List<UserSimpleResponseVO> userAllListVOSystem = this.userService.getUserAllListVO();
      List<com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userAllListVO = BeanUtil.copyToList(
         userAllListVOSystem, com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO.class
      );
      Map<Long, com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userAllMap = userAllListVO.stream()
         .collect(Collectors.toMap(com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO::getId, Function.identity()));
      List<JobResponseVO> all = this.jobService.getAll();
      List<com.hzchum.scim.common.core.api.pojo.vo.JobResponseVO> jobAllList = BeanUtil.copyToList(
         all, com.hzchum.scim.common.core.api.pojo.vo.JobResponseVO.class
      );
      Map<Long, com.hzchum.scim.common.core.api.pojo.vo.JobResponseVO> jobAllMap = jobAllList.stream()
         .collect(Collectors.toMap(com.hzchum.scim.common.core.api.pojo.vo.JobResponseVO::getId, Function.identity()));
      if (CollectionUtils.isNotEmpty(wmsApproveTemplateDTOS)) {
         wmsApproveTemplateVersions = this.wmsApproveTemplateVersionsService
            .list((Wrapper<WmsApproveTemplateVersions>)new LambdaQueryWrapper<WmsApproveTemplateVersions>().eq(WmsApproveTemplateVersions::getUseStatus, UseEnum.USE.getType()));
         if (CollectionUtils.isNotEmpty(wmsApproveTemplateVersions)) {
            List<Long> versionsId = wmsApproveTemplateVersions.stream().map(WmsApproveTemplateVersions::getId).collect(Collectors.toList());
            wmsApproveTemplateVersionsFlows = this.wmsApproveTemplateVersionsFlowMapper
               .selectList(
                  (Wrapper<WmsApproveTemplateVersionsFlow>)new LambdaQueryWrapper<WmsApproveTemplateVersionsFlow>().in(WmsApproveTemplateVersionsFlow::getApproveVersionsId, versionsId)
               );
         }
      }

      List<WmsApproveTemplateVersionsDTO> wmsApproveTemplateVersionsDTOS = new ArrayList<>();

      for (WmsApproveTemplateDTO wmsApproveTemplate : wmsApproveTemplateDTOS) {
         List<WmsApproveTemplateVersions> wmsApproveTemplateVersionsList = wmsApproveTemplateVersions.stream()
            .filter(w -> w.getApproveProcessType().equals(wmsApproveTemplate.getApproveProcessType()))
            .collect(Collectors.toList());
         if (CollectionUtils.isEmpty(wmsApproveTemplateVersionsList)) {
            WmsApproveTemplateVersionsDTO wmsApproveTemplateVersionsDTO = new WmsApproveTemplateVersionsDTO();
            wmsApproveTemplateVersionsDTO.setModuleName(ModuleTypeEnum.getName(wmsApproveTemplate.getModuleType()));
            wmsApproveTemplateVersionsDTO.setTemplateName(wmsApproveTemplate.getName());
            wmsApproveTemplateVersionsDTO.setModuleType(wmsApproveTemplate.getModuleType());
            wmsApproveTemplateVersionsDTO.setFunctionType(wmsApproveTemplate.getFunctionType());
            wmsApproveTemplateVersionsDTO.setApproveProcessType(wmsApproveTemplate.getApproveProcessType());
            wmsApproveTemplateVersionsDTOS.add(wmsApproveTemplateVersionsDTO);
         } else {
            for (WmsApproveTemplateVersions approveTemplateVersions : wmsApproveTemplateVersionsList) {
               WmsApproveTemplateVersionsDTO wmsApproveTemplateVersionsDTO = BeanUtil.toBean(approveTemplateVersions, WmsApproveTemplateVersionsDTO.class);
               wmsApproveTemplateVersionsDTO.setModuleName(ModuleTypeEnum.getName(wmsApproveTemplate.getModuleType()));
               wmsApproveTemplateVersionsDTO.setTemplateName(wmsApproveTemplate.getName());
               com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO userSimpleResponseVO1 = userAllMap.get(
                  wmsApproveTemplateVersionsDTO.getApplicantId()
               );
               wmsApproveTemplateVersionsDTO.setApplicationUser(userSimpleResponseVO1);
               String objIds = approveTemplateVersions.getObjIds();
               List<Long> ids = Arrays.stream(objIds.split(",")).map(Long::valueOf).collect(Collectors.toList());
               String mountMessage = approveTemplateVersions.getMountMessage();
               MountMessageDTO mountMessageDTO = JSON.parseObject(mountMessage, MountMessageDTO.class);
               wmsApproveTemplateVersionsDTO.setMountMessageDTO(mountMessageDTO);
               Integer objType = approveTemplateVersions.getObjType();
               if (objType.equals(ApproveObjectTypeEnum.DEPARTMENT.getType())) {
                  List<com.hzchum.scim.common.core.api.pojo.dto.DepartmentDTO> departmentDTOList = new ArrayList<>();

                  for (Long s : ids) {
                     com.hzchum.scim.common.core.api.pojo.dto.DepartmentDTO departmentDTO = departmentAllMap.get(s);
                     if (ObjectUtil.isNotEmpty(departmentDTO)) {
                        departmentDTOList.add(departmentDTO);
                     }
                  }

                  wmsApproveTemplateVersionsDTO.setDepartmentDTOS(departmentDTOList);
                  wmsApproveTemplateVersionsDTO.setObjTypeName(ApproveObjectTypeEnum.DEPARTMENT.getName());
               } else if (objType.equals(ApproveObjectTypeEnum.JOB.getType())) {
                  List<com.hzchum.scim.common.core.api.pojo.vo.JobResponseVO> jobResponseVOS = new ArrayList<>();

                  for (Long s : ids) {
                     com.hzchum.scim.common.core.api.pojo.vo.JobResponseVO jobResponseVO = jobAllMap.get(s);
                     if (ObjectUtil.isNotEmpty(jobResponseVO)) {
                        jobResponseVOS.add(jobResponseVO);
                     }
                  }

                  wmsApproveTemplateVersionsDTO.setJobResponseVOS(jobResponseVOS);
                  wmsApproveTemplateVersionsDTO.setObjTypeName(ApproveObjectTypeEnum.JOB.getName());
               } else if (!objType.equals(ApproveObjectTypeEnum.PERSON.getType())) {
                  if (objType.equals(ApproveObjectTypeEnum.COMPANY.getType())) {
                     wmsApproveTemplateVersionsDTO.setObjTypeName(ApproveObjectTypeEnum.COMPANY.getName());
                  } else {
                     Preconditions.checkArgument(false, "未知状态!!");
                  }
               } else {
                  List<com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userSimpleResponseVOS = new ArrayList<>();

                  for (Long s : ids) {
                     com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO userSimpleResponseVO = userAllMap.get(s);
                     if (ObjectUtil.isNotEmpty(userSimpleResponseVO)) {
                        userSimpleResponseVOS.add(userSimpleResponseVO);
                     }
                  }

                  wmsApproveTemplateVersionsDTO.setUserSimpleResponseVOS(userSimpleResponseVOS);
                  wmsApproveTemplateVersionsDTO.setObjTypeName(ApproveObjectTypeEnum.PERSON.getName());
               }

               if (CollectionUtils.isNotEmpty(wmsApproveTemplateVersionsFlows)) {
                  List<WmsApproveTemplateVersionsFlow> wmsApproveTemplateVersionsFlowsNow = wmsApproveTemplateVersionsFlows.stream()
                     .filter(w -> w.getApproveVersionsId().equals(approveTemplateVersions.getId()))
                     .sorted(Comparator.comparing(WmsApproveTemplateVersionsFlow::getId))
                     .collect(Collectors.toList());
                  List<WmsApproveTemplateVersionsFlowDTO> wmsApproveTemplateVersionsFlowDTOS = BeanUtil.copyToList(
                     wmsApproveTemplateVersionsFlowsNow, WmsApproveTemplateVersionsFlowDTO.class
                  );
                  StringBuilder flow = new StringBuilder();

                  for (WmsApproveTemplateVersionsFlowDTO wmsApproveTemplateVersionsFlowDTO : wmsApproveTemplateVersionsFlowDTOS) {
                     List<WmsApproveFlowOperation> list = this.wmsApproveFlowOperationService
                        .list(
                           (Wrapper<WmsApproveFlowOperation>)new LambdaQueryWrapper<WmsApproveFlowOperation>()
                              .eq(WmsApproveFlowOperation::getFlowId, wmsApproveTemplateVersionsFlowDTO.getId())
                        );
                     List<WmsApproveFlowOperationDTO> wmsApproveFlowOperationDTOS = BeanUtil.copyToList(list, WmsApproveFlowOperationDTO.class);
                     wmsApproveTemplateVersionsFlowDTO.setWmsApproveFlowOperationDTOS(wmsApproveFlowOperationDTOS);
                     flow.append("【");
                     flow.append(wmsApproveTemplateVersionsFlowDTO.getName() + "：");
                     String userIdsStr = wmsApproveTemplateVersionsFlowDTO.getUserIds();
                     List<Long> UserIds = Arrays.stream(userIdsStr.split(",")).map(u -> Long.parseLong(u.trim())).collect(Collectors.toList());
                     List<com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO> userSimpleResponseVOS = userAllListVO.stream()
                        .filter(u -> UserIds.contains(u.getId()))
                        .collect(Collectors.toList());

                     for (com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO userSimpleResponseVO : userSimpleResponseVOS) {
                        flow.append(userSimpleResponseVO.getDeptName() + "/" + userSimpleResponseVO.getName() + ",");
                     }

                     flow.deleteCharAt(flow.length() - 1);
                     flow.append("】");
                     flow.append("➜");
                     wmsApproveTemplateVersionsFlowDTO.setUserSimpleResponseVOS(userSimpleResponseVOS);
                  }

                  if (CollectionUtils.isNotEmpty(wmsApproveTemplateVersionsFlowDTOS)) {
                     flow.deleteCharAt(flow.length() - 1);
                     wmsApproveTemplateVersionsDTO.setApproveTemplateFlowStr(String.valueOf(flow));
                     wmsApproveTemplateVersionsDTO.setWmsApproveTemplateVersionsFlowDTOS(wmsApproveTemplateVersionsFlowDTOS);
                  }
               }

               wmsApproveTemplateVersionsDTOS.add(wmsApproveTemplateVersionsDTO);
            }
         }
      }

      return wmsApproveTemplateVersionsDTOS;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(WmsApproveTemplateVersionsDTOParam request) {
      List<WmsApproveTemplateVersionsFlowDTOParam> wmsApproveTemplateVersionsFlowDTOParams = request.getWmsApproveTemplateVersionsFlowDTOParams();
      Preconditions.checkArgument(
         ObjectUtil.isNotEmpty(request)
            && ObjectUtil.isNotEmpty(request.getModuleType())
            && ObjectUtil.isNotEmpty(request.getApproveProcessType())
            && ObjectUtil.isNotEmpty(request.getName()),
         "请传全信息"
      );
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsApproveTemplateVersions wmsApproveTemplateVersions = BeanUtil.toBean(request, WmsApproveTemplateVersions.class);
      if (request.getObjType().equals(ApproveObjectTypeEnum.COMPANY.getType()) && ObjectUtil.isNotEmpty(request.getMountMessageDTO())) {
         List<WmsApproveTemplateVersions> list = this.wmsApproveTemplateVersionsService
            .list(
               ((((new LambdaQueryWrapper<WmsApproveTemplateVersions>()
                              .eq(WmsApproveTemplateVersions::getModuleType, request.getModuleType()))
                           .eq(WmsApproveTemplateVersions::getApproveProcessType, request.getApproveProcessType()))
                        .eq(WmsApproveTemplateVersions::getUseStatus, UseEnum.USE.getType()))
                     .eq(WmsApproveTemplateVersions::getObjType, request.getObjType()))
                  .ne(request.getId() != null, WmsApproveTemplateVersions::getId, request.getId())
            );
         if (ObjectUtil.isNotEmpty(request.getMountMessageDTO())) {
            String name = this.judgeMountMessageDTO(list, request.getMountMessageDTO());
            if (ObjectUtil.isNotEmpty(name)) {
               Preconditions.checkArgument(false, "该审批流程与" + name + "所挂载的信息有重合数据，添加失败");
            }
         }
      }

      List<String> objIdsList = request.getObjIdsList();
      StringBuilder nameStr = new StringBuilder();

      for (String id : objIdsList) {
         String idStr = "," + id + ",";
         List<WmsApproveTemplateVersions> list = this.wmsApproveTemplateVersionsService
            .list(
               (Wrapper<WmsApproveTemplateVersions>)(((((new LambdaQueryWrapper<WmsApproveTemplateVersions>()
                                 .eq(WmsApproveTemplateVersions::getModuleType, request.getModuleType()))
                              .eq(WmsApproveTemplateVersions::getApproveProcessType, request.getApproveProcessType()))
                           .eq(WmsApproveTemplateVersions::getObjType, request.getObjType()))
                        .eq(WmsApproveTemplateVersions::getUseStatus, UseEnum.USE.getType()))
                     .ne(request.getId() != null, WmsApproveTemplateVersions::getId, request.getId()))
                  .like(WmsApproveTemplateVersions::getObjIds, idStr)
            );
         if (CollectionUtils.isNotEmpty(list)) {
            if (request.getObjType().equals(ApproveObjectTypeEnum.DEPARTMENT.getType())) {
               DepartmentDTO departmentSystem = this.departmentService.getDepartment(Long.parseLong(id));
               com.hzchum.scim.common.core.api.pojo.dto.DepartmentDTO department = BeanUtil.toBean(
                  departmentSystem, com.hzchum.scim.common.core.api.pojo.dto.DepartmentDTO.class
               );
               nameStr.append(department.getName() + "、");
            } else if (request.getObjType().equals(ApproveObjectTypeEnum.JOB.getType())) {
               Job job = this.jobService.getById(Long.parseLong(id));
               nameStr.append(job.getName() + "、");
            } else if (request.getObjType().equals(ApproveObjectTypeEnum.PERSON.getType())) {
               String nameById = this.userService.getNameById(Long.parseLong(id));
               nameStr.append(nameById + "、");
            } else {
               Preconditions.checkArgument(false, "未知状态!!");
            }
         }

         String name = null;
         if (ObjectUtil.isNotEmpty(request.getMountMessageDTO())) {
            name = this.judgeMountMessageDTO(list, request.getMountMessageDTO());
         }

         if (ObjectUtil.isNotEmpty(nameStr) && ObjectUtil.isNotEmpty(name)) {
            nameStr.deleteCharAt(nameStr.length() - 1);
            Preconditions.checkArgument(false, nameStr + "--已存在于其他启用中并且挂载信息相同的审批流程中，流程名称为--" + name + "--添加失败");
         }
      }

      String objIds = "0,";
      if (ObjectUtil.isNotEmpty(objIdsList)) {
         String s = StringUtils.list2String(objIdsList, ",");
         objIds = objIds + s + ",";
      } else {
         Preconditions.checkArgument(request.getObjType().equals(ApproveObjectTypeEnum.COMPANY.getType()), "审批流程未选择适用对象");
      }

      wmsApproveTemplateVersions.setObjIds(objIds);
      wmsApproveTemplateVersions.setApplicantId(currentUser.getId());
      MountMessageDTO mountMessageDTO = request.getMountMessageDTO();
      String mountMessage = JSON.toJSONString(mountMessageDTO);
      wmsApproveTemplateVersions.setMountMessage(mountMessage);
      if (ObjectUtil.isNotEmpty(request.getId())) {
         WmsApproveTemplateVersions wmsApproveTemplateVersionsOld = this.wmsApproveTemplateVersionsService.getById(request.getId());
         List<WmsApproveTemplateVersions> list = this.wmsApproveTemplateVersionsService
            .list(
               (Wrapper<WmsApproveTemplateVersions>)(new LambdaQueryWrapper<WmsApproveTemplateVersions>()
                     .ne(WmsApproveTemplateVersions::getFirstId, wmsApproveTemplateVersionsOld.getFirstId()))
                  .eq(WmsApproveTemplateVersions::getName, request.getName())
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(list), "名称已存在于其他版本，或其他版本历史版本，请重新命名");
         this.wmsApproveTemplateVersionsService
            .update(
               (Wrapper<WmsApproveTemplateVersions>)((new LambdaUpdateWrapper<WmsApproveTemplateVersions>()
                        .set(WmsApproveTemplateVersions::getStatus, EnableEnum.DISABLE.getType()))
                     .set(WmsApproveTemplateVersions::getUseStatus, UseEnum.UNUSED.getType()))
                  .eq(WmsApproveTemplateVersions::getFirstId, wmsApproveTemplateVersionsOld.getFirstId())
            );
         wmsApproveTemplateVersions.setFirstId(wmsApproveTemplateVersionsOld.getFirstId());
         this.wmsApproveTemplateVersionsService.save(wmsApproveTemplateVersions);
      } else {
         List<WmsApproveTemplateVersions> list = this.wmsApproveTemplateVersionsService
            .list((Wrapper<WmsApproveTemplateVersions>)new LambdaQueryWrapper<WmsApproveTemplateVersions>().eq(WmsApproveTemplateVersions::getName, request.getName()));
         Preconditions.checkArgument(CollectionUtils.isEmpty(list), "已存在该名称的审批模版，请重新命名");
         this.wmsApproveTemplateVersionsService.save(wmsApproveTemplateVersions);
         wmsApproveTemplateVersions.setFirstId(wmsApproveTemplateVersions.getId());
         this.wmsApproveTemplateVersionsService.updateById(wmsApproveTemplateVersions);
      }

      for (WmsApproveTemplateVersionsFlowDTOParam wmsApproveTemplateVersionsFlowDTOParam : wmsApproveTemplateVersionsFlowDTOParams) {
         WmsApproveTemplateVersionsFlow wmsApproveTemplateVersionsFlow = BeanUtil.toBean(
            wmsApproveTemplateVersionsFlowDTOParam, WmsApproveTemplateVersionsFlow.class
         );
         List<String> userIdsList = wmsApproveTemplateVersionsFlowDTOParam.getUserIdsList();
         String userIds = StringUtils.list2String(userIdsList, ",");
         userIds = "0," + userIds + ",";
         wmsApproveTemplateVersionsFlow.setName(
            wmsApproveTemplateVersionsFlow.getType().equals(ApproveTemplateVersionsFlowEnum.ALL_SIGN.getType())
               ? ApproveTemplateVersionsFlowEnum.ALL_SIGN.getName()
               : (
                  wmsApproveTemplateVersionsFlow.getType().equals(ApproveTemplateVersionsFlowEnum.OR_SIGN.getType())
                     ? ApproveTemplateVersionsFlowEnum.OR_SIGN.getName()
                     : (
                        wmsApproveTemplateVersionsFlow.getType().equals(ApproveTemplateVersionsFlowEnum.A_SIGN.getType())
                           ? ApproveTemplateVersionsFlowEnum.A_SIGN.getName()
                           : (
                              wmsApproveTemplateVersionsFlow.getType().equals(ApproveTemplateVersionsFlowEnum.COPY_SEND.getType())
                                 ? ApproveTemplateVersionsFlowEnum.COPY_SEND.getName()
                                 : "未知"
                           )
                     )
               )
         );
         wmsApproveTemplateVersionsFlow.setUserIds(userIds);
         wmsApproveTemplateVersionsFlow.setApproveVersionsId(wmsApproveTemplateVersions.getId());
         int insert = this.wmsApproveTemplateVersionsFlowMapper.insert(wmsApproveTemplateVersionsFlow);
         if (CollectionUtils.isNotEmpty(wmsApproveTemplateVersionsFlowDTOParam.getWmsApproveFlowOperationDTOParams())) {
            for (WmsApproveFlowOperationDTOParam wmsApproveFlowOperationDTOParam : wmsApproveTemplateVersionsFlowDTOParam.getWmsApproveFlowOperationDTOParams()) {
               if (!ObjectUtil.isEmpty(wmsApproveFlowOperationDTOParam.getOperationType())) {
                  WmsApproveFlowOperation wmsApproveFlowOperation = BeanUtil.toBean(wmsApproveFlowOperationDTOParam, WmsApproveFlowOperation.class);
                  wmsApproveFlowOperation.setFlowId(wmsApproveTemplateVersionsFlow.getId());
                  this.wmsApproveFlowOperationService.save(wmsApproveFlowOperation);
               }
            }
         }

         Preconditions.checkArgument(insert == 1, "添加流程失败");
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(List<Long> ids) {
      for (Long id : ids) {
         WmsApproveTemplateVersions byId = this.wmsApproveTemplateVersionsService.getById(id);
         boolean remove = this.wmsApproveTemplateVersionsService
            .remove((Wrapper<WmsApproveTemplateVersions>)new LambdaQueryWrapper<WmsApproveTemplateVersions>().eq(WmsApproveTemplateVersions::getFirstId, byId.getFirstId()));
         Preconditions.checkArgument(remove, "删除失败");
      }

      return true;
   }

   @Override
   public Boolean enabled(WmsApproveTemplateVersionsDTOParam wmsApproveTemplateVersionsDTOParam) {
      return this.wmsApproveTemplateVersionsService
         .update(
            (Wrapper<WmsApproveTemplateVersions>)(new LambdaUpdateWrapper<WmsApproveTemplateVersions>()
                  .set(WmsApproveTemplateVersions::getStatus, wmsApproveTemplateVersionsDTOParam.getStatus()))
               .eq(WmsApproveTemplateVersions::getId, wmsApproveTemplateVersionsDTOParam.getId())
         );
   }

   @Override
   public List<WmsApproveTemplateVersionsFlow> getWmsApproveTemplateVersionsFlows(
      Integer approveProcessType, Boolean boolDetail, MountMessageDTO mountMessageDTOSend
   ) {
      List<WmsApproveTemplateVersionsFlow> wmsApproveTemplateFlows;
      WmsApproveTemplateVersions wmsApproveTemplateVersionsGet;
      label125: {
         SecurityUser currentUser = UserUtil.getCurrentUser();
         wmsApproveTemplateFlows = new ArrayList<>();
         wmsApproveTemplateVersionsGet = null;
         String idStr = "";
         Long id = currentUser.getId();
         idStr = "," + id + ",";
         List<WmsApproveTemplateVersions> wmsApproveTemplateVersionsList = this.wmsApproveTemplateVersionsService
            .list(
               (Wrapper<WmsApproveTemplateVersions>)((((new LambdaQueryWrapper<WmsApproveTemplateVersions>()
                              .eq(WmsApproveTemplateVersions::getApproveProcessType, approveProcessType))
                           .eq(WmsApproveTemplateVersions::getObjType, ApproveObjectTypeEnum.PERSON.getType()))
                        .like(WmsApproveTemplateVersions::getObjIds, idStr))
                     .eq(WmsApproveTemplateVersions::getUseStatus, UseEnum.USE.getType()))
                  .eq(WmsApproveTemplateVersions::getStatus, EnableEnum.ENABLE.getType())
            );
         if (CollectionUtils.isNotEmpty(wmsApproveTemplateVersionsList)) {
            for (WmsApproveTemplateVersions wmsApproveTemplateVersions : wmsApproveTemplateVersionsList) {
               String mountMessage = wmsApproveTemplateVersions.getMountMessage();
               MountMessageDTO mountMessageDTOConfig = JSON.parseObject(mountMessage, MountMessageDTO.class);
               if (ObjectUtil.isEmpty(mountMessageDTOConfig) || contains(mountMessageDTOSend, mountMessageDTOConfig)) {
                  wmsApproveTemplateVersionsGet = wmsApproveTemplateVersions;
                  break label125;
               }
            }
         }

         if (ObjectUtil.isNotEmpty(currentUser.getJob())) {
            id = currentUser.getJob().getId();
            idStr = "," + id + ",";
            wmsApproveTemplateVersionsList = this.wmsApproveTemplateVersionsService
               .list(
                  (Wrapper<WmsApproveTemplateVersions>)((((new LambdaQueryWrapper<WmsApproveTemplateVersions>()
                                 .eq(WmsApproveTemplateVersions::getApproveProcessType, approveProcessType))
                              .eq(WmsApproveTemplateVersions::getObjType, ApproveObjectTypeEnum.JOB.getType()))
                           .like(WmsApproveTemplateVersions::getObjIds, idStr))
                        .eq(WmsApproveTemplateVersions::getUseStatus, UseEnum.USE.getType()))
                     .eq(WmsApproveTemplateVersions::getStatus, EnableEnum.ENABLE.getType())
               );
            if (CollectionUtils.isNotEmpty(wmsApproveTemplateVersionsList)) {
               for (WmsApproveTemplateVersions wmsApproveTemplateVersions : wmsApproveTemplateVersionsList) {
                  String mountMessage = wmsApproveTemplateVersions.getMountMessage();
                  MountMessageDTO mountMessageDTOConfig = JSON.parseObject(mountMessage, MountMessageDTO.class);
                  if (ObjectUtil.isEmpty(mountMessageDTOConfig) || contains(mountMessageDTOSend, mountMessageDTOConfig)) {
                     wmsApproveTemplateVersionsGet = wmsApproveTemplateVersions;
                     break label125;
                  }
               }
            }
         }

         if (ObjectUtil.isNotEmpty(currentUser.getDepartment())) {
            id = currentUser.getDepartment().getId();
            List<Long> departmentIds = this.departmentService.getDepartIdsById(id);
            List<WmsApproveTemplateVersions> wmsApproveTemplateVersionsListx = new ArrayList<>();
            Iterator<Long> var28 = departmentIds.iterator();

            label73:
            while (true) {
               if (var28.hasNext()) {
                  Long departId = (Long)var28.next();
                  idStr = "," + departId + ",";
                  wmsApproveTemplateVersionsListx = this.wmsApproveTemplateVersionsService
                     .list(
                        (Wrapper<WmsApproveTemplateVersions>)((((new LambdaQueryWrapper<WmsApproveTemplateVersions>()
                                       .eq(WmsApproveTemplateVersions::getApproveProcessType, approveProcessType))
                                    .eq(WmsApproveTemplateVersions::getObjType, ApproveObjectTypeEnum.DEPARTMENT.getType()))
                                 .like(WmsApproveTemplateVersions::getObjIds, idStr))
                              .eq(WmsApproveTemplateVersions::getUseStatus, UseEnum.USE.getType()))
                           .eq(WmsApproveTemplateVersions::getStatus, EnableEnum.ENABLE.getType())
                     );
                  if (!CollectionUtils.isNotEmpty(wmsApproveTemplateVersionsListx)) {
                     continue;
                  }
               }

               if (!CollectionUtils.isNotEmpty(wmsApproveTemplateVersionsListx)) {
                  break;
               }

               Iterator<WmsApproveTemplateVersions> versionIterator = wmsApproveTemplateVersionsListx.iterator();

               MountMessageDTO mountMessageDTOConfig;
               WmsApproveTemplateVersions wmsApproveTemplateVersions;
               do {
                  if (!versionIterator.hasNext()) {
                     break label73;
                  }

                  wmsApproveTemplateVersions = (WmsApproveTemplateVersions)versionIterator.next();
                  String mountMessage = wmsApproveTemplateVersions.getMountMessage();
                  mountMessageDTOConfig = JSON.parseObject(mountMessage, MountMessageDTO.class);
               } while (!ObjectUtil.isEmpty(mountMessageDTOConfig) && !contains(mountMessageDTOSend, mountMessageDTOConfig));

               wmsApproveTemplateVersionsGet = wmsApproveTemplateVersions;
               break label125;
            }
         }

         List<WmsApproveTemplateVersions> wmsApproveTemplateVersionsListx = this.wmsApproveTemplateVersionsService
            .list(
               (Wrapper<WmsApproveTemplateVersions>)(((new LambdaQueryWrapper<WmsApproveTemplateVersions>()
                           .eq(WmsApproveTemplateVersions::getApproveProcessType, approveProcessType))
                        .eq(WmsApproveTemplateVersions::getObjType, ApproveObjectTypeEnum.COMPANY.getType()))
                     .eq(WmsApproveTemplateVersions::getUseStatus, UseEnum.USE.getType()))
                  .eq(WmsApproveTemplateVersions::getStatus, EnableEnum.ENABLE.getType())
            );
         if (ObjectUtil.isNotEmpty(wmsApproveTemplateVersionsListx)) {
            for (WmsApproveTemplateVersions wmsApproveTemplateVersions : wmsApproveTemplateVersionsListx) {
               String mountMessage = wmsApproveTemplateVersions.getMountMessage();
               MountMessageDTO mountMessageDTOConfig = JSON.parseObject(mountMessage, MountMessageDTO.class);
               if (ObjectUtil.isEmpty(mountMessageDTOConfig) || contains(mountMessageDTOSend, mountMessageDTOConfig)) {
                  wmsApproveTemplateVersionsGet = wmsApproveTemplateVersions;
                  break;
               }
            }
         }
      }

      if (ObjectUtil.isNotEmpty(wmsApproveTemplateVersionsGet)) {
         wmsApproveTemplateFlows = this.wmsApproveTemplateVersionsFlowMapper
            .selectList(
               (Wrapper<WmsApproveTemplateVersionsFlow>)(new LambdaQueryWrapper<WmsApproveTemplateVersionsFlow>()
                     .eq(WmsApproveTemplateVersionsFlow::getApproveVersionsId, wmsApproveTemplateVersionsGet.getId()))
                  .orderByAsc(WmsApproveTemplateVersionsFlow::getId)
            );
      }

      return wmsApproveTemplateFlows;
   }

   @Override
   public List<WmsModuleDTO> getType() {
      List<WmsApproveTemplateDTO> wmsApproveTemplateDTOS = ApproveProcessTypeEnumV2.getTemplate();
      TreeSet<WmsApproveTemplateDTO> wmsApproveTemplatesTreeSet = new TreeSet<>(Comparator.comparing(WmsApproveTemplateDTO::getModuleType));
      wmsApproveTemplatesTreeSet.addAll(wmsApproveTemplateDTOS);
      List<WmsModuleDTO> wmsModuleDTOS = new ArrayList<>();

      for (WmsApproveTemplateDTO wmsApproveTemplate : wmsApproveTemplatesTreeSet) {
         WmsModuleDTO wmsModuleDTO = new WmsModuleDTO();
         List<WmsApproveTemplateDTO> collect = wmsApproveTemplateDTOS.stream()
            .filter(w -> w.getModuleType().equals(wmsApproveTemplate.getModuleType()))
            .collect(Collectors.toList());
         wmsModuleDTO.setModuleType(wmsApproveTemplate.getModuleType());
         wmsModuleDTO.setModuleTypeName(ModuleTypeEnum.getName(wmsApproveTemplate.getModuleType()));
         List<WmsModuleApproveTemplateDTO> wmsModuleApproveTemplateDTOS = new ArrayList<>();

         for (WmsApproveTemplateDTO approveTemplate : collect) {
            WmsModuleApproveTemplateDTO wmsModuleApproveTemplateDTO = new WmsModuleApproveTemplateDTO();
            wmsModuleApproveTemplateDTO.setFunctionType(approveTemplate.getFunctionType());
            wmsModuleApproveTemplateDTO.setApproveProcessType(approveTemplate.getApproveProcessType());
            wmsModuleApproveTemplateDTO.setApproveProcessName(approveTemplate.getName());
            wmsModuleApproveTemplateDTOS.add(wmsModuleApproveTemplateDTO);
         }

         wmsModuleDTO.setWmsModuleApproveTemplateDTOS(wmsModuleApproveTemplateDTOS);
         wmsModuleDTOS.add(wmsModuleDTO);
      }

      return wmsModuleDTOS;
   }

   public static boolean contains(MountMessageDTO mountMessageDTOSend, MountMessageDTO mountMessageDTOConfig) {
      if (ObjectUtil.isEmpty(mountMessageDTOSend)) {
         return true;
      }

      Class<?> clazz = mountMessageDTOSend.getClass();
      Field[] fields = clazz.getDeclaredFields();

      for (Field field : fields) {
         field.setAccessible(true);

         try {
            Object valueA = field.get(mountMessageDTOSend);
            Object valueB = field.get(mountMessageDTOConfig);
            if (valueA != null && valueA instanceof List && valueB instanceof List) {
               List<?> listA = (List<?>)valueA;
               List<?> listB = (List<?>)valueB;
               if (CollectionUtils.isNotEmpty(listA)) {
                  boolean disjoint = Collections.disjoint(listA, listB);
                  if (disjoint) {
                     return false;
                  }
               }
            }
         } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
         }
      }

      return true;
   }

   private String judgeMountMessageDTO(List<WmsApproveTemplateVersions> wmsApproveTemplateVersionsList, MountMessageDTO mountMessageDTOSend) {
      String name = null;

      for (WmsApproveTemplateVersions wmsApproveTemplateVersions : wmsApproveTemplateVersionsList) {
         String mountMessage = wmsApproveTemplateVersions.getMountMessage();
         MountMessageDTO mountMessageDTOConfig = JSON.parseObject(mountMessage, MountMessageDTO.class);
         boolean contains = contains(mountMessageDTOSend, mountMessageDTOConfig);
         if (contains) {
            name = wmsApproveTemplateVersions.getName();
            break;
         }
      }

      return name;
   }
}
