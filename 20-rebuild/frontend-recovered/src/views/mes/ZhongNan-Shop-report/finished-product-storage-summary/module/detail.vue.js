import { ref as v } from "vue";
import { inject as V } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as c } from "vue";
import { createBlock as p } from "vue";
import { withCtx as o } from "vue";
import { unref as d } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as F } from "vue";
import { withDirectives as j } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as a } from "vue";
import { isRef as B } from "vue";
import { ElTag as O } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { vLoading as R } from "element-plus";
import { u as q, o as I, p as E } from "../../../../../shared/runtime.js";
import { g as z } from "../../../../../modules/finished-product-storage-summary-8160e784.js";
const $ = { __name: "detail", props: { visible: { type: Boolean, default: false }, rowDetail: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(u, { emit: k }) {
  const M = k, w = u, m = v(false), b = v([]), f = V("query"), { visible: P, handleClose: x } = q({ emit: M, props: w, field: "visible", showHook: D }), { maxHeight: N } = I({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 });
  async function H() {
    var r, s, e;
    m.value = true;
    let n = [];
    try {
      const h = { workshopId: (r = w.rowDetail) == null ? void 0 : r.workshopId, structureType: (s = w.rowDetail) == null ? void 0 : s.structureType, yearMonth: f.yearMonth, workshopName: (e = w.rowDetail) == null ? void 0 : e.workshopName };
      n = await z(h);
    } catch (h) {
      console.log(h);
    } finally {
      b.value = n, m.value = false;
    }
  }
  function C({ columnIndex: n, row: r, column: s, rowIndex: e }) {
    if (r.projectName === "合计") {
      if (n === 0) return [1, 0];
      if (n === 1) return [1, 2];
    }
  }
  function D() {
    H();
  }
  return (n, r) => {
    const s = O, e = L, h = y("common-table"), g = y("common-drawer"), T = R;
    return c(), p(g, { ref: "drawerRef", title: `构件类别: ${u.rowDetail.structureType}`, modelValue: d(P), "onUpdate:modelValue": r[0] || (r[0] = (t) => B(P) ? P.value = t : null), direction: "rtl", "close-on-click-modal": false, "before-close": d(x), size: "100%" }, { titleAfter: o(() => [d(f).yearMonth ? (c(), p(s, { key: 0, type: "primary" }, { default: o(() => [_(l(d(E)(d(f).yearMonth, "{y}-{m}")), 1)]), _: 1 })) : F("", true), u.rowDetail.workshopName ? (c(), p(s, { key: 1, type: "primary" }, { default: o(() => [_(l(u.rowDetail.workshopName), 1)]), _: 1 })) : F("", true)]), content: o(() => [j((c(), p(h, { ref: "tableRef", data: b.value, "max-height": d(N), "span-method": C, style: { width: "100%" } }, { default: o(() => [i(e, { label: "序号", type: "index", align: "center", width: "60" }), i(e, { label: "工程项目", prop: "projectName", key: "projectName", align: "center", "min-width": "120" }, { default: o((t) => [a("span", null, l(t.row.projectName), 1)]), _: 1 }), i(e, { label: "期初累计情况", prop: "lineName", key: "lineName", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o(() => [i(e, { label: "已投料数量", prop: "beginPutPart", key: "beginPutPart", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o((t) => [a("div", null, l(t.row.beginPutPart ?? t.row.beginPutPart.toFixed(3)), 1)]), _: 1 }), i(e, { label: "已完工产量", prop: "beginFinishProduct", key: "beginFinishProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o((t) => [a("div", null, l(t.row.beginFinishProduct ?? t.row.beginFinishProduct.toFixed(3)), 1)]), _: 1 })]), _: 1 }), i(e, { label: "期初半成品", prop: "lineName", key: "lineName", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o(() => [i(e, { label: "半成品总吨位", prop: "beginHalfProduct", key: "beginHalfProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o((t) => [a("div", null, l(t.row.beginHalfProduct ?? t.row.beginHalfProduct.toFixed(3)), 1)]), _: 1 }), i(e, { label: "折合完工产量", prop: "beginConvertFinishProduct", key: "beginConvertFinishProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o((t) => [a("div", null, l(t.row.beginConvertFinishProduct ?? t.row.beginConvertFinishProduct.toFixed(3)), 1)]), _: 1 })]), _: 1 }), i(e, { label: "本月投料(T)", prop: "thisMonthPutPart", key: "thisMonthPutPart", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o((t) => [a("div", null, l(t.row.thisMonthPutPart ?? t.row.thisMonthPutPart.toFixed(3)), 1)]), _: 1 }), i(e, { label: "本月入库产量(T)", prop: "thisMonthFinishProduct", key: "thisMonthFinishProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o((t) => [a("div", null, l(t.row.thisMonthFinishProduct ?? t.row.thisMonthFinishProduct.toFixed(3)), 1)]), _: 1 }), i(e, { label: "期末半成品", prop: "lineName", key: "lineName", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o(() => [i(e, { label: "半成品总吨位", prop: "thisMonthHalfProduct", key: "thisMonthHalfProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o((t) => [a("div", null, l(t.row.thisMonthHalfProduct ?? t.row.thisMonthHalfProduct.toFixed(3)), 1)]), _: 1 }), i(e, { label: "折合完工产量", prop: "thisMonthConvertFinishProduct", key: "thisMonthConvertFinishProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o((t) => [a("div", null, l(t.row.thisMonthConvertFinishProduct ?? t.row.thisMonthConvertFinishProduct.toFixed(3)), 1)]), _: 1 })]), _: 1 }), i(e, { label: "累计情况", prop: "lineName", key: "lineName", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o(() => [i(e, { label: "已投料数量", prop: "totalPutPart", key: "totalPutPart", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o((t) => [a("div", null, l(t.row.totalPutPart ?? t.row.totalPutPart.toFixed(3)), 1)]), _: 1 }), i(e, { label: "已完工产量", prop: "totalFinishProduct", key: "totalFinishProduct", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o((t) => [a("div", null, l(t.row.totalFinishProduct ?? t.row.totalFinishProduct.toFixed(3)), 1)]), _: 1 })]), _: 1 }), i(e, { label: "本月完工产量", prop: "thisMonthFinishOutput", key: "thisMonthFinishOutput", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: o((t) => [a("div", null, l(t.row.thisMonthFinishOutput ?? t.row.thisMonthFinishOutput.toFixed(3)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[T, m.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  $ as default
};
