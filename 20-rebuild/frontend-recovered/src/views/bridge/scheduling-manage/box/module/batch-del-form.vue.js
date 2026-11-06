import { computed as H } from "vue";
import { ref as w } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as R } from "vue";
import { createBlock as T } from "vue";
import { withCtx as a } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as p } from "vue";
import { createTextVNode as z } from "vue";
import { unref as g } from "vue";
import { isRef as E } from "vue";
import { ElNotification as L } from "element-plus";
import { ElTag as U } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { k as A } from "../../../../../modules/box-3fab54f9.js";
import { u as I, o as M } from "../../../../../shared/runtime.js";
const S = { __name: "batch-del-form", props: { visible: { type: Boolean, default: false }, selections: { type: Array, default: () => [] } }, emits: ["update:visible", "del-success"], setup(y, { emit: v }) {
  const _ = v, m = y, { visible: d, handleClose: b } = I({ emit: _, props: m, field: "visible", showHook: k }), { maxHeight: x } = M({ mainBox: ".box-scheduling-batch-del", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, d), V = H(() => {
    var l, i, s, t;
    const n = (l = m.selections) != null && l.length ? m.selections[0] : {};
    return `${(i = n.workshop) == null ? void 0 : i.name}>${(s = n.productionLine) == null ? void 0 : s.name}>${(t = n.groups) == null ? void 0 : t.name}`;
  }), f = w(false), h = w([]);
  function k() {
    h.value = m.selections.map((n) => ({ ...n, delQuantity: n.schedulingQuantity }));
  }
  async function Q(n, l) {
    try {
      f.value = true;
      const i = h.value.map((s) => ({ id: s.id, quantity: s.delQuantity }));
      await A(i), L({ title: "批量删除任务成功", type: "success", duration: 2500 }), _("del-success"), b();
    } catch (i) {
      console.log("删除任务失败", i);
    } finally {
      f.value = false;
    }
  }
  return (n, l) => {
    const i = U, s = c("common-button"), t = $, B = c("common-input-number"), C = c("common-table"), N = c("common-dialog");
    return R(), T(N, { title: "批量删除任务", customClass: "box-scheduling-batch-del", modelValue: g(d), "onUpdate:modelValue": l[0] || (l[0] = (o) => E(d) ? d.value = o : null), top: "10vh", width: "1100px", "before-close": g(b) }, { titleAfter: a(() => [e(i, { size: "default", effect: "plain" }, { default: a(() => [l[1] || (l[1] = u("span", null, "原产线：", -1)), u("span", null, p(V.value), 1)]), _: 1, __: [1] })]), titleRight: a(() => [e(s, { loading: f.value, type: "primary", size: "default", onClick: Q }, { default: a(() => l[2] || (l[2] = [z("确 认")])), _: 1, __: [2] }, 8, ["loading"])]), default: a(() => [e(C, { data: h.value, "max-height": g(x), style: { width: "100%" } }, { default: a(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "100", align: "center" }, { default: a(({ row: o }) => {
      var r;
      return [u("span", null, p((r = o.monomer) == null ? void 0 : r.name), 1)];
    }), _: 1 }), e(t, { prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100", align: "center" }, { default: a(({ row: o }) => {
      var r;
      return [u("span", null, p((r = o.area) == null ? void 0 : r.name), 1)];
    }), _: 1 }), e(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }, { default: a(({ row: o }) => [u("span", null, p(o.serialNumber), 1)]), _: 1 }), e(t, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), e(t, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), e(t, { prop: "delQuantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" }, { default: a(({ row: o }) => [e(B, { modelValue: o.delQuantity, "onUpdate:modelValue": (r) => o.delQuantity = r, step: 1, min: 1, max: o.schedulingQuantity, precision: 0, size: "default", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), e(t, { prop: "schedulingTotalNetWeight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "90", align: "center" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  S as default
};
