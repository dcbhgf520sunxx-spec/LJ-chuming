import { inject as k } from "vue";
import { computed as f } from "vue";
import { ref as b } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as L } from "vue";
import { createBlock as O } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as U } from "vue";
import { createElementVNode as g } from "vue";
import { toDisplayString as i } from "vue";
import { unref as v } from "vue";
import { isRef as F } from "vue";
import { ElNotification as P } from "element-plus";
import { ElFormItem as D } from "element-plus";
import { ElCascader as H } from "element-plus";
import { ElInputNumber as A } from "element-plus";
import { ElForm as J } from "element-plus";
import { j as K } from "../../../../../modules/box-3fab54f9.js";
import { u as M } from "../../../../../shared/runtime.js";
import { u as W } from "../../../../../modules/use-scheduling-groups-9f6c1fa1.js";
const ee = { __name: "edit-form", props: { visible: { type: Boolean, default: false }, itemInfo: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(G, { emit: j }) {
  const _ = j, n = G, { visible: c, handleClose: I } = M({ emit: _, props: n, field: "visible", showHook: E }), S = k("areaIdObj"), N = k("productType"), Q = f(() => ({ productType: N, boxClassId: n.itemInfo.boxClassId })), y = f(() => {
    var a, o;
    return [(o = S.value[(a = n.itemInfo.area) == null ? void 0 : a.id]) == null ? void 0 : o.factoryId];
  }), { groupsTree: T, groupsObj: h } = W({ queryParams: Q, factoryIds: y, disabledIds: f(() => {
    var a, o;
    return [(o = (a = n.itemInfo) == null ? void 0 : a.groups) == null ? void 0 : o.id];
  }) }), V = b(), e = b({}), m = b(false), B = { curGroupsId: [{ required: true, message: "请选择现生产组", trigger: "change" }], needSchedulingQuantity: [{ required: true, message: "请选择现生产组", trigger: "change" }] };
  function E() {
    e.value = n.itemInfo;
  }
  async function R() {
    var o, d, s, p;
    let a = false;
    V.value.validate((r) => {
      a = r;
    });
    try {
      a && (m.value = true, await K([{ id: e.value.id, quantity: e.value.needSchedulingQuantity, groupsId: e.value.curGroupsId, factoryId: y.value[0], productionLineId: (d = (o = h[e.value.curGroupsId]) == null ? void 0 : o.productionLine) == null ? void 0 : d.id, workshopId: (p = (s = h[e.value.curGroupsId]) == null ? void 0 : s.workshop) == null ? void 0 : p.id }]), I(), P({ title: "重新分配成功", type: "success", duration: 2500 }), _("refresh"));
    } catch (r) {
      console.log("重新分配", r);
    } finally {
      m.value = false;
    }
  }
  return (a, o) => {
    const d = C("common-button"), s = D, p = H, r = A, q = J, z = C("common-dialog");
    return L(), O(z, { title: "重新分配", modelValue: v(c), "onUpdate:modelValue": o[2] || (o[2] = (u) => F(c) ? c.value = u : null), width: "400px", "before-close": v(I) }, { titleRight: l(() => [t(d, { loading: m.value, type: "primary", size: "default", onClick: R }, { default: l(() => o[3] || (o[3] = [U("确认")])), _: 1, __: [3] }, 8, ["loading"])]), default: l(() => [t(q, { ref_key: "formRef", ref: V, model: e.value, rules: B, size: "default", "label-width": "90px" }, { default: l(() => [t(s, { label: "编号" }, { default: l(() => [g("span", null, i(e.value.serialNumber), 1)]), _: 1 }), t(s, { label: "规格" }, { default: l(() => [g("span", null, i(e.value.specification), 1)]), _: 1 }), t(s, { label: "原生产组" }, { default: l(() => {
      var u, x, w;
      return [g("span", null, i((u = e.value.workshop) == null ? void 0 : u.name) + ">" + i((x = e.value.productionLine) == null ? void 0 : x.name) + ">" + i((w = e.value.groups) == null ? void 0 : w.name), 1)];
    }), _: 1 }), t(s, { label: "现生产组", prop: "curGroupsId" }, { default: l(() => [t(p, { modelValue: e.value.curGroupsId, "onUpdate:modelValue": o[0] || (o[0] = (u) => e.value.curGroupsId = u), options: v(T), props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, filterable: "", clearable: "", style: { width: "200px" }, placeholder: "请选择现生产组" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(s, { label: "分配数量", prop: "needSchedulingQuantity" }, { default: l(() => [t(r, { modelValue: e.value.needSchedulingQuantity, "onUpdate:modelValue": o[1] || (o[1] = (u) => e.value.needSchedulingQuantity = u), step: 1, min: 1, max: e.value.schedulingQuantity, precision: 0, size: "default", "controls-position": "right", style: { width: "200px" } }, null, 8, ["modelValue", "max"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ee as default
};
