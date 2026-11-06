package com.hzchum.scim.plan.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.contract.core.api.pojo._do.ContractTech;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.plan.core.api.biz.EnclosurePlanBiz;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailCreateDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailQureyDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailUpdateDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanTechDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureTechQureyDto;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnclosurePlanBizImpl implements EnclosurePlanBiz {
   private static final Logger log = LoggerFactory.getLogger(EnclosurePlanBizImpl.class);
   @Autowired
   private ContractProjectService projectService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ContractProjectContentService projectContentService;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private TechEnclosureService enclosureService;

   @Override
   public ResultVO<PageVO<EnclosurePlanDetailDto>> findAll(EnclosurePlanDetailQureyDto dto) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      PageHelper.startPage(dto.getPageNumber(), dto.getPageSize());
      List<EnclosurePlanDetailDto> enclosurePlanDetailDtos = this.projectService.queryEnclosurePlan(dto, projectIds);
      Object objectProjectContentList = this.redisUtils.get("project_content_list");
      List<ContractProjectContent> projectContentList;
      if (objectProjectContentList == null) {
         projectContentList = this.projectContentService.list();
         this.redisUtils.set("project_content_list", projectContentList);
      } else {
         projectContentList = (List<ContractProjectContent>)objectProjectContentList;
      }

      enclosurePlanDetailDtos.forEach(
         p -> {
            List<Long> pidList = Arrays.stream(StringUtils.split(p.getProjectContent(), ",")).map(Long::parseLong).collect(Collectors.toList());
            List<String> projectContentNameList = projectContentList.stream()
               .filter(s -> pidList.contains(s.getId()))
               .map(ContractProjectContent::getName)
               .collect(Collectors.toList());
            p.setProjectContent(StringUtils.join(projectContentNameList.stream().filter(c -> !c.equals("结构件")).collect(Collectors.toList()), "、"));
            LambdaQueryWrapper<ContractTech> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ContractTech::getStatus, 1).eq(ContractTech::getProjectId, p.getProjectId()).ne(ContractTech::getType, 1);
            int count = this.contractTechService.count(wrapper);
            LambdaQueryWrapper<ContractTech> wrapper1 = new LambdaQueryWrapper<>();
            wrapper1.eq(ContractTech::getProjectId, p.getProjectId()).ne(ContractTech::getType, 1);
            int count1 = this.contractTechService.count(wrapper1);
            if (count == 0) {
               p.setType(0);
            } else if (count == count1) {
               p.setType(1);
            } else {
               p.setType(2);
            }
         }
      );
      return ResultBuilder.success(new PageVO<>(enclosurePlanDetailDtos));
   }

   @Override
   public ResultVO<List<EnclosurePlanTechDto>> findByProjectId(Long projectId) {
      List<EnclosurePlanTechDto> enclosurePlanTechDtos = this.contractTechService.findByProjectId(projectId);
      return ResultBuilder.success(enclosurePlanTechDtos);
   }

   @Transactional
   @Override
   public ResultVO addEnclosurePlan(EnclosurePlanDetailCreateDto dto) {
      Long projectId = dto.getProjectId();
      LambdaQueryWrapper<ContractTech> wrapper = new LambdaQueryWrapper<>();
      wrapper.eq(ContractTech::getProjectId, projectId).eq(ContractTech::getType, dto.getCategory());
      ContractTech contractTech = this.contractTechService.getOne(wrapper);
      if (contractTech == null) {
         throw new BusinessException("操作失败，查询不到围护计划单信息!");
      }

      LambdaQueryWrapper<EnclosurePlan> wrapper1 = new LambdaQueryWrapper<>();
      wrapper1.eq(EnclosurePlan::getName, dto.getName()).eq(EnclosurePlan::getCategory, dto.getCategory()).eq(EnclosurePlan::getProjectId, dto.getProjectId());
      List<EnclosurePlan> enclosurePlans = this.enclosurePlanService.list(wrapper1);
      if (enclosurePlans != null && enclosurePlans.size() != 0) {
         throw new BusinessException("操作失败，名称重复!");
      }

      if (contractTech.getMeasureMode() == 1) {
         dto.setQuantityWork(dto.getQuantityWork().multiply(new BigDecimal(1000)));
      } else {
         dto.setQuantityWork(dto.getQuantityWork().multiply(new BigDecimal(1000000)));
      }

      EnclosurePlan enclosurePlan = new EnclosurePlan();
      enclosurePlan.setProjectId(projectId);
      BeanUtils.copyProperties(dto, enclosurePlan);
      enclosurePlan.setCategory(contractTech.getType());
      boolean flag = this.enclosurePlanService.save(enclosurePlan);
      if (!flag) {
         throw new BusinessException("操作失败，请稍后重试!");
      }

      contractTech.setStatus(1);
      this.contractTechService.updateById(contractTech);
      this.redisUtils.del("simpleProjectList");
      return ResultBuilder.success(flag);
   }

   @Override
   public ResultVO<PageVO<EnclosurePlan>> findBytechId(EnclosureTechQureyDto dto, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<EnclosurePlan> enclosurePlans = this.enclosurePlanService
         .list(Wrappers.lambdaQuery(EnclosurePlan.builder().projectId(dto.getProjectId()).category(dto.getCategory()).build()));
      LambdaQueryWrapper<ContractTech> wrapper = new LambdaQueryWrapper<>();
      wrapper.eq(ContractTech::getProjectId, dto.getProjectId()).eq(ContractTech::getType, dto.getCategory());
      ContractTech contractTech = this.contractTechService.getOne(wrapper);

      for (EnclosurePlan enclosurePlan : enclosurePlans) {
         if (contractTech.getMeasureMode() == 1) {
            enclosurePlan.setQuantityWork(enclosurePlan.getQuantityWork().divide(new BigDecimal(1000)));
         } else {
            enclosurePlan.setQuantityWork(enclosurePlan.getQuantityWork().divide(new BigDecimal(1000000)));
         }
      }

      return ResultBuilder.success(new PageVO<>(enclosurePlans));
   }

   @Transactional
   @Override
   public ResultVO deleteById(Long id) {
      EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(id);
      if (enclosurePlan == null) {
         throw new BusinessException("操作失败，查询不到计划单信息!");
      }

      LambdaQueryWrapper<ContractTech> wrapperTech = new LambdaQueryWrapper<>();
      wrapperTech.eq(ContractTech::getProjectId, enclosurePlan.getProjectId()).eq(ContractTech::getType, enclosurePlan.getCategory());
      ContractTech contractTech = this.contractTechService.getOne(wrapperTech);
      LambdaQueryWrapper<TechEnclosure> wrapperCount = new LambdaQueryWrapper<>();
      wrapperCount.eq(TechEnclosure::getEnclosurePlanId, id);
      int integer = this.enclosureService.count(wrapperCount);
      if (integer != 0) {
         throw new BusinessException("操作失败，有清单计划无法删除!");
      }

      boolean b = this.enclosurePlanService.removeById(id);
      if (!b) {
         throw new BusinessException("操作失败，请稍后重试!");
      }

      LambdaQueryWrapper<EnclosurePlan> wrapper = new LambdaQueryWrapper<>();
      wrapper.eq(EnclosurePlan::getProjectId, contractTech.getProjectId()).eq(EnclosurePlan::getCategory, contractTech.getType());
      List<EnclosurePlan> enclosurePlans = this.enclosurePlanService.list(wrapper);
      if (enclosurePlans == null || enclosurePlans.size() == 0) {
         contractTech.setStatus(0);
         this.contractTechService.updateById(contractTech);
      }

      this.redisUtils.del("simpleProjectList");
      return ResultBuilder.success(b);
   }

   @Transactional
   @Override
   public ResultVO modifyById(EnclosurePlanDetailUpdateDto dto) {
      Long id = dto.getId();
      EnclosurePlan enclosurePlan = this.enclosurePlanService.getById(id);
      if (enclosurePlan == null) {
         throw new BusinessException("操作失败，查询不到计划单信息!");
      }

      LambdaQueryWrapper<ContractTech> wrapperTech = new LambdaQueryWrapper<>();
      wrapperTech.eq(ContractTech::getProjectId, enclosurePlan.getProjectId()).eq(ContractTech::getType, enclosurePlan.getCategory());
      ContractTech contractTech = this.contractTechService.getOne(wrapperTech);
      if (contractTech.getMeasureMode() == 1) {
         dto.setQuantityWork(dto.getQuantityWork().multiply(new BigDecimal(1000)));
      } else {
         dto.setQuantityWork(dto.getQuantityWork().multiply(new BigDecimal(1000000)));
      }

      BeanUtils.copyProperties(dto, enclosurePlan);
      boolean b = this.enclosurePlanService.updateById(enclosurePlan);
      if (!b) {
         throw new BusinessException("操作失败，请稍后重试!");
      } else {
         LambdaQueryWrapper<EnclosurePlan> wrapper = new LambdaQueryWrapper<>();
         wrapper.eq(EnclosurePlan::getName, dto.getName())
            .eq(EnclosurePlan::getCategory, contractTech.getType())
            .eq(EnclosurePlan::getProjectId, contractTech.getProjectId());
         List<EnclosurePlan> enclosurePlans = this.enclosurePlanService.list(wrapper);
         if (enclosurePlans.size() > 1) {
            throw new BusinessException("操作失败，名称不能重复!");
         } else {
            return ResultBuilder.success(b);
         }
      }
   }

   @Override
   public ResultVO<List<EnclosurePlan>> findAllPlan(Long id) {
      LambdaQueryWrapper<EnclosurePlan> wrapper = new LambdaQueryWrapper<>();
      wrapper.eq(EnclosurePlan::getProjectId, id);
      List<EnclosurePlan> enclosurePlans = this.enclosurePlanService.list(wrapper);
      return ResultBuilder.success(enclosurePlans);
   }
}
