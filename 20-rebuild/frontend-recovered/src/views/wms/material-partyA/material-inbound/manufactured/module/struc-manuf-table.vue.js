import { ref as p } from "vue";
import { computed as O } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as b } from "vue";
import { createBlock as g } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as A } from "vue";
import { createVNode as l } from "vue";
import { unref as d } from "vue";
import { createElementVNode as N } from "vue";
import { mergeProps as E } from "vue";
import { watchEffect as M } from "vue";
import { watch as T } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElInput as W } from "element-plus";
import { tC as L, aR as Q, c9 as z, aw as K, i as h, iX as $ } from "../../../../../../shared/runtime.js";
const D = { class: "mtb-10" }, G = { __name: "struc-manuf-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false } }, setup(w, { expose: y }) {
  const r = w, i = p(), { form: o } = L(), c = p([]), _ = { quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: z, message: "数量必须大于0", trigger: "blur" }] }, x = O(() => Object.assign({}, _)), { tableValidate: v, wrongCellMask: k } = K({ rules: x });
  function V(e, a) {
    return !!e.canPurchaseQuantity || true;
  }
  function S(e, a) {
    const t = e.findIndex((n) => n.id === a.id) !== -1;
    o.selectObj[a.mergeId].isSelected = t;
  }
  function I(e) {
    const a = !!(e != null && e.length);
    o.strucManufList.forEach((t) => {
      o.selectObj[t.mergeId].isSelected = a;
    });
  }
  function C(e) {
    M(() => {
      var a, t;
      if (!r.boolPartyA && h((a = o.selectObj) == null ? void 0 : a[e.mergeId])) {
        const n = (t = o.selectObj[e.mergeId]) == null ? void 0 : t.isSelected;
        o.selectObj[e.mergeId] = { ...o.selectObj[e.mergeId], ...e, isSelected: n };
      }
    }), T([() => e.quantity, () => e.netWeight], () => P(e), { immediate: true });
  }
  function P(e) {
    h(e.netWeight) && e.quantity ? e.mete = $(e.netWeight * e.quantity) : e.mete = 0;
  }
  function R() {
    const e = o.strucManufList.filter((t) => {
      var n;
      return !!(r.boolPartyA || (n = o.selectObj[t.mergeId]) != null && n.isSelected);
    }), { validResult: a } = v(e);
    return a;
  }
  function j(e, a) {
    var t;
    (t = i == null ? void 0 : i.value) == null || t.toggleRowSelection(e, a);
  }
  return y({ validate: R, toggleRowSelection: j, rowWatch: C }), (e, a) => {
    const t = U, n = W, q = f("common-input-number"), B = f("common-table");
    return b(), g(B, E({ ref_key: "tableRef", ref: i }, e.$attrs, { data: d(o).strucManufList, "cell-class-name": d(k), "expand-row-keys": c.value, "show-empty-symbol": false, "return-source-data": "", "row-key": "uid", onSelect: S, onSelectAll: I }), { default: m(() => [r.boolPartyA ? A("", true) : (b(), g(t, { key: 0, type: "selection", width: "55", align: "center", selectable: V })), l(Q, { data: d(o).strucManufList, "expand-row-keys": c.value, "onUpdate:expandRowKeys": a[0] || (a[0] = (s) => c.value = s), "row-key": "uid", fixed: "left" }, { default: m(({ row: s }) => [N("div", D, [l(n, { modelValue: s.remark, "onUpdate:modelValue": (u) => s.remark = u, rows: 1, autosize: { minRows: 1, maxRows: 1 }, type: "textarea", placeholder: "备注", maxlength: "200", "show-word-limit": "", style: { width: "400px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["data", "expand-row-keys"]), l(t, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), l(t, { prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), l(t, { prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), l(t, { prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), l(t, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), l(t, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "140px" }), l(t, { prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": "" }), l(t, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }), l(t, { prop: "purchaseQuantity", label: "采购数量", align: "center", "show-overflow-tooltip": "" }), l(t, { prop: "quantity", label: "本次实收数", align: "center", "min-width": "120px" }, { default: m(({ row: s }) => [l(q, { modelValue: s.quantity, "onUpdate:modelValue": (u) => s.quantity = u, min: 0, max: s.canPurchaseQuantity, controls: false, step: 1, size: "default", placeholder: "本次实收数" }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), l(t, { prop: "mete", label: "实收量(kg)", align: "center", "min-width": "120px" })]), _: 1 }, 16, ["data", "cell-class-name", "expand-row-keys"]);
  };
} };
export {
  G as default
};
