import { ref as c } from "vue";
import { computed as y } from "vue";
import { watch as E } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as h } from "vue";
import { createBlock as H } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as O } from "vue";
import { unref as n } from "vue";
import { createElementBlock as j } from "vue";
import { Fragment as M } from "vue";
import { renderList as P } from "vue";
import { createElementVNode as U } from "vue";
import { toDisplayString as q } from "vue";
import { ElOption as I } from "element-plus";
import { ElSelect as K } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { _ as F, jX as A, gt as G, o as Q, vx as w, cO as X, jl as J, am as W, aR as Y, k4 as Z, jG as ee, jH as ae, k5 as te, k6 as se } from "../../../../../shared/runtime.js";
import { u as le } from "../../../../../modules/use-print-d47bc68b.js";
import { _ as ne } from "../../../../../modules/material-print-button-3ec7d08d.js";
import "../../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../../modules/popover-confirm-35927771.js";
const ie = { __name: "detail", setup(oe) {
  const v = c(), _ = c(), f = c([]), u = c([]), C = c([...A]), { print: N } = le(), { CRUD: x, crud: t, detail: o } = G(), { maxHeight: k } = Q({ mainBox: ".mat-label-print-receipt-mode-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => y(() => !t.detailLoading)), V = y(() => o && w.V[o.receiptType] ? `${w.V[o.receiptType].DOC}：${o.serialNumber}` : "");
  x.HOOK.beforeToDetail = () => {
    u.value = [];
  }, x.HOOK.beforeDetailLoaded = async (r, l) => {
    await X(l.materialList), l.materialList = await J(l.materialList, { toSmallest: false, toNum: false }), l.materialList.forEach((s) => {
      if (s.basicClass === W.STEEL_COIL.V ? s.number = 1 : s.number = s.quantity, s.printedNumber = s.printedNumber || 0, s.printNumber = s.number - s.printedNumber, s.printNumber > 0) {
        const b = E(_, (g) => {
          g && setTimeout(() => {
            _.value.toggleRowSelection(s, true), b();
          }, 0);
        });
      } else s.printNumber = 1;
    });
  };
  function L(r) {
    r.printedNumber < r.number && (u.value = [], t.reloadDetail(), t.refresh());
  }
  async function D() {
    await N(u.value, t.props.copies), o.pendingPrintedMaterialNumber > 0 && t.refresh(), t.cancelDetail();
  }
  function R(r) {
    u.value = r;
  }
  return (r, l) => {
    const s = m("common-button"), b = I, g = K, d = z, B = m("table-cell-tag"), S = m("common-input-number"), $ = m("common-table"), T = m("common-drawer");
    return h(), H(T, { ref_key: "drawerRef", ref: v, visible: n(t).detailVisible, "content-loading": n(t).detailLoading, "before-close": n(t).cancelDetail, title: V.value, "show-close": true, size: "85%", "custom-class": "mat-label-print-receipt-mode-detail" }, { titleAfter: i(() => l[2] || (l[2] = [])), titleRight: i(() => [a(s, { class: "filter-item", type: "success", size: "default", icon: "el-icon-printer", onClick: D }, { default: i(() => l[3] || (l[3] = [O("批量打印")])), _: 1, __: [3] }), a(g, { class: "select-mini", modelValue: n(t).props.copies, "onUpdate:modelValue": l[0] || (l[0] = (e) => n(t).props.copies = e), placeholder: "可选择打印份数", size: "default", style: { width: "100px" } }, { default: i(() => [(h(), j(M, null, P(3, (e) => a(b, { key: `copies_${e}`, label: `打印${e}份`, value: e }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), content: i(() => [a($, { ref_key: "tableRef", ref: _, data: n(o).materialList, "data-format": C.value, "max-height": n(k), "show-summary": "", "expand-row-keys": f.value, onSelectionChange: R, "row-key": "id" }, { default: i(() => [a(Y, { data: n(o).materialList, "expand-row-keys": f.value, "onUpdate:expandRowKeys": l[1] || (l[1] = (e) => f.value = e), "row-key": "id", fixed: "left" }, { default: i(({ row: e }) => [a(Z, { "basic-class": e.basicClass, row: e, "show-graphics": "", "show-batch-no": false }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["data", "expand-row-keys"]), a(d, { type: "selection", width: "55", align: "center", fixed: "left" }), a(d, { label: "序号", type: "index", align: "center", width: "55", fixed: "left" }, { default: i(({ row: e, $index: p }) => [a(B, { show: e.printedNumber >= e.number, name: "已打印", type: "printed" }, null, 8, ["show"]), U("span", null, q(p + 1), 1)]), _: 1 }), a(ee, { "basic-class": n(t).query.basicClass, fixed: "left", "show-index": false }, null, 8, ["basic-class"]), a(ae, { "basic-class": n(t).query.basicClass }, null, 8, ["basic-class"]), a(te, { "basic-class": n(t).query.basicClass }, null, 8, ["basic-class"]), a(se), a(d, { key: "printNumber", "show-overflow-tooltip": true, prop: "printNumber", label: "批量打印数量", align: "center", fixed: "right", "min-width": "120" }, { default: i(({ row: e }) => [a(S, { modelValue: e.printNumber, "onUpdate:modelValue": (p) => e.printNumber = p, min: 1, max: 999 }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(d, { label: "操作", width: "70px", align: "center", fixed: "right" }, { default: i(({ row: e }) => [a(ne, { material: e, number: e.printNumber, copies: n(t) ? n(t).props.copies : 1, "submit-print-record": "", onPrintedSuccess: (p) => L(e) }, null, 8, ["material", "number", "copies", "onPrintedSuccess"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, _e = F(ie, [["__scopeId", "data-v-3d898107"]]);
export {
  _e as default
};
