package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.BranchAttributeEnum;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.pojo._do.BankAccount;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import com.hzchum.scim.system.core.api.pojo.dto.BankAccountDTO;
import com.hzchum.scim.system.core.api.pojo.dto.BankAccountSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.BankAccountSimpleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.BankAccountVO;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanyConditionVO;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanyDTO;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanySaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanySimpleVO;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanyUpdateDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.BranchProjectVO;
import com.hzchum.scim.system.core.api.service.BankAccountService;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.MenuService;
import com.hzchum.scim.system.core.mapper.BranchCompanyMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BranchCompanyServiceImpl extends ServiceImpl<BranchCompanyMapper, BranchCompany> implements BranchCompanyService {
   private static final String MENU_LIST = "menus";
   @Resource
   private BankAccountService bankAccountService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ApplyPurchaseService applyPurchaseService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private MenuService menuService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   @Resource
   private MesBuildingFactoryService factoryService;
   @Resource
   private ProjectFinanceUtils projectFinanceUtils;

   @Override
   public PageVO<BranchCompanyDTO> pageByCondition(String name, String socialCode, Integer enabled, Integer pageNumber, Integer pageSize) {
      return this.pageByCondition(name, socialCode, enabled, null, pageNumber, pageSize);
   }

   @Override
   public PageVO<BranchCompanyDTO> pageByCondition(String name, String socialCode, Integer enabled, Integer level, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<BranchCompanyDTO> branchCompanyList = this.baseMapper
         .listByCondition(BranchCompanyConditionVO.builder().name(name).socialCode(socialCode).enabled(enabled).level(level).build());
      branchCompanyList.forEach(
         c -> {
            List<BankAccount> bankAccountList = this.bankAccountService
               .list((Wrapper<BankAccount>)Wrappers.<BankAccount>lambdaQuery().eq(BankAccount::getBranchCompanyId, c.getId()));
            if (CollectionUtils.isNotEmpty(bankAccountList)) {
               List<BankAccountVO> accountVOList = bankAccountList.stream().map(b -> BeanUtil.copy(b, BankAccountVO.class)).collect(Collectors.toList());
               c.setBankAccounts(accountVOList);
            } else {
               c.setBankAccounts(new ArrayList<>());
            }
         }
      );
      return new PageVO<>(branchCompanyList);
   }

   @Override
   public ListVO<BranchCompanySimpleVO> listSimple() {
      List<BranchCompanyDTO> branchCompanyList = this.baseMapper
         .listByCondition(BranchCompanyConditionVO.builder().enabled(EnableEnum.ENABLE.getType()).build());
      List<BranchCompanySimpleVO> responseVOS = branchCompanyList.stream()
         .map(
            branchCompany -> {
               BranchCompanySimpleVO companySimpleVO = BeanUtil.copy(branchCompany, BranchCompanySimpleVO.class);
               List<BankAccountSimpleDTO> accountSimpleDTOList = this.bankAccountService
                  .list(Wrappers.lambdaQuery(BankAccount.builder().branchCompanyId(branchCompany.getId()).build()))
                  .stream()
                  .map(s -> BeanUtil.copy(s, BankAccountSimpleDTO.class))
                  .collect(Collectors.toList());
               companySimpleVO.setBankAccountList(accountSimpleDTOList);
               return companySimpleVO;
            }
         )
         .collect(Collectors.toList());
      return new ListVO<>(responseVOS);
   }

   @Override
   public ListVO<BranchCompanySimpleVO> purchaseByLevelList(Integer level) {
      List<BranchCompany> branchCompanyList = this.baseMapper
         .selectList(
            (Wrappers.<BranchCompany>lambdaQuery().eq(true, BranchCompany::getEnabled, EnableEnum.ENABLE.getType()))
               .eq(level != null, BranchCompany::getLevel, level)
         );
      List<BranchCompanySimpleVO> responseVOS = branchCompanyList.stream()
         .map(branchCompany -> BeanUtil.copy(branchCompany, BranchCompanySimpleVO.class))
         .collect(Collectors.toList());
      return new ListVO<>(responseVOS);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Long save(BranchCompanySaveDTOParam param) {
      Preconditions.checkArgument(this.projectFinanceUtils.checkVersion(), "未识别当前系统版本!!不可进行当前操作!!");
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (boolTwoLevelUnit) {
         Preconditions.checkArgument(BranchCompanyLevelEnum.check(param.getLevel()), "分支机构单位等级有误!");
         BranchCompany primaryUnitCompany = this.baseMapper
            .selectOne(Wrappers.lambdaQuery(BranchCompany.builder().level(BranchCompanyLevelEnum.PRIMARY_UNIT.getType()).build()));
         if (param.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType())) {
            Preconditions.checkArgument(param.getBranchAttributeEnum().equals(BranchAttributeEnum.INSTALLATION.getType()), "一级单位仅能选择[安装]属性!");
            Preconditions.checkArgument(primaryUnitCompany == null, "一级单位已存在,不可重复添加!");
         } else {
            Preconditions.checkArgument(primaryUnitCompany != null, "请先创建一级单位!");
            Preconditions.checkArgument(param.getBranchAttributeEnum().equals(BranchAttributeEnum.MANUFACTURING.getType()), "二级单位仅能选择[加工]属性!");
            int count = this.baseMapper
               .selectCount(
                  Wrappers.lambdaQuery(BranchCompany.class)
                     .eq(BranchCompany::getLevel, BranchCompanyLevelEnum.SECONDARY_UNIT.getType())
                     .eq(BranchCompany::getBranchAttributeEnum, BranchAttributeEnum.MANUFACTURING.getType())
               );
            Preconditions.checkArgument(count == 0, "已存在[加工]属性的二级单位!");
         }
      } else {
         Preconditions.checkArgument(!BranchCompanyLevelEnum.PRIMARY_UNIT.getType().equals(param.getLevel()), "当前系统不支持创建一级单位!");
         if (param.getBranchAttributeEnum().equals(BranchAttributeEnum.MANUFACTURING.getType())) {
            int count = this.baseMapper
               .selectCount(
                  Wrappers.lambdaQuery(BranchCompany.class)
                     .eq(BranchCompany::getLevel, BranchCompanyLevelEnum.SECONDARY_UNIT.getType())
                     .eq(BranchCompany::getBranchAttributeEnum, BranchAttributeEnum.MANUFACTURING.getType())
               );
            Preconditions.checkArgument(count == 0, "已存在[加工]属性的二级单位!");
         }

         Boolean boolProjectVersion = this.projectFinanceUtils.getBoolProjectVersion();
         Preconditions.checkArgument(
            boolProjectVersion || !param.getBranchAttributeEnum().equals(BranchAttributeEnum.INSTALLATION.getType()), "当前系统不支持选择[安装]属性!"
         );
      }

      if (param.getIsParent() == 1) {
         this.cancelParentCompany();
      }

      this.checkCompanyName(param.getName(), param.getShortName());
      this.checkSocialCode(param.getSocialCode());
      BranchCompany company = BeanUtil.copy(param, BranchCompany.class);
      company.setLevel(param.getLevel() != null ? param.getLevel() : BranchCompanyLevelEnum.SECONDARY_UNIT.getType());
      this.baseMapper.insert(company);
      this.checkIsRepeatAndSave(param.getBankAccounts(), company.getId());
      if (boolTwoLevelUnit) {
         String levelName = company.getLevel().equals(1) ? "一级单位" : "二级单位";
         Menu menu = this.menuService.getOne(Wrappers.lambdaQuery(Menu.class).eq(Menu::getPid, 1016L).eq(Menu::getName, levelName));
         if (menu != null) {
            menu.setName(company.getShortName());
            this.menuService.updateById(menu);
            this.redisUtils.del("menus");
            List<NameInfo> nameInfos = this.menuService.listModuleMenu(null);
            this.redisUtils.set("menus", nameInfos);
         }
      }

      return company.getId();
   }

   private void checkSocialCode(String socialCode) {
      if (StringUtils.isNotBlank(socialCode)) {
         Integer count = this.baseMapper.selectCount((Wrapper<BranchCompany>)Wrappers.<BranchCompany>lambdaQuery().eq(BranchCompany::getSocialCode, socialCode));
         Preconditions.checkArgument(count == 0, "该社会统一信用代码已存在，请勿重复添加");
      }
   }

   private void checkCompanyName(String name, String shortName) {
      if (name != null) {
         Integer count = this.baseMapper.selectCount((Wrapper<BranchCompany>)Wrappers.<BranchCompany>lambdaQuery().eq(BranchCompany::getName, name));
         Preconditions.checkArgument(count == 0, "该公司名称已存在，请勿重复添加!");
      }

      if (shortName != null) {
         Integer count = this.baseMapper.selectCount((Wrapper<BranchCompany>)Wrappers.<BranchCompany>lambdaQuery().eq(BranchCompany::getShortName, shortName));
         Preconditions.checkArgument(count == 0, "该公司简称已存在，请勿重复添加!");
      }
   }

   private void checkIsRepeatAndSave(List<BankAccountSaveDTOParam> bankAccountList, Long branchCompanyId) {
      if (CollectionUtils.isNotEmpty(bankAccountList)) {
         List<String> accountList = bankAccountList.stream().map(item -> item.getAccount()).distinct().collect(Collectors.toList());
         Preconditions.checkArgument(accountList.size() == bankAccountList.size(), "账号存在重复，请重新输入");
         bankAccountList.forEach(item -> {
            BankAccount copy = BeanUtil.copy(item, BankAccount.class);
            copy.setBranchCompanyId(branchCompanyId);
            this.bankAccountService.save(copy);
         });
      }
   }

   private void cancelParentCompany() {
      BranchCompany check = this.baseMapper.selectOne((Wrapper<BranchCompany>)Wrappers.<BranchCompany>lambdaQuery().eq(BranchCompany::getIsParent, 1));
      if (check != null) {
         check.setIsParent(0);
         this.baseMapper.updateById(check);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean update(BranchCompanyUpdateDTOParam param) {
      BranchCompany branchCompany = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(branchCompany != null, "更新失败，分支机构不存在");
      Preconditions.checkArgument(branchCompany.getEnabled().equals(param.getEnabled()), "更新失败，状态不允许修改");
      Preconditions.checkArgument(param.getLevel() == null || param.getLevel().equals(branchCompany.getLevel()), "不允许修改单位等级!!");
      if (branchCompany.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType())) {
         Preconditions.checkArgument(branchCompany.getBranchAttributeEnum().equals(param.getBranchAttributeEnum()), "一级单位不可修改单位属性!");
      }

      if (!branchCompany.getBranchAttributeEnum().equals(param.getBranchAttributeEnum())) {
         Preconditions.checkArgument(this.projectFinanceUtils.checkVersion(), "未识别当前系统版本!!不可进行当前操作!!");
         if (param.getBranchAttributeEnum().equals(BranchAttributeEnum.INSTALLATION.getType())) {
            Preconditions.checkArgument(this.projectFinanceUtils.getBoolProjectVersion(), "本系统暂不支持二级单位选择[安装]属性");
            if (branchCompany.getBranchAttributeEnum().equals(BranchAttributeEnum.MANUFACTURING.getType())) {
               int count = this.factoryService.count(Wrappers.lambdaQuery(MesBuildingFactory.builder().branchCompanyId(param.getId()).build()));
               Preconditions.checkArgument(count == 0, "分支机构已关联工厂,不可改为[安装]属性!");
            }
         }

         if (param.getBranchAttributeEnum().equals(BranchAttributeEnum.MANUFACTURING.getType())) {
            Integer count = this.baseMapper
               .selectCount(Wrappers.lambdaQuery(BranchCompany.builder().branchAttributeEnum(BranchAttributeEnum.MANUFACTURING.getType()).build()));
            Preconditions.checkArgument(count == 0, "已存在[加工]属性的分支机构!");
         }

         if (param.getBranchAttributeEnum().equals(BranchAttributeEnum.OTHER.getType())) {
            Preconditions.checkArgument(!this.projectFinanceUtils.getBoolTwoLevelUnit(), "本系统暂不支持改为[其他]属性!");
            if (branchCompany.getBranchAttributeEnum().equals(BranchAttributeEnum.MANUFACTURING.getType())) {
               int count = this.factoryService.count(Wrappers.lambdaQuery(MesBuildingFactory.builder().branchCompanyId(param.getId()).build()));
               Preconditions.checkArgument(count == 0, "分支机构已关联工厂,不可更改为[其他]属性!");
            }
         }
      }

      if (!param.getName().equals(branchCompany.getName())) {
         this.checkCompanyName(param.getName(), null);
      }

      if (!param.getShortName().equals(branchCompany.getShortName())) {
         this.checkCompanyName(null, param.getShortName());
      }

      if (StringUtils.isNotBlank(param.getSocialCode()) && !param.getSocialCode().equals(branchCompany.getSocialCode())) {
         this.checkSocialCode(param.getSocialCode());
      }

      if (param.getIsParent() != null && param.getIsParent() == 1 && branchCompany.getIsParent() == 0) {
         this.cancelParentCompany();
      }

      String oldShortName = branchCompany.getShortName();
      BeanUtil.copy(param, branchCompany);
      this.bankAccountService.remove((Wrapper<BankAccount>)Wrappers.<BankAccount>lambdaQuery().eq(BankAccount::getBranchCompanyId, param.getId()));
      this.checkIsRepeatAndSave(param.getBankAccounts(), branchCompany.getId());
      this.baseMapper.updateById(branchCompany);
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (boolTwoLevelUnit && !param.getShortName().equals(oldShortName)) {
         Menu menu = this.menuService.getOne(Wrappers.lambdaQuery(Menu.class).eq(Menu::getPid, 1016L).eq(Menu::getName, oldShortName));
         if (menu != null) {
            menu.setName(param.getShortName());
            this.menuService.updateById(menu);
            this.redisUtils.del("menus");
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(List<Long> ids) {
      ids.forEach(id -> {
         BranchCompany branchCompany = this.baseMapper.selectById(id);
         Preconditions.checkArgument(branchCompany != null, "删除失败，分支机构不存在");
         Preconditions.checkArgument(!branchCompany.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType()), "不可删除一级单位分支机构!");
         int count = this.factoryService.count(Wrappers.lambdaQuery(MesBuildingFactory.builder().branchCompanyId(id).build()));
         Preconditions.checkArgument(count == 0, "删除失败,分支机构已关联工厂!");
         count = this.projectService.count(Wrappers.lambdaQuery(ContractProject.builder().build()).eq(ContractProject::getContractSignBodyId, id));
         Preconditions.checkArgument(count == 0, "删除失败,分支机构已关联项目合同!");
         count = this.projectBranchCompanyLinkService.count(Wrappers.lambdaQuery(ProjectBranchCompanyLink.builder().branchCompanyId(id).build()));
         Preconditions.checkArgument(count == 0, "删除失败,分支机构已关联项目合同!");
         count = this.applyPurchaseService.count(Wrappers.lambdaQuery(ApplyPurchase.builder().build()).eq(ApplyPurchase::getBranchCompanyId, id));
         Preconditions.checkArgument(count == 0, "删除失败,分支机构已关联物料申购单!");
         count = this.purchaseOrderService.count(Wrappers.lambdaQuery(PurchaseOrder.builder().build()).eq(PurchaseOrder::getBranchCompanyId, id));
         Preconditions.checkArgument(count == 0, "删除失败,分支机构已关联物料采购单!");
         this.baseMapper.deleteById(id);
         this.bankAccountService.remove((Wrapper<BankAccount>)Wrappers.<BankAccount>lambdaQuery().eq(BankAccount::getBranchCompanyId, id));
      });
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateEnabled(Long id, Integer enabled) {
      Preconditions.checkArgument(EnableEnum.isExist(enabled), "更新失败，参数错误!");
      BranchCompany branchCompany = this.baseMapper.selectById(id);
      Preconditions.checkArgument(branchCompany != null, "更新失败，分支机构不存在");
      if (EnableEnum.DISABLE.getType().equals(enabled)) {
         Preconditions.checkArgument(!branchCompany.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType()), "不可禁用一级单位分支机构!");
         int count = this.factoryService.count(Wrappers.lambdaQuery(MesBuildingFactory.builder().branchCompanyId(id).build()));
         Preconditions.checkArgument(count == 0, "分支机构已关联工厂!");
         count = this.projectBranchCompanyLinkService.count(Wrappers.lambdaQuery(ProjectBranchCompanyLink.builder().branchCompanyId(id).build()));
         Preconditions.checkArgument(count == 0, "分支机构已关联项目!");
         count = this.applyPurchaseService.count(Wrappers.lambdaQuery(ApplyPurchase.builder().build()).eq(ApplyPurchase::getBranchCompanyId, id));
         Preconditions.checkArgument(count == 0, "分支机构已关联物料申购单!");
         count = this.purchaseOrderService.count(Wrappers.lambdaQuery(PurchaseOrder.builder().build()).eq(PurchaseOrder::getBranchCompanyId, id));
         Preconditions.checkArgument(count == 0, "分支机构已关联物料采购单!");
      }

      branchCompany.setEnabled(enabled);
      return this.baseMapper.updateById(branchCompany) == 1;
   }

   @Override
   public ListVO<BankAccountDTO> listBlankAccount() {
      List<BankAccountDTO> bankAccountDTOS = this.listCompanyAccount();
      return new ListVO<>(bankAccountDTOS);
   }

   @Override
   public List<BankAccountDTO> listCompanyAccount() {
      return this.baseMapper.listBlankAccount();
   }

   @Override
   public String getNameById(Long id) {
      if (id == null) {
         return null;
      }

      BranchCompany branchCompany = this.baseMapper.selectById(id);
      return branchCompany != null ? branchCompany.getName() : null;
   }

   @Override
   public String getShortNameById(Long id) {
      if (id == null) {
         return null;
      }

      BranchCompany branchCompany = this.baseMapper.selectById(id);
      return branchCompany != null ? branchCompany.getShortName() : null;
   }

   @Override
   public List<BranchProjectVO> getBranchProjectList() {
      List<BranchCompany> branchCompanyList = this.list(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getEnabled, true));
      if (CollUtil.isNotEmpty(branchCompanyList)) {
         List<Long> branchCompanyIdList = branchCompanyList.stream().map(BranchCompany::getId).collect(Collectors.toList());
         List<ProjectBranchCompanyLink> projectBranchCompanyLinks = this.projectBranchCompanyLinkService
            .list(Wrappers.lambdaQuery(ProjectBranchCompanyLink.class).in(ProjectBranchCompanyLink::getBranchCompanyId, branchCompanyIdList));
         if (CollUtil.isNotEmpty(projectBranchCompanyLinks)) {
            List<Long> projectIds = projectBranchCompanyLinks.stream().map(ProjectBranchCompanyLink::getProjectId).distinct().collect(Collectors.toList());
            Map<Long, ProjectInfo> projectMap = this.projectService
               .listByIds(projectIds)
               .stream()
               .map(cp -> ProjectInfo.builder().id(cp.getId()).name(cp.getName()).shortName(cp.getShortName()).serialNumber(cp.getSerialNumber()).build())
               .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
            Map<Long, List<ProjectInfo>> projectBranchCompanyLinkGroup = projectBranchCompanyLinks.stream()
               .filter(link -> projectMap.containsKey(link.getProjectId()))
               .collect(
                  Collectors.groupingBy(
                     ProjectBranchCompanyLink::getBranchCompanyId,
                     Collectors.mapping(projectBranchCompanyLink -> projectMap.get(projectBranchCompanyLink.getProjectId()), Collectors.toList())
                  )
               );
            return branchCompanyList.stream().map(branchCompany -> {
               BranchProjectVO vo = cn.hutool.core.bean.BeanUtil.toBean(branchCompany, BranchProjectVO.class);
               vo.setProjectList(projectBranchCompanyLinkGroup.getOrDefault(vo.getId(), Collections.emptyList()));
               return vo;
            }).collect(Collectors.toList());
         } else {
            return Collections.emptyList();
         }
      } else {
         return Collections.emptyList();
      }
   }
}
