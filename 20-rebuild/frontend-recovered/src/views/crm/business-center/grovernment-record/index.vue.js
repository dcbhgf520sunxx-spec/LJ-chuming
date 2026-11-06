import { ref as l } from "vue";
import { onMounted as D } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as t } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as H } from "vue";
import { unref as o } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as g } from "vue";
import { ElTableColumn as P } from "element-plus";
import { e as R, h as B } from "../../../../modules/use-form-config-data-098a0552.js";
import { x as T, o as O, lN as U, G as y, P as A } from "../../../../shared/runtime.js";
import { k as m } from "../../../../modules/crm-c6ba92ff.js";
import E from "./module/detail.vue.js";
import L from "./module/header.vue.js";
import "../../../../modules/project-information-053c195b.js";
import "../../components/information-description/index.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const S = { class: "app-container" }, M = { style: { float: "right", "margin-top": "10px" } }, Y = { __name: "index", setup($) {
  const { crud: n, CRUD: f } = T({ title: "政府备案列表", crudApi: { ...R }, permission: { ...m } }), b = l([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]], ["caLockDate", ["parse-time", "{y}-{m}-{d}"]]]), s = l(false), h = l({}), w = l({});
  D(() => {
    k();
  });
  const { maxHeight: v } = O({ extraBox: [".head-container"], extraHeight: 40, paginate: true });
  async function k() {
    try {
      const a = await B();
      w.value = a;
    } catch (a) {
      console.log(a, "获取汇总数据");
    }
  }
  f.HOOK.beforeToQuery = () => {
    n.query.checkRecord = U.RECORD.V;
  }, f.HOOK.handleRefresh = (a, r) => {
    var i;
    r.data.content = (i = r.data.content) == null ? void 0 : i.map((e) => (e.homeProvince = e.countryName + e.provinceName + e.cityName + e.regionName, e));
  };
  function x(a) {
    s.value = true, h.value = a;
  }
  return (a, r) => {
    const i = p("print-table"), e = P, C = p("common-button"), N = p("common-table");
    return u(), V("div", S, [t(L, { summary: w.value }, { printBtn: d(() => [H("div", M, [o(y)(o(m).print) ? (u(), _(i, { key: 0, "api-key": "governmentInfoList", params: { ...o(n).query }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["params"])) : g("", true)])]), _: 1 }, 8, ["summary"]), t(N, { data: o(n).data, "data-format": b.value, maxHeight: o(v) }, { default: d(() => [t(e, { type: "index", align: "center", label: "序号", width: "60" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "登记日期", width: "120", prop: "informantDateTime" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "企业名称", "min-width": "120", prop: "businessName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "homeProvince" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "详细地址", prop: "informantDateTime" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "企业类别", prop: "unitPropertyAllocationConfigName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "企业性质", prop: "unitClassConfigurationName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "填报人", prop: "informantUserName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "创建人", prop: "createUserName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "CA锁有效期", prop: "caLockDate" }), o(y)(o(m).detail) ? (u(), _(e, { key: 0, align: "center", label: "操作", width: "100" }, { default: d(({ row: c }) => [t(C, { type: "primary", icon: "el-icon-view", onClick: (q) => x(c) }, null, 8, ["onClick"])]), _: 1 })) : g("", true)]), _: 1 }, 8, ["data", "data-format", "maxHeight"]), t(o(A)), t(E, { modelValue: s.value, "onUpdate:modelValue": r[0] || (r[0] = (c) => s.value = c), "current-row": h.value, permission: o(m), onSuccess: o(n).toQuery }, null, 8, ["modelValue", "current-row", "permission", "onSuccess"])]);
  };
} };
export {
  Y as default
};
