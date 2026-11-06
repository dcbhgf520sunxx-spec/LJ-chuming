import { ref as i } from "vue";
import { onMounted as w } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as Y } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as D } from "vue";
import { unref as n } from "vue";
import { createBlock as V } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as F } from "vue";
import { ElDatePicker as T } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { l as _, p as E, G as g, o as L, L as N, c as P } from "../../../shared/runtime.js";
import { b as p } from "../../../modules/operation-4e9312fe.js";
function R({ year: o }) {
  return _({ url: `/api/contract/Management-fee/findAll/${o}`, method: "get" });
}
function $({ year: o }) {
  return _({ url: `/api/contract/Management-fee/export/${o}`, method: "get", responseType: "blob" });
}
const j = { class: "app-container" }, H = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, G = { __name: "index", setup(o) {
  const r = i(E(/* @__PURE__ */ new Date(), "{y}")), y = i(), m = i([]);
  w(() => {
    d();
  });
  async function d() {
    if (!g(p.get)) return false;
    try {
      const { content: t } = await R({ year: r.value });
      m.value = t || [];
    } catch (t) {
      console.log("获取管理费列表失败", t);
    }
  }
  function b(t) {
    return t > /* @__PURE__ */ new Date();
  }
  const { maxHeight: h } = L({ extraBox: [".head-container"], paginate: true });
  return (t, l) => {
    const v = T, a = U, x = k("common-table"), M = C("permission");
    return u(), Y("div", j, [f("div", H, [e(v, { modelValue: r.value, "onUpdate:modelValue": l[0] || (l[0] = (s) => r.value = s), type: "year", size: "default", style: { width: "100px" }, placeholder: "选择年", class: "filter-item", format: "YYYY", "value-format": "YYYY", clearable: "", "disabled-date": b, onChange: d }, null, 8, ["modelValue"]), D((u(), V(N, { class: "filter-item", fn: n($), params: { year: r.value } }, { default: c(() => l[1] || (l[1] = [B(" 管理费清单 ")])), _: 1, __: [1] }, 8, ["fn", "params"])), [[M, n(p).download]])]), e(x, { ref_key: "tableRef", ref: y, data: m.value, "empty-text": n(g)(n(p).get) ? "暂无数据" : "暂无权限", "max-height": n(h), "row-key": "id", style: { width: "100%" } }, { default: c(() => [e(a, { label: "月份", prop: "month", align: "center", width: "60px" }), e(a, { label: "月产（吨）", prop: "monthCapacity", align: "center" }, { default: c(({ row: s }) => [f("span", null, F(n(P)(s.monthCapacity, "kg", "t", 2)), 1)]), _: 1 }), e(a, { label: "管理人员数量", prop: "managementUserCount", align: "center" }), e(a, { label: "应发工资（元）", prop: "managementUserMoney", align: "center" }), e(a, { label: "报销（元）", prop: "reimbursementMoney", align: "center" }), e(a, { label: "其它（元）", prop: "otherMoney", align: "center" }), e(a, { label: "合计金额（元）", prop: "sumMoney", align: "center" }), e(a, { label: "平均单价（元/吨）", prop: "avgMoney", align: "center" })]), _: 1 }, 8, ["data", "empty-text", "max-height"])]);
  };
} };
export {
  G as default
};
