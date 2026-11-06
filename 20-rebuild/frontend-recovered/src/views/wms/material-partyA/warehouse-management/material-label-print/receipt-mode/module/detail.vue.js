import { ref as u } from "vue";
import { computed as y } from "vue";
import { watch as H } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as v } from "vue";
import { createBlock as O } from "vue";
import { withCtx as i } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as j } from "vue";
import { unref as n } from "vue";
import { createElementBlock as P } from "vue";
import { Fragment as M } from "vue";
import { renderList as U } from "vue";
import { createElementVNode as q } from "vue";
import { toDisplayString as I } from "vue";
import { ElOption as K } from "element-plus";
import { ElSelect as z } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { _ as A, jX as G, gt as Q, o as X, vx as N, cO as J, jl as W, cP as Y, aR as Z, k4 as ee, jG as te, jH as ae, k5 as se, k6 as le } from "../../../../../../../shared/runtime.js";
import { u as ne } from "../../../../../../../modules/use-print-4d7e67fe.js";
import { _ as ie } from "../../../../../../../modules/material-print-button-3ec7d08d.js";
import "../../../../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../../../../modules/popover-confirm-35927771.js";
const oe = { __name: "detail", setup(re) {
  const w = u(), b = u(), g = u([]), d = u([]), C = u([...G]), { print: k } = ne(), { CRUD: h, crud: t, detail: r } = Q(), { maxHeight: V } = X({ mainBox: ".mat-label-print-receipt-mode-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => y(() => !t.detailLoading)), L = y(() => r && N.V[r.receiptType] ? `${N.V[r.receiptType].DOC}：${r.serialNumber}` : "");
  h.HOOK.beforeToDetail = () => {
    d.value = [];
  }, h.HOOK.beforeDetailLoaded = async (c, l) => {
    await J(l.materialList), l.materialList = await W(l.materialList, { toSmallest: false, toNum: false }), l.materialList.forEach((a) => {
      var _;
      if (a.projectShortName = (_ = a.project) == null ? void 0 : _.shortName, a.basicClass === Y.STEEL_COIL.V ? a.number = 1 : a.number = a.quantity, a.printedNumber = a.printedNumber || 0, a.printNumber = a.number - a.printedNumber, a.printNumber > 0) {
        const x = H(b, (m) => {
          m && setTimeout(() => {
            b.value.toggleRowSelection(a, true), x();
          }, 0);
        });
      } else a.printNumber = 1;
    });
  };
  function D(c) {
    c.printedNumber < c.number && (d.value = [], t.reloadDetail(), t.refresh());
  }
  async function R() {
    await k(d.value, t.props.copies), r.pendingPrintedMaterialNumber > 0 && t.refresh(), t.cancelDetail();
  }
  function S(c) {
    d.value = c;
  }
  return (c, l) => {
    const a = p("common-button"), _ = K, x = z, m = F, B = p("table-cell-tag"), $ = p("common-input-number"), T = p("common-table"), E = p("common-drawer");
    return v(), O(E, { ref_key: "drawerRef", ref: w, "before-close": n(t).cancelDetail, "content-loading": n(t).detailLoading, "show-close": true, title: L.value, visible: n(t).detailVisible, "custom-class": "mat-label-print-receipt-mode-detail", size: "85%" }, { titleAfter: i(() => l[2] || (l[2] = [])), titleRight: i(() => [e(a, { class: "filter-item", icon: "el-icon-printer", size: "default", type: "success", onClick: R }, { default: i(() => l[3] || (l[3] = [j(" 批量打印 ")])), _: 1, __: [3] }), e(x, { modelValue: n(t).props.copies, "onUpdate:modelValue": l[0] || (l[0] = (o) => n(t).props.copies = o), class: "select-mini", placeholder: "可选择打印份数", size: "default", style: { width: "100px" } }, { default: i(() => [(v(), P(M, null, U(3, (o) => e(_, { key: `copies_${o}`, label: `打印${o}份`, value: o }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), content: i(() => {
      var o;
      return [e(T, { ref_key: "tableRef", ref: b, data: (o = n(r)) == null ? void 0 : o.materialList, "data-format": C.value, "expand-row-keys": g.value, "max-height": n(V), "row-key": "id", "show-summary": "", onSelectionChange: S }, { default: i(() => [e(Z, { "expand-row-keys": g.value, "onUpdate:expandRowKeys": l[1] || (l[1] = (s) => g.value = s), data: n(r).materialList, fixed: "left", "row-key": "id" }, { default: i(({ row: s }) => [e(ee, { "basic-class": s.basicClass, row: s, "show-batch-no": false, "show-graphics": "" }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), e(m, { align: "center", fixed: "left", type: "selection", width: "55" }), e(m, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: i(({ row: s, $index: f }) => [e(B, { show: s.printedNumber >= s.number, name: "已打印", type: "printed" }, null, 8, ["show"]), q("span", null, I(f + 1), 1)]), _: 1 }), e(te, { "basic-class": n(t).query.basicClass, "show-index": false, fixed: "left" }, null, 8, ["basic-class"]), e(ae, { "basic-class": n(t).query.basicClass }, null, 8, ["basic-class"]), e(se, { "basic-class": n(t).query.basicClass }, null, 8, ["basic-class"]), e(le), e(m, { key: "printNumber", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "批量打印数量", "min-width": "120", prop: "printNumber" }, { default: i(({ row: s }) => [e($, { modelValue: s.printNumber, "onUpdate:modelValue": (f) => s.printNumber = f, max: 999, min: 1 }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e(m, { align: "center", fixed: "right", label: "操作", width: "70px" }, { default: i(({ row: s }) => [e(ie, { copies: n(t) ? n(t).props.copies : 1, material: s, number: s.printNumber, "submit-print-record": "", onPrintedSuccess: (f) => D(s) }, null, 8, ["copies", "material", "number", "onPrintedSuccess"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])];
    }), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, fe = A(oe, [["__scopeId", "data-v-4ec27ed4"]]);
export {
  fe as default
};
