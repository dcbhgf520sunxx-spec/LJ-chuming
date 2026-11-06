import { ref as v } from "vue";
import { inject as y } from "vue";
import { computed as C } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as W } from "vue";
import { withDirectives as c } from "vue";
import { vShow as R } from "vue";
import { unref as e } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as i } from "vue";
import { createBlock as d } from "vue";
import { createCommentVNode as f } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as x } from "vue";
import { ElTag as P } from "element-plus";
import { a as b, b as T } from "../../../../../modules/loss-and-work-in-progress-statistics-3ddf318f.js";
import { _ as L, si as l, c1 as S, B as N, fv as U, aV as B, C as Q, L as k, E as $ } from "../../../../../shared/runtime.js";
const q = { __name: "header", props: { selectedRows: { type: Array, default: () => [] } }, setup(H) {
  const E = { projectOrWorkShopEnum: l.PROJECT.V, status: void 0, projectId: void 0, workShopId: void 0 }, V = v([S.PROCESS, S.SUSPEND, S.COMPLETE]), m = y("selectedRows"), { crud: a, query: t } = N(E), g = C(() => {
    var u, o;
    return { projectOrWorkShopEnum: t.projectOrWorkShopEnum, projectId: (u = m.value) == null ? void 0 : u.map((r) => r.projectId), workShopId: (o = m.value) == null ? void 0 : o.map((r) => r.workShopId) };
  });
  function O(u) {
    t.status = void 0, t.projectId = void 0, t.workShopId = void 0, a.page.total = 0, a.data = [], a.toQuery();
  }
  return (u, o) => {
    const r = I("common-radio-button"), j = P, h = D("permission");
    return n(), W("div", null, [c(w("div", null, [i(r, { modelValue: e(t).projectOrWorkShopEnum, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(t).projectOrWorkShopEnum = s), options: e(l).ENUM, type: "enum", class: "filter-item", onChange: O }, null, 8, ["modelValue", "options"]), e(t).projectOrWorkShopEnum === e(l).PROJECT.V ? (n(), d(r, { key: 0, modelValue: e(t).status, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(t).status = s), options: V.value, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : f("", true), e(t).projectOrWorkShopEnum === e(l).PROJECT.V ? (n(), d(e(U), { key: 1, modelValue: e(t).projectId, "onUpdate:modelValue": o[2] || (o[2] = (s) => e(t).projectId = s), class: "filter-item", style: { width: "240px" }, placeholder: "请选择项目", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"])) : f("", true), e(t).projectOrWorkShopEnum === e(l).WORKSHOP.V ? (n(), d(e(B), { key: 2, modelValue: e(t).workShopId, "onUpdate:modelValue": o[3] || (o[3] = (s) => e(t).workShopId = s), placeholder: "请选择车间", style: { width: "200px" }, class: "filter-item", clearable: true, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"])) : f("", true), i(e(Q))], 512), [[R, e(a).searchToggle]]), i(e($), null, { optLeft: p(() => [c((n(), d(e(k), { fn: e(b), params: e(a).query, "response-header-result": "" }, { default: p(() => o[4] || (o[4] = [_(" 损耗及在制品统计下载(根据查询结果) ")])), _: 1, __: [4] }, 8, ["fn", "params"])), [[h, e(a).permission.download]]), c((n(), d(e(k), { fn: e(T), params: g.value, disabled: !e(m).length, "response-header-result": "" }, { default: p(() => [_(" 单" + x(e(l).V[e(t).projectOrWorkShopEnum].SL) + "统计详情下载 ", 1)]), _: 1 }, 8, ["fn", "params", "disabled"])), [[h, e(a).permission.download]]), o[5] || (o[5] = w("span", { class: "tips" }, "*当前页面不包含当天数据，可通过下载获取最新数据。", -1))]), viewLeft: p(() => [i(j, { size: "medium" }, { default: p(() => o[6] || (o[6] = [_("单位：吨")])), _: 1, __: [6] })]), _: 1 })]);
  };
} }, z = L(q, [["__scopeId", "data-v-85fe4d6e"]]);
export {
  z as default
};
