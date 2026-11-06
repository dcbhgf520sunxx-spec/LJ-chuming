import { inject as h } from "vue";
import { computed as p } from "vue";
import { ref as m } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as z } from "vue";
import { createBlock as L } from "vue";
import { withCtx as o } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as O } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as i } from "vue";
import { unref as g } from "vue";
import { isRef as U } from "vue";
import { ElNotification as A } from "element-plus";
import { ElFormItem as F } from "element-plus";
import { ElCascader as P } from "element-plus";
import { ElInputNumber as D } from "element-plus";
import { ElForm as H } from "element-plus";
import { v as J } from "../../../../../modules/artifact-f1b0ca44.js";
import { u as K } from "../../../../../shared/runtime.js";
import { u as M } from "../../../../../modules/use-scheduling-line-f234c58c.js";
const $ = { __name: "edit-form", props: { visible: { type: Boolean, default: false }, itemInfo: { type: Object, default: () => {
} }, selections: { type: Array, default: () => [] }, structureClassId: { type: [Array, Number, String, void 0] }, artName: { type: [Array, String] } }, emits: ["update:visible", "refresh"], setup(w, { emit: x }) {
  const v = x, u = w, { visible: d, handleClose: b } = K({ emit: v, props: u, field: "visible", showHook: G }), N = h("areaIdObj"), C = h("productType"), S = p(() => ({ productType: C, structureClassId: u.structureClassId, artName: u.artName })), y = p(() => {
    var t, e;
    return [(e = N.value[(t = u.itemInfo.area) == null ? void 0 : t.id]) == null ? void 0 : e.factoryId];
  }), { groupsTree: k, groupsObj: Q } = M({ queryParams: S, factoryIds: y, disabledIds: p(() => {
    var t, e;
    return [(e = (t = u.itemInfo) == null ? void 0 : t.groups) == null ? void 0 : e.id];
  }) }), _ = m(), a = m({}), c = m(false), j = { curGroupsId: [{ required: true, message: "请选择现生产组", trigger: "change" }], needSchedulingQuantity: [{ required: true, message: "请选择现生产组", trigger: "change" }] };
  function G() {
    a.value = u.itemInfo;
  }
  async function T() {
    var e, n;
    let t = false;
    _.value.validate((l) => {
      t = l;
    });
    try {
      t && (c.value = true, await J([{ id: a.value.id, quantity: a.value.needSchedulingQuantity, productionLineId: a.value.curGroupsId, factoryId: y.value[0], workshopId: (n = (e = Q.value[a.value.curGroupsId]) == null ? void 0 : e.workshop) == null ? void 0 : n.id }]), b(), A({ title: "重新分配成功", type: "success", duration: 2500 }), v("refresh"));
    } catch (l) {
      console.log("重新分配", l);
    } finally {
      c.value = false;
    }
  }
  return (t, e) => {
    const n = V("common-button"), l = F, B = P, E = D, R = H, q = V("common-dialog");
    return z(), L(q, { title: "重新分配", modelValue: g(d), "onUpdate:modelValue": e[2] || (e[2] = (r) => U(d) ? d.value = r : null), width: "400px", "before-close": g(b) }, { titleRight: o(() => [s(n, { loading: c.value, type: "primary", size: "default", onClick: T }, { default: o(() => e[3] || (e[3] = [O("确认")])), _: 1, __: [3] }, 8, ["loading"])]), default: o(() => [s(R, { ref_key: "formRef", ref: _, model: a.value, rules: j, size: "default", "label-width": "90px" }, { default: o(() => [s(l, { label: "编号" }, { default: o(() => [f("span", null, i(a.value.serialNumber), 1)]), _: 1 }), s(l, { label: "规格" }, { default: o(() => [f("span", null, i(a.value.specification), 1)]), _: 1 }), s(l, { label: "原生产线" }, { default: o(() => {
      var r, I;
      return [f("span", null, i((r = a.value.workshop) == null ? void 0 : r.name) + ">" + i((I = a.value.productionLine) == null ? void 0 : I.name), 1)];
    }), _: 1 }), s(l, { label: "现生产线", prop: "curGroupsId" }, { default: o(() => [s(B, { modelValue: a.value.curGroupsId, "onUpdate:modelValue": e[0] || (e[0] = (r) => a.value.curGroupsId = r), options: g(k), "popper-class": "group-cascader", props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, filterable: "", clearable: "", style: { width: "200px" }, placeholder: "请选择现生产线" }, null, 8, ["modelValue", "options"])]), _: 1 }), s(l, { label: "分配数量", prop: "needSchedulingQuantity" }, { default: o(() => [s(E, { modelValue: a.value.needSchedulingQuantity, "onUpdate:modelValue": e[1] || (e[1] = (r) => a.value.needSchedulingQuantity = r), step: 1, min: 1, max: a.value.schedulingQuantity, precision: 0, size: "default", "controls-position": "right", style: { width: "200px" }, disabled: a.value.schedulingQuantity === 1 }, null, 8, ["modelValue", "max", "disabled"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  $ as default
};
