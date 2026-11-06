import { inject as K } from "vue";
import { ref as m } from "vue";
import { watch as A } from "vue";
import { onUnmounted as J } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as l } from "vue";
import { unref as i } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as C } from "vue";
import { createBlock as X } from "vue";
import { createCommentVNode as Y } from "vue";
import { withDirectives as Z } from "vue";
import { normalizeStyle as r } from "vue";
import { toDisplayString as c } from "vue";
import { nextTick as D } from "vue";
import { ElTableColumn as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { _ as ae } from "../../../../../../modules/index-c07af747.js";
import { _ as oe, b as le, fa as q, pF as se, G as B, pQ as Q, L as ne, bV as j, p as ie } from "../../../../../../shared/runtime.js";
import { d as re, c as ce } from "../../../../../../modules/project-material-c2039d20.js";
const ue = { id: "container" }, pe = { class: "util-container" }, me = { class: "table-container" }, w = 50, de = { __name: "pick-list-component", props: { maxHeight: { type: [Number, String], default: 500 } }, setup(z) {
  const x = K("commonQuery"), T = () => ({ workShopId: "", basicClass: "" }), d = m(T()), P = m({}), f = m([]), g = m([]), y = m(false), v = m(0), H = async () => {
    if (!(y.value || v.value >= f.value.length)) {
      y.value = true;
      try {
        const a = f.value.slice(v.value, v.value + w);
        g.value = [...g.value, ...a], v.value += w, await D();
      } finally {
        y.value = false;
      }
    }
  }, L = async (a) => {
    const t = a.target;
    t.scrollHeight - t.scrollTop - t.clientHeight < 100 && await H();
  }, M = async () => {
    g.value = f.value.slice(0, w), v.value = w, await D();
    const a = document.querySelector("#pickTable .el-table__body-wrapper");
    a && a.addEventListener("scroll", L);
  }, U = async () => {
    await D();
    const a = document.querySelector("#pickTable .el-table__body-wrapper");
    a && a.removeEventListener("scroll", L);
  }, R = async () => {
    if (B(Q.getPickList)) {
      y.value = true;
      try {
        const a = { ...x, ...i(d) };
        P.value = a;
        const t = await ce(a);
        let u = [];
        const _ = (o, p, h = false, e = "") => {
          const I = o.map((k) => {
            const N = k.mete / 1e3 * (h ? -1 : 1);
            return { ...k, mete: N, color: e };
          }), F = I.reduce((k, N) => k + N.mete, 0);
          return [...I, { type: p, time: 0, mete: F, color: e }];
        };
        t.moveOutboundDetails.length && (u = _(t.moveOutboundDetails, "小计")), t.returnDetails.length && (u = u.concat(_(t.returnDetails, "小计", true, "red"))), f.value = u;
      } finally {
        y.value = false;
      }
    }
  }, b = async () => {
    await R(), U(), M();
  }, G = ({ columns: a }) => a.map((t, u) => {
    if (u === 0) return "合计";
    if (!["mete"].includes(t.property)) return "";
    const o = f.value.map((p) => Number(p[t.property]) || 0).reduce((p, h) => p + h, 0) / 2;
    return isNaN(o) ? "" : j(o);
  }), W = m(null), O = () => {
    b();
  }, $ = () => {
    d.value = T(), b();
  };
  return A(() => x.projectId, async () => {
    le(x.projectId) || b();
  }, { immediate: true }), J(() => {
    U();
  }), (a, t) => {
    const u = S("common-select"), _ = S("common-button"), o = ee, p = S("common-table"), h = te;
    return V(), E("div", ue, [n("div", null, [l(ae, { modelValue: d.value.workShopId, "onUpdate:modelValue": t[0] || (t[0] = (e) => d.value.workShopId = e), placeholder: "请选择车间", "workshop-type": [i(q).BUILDING.V, i(q).BRIDGE.V], style: { width: "200px" }, class: "filter-item", clearable: true, onChange: b }, null, 8, ["modelValue", "workshop-type"]), l(u, { "data-structure": { key: "K", label: "SL", value: "WMSV" }, modelValue: d.value.basicClass, "onUpdate:modelValue": t[1] || (t[1] = (e) => d.value.basicClass = e), placeholder: "请选择物料种类", style: { width: "200px", margin: "0 10px" }, class: "filter-item", clearable: true, options: i(se).ENUM, onChange: b }, null, 8, ["modelValue", "options"]), l(_, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: O }, { default: s(() => t[2] || (t[2] = [C("搜索")])), _: 1, __: [2] }), l(_, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: $ }, { default: s(() => t[3] || (t[3] = [C(" 重置 ")])), _: 1, __: [3] })]), n("div", pe, [i(B)(i(Q).printPickList) ? (V(), X(ne, { key: 0, fn: i(re), disabled: !f.value.length, params: P.value, class: "filter-item" }, { default: s(() => t[4] || (t[4] = [C(" 下载 ")])), _: 1, __: [4] }, 8, ["fn", "disabled", "params"])) : Y("", true)]), Z((V(), E("div", me, [l(p, { ref_key: "tableRef", ref: W, id: "pickTable", "summary-method": G, "show-summary": "", data: g.value, "max-height": z.maxHeight + 50, border: "", style: { width: "100%", cursor: "pointer" } }, { default: s(() => [l(o, { prop: "index", type: "index", label: "序号", align: "center", width: "60" }), l(o, { key: "type", prop: "type", align: "center", width: "70", "show-overflow-tooltip": true, label: "类型" }, { default: s(({ row: e }) => [n("span", { style: r({ color: e.color }) }, c(e.type), 5)]), _: 1 }), l(o, { key: "classifyName", prop: "classifyName", align: "center", "show-overflow-tooltip": true, label: "物料种类" }, { default: s(({ row: e }) => [n("span", { style: r({ color: e.color }) }, c(e.classifyName), 5)]), _: 1 }), l(o, { key: "specification", prop: "specification", align: "center", "show-overflow-tooltip": true, label: "规格材质" }, { default: s(({ row: e }) => [n("span", { style: r({ color: e.color }) }, c(e.specification), 5)]), _: 1 }), l(o, { key: "measureUnit", prop: "measureUnit", align: "center", "show-overflow-tooltip": true, label: "计量单位" }, { default: s(({ row: e }) => [n("span", { style: r({ color: e.color }) }, c(e.measureUnit), 5)]), _: 1 }), l(o, { key: "quantity", prop: "quantity", align: "center", "min-width": "100", "show-overflow-tooltip": true, label: "数量" }, { default: s(({ row: e }) => [n("span", { style: r({ color: e.color }) }, c(e.quantity), 5)]), _: 1 }), l(o, { key: "accountingUnit", prop: "accountingUnit", align: "center", "show-overflow-tooltip": true, label: "核算单位" }, { default: s(({ row: e }) => [n("span", { style: r({ color: e.color }) }, c(e.accountingUnit), 5)]), _: 1 }), l(o, { key: "mete", prop: "mete", align: "center", "min-width": "120", "show-overflow-tooltip": true, label: "核算量" }, { default: s(({ row: e }) => [n("span", { style: r({ color: e.color }) }, c(i(j)(e.mete)), 5)]), _: 1 }), l(o, { key: "time", prop: "time", align: "center", width: "100", "show-overflow-tooltip": true, label: "出(退)库日期" }, { default: s(({ row: e }) => [n("span", { style: r({ color: e.color }) }, c(e.time ? i(ie)(e.time, "{y}-{m}-{d}") : ""), 5)]), _: 1 }), l(o, { key: "recipientName", prop: "recipientName", align: "center", "show-overflow-tooltip": true, label: "领用人" }, { default: s(({ row: e }) => [n("span", { style: r({ color: e.color }) }, c(e.recipientName), 5)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])])), [[h, y.value]])]);
  };
} }, be = oe(de, [["__scopeId", "data-v-31cc89ed"]]);
export {
  be as default
};
