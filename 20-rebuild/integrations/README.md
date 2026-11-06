# 第三方对接准备包

用户顺序：全部准备完备后再统一测试。本目录覆盖现有清单 I01—I17。当前只做源码、配置、部署与资料准备；没有发出真实审批、消息、上传/删除、组织同步、回调注册或硬件打印。

`catalog.json` 逐项列出环境变量、实际消费属性、资料和明确代码阻塞。`discovery/` 保存静态调用链依据；静态代码、协议模拟与真实接通分开记录。原 app90/web93 本地服务保持运行，新源码尚未替换运行制品。

运维一次性交付材料见`运维资料清单.md`；待执行的成功、异常和清理场景见`统一测试清单.md`。当前17项均缺已审核测试资料，10项仍有代码/协议边界，真实测试就绪为0项。

## 资料如何交付

真实资料放在 `integrations/private/`，该目录不对 Web 发布，也不纳入 Git。请提供测试环境而非直接沿用历史生产身份：

- OA、SHR：接口文档、身份、组织/人员/流程映射、请求响应及回调认证样例。
- BIM、柏楚：测试应用、模型/作业样本、团队和车间映射、授权、回调/WS及浏览器实际资源域名。
- 消息与身份：测试应用、审核通过的签名/模板、回调协议、允许的测试收件人或隔离测试群。
- IoT、地磅：实际网关协议、设备ID、单位/标定、采集样本及网络范围。
- OSS：隔离Bucket和前缀、API端点、公开/CDN访问基址、私有对象访问授权约定。
- 外链、打印：目标入口和菜单映射；客户端系统/浏览器、打印机和适配器脚本。外链的`iframe`菜单标志不代表一定使用HTML iframe。

按模板生成材料表（只生成空白项，未测试）：

```sh
python3 integrations/prepare.py templates
```

这会创建每项的 `private/Ixx/contract.json` 和无凭据 `private/connections.env.example`。实际文档/样例放在 private 下，在材料表填写相对路径；审核后再把对应项的 reviewed/confirmed 标为 true。不能只填确认标志而没有真实材料。

将连接模板另存为 `private/connections.env` 并设为0600。格式是原始单行 `KEY=值`，不加包裹引号，不执行 `source`；密钥中的 `$`、`#` 和 `=` 保留为原始值，不插入命令或多行内容。公开报告只列变量名和是否齐全，不输出值。

可选字段留空时保持现有默认值；一旦填写，也会校验格式，不能靠可选标记跳过错误地址检查。

## 查看准备状态与生成部署配置

```sh
python3 integrations/prepare.py status
python3 integrations/prepare.py status --integrations I01,I03,I04
```

检查只读本地文件，不访问第三方、数据库或硬件。准备齐全表示可以进入真实测试，不代表接口已经通过验收。源码、回调鉴权或资料未就绪时，render会明确停止；不存在“忽略缺项继续部署”的开关。

```sh
python3 integrations/prepare.py render --integrations I03 --output integrations/runtime/bim-test-01
```

成功后生成原始格式 env、Spring属性及Compose overlay，所有实际值保存在私有目录；原 `local/.env`、business.properties和数据库不改。overlay只是配置文件，不自动启动、不替换已运行程序，也不开外网。需要Docker Compose支持`env_file.format=raw`（当前已观察版本5.3.0）。

后续真实测试另需单独准备受控出口、回调域名/TLS/代理及白名单。现有Docker后端仍在内部网络，生成配置不能代替网络开通。不要直接重放旧外部Runner；其中包含删除/注册回调、创建模板、同步和旧迁移。

## 浏览器与客户端

当前网页只允许同源资源，普通构建保持此行为。BIM SDK/模型服务、实际嵌入外链或本机打印需要准确的资源来源：复制 `browser-policy.example.json` 到 private，按真实部署列出HTTPS/WSS来源，审核后显式设置 approved=true。只有 I17 可声明本机HTTP/WS打印来源；不接受通配符、带账号/查询参数的来源或全网放行。

未来构建时通过 `LJAPS_INTEGRATION_BROWSER_POLICY=/绝对路径/已审核策略.json` 明确选择该策略；此变量在构建阶段使用，不能只传到后端容器。构建、摘要登记和实际网页回读仍按原流程执行。当前 live web93 未替换、未放宽策略。

打印必须提供能返回真实LODOP/C-Lodop驱动对象的 `window.LJAPS_PRINT_ADAPTER.getPrinter`。现有适配入口只检查对象契约，不主动扫描设备；有安装包或导出模板不代表已经能打印。

## 仍需先解决的代码/协议边界

- OA、BIM、钉钉回调和微信匿名入口会经过当前平台JWT过滤器。必须按真实令牌/签名协议做精确适配，不能开放整段API。
- 微信历史令牌缺当前的jti/uid/pwdv，不能用“登录接口返回成功”替代可用会话；验证码和绑定关系需实际契约。
- 柏楚遗留分支的固定Orgcode及WS/Pulsar部署方式要确认；26处集中签名不代表所有主动/被动事件都已接通。
- WMS Webhook保留原`@all`和固定agentid，真实测试前须确认机器人/应用协议及隔离接收范围。
- 企微专用工具未发现公开调用入口；极光APNS/渠道常量及独立招采命名源需与实际启用方式核对。

明确的本地准备改动包括BIM显式开关、柏楚签名集中、SHR地址外置及空响应保护、认证日志去敏、Webhook JSON转义和OSS公开访问基址。`probes/` 是为统一离线核查准备的断言源码，不是已完成的第三方测试结果。

Git使用 `https://github.com/dcbhgf520sunxx-spec/LJ-chuming.git` 的 main；源码提交范围及公开前脱敏见`../docs/source-baseline.md`。本目录带时间的准备记录保留当时观察，Git提交与真实接口验收分别记录。实际凭据、本地备份和原始回执不随源码上传。
