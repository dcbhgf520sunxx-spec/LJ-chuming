package com.hzchum.scim.system.core.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.system.core.api.common.enums.DeptAndJobTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DeptUserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.JobResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.JobSaveRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.JobUpdateRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.JobUserUpdateDTO;
import com.hzchum.scim.system.core.api.pojo.dto.UserJobResponseVO;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.mapper.DepartmentMapper;
import com.hzchum.scim.system.core.mapper.JobMapper;
import com.hzchum.scim.system.core.mapper.UserMapper;
import com.hzchum.scim.system.core.security.GeneratorUserDetailService;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {
   @Resource
   private JobMapper jobMapper;
   @Resource
   private DepartmentMapper departmentMapper;
   @Resource
   private UserMapper userMapper;

   @Override
   public ListVO<JobResponseVO> listByDeptId(Long deptId, Integer enabled) {
      return new ListVO<>(this.jobMapper.listByDeptIdAndNameAndEnabled(deptId, null, enabled, null, null));
   }

   @Override
   public PageVO<JobResponseVO> pageByNameAndDeptId(String name, Integer enabled, Integer jobType, String code, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<JobResponseVO> list = this.jobMapper.listByDeptIdAndNameAndEnabled(null, name, enabled, jobType, code);
      return new PageVO<>(list);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean deleteJobs(List<Long> ids) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(ids), "删除失败,未选中任何岗位");
      ids.forEach(id -> {
         Job job = this.jobMapper.selectById(id);
         Preconditions.checkArgument(job != null, "删除失败,对应的岗位不存在");
         Preconditions.checkArgument(job.getIsAdmin().equals(0), "删除失败,禁止删除默认岗位");
         Preconditions.checkArgument(this.jobMapper.checkJobIsUsed(id) == 0, "删除失败," + job.getName() + "岗位正在被使用");
         this.jobMapper.deleteById(id);
      });
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean updateJob(JobUpdateRequestVO requestVO) {
      Job job = this.jobMapper.selectById(requestVO.getId());
      Preconditions.checkArgument(job != null, "更新失败，岗位不存在!");
      Preconditions.checkArgument(job.getIsAdmin().equals(0), "更新失败，禁止修改默认岗位");
      if (!requestVO.getDeptId().equals(job.getDeptId()) || !job.getName().equals(requestVO.getName())) {
         Preconditions.checkArgument(this.jobMapper.getByDeptIdAndName(requestVO.getDeptId(), requestVO.getName()) == null, "更新失败，该部门下已存在该岗位");
      }

      BeanUtil.copy(requestVO, job);
      this.jobMapper.updateById(job);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Long saveJob(JobSaveRequestVO requestVO) {
      Preconditions.checkArgument(this.departmentMapper.selectById(requestVO.getDeptId()) != null, "保存失败，该部门不存在。");
      Preconditions.checkArgument(this.jobMapper.getByDeptIdAndName(requestVO.getDeptId(), requestVO.getName()) == null, "保存失败，该部门下已存在对应岗位。");
      Job job = BeanUtil.copy(requestVO, Job.class);
      job.setIsAdmin(0);
      job.setJobType(DeptAndJobTypeEnum.ESTABLISHMENT_OUTER.getType());
      this.jobMapper.insert(job);
      return job.getId();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean setEnabled(Long id, Integer enabled) {
      Job job = this.jobMapper.selectById(id);
      Preconditions.checkArgument(job != null, "禁用失败，对应的岗位不存在");
      Preconditions.checkArgument(job.getIsAdmin().equals(0), "禁用失败，禁止修改默认岗位状态");
      if (Objects.equals(EnableEnum.DISABLE.getType(), enabled)) {
         Integer count = this.userMapper
            .selectCount((Wrapper<User>)(new LambdaQueryWrapper<User>().eq(User::getJobId, id)).eq(User::getIsEnabled, true));
         Preconditions.checkArgument(count.equals(0), "禁用失败，" + job.getName() + "岗位正在被使用!");
      }

      job.setEnabled(enabled);
      this.jobMapper.updateById(job);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveJobUser(JobUserUpdateDTO jobUserUpdateDTO) {
      Job job = this.jobMapper.selectById(jobUserUpdateDTO.getJobId());
      Preconditions.checkArgument(job != null, "对应的岗位不存在");
      Preconditions.checkArgument(job.getEnabled().equals(1), "该岗位状态已关闭,无法配置用户信息");
      List<User> users = this.userMapper
         .selectList(
            ((new LambdaQueryWrapper<User>().eq(User::getJobId, job.getId())).eq(User::getIsEnabled, true))
               .notIn(CollectionUtils.isNotEmpty(jobUserUpdateDTO.getUserIds()), User::getId, jobUserUpdateDTO.getUserIds())
         );
      Long deptId = job.getDeptId();
      if (CollectionUtils.isNotEmpty(jobUserUpdateDTO.getUserIds())) {
         List<User> usersSave = this.userMapper.selectBatchIds(jobUserUpdateDTO.getUserIds());
         Preconditions.checkArgument(usersSave.size() == jobUserUpdateDTO.getUserIds().size(), "部分用户不存在");

         for (User user : usersSave) {
            Preconditions.checkArgument(user.getDepartmentId().equals(deptId), user.getName() + "与岗位的部门信息不匹配，请刷新重试");
            Preconditions.checkArgument(user.getIsEnabled(), user.getName() + "已被禁用,请刷新重试");
            if (!job.getId().equals(user.getJobId())) {
               user.setJobId(job.getId());
               this.userMapper.updateById(user);
               GeneratorUserDetailService.USER_MAP.remove(user.getId());
            }
         }
      }

      if (CollectionUtils.isNotEmpty(users)) {
         for (User user : users) {
            Preconditions.checkArgument(user.getDepartmentId().equals(deptId), user.getName() + "与岗位的部门信息不匹配，请刷新重试");
            user.setJobId(null);
            this.userMapper.updateById(user);
            GeneratorUserDetailService.USER_MAP.remove(user.getId());
         }
      }

      return true;
   }

   @Override
   public DeptUserResponseVO getJobUser(Long jobId) {
      Job job = this.jobMapper.selectById(jobId);
      Preconditions.checkArgument(job != null, "对应的岗位不存在");
      List<User> users = this.userMapper.selectList((Wrapper<User>)new LambdaQueryWrapper<User>().eq(User::getJobId, jobId));
      if (CollectionUtils.isEmpty(users)) {
         return null;
      }

      Map<Long, List<User>> userMap = users.stream()
         .collect(Collectors.toMap(User::getDepartmentId, y -> new ArrayList<>(Collections.singleton((User)y)), (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
         }));
      DeptUserResponseVO[] deptUserResponseVOS = new DeptUserResponseVO[]{new DeptUserResponseVO()};
      userMap.forEach(
         (deptId, userList) -> {
            Department department = this.departmentMapper.selectById(deptId);
            Preconditions.checkArgument(department != null, "部门不存在");
            DeptUserResponseVO deptUserResponseVO = DeptUserResponseVO.builder()
               .deptId(deptId)
               .deptName(department.getName())
               .jobId(jobId)
               .jobName(job.getName())
               .build();
            List<UserJobResponseVO> userJobResponseVOS = new ArrayList<>(16);

            for (User user : userList) {
               UserJobResponseVO userJobResponseVO = UserJobResponseVO.builder().userId(user.getId()).userName(user.getName()).JobId(jobId).build();
               userJobResponseVOS.add(userJobResponseVO);
            }

            deptUserResponseVO.setUserList(userJobResponseVOS);
            deptUserResponseVOS[0] = deptUserResponseVO;
         }
      );
      return deptUserResponseVOS[0];
   }

   @Override
   public void jobExport(Integer enabled, HttpServletResponse response) {
      try {
         List<JobResponseVO> jobResponseVOList = this.jobMapper.listByDeptIdAndNameAndEnabled(null, null, enabled, null, null);
         Map<String, Object> map = new HashMap<>();
         String status = enabled == null ? "全部" : (enabled == 1 ? "启用" : "禁用");
         map.put("status", status);
         if (CollectionUtils.isNotEmpty(jobResponseVOList)) {
            Map<Long, List<User>> userAndJobMap = this.userMapper
               .selectList(new LambdaQueryWrapper<>())
               .stream()
               .collect(Collectors.toMap(User::getJobId, y -> new ArrayList<>(Collections.singleton((User)y)), (oldList, newList) -> {
                  oldList.addAll(newList);
                  return oldList;
               }));
            Map<Long, Department> departmentMap = this.departmentMapper
               .selectList(new LambdaQueryWrapper<>())
               .stream()
               .collect(Collectors.toMap(Department::getId, y -> (Department)y));
            List<Map<String, Object>> roleList = new ArrayList<>();

            for (int i = 0; i < jobResponseVOList.size(); i++) {
               Map<String, Object> roleMap = new HashMap<>();
               roleMap.put("jobName", jobResponseVOList.get(i).getName());
               roleMap.put("id", i + 1);
               List<Map<String, Object>> deptList = new ArrayList<>();
               List<User> users = userAndJobMap.get(jobResponseVOList.get(i).getId());
               if (CollectionUtils.isNotEmpty(users)) {
                  Map<Long, List<User>> userMap = users.stream()
                     .collect(Collectors.toMap(User::getDepartmentId, y -> new ArrayList<>(Collections.singleton((User)y)), (oldList, newList) -> {
                        oldList.addAll(newList);
                        return oldList;
                     }));
                  userMap.forEach((deptId, userList) -> {
                     Map<String, Object> userDeptMap = new HashMap<>();
                     userDeptMap.put("deptName", "-");
                     if (deptId != null) {
                        Department department = departmentMap.get(deptId);
                        if (department != null) {
                           userDeptMap.put("deptName", department.getName());
                        }
                     }

                     String userNames = userList.stream().map(User::getName).collect(Collectors.joining(","));
                     userDeptMap.put("userNames", userNames);
                     deptList.add(userDeptMap);
                  });
                  roleMap.put("deptList", deptList);
               }

               roleList.add(roleMap);
            }

            map.put("roleList", roleList);
         }

         String tempFileName = "jobAnduser";
         String resourcePath = "template/jobAnduser.xlsx";
         String exportFileName = "岗位用户信息表.xlsx";
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         InputStream inputStream = resource.getInputStream();
         File file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         params.setColForEach(true);
         Workbook workbook = ExcelExportUtil.exportExcel(params, map);
         PoiUtils.downLoadExcel(exportFileName, response, workbook);
      } catch (Throwable $ex) {
         throw JobServiceImpl.<RuntimeException>rethrow($ex);
      }
   }

   @Override
   public List<JobResponseVO> getAll() {
      return this.jobMapper.getAll();
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
