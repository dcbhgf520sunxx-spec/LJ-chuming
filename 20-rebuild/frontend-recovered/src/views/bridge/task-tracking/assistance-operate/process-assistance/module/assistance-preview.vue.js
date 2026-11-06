import { ref as V } from "vue";
import { inject as L } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as r } from "vue";
import { createBlock as u } from "vue";
import { withCtx as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as o } from "vue";
import { createCommentVNode as m } from "vue";
import { createVNode as f } from "vue";
import { createElementVNode as T } from "vue";
import { isRef as j } from "vue";
import { ElNotification as O } from "element-plus";
import { ElTag as S } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { l as y, u as D, o as F, ce as d } from "../../../../../../shared/runtime.js";
function U(a) {
  return y({ module: "bridge", url: "assist/top_task_order/page", method: "get", params: a });
}
function K({ topTaskOrderId: a }) {
  return y({ module: "bridge", url: `assist/${a}/task_order/list`, method: "get" });
}
function Q(a) {
  return y({ module: "bridge", url: "assist/task_order/product/list", method: "get", params: a });
}
function W(a) {
  return y({ module: "bridge", url: "assist", method: "post", data: a });
}
function X(a) {
  return y({ module: "bridge", url: "assist", method: "delete", data: a });
}
const Y = { get: U }, $ = { __name: "assistance-preview", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} }, list: { type: Array, default: () => [] } }, emits: ["update:visible", "success"], setup(a, { emit: M }) {
  const v = M, x = a, { visible: b, handleClose: E } = D({ emit: v, props: x, field: "visible" }), { maxHeight: H } = F({ mainBox: ".assistance-preview", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, b), I = V([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), p = L("crud"), h = V(false);
  async function q() {
    try {
      h.value = true;
      const _ = x.list.map((c) => ({ id: c.id, groupsId: c.groupsId }));
      await W({ assistList: _ }), O({ title: "工序协同保存成功", type: "success", duration: 2500 }), E(), v("success");
    } catch (_) {
      console.log("保存工序协同报错", _);
    } finally {
      h.value = false;
    }
  }
  return (_, c) => {
    const A = S, R = w("common-button"), s = z, P = w("common-table"), B = w("common-dialog");
    return r(), u(B, { "custom-class": "assistance-preview", "append-to-body": "", "close-on-click-modal": false, title: "工序协同预览", modelValue: e(b), "onUpdate:modelValue": c[0] || (c[0] = (t) => j(b) ? b.value = t : null), width: "1100px", "before-close": e(E) }, { titleAfter: n(() => [e(p).query.taskTypeEnum !== e(d).MACHINE_PART.V ? (r(), u(A, { key: 0, effect: "plain" }, { default: n(() => {
      var t, l, i;
      return [k(" 原生产组：" + o((t = a.info.workshop) == null ? void 0 : t.name) + ">" + o((l = a.info.productionLine) == null ? void 0 : l.name) + ">" + o((i = a.info.groups) == null ? void 0 : i.name), 1)];
    }), _: 1 })) : m("", true)]), titleRight: n(() => [f(R, { onClick: q, loading: h.value, size: "default", type: "primary" }, { default: n(() => c[1] || (c[1] = [k("保存")])), _: 1, __: [1] }, 8, ["loading"])]), default: n(() => [f(P, { data: a.list, "data-format": I.value, "max-height": e(H), style: { width: "100%" } }, { default: n(() => [f(s, { label: "序号", type: "index", align: "center", width: "60" }), e(p).query.taskTypeEnum !== e(d).MACHINE_PART.V ? (r(), u(s, { key: 0, prop: "areaName", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" })) : m("", true), e(p).query.taskTypeEnum === e(d).CELL.V ? (r(), u(s, { key: 1, prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: n(({ row: t }) => [f(A, { type: t.attributeType === "单元件" ? "warning" : "success" }, { default: n(() => [k(o(t.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : m("", true), e(p).query.taskTypeEnum === e(d).MACHINE_PART.V ? (r(), u(s, { key: 2, prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100px", align: "center" })) : m("", true), e(p).query.taskTypeEnum !== e(d).MACHINE_PART.V ? (r(), u(s, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" })) : m("", true), f(s, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), e(p).query.taskTypeEnum !== e(d).MACHINE_PART.V ? (r(), u(s, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" })) : m("", true), f(s, { align: "center", prop: "totalTaskMete.quantity", "show-overflow-tooltip": true, label: "任务（件/kg）" }, { default: n(({ row: t }) => {
      var l, i;
      return [T("span", null, o(((l = t.totalTaskMete) == null ? void 0 : l.quantity) || 0) + "/" + o(((i = t.totalTaskMete) == null ? void 0 : i.netWeight) || 0), 1)];
    }), _: 1 }), e(p).query.taskTypeEnum === e(d).MACHINE_PART.V ? (r(), u(s, { key: 5, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : m("", true), e(p).query.taskTypeEnum === e(d).MACHINE_PART.V ? (r(), u(s, { key: 6, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "160px" }, { default: n(({ row: t }) => {
      var l, i, g;
      return [T("span", null, o((l = t.workshop) == null ? void 0 : l.name) + ">" + o((i = t.productionLine) == null ? void 0 : i.name) + ">" + o((g = t.groups) == null ? void 0 : g.name), 1)];
    }), _: 1 })) : m("", true), f(s, { prop: "groupsName", "show-overflow-tooltip": true, label: "协同生产组", "min-width": "150" }, { default: n(({ row: t }) => {
      var l, i, g, C, N;
      return [T("span", null, o((i = (l = t.assistance) == null ? void 0 : l.workshop) == null ? void 0 : i.name) + ">" + o((C = (g = t.assistance) == null ? void 0 : g.productionLine) == null ? void 0 : C.name) + ">" + o((N = t.assistance) == null ? void 0 : N.groupsName), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Z = Object.freeze(Object.defineProperty({ __proto__: null, default: $ }, Symbol.toStringTag, { value: "Module" }));
export {
  $ as _,
  X as a,
  Z as b,
  Y as c,
  Q as d,
  K as g
};
