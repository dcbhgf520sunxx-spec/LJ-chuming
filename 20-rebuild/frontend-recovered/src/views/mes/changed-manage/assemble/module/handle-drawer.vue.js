import { ref as u } from "vue";
import { watch as U } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as c } from "vue";
import { createBlock as g } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as y } from "vue";
import { withDirectives as j } from "vue";
import { unref as x } from "vue";
import { createVNode as i } from "vue";
import { createElementBlock as Q } from "vue";
import { Fragment as S } from "vue";
import { createTextVNode as V } from "vue";
import { isRef as F } from "vue";
import { ElNotification as O } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { ElInputNumber as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { t as K } from "../../../../../modules/common-b3e76e54.js";
import { l as P, _ as W, u as X, o as Y, V as Z } from "../../../../../shared/runtime.js";
function ee(p) {
  return P({ module: "mes", url: "abnormal/assemble/task_change", method: "put", data: p });
}
const te = { class: "tip" }, ae = { key: 0 }, le = { key: 1 }, ne = { __name: "handle-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(p, { emit: q }) {
  const I = u(), C = u(), E = q, d = p, { visible: v, handleClose: L } = X({ emit: E, props: d, field: "visible" }), { maxHeight: H } = Y({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, C), b = u(false), w = u(false), _ = u(false), h = u([]), o = u();
  U(() => d.visible, (t) => {
    t ? (T(), o.value = d.info.canHandleTotalMete) : B();
  }, { immediate: true });
  function B() {
    h.value = [], o.value !== d.info.canHandleTotalMete && E("refresh");
  }
  async function T() {
    var a, n;
    let t = [];
    try {
      b.value = true;
      const { content: m } = await K({ productType: (a = d.info) == null ? void 0 : a.productType, productId: (n = d.info) == null ? void 0 : n.productId });
      t = m.map((s) => (s.submitLoading = false, s.isEdit = false, s));
    } catch (m) {
      console.log("获取处理列表失败", m);
    } finally {
      h.value = Z(t), b.value = false;
    }
  }
  function M(t) {
    t.isEdit = true, t.quantity = t.taskQuantity, _.value = true;
  }
  function N(t) {
    t.isEdit = false, _.value = false;
  }
  async function R(t) {
    try {
      w.value = true, await ee({ taskId: t.taskId, quantity: t.taskQuantity - t.quantity }), O({ title: "部件变更处理成功", type: "success", duration: 2500 }), t.isEdit = false, _.value = false, o.value = o.value - (t.taskQuantity - t.quantity), t.taskQuantity = t.quantity;
    } catch (a) {
      console.log("变更处理失败", a);
    } finally {
      w.value = false;
    }
  }
  return (t, a) => {
    const n = A, m = G, s = k("common-button"), z = k("common-table"), D = k("common-drawer"), $ = J;
    return c(), g(D, { ref_key: "drawerRef", ref: C, title: `${p.info.serialNumber}部件处理列表`, modelValue: x(v), "onUpdate:modelValue": a[0] || (a[0] = (e) => F(v) ? v.value = e : null), direction: "rtl", "before-close": x(L), size: "40%" }, { content: l(() => [f("div", te, [a[1] || (a[1] = f("span", null, "* 注意：", -1)), f("span", null, " 可修改的部件数量总和为" + y(o.value) + "，请谨慎操作！", 1)]), j((c(), g(z, { ref_key: "tableRef", ref: I, data: h.value, "max-height": x(H), style: { width: "100%" } }, { default: l(() => [i(n, { label: "序号", type: "index", align: "center", width: "60" }), i(n, { prop: "productionLine.name", "show-overflow-tooltip": true, label: "生产线", "min-width": "150px" }, { default: l((e) => {
      var r;
      return [f("span", null, y((r = e.row.productionLine) == null ? void 0 : r.name), 1)];
    }), _: 1 }), i(n, { prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务数", align: "center", "min-width": "150px" }, { default: l((e) => [e.row.isEdit ? (c(), Q("div", ae, [i(m, { class: "align-left", modelValue: e.row.quantity, "onUpdate:modelValue": (r) => e.row.quantity = r, placeholder: "请输入任务数", "controls-position": "right", style: { width: "100%" }, size: "default", min: e.row.taskQuantity - Math.min(o.value, e.row.taskQuantity - e.row.completeQuantity), max: e.row.taskQuantity }, null, 8, ["modelValue", "onUpdate:modelValue", "min", "max"])])) : (c(), Q("span", le, y(e.row.taskQuantity), 1))]), _: 1 }), i(n, { prop: "completeQuantity", "show-overflow-tooltip": true, label: "已生产", align: "center", width: "100px" }, { default: l((e) => [f("span", null, y(e.row.completeQuantity), 1)]), _: 1 }), i(n, { label: "操作", width: "170" }, { default: l((e) => [e.row.isEdit ? (c(), Q(S, { key: 0 }, [i(s, { loading: w.value, disabled: e.row.taskQuantity === e.row.quantity, size: "default", type: "success", onClick: (r) => R(e.row) }, { default: l(() => a[2] || (a[2] = [V(" 确认 ")])), _: 2, __: [2] }, 1032, ["loading", "disabled", "onClick"]), i(s, { size: "default", type: "warning", onClick: (r) => N(e.row) }, { default: l(() => a[3] || (a[3] = [V(" 取消 ")])), _: 2, __: [3] }, 1032, ["onClick"])], 64)) : (c(), g(s, { key: 1, type: "primary", size: "default", disabled: o.value <= 0 || e.row.taskQuantity - e.row.completeQuantity <= 0 || _.value, onClick: (r) => M(e.row) }, { default: l(() => a[4] || (a[4] = [V("修改")])), _: 2, __: [4] }, 1032, ["disabled", "onClick"]))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[$, b.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, re = W(ne, [["__scopeId", "data-v-84daeac4"]]);
export {
  re as default
};
