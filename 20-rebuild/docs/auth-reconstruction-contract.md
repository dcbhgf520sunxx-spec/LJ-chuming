# 首条登录、用户信息与菜单源码链

本链是独立 Spring Boot 源码重建，只加载新源码和现有开源第三方依赖，不使用原厂业务 JAR，也不向原服务转发未重建接口。数据库通过 `JdbcTemplate` 读取独立 `plm7_rebuild`。账号、角色、菜单、部门、岗位与配置均来自该库，没有内置管理员或菜单列表。

## 接口与前端契约

| 接口 | 已实现行为 |
| --- | --- |
| `POST /api/user/login` | JSON `username/password`；密码为新公钥加密后的 Base64 RSA PKCS#1 v1.5 密文；成功 `data.token` 与 `data.conformPasswordPolicy` |
| `GET /api/user/public-key` | 新增接口，返回 `data.publicKey` PEM 与 `data.algorithm`；公钥由部署私钥导出，不含私钥 |
| `GET /api/user/info` | 由 Authorization 原始 token 定位实时用户，返回原 PC 用户信息投影 |
| `GET /api/user/menu` | 根据当前数据库角色读取原菜单树与分公司计价菜单 |
| `POST /api/user/logout` | 持久化撤销该 token；同时保留原版 `DELETE /api/user/logout` 兼容入口 |

成功响应为 `{"code":20000,"message":"操作成功","data":...}`；失败保留 `code/message/data`，认证错误使用原公共枚举 40001–40005 等代码。token 直接放入 `Authorization`，无 `Bearer ` 前缀。新 token 使用新部署密钥签名，旧平台 token 不被新服务接受。

所有 `/api/` 路径通过认证过滤器，公开入口仅有登录、公钥及预留健康路径；实际健康接口为 `/actuator/health`。未实现接口没有业务控制器，不会因为用户拥有菜单而获得旧业务执行能力。将来新增业务接口必须单独实现业务权限校验，菜单可见性不能代替服务端权限。

## 原版静态证据与重建规则

证据根目录：`10-reverse/decompiled`。

- `src/main/java/com/hzchum/scim/rest/controller/system/UserApi.java`：login、PC info、menu、原 DELETE logout 的路径与响应封装。
- `.../system/core/service/impl/UserServiceImpl.java`：手机号优先，其次 4–16 位字母数字用户名，再匹配邮箱；未删除用户查询，RSA 解密、BCrypt 认证、密码策略提示。保留原正则和错误文案，不引入按用户 ID 或用户名判断管理员的捷径。
- `.../system/core/security/GeneratorUserDetailService.java` 与 `modules/scim-system-core/src/main/resources/mapper/RoleMapper.xml`：角色必须由 `sys_user_role_link` 联结 `sys_role`，两边 `bool_delete_enum=0`。仅 `role.permission` 精确等于 `admin` 代表管理员，角色名称和用户 ID 不决定权限。
- `.../system/core/service/impl/MenuServiceImpl.java`、`.../mapper/MenuMapper.xml`、`RoleMenuLinkMapper.xml`：PC `category=0`，按钮 `type=2`。管理员读该类别所有未删除菜单；非管理员按当前角色联结未删除 role-menu link 与未删除菜单，再补全部 `pid=0` 未删除根菜单；没有角色时返回空菜单。保留排序、hidden、component、meta/noCache 与根节点空字段，不自行剔除隐藏路由。
- 同一 `MenuServiceImpl` 的 `setPricingMenu`：菜单 6000200 存在时，以其第一个子菜单作为模板，对未删除 `sys_branch_company` 按 level/id 展开分公司项、重写 path/redirect/name 和 branchCompanyId。该分支已纳入实际菜单全树对照。
- `.../system/core/biz/impl/UserBizImpl.java#getInfo`：PC 权限保留含冒号项；model menus 使用全部权限菜单中的非隐藏项，若包含主系统则改为主系统直系子项与其他根项；角色、菜单、部门、岗位、公司/Logo/产品Logo、物料获取配置、首页开关与图纸匹配范围按原链读取。
- `.../system/core/api/utils/PasswordPolicyUtil.java` 与 `ConfigServiceImpl#getPasswordPolicy`：未配置策略时默认不阻止登录；策略关闭登录校验时返回 true；开启时按配置检查字符和长度，管理员规则提升为数字、字母、特殊字符和最少 8 位。只返回是否符合，不修改密码或配置。
- 原 `application.properties` 中 module/menu/mes-enum/menu-enum 的非敏感值成为可覆盖的部署默认值，按原枚举换算 info 中能力位与产品类型列表。

用户查询使用显式字段清单。密码哈希只在登录内部查询用于 BCrypt；`info`、token 与菜单不包含 password，未使用 `SELECT *`。数据查询均带参数；动态字段仅由固定账号正则分支选择，角色占位符数量来自数据库角色列表。

## 新部署配置

必需：`LJAPS_RSA_PRIVATE_KEY_PATH`（PKCS#8 RSA PEM）、`LJAPS_JWT_SECRET`（至少 64 个 UTF-8 字节）。私钥与秘密由部署环境生成并注入，源码不含原私钥、原 JWT secret 或真实账号。

可选：`LJAPS_JWT_EXPIRATION_SECONDS`（默认 28800）、`LJAPS_MODULES`、`LJAPS_PRODUCT_MENU`、`LJAPS_MES_ENUM`、`LJAPS_MENU_ENUM`。数据库连接沿用 Spring datasource 配置。

新平台专用撤销表，仅创建在重建库，不修改原业务表：

```sql
CREATE TABLE rebuild_auth_revoked_token (
  jti VARCHAR(36) CHARACTER SET ascii COLLATE ascii_bin NOT NULL PRIMARY KEY,
  expires_at_epoch_ms BIGINT NOT NULL
) ENGINE=InnoDB;
```

JWT 使用 HS512、随机 jti、到期时间与数据库用户 ID。每次请求重新检查用户存在、删除状态、启用状态、用户名和 `last_password_reset_date`；密码重置日期变化立即使旧 token 失效。退出将 jti 写入附属表，后续请求以及服务重启后的请求均检查持久化撤销。已过期撤销记录暂保留，可由后续维护任务清理，不影响到期判断。

## 已验证与差异边界

1. 合成检查先因缺少实现而失败，随后新源码在现有 Java 8 工具镜像内独立编译，通过 18 项合成场景：RSA 登录、原始 JWT、BCrypt 错误密码、拒绝 Bearer 前缀与明文/坏密文、禁用/删除用户拒绝、密码重置即时失效、缺失/到期/篡改 token 拒绝、无角色空菜单、非管理员角色菜单限定/去重/去按钮、管理员仅按角色 permission 判断、菜单 hidden 保留、公钥无私钥、退出撤销与跨服务实例撤销。测试输入为临时生成的密钥及合成账号。
2. 用私有本地登录 fixture 在独立库真实 BCrypt 登录；`info` 所有 37 个字段与原私有运行样本逐值 JSON 相同，动态菜单 3 个根节点及全部子树与原样本逐值相同，`conformPasswordPolicy` 相同。测试只输出字段差异名称及数量，不把身份信息或 token 写入公共结果。
3. 数据库测试源码为 `backend/app/src/test/java/com/ljaps/rebuild/auth/AuthDatabaseProbe.java`，可加载私有环境及样本文件。合成测试为 `AuthContractProbe.java`，已纳入统一构建，输出在被忽略的 `backend/target/tests`；单独开发探针位于 `.auth-probe`。实际 HTTP 对照由 `local/check-runtime.py` 执行，已覆盖完整用户信息、完整菜单树、真实新库无角色账号、禁用与密码重置，并清理专用合成账号。真实服务重启后退出令牌仍被拒绝。浏览器退出也已确认新增持久化撤销记录。这些检查不等于生产发布或全部业务权限验收。

明确差异：使用新 RSA/JWT 密钥，不兼容原客户端内置旧公钥或旧 token；新增公钥接口供新前端启动。原版 logout 调用 Servlet logout，新版持久化撤销 JWT 并增加 POST。原版 SecurityUser 全局缓存改为每次回读，角色/禁用/密码重置变动能及时生效。旧版未明确阻止已禁用账号的过滤器逻辑不沿用，重建版明确拒绝。

未重建：短信/邮箱登录与找回密码、分包商专用登录、密码变更交互及用户写操作、Redis会话缓存、原服务初始化/授权许可门、全部业务 API 与业务写权限、第三方集成、附件读取。当前只支持已核实读链；不会把角色中的 `admin` 映射成未实现业务的通行证。真实不同角色、删除角色、删除菜单等与原版完整样本对照仍待专项验收；新库合成无角色账号已测，但现有 fixture 的全树相同不代表所有角色组合已完成业务等价证明。
