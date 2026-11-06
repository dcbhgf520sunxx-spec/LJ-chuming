import { ref as l } from "vue";
import { onMounted as D } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as o } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as R } from "vue";
import { unref as t } from "vue";
import { createBlock as g } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElTableColumn as H } from "element-plus";
import { k as P, l as B } from "../../../../modules/use-form-config-data-098a0552.js";
import { x as A, o as O, lN as S, G as y, P as T } from "../../../../shared/runtime.js";
import { n as s } from "../../../../modules/crm-c6ba92ff.js";
import U from "./module/header.vue.js";
import E from "./module/detail.vue.js";
import "../../../../modules/project-information-053c195b.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/basics-config-select-53b77c54.js";
import "../../../../modules/use-crm-basics-c35b230b.js";
import "../../components/information-description/index.vue.js";
const L = { class: "app-container" }, M = { style: { float: "right", "margin-top": "10px" } }, ee = { __name: "index", setup(Q) {
  const { crud: n, CRUD: f } = A({ title: "合格供应商", crudApi: { ...P }, permission: { ...s } }), b = l([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]], ["caLockDate", ["parse-time", "{y}-{m}-{d}"]]]), c = l(false), w = l({}), h = l({});
  D(() => {
    C();
  });
  const { maxHeight: v } = O({ extraBox: [".head-container"], extraHeight: 40, paginate: true });
  async function C() {
    try {
      const a = await B();
      h.value = a;
    } catch (a) {
      console.log(a, "获取汇总数据");
    }
  }
  f.HOOK.beforeToQuery = () => {
    n.query.checkRecord = S.RECORD.V;
  }, f.HOOK.handleRefresh = (a, r) => {
    var i;
    r.data.content = (i = r.data.content) == null ? void 0 : i.map((e) => (e.homeProvince = e.countryName + e.provinceName + e.cityName + e.regionName, e));
  };
  function N(a) {
    c.value = true, w.value = a;
  }
  return (a, r) => {
    const i = p("print-table"), e = H, k = p("common-button"), x = p("common-table");
    return u(), V("div", L, [o(U, { summary: h.value }, { printBtn: d(() => [R("div", M, [t(y)(t(s).print) ? (u(), g(i, { key: 0, "api-key": "supplierInfoList", params: { ...t(n).query }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["params"])) : _("", true)])]), _: 1 }, 8, ["summary"]), o(x, { data: t(n).data, "data-format": b.value, maxHeight: t(v) }, { default: d(() => [o(e, { type: "index", align: "center", label: "序号", width: "60" }), o(e, { align: "center", "show-overflow-tooltip": true, label: "登记日期", prop: "informantDateTime" }), o(e, { align: "center", "show-overflow-tooltip": true, label: "企业名称", "min-width": "120", prop: "businessName" }), o(e, { align: "center", "show-overflow-tooltip": true, label: "社会统一信息代码", "min-width": "120", prop: "creditCode" }), o(e, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "homeProvince" }), o(e, { align: "center", "show-overflow-tooltip": true, label: "企业类别", prop: "unitPropertyAllocationConfigName" }), o(e, { align: "center", "show-overflow-tooltip": true, label: "企业性质", prop: "unitClassConfigurationName" }), o(e, { align: "center", "show-overflow-tooltip": true, label: "所属行业", prop: "industryConfigurationName" }), o(e, { align: "center", "show-overflow-tooltip": true, label: "企业信誉", prop: "unitReputationAllocationConfigName" }), o(e, { align: "center", "show-overflow-tooltip": true, label: "填报人", prop: "informantUserName" }), o(e, { align: "center", "show-overflow-tooltip": true, label: "创建人", prop: "createUserName" }), o(e, { align: "center", "show-overflow-tooltip": true, label: "CA锁有效期", prop: "caLockDate" }), t(y)(t(s).detail) ? (u(), g(e, { key: 0, align: "center", label: "操作", width: "100" }, { default: d(({ row: m }) => [o(k, { type: "primary", icon: "el-icon-view", onClick: ($) => N(m) }, null, 8, ["onClick"])]), _: 1 })) : _("", true)]), _: 1 }, 8, ["data", "data-format", "maxHeight"]), o(t(T)), o(E, { modelValue: c.value, "onUpdate:modelValue": r[0] || (r[0] = (m) => c.value = m), "current-row": w.value, permission: t(s), onSuccess: t(n).toQuery }, null, 8, ["modelValue", "current-row", "permission", "onSuccess"])]);
  };
} };
export {
  ee as default
};
