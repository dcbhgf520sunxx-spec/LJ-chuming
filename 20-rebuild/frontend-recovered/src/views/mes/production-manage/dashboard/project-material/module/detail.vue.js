import { inject as q } from "vue";
import { ref as _ } from "vue";
import { watchEffect as J } from "vue";
import { unref as n } from "vue";
import { onUnmounted as Q } from "vue";
import { withDirectives as S } from "vue";
import { openBlock as D } from "vue";
import { createElementBlock as X } from "vue";
import { createElementVNode as r } from "vue";
import { vShow as W } from "vue";
import { createVNode as l } from "vue";
import { withCtx as s } from "vue";
import { createBlock as O } from "vue";
import { createTextVNode as Y } from "vue";
import { createCommentVNode as B } from "vue";
import { normalizeStyle as p } from "vue";
import { toDisplayString as d } from "vue";
import { ElCol as Z } from "element-plus";
import { ElRow as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { ElTable as ae } from "element-plus";
import { vLoading as le } from "element-plus";
import { nextTick as oe } from "vue";
import { P as se } from "../../../../../../modules/index-5b9e6004.js";
import { _ as ne, o as re, b as V, G as H, pG as I, L as ie, bV as N, pF as w, p as ce } from "../../../../../../shared/runtime.js";
import { d as ue, b as pe, c as de } from "../../../../../../modules/project-material-c2039d20.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
const me = { class: "header-container" }, fe = { class: "util-container" }, P = 50, _e = { __name: "detail", setup(ye) {
  const { maxHeight: j } = re({ extraBox: [".header-container", ".util-container"], paginate: false, extraHeight: 10 }), h = q("currentRow"), R = q("headerRef"), T = _({}), U = _({}), y = _([]), k = _([]), v = _(false), x = _(), g = _(0), A = async () => {
    if (!(v.value || g.value >= y.value.length)) {
      v.value = true;
      try {
        const o = y.value.slice(g.value, g.value + P);
        k.value = [...k.value, ...o], g.value += P, await oe();
      } finally {
        v.value = false;
      }
    }
  }, L = async (o) => {
    const t = o.target;
    t.scrollHeight - t.scrollTop - t.clientHeight < 100 && await A();
  }, K = () => {
    k.value = y.value.slice(0, P), g.value = P;
    const o = x.value.$el.querySelector(".el-table__body-wrapper");
    o && o.addEventListener("scroll", L);
  }, M = () => {
    var t;
    const o = (t = x.value) == null ? void 0 : t.$el.querySelector(".el-table__body-wrapper");
    o && o.removeEventListener("scroll", L);
  }, $ = () => {
    var e, E;
    const { productClassificationEnum: o, steelSpec: t, title: i, ...c } = n(h), u = { [w.SECTION_PRODUCT.V]: { basicClass: w.SECTION_PRODUCT.WMSV, specKey: "specification" }, [w.STEEL_PLATE_PRODUCT.V]: { basicClass: w.STEEL_PLATE_PRODUCT.WMSV, specKey: "thickness" } }, a = i !== "合计" ? o : (E = (e = R.value) == null ? void 0 : e.query) == null ? void 0 : E.productClassificationEnum, m = u[a];
    if (m) c.basicClass = m.basicClass, c[m.specKey] = t;
    else if (i !== "合计") throw new Error("【productClassificationEnum】类型不匹配");
    const f = { ...R.value.query, ...c };
    return U.value = f, f;
  }, z = async () => {
    if (H(I.get)) {
      v.value = true;
      try {
        const o = $();
        pe(o).then((u) => T.value = u);
        const t = await de(o);
        let i = [];
        const c = (u, a, m = false, f = "") => {
          const e = u.map((b) => {
            const C = b.mete / 1e3 * (m ? -1 : 1), F = b.actualTheoryWeight == null ? null : b.actualTheoryWeight / 1e3;
            return { ...b, accountingUnit: "kg", mete: C, color: f, actualTheoryWeight: F };
          }), E = e.reduce((b, C) => b + C.mete, 0);
          return [...e, { type: a, time: 0, mete: E, color: f }];
        };
        t.moveOutboundDetails.length && (i = c(t.moveOutboundDetails, "小计")), t.returnDetails.length && (i = i.concat(c(t.returnDetails, "小计", true, "red"))), y.value = i;
      } finally {
        v.value = false;
      }
    }
  }, G = ({ columns: o }) => o.map((t, i) => {
    if (i === 0) return "合计";
    if (!["mete"].includes(t.property)) return "";
    const u = y.value.map((a) => Number(a[t.property]) || 0).reduce((a, m) => a + m, 0) / 2;
    return isNaN(u) ? "" : N(u);
  });
  return J(async () => {
    V(n(h)) || (await z(), M(), K());
  }), Q(() => {
    M();
  }), (o, t) => {
    const i = se, c = Z, u = ee, a = te, m = ae, f = le;
    return S((D(), X("div", null, [S(r("div", null, t[0] || (t[0] = [r("div", { class: "my-code" }, "点击左边表格行查看详情", -1)]), 512), [[W, n(V)(n(h))]]), S(r("div", null, [r("div", me, [l(u, { gutter: 20, class: "panel-group" }, { default: s(() => [l(c, { span: 8, class: "card-panel-col" }, { default: s(() => [l(i, { name: "累计领用(kg)", "text-color": "#626262", "num-color": "#1890ff", endVal: T.value.meteCount / 1e3 || 0, precision: 0 }, null, 8, ["endVal"])]), _: 1 }), l(c, { span: 8, class: "card-panel-col" }, { default: s(() => [l(i, { name: "上月领用(kg)", "text-color": "#626262", "num-color": "#1890ff", endVal: T.value.aboveMonthMete / 1e3 || 0, precision: 0 }, null, 8, ["endVal"])]), _: 1 }), l(c, { span: 8, class: "card-panel-col" }, { default: s(() => [l(i, { name: "本月领用(kg)", "text-color": "#626262", "num-color": "#1890ff", "end-val": T.value.MonthMete / 1e3 || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })]), r("div", fe, [n(H)(n(I).print) ? (D(), O(ie, { key: 0, fn: n(ue), disabled: !y.value.length, params: U.value, class: "filter-item" }, { default: s(() => t[1] || (t[1] = [Y(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "disabled", "params"])) : B("", true)]), l(m, { ref_key: "tableRef", ref: x, "summary-method": G, "show-summary": "", data: k.value, "max-height": n(j), border: "", style: { width: "100%", cursor: "pointer" } }, { default: s(() => [l(a, { prop: "index", type: "index", label: "序号", align: "center", width: "60" }), l(a, { key: "type", prop: "type", align: "center", width: "70", "show-overflow-tooltip": true, label: "类型" }, { default: s(({ row: e }) => [r("span", { style: p({ color: e.color }) }, d(e.type), 5)]), _: 1 }), l(a, { key: "classifyName", prop: "classifyName", align: "center", "show-overflow-tooltip": true, label: "物料种类" }, { default: s(({ row: e }) => [r("span", { style: p({ color: e.color }) }, d(e.classifyName), 5)]), _: 1 }), l(a, { key: "specification", prop: "specification", align: "center", "show-overflow-tooltip": true, label: "规格材质" }, { default: s(({ row: e }) => [r("span", { style: p({ color: e.color }) }, d(e.specification), 5)]), _: 1 }), l(a, { key: "measureUnit", prop: "measureUnit", align: "center", "show-overflow-tooltip": true, label: `计量
单位`, width: "80" }, { default: s(({ row: e }) => [r("span", { style: p({ color: e.color }) }, d(e.measureUnit), 5)]), _: 1 }), l(a, { key: "quantity", prop: "quantity", align: "center", "min-width": "100", "show-overflow-tooltip": true, label: "数量" }, { default: s(({ row: e }) => [r("span", { style: p({ color: e.color }) }, d(e.quantity), 5)]), _: 1 }), l(a, { key: "accountingUnit", prop: "accountingUnit", align: "center", "show-overflow-tooltip": true, label: `核算
单位`, width: "80" }, { default: s(({ row: e }) => [r("span", { style: p({ color: e.color }) }, d(e.accountingUnit), 5)]), _: 1 }), l(a, { key: "mete", prop: "mete", align: "center", "min-width": "120", "show-overflow-tooltip": true, label: "核算量" }, { default: s(({ row: e }) => [r("span", { style: p({ color: e.color }) }, d(n(N)(e.mete)), 5)]), _: 1 }), n(h).productClassificationEnum === n(w).STEEL_PLATE_PRODUCT.V ? (D(), O(a, { key: "actualTheoryWeight", prop: "actualTheoryWeight", align: "center", "min-width": "120", "show-overflow-tooltip": true, label: "理论重量(kg)" }, { default: s(({ row: e }) => [r("span", { style: p({ color: e.color }) }, d(e.actualTheoryWeight == null ? "-" : n(N)(e.actualTheoryWeight)), 5)]), _: 1 })) : B("", true), l(a, { key: "time", prop: "time", align: "center", "min-width": "100", "show-overflow-tooltip": true, label: "出(退)库日期" }, { default: s(({ row: e }) => [r("span", { style: p({ color: e.color }) }, d(e.time ? n(ce)(e.time, "{y}-{m}-{d}") : ""), 5)]), _: 1 }), l(a, { key: "recipientName", prop: "recipientName", align: "center", "show-overflow-tooltip": true, label: "领用人" }, { default: s(({ row: e }) => [r("span", { style: p({ color: e.color }) }, d(e.recipientName), 5)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])], 512), [[W, !n(V)(n(h))]])])), [[f, v.value]]);
  };
} }, Te = ne(_e, [["__scopeId", "data-v-5af053f8"]]);
export {
  Te as default
};
