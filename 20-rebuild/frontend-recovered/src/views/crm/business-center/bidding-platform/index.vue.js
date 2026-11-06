import { ref as l } from "vue";
import { onMounted as D } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as t } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as H } from "vue";
import { unref as o } from "vue";
import { createBlock as g } from "vue";
import { createCommentVNode as w } from "vue";
import { ElTableColumn as R } from "element-plus";
import { c as B, g as P } from "../../../../modules/use-form-config-data-098a0552.js";
import { x as E, o as O, lN as S, G as y, P as T } from "../../../../shared/runtime.js";
import { f as m } from "../../../../modules/crm-c6ba92ff.js";
import U from "./module/detail.vue.js";
import L from "./module/header.vue.js";
import "../../../../modules/project-information-053c195b.js";
import "../../components/information-description/index.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const A = { class: "app-container" }, M = { style: { float: "right", "margin-top": "10px" } }, Y = { __name: "index", setup(q) {
  const { crud: n, CRUD: f } = E({ title: "招标平台列表", crudApi: { ...B }, permission: { ...m } }), b = l([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]], ["caLockDate", ["parse-time", "{y}-{m}-{d}"]]]), c = l(false), h = l({}), _ = l({});
  D(() => {
    x();
  });
  const { maxHeight: v } = O({ extraBox: [".head-container"], extraHeight: 40, paginate: true });
  async function x() {
    try {
      const a = await P();
      _.value = a;
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
  function k(a) {
    c.value = true, h.value = a;
  }
  return (a, r) => {
    const i = p("print-table"), e = R, C = p("common-button"), N = p("common-table");
    return u(), V("div", A, [t(L, { summary: _.value }, { printBtn: d(() => [H("div", M, [o(y)(o(m).print) ? (u(), g(i, { key: 0, "api-key": "platFormInfoList", params: { ...o(n).query }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["params"])) : w("", true)])]), _: 1 }, 8, ["summary"]), t(N, { data: o(n).data, "data-format": b.value, maxHeight: o(v) }, { default: d(() => [t(e, { type: "index", align: "center", label: "序号", width: "60" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "登记日期", prop: "informantDateTime" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "企业名称", "min-width": "120", prop: "crmEnterpriseWarehousingName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "招标平台名称", "min-width": "150", prop: "biddingPlatformName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "homeProvince" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "详细地址", prop: "address" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "填报人", prop: "informantUserName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "创建人", prop: "createUserName" }), t(e, { align: "center", "show-overflow-tooltip": true, label: "CA锁有效期", prop: "caLockDate" }), o(y)(o(m).detail) ? (u(), g(e, { key: 0, align: "center", label: "操作", width: "100" }, { default: d(({ row: s }) => [t(C, { type: "primary", icon: "el-icon-view", onClick: (F) => k(s) }, null, 8, ["onClick"])]), _: 1 })) : w("", true)]), _: 1 }, 8, ["data", "data-format", "maxHeight"]), t(o(T)), t(U, { modelValue: c.value, "onUpdate:modelValue": r[0] || (r[0] = (s) => c.value = s), "current-row": h.value, permission: o(m), onSuccess: o(n).toQuery }, null, 8, ["modelValue", "current-row", "permission", "onSuccess"])]);
  };
} };
export {
  Y as default
};
