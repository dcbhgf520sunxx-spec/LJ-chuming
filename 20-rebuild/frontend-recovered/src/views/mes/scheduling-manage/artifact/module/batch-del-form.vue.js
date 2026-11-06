import { computed as R } from "vue";
import { ref as w } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as T } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as n } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as f } from "vue";
import { createTextVNode as z } from "vue";
import { unref as g } from "vue";
import { isRef as E } from "vue";
import { ElNotification as L } from "element-plus";
import { ElTag as U } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { w as I } from "../../../../../modules/artifact-f1b0ca44.js";
import { u as M, o as j } from "../../../../../shared/runtime.js";
const W = { __name: "batch-del-form", props: { visible: { type: Boolean, default: false }, selections: { type: Array, default: () => [] } }, emits: ["update:visible", "del-success"], setup(y, { emit: v }) {
  const _ = v, m = y, { visible: c, handleClose: b } = M({ emit: _, props: m, field: "visible", showHook: C }), { maxHeight: x } = j({ mainBox: ".artifact-scheduling-batch-del", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, c), V = R(() => {
    var e, i, r, a;
    const l = (e = m.selections) != null && e.length ? m.selections[0] : {};
    return `${(i = l.workshop) == null ? void 0 : i.name}>${(r = l.productionLine) == null ? void 0 : r.name}>${(a = l.groups) == null ? void 0 : a.name}`;
  }), h = w(false), u = w([]);
  function C() {
    u.value = m.selections.map((l) => ({ ...l, delQuantity: l.schedulingQuantity }));
  }
  const Q = (l) => {
    u.value = u.value.map((e) => (e.id === l.id && (e.delQuantity = l.delQuantity), e));
  };
  async function N(l, e) {
    try {
      h.value = true;
      const i = u.value.map((r) => ({ id: r.id, quantity: r.delQuantity }));
      await I(i), L({ title: "批量删除任务成功", type: "success", duration: 2500 }), _("del-success"), b();
    } catch (i) {
      console.log("删除任务失败", i);
    } finally {
      h.value = false;
    }
  }
  return (l, e) => {
    const i = U, r = p("common-button"), a = A, k = p("common-input-number"), B = p("common-table"), H = p("common-dialog");
    return T(), $(H, { title: "批量删除任务", customClass: "artifact-scheduling-batch-del", modelValue: g(c), "onUpdate:modelValue": e[0] || (e[0] = (t) => E(c) ? c.value = t : null), top: "10vh", width: "1100px", "before-close": g(b) }, { titleAfter: n(() => [o(i, { size: "default", effect: "plain" }, { default: n(() => [e[1] || (e[1] = d("span", null, "原产线：", -1)), d("span", null, f(V.value), 1)]), _: 1, __: [1] })]), titleRight: n(() => [o(r, { loading: h.value, type: "primary", size: "default", onClick: N }, { default: n(() => e[2] || (e[2] = [z("确 认")])), _: 1, __: [2] }, 8, ["loading"])]), default: n(() => [o(B, { data: u.value, "max-height": g(x), style: { width: "100%" } }, { default: n(() => [o(a, { label: "序号", type: "index", align: "center", width: "60" }), o(a, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "100", align: "center" }, { default: n(({ row: t }) => {
      var s;
      return [d("span", null, f((s = t.monomer) == null ? void 0 : s.name), 1)];
    }), _: 1 }), o(a, { prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100", align: "center" }, { default: n(({ row: t }) => {
      var s;
      return [d("span", null, f((s = t.area) == null ? void 0 : s.name), 1)];
    }), _: 1 }), o(a, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }, { default: n(({ row: t }) => [d("span", null, f(t.serialNumber), 1)]), _: 1 }), o(a, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), o(a, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), o(a, { prop: "delQuantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" }, { default: n(({ row: t }) => [o(k, { modelValue: t.delQuantity, "onUpdate:modelValue": (s) => t.delQuantity = s, step: 1, min: 1, max: t.schedulingQuantity, precision: 0, size: "default", "controls-position": "right", style: { width: "100%" }, onChange: (s) => Q(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), o(a, { prop: "schedulingTotalNetWeight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "90", align: "center" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  W as default
};
