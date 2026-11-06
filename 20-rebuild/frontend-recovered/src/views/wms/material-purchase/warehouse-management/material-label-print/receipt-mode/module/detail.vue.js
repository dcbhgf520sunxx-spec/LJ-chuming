import { ref as m } from "vue";
import { computed as h } from "vue";
import { watch as E } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as y } from "vue";
import { createBlock as H } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as O } from "vue";
import { unref as n } from "vue";
import { createElementBlock as j } from "vue";
import { Fragment as P } from "vue";
import { renderList as M } from "vue";
import { createElementVNode as U } from "vue";
import { toDisplayString as q } from "vue";
import { ElOption as I } from "element-plus";
import { ElSelect as K } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { _ as F, jX as A, gt as G, o as Q, vx as v, cO as X, jl as J, cP as W, aR as Y, k4 as Z, jG as ee, jH as ae, k5 as te, k6 as se } from "../../../../../../../shared/runtime.js";
import { u as le } from "../../../../../../../modules/use-print-7c5ddea7.js";
import { _ as ne } from "../../../../../../../modules/material-print-button-3ec7d08d.js";
import "../../../../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../../../../modules/popover-confirm-35927771.js";
const ie = { __name: "detail", setup(oe) {
  const N = m(), f = m(), b = m([]), p = m([]), w = m([...A]), { print: C } = le(), { CRUD: x, crud: t, detail: o } = G(), { maxHeight: k } = Q({ mainBox: ".mat-label-print-receipt-mode-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => h(() => !t.detailLoading)), V = h(() => o && v.V[o.receiptType] ? `${v.V[o.receiptType].DOC}：${o.serialNumber}` : "");
  x.HOOK.beforeToDetail = () => {
    p.value = [];
  }, x.HOOK.beforeDetailLoaded = async (r, l) => {
    await X(l.materialList), l.materialList = await J(l.materialList, { toSmallest: false, toNum: false }), l.materialList.forEach((s) => {
      var d;
      if (s.projectShortName = (d = s.project) == null ? void 0 : d.shortName, s.basicClass === W.STEEL_COIL.V ? s.number = 1 : s.number = s.quantity, s.printedNumber = s.printedNumber || 0, s.printNumber = s.number - s.printedNumber, s.printNumber > 0) {
        const g = E(f, (c) => {
          c && setTimeout(() => {
            f.value.toggleRowSelection(s, true), g();
          }, 0);
        });
      } else s.printNumber = 1;
    });
  };
  function L(r) {
    r.printedNumber < r.number && (p.value = [], t.reloadDetail(), t.refresh());
  }
  async function D() {
    await C(p.value, t.props.copies), o.pendingPrintedMaterialNumber > 0 && t.refresh(), t.cancelDetail();
  }
  function R(r) {
    p.value = r;
  }
  return (r, l) => {
    const s = u("common-button"), d = I, g = K, c = z, S = u("table-cell-tag"), B = u("common-input-number"), $ = u("common-table"), T = u("common-drawer");
    return y(), H(T, { ref_key: "drawerRef", ref: N, "before-close": n(t).cancelDetail, "content-loading": n(t).detailLoading, "show-close": true, title: V.value, visible: n(t).detailVisible, "custom-class": "mat-label-print-receipt-mode-detail", size: "85%" }, { titleAfter: i(() => l[2] || (l[2] = [])), titleRight: i(() => [a(s, { class: "filter-item", icon: "el-icon-printer", size: "default", type: "success", onClick: D }, { default: i(() => l[3] || (l[3] = [O(" 批量打印 ")])), _: 1, __: [3] }), a(g, { modelValue: n(t).props.copies, "onUpdate:modelValue": l[0] || (l[0] = (e) => n(t).props.copies = e), class: "select-mini", placeholder: "可选择打印份数", size: "default", style: { width: "100px" } }, { default: i(() => [(y(), j(P, null, M(3, (e) => a(d, { key: `copies_${e}`, label: `打印${e}份`, value: e }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), content: i(() => [a($, { ref_key: "tableRef", ref: f, data: n(o).materialList, "data-format": w.value, "expand-row-keys": b.value, "max-height": n(k), "row-key": "id", "show-summary": "", onSelectionChange: R }, { default: i(() => [a(Y, { "expand-row-keys": b.value, "onUpdate:expandRowKeys": l[1] || (l[1] = (e) => b.value = e), data: n(o).materialList, fixed: "left", "row-key": "id" }, { default: i(({ row: e }) => [a(Z, { "basic-class": e.basicClass, row: e, "show-batch-no": false, "show-graphics": "" }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), a(c, { align: "center", fixed: "left", type: "selection", width: "55" }), a(c, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: i(({ row: e, $index: _ }) => [a(S, { show: e.printedNumber >= e.number, name: "已打印", type: "printed" }, null, 8, ["show"]), U("span", null, q(_ + 1), 1)]), _: 1 }), a(ee, { "basic-class": n(t).query.basicClass, "show-index": false, fixed: "left" }, null, 8, ["basic-class"]), a(ae, { "basic-class": n(t).query.basicClass }, null, 8, ["basic-class"]), a(te, { "basic-class": n(t).query.basicClass }, null, 8, ["basic-class"]), a(se), a(c, { key: "printNumber", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "批量打印数量", "min-width": "120", prop: "printNumber" }, { default: i(({ row: e }) => [a(B, { modelValue: e.printNumber, "onUpdate:modelValue": (_) => e.printNumber = _, max: 999, min: 1 }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(c, { align: "center", fixed: "right", label: "操作", width: "70px" }, { default: i(({ row: e }) => [a(ne, { copies: n(t) ? n(t).props.copies : 1, material: e, number: e.printNumber, "submit-print-record": "", onPrintedSuccess: (_) => L(e) }, null, 8, ["copies", "material", "number", "onPrintedSuccess"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, _e = F(ie, [["__scopeId", "data-v-ed9a4696"]]);
export {
  _e as default
};
